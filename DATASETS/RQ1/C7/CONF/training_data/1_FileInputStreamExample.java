


public class FileInputStreamExample {

    public static void main(String[] args) {
        String file = "c:\\test\\file.txt";
        String fileUnicode = "c:\\test\\file-unicode.txt";

        readFile(file);
        
        

    }

    private static void readFile(String fileName) {

        try (FileInputStream fis = new FileInputStream(new File(fileName))) {

            
            System.out.println("Remaining bytes that can be read : " + fis.available());

            int content;
            
            while ((content = fis.read()) != -1) {
                System.out.println((char) content);

                System.out.println("Remaining bytes that can be read : " + fis.available());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void readFileBetterPerformance(String fileName) {

        try (FileInputStream fis = new FileInputStream(new File(fileName))) {

            
            System.out.println("Remaining bytes that can be read : " + fis.available());

            
            byte[] bytes = new byte[8192];

            
            while (fis.read(bytes) != -1) {

                
                
                System.out.println(new String(bytes, StandardCharsets.UTF_8));

                System.out.println("Remaining bytes that can be read : " + fis.available());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void readFileBetterPerformance2(String fileName) {

        try (BufferedInputStream bis =
                     new BufferedInputStream(
                             new FileInputStream(new File(fileName)))) {

            
            System.out.println("Remaining bytes that can be read : " + bis.available());

            int content;
            
            
            while ((content = bis.read()) != -1) {

                
                System.out.println((char) content);

                System.out.println("Remaining bytes that can be read : " + bis.available());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void readFileBetterInputStreamReader(String fileName) {

        try (BufferedReader br =
                     new BufferedReader(
                             new InputStreamReader(
                                     new FileInputStream(new File(fileName))))) {

            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
