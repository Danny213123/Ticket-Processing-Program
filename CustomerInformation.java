/**  Organizes customer information
 *
 * CustomerInformation Class
 * @author Danny Guan
 * @version 2
 */
public class CustomerInformation {
    private int standardTickets;
    private int VIPTickets;
    private String email;
    
    /** CustomerInformation Constructor.
     *  
     * @param standardTickets - Number of standard ticket the customer wants.
     * @param VIPTickets - Number of VIP tickets the customer wants.
     * @param email - Email of the customer.
     */
    public CustomerInformation(int standardTickets, int VIPTickets, String email){
        this.standardTickets = standardTickets;
        this.VIPTickets = VIPTickets;
        this.email = email;
    }
    
    /** Returns the number of standard ticket requested
     *
     * @return standard ticket order
     */
    public int GetTickets(){
        return this.standardTickets;
    }

    /** Returns the number of VIP tickets requested
     *
     * @return VIP ticket order
     */
    public int GetVIPTickets(){
        return this.VIPTickets;
    }
    
    /** Returns the customers email
    *
    * @return customer email
    */
    public String GetEmail(){
        return this.email;
    }
    
    /** Returns the customers email and tickets requested
    *
    * @return customers email and ticket request
    */
    public String toString(){
        return("Email: " + email + ", # of Standard Tickets requested: " + standardTickets + " and # of VIP Tickets requested " + VIPTickets);
    }
}
