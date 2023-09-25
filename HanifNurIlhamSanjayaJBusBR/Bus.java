package HanifNurIlhamSanjayaJBusBR;


/**
 * Write a description of class Bus here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bus extends Serializable
{
    public int capacity;
    public Facility facility;
    public String name;
    public Price price;
    public Station departure;
    public Station arrival;
    public BusType busType;
    public City city;
    
    public Bus(int id, String name, Facility facility, Price price, int capacity, BusType busType, City city, Station departure, Station arrival) {
        super(id);
        this.name = name;
        this.facility = facility;
        this.price = price;
        this.capacity = capacity;
        this.busType = busType;
        this.city = city;
        this.departure = departure;
        this.arrival = arrival;
    }
    
    public String toString() {
        return "Bus Id :" + super.id + "Bus name: " + name + "Bus facility: " + facility + "Bus price: " + price + "Bus capcity: " + capacity + "Bus type: " + busType + "Bus city: " + city + "Bus departure: " + departure + "Bus arrival: " + arrival;
    }
}
