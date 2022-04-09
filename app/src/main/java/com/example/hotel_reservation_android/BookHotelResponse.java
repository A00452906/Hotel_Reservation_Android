package com.example.hotel_reservation_android;

public class BookHotelResponse {
    String message;

    public BookHotelResponse(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
