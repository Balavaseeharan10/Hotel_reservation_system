package com.management;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.time.LocalDate;
	import java.util.List;

	import com.model.Booking;

	public class BookingManagement {

	    // INSERT BOOKING LIST
	    public boolean insertBookingList(List<Booking> bookingList) {

	        boolean result = false;

	        try {

	            Connection con =
	                    DBConnectionManager.getConnection();

	            String query =
	                    "INSERT INTO booking VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	            PreparedStatement ps =
	                    con.prepareStatement(query);

	            for (Booking booking : bookingList) {

	                ps.setString(1, booking.getBookingId());

	                ps.setString(2, booking.getResidentId());

	                ps.setString(3, booking.getResidentName());

	                ps.setInt(4, booking.getDurationOfStay());

	                ps.setInt(5, booking.getNumberOfAdults());

	                ps.setInt(6, booking.getNumberOfChildrenAbove12());

	                ps.setInt(7, booking.getNumberOfChildrenAbove5());

	                ps.setDate(8,java.sql.Date.valueOf(booking.getCheckInDate()));

	                ps.setDate(9,java.sql.Date.valueOf( booking.getCheckOutDate()));

	                ps.setString(10, booking.getFloorNumber());

	                ps.setString(11, booking.getRoomNumber());

	                ps.setString(12, booking.getPreferredPackage());

	                ps.setString(13, booking.getAcAccess());

	                ps.setString(14, booking.getPoolAccess());

	                ps.setString(15, booking.getGymAccess());

	                ps.executeUpdate();
	            }

	            result = true;

	        } catch (Exception e) {

	            e.printStackTrace();
	        }

	        return result;
	    }

	    // UPDATE CHECK-IN AND CHECK-OUT
	    public boolean updateCheckInAndCheckOutUsingBookingId(
	            String bookingId,
	            LocalDate checkInDate,
	            LocalDate checkOutDate) {

	        boolean result = false;

	        try {

	            Connection con =
	                    DBConnectionManager.getConnection();

	            String query =
	                    "UPDATE booking SET check_in_date=?, check_out_date=? WHERE booking_id=?";

	            PreparedStatement ps =
	                    con.prepareStatement(query);

	            ps.setDate(1,
	                    java.sql.Date.valueOf(checkInDate));

	            ps.setDate(2,
	                    java.sql.Date.valueOf(checkOutDate));

	            ps.setString(3, bookingId);

	            int rows = ps.executeUpdate();

	            if (rows > 0) {

	                result = true;
	            }

	        } catch (Exception e) {

	            e.printStackTrace();
	        }

	        return result;
	    }

	    // UPDATE PACKAGE
	    public boolean updatePackageUsingBookingId(
	            String bookingId,
	            String preferredPackage) {

	        boolean result = false;

	        try {

	            Connection con =
	                    DBConnectionManager.getConnection();

	            String query =
	                    "UPDATE booking SET preferred_package=? WHERE booking_id=?";

	            PreparedStatement ps =
	                    con.prepareStatement(query);

	            ps.setString(1, preferredPackage);

	            ps.setString(2, bookingId);

	            int rows = ps.executeUpdate();

	            if (rows > 0) {

	                result = true;
	            }

	        } catch (Exception e) {

	            e.printStackTrace();
	        }

	        return result;
	    }

	    // UPDATE EXTRA ACCESS
	    public boolean updateExtraAccessUsingBookingId(
	            String bookingId,
	            String acAccess,
	            String poolAccess,
	            String gymAccess) {

	        boolean result = false;

	        try {

	            Connection con =
	                    DBConnectionManager.getConnection();

	            String query =
	                    "UPDATE booking SET ac_access=?, pool_access=?, gym_access=? WHERE booking_id=?";

	            PreparedStatement ps =
	                    con.prepareStatement(query);

	            ps.setString(1, acAccess);

	            ps.setString(2, poolAccess);

	            ps.setString(3, gymAccess);

	            ps.setString(4, bookingId);

	            int rows = ps.executeUpdate();

	            if (rows > 0) {

	                result = true;
	            }

	        } catch (Exception e) {

	            e.printStackTrace();
	        }

	        return result;
	    }

	    // CANCEL BOOKING
	    public boolean cancelBookingFromDB(String bookingId) {

	        boolean result = false;

	        try {

	            Connection con =
	                    DBConnectionManager.getConnection();

	            String query =
	                    "DELETE FROM booking WHERE booking_id=?";

	            PreparedStatement ps =
	                    con.prepareStatement(query);

	            ps.setString(1, bookingId);

	            int rows = ps.executeUpdate();

	            if (rows > 0) {

	                result = true;
	            }

	        } catch (Exception e) {

	            e.printStackTrace();
	        }

	        return result;
	    }

	    // VIEW BOOKING DETAILS
	    public Booking viewBookingDetails(String bookingId) {

	        Booking booking = null;

	        try {

	            Connection con =
	                    DBConnectionManager.getConnection();

	            String query =
	                    "SELECT * FROM booking WHERE booking_id=?";

	            PreparedStatement ps =
	                    con.prepareStatement(query);

	            ps.setString(1, bookingId);

	            ResultSet rs = ps.executeQuery();

	            if (rs.next()) {

	                Booking booking = new Booking();

	                booking.setBookingId(rs.getString(1));

	                booking.setResidentId(rs.getString(2));

	                booking.setResidentName(rs.getString(3));

	                booking.setDurationOfStay(rs.getInt(4));

	                booking.setNumberOfAdults(rs.getInt(5));

	                booking.setNumberOfChildrenAbove12(rs.getInt(6));

	                booking.setNumberOfChildrenAbove5(rs.getInt(7));

	                booking.setCheckInDate(
	                        rs.getDate(8).toLocalDate());

	                booking.setCheckOutDate(
	                        rs.getDate(9).toLocalDate());

	                booking.setFloorNumber(rs.getString(10));

	                booking.setRoomNumber(rs.getString(11));

	                booking.setPreferredPackage(rs.getString(12));

	                booking.setAcAccess(rs.getString(13));

	                booking.setPoolAccess(rs.getString(14));

	                booking.setGymAccess(rs.getString(15));
	            }

	        } catch (Exception e) {

	            e.printStackTrace();
	        }

	        return booking;
	    }
	}



