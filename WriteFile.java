/** 
 * Writes to output file
 *
 * @WriteFile Class
 * @Author - Danny Guan
 * @Version - 7
 *
 */

import java.io.*;
import java.util.Scanner;

public class WriteFile {

    /** Outputs order requests
     *  
     * @Param CustomerInformation[] CustomerInfo - Information about the Customer's order
     * 
     */
    public void OutputFile(CustomerInformation[] CustomerInfo){
        try {

            File file = new File("Output.txt");

            FileWriter FileWrite = new FileWriter(file);

            PrintWriter output = new PrintWriter(FileWrite);

            int MaxStandardTickets = 30;

            int MaxVIPTickets = 10;

            // Scans through the customer info queue
            for (int x = 0; x < CustomerInfo.length; x++){

                int CustomerVIPTickets = CustomerInfo[x].GetVIPTickets();

                int CustomerTickets = CustomerInfo[x].GetTickets();

                output.println("<<EMAIL>>");

                // If there is enough standard and vip tickets left, order is fulfilled
                if (MaxVIPTickets - CustomerVIPTickets >= 0 & MaxStandardTickets - CustomerTickets >= 0){
                    output.println(CustomerInfo[x].GetEmail() + "\nYour ticket order of " + CustomerTickets + " standard tickets and " + CustomerVIPTickets + " VIP tickets has been fulfilled, send us your email and password\nwhich we will send them to our secure payment system to finish their transaction.");

                    MaxVIPTickets -= CustomerVIPTickets;

                    MaxStandardTickets -= CustomerTickets;

                // ticket order cannot be fulfilled
                } else {
                    output.println(CustomerInfo[x].GetEmail() + "\nYour ticket order of " + CustomerTickets + " standard tickets and " + CustomerVIPTickets + " VIP tickets has not been fulfilled");
                }

                output.println("<<END EMAIL>>");

                //output.println(MaxVIPTickets + " VIP tickets left and " + MaxStandardTickets + " MaxStandardTickets left.\n");
            }
            output.close();
        } catch (Exception e){
            System.out.println("Error");
        }
    }
}
