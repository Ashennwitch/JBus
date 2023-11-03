package HanifNurIlhamSanjayaJBusBR;
import java.util.ArrayList;
import java.util.List;
import java.sql.Timestamp;

import static HanifNurIlhamSanjayaJBusBR.Algorithm.paginate;


/**
 * Write a description of class JBus here.
 *
 * @author Hanif Nur Ilham Sanjaya
 * @version (a version number or a date)
 */
public class JBus {

    public static void main(String[] args) {

        //Renter renter = new Renter(hanif, hanifs);
        //System.out.println(true Regex, void validate());


        try {
            String filepath =
                    "C:\\Users\\Hanif\\Documents\\DEV\\Praktikum OOP\\JBus\\data\\buses_CS.json";
            JsonTable<Bus> busList = new JsonTable<>(Bus.class, filepath);
            List<Bus> filteredBus =
                    filterByDeparture(busList, City.JAKARTA, 1, 10);
            filteredBus.forEach(bus -> System.out.println(bus.toString()));
        } catch (Throwable t) {
            t.printStackTrace();

        }
    }

    public static Bus createBus() {
        Price price = new Price(750000, 5);
        Bus bus = new Bus("Netlab Bus", Facility.LUNCH, price, 25, BusType.REGULER, City.BANDUNG, new Station("Depok Terminal", City.DEPOK, "Jl. Margonda Raya"), new Station("Halte UI", City.JAKARTA, "Universitas Indonesia"));
        return bus;
    }

    public static List<Bus> filterByDeparture(List<Bus> buses, City departure, int page, int pageSize) {
        List<Bus> filteredBuses = new ArrayList<>();

        // Filter buses by departure city
        for (Bus bus : buses) {
            if (bus.departure.city.equals(departure)) {
                filteredBuses.add(bus);
            }
        }

        // Calculate the start and end index for the specified page and pageSize
        int startIndex = page * pageSize;
        int endIndex = Math.min(startIndex + pageSize, filteredBuses.size());

        // Retrieve the buses for the specified page
        List<Bus> pageBuses = filteredBuses.subList(startIndex, endIndex);

        return pageBuses;
    }

    public static List<Bus> filterByPrice(List<Bus> buses, int minPrice, int maxPrice) {
        List<Bus> filteredBuses = new ArrayList<>();

        for (Bus bus : buses) {

            if (bus.price.price >= minPrice && bus.price.price <= maxPrice) {
                filteredBuses.add(bus);
            }
        }

        return filteredBuses;
    }

    //bus.getId() == id)
    public static Bus filterBusId(List<Bus> buses, int id) {
        for (Bus bus : buses) {
            if (bus.id == id) {
                return bus;
            }
        }
        return null;
    }

    public static List<Bus> filterByDepartureAndArrival(List<Bus> buses, City departure, City arrival, int page, int pageSize) {
        Predicate<Bus> filterPredicate = bus -> bus.departure.city.equals(departure) && bus.arrival.city.equals(arrival);

        return paginate(buses, page, pageSize, filterPredicate);
    }
}

