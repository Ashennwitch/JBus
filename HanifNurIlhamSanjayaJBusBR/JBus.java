package HanifNurIlhamSanjayaJBusBR;

/**
 * Write a description of class JBus here.
 *
 * @author Hanif Nur Ilham Sanjaya
 * @version (a version number or a date)
 */
public class JBus {
 
    public static void main(String[] args) {
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
        
        Review testReview = new Review(1, "23 August 2023", "Bad Quality");
        Price testPrice = new Price (100088, 20088);
        Station testDeparture = new Station (2, "Depok Terminal", City.DEPOK, "JL. Margonda Raya");
        Station testArrival = new Station (3, "Halte UI", City.JAKARTA, "Universitas Indonesia");
        Bus testBus = new Bus(1, "Busway", Facility.AC, testPrice, 50, BusType.REGULER, City.DEPOK, testDeparture, testArrival);
        Account testAccount = new Account(1, "Bob", "bob@gmail.com", "bob");
        Rating testRating = new Rating();
        System.out.println(testReview);
        System.out.println(testBus);
        System.out.println(testAccount);
        System.out.println(testPrice);
        System.out.println(testRating);
    }
    
  // public static Bus createBus() {
   //     Price price = new Price(750000, 5);
   //     Bus bus = new Bus(2403,"hanif bus", Facility.LUNCH, price, 25);
  //      return bus;
  //  }
   
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
