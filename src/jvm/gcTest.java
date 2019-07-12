package jvm;

public class gcTest {
    public static void main(String... args)
    {
        byte[] bi = new byte[1024*1024*64];
        System.gc();
    }

}
