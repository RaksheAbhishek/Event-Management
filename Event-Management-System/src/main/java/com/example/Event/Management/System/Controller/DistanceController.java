package com.example.Event.Management.System.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DistanceController {

    @GetMapping("/calculateDistance")
    public String calculateDistance(
            @RequestParam double lat1,
            @RequestParam double lon1,
            @RequestParam double lat2,
            @RequestParam double lon2) {

        // Validate parameters if necessary
        if (!isValidCoordinates(lat1, lon1) || !isValidCoordinates(lat2, lon2)) {
            return "Invalid coordinates provided";
        }

        // Perform distance calculation
        String distance = calculateDistance(lat1, lon1, lat2, lon2);

        return "Distance between points: " + distance + " km";
    }
    
    
    private boolean isValidCoordinates(double lat, double lon) {
        // Latitude must be in the range of -90 to 90
        // Longitude must be in the range of -180 to 180
        return (lat >= -90 && lat <= 90) && (lon >= -180 && lon <= 180);
    }

    private double calculateDistance1(double lat1, double lon1, double lat2, double lon2) {
        // Add distance calculation logic here
        // For simplicity, let's assume we calculate the distance using the Haversine formula
        double radiusEarth = 6371; // Radius of the Earth in kilometers
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return radiusEarth * c;
    }
}
