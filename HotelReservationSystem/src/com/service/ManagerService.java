package com.service;

import java.time.LocalDate;
import java.util.List;

import com.management.ManagerManagement;
import com.model.Booking;
import com.model.Room;

public class ManagerService {

    ManagerManagement management = new ManagerManagement();

    public Booking viewBookingDetails(String bookingId) {

        Booking booking = null;

        try {
            booking = management.viewBookingDetails(bookingId);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return booking;
    }

    public List<Room> viewAvailableRoom() {

        return management.viewAvailableRoom();
    }

    public List<Room> viewOccupiedRoom() {

        return management.viewOccupiedRoom();
    }

    public List<Room> viewAvailableRoomForParticularFloorNumber(String floorNumber) {

        return management.viewAvailableRoomForParticularFloorNumber(floorNumber);
    }

    public List<Room> viewOccupiedRoomForParticularFloorNumber(String floorNumber) {

        return management.viewOccupiedRoomForParticularFloorNumber(floorNumber);
    }

    public List<Booking> viewOccupiedRoomForParticularCheckInDate(LocalDate checkInDate) {

        return management.viewOccupiedRoomForParticularCheckInDate(checkInDate);
    }

    public List<Booking> viewOccupiedRoomForParticularCheckOutDate(LocalDate checkOutDate) {

        return management.viewOccupiedRoomForParticularCheckOutDate(checkOutDate);
    }
    
    public List<Booking> viewAllBookings() {

        return management.viewAllBookings();
    }
}