package com.alberto.gi.bookingdemo.repository;
import org.springframework.data.repository.CrudRepository;

import com.alberto.gi.bookingdemo.entity.City;

public interface CityRepository extends CrudRepository<City, Integer> {

}
