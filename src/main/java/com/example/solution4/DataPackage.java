package com.example.solution4;

import java.time.LocalDate;

public class DataPackage {
    String packageName;
    String availability;
    String validity;
    float price;
    float dataAmount;
    LocalDate offerEnds;

    public DataPackage(String packageName, String availability, String validity, float price, float dataAmount, LocalDate offerEnds) {
        this.packageName = packageName;
        this.availability = availability;
        this.validity = validity;
        this.price = price;
        this.dataAmount = dataAmount;
        this.offerEnds = offerEnds;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDataAmount() {
        return dataAmount;
    }

    public void setDataAmount(float dataAmount) {
        this.dataAmount = dataAmount;
    }

    public LocalDate getOfferEnds() {
        return offerEnds;
    }

    public void setOfferEnds(LocalDate offerEnds) {
        this.offerEnds = offerEnds;
    }

    @Override
    public String toString() {
        return "DataPackage{" +
                "packageName='" + packageName + '\'' +
                ", availability='" + availability + '\'' +
                ", validity='" + validity + '\'' +
                ", price=" + price +
                ", dataAmount=" + dataAmount +
                ", offerEnds=" + offerEnds +
                '}';
    }
}
