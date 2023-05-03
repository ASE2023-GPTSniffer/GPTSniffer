



public class FileFindExample {

    private static DateTimeFormatter DATE_FORMATTER
            = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public static void main(String[] args) throws IOException {

        Path path = Paths.get("C:\\test\\");
        List<Path> result = findByFileName(path, "google.png");
        result.forEach(x -> System.out.println(x));

        

        
        

    }

    public static List<Path> findByFileName(Path path, String fileName)
            throws IOException {

        List<Path> result;
        try (Stream<Path> pathStream = Files.find(path,
                Integer.MAX_VALUE,
                (p, basicFileAttributes) ->
                        p.getFileName().toString().equalsIgnoreCase(fileName))
        ) {
            result = pathStream.collect(Collectors.toList());
        }
        return result;

    }

    public static List<Path> findByFileName2(Path path, String fileName)
            throws IOException {

        List<Path> result;
        try (Stream<Path> pathStream = Files.find(path,
                Integer.MAX_VALUE,
                (p, basicFileAttributes) -> {
                    
                    if (Files.isDirectory(p) || !Files.isReadable(p)) {
                        return false;
                    }
                    return p.getFileName().toString().equalsIgnoreCase(fileName);
                })
        ) {
            result = pathStream.collect(Collectors.toList());
        }
        return result;

    }

    public static List<Path> findByFileSize(Path path, long fileSize)
            throws IOException {

        List<Path> result;
        try (Stream<Path> pathStream = Files.find(path,
                Integer.MAX_VALUE,
                (p, basicFileAttributes) -> {
                    try {
                        if (Files.isDirectory(p)) {   
                            return false;
                        }
                        return Files.size(p) >= fileSize;
                    } catch (IOException e) {
                        System.err.println("Unable to get the file size of path : " + path);
                    }
                    return false;
                }

        )) {
            result = pathStream.collect(Collectors.toList());
        }
        return result;

    }

    public static List<Path> findByLastModifiedTime(Path path, Instant instant)
            throws IOException {

        List<Path> result;
        try (Stream<Path> pathStream = Files.find(path,
                Integer.MAX_VALUE,
                (p, basicFileAttributes) -> {

                    if (Files.isDirectory(p) || !Files.isReadable(p)) {
                        return false;
                    }

                    FileTime fileTime = basicFileAttributes.lastModifiedTime();
                    
                    
                    
                    int i = fileTime.toInstant().compareTo(instant);
                    return i > 0;
                }

        )) {
            result = pathStream.collect(Collectors.toList());
        }
        return result;

    }

}
