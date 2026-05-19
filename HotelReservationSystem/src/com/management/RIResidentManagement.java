package com.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.model.RIResident;
import com.util.ApplicationUtil;

public class RIResidentManagement {

    public boolean insertRIResidentList(List<RIResident> residentList) {

        boolean result = false;

        try {
            Connection con = DBConnectionManager.getConnection();

            String query = "INSERT INTO riresident VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            for (RIResident resident : residentList) {

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
                ps.setLong(13, resident.getIdproofAadharno());

                ps.executeUpdate();
            }

            result = true;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
}