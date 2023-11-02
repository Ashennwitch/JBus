package HanifNurIlhamSanjayaJBusBR;

import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.List;

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
            String seatCode = "BR" + (seatNumber < 10 ? "0" : "") + seatNumber;
            seatAvailability.put(seatCode, true);
        }
    }

    public Map<String, Boolean> getSeatAvailability() {
        return seatAvailability;
    }

    public boolean isSeatAvailable(String seat) {
        Boolean availability = seatAvailability.get(seat);
        return availability != null && availability;
    }

    public boolean isSeatAvailable(List<String> seats) {
        boolean allAvailable = true;
        for (String seat : seats) {
            if (!isSeatAvailable(seat)) {
                allAvailable = false;
                break;
            }
        }
        return allAvailable;
    }

    public void bookSeat(String seat) {
        Boolean availability = seatAvailability.get(seat);
        if (availability != null && availability) {
            seatAvailability.put(seat, false);
        }
    }

    public void bookSeat(List<String> seats) {
        for (String seat : seats) {
            bookSeat(seat);
        }
    }

    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.S");
        String formattedDepartureSchedule = dateFormat.format(this.departureSchedule.getTime());
        int totalSeats = seatAvailability.size();
        int occupiedSeats = (int) seatAvailability.values().stream().filter(available -> !available).count();

        return "Schedule: " + formattedDepartureSchedule + "\nOccupied: " + occupiedSeats + "/" + totalSeats;
    }

    public void printSchedule() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMMM d, yyyy HH:mm:ss");
        String formattedDepartureSchedule = dateFormat.format(this.departureSchedule.getTime());
        System.out.println("Tanggal keberangkatan: " + formattedDepartureSchedule);
        System.out.println("Daftar kursi dan ketersediaan kursinya: ");
        int maxSeatsPerRow = 4;
        int currentSeat = 1;
        for (String seat : this.seatAvailability.keySet()) {
            String symbol = this.seatAvailability.get(seat) ? "O" : "X";
            System.out.print(seat + " : " + symbol + "\t");
            if (currentSeat % maxSeatsPerRow == 0) {
                System.out.println();
            }
            currentSeat++;
        }
        System.out.println("\n");
    }
}
