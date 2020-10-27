public class CustomerInformation {
    private int StandardTickets;
    private int VIPTickets;
    private String Email;
    
    public CustomerInformation(int StandardTickets, int VIPTickets, String Email){
        this.StandardTickets = StandardTickets;
        this.VIPTickets = VIPTickets;
        this.Email = Email;
    }
    
    public int GetTickets(){
        return this.StandardTickets;
    }
    
    public int GetVIPTickets(){
        return this.VIPTickets;
    }
    
    public String GetEmail(){
        return this.Email;
    }
    
    public String toString(){
        return(Email + "- #OfTickets: " + StandardTickets + " and #OfVIPTickets " + VIPTickets);
    }
}
