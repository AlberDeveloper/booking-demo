package com.alberto.gi.bookingdemo.service;

import com.alberto.gi.bookingdemo.entity.Availability;
import com.alberto.gi.bookingdemo.entity.Booking;
import com.alberto.gi.bookingdemo.entity.Room;
import com.alberto.gi.bookingdemo.repository.AvailabilityRepository;
import com.alberto.gi.bookingdemo.repository.BookingRepository;
import com.alberto.gi.bookingdemo.repository.RoomRepository;
import com.alberto.gi.bookingdemo.response.BookingResponse;
import com.alberto.gi.bookingdemo.result.BookingResult;
import com.alberto.gi.bookingdemo.result.Result;

public class BookingService {
	private RoomRepository roomRepository;
	private BookingRepository bookingRepository;
	private AvailabilityRepository availabilityRepository;
	private String bookingCode;
	
	/**
	 * Constructor
	 * @param roomRepository
	 * @param bookingRepository
	 * @param availabilityRepository
	 * @param bookingCode
	 */
	public BookingService(RoomRepository roomRepository, BookingRepository bookingRepository,
			AvailabilityRepository availabilityRepository, String bookingCode) {
		super();
		this.roomRepository = roomRepository;
		this.bookingRepository = bookingRepository;
		this.availabilityRepository = availabilityRepository;
		this.bookingCode = bookingCode;
	}

	/**
	 * setBooking
	 * @param bookingCode
	 * @return BookingResult
	 */
	public BookingResult setBooking(){
		BookingResult bookingResult = new BookingResult();
		BookingResponse bookingResponse = new BookingResponse();
		Booking bookingEntity = new Booking();
		Result result = new Result();
		Availability availabilityEntity;
		
		availabilityEntity = getAvailability();
		//Initialize result message and status as error.
		result.setMessage("No se puede realizar la reserva con el código: " + this.bookingCode + ". Código incorrecto o disponibilidad agotada.");
		result.setStatus(false);
		
		if(availabilityEntity != null) {
			bookingEntity = setBooking(availabilityEntity);
			//Save locator in DB.
			bookingEntity = this.bookingRepository.save(bookingEntity);
			
			//Return saved booking entity
			bookingResponse.setLocator(bookingEntity.getLocator());
			bookingResult.setBookingResponse(bookingResponse);
			
			subtractRoom(availabilityEntity);
			result.setMessage("Reserva realizada. Localizador: " + bookingResponse.getLocator());
			result.setStatus(true);
		}
		
		bookingResult.setResult(result);
		return bookingResult;
		
	}

	/**
	 * Subtract room availability cupo by 1.
	 * @param availabilityEntity
	 */
	private void subtractRoom(Availability availabilityEntity) {
		Room room = availabilityEntity.getRoom();
		int cupo = room.getCupo();
		room.setCupo(cupo - 1);
		this.roomRepository.save(room);
	}
	
	/**
	 * getAvailability
	 * @return Availability
	 */
	private Availability getAvailability() {
		return this.availabilityRepository.findAvailabilityByCode(this.bookingCode);
	}
	
	/**
	 * setBooking
	 * @param availabilityEntity
	 * @return Booking
	 */
	private Booking setBooking(Availability availabilityEntity) {
		Booking bookingEntity = new Booking();
		
		bookingEntity.setBookingCode(this.bookingCode);
		bookingEntity.setRoom(availabilityEntity.getRoom());
		return this.bookingRepository.save(bookingEntity);
	}
	
	
}
