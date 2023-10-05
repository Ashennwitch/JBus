package HanifNurIlhamSanjayaJBusBR;


/**
 * Write a description of class Renter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Renter extends Serializable
{
    // instance variables - replace the example below with your own
    public String address;
    public String companyName;
    public int phoneNumber;

    /**
     * Constructor for objects of class Renter
     */
    public Renter(int id, String companyName)
    {
         super(id);// initialise instance variables
        this.companyName = companyName;
        this.address = "";
        this.phoneNumber = 0;
    }
    
    public Renter(int id, String companyName, String address)
    {
        super(id);
        this.companyName = companyName;
        this.phoneNumber = 0;
        this.address = address;
    }

    public Renter(int id, String companyName, int phoneNumber)
    {
         super(id);// initialise instance variables
        this.companyName = companyName;
       this.address = "";
       this.phoneNumber = phoneNumber;
    }
    
    public Renter(int id, String companyName, int phoneNumber, String address)
    {
         super(id);// initialise instance variables
         this.companyName = companyName;
         this.address = address;
         this.phoneNumber = phoneNumber;
    }


}
