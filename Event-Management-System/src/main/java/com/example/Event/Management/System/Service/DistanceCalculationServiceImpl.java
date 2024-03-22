package com.example.Event.Management.System.Service;

import org.springframework.stereotype.Service;

@Service
public class DistanceCalculationServiceImpl implements DistanceCalculationService {

    @Override
    public double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Implementation of distance calculation algorithm
        // For simplicity, let's assume a basic implementation using Euclidean distance formula
        double xDiff = lat2 - lat1;
        double yDiff = lon2 - lon1;
        return Math.sqrt(xDiff * xDiff + yDiff * yDiff);
    }
}
