package com.example.Event.Management.System.Service;

import java.time.LocalDate;
import java.util.List;

import com.example.Event.Management.System.Entity.Event;

public interface EventService {

	
	void addEvent(Event event);
    List<Event> findEvents(double latitude, double longitude, LocalDate date);
	List<Event> findEventsWithin14Days(LocalDate searchDate);
	List<Event> convertToDTOs(List<Event> events, double latitude, double longitude);
public	void createEvent(Event event);

}
