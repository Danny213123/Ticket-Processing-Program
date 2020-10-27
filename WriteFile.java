import java.io.*;
import java.util.Scanner;

public class WriteFile {
    public void OutputFile(CustomerInformation[] CustomerInfo){
        try {
            File file = new File("Output.txt");
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);
            
            for (int x = 0; x < CustomerInfo.length; x++){
              String Email = CustomerInfo[x].GetEmail();
              int StandardTickets = CustomerInfo[x].GetTickets();
              int VIPTickets = CustomerInfo[x].GetVIPTickets();
              pw.println(Email + ". StandardTickets: " + StandardTickets + ". VIPTickets: " + VIPTickets + "\n");
            }
            
            pw.close();
        } catch (Exception e){
            System.out.println("l");
        }
    }
}
