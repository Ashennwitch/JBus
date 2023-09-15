package HanifNurIlhamSanjayaJBusBR;


/**
 * Write a description of class Price here.
 *
 * @author (Hanif Nur Ilham Sanjaya)
 * @version (a version number or a date)
 */
public class Price {
    double rebate;
    double price;
    int discount;

    // no2
    public Price(double price) {
        this.price = price;
        this.discount = 0;
        this.rebate = 0;
    }

    // no3
    public Price(double price, int discount) {
        this.price = price;
        this.discount = discount;
        this.rebate = 0;
    }

    // no4
    public Price(double price, double rebate) {
        this.price = price;
        this.rebate = discount;
        this.discount = 0;
    }
    
    public double getDiscountedPrice(double price, int discount) {
    // Apabila discount lebih dari 100.0, anggap 100.0
    if (discount > 100) {
        this.discount = 100;
        return 0.0f;
    }

    // Apabila discount adalah 100.0, kembalikan 0.0
    else if (discount == 100) {
        return 0.0f;
    }

    else {
    // Kembalikan nilai setelah field price dipotong dengan persentase diskon yang ditentukan
        return (double)(price - (price * (discount / 100)));
   }

  }
  
  public double getRebatedPrice(int priceDipotong,double rebate) {
    if (rebate > price) {
         //pastikan nilai dikembalikan tidak bisa negatif 
         return price;
      }
      
    return price - rebate;
    }
}


