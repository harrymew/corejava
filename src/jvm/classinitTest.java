package jvm;

public class classinitTest {
    public static void main(String... args)
    {
        //subclass sb = new subclass();
        //System.out.println(subclass.value);
        //superclass[] sp = new superclass [10];
        //System.out.println(subclass.st);

        //clinit dead loop
        System.out.println(Thread.currentThread().getName() + "start");
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "start");
                deadloop dl = new deadloop();
                System.out.println(Thread.currentThread().getName() + "finished");
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);
        t1.start();
        t2.start();
    }
}

class superclass
{
    static {
        System.out.println("hello from super");
    }
    public final static int value = 2;
    public static final String st = "hello world";
}

class subclass extends superclass
{
    static {
        System.out.println("hello from sub");
    }
}


class deadloop
{
    static {
        if(true) {
            System.out.println(Thread.currentThread().getName() + "init deadloop");
            while (true) {

            }
        }
    }
}