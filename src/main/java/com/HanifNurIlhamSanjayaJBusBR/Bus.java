package com.HanifNurIlhamSanjayaJBusBR;

import com.HanifNurIlhamSanjayaJBusBR.dbjson.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.sql.Timestamp;

/**
 * Write a description of class Bus here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bus extends Serializable
{
    public int capacity;
    public List<Facility> facilities;
    public String name;
    public Price price;
    public Station departure;
    public Station arrival;
    public BusType busType;
    public List<Schedule> schedules;

    public int accountId;
    
    public Bus(String name, List<Facility> facilities, Price price, int capacity, BusType busType, Station departure, Station arrival, int accountId) {
        super();
        this.name = name;
        this.price = price;
        this.capacity = capacity;
        this.busType = busType;
        this.departure = departure;
        this.arrival = arrival;
        this.schedules = new ArrayList<>();
        this.accountId = accountId;
        this.facilities = facilities;
    }
    
    public Object write() {
        return null;
    }
    
    public String toString() {
        return "Bus Id: " + super.id + "\n"
            + "Bus name: " + name + "\n"
            + "Bus facility: " + facilities + "\n"
            + "Bus price: " + price + "\n"
            + "Bus capacity: " + capacity + "\n"
            + "Bus type: " + busType + "\n"
            + "Bus departure: " + departure + "\n"
            + "Bus arrival: " + arrival + "\n";
    }

    public void addSchedule(Timestamp timestamp) {
        if (schedules.stream().anyMatch(schedule -> schedule.departureSchedule.equals(timestamp))) {
            System.out.println("Jadwal dengan waktu yang sama sudah ada.");
        }
        Schedule schedule = new Schedule(timestamp, this.capacity);
        schedules.add(schedule);
    }

}