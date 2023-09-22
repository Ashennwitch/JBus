package HanifNurIlhamSanjayaJBusBR;


/**
 * Write a description of class Station here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Station extends Serializable
{
    // instance variables - replace the example below with your own
    public City city;
    public String stationName;

    /**
     * Constructor for objects of class Station
     */
    public Station(int id, String stationName, City city)
    {
        super(id);// initialise instance variables
        this.city = city;
        this. stationName = stationName;
    }
    
    public String print() {
        return "City:" + city + "Station Name:" + stationName;
    }
}
