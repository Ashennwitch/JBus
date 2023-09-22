package HanifNurIlhamSanjayaJBusBR;


/**
 * Write a description of class Payment here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Payment extends Invoice
{
    // instance variables - replace the example below with your own
    protected int busId;
    public String departureDate;
    public String busSeat;

    /**
     * Constructor for objects of class Payment
     */
    public Payment(int id, int buyerId, int renterId, String time, int busId, String departureDate, String busSeat)
    {
       //this.renterId = renterId;
       super(id, buyerId, renterId, time);
       //this.time = time;\
       this.busId = busId;
       this.departureDate = departureDate;
       this.busSeat = busSeat;
       
    }
    
    public Payment(int id, Account buyer, Renter renter, String time, int busId, String departureDate, String busSeat) {
        super(id, buyer, renter, time);
        this.busId = busId;
        this.departureDate=departureDate;
        this.busSeat = busSeat;
        
    }

    public String print() {
        return "id:"  + "buyer id" + buyerId + "renter Id:" + renterId + "time:" + time + "departureDate:" + departureDate + "busSeat:" + busSeat;
    }
    
    public int getBusId() {
        return busId;        
    }
}
