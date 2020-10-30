import java.io.*;
import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;

public class ErrorLog {
    public void OutputLog(String ErrorType, String Recieved, int LineError){
        try {
            File ErrorLog = new File("Log.txt");

            FileWriter FileWrite = new FileWriter(ErrorLog, true);

            PrintWriter PrintWrite = new PrintWriter(FileWrite);

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy);

            String formattedDate = sdf.format(date);

            PrintWrite.println(formattedDate);

            if (ErrorType.equals("No requests")){
            
                PrintWrite.println("    >No requests made.");
                
            } else if (ErrorType.equals("No inputs")){
            
                PrintWrite.println("    >No inputs made.");
                
            } else if (ErrorType.equals("Wrong Input type")){
            
                PrintWrite.println("    >Input error, wrong input type.");
                
                PrintWrite.println("    >Input error on line: " + LineError + ", email expected, recieved: " + Recieved + ".");
                
            } else if (ErrorType.equals("Wrong Input size")){
            
                PrintWrite.println("    >Input error, wrong input size.");
                
                PrintWrite.println("    >Input error on line: " + LineError + ", email expected, recieved: " + Recieved + ".");
                
            }

            PrintWrite.close();
        } catch (Exception e){

            System.out.println("hello");
        }
    }
}
