package com.alberto.gi.bookingdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostPersist;

@Entity
public class Booking {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="room", referencedColumnName="id")
	private Room room;
	private String locator;
	private String bookingCode;
	private Boolean canceled = false;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}
	
	/**
	 * @return the locator
	 */
	public String getLocator() {
		return locator;
	}
	
	/**
	 * @return the canceled
	 */
	public Boolean getCanceled() {
		return canceled;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * @param room the room to set
	 */
	public void setRoom(Room room) {
		this.room = room;
	}
	
	/**
	 * @param locator the locator to set
	 */
	public void setLocator(String locator) {
		this.locator = locator;
	}

	/**
	 * @return the bookingCode
	 */
	public String getBookingCode() {
		return bookingCode;
	}

	/**
	 * @param bookingCode the bookingCode to set
	 */
	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}
	
	/**
	 * @param canceled the canceled to set
	 */
	public void setCanceled(Boolean canceled) {
		this.canceled = canceled;
	}
	
	@PostPersist
	public void onSave(){
	    this.locator = this.bookingCode + this.id;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", room=" + room + ", locator=" + locator + ", bookingCode=" + bookingCode + "]";
	}
	
}
