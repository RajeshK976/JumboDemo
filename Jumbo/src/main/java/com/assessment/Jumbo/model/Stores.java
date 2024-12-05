package com.assessment.Jumbo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
public class Stores {
    private List<Store> stores;
    private Attributes attributes;

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }


    // Getters and Setters
    public List<Store> getStores() {
        return stores;
    }
    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

}
