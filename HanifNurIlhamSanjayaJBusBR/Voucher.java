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

    public boolean isUsed() {
        return used;
    }
    
    public boolean canApply(Price price) {
        if (price.price > minimum && used == false) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public double apply(Price price) {
        if (canApply(price) == true) {
            
            if (type == Type.DISCOUNT) {
                if (this.cut > 100) {
                    this.cut = 100;
                }
                else if (this.cut == 100) {
                    return 0;
                }
                return price.price - (price.price * (this.cut / 100));
            }
            
            else if (type == Type.REBATE) {
                if (this.cut > price.price) {
                    return 0;
                }
                return price.price - this.cut;
            }
            this.used = true;
        }
        return price.price;
    }
}