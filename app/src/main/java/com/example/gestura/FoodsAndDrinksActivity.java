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

public class FoodsAndDrinksActivity extends AppCompatActivity implements MenuRecyclerInterface{
    String[] fooddrinksArray = {
            "Gatas", "Hotdog", "Inumin", "Itlog", "Juice", "Kanin", "Kape", "Soda"
    };

    ArrayList<MenuModelClass> modelClasses;
    RecyclerView fooddrinksRecycler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_foods_and_drinks);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        modelClasses = new ArrayList<>();

        for (String s : fooddrinksArray) {
            modelClasses.add(new MenuModelClass(s));
        }

        fooddrinksRecycler = findViewById(R.id.fooddrinksRecycler);
        fooddrinksRecycler.setAdapter(new RecyclerNameAdapter(this, modelClasses, this));
        fooddrinksRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(int pos) {
        String url = "";
        String title = "";
        switch (pos){
            case 0:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756934/gatas_mzpxb6.mp4";
                title = "Gatas";
                break;
            case 1:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756871/hotdog_bqgahm.mp4";
                title = "Hotdog";
                break;
            case 2:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756811/inumin_snldqv.mp4";
                title = "Inumin";
                break;
            case 3:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756932/itlog_znnpgx.mp4";
                title = "Itlog";
                break;
            case 4:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756836/juice_sfa7c0.mp4";
                title = "Juice";
                break;
            case 5:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756853/kanin_cm7qgi.mp4";
                title = "Kanin";
                break;
            case 6:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756943/kape_lyrdwt.mp4";
                title = "Kape";
                break;
            case 7:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756857/soda_sbkknl.mp4";
                title = "Soda";
                break;
            default:
                Log.d("Warning", "Out of Bounds Exception");
        }
        intentVideoUrl(url, title);
    }

    public void intentVideoUrl(String url, String title){
        Intent intent = new Intent(FoodsAndDrinksActivity.this, VideoActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("title", title);
        startActivity(intent);
    }
}