package HanifNurIlhamSanjayaJBusBR;


/**
 * Write a description of class Price here.
 *
 * @author (your name)
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
}
