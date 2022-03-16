package com.qa.springDemo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.springDemo.model.HolidayBooking;

// Repo class has all of the basic methods stored we may need to access our db
// repo.findall() - return all data
// rep.save(object) - create an object and save it into the db


public interface Repo extends JpaRepository<HolidayBooking, Long> {

	// this class extends off JpaRepo which has most methods we need
	
}
