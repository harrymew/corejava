package jvm;

import java.util.List;

public class overrideTest {
    static abstract class sup{
        abstract void sayHello();
    }

    static class subA extends sup{
        public void sayHello()
        {
            System.out.println("hello subA");
        }
    }

    static class subB extends sup{
        public void sayHello()
        {
            System.out.println("hello subB");
        }
    }

    public static void main(String... args)
    {
//        sup o1 = new subA();
//        sup o2 = new subB();
//        o1.sayHello();
//        o2.sayHello();
//        o1 = new subB();
//        o1.sayHello();
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        System.out.println(a+b == c);

    }

}
