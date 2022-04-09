package com.example.hotel_reservation_android;

public class HotelListResponse {
    Integer hotel_rating;
    Integer hotel_id;
    Integer room_price;
    String hotel_name;
    String hotel_location;

    public HotelListResponse(Integer hotel_rating, Integer hotel_id, Integer room_price, String hotel_name, String hotel_location) {
        this.hotel_rating = hotel_rating;
        this.hotel_id = hotel_id;
        this.room_price = room_price;
        this.hotel_name = hotel_name;
        this.hotel_location = hotel_location;
    }

    public HotelListResponse() {
    }

    public Integer getHotel_rating() {
        return hotel_rating;
    }

    public void setHotel_rating(Integer hotel_rating) {
        this.hotel_rating = hotel_rating;
    }

    public Integer getHotel_id() {
        return hotel_id;
    }

    public void setHotel_id(Integer hotel_id) {
        this.hotel_id = hotel_id;
    }

    public Integer getRoom_price() {
        return room_price;
    }

    public void setRoom_price(Integer room_price) {
        this.room_price = room_price;
    }

    public String getHotel_name() {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name) {
        this.hotel_name = hotel_name;
    }

    public String getHotel_location() {
        return hotel_location;
    }

    public void setHotel_location(String hotel_location) {
        this.hotel_location = hotel_location;
    }
}
