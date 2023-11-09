package com.HanifNurIlhamSanjayaJBusBR;

import java.sql.Timestamp;
public class BookingThread extends Thread{
    private Bus bus;
    private Timestamp timestamp ;
    public BookingThread(String name, Bus bus, Timestamp timestamp){
        super(name);
        this.bus = bus;
        this.timestamp = timestamp;
        this.start();
    }
    public void run() {
        System.out.println("Thread " + getName() + " ID : " + getId() + " is running");

        synchronized (bus) {
            // Lakukan booking pada seat pertama pada bus jika tersedia
            if (bus != null) {
                String seat = "BR01";
                boolean bookingResult = Payment.makeBooking(timestamp, seat, bus);

                if (bookingResult) {
                    System.out.println("Thread " + getName() + " ID : " + getId() + " berhasil melakukan booking seat " + seat);
                } else {
                    System.out.println("Thread " + getName() + " ID : " + getId() + " gagal melakuakan booking seat " + seat);
                }
            }
        }
    }
}

