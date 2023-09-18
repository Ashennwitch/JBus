package HanifNurIlhamSanjayaJBusBR;


/**
 * Write a description of class Voucher here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Voucher
{
    // instance variables - replace the example below with your own
    public String name;
    private boolean used;
    public double minimum;
    public double cut;
    public int code;
    public Type type;
    
    /**
     * Constructor for objects of class Voucher
     */
    public Voucher(String name, int code, Type type, double minimum, double cut)
    {
        // initialise instance variables
        this.name = name;
        this.used = false;
        this.minimum = minimum;
        this.cut = cut;
        this.code = code;
        this.type = type;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public boolean isUsed() {
        // put your code here
        return used;
    }
    
    public boolean canApply(Price price) {
        if (Price.price > minimum && used == false) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean apply(Price price) {
        if (!used) {
            if (type == type.DISCOUNT) {
                return price - (price * (1 - cut / 100));
            }
            else if (type == type.REBATE) {
                
            }
            used = true;
        }
        
        
    }
}
