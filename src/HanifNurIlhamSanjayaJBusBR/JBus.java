package HanifNurIlhamSanjayaJBusBR;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.stream.Collectors;

import static HanifNurIlhamSanjayaJBusBR.Algorithm.paginate;


/**
 * Write a description of class JBus here.
 *
 * @author Hanif Nur Ilham Sanjaya
 * @version (a version number or a date)
 */
public class JBus {

    public static void main(String[] args) {
        // PT Modul 5
        // Tes Pagination
        Bus b = createBus();
        List<Timestamp> listOfSchedules = new ArrayList<>();
        listOfSchedules.add(Timestamp.valueOf("2023-7-18 15:00:00"));
        listOfSchedules.add(Timestamp.valueOf("2023-7-20 12:00:00"));
        listOfSchedules.add(Timestamp.valueOf("2023-7-22 10:00:00"));
        listOfSchedules.add(Timestamp.valueOf("2023-7-26 12:00:00"));

        listOfSchedules.forEach(b::addSchedule);
        System.out.println("Page 1");
        paginate(b.schedules, 0, 3, t -> true).forEach(System.out::println);
        System.out.println("=====================================================");
        System.out.println("Page 2");
        paginate(b.schedules, 1, 3, t -> true).forEach(System.out::println);
        System.out.println("=====================================================");

        // Tes Booking
        String msgSuccess = "Booking Success!";
        String msgFailed = "Booking Failed";
        // valid date, invalid seat = Booking Failed
        Timestamp t1 = Timestamp.valueOf("2023-7-19 15:00:00");
        System.out.println("\nMake booking at July 19, 2023 15:00:00 Seats: BR17 BR18");
        System.out.println(Payment.makeBooking(t1, List.of("BR17", "BR18"), b) ? msgSuccess : msgFailed);
        // valid date, invalid seat = Booking Failed
        Timestamp t2 = Timestamp.valueOf("2023-7-18 15:00:00");
        System.out.println("Make booking at July 18, 2023 15:00:00 Seat BR26");
        System.out.println(Payment.makeBooking(t2, "BR26", b) ? msgSuccess : msgFailed);

        // valid date, valid seat = Booking Success
        System.out.println("Make booking at July 18, 2023 15:00:00 Seats: BR7 BR8");
        System.out.println(Payment.makeBooking(t2, List.of("BR07", "BR08"), b) ? msgSuccess : msgFailed);
        // valid date, valid seat = Booking Success
        Timestamp t3 = Timestamp.valueOf("2023-7-20 12:00:00");
        System.out.println("Make booking at July 20, 2023 12:00:00 Seats: BR1 BR2");
        System.out.println(Payment.makeBooking(t3, List.of("BR01", "BR02"), b) ? msgSuccess : msgFailed);

        // valid date, book the same seat = Booking Failed
        System.out.println("Make booking at July 20, 2023 12:00:00 Seat BR1");
        System.out.println(Payment.makeBooking(t3, "BR1", b) ? msgSuccess : msgFailed);
        // check if the data changed
        System.out.println("\nUpdated Schedule");
        paginate(b.schedules, 0, 4, t -> true).forEach(System.out::println);
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
            if (bus.id == id){
                return bus;
            }
        }
        return null;
    }

    public static List<Bus> filterByDepartureAndArrival(List<Bus> buses, City departure, City arrival, int page, int pageSize) {
        Predicate<Bus> filterPredicate = bus -> bus.departure.city.equals(departure) && bus.arrival.city.equals(arrival);

        return paginate(buses, page, pageSize, filterPredicate);
    }

    Renter renter = new Renter(123, hanif, hanifs);


    try {
        String filepath =
                "C:\\Users\\Hanif\\Documents\\DEV\\Praktikum OOP\\JBus\\data\\buses_CS.json";
        JsonTable<Bus> busList = new JsonTable<>(Bus.class, filepath);
        List<Bus> filteredBus =
                filterByDeparture (busList, City.JAKARTA,1,10);
        filteredBus.forEach (bus -> System.out.println(bus.toString()));
    }
    catch (Throwable t) {
        t.printStackTrace();

}
