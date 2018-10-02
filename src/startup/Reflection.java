package startup;

import java.lang.invoke.MethodHandle;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Reflection {

    public static void getClassInfo(String classname)
    {
        try {
            Class cl = Class.forName(classname);
            System.out.println(Modifier.toString(cl.getModifiers()));
            System.out.println(cl.getName());
            Field[] clField = cl.getFields();
            for(Field cf : clField)
            {
                System.out.println(cf.getName());
                System.out.println(Modifier.toString(cf.getModifiers()));
            }

            Field[] dField = cl.getDeclaredFields();
            for(Field cf : dField)
            {
                System.out.println(cf.getName());
                System.out.println(Modifier.toString(cf.getModifiers()));
            }

            Method[] cMethods = cl.getDeclaredMethods();
            for(Method vm: cMethods)
            {
                System.out.println(vm.getName());
                Class[] clMethod = vm.getParameterTypes();
                for(Class vc: clMethod)
                    System.out.println(vc.getName());
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
