package com.example.hotel_reservation_android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HotelAdapter extends RecyclerView.Adapter<HotelAdapter.ViewHolder> {
    private List<HotelListResponse> hotelListData;
    private LayoutInflater layoutInflater;
    private ItemClickListener clickListener;

    //Data gets passed in the constructor
    HotelAdapter(Context context, List<HotelListResponse> hotelListData) {
        this.layoutInflater = LayoutInflater.from(context);
        this.hotelListData = hotelListData;
    }

    @NonNull
    @Override
    public HotelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.hotellist_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HotelAdapter.ViewHolder holder, int position) {
        String hotelName = hotelListData.get(position).getHotel_name();
        String hotelPrice = hotelListData.get(position).getRoom_price().toString();
//        String hotelAvailability = hotelListData.get(position).getAvailability();
        String hotelAvailability = "true";

        // set up the text
        holder.hotelName.setText(hotelName);
//        holder.hotelAvailability.setText(hotelAvailability);
        holder.hotelPrice.setText(hotelPrice);
    }

    @Override
    public int getItemCount() {
        if (hotelListData != null) {
            return hotelListData.size();
        } else {
            return 0;
        }
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView hotelName, hotelPrice, hotelAvailability;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            hotelName = itemView.findViewById(R.id.hotel_name_text_view);
            hotelPrice = itemView.findViewById(R.id.price_text_view);
            //hotelAvailability = itemView.findViewById(R.id.availability_text_view);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (clickListener != null)
                clickListener.onClick(view,getAbsoluteAdapterPosition());
        }
    }
}
