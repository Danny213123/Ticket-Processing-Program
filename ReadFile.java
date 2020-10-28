import java.io.*;
import java.util.Scanner;

public class ReadFile {
    private int Inputs;
    private int Size;
    
    public ReadFile(int Inputs, int Size){
        this.Inputs = Inputs;
        this.Size = Size;
    }
    
    public int GetInputs(){
        return this.Inputs;
    }
    
    public int GetSize(){
        return this.Size;
    }
    
    public String[][] ScanFile(){
        
        Scanner sc = new Scanner (System.in);
        
        String FileName = "Values.txt";
        String Line = "1"; 
        
        int times = 0;
        
        String[][] Results = new String[1][1];
        
        // Reads the file (values.txt) and stores the entries in an Array
        try{
            BufferedReader in = new BufferedReader(new FileReader(FileName));
            
            Line = in.readLine();
            
            this.Size = Integer.parseInt(Line);
            
            Results = new String [this.Size][(this.Inputs)];
            
            // Reads the file and stores values in an array
            while (Line != null){
                for (int q = 0; q < this.Inputs; q++){
                    Line = in.readLine();
                    if (Line == null){
                        in.close();
                        return Results;
                    }
                    Results[times][q] = Line; 
                }
                times += 1;
            }
            in.close();
            return Results;
        }
        catch (IOException iox){
            System.out.println("Invalid entery");
        }
        return (Results);
    }
    
}
