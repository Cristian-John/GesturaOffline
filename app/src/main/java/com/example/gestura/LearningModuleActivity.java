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

import java.util.ArrayList;

public class LearningModuleActivity extends AppCompatActivity implements RecyclerViewInterface{
    ArrayList<ButtonModelClass> arrayList = new ArrayList<>();
    RecyclerView mRecycler;
    int[] icons = {
            R.drawable.alphabet, R.drawable.emotions, R.drawable.greetings, R.drawable.fooddrinks, R.drawable.color, R.drawable.numbers, R.drawable.question, R.drawable.animal
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_learning_module);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        for (int i = 0; i < icons.length; i += 2){
            arrayList.add(new ButtonModelClass(icons[i], icons[i+1]));
        }

        mRecycler = findViewById(R.id.mRecyclerView);
        mRecycler.setAdapter(new RecyclerAdapter(this, arrayList, this));
        mRecycler.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void onItemClick1(int pos) {
        if (pos == 0){
            Log.d("TESTING", "ITEM ALPHABET");
            intentActivity(AlphabetActivity.class);
        } else if (pos == 1){
            Log.d("TESTING", "ITEM GREETINGS");
            intentActivity(GreetingsActivity.class);
        } else if (pos == 2){
            Log.d("TESTING", "ITEM COLORS");
            intentActivity(ColorsActivity.class);
        } else if (pos == 3){
            Log.d("TESTING", "ITEM QUESTIONS");
            intentActivity(QuestionsActivity.class);
        } else {
            Log.d("TESTING", "ERROR");
        }
    }

    @Override
    public void onItemClick2(int pos) {
        if (pos == 0){
            Log.d("TESTING", "ITEM EMOTIONS");
            intentActivity(EmotionsActivity.class);
        } else if (pos == 1){
            Log.d("TESTING", "ITEM FOODS AND DRINKS");
            intentActivity(FoodsAndDrinksActivity.class);
        } else if (pos == 2){
            Log.d("TESTING", "ITEM NUMBERS");
            intentActivity(NumbersActivity.class);
        } else if (pos == 3){
            Log.d("TESTING", "ITEM ANIMALS");
            intentActivity(AnimalsActivity.class);
        } else {
            Log.d("TESTING", "ERROR");
        }
    }

    public void intentActivity(Class<?> classVariable){
        Intent intent = new Intent(LearningModuleActivity.this, classVariable);
        startActivity(intent);
        // so pinapasa ko na lanh ung class na variable pra d na ki paulet ulet type ng Intent intent = new Intent kineme
    }

    // try natin to wish me luck sarili ko to algorithm HAHAHAHA
    // bwahahhaha galing ko talaga gumana hahaha kahit nag lalag HAHAHAH
    // pre pre
}