package startup;

import java.io.*;
import java.util.Properties;
import java.util.Scanner;
import java.util.prefs.BackingStoreException;
import java.util.prefs.NodeChangeListener;
import java.util.prefs.PreferenceChangeListener;
import java.util.prefs.Preferences;

public class FileResourceTest {
    public static void main(String[] args)
    {
        Employee obj = new Employee("abb", 123);
        BufferedInputStream io = new BufferedInputStream(Employee.class.getResourceAsStream("readme.txt"));
        try {
            Scanner sc = new Scanner(io);
            String a = sc.next();
            System.out.println(a);

            Properties settings = new Properties();
            settings.setProperty("name", "mahui");
            settings.store(new FileOutputStream("test.txt"), "");


            Preferences pf = Preferences.systemRoot();

            Preferences node = pf.node("");

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }


    }
}
