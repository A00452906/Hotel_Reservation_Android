package com.example.hotel_reservation_android;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class hotelsearch_fragment extends Fragment {
    String checkInDate, checkOutDate, numberOfGuests, guestName;
    SharedPreferences sharedPreferences;
    public static final String myPreference = "myPref";
    public static final String name = "nameKey";
    public static final String guestsCount = "guestsCount";

    //inflates the view
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.hotelsearch_layout, container, false);
        return view;
    }
    //after view is inflated set the values
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Button confirmSeacrh=view.findViewById(R.id.confirmsearch_button);
        DatePicker checkInDateDp = view.findViewById(R.id.checkin_dp);
        DatePicker checkOutDateDP = view.findViewById(R.id.checkout_dp);
        EditText guestsCountET = view.findViewById(R.id.guestcount_et);
        EditText nameET = view.findViewById(R.id.name_et);
        //TextView search_confirm_tv=view.findViewById(R.id.search_confirm_tv);
        //set up confirmsearch
        confirmSeacrh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInDate = getDateFromCalendar(checkInDateDp);
                checkOutDate = getDateFromCalendar(checkOutDateDP);
                //Get input of guests count
                numberOfGuests = guestsCountET.getText().toString();
                guestName = nameET.getText().toString();
                // Saving into shared preferences
                sharedPreferences = getActivity().getSharedPreferences(myPreference, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(name, guestName);
                editor.putString(guestsCount, numberOfGuests);
                editor.commit();
                //search_confirm_tv.setText("Dear Customer, Your check in date is " + checkInDate + ", " +
                    //    "your checkout date is " + checkOutDate + ".The number of guests are " + numberOfGuests);
                Bundle bundle = new Bundle();
                bundle.putString("check in date", checkInDate);
                bundle.putString("check out date", checkOutDate);
                bundle.putString("number of guests", numberOfGuests);


                // set Fragment class Arguments
                HotelListFragment hotelsListFragment = new HotelListFragment();
                hotelsListFragment.setArguments(bundle);

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.main_layout, hotelsListFragment);
                fragmentTransaction.remove(hotelsearch_fragment.this);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
    }
    private String getDateFromCalendar(DatePicker datePicker) {
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = simpleDateFormat.format(calendar.getTime());

        return formattedDate;
    }
}
