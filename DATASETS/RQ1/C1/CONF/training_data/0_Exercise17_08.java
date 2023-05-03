import java.io.*;

public class Exercise17_08 {
    public static void main(String[] args) {
        try {
            // Open the file for reading
            FileInputStream countStream = new FileInputStream("Exercise17_08.dat");

            // Read the count from the file
            int count = countStream.read();

            // Close the file input stream
            countStream.close();

            // Increment the count
            count++;

            // Open the file for writing
            FileOutputStream updateStream = new FileOutputStream("Exercise17_08.dat");

            // Write the updated count to the file
            updateStream.write(count);

            // Close the file output stream
            updateStream.close();

            System.out.println("This program has been executed " + count + " times.");
        } catch (FileNotFoundException e) {
            // File doesn't exist yet, so start count at 1 and create file
            try {
                FileOutputStream createStream = new FileOutputStream("Exercise17_08.dat");
                createStream.write(1);
                createStream.close();
                System.out.println("This program has been executed 1 time.");
            } catch (IOException ex) {
                System.out.println("Error creating count file: " + ex.getMessage());
            }
        } catch (IOException e) {
            System.out.println("Error updating count file: " + e.getMessage());
        }
    }
}
