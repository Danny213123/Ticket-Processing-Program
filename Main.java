/** Read, organize and output customer orders
 *
 * Main Class
 * @author Danny Guan
 * @version 6
 */
public class Main
{
    public static void main(String[] args)
    {
        int inputs = 3;

        ReadFile scan = new ReadFile(inputs, 1);
        
        // Reads input file (Values.txt)
        String[][] stringArray = scan.ScanFile();

        Lottery customerLottery = new Lottery();
        
        CustomerInformation[] customers = new CustomerInformation[stringArray.length];
        
        // Creates User objects with correct info
        for (int y = 0; y < customers.length; y++){
            customers[y] = new CustomerInformation(Integer.parseInt(stringArray[y][1]),Integer.parseInt(stringArray[y][2]), stringArray[y][0]);
        }
        
        customers = customerLottery.RandomizeOrder(customers);

        // Outputs file to Output.txt
        WriteFile output = new WriteFile();
        output.OutputFile(customers);

        // Prints out user information
        System.out.println("Ticket Requests in randomized order....\n");

        for (int x = 0; x < customers.length; x ++){
          System.out.println(customers[x].toString() + "\n");
        }

        System.out.println("Refer to the Output.txt file to check the email text(s) generated, and if the request(s) could be fulfilled");
    }
}
