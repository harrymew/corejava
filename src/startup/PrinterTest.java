package startup;

import javax.print.DocFlavor;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.attribute.PrintRequestAttributeSet;

public class PrinterTest {
    public static void main(String[] args)
    {
        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
        DocFlavor flavor = DocFlavor.BYTE_ARRAY.PNG;
        //可用的打印机列表(字符串数组)
        PrintService printService[] = PrintServiceLookup.lookupPrintServices(flavor, pras);
        String[] Printers = new String[10];
        System.out.println(printService.length);
        for(int i=0;i<printService.length;i++)
            Printers[i]=printService[i].getName();

        PrintService PS = PrintServiceLookup.lookupDefaultPrintService();
        System.out.println(PS.getName());
}}
