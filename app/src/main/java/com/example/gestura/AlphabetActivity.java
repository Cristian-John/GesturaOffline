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

public class AlphabetActivity extends AppCompatActivity implements MenuRecyclerInterface{
    String[] alphabetArray = {
            "A", "B", "C", "D", "E", "F", "G", "H",
            "I", "J", "K", "L", "M", "N", "Ñ", "Ng",
            "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z"
    };

    ArrayList<MenuModelClass> modelClasses;
    RecyclerView alphabetRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_alphabet);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        modelClasses = new ArrayList<>();

        for (String s : alphabetArray) {
            modelClasses.add(new MenuModelClass(s));
        }

        alphabetRecycler = findViewById(R.id.alphabetRecycler);
        alphabetRecycler.setAdapter(new RecyclerNameAdapter(this, modelClasses, this));
        alphabetRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onClick(int pos) {
        String url = "";
        String title = "";
        switch (pos){
            case 0:
                url = ""; title = "A"; break;
            case 1:
                url = ""; title = "B"; break;
            case 2:
                url = ""; title = "C"; break;
            case 3:
                url = ""; title = "D"; break;
            case 4:
                url = ""; title = "E"; break;
            case 5:
                url = ""; title = "F"; break;
            case 6:
                url = ""; title = "G"; break;
            case 7:
                url = ""; title = "H"; break;
            case 8:
                url = ""; title = "I"; break;
            case 9:
                url = ""; title = "J"; break;
            case 10:
                url = ""; title = "K"; break;
            case 11:
                url = ""; title = "L"; break;
            case 12:
                url = ""; title = "M"; break;
            case 13:
                url = ""; title = "N"; break;
            case 14:
                url = ""; title = "Ñ"; break;
            case 15:
                url = ""; title = "Ng"; break;
            case 16:
                url = ""; title = "O"; break;
            case 17:
                url = ""; title = "P"; break;
            case 18:
                url = ""; title = "Q"; break;
            case 19:
                url = ""; title = "R"; break;
            case 20:
                url = ""; title = "S"; break;
            case 21:
                url = ""; title = "T"; break;
            case 22:
                url = ""; title = "U"; break;
            case 23:
                url = ""; title = "V"; break;
            case 24:
                url = ""; title = "W"; break;
            case 25:
                url = ""; title = "X"; break;
            case 26:
                url = ""; title = "Y"; break;
            case 27:
                url = ""; title = "Z"; break;
            default:
                Log.d("Warning", "Out of Bounds Exception");
        }
        intentVideoUrl(url, title);
    }

    public void intentVideoUrl(String url, String title){
        Intent intent = new Intent(AlphabetActivity.this, VideoActivity.class);
        intent.putExtra("url", url);
        intent.putExtra("title", title);
        startActivity(intent);
    }
}