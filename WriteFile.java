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

            for (int x = 0; x < CustomerInfo.length; x++){
                int CustomerVIPTickets = CustomerInfo[x].GetVIPTickets();
                int CustomerTickets = CustomerInfo[x].GetTickets();

                if (MaxVIPTickets - CustomerVIPTickets > 0 & MaxStandardTickets - CustomerTickets > 0){
                  pw.println(CustomerInfo[x].GetEmail() + "\nYour ticket order has been fulfilled, send us your email and password\n which we will send them to our secure payment system to finish their transaction.\n");
                  MaxVIPTickets -= CustomerVIPTickets;
                  MaxStandardTickets -= CustomerTickets;
                } else {
                     pw.println(CustomerInfo[x].GetEmail() + "\nYour ticket order has not been fulfilled\n");
                }

                System.out.println(MaxStandardTickets + " VIP tickets left and " + MaxStandardTickets + " MaxStandardTickets left.\n");
            }
            
            pw.close();
        } catch (Exception e){
            System.out.println("l");
        }
    }

    public CustomerInformation[] RandomizeOrder(CustomerInformation[] Array) {
      Random random = new Random();

      for (int i = Array.length - 1; i > 0; i--) {
          int Index = random.nextInt(i + 1);

          CustomerInformation Switch = Array[i];
          Array[i] = Array[Index];
          Array[Index] = Switch;
      }
      return Array;
  }
}
