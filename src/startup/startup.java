package startup;

import org.omg.Messaging.SYNC_WITH_TRANSPORT;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;


/**
 * @author mahui
 */

public class startup {

    public static int id  = 1;
    private int nextid;

    private int getid()
    {
        return nextid;
    }
    private startup()
    {
        nextid = id;
    }

    public static void main (String[] args)
    {
        Manager mg = new Manager("frank",1000,100);
        Employee[] em = new Employee[3];
        em[0] = mg;
        em[1] = new Employee("frank", 1000);
        em[2] = new Employee("tom", 500);

        Employee a = new Employee("tom", 500);

        StaticInner s = new StaticInner();
        System.out.println(s.outerfun().getFd());

        Pair<String, Integer> m = new Pair<>("tom", 20);
        Pair<String, Integer>[] x = (Pair<String, Integer>[]) new Pair<?,?>[10];

        Arrays.asList();
    }
}