package com.example.recyclerview.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.recyclerview.R;
import com.example.recyclerview.RecyclerViewHolder;
import com.example.recyclerview.model.Data;

import java.util.Collections;
import java.util.List;


//Requires a ViewHolder for caching views
public class CustomRecyclerAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<Data> mData = Collections.emptyList();
    private int itemLayout;

    public CustomRecyclerAdapter(List<Data> mData, int itemLayout) {
        this.mData = mData;
        this.itemLayout = itemLayout;
        // Pass context or other static stuff that will be needed.
    }

    public void updateList(List<Data> data) {
        mData = data;
        notifyDataSetChanged();
    }

    //Numbers of data items
    @Override
    public int getItemCount() {
        return mData.size();
    }

    //gets the ViewHolder used for the item at given position
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int position) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.list_item, viewGroup, false);
        return new RecyclerViewHolder(itemView);
    }

    //is called when views need to be created from given ViewHolder.
    @Override
    public void onBindViewHolder(RecyclerViewHolder viewHolder, int position) {
        viewHolder.title.setText(mData.get(position).text);
        viewHolder.icon.setBackgroundColor(Color.parseColor(mData.get(position).color));
    }

    public void addItem(int position, Data data) {
        mData.add(position, data);
        notifyItemInserted(position);
    }

    public void removeItem(int position) {
        mData.remove(position);
        notifyItemRemoved(position);
    }
}
