package com.alberto.gi.bookingdemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Room {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="hotel", referencedColumnName="id")
	private Hotel hotel;
	private String code;
	private String name;
	private Float price;
	private Integer cupo;
	
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	
	/**
	 * @return the hotel
	 */
	public Hotel getHotel() {
		return hotel;
	}
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return the price
	 */
	public Float getPrice() {
		return price;
	}
	
	/**
	 * @return the cupo
	 */
	public Integer getCupo() {
		return cupo;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * @param hotel the hotel to set
	 */
	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}
	
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @param price the price to set
	 */
	public void setPrice(Float price) {
		this.price = price;
	}
	
	/**
	 * @param cupo the cupo to set
	 */
	public void setCupo(Integer cupo) {
		this.cupo = cupo;
	}
	
	@Override
	public String toString() {
		return "Room [id=" + id + ", hotel=" + hotel + ", code=" + code + ", name=" + name + ", price=" + price
				+ ", cupo=" + cupo + "]";
	}
	
}
