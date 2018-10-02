package startup;

import java.io.Serializable;
import java.util.EnumMap;
import java.util.Objects;
import java.util.function.*;
/**
 * @author mahui
 * @version 1.7
 */
public  class Employee implements Comparable<Employee>, Serializable {
    static int nextid=0;
    private int id;
    private String name;
    private double salary;
    private Profession prof;


    public innerClass inn;

    public Employee(String xname, double xsalary)
    {
        id = ++nextid;
        name = xname;
        salary = xsalary;
        prof = Profession.Worker;

        inn = new innerClass(25);
    }

    public static int getid()
    {
        return nextid;
    }

    public String getName()
    {
        return name;
    }

    public double getSalary()
    {
        return salary;
    }

    @Override
    public boolean equals(Object otherObject)
    {
        if(otherObject == null)
            return false;
        if(otherObject == this)
            return true;
        if (! (otherObject instanceof Employee))
            return false;

        return id==((Employee) otherObject).getid()
                && Objects.equals(name, ((Employee) otherObject).getName())
                && Objects.equals(salary, ((Employee) otherObject).getSalary());
    }

    public int compareTo(Employee obj)
    {
        return 1;
    }

    public class innerClass implements Serializable
    {
        int iid;
        innerClass(int xid)
        {
            iid = xid;

        }
        public int getId()
        {
            return Employee.this.nextid;
        }
    }

}
