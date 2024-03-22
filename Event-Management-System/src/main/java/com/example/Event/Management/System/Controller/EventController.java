package com.example.Event.Management.System.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.example.Event.Management.System.Entity.Event;
import com.example.Event.Management.System.Service.DistanceCalculationService;
import com.example.Event.Management.System.Service.EventService;
import com.example.Event.Management.System.Service.WeatherService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private DistanceCalculationService distanceService;

    @PostMapping("/create")
    public ResponseEntity<String> createEvent(@RequestBody Event event) {
        eventService.createEvent(event);
        return ResponseEntity.status(HttpStatus.CREATED).body("Event created successfully");
    }

    @GetMapping("/find")
    public ResponseEntity<List<Event>> findEvents(
            @RequestParam double latitude,
            @RequestParam double longitude,
            @RequestParam String date) {

        LocalDate searchDate = LocalDate.parse(date);
        List<Event> events = eventService.findEventsWithin14Days(searchDate);
        List<Event> eventDTOs = eventService.convertToDTOs(events, latitude, longitude);

        return ResponseEntity.ok(eventDTOs);
    }
    
    
    @GetMapping("/calculate-distance")
    public String calculateDistance(@RequestParam double lat1, @RequestParam double lon1,
                                    @RequestParam double lat2, @RequestParam double lon2) {
        double distance = distanceService.calculateDistance(lat1, lon1, lat2, lon2);
        return "Distance between the points: " + distance + " units";
    }

    
}
