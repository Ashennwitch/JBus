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
    String address;

    /**
     * Constructor for objects of class Station
     */
    public Station(String stationName, City city, String address)
    {
        super();// initialise instance variables
        this.city = city;
        this.stationName = stationName;
        this.address = address;
    }
    
    public String toString() {
        return "City:" + city + "Station Name:" + stationName + "Addres: " + address;
    }
}
