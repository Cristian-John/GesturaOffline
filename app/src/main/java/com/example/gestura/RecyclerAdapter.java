package com.example.gestura;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> implements OnClick {
    Context context;
    ArrayList<ButtonModelClass> arrayList;

    public RecyclerAdapter(Context context, ArrayList<ButtonModelClass> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public RecyclerAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.itemlayout, parent, false);

        return new RecyclerAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.MyViewHolder holder, int position) {
        holder.imgButton1.setImageResource(arrayList.get(position).getImgButton1());
        holder.imgButton2.setImageResource(arrayList.get(position).getImgButton2());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    @Override
    public void onClick() {

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        ImageButton imgButton1, imgButton2;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgButton1 = itemView.findViewById(R.id.imageButton1);
            imgButton2 = itemView.findViewById(R.id.imageButton2);
        }
    }
}
