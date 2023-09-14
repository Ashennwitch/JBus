package HanifNurIlhamSanjayaJBusBR;


/**
 * Write a description of class JBus here.
 *
 * @author Hanif Nur Ilham Sanjaya
 * @version (a version number or a date)
 */
public class JBus {
    public void main(String[] args) {
        
    }
    
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

        if (beforeDiscount < afterDiscount) {
            return 0.0f; 
        }
  
        float discountPercentage = ((beforeDiscount - afterDiscount) * 100.0f) / beforeDiscount;
        return discountPercentage;
    }

    public float getDiscountedPrice(int price, float discountPercentage) {

        if (discountPercentage > 100.0f) {
            discountPercentage = 100.0f; 
        }

        float discountedPrice = price * (1 - discountPercentage / 100.0f);
        return discountedPrice;
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
