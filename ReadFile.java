/**Reads input file
 *
 * ReadFile Class
 * @author Danny Guan
 * @version 9
 */

import java.io.*;

public class ReadFile {
    private int inputs;
    private int size;
    
    /** ReadFile Constructor.
     *  
     * @param inputs - total number of ticket inputs per customer
     * @param size - total number of customers
     */
    public ReadFile(int inputs, int size){
        this.inputs = inputs;
        this.size = size;
    }
    
    /** Returns the number of customer inputs
     *
     * @return number of inputs
     */
    public int GetInputs(){
        return this.inputs;
    }

    /** Returns the number of customers
     *
     * @return number of customers
     */
    public int GetSize(){
        return this.size;
    }

    /** Sets a new number of customer inputs
     *
     * @param inputs - sets new number of inputs
     */
    public void SetInputs(int inputs){
        this.inputs = inputs;
    }

    /** Sets a new number of customers
     *
     * @param size - sets new number of customers
     */
    public void SetSize(int size){
        this.size = size;
    }
    
    /** Scans the file, customer index is row, customer order info is col
     *
     * @return the correct inputs in a 2d array
	 */
    public String[][] ScanFile(){
        String line;

        ErrorLog log = new ErrorLog();

        String[][] results = new String[1][1];
        
        // Reads the file (values.txt) and stores the entries in an Array
        try{

            BufferedReader in = new BufferedReader(new FileReader("Values.txt"));

            line = in.readLine();

            String correctLine;
            
            try {
                this.size = Integer.parseInt(line);
		   
                if (this.size == 0){
                   System.out.println("There are no ticket requests");

                   log.OutputLog("No Requests", "", 1);

                   System.exit(0);
                }
            } catch (NumberFormatException e) {
                System.out.println("Input error, no inputs");

                System.out.println("Input error on line 1, integer expected, received: " + line);

                log.OutputLog("No inputs", line, 1);

                System.exit(0);
            }

             results = new String [this.size][(this.inputs)];
                
            // Reads the file and stores values in an array
            while (line != null){

                for (int l = 0; l < this.size; l++){

                    for (int q = 0; q < this.inputs; q++){

                        line = in.readLine();

                        if (line == null){
                            in.close();
                            return results;
                        }

                        if (q % 3 == 0){

                            // Try's to change input from string to int
                            try {
                                int test = Integer.parseInt(line);
                                int lineError = (l * this.inputs) + 2;

                                System.out.println("Input error, wrong input type");

                                System.out.println("Input error on line: " + lineError + ", email expected, received: " + line);

                                log.OutputLog("Wrong Input type", line, lineError);

                                System.exit(0);

                            // If exception thrown means correct input received
                            } catch (NumberFormatException e){

                                // input length must be > 3 as the lowest length of an email is 3 characters
                                if (line.length() < 3){

                                    int lineError = (l * this.inputs) + 2;

                                    System.out.println("Input error, input size");
                                    
                                    System.out.println("Input error on line: " + lineError + ", email expected, received: " + line);

                                    log.OutputLog("Wrong Input size", line, lineError);

                                    System.exit(0);
                                }
                            }
                        }

                        // If the input's correct, the input will be passed through
                        correctLine = line;
                        results[l][q] = correctLine;
                    }
                }
            }

            in.close();

            return results;
        
        // Invalid entry
        } catch (IOException iox){
            System.out.println("Invalid entry");
        }
        return (results);
    }
}
