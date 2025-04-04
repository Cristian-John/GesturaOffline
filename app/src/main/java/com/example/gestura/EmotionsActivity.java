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

public class EmotionsActivity extends AppCompatActivity implements MenuRecyclerInterface{

    String[] emotionsArray = {
            "Angry", "Annoy", "Crazy", "Excite", "Shame", "Strong"
    };

    ArrayList<MenuModelClass> modelClasses;
    RecyclerView emotionRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_emotions);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        modelClasses = new ArrayList<>();

        for (String s : emotionsArray) {
            modelClasses.add(new MenuModelClass(s));
        }

        emotionRecycler = findViewById(R.id.emotionRecycler);
        emotionRecycler.setAdapter(new RecyclerNameAdapter(this, modelClasses, this));
        emotionRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(int pos) {
        String url = "";
        String title = "";
        switch (pos){
            case 0:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756877/angry_xbcyrz.mp4";
                title = "Angry";
                break;
            case 1:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756779/annoy_veihu8.mp4";
                title = "Annoy";
                break;
            case 2:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756782/crazy_h9pyxk.mp4";
                title = "Crazy";
                break;
            case 3:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756818/excite_xt49zf.mp4";
                title = "Excite";
                break;
            case 4:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756859/shame_n4co0v.mp4";
                title = "Shame";
                break;
            case 5:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756824/strong_dnccpv.mp4";
                title = "Strong";
                break;
            default:
                Log.d("Warning", "Out of Bounds Exception");
        }
        intentVideoUrl(url, title);
    }

    public void intentVideoUrl(String url, String title){
        Intent intent = new Intent(EmotionsActivity.this, VideoActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("title", title);
        startActivity(intent);
    }
}