package startup;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.concurrent.Callable;

public class CompilerTest {
    public static void main(String... args)
    {
        EasyWay();
    }

    public static int EasyWay()
    {
        JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
        int res = jc.run(null, null, null, "-sourcepath","src", "startup.java");
        return res;
    }

    public static void CompliationTask()
    {
        JavaCompiler jc = ToolProvider.getSystemJavaCompiler();
        StandardJavaFileManager sjf =  jc.getStandardFileManager(null, null, null);
        System.gc();
    }
}
