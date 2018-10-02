package startup;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.*;

public class ProxyTest {

    public static void main(String[] args)
    {
        Object[] elements = new Object[5];
        for(int i =0; i<5; i++) {
            Integer value = i;
            InvocationHandler ih = new ProxyHandler(value);
            Object proxy = Proxy.newProxyInstance(null, new Class[]{java.lang.Comparable.class}, ih);
            elements[i] = proxy;
        }
        Arrays.sort(elements);
    }
}
