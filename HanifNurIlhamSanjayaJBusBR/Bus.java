package HanifNurIlhamSanjayaJBusBR;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;

/**
 * Write a description of class Bus here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bus extends Serializable implements FileParser
{
    public int capacity;
    public Facility facility;
    public String name;
    public Price price;
    public Station departure;
    public Station arrival;
    public BusType busType;
    public City city;
    public List<Schedule> schedules;
    
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
        this.schedules = new ArrayList<>();
    }
    
    public Object write() {
        return null;
    }

    @Override
    public boolean read(String filename) {
        return false; // Mengembalikan true jika berhasil membaca, false jika gagal
    }  
    
    public String toString() {
        return "Bus Id: " + super.id + "\n"
            + "Bus name: " + name + "\n"
            + "Bus facility: " + facility + "\n"
            + "Bus price: " + price + "\n"
            + "Bus capacity: " + capacity + "\n"
            + "Bus type: " + busType + "\n"
            + "Bus city: " + city + "\n"
            + "Bus departure: " + departure + "\n"
            + "Bus arrival: " + arrival + "\n";
    }
    
        public void addSchedule(Timestamp timestamp) {
        Schedule schedule = new Schedule(timestamp, capacity);
        schedules.add(schedule);
    }
    
    public void createSchedule(Timestamp departureSchedule, int numberOfSeats) {
    Schedule schedule = new Schedule(departureSchedule, numberOfSeats);
    schedules.add(schedule);
    }

}