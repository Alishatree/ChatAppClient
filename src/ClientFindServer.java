import java.io.*;
import java.net.*;
import java.nio.Buffer;

public class ClientFindServer {

    public static void findServer() {
        String hostAddress = "IP Address";
        int port = 1234;

        try (Socket socket = new Socket(hostAddress, port)) {
            OutputStream output = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(output, true);

            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            writer.println("Send test");

            String response = reader.readLine();
            System.out.println(("Server: " + response));

            socket.close();;

        }
        //Error catching code
        catch (UnknownHostException ex) {
            println(ex.getMessage());
        }
        catch (IOException ex) {
            println(ex.getMessage());
        }

    }

}
