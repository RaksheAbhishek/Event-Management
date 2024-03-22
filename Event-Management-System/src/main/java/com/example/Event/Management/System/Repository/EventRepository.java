package com.example.Event.Management.System.Repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Event.Management.System.Entity.Event;

public interface EventRepository extends JpaRepository<Event, Long>{
    List<Event> findByLatitudeAndLongitudeAndDateBetween(double latitude, double longitude, LocalDate startDate, LocalDate endDate);

	List<Event> findByDateBetween(LocalDate searchDate, LocalDate endDate);

}
