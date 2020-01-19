package com.alberto.gi.bookingdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alberto.gi.bookingdemo.entity.Availability;

public interface AvailabilityRepository extends JpaRepository<Availability, Integer> {
    @Query(value = "SELECT * FROM availability a "
    		+ "JOIN room r on r.id = a.room "
    		+ "WHERE booking_code = :code "
    		+ "AND r.cupo > 0", nativeQuery = true)
    Availability findAvailabilityByCode(@Param("code") String code);
}
