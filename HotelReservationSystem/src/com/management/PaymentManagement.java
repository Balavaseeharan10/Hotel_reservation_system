package com.management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Payment;

public class PaymentManagement {

    public boolean insertPaymentList(List<Payment> paymentList) {

        boolean result = false;

        try {
            Connection con = DBConnectionManager.getConnection();

            String query =
                    "INSERT INTO payment " +
                    "(PAYMENT_ID, BOOKING_ID, RESIDENT_NAME, FLOOR_NUMBER, ROOM_NUMBER, " +
                    "CHECK_IN_DATE, CHECK_OUT_DATE, PAYMENT_DATE, PAYMENT_METHOD, BILL_AMOUNT) " +
                    "VALUES (?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(query);

            for (Payment payment : paymentList) {

                ps.setString(1, payment.getPaymentId());
                ps.setString(2, payment.getBookingId());
                ps.setString(3, payment.getResidentName());
                ps.setString(4, payment.getFloorNumber());
                ps.setString(5, payment.getRoomNumber());
                ps.setDate(6, java.sql.Date.valueOf(payment.getCheckInDate()));
                ps.setDate(7, java.sql.Date.valueOf(payment.getCheckOutDate()));
                ps.setDate(8, java.sql.Date.valueOf(payment.getPaymentDate()));
                ps.setString(9, payment.getPaymentMethod());
                ps.setDouble(10, payment.getBillAmount());

                ps.executeUpdate();
            }

            result = true;

        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public Payment viewPaymentDetails(String paymentId) {

        Payment payment = null;

        try {
            Connection con = DBConnectionManager.getConnection();

            String query ="SELECT * FROM payment WHERE PAYMENT_ID = ?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, paymentId);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                payment = new Payment();

                payment.setPaymentId(rs.getString("PAYMENT_ID"));
                payment.setBookingId(rs.getString("BOOKING_ID"));
                payment.setResidentName(rs.getString("RESIDENT_NAME"));
                payment.setFloorNumber(rs.getString("FLOOR_NUMBER"));
                payment.setRoomNumber(rs.getString("ROOM_NUMBER"));
                payment.setCheckInDate(rs.getDate("CHECK_IN_DATE").toLocalDate());
                payment.setCheckOutDate(rs.getDate("CHECK_OUT_DATE").toLocalDate());
                payment.setPaymentDate(rs.getDate("PAYMENT_DATE").toLocalDate());
                payment.setPaymentMethod(rs.getString("PAYMENT_METHOD"));
                payment.setBillAmount(rs.getDouble("BILL_AMOUNT"));
            }

        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return payment;
    }
    
    public List<Payment> viewAllPayments() {

        List<Payment> paymentList = new ArrayList<Payment>();

        try {

            Connection con = DBConnectionManager.getConnection();

            String query = "SELECT * FROM PAYMENT";

            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                Payment payment = new Payment();

                payment.setPaymentId(rs.getString("PAYMENT_ID"));

                payment.setBookingId(rs.getString("BOOKING_ID"));

                payment.setResidentName(rs.getString("RESIDENT_NAME"));

                payment.setFloorNumber(rs.getString("FLOOR_NUMBER"));

                payment.setRoomNumber(rs.getString("ROOM_NUMBER"));

                payment.setCheckInDate(rs.getDate("CHECK_IN_DATE").toLocalDate());

                payment.setCheckOutDate(rs.getDate("CHECK_OUT_DATE").toLocalDate());

                payment.setPaymentDate(rs.getDate("PAYMENT_DATE").toLocalDate());

                payment.setPaymentMethod(rs.getString("PAYMENT_METHOD"));

                payment.setBillAmount(rs.getDouble("BILL_AMOUNT"));

                paymentList.add(payment);
            }

        }

        catch(Exception e) {

            e.printStackTrace();
        }

        return paymentList;
    }
}