package com.qa.springDemo.controller;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.springDemo.Services.ServicesClass;
import com.qa.springDemo.model.HolidayBooking;

@RestController
public class Controller {
	
	// array list matches other class
	
	private ServicesClass servicesClass;
	
	public Controller(ServicesClass servicesClass) {
		super();
		this.servicesClass = servicesClass;
	}




	//this method listens for /get bookings and returns array list
	@GetMapping("/getBookings")
	public ResponseEntity<ArrayList<HolidayBooking>> getBookings() {
	ArrayList<HolidayBooking> bookinglist = servicesClass.getBookings();
	ResponseEntity<ArrayList<HolidayBooking>> response = new ResponseEntity<>(bookinglist, HttpStatus.OK);					
	return response;
	}

	
	
	
	// create a method to post data
	// listens to port 8080 and /createbooking
	@PostMapping("/createBooking")
	public ResponseEntity<String> createBookings() {
		servicesClass.createBooking();
		return new ResponseEntity<>("Added Holiday", HttpStatus.OK);
	}
	
	// creating a post request that takes in information to add to the database
	// the http request will be supplied with data, in the forkm of a request body
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	@PostMapping("/setBooking")
//	public boolean setBooking(@RequestBody HolidayBooking booking) {
//		System.out.println(booking);
//		booking.setId(bookingList.size() + 1);
//		bookingList.add(booking);
//		return true;
//	}
//////////////////////////////////////////////////////////	/////////////////////////////	////////////////////////////////////////////////////////////////////////////////////////

	
	
	//listens for a /get/<number>
	// /get/4
	// /get/104 - path variable
	@GetMapping("/get/{index}")
	public ResponseEntity<HolidayBooking> getByIndex(@PathVariable("index") int index) {
			
		HolidayBooking result = servicesClass.getByIndex(index);
		ResponseEntity<HolidayBooking> response = new ResponseEntity<>(result, HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/delete/{index}")
	public ResponseEntity<String> deleteByIndex(@PathVariable("index") int index) {
		servicesClass.deleteIndex(index);
		return new ResponseEntity<>("Booking of index: " + index + " deleted", HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteAll")
	public ResponseEntity<String> deleteAll() {
		servicesClass.deleteall();
		return new ResponseEntity<>("All bookings deleted", HttpStatus.ACCEPTED);
	}
	
	//update two params, Id/index and the data we're replacing it with
	// localhost:8080/update/2 AND we need to add a request body
	@PutMapping("/update/{index}")
	public ResponseEntity<String> update(@PathVariable("index")int index, @RequestBody HolidayBooking booking) {
		servicesClass.updateByIndex(index, booking);
		return new ResponseEntity<>("Updated by Index" + index, HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/postArray")
	public ResponseEntity<String> addArrayBookings(@RequestBody HolidayBooking[] bookingArray) {

		servicesClass.addArrayBooking(bookingArray);
		return new ResponseEntity<>("Showing all Array", HttpStatus.ACCEPTED);
		
	}
	//save= the value of query and value as to seperate path variables
	// update/country/wales - updates all bookings to the country Wales 
	
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	@PutMapping("/updateByCountry/{value}")
//	public boolean updateByCountry(@PathVariable("value") String value, @RequestBody HolidayBooking booking) {
//		
//		for(HolidayBooking bookingObj : bookingList) {
//			if (bookingObj.getCountry() == value) {
//				bookingObj.setCountry(booking.getCountry());
//				bookingObj.setAllInclusive(booking.isAllInclusive());
//				bookingObj.setPrice(booking.getPrice());
//				bookingObj.setWeather(booking.getWeather());
//			}
//		}
//		
//		return true;
//	}
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	// ControllerResponseEntity
	
	// Response Entities offer more info when sending a response back
	// response includes a message and a status code we can specify and the data it requested
	// sending a delete request, we response with "deleted id of x" 202
	//sending a get request, we respond with the data requested and a status code of 200
	
	@PostMapping("/setBooking")
	public ResponseEntity<String> setBookingsize(@RequestBody HolidayBooking booking) {
		servicesClass.setBookingsize(booking);
		ResponseEntity<String> response = new ResponseEntity<String>("Booking added with ID: " + booking.getId(), HttpStatus.CREATED);
		return response;
	}
	
	
}
