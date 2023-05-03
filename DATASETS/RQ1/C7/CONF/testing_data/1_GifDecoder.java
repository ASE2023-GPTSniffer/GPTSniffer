





public class GifDecoder {
    private static final String TAG = GifDecoder.class.getSimpleName();

    
    public static final int STATUS_OK = 0;
    
    public static final int STATUS_FORMAT_ERROR = 1;
    
    public static final int STATUS_OPEN_ERROR = 2;
    
    protected static final int MAX_STACK_SIZE = 4096;

    
    private static final int DISPOSAL_UNSPECIFIED = 0;
    
    private static final int DISPOSAL_NONE = 1;
    
    private static final int DISPOSAL_BACKGROUND = 2;
    
    private static final int DISPOSAL_PREVIOUS = 3;

    
    protected int status;

    
    protected int width; 
    protected int height; 
    protected boolean gctFlag; 
    protected int gctSize; 
    protected int loopCount = 1; 
    protected int[] gct; 
    protected int[] act; 
    protected int bgIndex; 
    protected int bgColor; 
    protected int pixelAspect; 
    protected boolean lctFlag; 
    protected int lctSize; 

    
    protected ByteBuffer rawData;

    
    protected byte[] block = new byte[256]; 
    protected int blockSize = 0; 

    
    protected short[] prefix;
    protected byte[] suffix;
    protected byte[] pixelStack;
    protected byte[] mainPixels;
    protected int[] mainScratch, copyScratch;

    protected ArrayList<GifFrame> frames; 
    protected GifFrame currentFrame;
    protected Bitmap previousImage, currentImage, renderImage;

    protected int framePointer;
    protected int frameCount;

    
    private static class GifFrame {
        public int ix, iy, iw, ih;
        
        public boolean interlace;
        public boolean transparency;
        
        public int dispose;
        
        public int transIndex;
        
        public int delay;
        
        public int bufferFrameStart;
        
        public int[] lct;
    }

    
    public void advance() {
        framePointer = (framePointer + 1) % frameCount;
    }

    
    public int getDelay(int n) {
        int delay = -1;
        if ((n >= 0) && (n < frameCount)) {
            delay = frames.get(n).delay;
        }
        return delay;
    }

    
    public int getNextDelay() {
        if (frameCount <=0 || framePointer < 0) {
            return -1;
        }

        return getDelay(framePointer);
    }

    
    public int getFrameCount() {
        return frameCount;
    }

    
    public int getCurrentFrameIndex() {
        return framePointer;
    }

    
    public int getLoopCount() {
        return loopCount;
    }

    
    public Bitmap getNextFrame() {
        if (frameCount <= 0 || framePointer < 0 || currentImage == null) {
            return null;
        }

        GifFrame frame = frames.get(framePointer);

        
        if (frame.lct == null) {
            act = gct;
        } else {
            act = frame.lct;
            if (bgIndex == frame.transIndex) {
                bgColor = 0;
            }
        }

        int save = 0;
        if (frame.transparency) {
            save = act[frame.transIndex];
            act[frame.transIndex] = 0; 
        }
        if (act == null) {
            Log.w(TAG, "No Valid Color Table");
            status = STATUS_FORMAT_ERROR; 
            return null;
        }

        setPixels(framePointer); 

        
        if (frame.transparency) {
            act[frame.transIndex] = save;
        }

        return currentImage;
    }

    
    public int read(InputStream is, int contentLength) {
        long startTime = System.currentTimeMillis();
        if (is != null) {
            try {
                int capacity = (contentLength > 0) ? (contentLength + 4096) : 4096;
                ByteArrayOutputStream buffer = new ByteArrayOutputStream(capacity);
                int nRead;
                byte[] data = new byte[16384];
                while ((nRead = is.read(data, 0, data.length)) != -1) {
                    buffer.write(data, 0, nRead);
                }
                buffer.flush();

                read(buffer.toByteArray());
            } catch (IOException e) {
                Log.w(TAG, "Error reading data from stream", e);
            }
        } else {
            status = STATUS_OPEN_ERROR;
        }

        try {
            is.close();
        } catch (Exception e) {
            Log.w(TAG, "Error closing stream", e);
        }

        return status;
    }

    
    public int read(byte[] data) {
        init();
        if (data != null) {
            
            rawData = ByteBuffer.wrap(data);
            rawData.rewind();
            rawData.order(ByteOrder.LITTLE_ENDIAN);

            readHeader();
            if (!err()) {
                readContents();
                if (frameCount < 0) {
                    status = STATUS_FORMAT_ERROR;
                }
            }
        } else {
            status = STATUS_OPEN_ERROR;
        }

        return status;
    }

    
    protected void setPixels(int frameIndex) {
        GifFrame currentFrame = frames.get(frameIndex);
        GifFrame previousFrame = null;
        int previousIndex = frameIndex - 1;
        if (previousIndex >= 0) {
            previousFrame = frames.get(previousIndex);
        }

        
        final int[] dest = mainScratch;

        
        if (previousFrame != null && previousFrame.dispose > DISPOSAL_UNSPECIFIED) {
            if (previousFrame.dispose == DISPOSAL_NONE && currentImage != null) {
                
                currentImage.getPixels(dest, 0, width, 0, 0, width, height);
            }
            if (previousFrame.dispose == DISPOSAL_BACKGROUND) {
                
                int c = 0;
                if (!currentFrame.transparency) {
                    c = bgColor;
                }
                for (int i = 0; i < previousFrame.ih; i++) {
                    int n1 = (previousFrame.iy + i) * width + previousFrame.ix;
                    int n2 = n1 + previousFrame.iw;
                    for (int k = n1; k < n2; k++) {
                        dest[k] = c;
                    }
                }
            }
            if (previousFrame.dispose == DISPOSAL_PREVIOUS && previousImage != null) {
                
                previousImage.getPixels(dest, 0, width, 0, 0, width, height);
            }
        }

        
        decodeBitmapData(currentFrame, mainPixels); 

        
        int pass = 1;
        int inc = 8;
        int iline = 0;
        for (int i = 0; i < currentFrame.ih; i++) {
            int line = i;
            if (currentFrame.interlace) {
                if (iline >= currentFrame.ih) {
                    pass++;
                    switch (pass) {
                        case 2:
                            iline = 4;
                            break;
                        case 3:
                            iline = 2;
                            inc = 4;
                            break;
                        case 4:
                            iline = 1;
                            inc = 2;
                            break;
                        default:
                            break;
                    }
                }
                line = iline;
                iline += inc;
            }
            line += currentFrame.iy;
            if (line < height) {
                int k = line * width;
                int dx = k + currentFrame.ix; 
                int dlim = dx + currentFrame.iw; 
                if ((k + width) < dlim) {
                    dlim = k + width; 
                }
                int sx = i * currentFrame.iw; 
                while (dx < dlim) {
                    
                    int index = ((int) mainPixels[sx++]) & 0xff;
                    int c = act[index];
                    if (c != 0) {
                        dest[dx] = c;
                    }
                    dx++;
                }
            }
        }

        
        currentImage.getPixels(copyScratch, 0, width, 0, 0, width, height);
        previousImage.setPixels(copyScratch, 0, width, 0, 0, width, height);
        
        currentImage.setPixels(dest, 0, width, 0, 0, width, height);
    }

    
    protected void decodeBitmapData(GifFrame frame, byte[] dstPixels) {
        long startTime = System.currentTimeMillis();
        long stepOne, stepTwo, stepThree;
        if (frame != null) {
            
            rawData.position(frame.bufferFrameStart);
        }

        int nullCode = -1;
        int npix = (frame == null) ? width * height : frame.iw * frame.ih;
        int available, clear, code_mask, code_size, end_of_information, in_code, old_code, bits, code, count, i, datum, data_size, first, top, bi, pi;

        if (dstPixels == null || dstPixels.length < npix) {
            dstPixels = new byte[npix]; 
        }
        if (prefix == null) {
            prefix = new short[MAX_STACK_SIZE];
        }
        if (suffix == null) {
            suffix = new byte[MAX_STACK_SIZE];
        }
        if (pixelStack == null) {
            pixelStack = new byte[MAX_STACK_SIZE + 1];
        }

        
        data_size = read();
        clear = 1 << data_size;
        end_of_information = clear + 1;
        available = clear + 2;
        old_code = nullCode;
        code_size = data_size + 1;
        code_mask = (1 << code_size) - 1;
        for (code = 0; code < clear; code++) {
            prefix[code] = 0; 
            suffix[code] = (byte) code;
        }

        
        datum = bits = count = first = top = pi = bi = 0;
        for (i = 0; i < npix; ) {
            if (top == 0) {
                if (bits < code_size) {
                    
                    if (count == 0) {
                        
                        count = readBlock();
                        if (count <= 0) {
                            break;
                        }
                        bi = 0;
                    }
                    datum += (((int) block[bi]) & 0xff) << bits;
                    bits += 8;
                    bi++;
                    count--;
                    continue;
                }
                
                code = datum & code_mask;
                datum >>= code_size;
                bits -= code_size;
                
                if ((code > available) || (code == end_of_information)) {
                    break;
                }
                if (code == clear) {
                    
                    code_size = data_size + 1;
                    code_mask = (1 << code_size) - 1;
                    available = clear + 2;
                    old_code = nullCode;
                    continue;
                }
                if (old_code == nullCode) {
                    pixelStack[top++] = suffix[code];
                    old_code = code;
                    first = code;
                    continue;
                }
                in_code = code;
                if (code == available) {
                    pixelStack[top++] = (byte) first;
                    code = old_code;
                }
                while (code > clear) {
                    pixelStack[top++] = suffix[code];
                    code = prefix[code];
                }
                first = ((int) suffix[code]) & 0xff;
                
                if (available >= MAX_STACK_SIZE) {
                    break;
                }
                pixelStack[top++] = (byte) first;
                prefix[available] = (short) old_code;
                suffix[available] = (byte) first;
                available++;
                if (((available & code_mask) == 0) && (available < MAX_STACK_SIZE)) {
                    code_size++;
                    code_mask += available;
                }
                old_code = in_code;
            }
            
            top--;
            dstPixels[pi++] = pixelStack[top];
            i++;
        }

        for (i = pi; i < npix; i++) {
            dstPixels[i] = 0; 
        }
    }

    
    protected boolean err() {
        return status != STATUS_OK;
    }

    
    protected void init() {
        status = STATUS_OK;
        frameCount = 0;
        framePointer = -1;
        frames = new ArrayList<GifFrame>();
        gct = null;
    }

    
    protected int read() {
        int curByte = 0;
        try {
            curByte = (rawData.get() & 0xFF);
        } catch (Exception e) {
            status = STATUS_FORMAT_ERROR;
        }
        return curByte;
    }

    
    protected int readBlock() {
        blockSize = read();
        int n = 0;
        if (blockSize > 0) {
            try {
                int count;
                while (n < blockSize) {
                    count = blockSize - n;
                    rawData.get(block, n, count);

                    n += count;
                }
            } catch (Exception e) {
                Log.w(TAG, "Error Reading Block", e);
                status = STATUS_FORMAT_ERROR;
            }
        }
        return n;
    }

    
    protected int[] readColorTable(int ncolors) {
        int nbytes = 3 * ncolors;
        int[] tab = null;
        byte[] c = new byte[nbytes];

        try {
            rawData.get(c);

            tab = new int[256]; 
            int i = 0;
            int j = 0;
            while (i < ncolors) {
                int r = ((int) c[j++]) & 0xff;
                int g = ((int) c[j++]) & 0xff;
                int b = ((int) c[j++]) & 0xff;
                tab[i++] = 0xff000000 | (r << 16) | (g << 8) | b;
            }
        } catch (BufferUnderflowException e) {
            Log.w(TAG, "Format Error Reading Color Table", e);
            status = STATUS_FORMAT_ERROR;
        }

        return tab;
    }

    
    protected void readContents() {
        
        boolean done = false;
        while (!(done || err())) {
            int code = read();
            switch (code) {
                case 0x2C: 
                    readBitmap();
                    break;
                case 0x21: 
                    code = read();
                    switch (code) {
                        case 0xf9: 
                            
                            currentFrame = new GifFrame();
                            readGraphicControlExt();
                            break;
                        case 0xff: 
                            readBlock();
                            String app = "";
                            for (int i = 0; i < 11; i++) {
                                app += (char) block[i];
                            }
                            if (app.equals("NETSCAPE2.0")) {
                                readNetscapeExt();
                            } else {
                                skip(); 
                            }
                            break;
                        case 0xfe:
                            skip();
                            break;
                        case 0x01:
                            skip();
                            break;
                        default: 
                            skip();
                    }
                    break;
                case 0x3b: 
                    done = true;
                    break;
                case 0x00: 
                default:
                    status = STATUS_FORMAT_ERROR;
            }
        }
    }

    
    protected void readHeader() {
        String id = "";
        for (int i = 0; i < 6; i++) {
            id += (char) read();
        }
        if (!id.startsWith("GIF")) {
            status = STATUS_FORMAT_ERROR;
            return;
        }
        readLSD();
        if (gctFlag && !err()) {
            gct = readColorTable(gctSize);
            bgColor = gct[bgIndex];
        }
    }

    
    protected void readGraphicControlExt() {
        read(); 
        int packed = read(); 
        currentFrame.dispose = (packed & 0x1c) >> 2; 
        if (currentFrame.dispose == 0) {
            currentFrame.dispose = 1; 
        }
        currentFrame.transparency = (packed & 1) != 0;
        currentFrame.delay = readShort() * 10; 
        currentFrame.transIndex = read(); 
        read(); 
    }

    
    protected void readBitmap() {
        currentFrame.ix = readShort(); 
        currentFrame.iy = readShort();
        currentFrame.iw = readShort();
        currentFrame.ih = readShort();

        int packed = read();
        lctFlag = (packed & 0x80) != 0; 
        lctSize = (int) Math.pow(2, (packed & 0x07) + 1);
        
        
        
        currentFrame.interlace = (packed & 0x40) != 0;
        if (lctFlag) {
            currentFrame.lct = readColorTable(lctSize); 
        } else {
            currentFrame.lct = null; 
        }

        currentFrame.bufferFrameStart = rawData.position(); 

        decodeBitmapData(null, mainPixels); 
        skip();
        if (err()) {
            return;
        }

        frameCount++;
        frames.add(currentFrame); 
    }

    
    protected void readLSD() {
        
        width = readShort();
        height = readShort();
        
        int packed = read();
        gctFlag = (packed & 0x80) != 0; 
        
        
        gctSize = 2 << (packed & 7); 
        bgIndex = read(); 
        pixelAspect = read(); 

        
        mainPixels = new byte[width * height];
        mainScratch = new int[width * height];
        copyScratch = new int[width * height];

        previousImage = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
        currentImage = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
    }

    
    protected void readNetscapeExt() {
        do {
            readBlock();
            if (block[0] == 1) {
                
                int b1 = ((int) block[1]) & 0xff;
                int b2 = ((int) block[2]) & 0xff;
                loopCount = (b2 << 8) | b1;
            }
        } while ((blockSize > 0) && !err());
    }

    
    protected int readShort() {
        
        return rawData.getShort();
    }

    
    protected void skip() {
        do {
            readBlock();
        } while ((blockSize > 0) && !err());
    }
}
