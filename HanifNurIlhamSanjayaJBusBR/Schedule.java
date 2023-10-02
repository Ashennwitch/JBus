package HanifNurIlhamSanjayaJBusBR;

import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;

public class Schedule {
    public Timestamp departureSchedule;
    public Map<String, Boolean> seatAvailability;

    public Schedule(Timestamp departureSchedule, int numberOfSeats) {
        this.departureSchedule = departureSchedule;
        initializeSeatAvailability(numberOfSeats);
    }

    private void initializeSeatAvailability(int numberOfSeats) {
        seatAvailability = new LinkedHashMap<>();
        for (int seatNumber = 1; seatNumber <= numberOfSeats; seatNumber++) {
            String sn = seatNumber < 10 ? "0"+seatNumber : ""+seatNumber;
            seatAvailability.put("BR" + sn, true);
        }  
    }    
        //seatAvailability = new LinkedHashMap<>();
        //for (int seatNumber = 1; seatNumber <= numberOfSeats; seatNumber++) {
        //    String seatCode = "BR" + seatNumber;
        //    seatAvailability.put(seatCode, true);
        //}
    
    //public Calendar getDepartureSchedule() {
    //    return departureSchedule;
    //}
    public Map<String, Boolean> getSeatAvailability() {
        return seatAvailability;
    }
    
    public boolean isSeatAvailable(String seat) {
        Boolean availability = seatAvailability.get(seat);
        return availability != null && availability;
    }

    public void bookSeat(String seat) {
        Boolean availability = seatAvailability.get(seat);
        if (availability != null && availability) {
            seatAvailability.put(seat, false);  // Menjadikan ketersediaan kursi menjadi false jika kursi tersedia.
        }
    }    
    
/*        public void printSchedule(Schedule schedule) {
     SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM dd, yyyy HH:mm:ss");
    // for (schedule : schedules) {
        System.out.println("Tanggal Keberangkatan: " + dateFormat.format(departureSchedule.getTime()));
        System.out.println("Seat Availability:");
            for (Map.Entry<String, Boolean> entry : seatAvailability.entrySet()) {
                String seatCode = entry.getKey();
                boolean isAvailable = entry.getValue();
                System.out.println("Seat " + seatCode + ": " + (isAvailable ? "Available" : "Booked"));
    //       }
        } 
    }
*/
    public void printSchedule() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy HH:mm:ss");
        String formattedDepartureSchedule = dateFormat.format(this.departureSchedule.getTime());
        // Print tanggal keberangkatan
        System.out.println("Tanggal keberangkatan: " + formattedDepartureSchedule);
        // Print daftar kursi dan ketersediaan kursinya
        System.out.println("Daftar kursi dan ketersediaan kursinya: ");
        // Create a list of seats and sort them numerically
        int maxSeatsPerRow = 4; // Assuming there are 4 seats per row
        int currentSeat = 1;
        for (String seat : this.seatAvailability.keySet()) {
            String symbol = this.seatAvailability.get(seat)? "O" : "X";
            System.out.print(seat + " : " + symbol + "\t");
                if (currentSeat % maxSeatsPerRow == 0) {
                    System.out.println();
                }
            currentSeat++;
        }
        System.out.println("\n");
    }
}
