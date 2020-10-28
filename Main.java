import java.io.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        ReadFile Scan = new ReadFile(3, 1);
        
        String[][] StringArray = Scan.ScanFile();
        
        for (int x = 0; x < StringArray.length; x++){
            for (int q = 0; q < StringArray[0].length; q++){
                System.out.println(StringArray[x][q]);
            }
        }
        
        CustomerInformation[] Customers = new CustomerInformation[StringArray.length];
        
        for (int y = 0; y < Customers.length; y ++){
            Customers[y] = new CustomerInformation(Integer.parseInt(StringArray[y][1]), Integer.parseInt(StringArray[y][2]), StringArray[y][0]);
        }
        
        WriteFile Output = new WriteFile();
        Output.RandomizeOrder(Customers);
        Output.OutputFile(Customers);
        
    }
}
