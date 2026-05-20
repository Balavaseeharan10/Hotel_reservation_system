package com.service;

import java.util.ArrayList;
import java.util.List;
import com.dao.RoomDAO;
import com.model.Room;
import com.util.ApplicationUtil;

public class RoomService {
   RoomDAO dao= new RoomDAO();
   
   public List<Room>buildRoomList(List<String> roomRecords)
   {
	   List<Room> roomList = new ArrayList<>();
	   for(String data : roomRecords)
	   {
		   List<String> values=ApplicationUtil.extractDetails(data);
		   Room room=new Room();
		   room.setRoomNumber(values.get(0));
		   room.setFloorNumber(values.get(1));
		   room.setIsOccupied(values.get(2));
		   room.setMaxOccupancy(Integer.parseInt(values.get(3)));
		   room.setHasAc(values.get(4));
		   room.setHasSwimmingPoolAccess(values.get(5));
		   room.setHasGymAccess(values.get(6));
		   
		   roomList.add(room);
	   }
	   return roomList;
   }
   public boolean updateOccupiedStatus(String roomNumber,String status)
   {
	   return dao.updateOccupiedStatusUsingRoomNumber(roomNumber,status);
   }
   
   public boolean deleteRoomDetailsFromDBUsingFloorNumber(String roomNumber)
   {
	   return dao.deleteRoomDetailsFromDBUsingFloorNumber(floorNumber);
   }
   public boolean deleteRoomDetailsFromDBUsingRoomNumber(String roomNumber)
   {
	   return dao.deleteRoomDetailsFromDBUsingRoomNumber(roomNumber);
   }
}
