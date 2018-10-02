package startup;

import java.nio.channels.FileChannel;

public class Manager extends Employee{

    private double bonus;
    private Employee secratary = null;

    public Manager( String xname, double xsalary, double xbonus)
    {
        super(xname, xsalary);
        bonus = xbonus;
    }

    public void setSecratary(Employee sec)
    {
        this.secratary = sec;
    }
    public void setBonus(double xbonus)
    {
        bonus = xbonus;
    }

    public double getSalary()
    {
        return bonus+super.getSalary();
    }

    public void triple (Integer x)
    {
        x = 3*x;
    }
}
