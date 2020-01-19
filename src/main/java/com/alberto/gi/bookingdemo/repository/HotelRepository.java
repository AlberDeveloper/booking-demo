package com.alberto.gi.bookingdemo.repository;
import org.springframework.data.repository.CrudRepository;

import com.alberto.gi.bookingdemo.entity.Hotel;

public interface HotelRepository extends CrudRepository<Hotel, Integer> {

}
