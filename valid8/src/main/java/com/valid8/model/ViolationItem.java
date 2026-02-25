package com.valid8.model;


public class ViolationItem {

    private String licensePlate;
    private String lotName;
    private String timeIn;   
    private String timeOut;  
    private String status;   

    public ViolationItem() {}

    public ViolationItem(String licensePlate, String lotName,
                         String timeIn, String timeOut, String status) {
        this.licensePlate = licensePlate;
        this.lotName      = lotName;
        this.timeIn       = timeIn;
        this.timeOut      = timeOut;
        this.status       = status;
    }

    public String getLicensePlate()           { return licensePlate; }
    public void setLicensePlate(String v)     { this.licensePlate = v; }

    public String getLotName()                { return lotName; }
    public void setLotName(String v)          { this.lotName = v; }

    public String getTimeIn()                 { return timeIn; }
    public void setTimeIn(String v)           { this.timeIn = v; }

    public String getTimeOut()                { return timeOut; }
    public void setTimeOut(String v)          { this.timeOut = v; }

    public String getStatus()                 { return status; }
    public void setStatus(String v)           { this.status = v; }
}
