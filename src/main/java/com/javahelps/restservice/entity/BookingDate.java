package com.javahelps.restservice.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.javahelps.service.DateImplementation;

@Entity
public class BookingDate implements Comparable<BookingDate> {
	
	public BookingDate() {
		this.setBookingDateId(UUID.randomUUID().toString());
	}
	
	@Id
	@GenericGenerator(name = "uuid", strategy = "uuid")
	@Column(name = "BOOKING_DATE_ID", unique = true, length = 255)
	private String bookingDateId;
	
	@Column(name = "BOOKING_DATE", unique = true, nullable = false)
    private Date bookingDate;

	public String getBookingDateId() {
		return bookingDateId;
	}


	private void setBookingDateId(String bookingDateId) {
		this.bookingDateId = bookingDateId;
	}


	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		Calendar c = Calendar.getInstance();
		c.setTime(bookingDate);
	    c.set(Calendar.HOUR_OF_DAY, 12);
	    c.set(Calendar.MINUTE, 0);
	    c.set(Calendar.SECOND, 0);
		this.bookingDate = c.getTime();
	}

	@Override
	  public int compareTo(BookingDate booking) {
	    return this.getBookingDate().compareTo(booking.getBookingDate());
	  }
	
	@ManyToOne
    private Booking user;

}