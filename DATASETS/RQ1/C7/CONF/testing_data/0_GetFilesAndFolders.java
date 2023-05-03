
public class GetAllFilesAndFolders {
    public static void main(String[] args) {
        String directoryPath = "C:/example/directory";
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("The directory does not exist.");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("The path specified is not a directory.");
            return;
        }

        getAllFilesAndFolders(directory);
    }

    public static void getAllFilesAndFolders(File directory) {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                System.out.println("Folder: " + file.getAbsolutePath());
                getAllFilesAndFolders(file);
            } else {
                System.out.println("File: " + file.getAbsolutePath());
            }
        }
    }
}

