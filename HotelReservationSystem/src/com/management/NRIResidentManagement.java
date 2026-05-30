package com.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.NRIResident;

public class NRIResidentManagement {

    public boolean insertNRIResidentList(List<NRIResident> residentList) {

        boolean result = false;

        try {
            Connection con = DBConnectionManager.getConnection();

            String query =
                    "INSERT INTO nriresident " +
                    "(RESIDENT_ID, RESIDENT_NAME, AGE, GENDER, CONTACT_NUMBER, EMAIL, ADDRESS, " +
                    "NUMBER_OF_ADULTS, NUMBER_OF_CHILDREN_ABOVE12, NUMBER_OF_CHILDREN_ABOVE5, " +
                    "DURATION_OF_STAY, RESIDENT_TYPE, PASSPORT_NO, PASSPORT_TYPE, NATIONALITY, PURPOSEFORVISIT) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            for (NRIResident resident : residentList) {

                ps.setString(1, resident.getResidentId());
                ps.setString(2, resident.getResidentName());
                ps.setInt(3, resident.getAge());
                ps.setString(4, resident.getGender());
                ps.setLong(5, resident.getContactNumber());
                ps.setString(6, resident.getEmail());
                ps.setString(7, resident.getAddress());
                ps.setInt(8, resident.getNumberOfAdults());
                ps.setInt(9, resident.getNumberOfChildrenAbove12());
                ps.setInt(10, resident.getNumberOfChildrenAbove5());
                ps.setInt(11, resident.getDurationOfStay());
                ps.setString(12, resident.getResidentType());
                ps.setString(13, resident.getPassportNo());
                ps.setString(14, resident.getPassportType());
                ps.setString(15, resident.getNationality());
                ps.setString(16, resident.getPurposeForVisit());

                ps.executeUpdate();
            }

            result = true;

        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public boolean updateNRIResidentPhoneNumberUsingResidentId(String residentId,long newPhoneNumber) {

        boolean result = false;

        try {
            Connection con = DBConnectionManager.getConnection();

            String query ="UPDATE nriresident SET CONTACT_NUMBER = ? WHERE RESIDENT_ID = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setLong(1, newPhoneNumber);
            ps.setString(2, residentId);

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

    public boolean updateOccupancyUsingResidentId(String residentId,int adults,int above12,int above5) {

        boolean result = false;

        try {
            Connection con = DBConnectionManager.getConnection();

            String query ="UPDATE nriresident SET NUMBER_OF_ADULTS = ?, NUMBER_OF_CHILDREN_ABOVE12 = ?, NUMBER_OF_CHILDREN_ABOVE5 = ? WHERE RESIDENT_ID = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, adults);
            ps.setInt(2, above12);
            ps.setInt(3, above5);
            ps.setString(4, residentId);

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

    public NRIResident retrieveNRIResidentList(String residentId) {

        NRIResident resident = null;

        try {
            Connection con = DBConnectionManager.getConnection();

            String query ="SELECT * FROM nriresident WHERE RESIDENT_ID = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, residentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                resident = new NRIResident();

                resident.setResidentId(rs.getString("RESIDENT_ID"));
                resident.setResidentName(rs.getString("RESIDENT_NAME"));
                resident.setAge(rs.getInt("AGE"));
                resident.setGender(rs.getString("GENDER"));
                resident.setContactNumber(rs.getLong("CONTACT_NUMBER"));
                resident.setEmail(rs.getString("EMAIL"));
                resident.setAddress(rs.getString("ADDRESS"));
                resident.setNumberOfAdults(rs.getInt("NUMBER_OF_ADULTS"));
                resident.setNumberOfChildrenAbove12(rs.getInt("NUMBER_OF_CHILDREN_ABOVE12"));
                resident.setNumberOfChildrenAbove5(rs.getInt("NUMBER_OF_CHILDREN_ABOVE5"));
                resident.setDurationOfStay(rs.getInt("DURATION_OF_STAY"));
                resident.setResidentType(rs.getString("RESIDENT_TYPE"));
                resident.setPassportNo(rs.getString("PASSPORT_NO"));
                resident.setPassportType(rs.getString("PASSPORT_TYPE"));
                resident.setNationality(rs.getString("NATIONALITY"));
                resident.setPurposeForVisit(rs.getString("PURPOSEFORVISIT"));
            }

        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return resident;
    }

    public boolean deleteNRIResidentDetailsFromDB(String residentId) {

        boolean result = false;

        try {
            Connection con = DBConnectionManager.getConnection();

            String query ="DELETE FROM nriresident WHERE RESIDENT_ID = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, residentId);

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
    
    public List<NRIResident> viewAllNRIResidents() {

        List<NRIResident> residentList = new ArrayList<NRIResident>();

        try {

            Connection con = DBConnectionManager.getConnection();

            String query = "SELECT * FROM NRIRESIDENT";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                NRIResident resident = new NRIResident();

                resident.setResidentId(rs.getString("RESIDENT_ID"));

                resident.setResidentName(rs.getString("RESIDENT_NAME"));

                resident.setContactNumber(rs.getLong("CONTACT_NUMBER"));

                residentList.add(resident);
            }

        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return residentList;
    }
}