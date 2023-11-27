package com.HanifNurIlhamSanjayaJBusBR.controller;

import com.HanifNurIlhamSanjayaJBusBR.*;
import com.HanifNurIlhamSanjayaJBusBR.dbjson.JsonAutowired;
import com.HanifNurIlhamSanjayaJBusBR.dbjson.JsonTable;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/bus")
public class BusController implements BasicGetController<Bus> {

    @JsonAutowired(value = Bus.class, filepath = "C:\\Users\\Hanif\\Documents\\DEV\\Praktikum OOP\\JBus\\src\\main\\java\\com\\HanifNurIlhamSanjayaJBusBR\\dbjson\\bus.json")
    public static JsonTable<Bus> busTable;

    @Override
    public JsonTable<Bus> getJsonTable() {
        return busTable;
    }

    @PostMapping("/create")
    public BaseResponse<Bus> create(
            @RequestParam int accountId,
            @RequestParam String name,
            @RequestParam int capacity,
            @RequestParam List<Facility> facilities,
            @RequestParam BusType busType,
            @RequestParam int price,
            @RequestParam int stationDepartureId,
            @RequestParam int stationArrivalId
    ) {
        // Find the account based on the provided accountId
        Account account = Algorithm.<Account>find(AccountController.accountTable, acc -> acc.id == accountId);

        // Check if the account is found and is a renter
        if (account == null || account.company == null) {
            return new BaseResponse<>(false, "Failed to create bus: Account not found or is not a renter", null);
        }

        // Find the departure and arrival stations based on the provided IDs
        Station stationDeparture = Algorithm.<Station>find(StationController.stationTable, s -> s.id == stationDepartureId);
        Station stationArrival = Algorithm.<Station>find(StationController.stationTable, s -> s.id == stationArrivalId);

        // Check if the departure and arrival stations are found
        if (stationDeparture == null || stationArrival == null) {
            return new BaseResponse<>(false, "Failed to create bus: Departure or arrival station not found", null);
        }

        // Create a new Price object
        Price busPrice = new Price(price);

        // Create a new Bus object
        Bus newBus = new Bus(name, facilities, busPrice, capacity, busType, stationDeparture, stationArrival, accountId);

        // Add the new bus to the busTable
        busTable.add(newBus);

        return new BaseResponse<>(true, "Bus created successfully", newBus);
    }

    @PostMapping("/addSchedule")
    public BaseResponse<Bus> addSchedule(
            @RequestParam int busId,
            @RequestParam String time
    ) {
        // Find the bus based on the provided busId
        Bus bus = Algorithm.<Bus>find(busTable, b -> b.id == busId);

        // Check if the bus is found
        if (bus == null) {
            return new BaseResponse<>(false, "Failed to add schedule: Bus not found", null);
        }

        try {
            // Parse the time string into a Timestamp object
            Timestamp timestamp = Timestamp.valueOf(time);

            // Add the schedule to the bus
            bus.addSchedule(timestamp);

            return new BaseResponse<>(true, "Schedule added successfully", bus);
        } catch (IllegalArgumentException e) {
            // Handle invalid timestamp format
            return new BaseResponse<>(false, "Failed to add schedule: Invalid timestamp format", null);
        }
    }

    @GetMapping("/getMyBus")
    public List<Bus> getMyBus(@RequestParam int accountId) {
        return Algorithm.<Bus>collect(getJsonTable(),
                b -> b.accountId == accountId);
    }
}
