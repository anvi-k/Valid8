package com.valid8.model;

import java.util.*;


public class AutoGate {

    
    public static final List<LotConfig> LOT_CONFIGS = List.of(
            new LotConfig("Busch Lot 51", 90, 40.5221, -74.4597),
            new LotConfig("Livingston Yellow", 85, 40.5239, -74.4495),
            new LotConfig("College Ave Deck", 100, 40.4983, -74.4480),
            new LotConfig("Cook Lot 98", 60, 40.4844, -74.4357),
            new LotConfig("Lot 33", 75, 40.5058, -74.4530));

    
    public static Map<String, LotConfig> buildConfigMap() {
        Map<String, LotConfig> map = new LinkedHashMap<>();
        for (LotConfig lc : LOT_CONFIGS) {
            map.put(lc.getName(), lc);
        }
        return map;
    }

    /**
     * @param records       
     * @param registrations 
     */
    public static void applyRegistrations(List<ParkingRecord> records,
            Map<String, Registration> registrations) {
        for (ParkingRecord pr : records) {
            Registration reg = registrations.get(pr.getPlate());
            pr.setRegistration(reg); 
        }
    }

    public static int computeAvailable(int capacity, int currentInLot) {
        return Math.max(0, capacity - currentInLot);
    }

   
    public static String availabilityColor(int available, int capacity) {
        if (capacity == 0)
            return "green";
        double ratio = (double) available / capacity;
        if (ratio >= 0.40)
            return "green";
        if (ratio >= 0.15)
            return "yellow";
        return "red";
    }
}
