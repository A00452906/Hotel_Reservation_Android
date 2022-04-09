package com.example.hotel_reservation_android;
import retrofit.RestAdapter;

public class Api {
    public static ApiInterface getClient() {

        // change your base URL
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint("https://1c7d-134-41-196-67.ngrok.io" +
                        "") //Set the Root URL
                .build(); //Finally building the adapter
        //Creating obor our interface
        ApiInterface api = adapter.create(ApiInterface.class);
        return api; // return the APIInterface object
    }
}
