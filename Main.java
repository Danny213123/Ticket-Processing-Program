/** 
 * Read, organize and output customer orders
 *
 * @Main Class
 * @Author - Danny Guan
 * @Version - 1
 *
 */

import java.io.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        ReadFile Scan = new ReadFile(3, 1);
        
        // Reads input file (Values.txt)
        String[][] StringArray = Scan.ScanFile();
        
        CustomerInformation[] Customers = new CustomerInformation[StringArray.length];
        
        // Creates User objects with correct info
        for (int y = 0; y < Customers.length; y ++){
            Customers[y] = new CustomerInformation(Integer.parseInt(StringArray[y][1]), Integer.parseInt(StringArray[y][2]), StringArray[y][0]);
        }
        
        // Outputs file to Output.txt
        WriteFile Output = new WriteFile();
        Customers = Output.RandomizeOrder(Customers);
        Output.OutputFile(Customers);

        // Prints out user information
        for (int x = 0; x < Customers.length; x ++){
          System.out.println(Customers[x].toString() + "\n");
        }
        
    }
}
