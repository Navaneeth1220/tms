package com.cg.tms.entities;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class Booking {

    @GeneratedValue
    @Id
    private int bookingId;

    private String bookingType;
    private String description;
    private String bookingTitle;
    private LocalDate bookingDate;

    @ManyToOne(optional = false)
    private Package pack;

    @OneToOne
    private PaymentDetails payment;

    @OneToOne
    private TicketDetails ticket;


    private int userId;

   public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingType() {
        return bookingType;
    }

    public void setBookingType(String bookingType) {
        this.bookingType = bookingType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBookingTitle() {
        return bookingTitle;
    }

    public void setBookingTitle(String bookingTitle) {
        this.bookingTitle = bookingTitle;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDate bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Package getPack() {
        return pack;
    }

    public void setPack(Package pack) {
        this.pack = pack;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public PaymentDetails getPayment() {
        return payment;
    }

    public void setPayment(PaymentDetails payment) {
        this.payment = payment;
    }

    public TicketDetails getTicket() {
        return ticket;
    }

    public void setTicket(TicketDetails ticket) {
        this.ticket = ticket;
    }
}
