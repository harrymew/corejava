package startup;

public class JNITest {
    static {
        System.loadLibrary("helloworld");
    }
    public static void main(String... args)
    {
        HelloNative a = new HelloNative();
        a.hello();
    }
}
