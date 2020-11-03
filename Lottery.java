import java.util.Random;

/** Performs the lottery to determine the order in which ticket requests will be fulfilled
 *
 * Lottery Class
 * @author Danny Guan
 * @version 1
 */
public class Lottery{
    /** Randomized the array which the ticket requests are stored in
     *
     * @param requests - array with all of the ticket requests
     * @return the array with the ticket request order randomized
     */
    public CustomerInformation[] RandomizeOrder(CustomerInformation[] requests) {

        Random random = new Random();

        // Sorts array of requests
        for (int i = requests.length - 1; i > 0; i--) {
            
            int index = random.nextInt(i + 1);

            CustomerInformation change = requests[i];

            requests[i] = requests[index];

            requests[index] = change;
        }
        return requests;
    }
}
