package startup;

import java.io.*;

import java.nio.charset.StandardCharsets;

public class IOTest {
    public static void main(String[] args) throws Exception
    {
        //objectIO();
        objectRead();
    }


    public static void  dataIO() throws Exception
    {
        String dir = System.getProperty("user.dir") + File.separator+"test.txt";
        System.out.println(dir);
        DataInputStream din = new DataInputStream( new BufferedInputStream(new FileInputStream(dir)));
        byte[] b = new byte[100];
        System.out.println(din.read(b));
        System.out.println(new String(b, "GBK"));
        din.close();

        FileOutputStream fout;
        DataOutputStream dot = new DataOutputStream(fout = new FileOutputStream(dir, true));
        dot.write("你1好".getBytes("GBK"));
        dot.close();
    }


    public static void textIO() throws Exception
    {
        String dir = System.getProperty("user.dir") + File.separator+"test.txt";
        System.out.println(dir);
        try(BufferedReader bin = new BufferedReader(new InputStreamReader(new FileInputStream(dir), "GBK")))
        {
            System.out.println(bin.readLine());
        }
    }

    public static void randomAccessFile() throws Exception
    {
        RandomAccessFile rf = new RandomAccessFile("ra.txt", "rw");
        Long len = rf.length();
        rf.seek(10);
        rf.writeChars("111111111111111111111111111");
        rf.close();
    }

    public static void objectIO() throws Exception
    {
        Employee sec = new Employee("harry", 100);
        Manager  m1 = new Manager("tom", 200, 50);
        Manager m2 = new Manager("fan", 300, 50);
        m1.setSecratary(sec);
        m2.setSecratary(sec);

        Employee em[] = new Employee[19];
        em[0] = sec;
        em[1] = m1;
        em[2] = m2;
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("em.txt"));
        oos.writeObject(em);
    }

    public static void objectRead() throws Exception
    {
        Employee em[] ;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("em.txt"));
        em = (Employee[]) ois.readObject();
        System.out.println(em[1].getName());
    }
}
