package com.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Room;

public class RoomManagement {

    public boolean insertRoomList(List<Room> roomList) {

        boolean result = false;

        try {
            Connection con = DBConnectionManager.getConnection();

            String query =
                    "INSERT INTO room " +
                    "(ROOM_NUMBER, FLOOR_NUMBER, IS_OCCUPIED, MAX_OCCUPANCY, HAS_AC, HAS_SWIMMING_POOL_ACCESS, HAS_GYM_ACCESS) " +
                    "VALUES (?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            for (Room room : roomList) {

                ps.setString(1, room.getRoomNumber());
                ps.setString(2, room.getFloorNumber());
                ps.setString(3, room.getIsOccupied());
                ps.setInt(4, room.getMaxOccupancy());
                ps.setString(5, room.getHasAc());
                ps.setString(6, room.getHasSwimmingPoolAccess());
                ps.setString(7, room.getHasGymAccess());

                ps.executeUpdate();
            }

            result = true;

        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

   

    public boolean deleteRoomDetailsFromDBUsingFloorNumber(String floorNumber) {

        boolean result = false;

        try {
            Connection con = DBConnectionManager.getConnection();

            String query ="DELETE FROM room WHERE FLOOR_NUMBER = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, floorNumber);

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

    public boolean deleteRoomDetailsFromDBUsingRoomNumber(String roomNumber) {

        boolean result = false;

        try {
            Connection con = DBConnectionManager.getConnection();

            String query ="DELETE FROM room WHERE ROOM_NUMBER = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, roomNumber);

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
    
    public List<Room> viewAllRooms() {

        List<Room> roomList = new ArrayList<Room>();

        try {
            Connection con = DBConnectionManager.getConnection();

            String query = "SELECT * FROM room";

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
}