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

public class ColorsActivity extends AppCompatActivity implements MenuRecyclerInterface{

    String[] colorsArray = {
            "Black", "Blue", "Brown", "Gray", "Green", "Orange", "Red", "Violet"
    };

    ArrayList<MenuModelClass> modelClasses;
    RecyclerView colorsRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_colors);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        modelClasses = new ArrayList<>();

        for (String s : colorsArray) {
            modelClasses.add(new MenuModelClass(s));
        }

        colorsRecycler = findViewById(R.id.colorRecycler);
        colorsRecycler.setAdapter(new RecyclerNameAdapter(this, modelClasses, this));
        colorsRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(int pos) {
        String url = "";
        String title = "";
        switch (pos){
            case 0:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756734/black_un3oia.mp4";
                title = "Black";
                break;
            case 1:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756713/blue_gfjivr.mp4";
                title = "Blue";
                break;
            case 2:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756716/brown_nq0bgj.mp4";
                title = "Brown";
                break;
            case 3:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756745/gray_ml7zl6.mp4";
                title = "Gray";
                break;
            case 4:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756746/green_uyici0.mp4";
                title = "Green";
                break;
            case 5:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756754/orange_kr1vwy.mp4";
                title = "Orange";
                break;
            case 6:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756760/red_vorwv7.mp4";
                title = "Red";
                break;
            case 7:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756747/violet_j8qkqd.mp4";
                title = "Violet";
                break;
            default:
                Log.d("Warning", "Out of Bounds Exception");
        }
        intentVideoUrl(url, title);
    }

    public void intentVideoUrl(String url, String title){
        Intent intent = new Intent(ColorsActivity.this, VideoActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("title", title);
        startActivity(intent);
    }
}