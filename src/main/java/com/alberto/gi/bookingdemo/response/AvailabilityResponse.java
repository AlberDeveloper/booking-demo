package com.alberto.gi.bookingdemo.response;

public class AvailabilityResponse{
	private String hotelName;
	private String hotelCode;
	private String cityName;
	private String roomCode;
	private String roomName;
	private Float roomPrice;
	private String bookingCode;
	
	
	
	/**
	 * @return the hotelName
	 */
	public String getHotelName() {
		return hotelName;
	}
	
	/**
	 * @return the hotelCode
	 */
	public String getHotelCode() {
		return hotelCode;
	}
	
	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}
	
	/**
	 * @return the roomCode
	 */
	public String getRoomCode() {
		return roomCode;
	}
	
	/**
	 * @return the roomName
	 */
	public String getRoomName() {
		return roomName;
	}
	
	/**
	 * @return the roomPrice
	 */
	public Float getRoomPrice() {
		return roomPrice;
	}
	
	/**
	 * @return the bookingCode
	 */
	public String getBookingCode() {
		return bookingCode;
	}
	
	/**
	 * @param hotelName the hotelName to set
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}
	
	/**
	 * @param hotelCode the hotelCode to set
	 */
	public void setHotelCode(String hotelCode) {
		this.hotelCode = hotelCode;
	}
	
	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	
	/**
	 * @param roomCode the roomCode to set
	 */
	public void setRoomCode(String roomCode) {
		this.roomCode = roomCode;
	}
	
	/**
	 * @param roomName the roomName to set
	 */
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	/**
	 * @param roomPrice the roomPrice to set
	 */
	public void setRoomPrice(Float roomPrice) {
		this.roomPrice = roomPrice;
	}
	
	/**
	 * @param bookingCode the bookingCode to set
	 */
	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}

	@Override
	public String toString() {
		return "Availability [hotelName=" + hotelName + ", hotelCode=" + hotelCode + ", cityName=" + cityName
				+ ", roomCode=" + roomCode + ", roomName=" + roomName + ", roomPrice=" + roomPrice + ", bookingCode="
				+ bookingCode + "]";
	}
	
}
