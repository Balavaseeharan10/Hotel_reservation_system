package com.management;

	import java.sql.Connection;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

	import com.model.Booking;

	public class BookingManagement {

	    public boolean insertBookingList(List<Booking> bookingList) {

	        boolean result = false;

	        try {
	            Connection con = DBConnectionManager.getConnection();

	            String query ="INSERT INTO booking " +
	                    "(BOOKING_ID, RESIDENT_ID, RESIDENT_NAME, DURATION_OF_STAY, " +
	                    "NUMBER_OF_ADULTS, NUMBER_OF_CHILDREN_ABOVE12, NUMBER_OF_CHILDREN_ABOVE5, " +
	                    "CHECK_IN_DATE, CHECK_OUT_DATE, FLOOR_NUMBER, ROOM_NUMBER, " +
	                    "PREFERRED_PACKAGE, AC_ACCESS, POOL_ACCESS, GYM_ACCESS) " +
	                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

	            PreparedStatement ps = con.prepareStatement(query);

	            for (Booking booking : bookingList) {

	                ps.setString(1, booking.getBookingId());
	                ps.setString(2, booking.getResidentId());
	                ps.setString(3, booking.getResidentName());
	                ps.setInt(4, booking.getDurationOfStay());
	                ps.setInt(5, booking.getNumberOfAdults());
	                ps.setInt(6, booking.getNumberOfChildrenAbove12());
	                ps.setInt(7, booking.getNumberOfChildrenAbove5());
	                ps.setDate(8, java.sql.Date.valueOf(booking.getCheckInDate()));
	                ps.setDate(9, java.sql.Date.valueOf(booking.getCheckOutDate()));
	                ps.setString(10, booking.getFloornumber());
	                ps.setString(11, booking.getRoomNumber());
	                ps.setString(12, booking.getPreferredPackage());
	                ps.setString(13, booking.getAcAccess());
	                ps.setString(14, booking.getPoolAccess());
	                ps.setString(15, booking.getGymAccess());

	                ps.executeUpdate();
	                
	                String updateRoomQuery = "UPDATE ROOM SET IS_OCCUPIED = ? WHERE ROOM_NUMBER = ?";

	                PreparedStatement ps1 = con.prepareStatement(updateRoomQuery);

	                ps1.setString(1, "YES");

	                ps1.setString(2, booking.getRoomNumber());

	                ps1.executeUpdate();
	            }

	            result = true;

	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }

	        return result;
	    }
	    
	    public boolean updateCheckInAndCheckOutUsingBookingId(String bookingId,LocalDate checkInDate,LocalDate checkOutDate) {

	        boolean result = false;

	        try {
	            Connection con = DBConnectionManager.getConnection();

	            String query =
	                    "UPDATE booking SET CHECK_IN_DATE = ?, CHECK_OUT_DATE = ? WHERE BOOKING_ID = ?";

	            PreparedStatement ps = con.prepareStatement(query);

	            ps.setDate(1, java.sql.Date.valueOf(checkInDate));
	            ps.setDate(2, java.sql.Date.valueOf(checkOutDate));
	            ps.setString(3, bookingId);

	            int rows = ps.executeUpdate();

	            if (rows > 0) {
	                result = true;
	            }

	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }

	        return result;
	    }
	    
	    public boolean updatePackageUsingBookingId(String bookingId,String preferredPackage) {

	        boolean result = false;

	        try {

	            Connection con = DBConnectionManager.getConnection();

	            String query ="UPDATE booking SET PREFERRED_PACKAGE = ? WHERE BOOKING_ID = ?";

	            PreparedStatement ps =con.prepareStatement(query);

	            ps.setString(1, preferredPackage);

	            ps.setString(2, bookingId);

	            int rows = ps.executeUpdate();

	            if(rows > 0) {

	                result = true;
	            }

	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }

	        return result;
	    }
	    
	    public boolean updateExtraAccessUsingBookingId(String bookingId, String acAccess,String poolAccess,String gymAccess) {

	        boolean result = false;

	        try {

	            Connection con =
	                    DBConnectionManager.getConnection();

	            String query = "UPDATE booking SET AC_ACCESS = ?, POOL_ACCESS = ?, GYM_ACCESS = ? WHERE BOOKING_ID = ?";

	            PreparedStatement ps =con.prepareStatement(query);

	            ps.setString(1, acAccess);

	            ps.setString(2, poolAccess);

	            ps.setString(3, gymAccess);

	            ps.setString(4, bookingId);

	            int rows = ps.executeUpdate();

	            if(rows > 0) {

	                result = true;
	            }

	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }

	        return result;
	    }
	    
	    public boolean cancelBookingFromDB(String bookingId) {

	        boolean result = false;

	        try {

	            Connection con = DBConnectionManager.getConnection();

	            String roomNumber = "";

	            String selectQuery = "SELECT ROOM_NUMBER FROM BOOKING WHERE BOOKING_ID = ?";

	            PreparedStatement ps1 = con.prepareStatement(selectQuery);

	            ps1.setString(1, bookingId);

	            ResultSet rs = ps1.executeQuery();

	            if(rs.next()) {

	                roomNumber = rs.getString("ROOM_NUMBER");
	            }

	            String deleteQuery = "DELETE FROM BOOKING WHERE BOOKING_ID = ?";

	            PreparedStatement ps2 = con.prepareStatement(deleteQuery);

	            ps2.setString(1, bookingId);

	            int rows = ps2.executeUpdate();

	            if(rows > 0) {

	                String updateRoomQuery = "UPDATE ROOM SET IS_OCCUPIED = ? WHERE ROOM_NUMBER = ?";

	                PreparedStatement ps3 = con.prepareStatement(updateRoomQuery);

	                ps3.setString(1, "NO");

	                ps3.setString(2, roomNumber);

	                ps3.executeUpdate();

	                result = true;
	            }

	        }

	        catch(Exception e) {

	            e.printStackTrace();
	        }

	        return result;
	    }	    
	    public Booking viewBookingDetails(
	            String bookingId) {

	        Booking booking = null;

	        try {

	            Connection con =
	                    DBConnectionManager.getConnection();

	            String query =
	            "SELECT * FROM booking WHERE BOOKING_ID = ?";

	            PreparedStatement ps =
	                    con.prepareStatement(query);

	            ps.setString(1, bookingId);

	            ResultSet rs = ps.executeQuery();

	            if(rs.next()) {

	                booking = new Booking(query, query, query, 0, 0, 0, 0, null, null, query, query, query, query, query, query);

	                booking.setBookingId(rs.getString("BOOKING_ID"));

	                booking.setResidentId(rs.getString("RESIDENT_ID"));

	                booking.setResidentName(rs.getString("RESIDENT_NAME"));

	                booking.setDurationOfStay(rs.getInt("DURATION_OF_STAY"));

	                booking.setNumberOfAdults(rs.getInt("NUMBER_OF_ADULTS"));

	                booking.setNumberOfChildrenAbove12(rs.getInt("NUMBER_OF_CHILDREN_ABOVE12"));

	                booking.setNumberOfChildrenAbove5(rs.getInt("NUMBER_OF_CHILDREN_ABOVE5"));

	                booking.setCheckInDate(rs.getDate("CHECK_IN_DATE").toLocalDate());

	                booking.setCheckOutDate(rs.getDate("CHECK_OUT_DATE").toLocalDate());

	                booking.setFloornumber(rs.getString("FLOOR_NUMBER"));

	                booking.setRoomNumber(rs.getString("ROOM_NUMBER"));

	                booking.setPreferredPackage(rs.getString("PREFERRED_PACKAGE"));

	                booking.setAcAccess(rs.getString("AC_ACCESS"));

	                booking.setPoolAccess(rs.getString("POOL_ACCESS"));

	                booking.setGymAccess(rs.getString("GYM_ACCESS"));
	            }

	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }

	        return booking;
	    }
	    
	    public List<Booking> viewAllBookings() {

	        List<Booking> bookingList = new ArrayList<Booking>();

	        try {

	            Connection con = DBConnectionManager.getConnection();

	            String query = "SELECT * FROM BOOKING";

	            PreparedStatement ps = con.prepareStatement(query);

	            ResultSet rs = ps.executeQuery();

	            while(rs.next()) {

	                Booking booking = new Booking(query, query, query, 0, 0, 0, 0, null, null, query, query, query, query, query, query);

	                booking.setBookingId(rs.getString("BOOKING_ID"));

	                booking.setResidentId(rs.getString("RESIDENT_ID"));

	                booking.setResidentName(rs.getString("RESIDENT_NAME"));

	                booking.setDurationOfStay(rs.getInt("DURATION_OF_STAY"));

	                booking.setNumberOfAdults(rs.getInt("NUMBER_OF_ADULTS"));

	                booking.setNumberOfChildrenAbove12(rs.getInt("NUMBER_OF_CHILDREN_ABOVE12"));

	                booking.setNumberOfChildrenAbove5(rs.getInt("NUMBER_OF_CHILDREN_ABOVE5"));
	                
	                booking.setCheckInDate(rs.getDate("CHECK_IN_DATE").toLocalDate());

	                booking.setCheckOutDate(rs.getDate("CHECK_OUT_DATE").toLocalDate());

	                booking.setFloornumber(rs.getString("FLOOR_NUMBER"));

	                booking.setRoomNumber(rs.getString("ROOM_NUMBER"));

	                booking.setPreferredPackage(rs.getString("PREFERRED_PACKAGE"));

	                booking.setAcAccess(rs.getString("AC_ACCESS"));

	                booking.setPoolAccess(rs.getString("POOL_ACCESS"));

	                booking.setGymAccess(rs.getString("GYM_ACCESS"));

	                bookingList.add(booking);
	            }

	        }

	        catch(Exception e) {

	            e.printStackTrace();
	        }

	        return bookingList;
	    }
	    
	}