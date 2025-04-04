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

public class QuestionsActivity extends AppCompatActivity implements MenuRecyclerInterface{
    String[] questionsArray = {
            "How?", "How much?", "What?", "When?", "which", "Who?", "Why?"
    };

    ArrayList<MenuModelClass> modelClasses;
    RecyclerView questionsRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_questions);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        modelClasses = new ArrayList<>();

        for (String s : questionsArray) {
            modelClasses.add(new MenuModelClass(s));
        }

        questionsRecycler = findViewById(R.id.questionsRecycler);
        questionsRecycler.setAdapter(new RecyclerNameAdapter(this, modelClasses, this));
        questionsRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(int pos) {
        String url = "";
        String title = "";
        switch (pos){
            case 0:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756942/how_vjygzm.mp4";
                title = "How?";
                break;
            case 1:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756910/how_much_qccaln.mp4";
                title = "How much?";
                break;
            case 2:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756935/what_vaz87i.mp4";
                title = "What?";
                break;
            case 3:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756879/when_i8tw58.mp4";
                title = "When?";
                break;
            case 4:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756932/which_w5uyzo.mp4";
                title = "Which?";
                break;
            case 5:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756887/who_ywcz1m.mp4";
                title = "Who?";
                break;
            case 6:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743756894/why_jfwv30.mp4";
                title = "Why?";
                break;
            default:
                Log.d("Warning", "Out of Bounds Exception");
        }
        intentVideoUrl(url, title);
    }

    public void intentVideoUrl(String url, String title){
        Intent intent = new Intent(QuestionsActivity.this, VideoActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("title", title);
        startActivity(intent);
    }
}