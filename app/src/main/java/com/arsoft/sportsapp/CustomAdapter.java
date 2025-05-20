package com.arsoft.sportsapp;


import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.SportsViewHolder> {

    private List<Sport> sportList;
    public ItemClickListener clickListener;

    public void setClickListener(ItemClickListener clickListener){
        this.clickListener = clickListener;
    }


    public CustomAdapter(List<Sport> sportList) {
        this.sportList = sportList;
    }


    @NonNull
    @Override
    public SportsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflating the layout for each item in the recyclerView

        View itemView  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item_layout,
                        parent,
                        false
                );





        return new SportsViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull SportsViewHolder holder, int position) {

        // Called for each item in the list and is responsible fr
        // binding the data from the Sport object ot the views
        // within the 'SportsViewHolder'
        Sport sport = sportList.get(position);
        holder.textView.setText(sport.getSportName());
        holder.imageView.setImageResource(sport.getSportImg());




    }

    @Override
    public int getItemCount() {
        return sportList.size();
    }


    public class SportsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // Holds the references to the views within the item layout

        TextView textView;
        ImageView imageView;


        public SportsViewHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.textViewCard);
            imageView = itemView.findViewById(R.id.imageViewCard);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (clickListener != null ){
                clickListener.onCLick(v,getAdapterPosition());
            }

        }
    }

}
