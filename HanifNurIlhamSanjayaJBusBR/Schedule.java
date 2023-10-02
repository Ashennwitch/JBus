package HanifNurIlhamSanjayaJBusBR;

import java.util.Calendar;
import java.util.LinkedHashMap;
import java.util.Map;

public class Schedule {
    public Calendar departureSchedule;
    public Map<String, Boolean> seatAvailability;

    public Schedule(Calendar departureSchedule, int numberOfSeats) {
        this.departureSchedule = departureSchedule;
        initializeSeatAvailability(numberOfSeats);
    }

    private void initializeSeatAvailability(int numberOfSeats) {
        seatAvailability = new LinkedHashMap<>();
        for (int seatNumber = 1; seatNumber <= numberOfSeats; seatNumber++) {
            String seatCode = "BR" + seatNumber;
            seatAvailability.put(seatCode, true);
        }
    }

    public Calendar getDepartureSchedule() {
        return departureSchedule;
    }

    public Map<String, Boolean> getSeatAvailability() {
        return seatAvailability;
    }
}
