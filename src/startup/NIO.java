package startup;

import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIO {
    public static void main(String... args) throws Exception
    {
        mappedbuffer();
    }

    private static void mappedbuffer() throws Exception
    {
        Path p = Paths.get("C:\\software\\idea\\test.txt");
        FileChannel fc = FileChannel.open(p, StandardOpenOption.READ, StandardOpenOption.WRITE);
        MappedByteBuffer mbb = fc.map(FileChannel.MapMode.READ_WRITE, 0, 128*1024*1024);
        byte[] tmp = new byte[10];
        byte[] ib = "32".getBytes();
        mbb.get(tmp);
        mbb.rewind();
        mbb.put(ib);
        mbb.force();
        System.out.println(new String(tmp));
        Thread.sleep(100000);
    }

    private static void bytebuffer() throws Exception
    {
        Path p = Paths.get("C:\\software\\idea\\test.txt");
        FileChannel fc = FileChannel.open(p, StandardOpenOption.READ, StandardOpenOption.WRITE);
        ByteBuffer bb = ByteBuffer.allocateDirect(200);
        fc.read(bb);
    }
}
