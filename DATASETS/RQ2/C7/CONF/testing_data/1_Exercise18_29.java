



public class FileCount {

    public static void main(String[] args) {
        System.out.print("Enter a directory: ");
        Scanner input = new Scanner(System.in);
        String directory = input.nextLine().trim();
        File file = new File(directory);
        if (file.isDirectory()) {
            System.out.println("The directory: " + file.getName() + " contains " + getFileCount(file) +
                    " files.");
        } else {
            System.out.println("Please ensue you are entering a directory.");
        }
    }

    public static long getFileCount(File file) {
        long TOTAL_FILES = 0;
        File[] files = file.listFiles();
        if (files != null && files.length > 0) {
            for (File f : files) {
                if (f.isFile()) {
                    TOTAL_FILES += 1;
                }

            }
        }
        return TOTAL_FILES;
    }
}
