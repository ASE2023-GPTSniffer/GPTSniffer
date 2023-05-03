
public class RenameFiles {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java RenameFiles directory");
            System.exit(1);
        }

        File directory = new File(args[0]);
        if (!directory.isDirectory()) {
            System.out.println(args[0] + " is not a directory");
            System.exit(1);
        }

        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isFile() && file.getName().matches("Exercise\\d_\\d\\.txt")) {
                String filename = file.getName();
                String[] parts = filename.split("_");
                String newFilename = parts[0] + "_" + String.format("%02d", Integer.parseInt(parts[1].split("\\.")[0])) + ".txt";
                File newFile = new File(directory, newFilename);
                if (file.renameTo(newFile)) {
                    System.out.println("Renamed " + filename + " to " + newFilename);
                } else {
                    System.err.println("Error renaming " + filename);
                }
            }
        }
    }
}
