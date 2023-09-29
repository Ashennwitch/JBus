package HanifNurIlhamSanjayaJBusBR;
import java.util.Calendar;

/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Invoice extends Serializable
{
    
    // instance variables - replace the example below with your own
    public Calendar time;
    public int buyerId;
    public int renterId;
    public Account buyer;
    public Renter renter;
    public BusRating rating;
    public PaymentStatus status;

    /**
     * Constructor for objects of class Invoice
     */
    protected Invoice(int id, int buyerId, int renterId, Calendar time)
    {
        // initialise instance variables
        super(id);
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = Calendar.getInstance();
        rating = BusRating.NONE;
        status = PaymentStatus.WAITING;
        
    }
    
    public Invoice(int id, Account buyer, Renter renter, Calendar time) {
        super(id);
        this.buyer = buyer;
        this.renter = renter;
        this.time = Calendar.getInstance();
        this.buyerId = buyerId;
        this.renterId = renterId;
        rating = BusRating.NONE;
        status = PaymentStatus.WAITING;
    }
    
    public enum BusRating {
        NONE, NEUTRAL, GOOD, BAD
    }
    
    public enum PaymentStatus {
        FAILED, WAITING, SUCCESS
    }
 
    public String toString() {
        return "Invoice Id: " + super.id + "\n"
            + "Invoice Buyer Id: " + buyerId + "\n"
            + "Invoice Renter Id: " + renterId + "\n"
            + "Time: " + time.getTime() + "\n";
    }
}
