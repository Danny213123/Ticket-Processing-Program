/** 
 * Writes email text to Output.txt file
 *
 * WriteFile Class
 * @author Danny Guan
 * @version 7
 */

import java.io.*;

public class WriteFile {

    /** Outputs order requests
     *  
     * @param customerInfo - Information about the Customer's order
     */
    public void OutputFile(CustomerInformation[] customerInfo){
        try {

            File file = new File("Output.txt");

            FileWriter fileWrite = new FileWriter(file);

            PrintWriter output = new PrintWriter(fileWrite);

            int availableStandardTickets = 30;

            int availableVIPTickets = 10;

            // Scans through the customer info queue
            for (int x = 0; x < customerInfo.length; x++){

                int customerVIPTickets = customerInfo[x].GetVIPTickets();

                int customerStandardTickets = customerInfo[x].GetTickets();

                output.println("<<EMAIL>>");

                // If there is enough standard and vip tickets left, order is fulfilled
                if (availableVIPTickets - customerVIPTickets >= 0 & availableStandardTickets - customerStandardTickets >= 0){
                    output.println(customerInfo[x].GetEmail() + "\nYour ticket order of " + customerStandardTickets + " standard ticket(s) and " + customerVIPTickets + " VIP ticket(s) has been fulfilled... \nEnter your email and password and you will be sent to our secure payment system to finish your transaction.");

                    availableVIPTickets -= customerVIPTickets;

                    availableStandardTickets -= customerStandardTickets;

                // ticket order cannot be fulfilled
                } else {
                    output.println(customerInfo[x].GetEmail() + "\nSorry, your ticket order of " + customerStandardTickets + " standard ticket(s) and " + customerVIPTickets + " VIP ticket(s) could not been fulfilled");
                }

                output.println("<<END EMAIL>>");
            }
            output.close();
        } catch (Exception e){
            System.out.println("Error");
        }
    }
}
