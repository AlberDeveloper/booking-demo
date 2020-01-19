package com.alberto.gi.bookingdemo.result;
import com.alberto.gi.bookingdemo.response.CancelBookingResponse;

public class CancelBookingResult {
	private CancelBookingResponse cancelBookingResponse;
	private Result result;
	
	/**
	 * @return the cancelBookingResponse
	 */
	public CancelBookingResponse getCancelBookingResponse() {
		return cancelBookingResponse;
	}

	/**
	 * @param cancelBookingResponse the cancelBookingResponse to set
	 */
	public void setCancelBookingResponse(CancelBookingResponse cancelBookingResponse) {
		this.cancelBookingResponse = cancelBookingResponse;
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
