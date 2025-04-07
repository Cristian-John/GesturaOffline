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

public class AnimalsActivity extends AppCompatActivity implements MenuRecyclerInterface {

    String[] animalArray = {
            "Bear", "Bird", "Butterfly", "Carabao", "Dog", "Duck", "Fish", "Worm"
    };

    ArrayList<MenuModelClass> modelClasses;
    RecyclerView animalRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_animals);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        modelClasses = new ArrayList<>();

        for (String s : animalArray) {
            modelClasses.add(new MenuModelClass(s));
        }

        animalRecycler = findViewById(R.id.animalRecycler);
        animalRecycler.setAdapter(new RecyclerNameAdapter(this, modelClasses, this));
        animalRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(int pos) {
        String url = "";
        String title = "";
        switch (pos){
            case 0:
                url = "android.resource://"+getPackageName()+"/"+R.raw.bear;
                title = "Bear";
                break;
            case 1:
                url = "android.resource://"+getPackageName()+"/"+R.raw.bird;
                title = "Bird";
                break;
            case 2:
                url = "android.resource://"+getPackageName()+"/"+R.raw.butterfly;
                title = "Butterfly";
                break;
            case 3:
                url = "android.resource://"+getPackageName()+"/"+R.raw.carabao;
                title = "Carabao";
                break;
            case 4:
                url = "android.resource://"+getPackageName()+"/"+R.raw.dog;
                title = "Dog";
                break;
            case 5:
                url = "android.resource://"+getPackageName()+"/"+R.raw.duck;
                title = "Duck";
                break;
            case 6:
                url = "android.resource://"+getPackageName()+"/"+R.raw.fish;
                title = "Fish";
                break;
            case 7:
                url = "android.resource://"+getPackageName()+"/"+R.raw.worm;
                title = "Worm";
                break;
            default:
                Log.d("Warning", "Out of Bounds Exception");
        }
        intentVideoUrl(url, title);
    }

    public void intentVideoUrl(String url, String title){
        Intent intent = new Intent(AnimalsActivity.this, VideoActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("title", title);
        startActivity(intent);
    }
}