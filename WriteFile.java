/** 
 * Writes to output file
 *
 * @WriteFile Class
 * @Author - Danny Guan
 * @Version - 6
 *
 */

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class WriteFile {
    public void OutputFile(CustomerInformation[] CustomerInfo){
        try {
            File file = new File("Output.txt");
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);

            int MaxStandardTickets = 30;
            int MaxVIPTickets = 10;

            // Scans through the customer info queue
            for (int x = 0; x < CustomerInfo.length; x++){
                int CustomerVIPTickets = CustomerInfo[x].GetVIPTickets();
                int CustomerTickets = CustomerInfo[x].GetTickets();

                pw.println("<<EMAIL>>");

                // If there is enough standard and vip tickets left, order is fulfilled
                if (MaxVIPTickets - CustomerVIPTickets > 0 & MaxStandardTickets - CustomerTickets > 0){
                    pw.println(CustomerInfo[x].GetEmail() + "\nYour ticket order has been fulfilled, send us your email and password\nwhich we will send them to our secure payment system to finish their transaction.");
                    MaxVIPTickets -= CustomerVIPTickets;
                    MaxStandardTickets -= CustomerTickets;

                // ticket order cannot be fulfilled
                } else {
                    pw.println(CustomerInfo[x].GetEmail() + "\nYour ticket order has not been fulfilled");
                }

                pw.println("<<END EMAIL>>");

                //pw.println(MaxVIPTickets + " VIP tickets left and " + MaxStandardTickets + " MaxStandardTickets left.\n");
            }
            
            pw.close();
        } catch (Exception e){
            System.out.println("Error");
        }
    }

    /**
	* Randomly orders the array
	* @Param CustomerInformation[] Array - Customer index
	* @updates Customer 2d array with sorted indexes
	*/
    public CustomerInformation[] RandomizeOrder(CustomerInformation[] Array) {
      Random random = new Random();

        // Sorts Array
        for (int i = Array.length - 1; i > 0; i--) {
            int Index = random.nextInt(i + 1);

            CustomerInformation Switch = Array[i];
            Array[i] = Array[Index];
            Array[Index] = Switch;
        }
        return Array;
  }
}
