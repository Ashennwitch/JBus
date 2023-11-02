package HanifNurIlhamSanjayaJBusBR;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Timestamp;
import java.util.List;

public class Payment extends Invoice {
    public Timestamp departureDate;
    private int busId;
    public String busSeat;

    public Payment(int id, int buyerId, int renterId, int busId, String busSeat, Timestamp departureDate) {
        super(buyerId, renterId);
        this.busId = busId;
        this.busSeat = busSeat;
        this.departureDate = departureDate;
        //this.departureDate.add(Calendar.DATE, 2); // Menambahkan 2 hari dari waktu saat ini
    }

    public Payment(int id, Account buyer, Renter renter, int busId, String busSeat, Timestamp departureDate) {
        super(id, buyer, renter);
        this.busId = busId;
        this.busSeat = busSeat;
        this.departureDate = departureDate;
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

    public static Schedule availableSchedule(Timestamp departureSchedule, String seat, Bus bus) {
        for (Schedule schedule : bus.schedules) {
            if (schedule.departureSchedule.equals(departureSchedule) && schedule.isSeatAvailable(seat)) {
                return schedule;
            }
        }
        return null;
    }

    public static Schedule availableSchedule(Timestamp departureSchedule, List<String> seats, Bus bus) {
        for (Schedule schedule : bus.schedules) {
            if (schedule.departureSchedule.equals(departureSchedule) && schedule.isSeatAvailable(seats)) {
                return schedule;
            }
        }
        return null;
    }

    public static boolean makeBooking(Timestamp departureSchedule, String seat, Bus bus) {
        Schedule schedule = availableSchedule(departureSchedule, seat, bus);
        if (schedule != null) {
            schedule.bookSeat(seat);
            return true;
        }
        return false;
    }

    public static boolean makeBooking(Timestamp departureSchedule, List<String> seats, Bus bus) {
        Schedule schedule = availableSchedule(departureSchedule, seats, bus);
        if (schedule != null) {
            schedule.bookSeat(seats);
            return true;
        }
        return false;
    }

}