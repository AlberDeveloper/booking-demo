package com.alberto.gi.bookingdemo.result;

import java.util.List;

import com.alberto.gi.bookingdemo.response.AvailabilityResponse;

public class AvailabilityResult {
	private List<AvailabilityResponse> availabilityList;
	private Result result;

	/**
	 * @return the availabilityList
	 */
	public List<AvailabilityResponse> getAvailabilityList() {
		return availabilityList;
	}

	/**
	 * @param availabilityList the availabilityList to set
	 */
	public void setAvailabilityList(List<AvailabilityResponse> availabilityList) {
		this.availabilityList = availabilityList;
	}

	/**
	 * @return the result
	 */
	public Result getResult() {
		return result;
	}

	/**
	 * @param result the result to set
	 */
	public void setResult(Result result) {
		this.result = result;
	}
}
