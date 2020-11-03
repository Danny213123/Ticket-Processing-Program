/** Outputs program errors
 *
 * ErrorLog class
 * @author Danny Guan
 * @version 2
 */

import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ErrorLog {
    public void OutputLog(String errorType, String received, int lineError){
        try {
            // Prints out errors in log.txt
            File errorLog = new File("ErrorLog.txt");

            FileWriter fileWrite = new FileWriter(errorLog, true);

            PrintWriter printWrite = new PrintWriter(fileWrite);

            // Date of when the error was logged
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

            String formattedDate = sdf.format(date);

            printWrite.println(formattedDate);

            // No requests made
            if (errorType.equals("No requests")){

                printWrite.println(">No requests made.");

            // No inputs made
            } else if (errorType.equals("No inputs")){

                printWrite.println(">No inputs made.");

            // Wrong input type
            } else if (errorType.equals("Wrong Input type")){

                printWrite.println(">Input error, wrong input type.");

                printWrite.println(">Input error on line: " + lineError + ", email expected, received: " + received + ".");

            // Wrong input size
            } else if (errorType.equals("Wrong Input size")){

                printWrite.println(">Input error, wrong input size.");

                printWrite.println(">Input error on line: " + lineError + ", email expected, received: " + received + ".");
            }

            printWrite.close();

        } catch (Exception e){

            System.out.println("error");
        }
    }
}
