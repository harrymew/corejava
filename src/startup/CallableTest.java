package startup;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args)
    {
        Callable<Integer> compute = () ->{
                Thread.sleep(1000);
                return 5;
        };


        FutureTask<Integer> task = new FutureTask<>(compute);
        Thread t = new Thread(task);
        t.start();
        task.cancel(true);
        try {
            System.out.println(task.get());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
