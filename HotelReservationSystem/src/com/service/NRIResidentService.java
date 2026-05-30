package com.service;

import java.util.ArrayList;
import java.util.List;

import com.management.NRIResidentManagement;
import com.model.NRIResident;
import com.util.ApplicationUtil;

public class NRIResidentService {

    NRIResidentManagement management = new NRIResidentManagement();

    public List<NRIResident> buildNRIResidentList(String input) {

        List<NRIResident> residentList =new ArrayList<NRIResident>();

        try {
            List<String> details =ApplicationUtil.extractDetail(input);
            
            String phone = details.get(3);
            String email = details.get(4);

            if (!ApplicationUtil.validatePhone(phone)) {

                System.out.println("Invalid Phone Number");

                return null;
            }

            if (!ApplicationUtil.validateEmail(email)) {

                System.out.println("Invalid Email");

                return null;
            }

            NRIResident resident = new NRIResident();

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
            resident.setDurationOfStay(Integer.parseInt(details.get(9)));
            resident.setResidentType(details.get(10));
            resident.setPassportNo(details.get(11));
            resident.setPassportType(details.get(12));
            resident.setNationality(details.get(13));
            resident.setPurposeForVisit(details.get(14));

            residentList.add(resident);

        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return residentList;
    }

    public boolean addNRIResidentList(String input) {

        List<NRIResident> residentList =buildNRIResidentList(input);

        boolean result = false;

        try {
        	if(residentList == null) {

        	    return false;
        	}
            result =management.insertNRIResidentList(residentList);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public String generateId() {
        int random = (int)(Math.random() * 10000);
        return "NRI" + random;
    }

    public boolean updateNRIResidentPhoneNumberUsingResidentId(String residentId,long newPhoneNumber) {

        return management.updateNRIResidentPhoneNumberUsingResidentId(residentId,newPhoneNumber);
    }

    public boolean updateOccupancyUsingResidentId(String residentId,int adults,int above12,int above5) {

        return management.updateOccupancyUsingResidentId(residentId,adults,above12,above5);
    }

    public NRIResident retreiveNRIResidentDetails(String residentId) {

        return management.retrieveNRIResidentList(residentId);
    }

    public boolean deleteNRIResidentDetailsFromDB(String residentId) {

        return management.deleteNRIResidentDetailsFromDB(residentId);
    }
    
    public List<NRIResident> viewAllNRIResidents() {

        return management.viewAllNRIResidents();
    }
}