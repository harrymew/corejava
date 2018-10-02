package startup;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public  class ForkJoinTest extends RecursiveTask<Integer> {
    private  static Integer[] arr;
    private int threshold = 100;
    private int start;
    private int end;

    ForkJoinTest(int start, int end)
    {
        this.start = start;
        this.end = end;
        compute();
    }
    protected Integer compute()
    {
        Integer result = 0;
        if (end - start < threshold)
            for(int i= start; i<end; i++)
                result+=arr[i];
        else
        {
            int mid = (end-start)/2;
            ForkJoinTest p1 = new ForkJoinTest(start, mid);
            ForkJoinTest p2 = new ForkJoinTest(mid, end);
            invokeAll(p1, p2);
            result = p1.join()+ p2.join();
        }
        return result;
    }

    public static void main(String args[])
    {
        arr = new Integer[100];
        for(int i=0;i<100; i++)
            arr[i] = i+1;

        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTest fj = new ForkJoinTest(0,100);
        ForkJoinTask<Integer> result = pool.submit(fj);
        try {
            System.out.println(result.get());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
