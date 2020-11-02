/** 
 * Read, organize and output customer orders
 *
 * Main Class
 * @Author - Danny Guan
 * @Version - 6
 *
 */

import java.io.*;
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int Inputs = 3;

        ReadFile Scan = new ReadFile(Inputs, 1);
        
        // Reads input file (Values.txt)
        String[][] StringArray = Scan.ScanFile();

        Lottery CustomerLottery = new Lottery();
        
        CustomerInformation[] Customers = new CustomerInformation[StringArray.length];
        
        // Creates User objects with correct info
        for (int y = 0; y < Customers.length; y ++){
            Customers[y] = new CustomerInformation(Integer.parseInt(StringArray[y][1]),Integer.parseInt(StringArray[y][2]), StringArray[y][0]);
        }
        
        Customers = CustomerLottery.RandomizeOrder(Customers);

        // Outputs file to Output.txt
        WriteFile Output = new WriteFile();
        Output.OutputFile(Customers);

        // Prints out user information
        for (int x = 0; x < Customers.length; x ++){
          System.out.println(Customers[x].toString() + "\n");
        }
        
    }
}
