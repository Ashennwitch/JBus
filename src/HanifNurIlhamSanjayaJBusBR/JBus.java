package HanifNurIlhamSanjayaJBusBR;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.sql.Timestamp;
import java.util.Arrays;


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

        //listOfSchedules.forEach(b::addSchedule);
        System.out.println("Page 1");
        Algorithm.paginate(b.schedules, 0, 3, t -> true).forEach(System.out::println);
        System.out.println("=====================================================");
        System.out.println("Page 2");
        Algorithm.paginate(b.schedules, 1, 3, t -> true).forEach(System.out::println);
        System.out.println("=====================================================");

        // Tes Booking
        String msgSuccess = "Booking Success!";
        String msgFailed = "Booking Failed";
        // valid date, invalid seat = Booking Failed
        Timestamp t1 = Timestamp.valueOf("2023-7-19 15:00:00");
        System.out.println("\nMake booking at July 19, 2023 15:00:00 Seats: BR17 BR18");
        System.out.println(Payment.makeBooking(t1, List.of("BR17", "S18"), b)? msgSuccess : msgFailed);
        // valid date, invalid seat = Booking Failed
        Timestamp t2 = Timestamp.valueOf("2023-7-18 15:00:00");
        System.out.println("Make booking at July 18, 2023 15:00:00 Seat BR26");
        System.out.println(Payment.makeBooking(t2, "BR26", b)? msgSuccess : msgFailed);
        // valid date, valid seat = Booking Success
        System.out.println("Make booking at July 18, 2023 15:00:00 Seats: BR7 BR8");
        System.out.println(Payment.makeBooking(t2, List.of("BR7", "BR8"), b)? msgSuccess : msgFailed);
        // valid date, valid seat = Booking Success
        Timestamp t3 = Timestamp.valueOf("2023-7-20 12:00:00");
        System.out.println("Make booking at July 20, 2023 12:00:00 Seats: BR1 BR2");
        System.out.println(Payment.makeBooking(t3, List.of("BR1", "BR2"), b)? msgSuccess : msgFailed);
        // valid date, book the same seat = Booking Failed
        System.out.println("Make booking at July 20, 2023 12:00:00 Seat BR1");
        System.out.println(Payment.makeBooking(t3, "BR1", b)? msgSuccess : msgFailed);
        // check if the data changed
        System.out.println("\nUpdated Schedule");
        Algorithm.paginate(b.schedules, 0, 4, t-> true).forEach(System.out::println);
    }


/*        Integer[] numbers = {18, 10, 22, 43, 18, 67, 12, 11, 88, 22, 18};
        System.out.println("Number "+Arrays.toString(numbers));

        // Tes Algorithm
        System.out.print("1. ");
        testCount(numbers);
        System.out.print("2. ");
        testFind(numbers);
        System.out.print("3. ");
        testExist(numbers);
        System.out.println("4. Filtering");
        testCollect(numbers);
    }
    private static void testExist(Integer[] t) {
        int valueToCheck = 67;
        boolean result3 = Algorithm.exists(t, valueToCheck);
        if (result3) {
            System.out.println(valueToCheck + " exist in the array.");
        } else {
            System.out.println(valueToCheck + " doesn't exists in the array.");
        }
    }
    public static void testCount(Integer[] t) {
        int valueToCount = 18;
        int result = Algorithm.count(t, valueToCount);
        System.out.println("Number " + valueToCount + " appears " + result + " times");
    }
    public static void testFind(Integer[] t) {
        Integer valueToFind = 69;
        Integer result2 = Algorithm.find(t, valueToFind);
        System.out.print("Finding " + valueToFind + " inside the array : ");
        if (result2 != null) {
            System.out.println("Found!" + result2);
        } else {
            System.out.println("Not Found");
        }
    }
    private static void testCollect(Integer[] t) {
        Predicate<Integer> below = (val)->val<=22;
        Predicate<Integer> above = (val)->val>43;

        List<Integer> integerBelow = Algorithm.collect(t, below);
        List<Integer> integerAbove = Algorithm.collect(t, above);

        System.out.println("Below 22");
        System.out.println(integerBelow);
        System.out.println("Above 43");
        System.out.println(integerAbove);
    }
 
//    public static void main(String[] args) {


        /*
        Integer[] numbers = {10, 20, 30, 40, 50};
        int valueToCheck = 30;

        boolean result = Algorithm.exists(numbers, valueToCheck);
        if (result) {
            System.out.println(valueToCheck + " terdapat dalam array.");
        }
        else {
            System.out.println(valueToCheck + " tidak terdapat dalam array");
        }

        Bus b = createBus();
        Timestamp schedule1 = Timestamp.valueOf("2023-7-18 15:00:00");
        Timestamp schedule2 = Timestamp.valueOf("2023-7-20 12:00:00");

        b.addSchedule(schedule1, 12);
        b.addSchedule(schedule2, 12);

        b.schedules.forEach(Schedule::printSchedule);

        //Invalid date
        Timestamp t1 = Timestamp.valueOf("2023-7-19 15:00:00");
        System.out.println("Make booking at July 19, 2023 15:00:00 Seat BR12");
        System.out.println(Payment.makeBooking(t1, "BR12", b));
        //Valid date, invalid seat
        Timestamp t2 = Timestamp.valueOf("2023-7-18 15:00:00");
        System.out.println("\nMake booking at July 18, 2023 15:00:00 Seat BR20");
        System.out.println(Payment.makeBooking(t2, "BR20", b));
        System.out.println("\nMake booking at July 18, 2023 15:00:00 Seat BR07");
        System.out.println(Payment.makeBooking(t2, "BR07", b));
        //Valid date, valid seat
        Timestamp t3 = Timestamp.valueOf("2023-7-20 12:00:00");
        System.out.println("\nMake booking at July 20, 2023 12:00:00 Seat BR01");
        System.out.println(Payment.makeBooking(t3, "BR01", b));
        System.out.println("\nMake booking at July 20, 2023 12:00:00 Seat BR01 again");
        System.out.println(Payment.makeBooking(t3, "BR01", b));

        //Check if the data changed
        System.out.println("\nUpdated Schedule\n");
        b.schedules.forEach(Schedule::printSchedule);
        */
//}

    //Bus testBus = new Bus(1, "Hanif Bus", Facility.LUNCH, new Price(750000, 5), 25, BusType.REGULER, City.JAKARTA, new Station(20, "Pocin", City.DEPOK,"Blok duku"), new Station(30, "Gondangdia", City.DEPOK,"Blok apel"));

/*
        Payment testPayment = new Payment(1, 2, 3, 4, "BR");

        System.out.println("Departure Info: " + testPayment.getDepartureInfo());

        System.out.println("Time: " + testPayment.getTime());

        // Buat jadwal keberangkatan untuk Bus
        Calendar schedule1 = Calendar.getInstance();
        testBus.addSchedule(schedule1);

        Calendar schedule2 = Calendar.getInstance();
        schedule2.add(Calendar.DAY_OF_MONTH, 3);
        testBus.addSchedule(schedule2);

        // Cetak jadwal keberangkatan untuk Bus
        for (Schedule s : testBus.schedules) {
            testBus.printSchedule(s);
        }
*/    

       /* Bus testBus = createBus();
        System.out.println(testBus.name);
        System.out.println(testBus.facility);
        System.out.println(testBus.price.price);
        System.out.println(testBus.capacity);
        
        Payment testPayment = new Payment(1, 1, 1, "A", 1, "A", "A");
        Invoice testInvoice = new Invoice (2,2,2, "B");
        Station testStation = new Station (3, "C", City.DEPOK);
        System.out.println(testPayment.print());
        System.out.println(testInvoice.print());
        System.out.println(testStation.print()); 
        */


    /*
    Review testReview = new Review(1, "23 August 2023", "Bad Quality");
    Price testPrice = new Price(100000, 20000);
    Station testDeparture = new Station(2, "Depok Terminal", City.DEPOK, "Jl. Margonda Raya");
    Station testArrival = new Station(3, "Halte UI", City.JAKARTA, "Universitas Indonesia");
    Bus testBus = new Bus(1, "Busway", Facility.AC, testPrice, 50, BusType.REGULER, City.DEPOK, testDeparture, testArrival);
    Account testAccount = new Account(1, "Bob", "bob@gmail.com", "bob");
    Rating testRating = new Rating();
    System.out.println(testReview);
    System.out.println(testBus);
    System.out.println(testAccount);
    System.out.println(testPrice);
    System.out.println(testRating);
    */
/*       
    Price[] unfilteredArray = new Price[5];
    for (int i = 0; i<unfilteredArray.length; i++) {
        int j = 5000;
        unfilteredArray[i] = new Price((i+1)*j);
    }
    System.out.println("Price List");
    for (Price price : unfilteredArray) {
        System.out.println(price.price);
    }
    System.out.println("Below 12000.0");
    System.out.println(Validate.filter(unfilteredArray, 12000, true));
    System.out.println("Above 10000.0");
    System.out.println(Validate.filter(unfilteredArray, 10000, false));
*/
    public static Bus createBus() {
        Price price = new Price(750000, 5);
        Bus bus = new Bus(1, "Netlab Bus", Facility.LUNCH, price, 25, BusType.REGULER, City.BANDUNG, new Station(1, "Depok Terminal", City.DEPOK, "Jl. Margonda Raya"), new Station(1, "Halte UI", City.JAKARTA, "Universitas Indonesia"));
        return bus;
    }
}


