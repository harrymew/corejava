package startup;

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThread {
    private static final int banksize = 10;
    private static double account[] = new double[banksize];
    private static double allMoney = 10000D;
    private static Lock banklock = new ReentrantLock();
    private static Condition sufficientCond = banklock.newCondition();
    public static void main(String[] args)
    {
        Arrays.fill(account, allMoney/banksize);
        for(int i=0;i<10;i++)
        {
            Runnable r = ()->
            {
                    while (true) {
                        int from = (int) (banksize * Math.random());
                        int to = (int) (banksize * Math.random());
                        double money = allMoney * Math.random();
                        banklock.lock();
                        try {
                            account[from] -= money;
                            account[to] += money;
                            double sum = 0;
                            for (double v : account)
                                sum += v;
                            System.out.println(Thread.currentThread().getName() + " all " + sum);
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                        finally {
                            banklock.unlock();
                        }
                        try {
                            Thread.sleep((long) (1000*Math.random()));
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }

            };
            Thread t = new Thread(r);
            t.start();
        }

    }


}
