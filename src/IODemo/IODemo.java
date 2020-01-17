package IODemo;

import jdk.internal.util.xml.impl.Input;

import java.io.*;

public class IODemo {
    private static InputStream 获取一个输入流()throws IOException {
        InputStream is;


        //从文件中读
        /*is=new FileInputStream("2020-1-17.txt");

        */
        byte[]bytes=new byte[1024];
        is=new ByteArrayInputStream(bytes);
        return is;

    }
    private static String 获取一个输出流(InputStream is) throws IOException {
        //字节流
        /*
        byte []bytes=new byte[1024];
        int len=is.read(bytes);
        String message=new String (bytes,0,len);
        FileOutputStream os=new FileOutputStream("2020-1-17-输出.txt");
        os.write(bytes);
        return message;
        */
        //字节缓冲流
        /*
        Reader reader=new InputStreamReader(is);
        char[]chars=new char[1024];
        int len=reader.read(chars);
        String message=new String(chars,0,len);
        return message;
        */
        StringBuilder sb=new StringBuilder();
        Reader reader=new InputStreamReader(is);
        char[]chars=new char[10];
        int len;
        while((len=reader.read(chars))!=-1){
            sb.append(chars,0,len);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        InputStream is=获取一个输入流();
        String message=获取一个输出流(is);

        System.out.println(message);
    }
}
