package com.alberto.gi.bookingdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Availability {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String bookingCode;
	@ManyToOne
	@JoinColumn(name="room", referencedColumnName="id")
	private Room room;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * @return the bookingCode
	 */
	public String getBookingCode() {
		return bookingCode;
	}
	
	/**
	 * @return the room
	 */
	public Room getRoom() {
		return room;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * @param bookingCode the bookingCode to set
	 */
	public void setBookingCode(String bookingCode) {
		this.bookingCode = bookingCode;
	}
	
	/**
	 * @param room the room to set
	 */
	public void setRoom(Room room) {
		this.room = room;
	}
	
	@Override
	public String toString() {
		return "Availability [id=" + id + ", bookingCode=" + bookingCode + ", room=" + room + "]";
	}
	
}
