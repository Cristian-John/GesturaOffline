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
                //url = "android.resource://"+getPackageName()+"/"+R.raw.bear;
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743749835/Bear_wkzelh.mp4";
                title = "Bear";
                break;
            case 1:
                //url = "android.resource://"+getPackageName()+"/"+R.raw.bird;
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743754720/Bird_o6z1yl.mp4";
                title = "Bird";
                break;
            case 2:
                //url = "android.resource://"+getPackageName()+"/"+R.raw.butterfly;
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743754732/butterfly_wq7rps.mp4";
                title = "Butterfly";
                break;
            case 3:
                //url = "android.resource://"+getPackageName()+"/"+R.raw.carabao;
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743754742/Carabao_hbyagx.mp4";
                title = "Carabao";
                break;
            case 4:
                //url = "android.resource://"+getPackageName()+"/"+R.raw.dog;
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743754769/Dog_xxim7b.mp4";
                title = "Dog";
                break;
            case 5:
                //url = "android.resource://"+getPackageName()+"/"+R.raw.duck;
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743754780/Duck_ubv3rc.mp4";
                title = "Duck";
                break;
            case 6:
                //url = "android.resource://"+getPackageName()+"/"+R.raw.fish;
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743754789/fish_gbhetw.mp4";
                title = "Fish";
                break;
            case 7:
                //url = "android.resource://"+getPackageName()+"/"+R.raw.worm;
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743754799/worm_zot0br.mp4";
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