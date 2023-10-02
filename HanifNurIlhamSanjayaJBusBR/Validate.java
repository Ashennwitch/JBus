package HanifNurIlhamSanjayaJBusBR;
import java.util.ArrayList;

/**
 * Write a description of class Validate here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Validate
{
    // instance variables - replace the example below with your own
    private int x;

    /**
     * Constructor for objects of class Validate
     */
    public Validate()
    {
        // initialise instance variables
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static ArrayList filter(Price [] list, int value, boolean less)
    {
        ArrayList<Price> filteredList = new ArrayList<>();

        // Iterasi melalui array list
        for (Price price : list) {
            // Memeriksa apakah price sesuai dengan kriteria less
            if (less) {
                if (price.price <= value) {
                    filteredList.add(price);
                }
            } else {
                if (price.price > value) {
                    filteredList.add(price);
                }
            }
        }

        return filteredList;
    }
}

