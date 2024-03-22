package com.example.Event.Management.System.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Event.Management.System.Entity.Event;
import com.example.Event.Management.System.Repository.EventRepository;


@Service
public class EventServiceImpl implements EventService {

	 private final EventRepository eventRepository;

	    public EventServiceImpl(EventRepository eventRepository) {
	        this.eventRepository = eventRepository;
	    }

	    @Override
	    public void addEvent(Event event) {
	        eventRepository.save(event);
	    }

	    @Override
	    public List<Event> findEvents(double latitude, double longitude, LocalDate date) {
	        LocalDate endDate = date.plusDays(14);
	        return eventRepository.findByLatitudeAndLongitudeAndDateBetween(latitude, longitude, date, endDate);
	    }

		@Override
		public List<Event> findEventsWithin14Days(LocalDate searchDate) {

		    LocalDate endDate = searchDate.plusDays(14);
		    return eventRepository.findByDateBetween(searchDate, endDate);
		}

		@Override
		public List<Event> convertToDTOs(List<Event> events, double latitude, double longitude) {
			List<Event> eventDTOs = new ArrayList<>();
		    for (Event event : events) {
		        Event eventDTO = new Event(null, null, null, null, longitude, longitude);
		        // Map event fields to eventDTO fields
		        eventDTOs.add(eventDTO);
		    }
		    return eventDTOs;
		}

		@Override
		public void createEvent(Event event) {
			eventRepository.save(event);
			
		}


}
