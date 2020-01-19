package com.alberto.gi.bookingdemo.result;
import com.alberto.gi.bookingdemo.response.BookingResponse;

public class BookingResult {
	private BookingResponse bookingResponse;
	private Result result;

	/**
	 * @return the bookingResponse
	 */
	public BookingResponse getBookingResponse() {
		return bookingResponse;
	}

	/**
	 * @param bookingResponse the bookingResponse to set
	 */
	public void setBookingResponse(BookingResponse bookingResponse) {
		this.bookingResponse = bookingResponse;
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
