
public class Main {
    public static void main(String[] args) {
        
        String zipFile = "file.zip";

        try (ZipFile zf = new ZipFile(zipFile)) {
            
            for (Enumeration<? extends ZipEntry> entries = zf.entries(); entries.hasMoreElements();) {
                
                String entryName = entries.nextElement().getName();
                System.out.println("File: " + entryName);

                
                InputStream in = zf.getInputStream(new ZipEntry(entryName));
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
