package com.example.gestura;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VideoActivity extends AppCompatActivity {
    Intent intent;
    VideoView videoView;
    TextView titleView;
    ProgressBar progressBar; //new line

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_video);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        intent = getIntent();
        String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");

        videoView = findViewById(R.id.videoView);
        titleView = findViewById(R.id.titleView);
        progressBar = findViewById(R.id.progressBar); //new line

        videoView.setVideoURI(Uri.parse(url));
        videoView.setMediaController(new MediaController(this));
        videoView.requestFocus();

        progressBar.setVisibility(View.VISIBLE); //new

        videoView.setOnPreparedListener(mp -> { //new
            progressBar.setVisibility(View.GONE);//new

            videoView.start();
        });//new

        titleView.setText(title);

        videoView.setOnErrorListener((mp, what, extra) -> {//new
            progressBar.setVisibility(View.GONE);
            Toast.makeText(this, "Failed to play video", Toast.LENGTH_SHORT).show();
            return true;
        });//new


    }
}