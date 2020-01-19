package com.alberto.gi.bookingdemo.response;

public class CancelBookingResponse{
	private String locator;

	/**
	 * @return the locator
	 */
	public String getLocator() {
		return locator;
	}

	/**
	 * @param locator the locator to set
	 */
	public void setLocator(String locator) {
		this.locator = locator;
	}

	@Override
	public String toString() {
		return "CancelBookingResponse [locator=" + locator + "]";
	}
	
}
