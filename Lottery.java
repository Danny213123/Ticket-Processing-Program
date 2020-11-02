import java.util.Random;

public class Lottery{

/**
* Randomly orders the array
* @Param CustomerInformation[] Array - Customer index
* @updates Customer 2d array with sorted indexes
*/

    public CustomerInformation[] RandomizeOrder(CustomerInformation[] Array) {

        Random random = new Random();

        // Sorts Array
        for (int i = Array.length - 1; i > 0; i--) {
            int Index = random.nextInt(i + 1);
            
            CustomerInformation Switch = Array[i];

            Array[i] = Array[Index];

            Array[Index] = Switch;
        }
        return Array;
    }

}
