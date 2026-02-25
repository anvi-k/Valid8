package com.valid8.model;

import java.time.LocalDateTime;
import java.time.Duration;


public class ParkingRecord {

    private final String plate;
    private final String lot;
    private final LocalDateTime entryTime;
    private final LocalDateTime exitTime; 

   
    private Registration registration;

    public ParkingRecord(String plate, String lot, LocalDateTime entryTime, LocalDateTime exitTime) {
        this.plate = plate.trim().toUpperCase();
        this.lot = lot.trim();
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }

    public String getPlate()          { return plate; }
    public String getLot()            { return lot; }
    public LocalDateTime getEntryTime(){ return entryTime; }
    public LocalDateTime getExitTime() { return exitTime; }
    public Registration getRegistration() { return registration; }
    public void setRegistration(Registration r) { this.registration = r; }

  
    public boolean isStillInLot() {
        return exitTime == null;
    }

  
    public long getDurationMinutes() {
        LocalDateTime end = (exitTime != null) ? exitTime : LocalDateTime.now();
        return Duration.between(entryTime, end).toMinutes();
    }

  
    public boolean legal() {
        if (registration == null) {
            return false; 
        }
        if (!registration.getLot().equalsIgnoreCase(lot)) {
            return false; 
        }
        return true;
    }

   
    public String violationReason() {
        return "Unregistered";
    }

    @Override
    public String toString() {
        return "ParkingRecord{plate='" + plate + "', lot='" + lot
                + "', entry=" + entryTime + ", exit=" + exitTime + "}";
    }
}
