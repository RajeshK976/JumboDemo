package com.assessment.Jumbo.service;

import com.assessment.Jumbo.model.Attributes;
import com.assessment.Jumbo.model.Store;
import com.assessment.Jumbo.model.Stores;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class StoreService {
    public List<Store> getStoresFromFile() throws IOException {
        List<Store> storelist = new ArrayList<>();

        String storejson = new String(Files.readAllBytes(Paths.get("src/main/resources/stores.json")));
      //  System.out.println("print storejson------" + storejson);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Stores stores = objectMapper.readValue(storejson, Stores.class);
            System.out.println(stores.getStores().get(0).getCity());
            storelist.addAll(stores.getStores());

        } catch (Exception e) {
            e.printStackTrace();
        }

        return storelist;
    }

    private double haversine(double lat1, double lon1, double lat2, double lon2) {
        final double R = 6371.0; // Radius of the Earth in km
        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return R * c; // Returns the distance in km
    }
    public List<String> getClosestStores(double userLat, double userLon) throws IOException {
        List<Store> stores = getStoresFromFile();
        return stores.stream()
                .map(store -> new AbstractMap.SimpleEntry<>(store, haversine(userLat, userLon, store.getLatitude(), store.getLongitude())))
                .sorted(Comparator.comparingDouble(Map.Entry::getValue)) // Sort by distance
                .limit(5) // Take the closest 5
                .map(entry -> entry.getKey().getAddressName()) // Extract store name
                .collect(Collectors.toList());
    }
    public List<String> getClosestStoresPost(Double userLat, Double userLon, List<Store> stores ) throws IOException {
        //List<Store> stores = getStoresFromFile();
        return stores.stream()
                .map(store -> new AbstractMap.SimpleEntry<>(store, haversine(userLat, userLon, store.getLatitude(), store.getLongitude())))
                .sorted(Comparator.comparingDouble(Map.Entry::getValue)) // Sort by distance
                .limit(5) // Take the closest 5
                .map(entry -> entry.getKey().getAddressName()) // Extract store name
                .collect(Collectors.toList());
    }

}
