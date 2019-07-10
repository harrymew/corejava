package startup;

import java.lang.annotation.Annotation;

public class AnnotationsTest {

    public static void main(String... args)
    {
        processAnnotation();
    }

    public static void processAnnotation()
    {
        innerclass ins = new innerclass();
        Class<?> cl = ins.getClass();
        Annotation[] a = cl.getDeclaredAnnotations();
        for(Annotation i : a)
        {
            mew tx = (mew)i;
            System.out.println(tx.maxsize());
        }
    }
}
@mew
class innerclass{

}
