package com.qa.springDemo.Services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.qa.springDemo.model.HolidayBooking;
import com.qa.springDemo.repo.Repo;

@Service
public class ServicesClass {
	
	private Repo repo;
	
	public ServicesClass(Repo repo) {
		super();
		this.repo = repo;
	}
	
	// this method replaces the whole INSERT INTO HOLIDAY_BOOKING etc
	public boolean createBookingDB(HolidayBooking booking) {
		repo.save(booking); // Takes in an entity and puts in the DB
		return true;
	}

	private ArrayList<HolidayBooking> bookingList = new ArrayList<>();
	
	public HolidayBooking getByIndex(int index) {
		return bookingList.get(index);
	}
	
	public boolean updateByIndex(int index, HolidayBooking booking) {
		bookingList.set(index, booking);
		return true; 
	}
	
	public boolean deleteall() {
		bookingList.clear();
		return true;
	}
	
	public boolean deleteIndex(int index) {
		bookingList.remove(index -1);
		return true;
	}
	
	public ArrayList<HolidayBooking> getBookings() {
		ArrayList<HolidayBooking> result = bookingList;
		return result;
	}
	
	public boolean createBooking() {
		bookingList.add(new HolidayBooking("Scotland", "Rainy", 150f, false));
		return true;
	}
	
	public boolean addArrayBooking(HolidayBooking[] bookingArray) {
		for(HolidayBooking booking: bookingArray) {
			bookingList.add(booking);
	}
		return true;
}
	
	public boolean setBookingsize(HolidayBooking booking) {
		booking.setId(bookingList.size() + 1);
		bookingList.add(booking);
		return true;
	}
	
	
	
}