package TCP;

import jdk.internal.util.xml.impl.Input;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket=new ServerSocket(8080);
        while(true){
            Socket socket=serverSocket.accept();
            InputStream is=socket.getInputStream();
            OutputStream os=socket.getOutputStream();

            Reader reader=new InputStreamReader(is,"utf-8");
            BufferedReader bf=new BufferedReader(reader);

            Writer writer=new OutputStreamWriter(os,"UTF-8");
            PrintWriter pw=new PrintWriter(writer,false);

            String message;
            while((message=bf.readLine())!=null){
                System.out.println(message);
                pw.println(message);
                pw.flush();
            }

        }
    }
}
