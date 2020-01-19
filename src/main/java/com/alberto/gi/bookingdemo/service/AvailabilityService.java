package com.alberto.gi.bookingdemo.service;

import java.util.ArrayList;
import java.util.List;

import com.alberto.gi.bookingdemo.entity.Availability;
import com.alberto.gi.bookingdemo.entity.Room;
import com.alberto.gi.bookingdemo.repository.AvailabilityRepository;
import com.alberto.gi.bookingdemo.repository.RoomRepository;
import com.alberto.gi.bookingdemo.response.AvailabilityResponse;
import com.alberto.gi.bookingdemo.result.AvailabilityResult;
import com.alberto.gi.bookingdemo.result.Result;
import com.google.common.collect.Iterables;

public class AvailabilityService {
	private RoomRepository roomRepository;
	private AvailabilityRepository availabilityRepository;
	
	public AvailabilityService(RoomRepository roomRepository, AvailabilityRepository availabilityRepository) {
		super();
		this.roomRepository = roomRepository;
		this.availabilityRepository = availabilityRepository;
	}

	/**
	 * 
	 * @param code
	 * @return
	 */
	public AvailabilityResult getAvailability(String code){
		//Initialize variables.
		AvailabilityResult availabilityResult = new AvailabilityResult();
		Result result = new Result();
		
		//Initialize result message and status as error.
		result.setMessage("No se ha encontrado disponibilidad para el código " + code);
		result.setStatus(false);
		
		//Get available rooms.
		Iterable<Room> rooms = getRooms(code);
		
		//If there are rooms, get all rooms info.
		if(Iterables.size(rooms) > 0) {
			result.setMessage("Se han encontrado " + Iterables.size(rooms) + " resultados para el código " + code);
			result.setStatus(true);
			
			availabilityResult.setAvailabilityList(getAvailabilityList(rooms));
		}
		
		//Set and return availability result.
		availabilityResult.setResult(result);
		return availabilityResult;
	  }
	
	/**
	 * getRooms
	 * @param code
	 * @return Iterable<Room>, list of rooms by code
	 */
	private Iterable<Room> getRooms(String code){
		return this.roomRepository.findRoomsByCode(code);
	}
	
	/**
	 * getAvailabilityList
	 * @param rooms
	 * @return List<AvailabilityResponse>, list of available rooms and they info.
	 */
	private List<AvailabilityResponse> getAvailabilityList(Iterable<Room> rooms){
		//Define variables.
		List<AvailabilityResponse> availabilityList = new ArrayList<AvailabilityResponse>();
		AvailabilityResponse availabilityResponse;
		Availability availabilityEntity;
		
		String bookingCode, hotelName, hotelCode, cityName, roomCode, roomName;
		Float roomPrice;
		
		//Set data for each available room.
		for (Room room : rooms) {
			bookingCode = room.getHotel().getCity().getCode() 
					+ room.getHotel().getCode() 
					+ room.getCode();
			
			hotelName = room.getHotel().getName();
			hotelCode = room.getHotel().getCode();
			cityName = room.getHotel().getCity().getName();
			roomCode = room.getCode();
			roomName = room.getName();
			roomPrice = room.getPrice();
			
			availabilityResponse = new AvailabilityResponse();
			availabilityResponse.setHotelName(hotelName);
			availabilityResponse.setHotelCode(hotelCode);
			availabilityResponse.setCityName(cityName);
			availabilityResponse.setRoomCode(roomCode);
			availabilityResponse.setRoomName(roomName);
			availabilityResponse.setRoomPrice(roomPrice);
			availabilityResponse.setBookingCode(bookingCode);
			
			//Add available room to list.
			availabilityList.add(availabilityResponse);
			
			//Check if already exist the availability in BD
			availabilityEntity = this.availabilityRepository.findAvailabilityByCode(bookingCode);
			
			//If not exists, then create new availability row.
			if(availabilityEntity == null) {
				availabilityEntity = new Availability();
				availabilityEntity.setBookingCode(bookingCode);
				availabilityEntity.setRoom(room);
				this.availabilityRepository.save(availabilityEntity);
			}
		}
		
		//return the available list.
		return availabilityList;
	}
}
