package com.cg.tms.dto;


/**
 * create hotel repository, hotel service
 * end points (addHotel, fetching all Hotels )
 * add hotel first => hotel id
 * drop down => display all hotels in dropdown
 * hotel => hotel id
 */

public class CreatePackageRequest {


    private String packageName;
    private String packageDescription;
    private String packageType;
    private double packageCost;
    private int hotelId;


    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {

        this.packageName = packageName;
    }

    public String getPackageDescription() {

        return packageDescription;
    }

    public void setPackageDescription(String packageDescription) {

        this.packageDescription = packageDescription;
    }

    public String getPackageType() {

        return packageType;
    }

    public void setPackageType(String packageType) {

        this.packageType = packageType;
    }

    public double getPackageCost() {

        return packageCost;
    }

    public void setPackageCost(double packageCost) {

        this.packageCost = packageCost;
    }


    public int getHotelId() {
        return hotelId;
    }

    public void setHotelId(int hotelId) {
        this.hotelId = hotelId;
    }
}
