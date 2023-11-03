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
    private static final String REGEX_PHONE = "^[0-9]{9,12}$";
    private static final String REGEX_NAME = "^[A-Z][A-Z0-9_]{3,19}$";
    public String address;
    public String companyName;
    public int phoneNumber;

    /**
     * Constructor for objects of class Renter
     */
    public Renter(String companyName)
    {
        super();// initialise instance variables
        this.companyName = companyName;
        this.address = "";
        this.phoneNumber = 0;
    }
    
    public Renter(int id, String companyName, String address)
    {
        super();
        this.companyName = companyName;
        this.phoneNumber = 0;
        this.address = address;
    }

    public Renter(int id, String companyName, int phoneNumber)
    {
         super();// initialise instance variables
        this.companyName = companyName;
       this.address = "";
       this.phoneNumber = phoneNumber;
    }
    
    public Renter(int id, String companyName, int phoneNumber, String address)
    {
         super();// initialise instance variables
         this.companyName = companyName;
         this.address = address;
         this.phoneNumber = phoneNumber;
    }

    public boolean validate() {
        boolean isNameValid = companyName.matches(REGEX_NAME);
        boolean isPhoneValid = Integer.toString(phoneNumber).matches(REGEX_PHONE);

        return isNameValid && isPhoneValid;
    }


}
