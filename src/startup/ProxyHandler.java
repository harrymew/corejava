package startup;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler {
    private Object target;
    public ProxyHandler(Object t)
    {
        target = t;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{

        System.out.println(method.getName());
        return method.invoke(target, args);
    }
}
