package com.alberto.gi.bookingdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alberto.gi.bookingdemo.repository.AvailabilityRepository;
import com.alberto.gi.bookingdemo.repository.BookingRepository;
import com.alberto.gi.bookingdemo.repository.RoomRepository;
import com.alberto.gi.bookingdemo.result.AvailabilityResult;
import com.alberto.gi.bookingdemo.result.BookingResult;
import com.alberto.gi.bookingdemo.result.CancelBookingResult;
import com.alberto.gi.bookingdemo.service.AvailabilityService;
import com.alberto.gi.bookingdemo.service.BookingService;
import com.alberto.gi.bookingdemo.service.CancelBookingService;


@Controller
@RequestMapping(path="/booking-demo")
public class BookingController {
	@Autowired
	private RoomRepository roomRepository;
	
	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private AvailabilityRepository availabilityRepository;
	
	@GetMapping(path="/getAvailability")
	public @ResponseBody AvailabilityResult getAvailability(@RequestParam String code){
		AvailabilityService service = new AvailabilityService(roomRepository, availabilityRepository);
		return service.getAvailability(code);
	}
	
	@GetMapping(path="/booking")
	  public @ResponseBody BookingResult setBooking(@RequestParam String bookingCode){
		BookingService service = new BookingService(roomRepository, bookingRepository,
				availabilityRepository, bookingCode);
		return service.setBooking();
	}
	
	@GetMapping(path="/cancel-booking")
	  public @ResponseBody CancelBookingResult cancelBooking(@RequestParam String locatorCode){
		CancelBookingService service = new CancelBookingService(roomRepository, bookingRepository,locatorCode);
		return service.cancelBooking();
	}
}
