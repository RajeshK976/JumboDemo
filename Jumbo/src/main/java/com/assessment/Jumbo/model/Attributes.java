package com.assessment.Jumbo.model;

import java.util.Map;
public class Attributes {
    private Map<String, Object> longitude;
    private Map<String, Object> latitude;
    // Getters and Setters
    public Map<String, Object> getLongitude() {
        return longitude;
    }
    public void setLongitude(Map<String, Object> longitude) {
        this.longitude = longitude;
    }
    public Map<String, Object> getLatitude() {
        return latitude;
    }
    public void setLatitude(Map<String, Object> latitude) {
        this.latitude = latitude;
    }
}
