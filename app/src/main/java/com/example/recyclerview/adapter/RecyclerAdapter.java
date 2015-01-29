package com.example.recyclerview.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.recyclerview.R;
import com.example.recyclerview.model.Data;

import java.util.ArrayList;

/**
 * Created by JonathanAxel on 26/01/15.
 */
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<Data> datos;
    private int itemLayout;

    public RecyclerAdapter(ArrayList<Data> datos, int itemLayout) {
        this.datos = datos;
        this.itemLayout = itemLayout;
    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {

        Data data = datos.get(position);

        holder.title.setText(data.getText());
        holder.icon.setBackgroundColor(Color.parseColor("BLACK"));
    }

    @Override
    public int getItemCount() {
        return datos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public ImageView icon;

        public ViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            icon = (ImageView) itemView.findViewById(R.id.icon);
        }
    }

    public void addItem(int position, Data data) {
        datos.add(position, data);
        notifyItemInserted(position);
    }
}
