package com.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.model.Booking;
import com.model.Room;

public class ManagerManagement {

    public Booking viewBookingDetails(String bookingId) {

        Booking booking = null;

        try {
            Connection con = DBConnectionManager.getConnection();

            String query = "SELECT * FROM booking WHERE BOOKING_ID = ?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, bookingId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {booking = new Booking(query, query, query, 0, 0, 0, 0, null, null, query, query, query, query, query, query);

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

    public List<Room> viewAvailableRoom() {

        List<Room> roomList = new ArrayList<Room>();

        try {
            Connection con = DBConnectionManager.getConnection();

            String query ="SELECT * FROM room WHERE IS_OCCUPIED = 'NO'";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Room room = new Room(query, query, query, 0, query, query, query);

                room.setRoomNumber(rs.getString("ROOM_NUMBER"));
                room.setFloorNumber(rs.getString("FLOOR_NUMBER"));
                room.setIsOccupied(rs.getString("IS_OCCUPIED"));
                room.setMaxOccupancy(rs.getInt("MAX_OCCUPANCY"));
                room.setHasAc(rs.getString("HAS_AC"));
                room.setHasSwimmingPoolAccess(rs.getString("HAS_SWIMMING_POOL_ACCESS"));
                room.setHasGymAccess(rs.getString("HAS_GYM_ACCESS"));

                roomList.add(room);
            }

        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return roomList;
    }

    public List<Room> viewOccupiedRoom() {

        List<Room> roomList = new ArrayList<Room>();

        try {
            Connection con = DBConnectionManager.getConnection();

            String query ="SELECT * FROM room WHERE IS_OCCUPIED = 'YES'";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Room room = new Room(query, query, query, 0, query, query, query);

                room.setRoomNumber(rs.getString("ROOM_NUMBER"));
                room.setFloorNumber(rs.getString("FLOOR_NUMBER"));
                room.setIsOccupied(rs.getString("IS_OCCUPIED"));
                room.setMaxOccupancy(rs.getInt("MAX_OCCUPANCY"));
                room.setHasAc(rs.getString("HAS_AC"));
                room.setHasSwimmingPoolAccess(rs.getString("HAS_SWIMMING_POOL_ACCESS"));
                room.setHasGymAccess(rs.getString("HAS_GYM_ACCESS"));

                roomList.add(room);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return roomList;
    }

    public List<Room> viewAvailableRoomForParticularFloorNumber(String floorNumber) {

        List<Room> roomList = new ArrayList<Room>();

        try {
            Connection con = DBConnectionManager.getConnection();

            String query ="SELECT * FROM room WHERE FLOOR_NUMBER = ? AND IS_OCCUPIED = 'NO'";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, floorNumber);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Room room = new Room(query, query, query, 0, query, query, query);

                room.setRoomNumber(rs.getString("ROOM_NUMBER"));
                room.setFloorNumber(rs.getString("FLOOR_NUMBER"));
                room.setIsOccupied(rs.getString("IS_OCCUPIED"));
                room.setMaxOccupancy(rs.getInt("MAX_OCCUPANCY"));
                room.setHasAc(rs.getString("HAS_AC"));
                room.setHasSwimmingPoolAccess(rs.getString("HAS_SWIMMING_POOL_ACCESS"));
                room.setHasGymAccess(rs.getString("HAS_GYM_ACCESS"));

                roomList.add(room);
            }

        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return roomList;
    }

    public List<Room> viewOccupiedRoomForParticularFloorNumber(String floorNumber) {

        List<Room> roomList = new ArrayList<Room>();

        try {
            Connection con = DBConnectionManager.getConnection();

            String query ="SELECT * FROM room WHERE FLOOR_NUMBER = ? AND IS_OCCUPIED = 'YES'";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, floorNumber);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Room room = new Room(query, query, query, 0, query, query, query);

                room.setRoomNumber(rs.getString("ROOM_NUMBER"));
                room.setFloorNumber(rs.getString("FLOOR_NUMBER"));
                room.setIsOccupied(rs.getString("IS_OCCUPIED"));
                room.setMaxOccupancy(rs.getInt("MAX_OCCUPANCY"));
                room.setHasAc(rs.getString("HAS_AC"));
                room.setHasSwimmingPoolAccess(rs.getString("HAS_SWIMMING_POOL_ACCESS"));
                room.setHasGymAccess(rs.getString("HAS_GYM_ACCESS"));

                roomList.add(room);
            }

        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return roomList;
    }

    public List<Booking> viewOccupiedRoomForParticularCheckInDate(LocalDate checkInDate) {

        List<Booking> bookingList = new ArrayList<Booking>();

        try {
            Connection con = DBConnectionManager.getConnection();

            String query ="SELECT * FROM booking WHERE CHECK_IN_DATE = ?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setDate(1, java.sql.Date.valueOf(checkInDate));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Booking booking = new Booking(query, query, query, 0, 0, 0, 0, checkInDate, checkInDate, query, query, query, query, query, query);

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
        catch (Exception e) {
            e.printStackTrace();
        }

        return bookingList;
    }

    public List<Booking> viewOccupiedRoomForParticularCheckOutDate(LocalDate checkOutDate) {

        List<Booking> bookingList = new ArrayList<Booking>();

        try {
            Connection con = DBConnectionManager.getConnection();

            String query ="SELECT * FROM booking WHERE CHECK_OUT_DATE = ?";

            PreparedStatement ps = con.prepareStatement(query);
            ps.setDate(1, java.sql.Date.valueOf(checkOutDate));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Booking booking = new Booking(query, query, query, 0, 0, 0, 0, checkOutDate, checkOutDate, query, query, query, query, query, query);

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
        catch (Exception e) {
            e.printStackTrace();
        }

        return bookingList;
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

                booking.setResidentName(rs.getString("RESIDENT_NAME"));

                bookingList.add(booking);
            }

        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return bookingList;
    }
    }
