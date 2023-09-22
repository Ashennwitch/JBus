package HanifNurIlhamSanjayaJBusBR;


/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Invoice extends Serializable
{
    
    // instance variables - replace the example below with your own
    public String time;
    public int buyerId;
    public int renterId;
    public Account buyer;
    public Renter renter;

    /**
     * Constructor for objects of class Invoice
     */
    public Invoice(int id, int buyerId, int renterId, String time)
    {
        // initialise instance variables
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = time;
    }
    
    public Invoice(int id, Account buyer, Renter renter, String time) {
        super(id);
        this.buyer = buyer;
        this.renter = renter;
        this.time = time;
    }
 
    public String print() {
        return "Invoice Id : " + super.id;
    }
}
