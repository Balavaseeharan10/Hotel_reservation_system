package com.service;
import java.util.*;

import com.management.RIResidentManagement;
import com.model.RIResident;
import com.util.ApplicationUtil;

public class RIResidentService {
	public List<RIResident> buildRIResidentList(String input) {

	    List<String> details = ApplicationUtil.extractDetail(input);

	    RIResident resident = new RIResident(input, input, 0, input, 0, input, input, 0, 0, 0, 0, input, 0);

	    resident.setResidentId(generateId());
	    resident.setResidentName(details.get(0));
	    resident.setAge(Integer.parseInt(details.get(1)));
	    resident.setGender(details.get(2));
	    resident.setContactNumber(Long.parseLong(details.get(3)));

	    List<RIResident> residentList =new ArrayList<RIResident>();

	    residentList.add(resident);

	    return residentList;
	    
	}
	
	 public boolean addRIResidentList(String input) {

	        List<RIResident> residentList =buildRIResidentList(input);

	        RIResidentManagement management=new RIResidentManagement();

	        boolean result =management.insertRIResidentList(residentList);

	        return result;
	    }
	 
	 public String generateId() {

		    String id = "RI" + System.currentTimeMillis();

		    return id;
		}
	 
	 public boolean updateRIResidentPhoneNumberUsingResidentId(String residentId,long newPhoneNumber) {

		    RIResidentManagement management = new RIResidentManagement();

		    boolean result =management.updateRIResidentPhoneNumberUsingResidentId(residentId,newPhoneNumber);

		    return result;
		}
	 
	 
	 public boolean updateOccupancyUsingResidentId( String residentId,int adults,int above12,int above5) {

		    RIResidentManagement management =new RIResidentManagement();

		    boolean result =management.updateOccupancyUsingResidentId(residentId,adults,above12,above5);

		    return result;
		}
	 
	 public RIResident retreiveRIResidentDetails(String residentId) {

		    RIResidentManagement management =new RIResidentManagement();

		    RIResident resident = management.retrieveRIResidentList(residentId);

		    return resident;
		}
	 
	 public boolean deleteRIResidentDetailsFromDB(String residentId) {

		    RIResidentManagement management = new RIResidentManagement();

		    boolean result = management.deleteRIResidentDetailsFromDB(residentId);

		    return result;
		}
	 
	 
}
