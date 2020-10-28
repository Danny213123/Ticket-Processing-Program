/** 
 * Reads input file
 *
 * @Readfile Class
 * @Author - Danny Guan
 * @Version - 1
 *
 */

import java.io.*;
import java.util.Scanner;

public class ReadFile {
    private int Inputs;
    private int Size;
    
    /** Readfile Constructor.
     *  
     * @Param int Inputs - total number of inputs per customer
     * @Param int Size - total number of customers
     * 
     */
    public ReadFile(int Inputs, int Size){
        this.Inputs = Inputs;
        this.Size = Size;
    }
    
    /**
    * Returns the number of inputs
    * @return number of inputs
    */
    public int GetInputs(){
        return this.Inputs;
    }
    
    /**
    * Returns the number of customers
    * @return the number of customers
    */
    public int GetSize(){
        return this.Size;
    }
    
    /**
	* Scans the file, customer index is row, customer order info is col
    * @return the correct inputs in a 2d array
	*/
    public String[][] ScanFile(){
        
        Scanner sc = new Scanner (System.in);
        
        String FileName = "Values.txt";
        String Line = "1"; 
        
        int times = 0;
        boolean Error = false;
        
        String[][] Results = new String[1][1];
        
        // Reads the file (values.txt) and stores the entries in an Array
        try{
            BufferedReader in = new BufferedReader(new FileReader(FileName));
                
            int CheckError = 0;

            Line = in.readLine();
            String CorrectLine = "";
                
            this.Size = Integer.parseInt(Line);
                
            Results = new String [this.Size][(this.Inputs)];
                
            // Reads the file and stores values in an array
            while (Line != null){
                for (int l = 0; l < this.Size; l++){
                    for (int q = 0; q < this.Inputs; q++){
                        Line = in.readLine();
                        if (Line == null){
                            in.close();
                            return Results;
                        }
                        if (q % 3 == 0){
                            // Trys to change input from string to int
                            try {
                                int Test = Integer.parseInt(Line);
                                int LineError = (l * this.Inputs) + 2;
                                System.out.println("Input error, wrong input type");
                                System.out.println("Input error on line: " + LineError + ", email expected, recieved: " + Line);
                                System.exit(0);

                            // Doesn't work means correct input recieved
                            } catch (NumberFormatException e){

                                // input length must be > 10 for a good email
                                if (Line.length() > 10){
                                    CorrectLine = Line;

                                // Blank spaces mean input error
                                } else if (Line.length() < 10){
                                    int LineError = (l * this.Inputs) + 2;
                                    System.out.println("Input error, input size");
                                    System.out.println("Input error on line: " + LineError + ", email expected, recieved: " + Line);
                                    System.exit(0);
                                }
                            }
                        }

                        // If the input's correct, the input will be passed through
                        CorrectLine = Line;
                        Results[l][q] = CorrectLine; 
                    }
                }
            }
            in.close();
            return Results;
        
        // Invalid entery
        } catch (IOException iox){
            System.out.println("Invalid entery");
        }
        return (Results);
    }
}
