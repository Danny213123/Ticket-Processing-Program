/** 
 * Organizes customer information
 *
 * Customer information Class
 * @Author - Danny Guan
 * @Version - 2
 *
 */

public class CustomerInformation {
    private int StandardTickets;
    private int VIPTickets;
    private String Email;
    
    /** CustomerInformation Constructor.
     *  
     * @Param int StandardTickets - Number of standard ticket  the customer wants.
     * @Param int VIPTickets - Number of VIP tickets the customer wants.
     * @Param String Email - Email of the customer.
     * 
     */
    public CustomerInformation(int StandardTickets, int VIPTickets, String Email){
        this.StandardTickets = StandardTickets;
        this.VIPTickets = VIPTickets;
        this.Email = Email;
    }
    
    /**
    * Returns the standard ticket order 
    * @return standard ticket order
    */
    public int GetTickets(){
        return this.StandardTickets;
    }
    
    /** 
    * Returns the VIP ticket order
    * @return VIP ticket order
    */
    public int GetVIPTickets(){
        return this.VIPTickets;
    }
    
    /** 
    * Returns customer email
    * @return customer email
    */
    public String GetEmail(){
        return this.Email;
    }
    
    /** 
    * Returns all customer information
    * @return all customer information
    */
    public String toString(){
        return(Email + ": #OfTickets: " + StandardTickets + " and #OfVIPTickets " + VIPTickets);
    }
}
