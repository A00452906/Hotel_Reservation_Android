package com.example.hotel_reservation_android;

import java.util.List;

import retrofit.Callback;
import retrofit.http.Body;
import retrofit.http.GET;
import retrofit.http.POST;

public interface ApiInterface {
    // API's endpoints
    @GET("/HotelList")
    public void getHotelsLists(Callback<List<HotelListResponse>> callback);

    @POST("/HotelBook")
    public void ConfirmBooking(@Body GuestListData data,Callback<BookHotelResponse> callback);
}
