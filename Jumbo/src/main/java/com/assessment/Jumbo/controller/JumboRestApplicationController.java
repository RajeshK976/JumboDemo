package com.assessment.Jumbo.controller;

import com.assessment.Jumbo.model.Attributes;
import com.assessment.Jumbo.model.Store;
import com.assessment.Jumbo.model.Stores;
import com.assessment.Jumbo.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

@RestController
public class JumboRestApplicationController {
    @Autowired
    private StoreService storeService;
    @RequestMapping(value = "/getallstores" , method = RequestMethod.GET)
    public List<Store> getAllStores() throws IOException {
        return storeService.getStoresFromFile();
    }
    @RequestMapping(value = "/getstoresbypositions" , method = RequestMethod.GET)
    public List<String> getClosestStores(@RequestParam Double lat, @RequestParam Double lon) throws IOException {
        List<String> result = storeService.getClosestStores(lat,lon);
        System.out.println("print the 5 closest store for the input coordinates : " + result );
        return result;
    }
    @RequestMapping(value = "/getstoresbypositionspost" , method = RequestMethod.POST)
    public ResponseEntity getClosestStoresPost(@RequestBody Store store) throws IOException {
        Double lat = store.getLatitude();
        Double lon =  store.getLongitude();
        System.out.println("print the lat---->" + lat );
        System.out.println("print the lon---->" + lon );
        if(lat == null || lon == null){
            return ResponseEntity.status(400).body("Invalid Input");
        }
        List<Store> position = storeService.getStoresFromFile();
        List<String> result = storeService.getClosestStoresPost(lat,lon,position);
        System.out.println("print the 5 closest store for the input coordinates : " + result );
        return ResponseEntity.status(200).body(result);
    }

}
