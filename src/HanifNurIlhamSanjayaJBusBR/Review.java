package HanifNurIlhamSanjayaJBusBR;


/**
 * Write a description of class Review here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Review extends Serializable
{
    public String date;
    public String desc;

    /**
     * Constructor for objects of class Review
     */
    public Review(String date, String desc)
    {
        // initialise instance variables
        super();
        this.date = date;
        this.desc = desc;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String toString()
    {
       return "Review Id:" + super.id + "Review date:" + date + "Review desc:" + desc;
        //return x + y;
    }
}
