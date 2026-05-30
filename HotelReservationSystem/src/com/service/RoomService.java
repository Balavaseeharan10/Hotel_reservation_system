package com.service;

import java.util.ArrayList;
import java.util.List;

import com.management.RoomManagement;
import com.model.Room;
import com.util.ApplicationUtil;

public class RoomService {

    RoomManagement management = new RoomManagement();

    public List<Room> buildRoomList(List<String> roomRecords) {

        List<Room> roomList = new ArrayList<Room>();

        try {

            for (String data : roomRecords) {

                List<String> values = ApplicationUtil.extractDetail(data);
                
                String isOccupied = values.get(2);
                String hasAc = values.get(4);
                String hasPool = values.get(5);
                String hasGym = values.get(6);

                if (!ApplicationUtil.validateYesOrNo(isOccupied)) {
                    System.out.println("Invalid occupied status. Enter YES or NO");
                    return null;
                }

                if (!ApplicationUtil.validateYesOrNo(hasAc)) {
                    System.out.println("Invalid AC value. Enter YES or NO");
                    return null;
                }

                if (!ApplicationUtil.validateYesOrNo(hasPool)) {
                    System.out.println("Invalid Pool value. Enter YES or NO");
                    return null;
                }

                if (!ApplicationUtil.validateYesOrNo(hasGym)) {
                    System.out.println("Invalid Gym value. Enter YES or NO");
                    return null;
                }

                Room room = new Room(data, data, data, 0, data, data, data);

                room.setRoomNumber(values.get(0));

                room.setFloorNumber(values.get(1));

                room.setIsOccupied("NO");

                room.setMaxOccupancy(Integer.parseInt(values.get(2)));

                room.setHasAc(values.get(3));

                room.setHasSwimmingPoolAccess(values.get(4));

                room.setHasGymAccess(values.get(5));
                
                roomList.add(room);
            }

        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return roomList;
    }

    public boolean addRoomList(List<Room> roomList) {

        boolean result = false;

        try {
        	if (roomList == null) {
        	    return false;
        	}
            result = management.insertRoomList(roomList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

   
    public boolean deleteRoomDetailsFromDBUsingFloorNumber(String floorNumber) {

        boolean result = false;

        try {
            result = management.deleteRoomDetailsFromDBUsingFloorNumber(floorNumber);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean deleteRoomDetailsFromDBUsingRoomNumber(String roomNumber) {

        boolean result = false;

        try {
            result = management.deleteRoomDetailsFromDBUsingRoomNumber(roomNumber);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    
    public List<Room> viewAllRooms() {
        return management.viewAllRooms();
    }
}