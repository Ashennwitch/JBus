package HanifNurIlhamSanjayaJBusBR;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Payment extends Invoice {
    public Calendar departureDate;
    private int busId;
    public String busSeat;

    public Payment(int id, int buyerId, int renterId, int busId, String busSeat) {
        super(id, buyerId, renterId, Calendar.getInstance());
        this.busId = busId;
        this.busSeat = busSeat;
        this.departureDate = Calendar.getInstance();
        this.departureDate.add(Calendar.DATE, 2); // Menambahkan 2 hari dari waktu saat ini
    }

    public Payment(int id, Account buyer, Renter renter, int busId, String busSeat) {
        super(id, buyer, renter, Calendar.getInstance());
        this.busId = busId;
        this.busSeat = busSeat;
        this.departureDate = Calendar.getInstance();
        this.departureDate.add(Calendar.DATE, 2); // Menambahkan 2 hari dari waktu saat ini
    }

    public String getDepartureInfo() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss");
        return "Payment ID: " + super.id +
                "\nBuyer ID: " + super.buyerId +
                "\nRenter ID: " + super.renterId +
                "\nBus ID: " + busId + 
                "\nBus Seat: " + busSeat + 
                "\nDeparture Date: " + dateFormat.format(departureDate.getTime());
    }

    public String getTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss");
        String currdate = dateFormat.format(super.time.getTime());
        //return dateFormat.format(super.getTime().getTime());
        return currdate;
    }
}
