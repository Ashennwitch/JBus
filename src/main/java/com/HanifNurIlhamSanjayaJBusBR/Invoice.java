package com.HanifNurIlhamSanjayaJBusBR;
import com.HanifNurIlhamSanjayaJBusBR.dbjson.Serializable;

import java.sql.Timestamp;
/**
 * Write a description of class Invoice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Invoice extends Serializable
{
    
    // instance variables - replace the example below with your own
    public Timestamp time;
    public int buyerId;
    public int renterId;
    public Account buyer;
    public Renter renter;
    public BusRating rating;
    public PaymentStatus status;

    /**
     * Constructor for objects of class Invoice
     */
    protected Invoice(int buyerId, int renterId)
    {
        // initialise instance variables
        super();
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.time = new Timestamp(System.currentTimeMillis());
        rating = BusRating.NONE;
        status = PaymentStatus.WAITING;        
    }
    
    public Invoice(Account buyer, Renter renter) {
        super();
        this.buyer = buyer;
        this.renter = renter;
        this.time = new Timestamp(System.currentTimeMillis());
        this.buyerId = buyerId;
        this.renterId = renterId;
        rating = BusRating.NONE;
        status = PaymentStatus.WAITING;
    }
    
    public enum BusRating {
        NONE, NEUTRAL, GOOD, BAD
    }
    
    public enum PaymentStatus {
        FAILED, WAITING, SUCCESS
    }
 
    public String toString() {
        return "Invoice Id: " + super.id + "\n"
            + "Invoice Buyer Id: " + buyerId + "\n"
            + "Invoice Renter Id: " + renterId + "\n"
            + "Time: " + time.getTime() + "\n";
    }
}
