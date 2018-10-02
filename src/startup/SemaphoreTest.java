package startup;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {
    static CountDownLatch c1 = new CountDownLatch(1);
    static CyclicBarrier c2 = new CyclicBarrier(10, ()->System.out.println("arrive barrier"));
    static Exchanger<String> ex = new Exchanger<>();
    static Semaphore sp = new Semaphore(10,true);
    public static void exchangerTest()
    {
        new Thread(()->{
            try {
                String s1 = "s1";
                System.out.println(Thread.currentThread().getName()+s1);
                String get = ex.exchange(s1);
                System.out.println(Thread.currentThread().getName() + " "+get);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                String s2 = "s2";
                System.out.println(Thread.currentThread().getName()+s2);
                String get = ex.exchange(s2);
                System.out.println(Thread.currentThread().getName() + " "+get);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }).start();
    }

    public static void main(String[] args) throws Exception
    {
        exchangerTest();

        Thread.sleep(1000);
        for(int i = 0;i< 100;i++)
        {
            Runnable r = ()->
            {
                try {
                    c2.await();
                    System.out.println(Thread.currentThread().getName() + " start");
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            };
            new Thread(r).start();
            Thread.sleep(1000);
        }
        System.out.println(Thread.currentThread().getName() + " start");

    }
}
