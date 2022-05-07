import java.io.IOException;
import java.util.HashMap;
import java.net.*;
import java.io.*;


public class ServerName {
    private static HashMap<String, String> map = new HashMap<>();
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public HashMap<String, String> createData() {
        map.put("F1", "Machine1");
        map.put("F2", "Machine1");
        map.put("F3", "Machine2");
        map.put("F4", "Machine2");
        return map;
    }


    public String getKeyWord(ServerSocket serverSocket) throws IOException {
        Socket socket = serverSocket.accept();
        DataOutputStream dataOut = new DataOutputStream(socket.getOutputStream());
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String keyWord = (String) dis.readUTF();
        dataOut.flush();
        socket.close();
        return keyWord;
    }
    public String getMachineName(String keyWord){
        return map.get(keyWord);
    }

    public static void main(String[] args) throws IOException {
        ServerName serverName = new ServerName();
        serverName.createData();
        ServerSocket serverSocket = new ServerSocket(6666);
        try {
            while (true) {
                String result = serverName.getMachineName(serverName.getKeyWord(serverSocket));
                DataOutputStream dataOut = new DataOutputStream(serverSocket.accept().getOutputStream());
                dataOut.writeUTF(result);
                dataOut.flush();
                dataOut.close();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
