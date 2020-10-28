import java.io.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        ReadFile Scan = new ReadFile(3, 1);
        
        String[][] StringArray = Scan.ScanFile();
        
        CustomerInformation[] Customers = new CustomerInformation[StringArray.length];
        
        for (int y = 0; y < Customers.length; y ++){
            Customers[y] = new CustomerInformation(Integer.parseInt(StringArray[y][1]), Integer.parseInt(StringArray[y][2]), StringArray[y][0]);
        }
        
        WriteFile Output = new WriteFile();
        Customers = Output.RandomizeOrder(Customers);
        Output.OutputFile(Customers);

        for (int x = 0; x < Customers.length; x ++){
          System.out.println(Customers[x].toString());
        }
        
    }
}
