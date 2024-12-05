package com.assessment.Jumbo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Store {
    private String city;
    private String postalCode;
    private String street;
    private String street2;
    private String street3;
    private String addressName;
    private String uuid;
    private Double longitude;
    private Double latitude;
    private String complexNumber;
    private boolean showWarningMessage;
    private String todayOpen;
    private String todayClose;
    private String locationType;
    private boolean collectionPoint;
    private String sapStoreID;
    // Getters and Setters
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getPostalCode() {
        return postalCode;
    }
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    public String getStreet() {
        return street;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public String getStreet2() {
        return street2;
    }
    public void setStreet2(String street2) {
        this.street2 = street2;
    }
    public String getStreet3() {
        return street3;
    }
    public void setStreet3(String street3) {
        this.street3 = street3;
    }
    public String getAddressName() {
        return addressName;
    }
    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }
    public String getUuid() {
        return uuid;
    }
    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
    public Double getLongitude() {
        return longitude;
    }
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }
    public Double getLatitude() {
        return latitude;
    }
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    public String getComplexNumber() {
        return complexNumber;
    }
    public void setComplexNumber(String complexNumber) {
        this.complexNumber = complexNumber;
    }
    public boolean isShowWarningMessage() {
        return showWarningMessage;
    }
    public void setShowWarningMessage(boolean showWarningMessage) {
        this.showWarningMessage = showWarningMessage;
    }
    public String getTodayOpen() {
        return todayOpen;
    }
    public void setTodayOpen(String todayOpen) {
        this.todayOpen = todayOpen;
    }
    public String getTodayClose() {
        return todayClose;
    }
    public void setTodayClose(String todayClose) {
        this.todayClose = todayClose;
    }
    public String getLocationType() {
        return locationType;
    }
    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }
    public boolean isCollectionPoint() {
        return collectionPoint;
    }
    public void setCollectionPoint(boolean collectionPoint) {
        this.collectionPoint = collectionPoint;
    }
    public String getSapStoreID() {
        return sapStoreID;
    }
    public void setSapStoreID(String sapStoreID) {
        this.sapStoreID = sapStoreID;
    }
}
