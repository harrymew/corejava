package startup;

import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.SocketChannel;

public class SocketTest {
    public static void main(String... args) throws Exception
    {
        //getAddress();
        //createSocket();
        //createServer();
        channelsocket();
    }

    static public void createSocket() throws Exception
    {
        byte[] b = new byte[1024];
        try(Socket s = new Socket("baidu.com",80);InputStream is = s.getInputStream()){
            while(is.read(b)>0)
            {
                System.out.println(new String(b,"utf8"));
            }
        }
    }

    static public void getAddress() throws Exception
    {
        InetAddress ia = InetAddress.getLocalHost();
        System.out.println(ia.getHostAddress());

        InetAddress[] bia = InetAddress.getAllByName("localhost");
        for(InetAddress it:bia)
        {
            System.out.println(it);
        }
    }

    static public void createServer() throws Exception
    {
        ServerSocket server = new ServerSocket(10820);
        while (true)
        {
            Socket s = server.accept();
            Thread t = new Thread(new sockethandler(s));
            t.start();
        }
    }

    static public void channelsocket() throws Exception
    {
        InetSocketAddress ia = new InetSocketAddress("localhost",10888);
        if(ia.isUnresolved())
            return;
        SocketChannel sc = SocketChannel.open(ia);
        BufferedOutputStream bos = new BufferedOutputStream(Channels.newOutputStream(sc));
        bos.write("abc".getBytes());
        bos.flush();
    }
}

class sockethandler implements Runnable
{
    private Socket incoming;
    public sockethandler(Socket i)
    {
        incoming = i;
    }
    public void run()
    {
        try {
            InputStream is = incoming.getInputStream();
            byte[] buffer = new byte[1024];
            is.read(buffer);
            is.close();
            System.out.println(new String(buffer));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
