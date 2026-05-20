package com.service;
	import java.time.LocalDate;
	import java.util.ArrayList;
	import java.util.List;


	import com.management.BookingManagement;
	import com.model.Booking;
	import com.util.ApplicationUtil;
	

	public class BookingService {

	    BookingManagement management = new BookingManagement();

	    // BUILD BOOKING LIST
	    public List<Booking> buildBookingList(List<String> bookingRecords) {

	        List<Booking> bookingList = new ArrayList<>();

	        try {

	            for (String data : bookingRecords) {

	                List<String> values =ApplicationUtil.extractDetail(data);

	                Booking booking = new Booking(data, data, data, 0, 0, 0, 0, null, null, data, data, data, data, data, data);

	                booking.setBookingId(generateId());

	                booking.setResidentId(values.get(0));
	                
	                booking.setResidentName(values.get(1));

	                booking.setDurationOfStay(Integer.parseInt(values.get(2)));

	                booking.setNumberOfAdults(Integer.parseInt(values.get(3)));

	                booking.setNumberOfChildrenAbove12(Integer.parseInt(values.get(4)));

	                booking.setNumberOfChildrenAbove5(Integer.parseInt(values.get(5)));

	                booking.setCheckInDate(LocalDate.parse(values.get(6)));

	                booking.setCheckOutDate(LocalDate.parse(values.get(7)));

	                booking.setFloorNumber(values.get(8));

	                booking.setRoomNumber(values.get(9));

	                booking.setPreferredPackage(values.get(10));

	                booking.setAcAccess(values.get(11));

	                booking.setPoolAccess(values.get(12));

	                booking.setGymAccess(values.get(13));

	                bookingList.add(booking);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return bookingList;
	    }

	    // ADD BOOKING LIST
	    public boolean addBookingList(List<Booking> bookingList) {

	        boolean result = false;

	        try {

	            result = management.insertBookingList(bookingList);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return result;
	    }

	    // GENERATE BOOKING ID
	    public String generateId() {

	        String id = "B" + System.currentTimeMillis();

	        return id;
	    }

	    // UPDATE CHECK-IN AND CHECK-OUT DATE
	    public boolean updateCheckInAndCheckOutUsingBookingId(String bookingId,LocalDate checkInDate,LocalDate checkOutDate) {

	        boolean result = false;

	        try {

	            result = management.updateCheckInAndCheckOutUsingBookingId( bookingId,checkInDate,checkOutDate);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return result;
	    }

	    // UPDATE PACKAGE
	    public boolean updatePackageUsingBookingId(String bookingId,String preferredPackage) {

	        boolean result = false;

	        try {

	            result = management.updatePackageUsingBookingId(bookingId,preferredPackage);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return result;
	    }

	    // UPDATE EXTRA ACCESS
	    public boolean updateExtraAccessUsingBookingId(String bookingId,String acAccess,String poolAccess,String gymAccess) {

	        boolean result = false;

	        try {

	            result=management.updateExtraAccessUsingBookingId(bookingId,acAccess,poolAccess,gymAccess);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return result;
	    }

	    // CANCEL BOOKING
	    public boolean cancelBookingFromDB(
	            String bookingId) {

	        boolean result = false;

	        try {

	            result=management.cancelBookingFromDB(bookingId);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return result;
	    }

	    // VIEW BOOKING DETAILS
	    public Booking viewBookingDetails(
	            String bookingId) {

	        Booking booking = null;

	        try {

	            booking = management.viewBookingDetails(bookingId);
	            

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return booking;
	    }
	}


