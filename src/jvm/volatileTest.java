package jvm;

import java.util.concurrent.atomic.AtomicInteger;
import java.lang.Thread.*;

public class volatileTest {
    public static AtomicInteger race = new AtomicInteger(0);
    public static void func(){
        //race ++ ;
        race.incrementAndGet();
    }
    public static void main(String ... args) throws Exception{
        Thread[] ta = new Thread[10];
        for(int i =0 ; i< 10; i++)
        {
            ta[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j=0; j<100;j++)
                        func();
                }
            });
            ta[i].start();
        }
        Thread.sleep(1000);
        System.out.println(race);
    }
}
