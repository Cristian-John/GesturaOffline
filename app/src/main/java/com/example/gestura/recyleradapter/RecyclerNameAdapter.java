package com.example.gestura.recyleradapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestura.RecyclerAdapter;
import com.example.gestura.modelclass.MenuModelClass;
import com.example.gestura.R;
import com.example.gestura.recyclerinterfaces.MenuRecyclerInterface;

import java.util.ArrayList;
import java.util.Objects;

public class RecyclerNameAdapter extends RecyclerView.Adapter<RecyclerNameAdapter.MyViewHolder>{
    private Context context;
    private ArrayList<MenuModelClass> arrayList;
    private MenuRecyclerInterface menuRecyclerInterface;

    public RecyclerNameAdapter(Context context, ArrayList<MenuModelClass> arrayList, MenuRecyclerInterface menuRecyclerInterface) {
        this.context = context;
        this.arrayList = arrayList;
        this.menuRecyclerInterface = menuRecyclerInterface;
    }

    @NonNull
    @Override
    public RecyclerNameAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.nameitemlayout, parent, false);

        return new RecyclerNameAdapter.MyViewHolder(view, menuRecyclerInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerNameAdapter.MyViewHolder holder, int position) {
        holder.generatedName.setText(arrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView generatedName;
        ConstraintLayout main;
        public MyViewHolder(@NonNull View itemView, MenuRecyclerInterface menuRecyclerInterface) {
            super(itemView);
            generatedName = itemView.findViewById(R.id.generatedName);
            main = itemView.findViewById(R.id.namebutton);

            main.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (menuRecyclerInterface != null){
                        int pos = getAdapterPosition();

                        if (pos != RecyclerView.NO_POSITION){
                            menuRecyclerInterface.onClick(pos);
                        }
                    }
                }
            });
        }
    }

}
