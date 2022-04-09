package com.example.hotel_reservation_android;

public class GuestDetail {
     String gender;
     String guestname;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGuestname() {
        return guestname;
    }

    public void setGuestname(String guestname) {
        this.guestname = guestname;
    }

    public GuestDetail(String gender, String guestname) {
        this.gender = gender;
        this.guestname = guestname;
    }

    public GuestDetail() {
    }

    @Override
    public String toString() {
        return "GuestDetail{" +
                "gender='" + gender + '\'' +
                ", guestname='" + guestname + '\'' +
                '}';
    }
}
