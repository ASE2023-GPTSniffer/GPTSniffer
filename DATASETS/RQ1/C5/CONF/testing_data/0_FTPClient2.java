import java.io.*;
import java.net.Socket;

public class FTPClient {
    private static final String serverAddress = "ftp.example.com"; 
    private static final int serverPort = 21; 
    private static final String username = "yourusername"; 
    private static final String password = "yourpassword"; 

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket(serverAddress, serverPort);

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        String response = input.readLine();
        if (!response.startsWith("220 ")) {
            throw new Exception("FTP server not ready");
        }

        output.write("USER " + username + "\r\n");
        output.flush();
        response = input.readLine();
        if (!response.startsWith("331 ")) {
            throw new Exception("Wrong username or password");
        }

        output.write("PASS " + password + "\r\n");
        output.flush();
        response = input.readLine();
        if (!response.startsWith("230 ")) {
            throw new Exception("Wrong username or password");
        }

        output.write("PWD\r\n");
        output.flush();
        response = input.readLine();
        if (!response.startsWith("257 ")) {
            throw new Exception("Could not determine current directory");
        }
        String currentDirectory = response.substring(4, response.length() - 1);

        output.write("QUIT\r\n");
        output.flush();

        socket.close();

        System.out.println("Current directory: " + currentDirectory);
    }
}

