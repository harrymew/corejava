package startup;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.stream.Stream;

public class FileTest {
    public static void main(String... args) throws Exception
    {
        Path p1 = Paths.get("C:\\software\\idea");
        Path p2 = p1.resolve("test.txt");
        String str1 = "你好abc123\r\n";
        String str2 = "xxx12你还会\r\n";
        Files.write(p2, str1.getBytes());
        Files.write(p2, str2.getBytes(), StandardOpenOption.APPEND);

        OutputStream os = Files.newOutputStream(p2, StandardOpenOption.APPEND);
        os.write("xxx".getBytes());
        List<String> lines = Files.readAllLines(p2);
        //lines.forEach(p->System.out.println(p));

        InputStream is = Files.newInputStream(p2);


        Path tmp = Files.createTempFile("startup", ".txt");
        System.out.println(tmp.toString());

        dirsearch();
    }

    private static void dirsearch() throws Exception
    {
        Stream<Path> entries = Files.list(Paths.get("C:\\software\\idea"));

        //entries =  Files.walk(Paths.get("C:\\software\\idea"));
        //entries.forEach(p -> System.out.println(p.toString()));

        Files.walkFileTree(Paths.get("C:\\software\\idea"), new SimpleFileVisitor<Path>()
        {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                System.out.println("xx " + file.toString());
                return super.visitFile(file, attrs);
            }
        });
    }

}
