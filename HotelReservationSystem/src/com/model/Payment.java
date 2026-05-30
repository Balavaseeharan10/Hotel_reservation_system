package com.model;

import java.time.LocalDate;

public class Payment {

    private String paymentId;
    private String bookingId;
    private String residentName;
    private String floorNumber;
    private String roomNumber;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private LocalDate paymentDate;
    private String paymentMethod;
    private double billAmount;

    public Payment() {
    }

    public Payment(String paymentId, String bookingId, String residentName,
                   String floorNumber, String roomNumber,
                   LocalDate checkInDate, LocalDate checkOutDate,
                   LocalDate paymentDate, String paymentMethod,
                   double billAmount) {
        this.paymentId = paymentId;
        this.bookingId = bookingId;
        this.residentName = residentName;
        this.floorNumber = floorNumber;
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.paymentDate = paymentDate;
        this.paymentMethod = paymentMethod;
        this.billAmount = billAmount;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public String getResidentName() {
        return residentName;
    }

    public void setResidentName(String residentName) {
        this.residentName = residentName;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public double getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(double billAmount) {
        this.billAmount = billAmount;
    }
}