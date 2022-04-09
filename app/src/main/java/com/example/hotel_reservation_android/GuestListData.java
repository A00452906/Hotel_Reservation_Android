package com.example.hotel_reservation_android;

import java.util.List;

public class GuestListData {
    Integer hotelid;
    Integer numberofrooms;
    Integer numberofdays;
    String checkin;
    String checkout;
    List<GuestDetail> guest;

    public GuestListData() {
    }

    public GuestListData(Integer hotelid, Integer numberofrooms, Integer numberofdays, String checkin, String checkout, List<GuestDetail> guest) {
        this.hotelid = hotelid;
        this.numberofrooms = numberofrooms;
        this.numberofdays = numberofdays;
        this.checkin = checkin;
        this.checkout = checkout;
        this.guest = guest;
    }

    public Integer getHotelid() {
        return hotelid;
    }

    public void setHotelid(Integer hotelid) {
        this.hotelid = hotelid;
    }

    public Integer getNumberofrooms() {
        return numberofrooms;
    }

    public void setNumberofrooms(Integer numberofrooms) {
        this.numberofrooms = numberofrooms;
    }

    public Integer getNumberofdays() {
        return numberofdays;
    }

    public void setNumberofdays(Integer numberofdays) {
        this.numberofdays = numberofdays;
    }

    public String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }

    public List<GuestDetail> getGuest() {
        return guest;
    }

    public void setGuest(List<GuestDetail> guest) {
        this.guest = guest;
    }

    @Override
    public String toString() {
        return "GuestListData{" +
                "hotelid=" + hotelid +
                ", numberofrooms=" + numberofrooms +
                ", numberofdays=" + numberofdays +
                ", checkin='" + checkin + '\'' +
                ", checkout='" + checkout + '\'' +
                ", guest=" + guest +
                '}';
    }
}