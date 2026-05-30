package com.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.management.PaymentManagement;
import com.model.Payment;
import com.util.ApplicationUtil;

public class PaymentService {

    PaymentManagement management = new PaymentManagement();

    public List<Payment> buildPaymentList(List<String> paymentRecords) {

        List<Payment> paymentList = new ArrayList<Payment>();

        try {
            for (String data : paymentRecords) {

                List<String> values = ApplicationUtil.extractDetail(data);

                Payment payment = new Payment();

                payment.setPaymentId(generateId());
                payment.setBookingId(values.get(0));
                payment.setResidentName(values.get(1));
                payment.setFloorNumber(values.get(2));
                payment.setRoomNumber(values.get(3));
                payment.setCheckInDate(LocalDate.parse(values.get(4)));
                payment.setCheckOutDate(LocalDate.parse(values.get(5)));
                payment.setPaymentDate(LocalDate.parse(values.get(6)));
                payment.setPaymentMethod(values.get(7));
                payment.setBillAmount(Double.parseDouble(values.get(8)));

                paymentList.add(payment);
            }

        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return paymentList;
    }

    public boolean addPaymentList(List<Payment> paymentList) {

        boolean result = false;

        try {
            result = management.insertPaymentList(paymentList);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public String generateId() {
    	    int random = (int)(Math.random() * 10000);

    	    return "P" + random;
    	}

    public Payment viewPaymentDetails(String paymentId) {

        Payment payment = null;

        try {
            payment = management.viewPaymentDetails(paymentId);
        } 
        catch (Exception e) {
            e.printStackTrace();
        }

        return payment;
    }
    
    public List<Payment> viewAllPayments() {

        return management.viewAllPayments();
    }
}