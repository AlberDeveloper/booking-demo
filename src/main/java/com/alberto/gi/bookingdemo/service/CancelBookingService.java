package com.alberto.gi.bookingdemo.service;

import org.springframework.web.bind.annotation.ResponseBody;

import com.alberto.gi.bookingdemo.entity.Booking;
import com.alberto.gi.bookingdemo.entity.Room;
import com.alberto.gi.bookingdemo.repository.BookingRepository;
import com.alberto.gi.bookingdemo.repository.RoomRepository;
import com.alberto.gi.bookingdemo.response.CancelBookingResponse;
import com.alberto.gi.bookingdemo.result.CancelBookingResult;
import com.alberto.gi.bookingdemo.result.Result;

public class CancelBookingService {
	private RoomRepository roomRepository;
	private BookingRepository bookingRepository;
	private String locatorCode;
	
	/**
	 * Constructor
	 * @param roomRepository
	 * @param bookingRepository
	 * @param locatorCode
	 */
	public CancelBookingService(RoomRepository roomRepository, BookingRepository bookingRepository,
			String locatorCode) {
		super();
		this.roomRepository = roomRepository;
		this.bookingRepository = bookingRepository;
		this.locatorCode = locatorCode;
	}



	public @ResponseBody CancelBookingResult cancelBooking(){
		CancelBookingResult cancelBookingResult = new CancelBookingResult();
		CancelBookingResponse cancelBookingResponse = new CancelBookingResponse();
		Booking bookingEntity = new Booking();
		Result result = new Result();
		
		//Initialize result message and status as error.
		result.setMessage("No se puede realizar la cancelación del localizador: " + this.locatorCode + ". Localizador incorrecto.");
		result.setStatus(false);
		
		bookingEntity = getBooking();
		
		if(bookingEntity != null) {
			if(bookingEntity.getCanceled()) {
				result.setMessage("No se puede realizar la cancelación del localizador: " + this.locatorCode + ". La reserva ya ha sido cancelada previamente.");
			}else {
				setBookingCanceled(bookingEntity);
				addRoom(bookingEntity);
				
				result.setMessage("Cancelación realizada correctamente. Localizador: " + this.locatorCode);
				result.setStatus(true);
			}
			
			cancelBookingResponse.setLocator(this.locatorCode);
			cancelBookingResult.setCancelBookingResponse(cancelBookingResponse);
		}
				
		cancelBookingResult.setResult(result);
		return cancelBookingResult;
	}
	
	private Booking getBooking() {
		return this.bookingRepository.findByLocator(this.locatorCode);
	}
	
	private void setBookingCanceled(Booking bookingEntity) {
		bookingEntity.setCanceled(true);
		this.bookingRepository.save(bookingEntity);
	}
	
	/**
	 * Add room availability cupo by 1.
	 * @param Booking
	 */
	private void addRoom(Booking bookingEntity) {
		Room room = bookingEntity.getRoom();
		int cupo = room.getCupo();
		room.setCupo(cupo + 1);
		this.roomRepository.save(bookingEntity.getRoom());
	}
}
