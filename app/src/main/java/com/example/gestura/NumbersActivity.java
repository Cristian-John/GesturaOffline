package com.example.gestura;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gestura.modelclass.MenuModelClass;
import com.example.gestura.recyclerinterfaces.MenuRecyclerInterface;
import com.example.gestura.recyleradapter.RecyclerNameAdapter;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity implements MenuRecyclerInterface{
    String[] numbersArray = {
            "One to ten"
    };

    ArrayList<MenuModelClass> modelClasses;
    RecyclerView numbersRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_numbers);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        modelClasses = new ArrayList<>();

        for (String s : numbersArray) {
            modelClasses.add(new MenuModelClass(s));
        }

        numbersRecycler = findViewById(R.id.numbersRecycler);
        numbersRecycler.setAdapter(new RecyclerNameAdapter(this, modelClasses, this));
        numbersRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(int pos) {
        String url = "";
        String title = "";
        switch (pos){
            case 0:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/w_1280,h_720,q_auto,f_auto/v1743779027/1-10_ex4yrn.mp4";
                title = "One to Ten";
                break;
            default:
                Log.d("Warning", "Out of Bounds Exception");
        }
        intentVideoUrl(url, title);
    }

    public void intentVideoUrl(String url, String title){
        Intent intent = new Intent(NumbersActivity.this, VideoActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("title", title);
        startActivity(intent);
    }
}