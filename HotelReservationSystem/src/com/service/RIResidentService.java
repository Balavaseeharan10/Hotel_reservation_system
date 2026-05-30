package com.service;
import java.util.*;

import com.management.RIResidentManagement;
import com.model.RIResident;
import com.util.ApplicationUtil;

public class RIResidentService {
	public List<RIResident> buildRIResidentList(String input) {

	    List<String> details = ApplicationUtil.extractDetail(input);
	    
	    
	    String phone = details.get(3);
	    String email = details.get(4);
	    String aadhar = details.get(11);

	    if (!ApplicationUtil.validatePhone(phone)) {
	        System.out.println("Invalid phone number");
	        return null;
	    }

	    if (!ApplicationUtil.validateEmail(email)) {
	        System.out.println("Invalid email");
	        return null;
	    }

	    if (!ApplicationUtil.validateAadhar(aadhar)) {
	        System.out.println("Invalid Aadhar number");
	        return null;
	    }
	    
	    RIResident resident = new RIResident(input, input, 0, input, 0, input, input, 0, 0, 0, 0, input, 0);
	    
	    resident.setResidentId(generateId());
	    
	    resident.setResidentName(details.get(0));

	    resident.setAge(Integer.parseInt(details.get(1)));

	    resident.setGender(details.get(2));

	    resident.setContactNumber(Long.parseLong(details.get(3)));

	    resident.setEmail(details.get(4));

	    resident.setAddress(details.get(5));

	    resident.setNumberOfAdults(Integer.parseInt(details.get(6)));

	    resident.setNumberOfChildrenAbove12(Integer.parseInt(details.get(7)));

	    resident.setNumberOfChildrenAbove5(Integer.parseInt(details.get(8)));

	    resident.setDurationOfStay( Integer.parseInt(details.get(9)));

	    resident.setResidentType(details.get(10));

	    resident.setIdproofAadharno(Long.parseLong(details.get(11)));
	    
	    List<RIResident> residentList =new ArrayList<RIResident>();

	    residentList.add(resident);

	    return residentList;
	    
	}
	
	 public boolean addRIResidentList(String input) {

	        List<RIResident> residentList =buildRIResidentList(input);
	        
	        if (residentList == null) {
	            return false;
	        }

	        RIResidentManagement management=new RIResidentManagement();

	        boolean result =management.insertRIResidentList(residentList);

	        return result;
	    }
	 
	 public String generateId() {

		    int random =(int)(Math.random() * 1000);

		    return "RI" + random;
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
	 
	 public List<RIResident> viewAllRIResidents() {

		    RIResidentManagement management =new RIResidentManagement();

		    return management.viewAllRIResidents();
		}
	 
}
