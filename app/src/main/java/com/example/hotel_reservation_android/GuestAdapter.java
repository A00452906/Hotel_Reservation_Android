package com.example.hotel_reservation_android;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class GuestAdapter extends RecyclerView.Adapter<GuestAdapter.ViewHolder> {
    private List<GuestDetail> GuestDetail;
    private LayoutInflater layoutInflater;
    private ItemClickListener clickListener;

    //Data gets passed in the constructor
    GuestAdapter(Context context, List<GuestDetail> GuestDetail) {
        this.layoutInflater = LayoutInflater.from(context);
        this.GuestDetail = GuestDetail;
    }

    @NonNull
    @Override
    public GuestAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.guestdetails_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuestAdapter.ViewHolder holder, int position) {
        GuestDetail guestDetail = GuestDetail.get(position);
//        String hotelName = hotelListData.get(position).getHotel_name();
//        String hotelPrice = hotelListData.get(position).getRoom_price().toString();
//        String hotelAvailability = hotelListData.get(position).getAvailability();
//        String hotelAvailability = "true";
//        // set up the text
//        holder.hotelName.setText(hotelName);
//        holder.hotelAvailability.setText(hotelAvailability);
//        holder.hotelPrice.setText(hotelPrice);
        holder.GuestName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                guestDetail.setGuestname(holder.GuestName.getText().toString());
            }
        });
        holder.Gender.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
            guestDetail.setGender(holder.Gender.getText().toString());
            }
        });
        guestDetail.setGuestname(holder.GuestName.getText().toString());
        guestDetail.setGender(holder.Gender.getText().toString());
    }

    @Override
    public int getItemCount() {

        if (GuestDetail != null) {
            return GuestDetail.size();
        } else {
            return 0;
        }
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //TextView hotelName, hotelPrice, hotelAvailability;
        EditText GuestName,Gender;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
//            hotelName = itemView.findViewById(R.id.hotel_name_text_view);
//            hotelPrice = itemView.findViewById(R.id.price_text_view);
//            hotelAvailability = itemView.findViewById(R.id.availability_text_view);
            GuestName=itemView.findViewById(R.id.guest_name_ET);
            Gender=itemView.findViewById(R.id.guest_Gender_ET);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            if (clickListener != null)
                clickListener.onClick(view,getAbsoluteAdapterPosition());
        }
    }
}
