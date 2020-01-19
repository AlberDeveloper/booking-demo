package com.alberto.gi.bookingdemo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.alberto.gi.bookingdemo.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
	@Query(value = "SELECT * FROM booking b "
    		+ "WHERE locator = :locator ", nativeQuery = true)
	Booking findByLocator(@Param("locator") String locator);
}
