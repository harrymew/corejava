package jvm;

public class overloadTest {
    static abstract class human{

    }

    static class man extends human{

    }

    static class woman extends human{

    }

    public void sayHello(human a){
        System.out.println("hello human");
    }

    public void sayHello(man a){
        System.out.println("hello man");
    }

    public void sayhello(woman a){
        System.out.println("hello woman");
    }

    public static void main(String... args){
        man a = new man();
        human b = new woman();
        overloadTest ot = new overloadTest();
        ot.sayHello(a);
        ot.sayHello(b);
    }

}
