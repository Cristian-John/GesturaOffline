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


public class GreetingsActivity extends AppCompatActivity implements MenuRecyclerInterface{
    String[] greetingsArray = {
            "Good Afternoon", "Good Evening", "Goodmorning", "Good Night", "Good-bye", "Hello", "Hi", "Thank you", "Welcome"
    };

    ArrayList<MenuModelClass> modelClasses;
    RecyclerView greetingsRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_greetings);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        modelClasses = new ArrayList<>();

        for (String s : greetingsArray) {
            modelClasses.add(new MenuModelClass(s));
        }

        greetingsRecycler = findViewById(R.id.greetingsRecycler);
        greetingsRecycler.setAdapter(new RecyclerNameAdapter(this, modelClasses, this));
        greetingsRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(int pos) {
        String url = "";
        String title = "";
        switch (pos){
            case 0:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/w_1280,h_720,q_auto,f_auto/v1743755391/good_afternoon_itu4y8.mp4";
                title = "Good Afternoon"; //https://res.cloudinary.com/dbkvtunx6/video/upload/v1743755391/good_afternoon_itu4y8.mp4
                break;
            case 1:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/w_1280,h_720,q_auto,f_auto/v1743762845/good_evening_ant77b.mp4";
                title = "Good Evening";
                break;
            case 2:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/w_1280,h_720,q_auto,f_auto/v1743762810/good_morning_fa1jfn.mp4";
                title = "Good Morning";
                break;
            case 3:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/w_1280,h_720,q_auto,f_auto/v1743762728/good_night_cankyx.mp4";
                title = "Goodnight";
                break;
            case 4:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/w_1280,h_720,q_auto,f_auto/v1743762812/goodbye_xefmhe.mp4";
                title = "Good-Bye";
                break;
            case 5:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/w_1280,h_720,q_auto,f_auto/v1743762821/hello_uusw1t.mp4";
                title = "Hello";
                break;
            case 6:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/w_1280,h_720,q_auto,f_auto/v1743762828/hi_gjvzbl.mp4";
                title = "Hi";
                break;
            case 7:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/w_1280,h_720,q_auto,f_auto/v1743762704/thank_you_ajw8dh.mp4";
                title = "Thank You";
                break;
            case 8:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/w_1280,h_720,q_auto,f_auto/v1743762832/welcome_fvou9e.mp4";
                title = "Welcome";
                break;
            default:
                Log.d("Warning", "Out of Bounds Exception");
        }
        intentVideoUrl(url, title);
    }

    public void intentVideoUrl(String url, String title){
        Intent intent = new Intent(GreetingsActivity.this, VideoActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("title", title);
        startActivity(intent);
    }
}