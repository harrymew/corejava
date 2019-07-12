package startup;

public class StringTest {
    public static void main(String... args)
    {
        String  s1 = new StringBuilder("java").append("mh").toString(); // s1= s1-ref
        String  s2 = s1.intern(); // pool -> s1-ref
        String  s3= new StringBuilder("ja").append("va").toString(); // s3 = s3-ref
        String  s4 = s3.intern(); // pool -> s1-ref                     s4 = java-ref

        System.out.println(s1==s2);
        System.out.println(s3==s4);
    }
}
