package com.valid8.model;


public class Registration {

    private final String plate;
    private final String lot;
    private final double maxHours; 

    public Registration(String plate, String lot, double maxHours) {
        this.plate = plate.trim().toUpperCase();
        this.lot = lot.trim();
        this.maxHours = maxHours;
    }

    public String getPlate()    { return plate; }
    public String getLot()      { return lot; }
    public double getMaxHours() { return maxHours; }

    @Override
    public String toString() {
        return "Registration{plate='" + plate + "', lot='" + lot + "', maxHours=" + maxHours + "}";
    }
}
