import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class WriteFile {
    public void OutputFile(CustomerInformation[] CustomerInfo){
        try {
            File file = new File("Output.txt");
            FileWriter fw = new FileWriter(file);
            PrintWriter pw = new PrintWriter(fw);
            
            for (int x = 0; x < CustomerInfo.length; x++){
              pw.println(CustomerInfo[x].GetEmail() + ". StandardTickets: " + CustomerInfo[x].GetTickets() + ". VIPTickets: " + CustomerInfo[x].GetVIPTickets() + "\n");
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
