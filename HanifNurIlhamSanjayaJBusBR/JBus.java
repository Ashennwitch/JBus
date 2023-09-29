package HanifNurIlhamSanjayaJBusBR;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
/**
 * Write a description of class JBus here.
 *
 * @author Hanif Nur Ilham Sanjaya
 * @version (a version number or a date)
 */
public class JBus {
 
    public static void main(String[] args) {
       Bus testBus = new Bus(1, "Hanif Bus", Facility.LUNCH, new Price(750000, 5), 25, BusType.REGULER, City.JAKARTA, new Station(20, "Pocin", City.DEPOK,"Blok duku"), new Station(30, "Gondangdia", City.DEPOK,"Blok apel"));


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
            testBus.printSchedule();
        }
    

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
    }
    
   public static Bus createBus() {
        Price price = new Price(750000, 5);
        Bus bus = new Bus(1, "Netlab Bus", Facility.LUNCH, price, 25, BusType.REGULER, City.BANDUNG, new Station(1, "Depok Terminal", City.DEPOK, "Jl. Margonda Raya"), new Station(2, "Halte UI", City.JAKARTA, "Universitas Indonesia"));
        return bus;
    }
    
   // public static Bus createBus() {
     //   Price price = new Price(750000, 5);
     //   Bus bus = new Bus(2403,"hanif bus", Facility.LUNCH, price, 25, );
     //   return bus;
    //}
    
    public int getBusId() {
        return 0;
    }

    public String getBusName() {
        return "Bus";
    }

    public boolean isDiscount() {
        return true;
    }

    public float getDiscountPercentage(int beforeDiscount, int afterDiscount) {
        if (beforeDiscount > afterDiscount) {
            return ((float)(beforeDiscount - afterDiscount) / beforeDiscount) * 100;
        } else {
            return 0.0f;
        }
    }

    public int getDiscountedPrice(int price, float discountPercentage) {
        if (discountPercentage > 100.0f) {
            discountPercentage = 100.0f;
        }
        return (int)(price - (price * (discountPercentage / 100.0f)));
    }

    public int getOriginalPrice(int discountedPrice, float discountPercentage) {
        int originalPrice = (int)(discountedPrice / (1 - discountPercentage / 100.0f));
        return originalPrice;
    }

    public float getAdminFeePercentage() {
        return 0.05f;
    }

    public int getAdminFee(int price) {
        float adminFeePercentage = getAdminFeePercentage();
        int adminFee = (int)(price * adminFeePercentage);
        return adminFee;
    }

    public int getTotalPrice(int price, int numberOfSeat) {
        int totalPrice = (price * numberOfSeat) + getAdminFee(price * numberOfSeat);
        return totalPrice;
    }
}
