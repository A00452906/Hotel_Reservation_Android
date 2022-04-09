package com.example.hotel_reservation_android;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class guestDetailsFragment extends Fragment {
    View view;
    List<GuestDetail> GuestDetail=new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.guestdetails_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView hotelRecapTextView = view.findViewById(R.id.guest_details_tv);
        Button submitDetails = view.findViewById(R.id.book_button);
        String hotelName = getArguments().getString("hotel name");
        String hotelPrice = getArguments().getString("hotel price");
        String hotelAvailability = getArguments().getString("hotel availability");
        Integer numberofguests = Integer.valueOf(getArguments().getString("number of guests"));
        hotelRecapTextView.setText("You have selected " +hotelName+ ". The cost will be $ "+hotelPrice+ " and availability is " +hotelAvailability);
        for (int i=0;i<numberofguests;i++)
        {

            GuestDetail.add(new GuestDetail());
        }
        setupRecyclerView();

        submitDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("test","**********");
                Log.d("test", String.valueOf(GuestDetail.size()));
               // Log.d("test",GuestDetail.get(0).getName());
              //  System.out.println(GuestDetail.get(0).getName());

                GuestListData data= new GuestListData();

                //set all the values that need to be sent
                data.setHotelid(1);
                data.setNumberofrooms(2);
                data.setCheckin("2022-03-07");
                data.setCheckout("2022-03-19");
                data.setNumberofdays(2);
                data.setGuest(GuestDetail);
                BookHotel(data);
            }
        });

    }

    public void BookHotel(GuestListData data){
        Api.getClient().ConfirmBooking(data, new Callback<BookHotelResponse>() {

            @Override
            public void success(BookHotelResponse s, Response response) {
                System.out.println("inside");
                Toast.makeText(getActivity(), s.getMessage(), Toast.LENGTH_LONG).show();

            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(getActivity(), error.toString(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setupRecyclerView() {
     //   progressBar.setVisibility(View.GONE);
        RecyclerView recyclerView = view.findViewById(R.id.guest_list_recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        GuestAdapter guestListAdapter = new GuestAdapter(getActivity(), GuestDetail);
        recyclerView.setAdapter(guestListAdapter);

        //Bind the click listener
     //   guestListAdapter.setClickListener(this);
    }
}
