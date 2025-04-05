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
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784614/-A_fcr98i.mp4"; title = "A"; break;
            case 1:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784636/-B_zahwbd.mp4"; title = "B"; break;
            case 2:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784623/-C_y1yqta.mp4"; title = "C"; break;
            case 3:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784674/-D_iflpyr.mp4"; title = "D"; break;
            case 4:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784664/-E_dvkb5n.mp4"; title = "E"; break;
            case 5:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784799/-F_ubyniv.mp4"; title = "F"; break;
            case 6:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784662/-G_rbqnuy.mp4"; title = "G"; break;
            case 7:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784729/-H_lmyeqt.mp4"; title = "H"; break;
            case 8:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784847/-I_epuxl2.mp4"; title = "I"; break;
            case 9:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784693/-J_xddehk.mp4"; title = "J"; break;
            case 10:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784707/-K_pmetvg.mp4"; title = "K"; break;
            case 11:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784745/-L_d9t8ou.mp4"; title = "L"; break;
            case 12:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784757/-M_ofu3gk.mp4"; title = "M"; break;
            case 13:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784847/-N_fpxwrj.mp4"; title = "N"; break;
            case 14:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784763/%C3%91_stcx6q.mp4"; title = "Ñ"; break;
            case 15:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784792/Ng_qvzv23.mp4"; title = "Ng"; break;
            case 16:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784839/-O_oatslr.mp4"; title = "O"; break;
            case 17:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784791/-P_wavkvg.mp4"; title = "P"; break;
            case 18:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784818/-Q_fsjtc9.mp4"; title = "Q"; break;
            case 19:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784850/-R_fcbiep.mp4"; title = "R"; break;
            case 20:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784840/-S_qc72qa.mp4"; title = "S"; break;
            case 21:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784864/-T_kjcpbh.mp4"; title = "T"; break;
            case 22:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784860/-U_oqyykg.mp4"; title = "U"; break;
            case 23:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784604/-V_mxpq3o.mp4"; title = "V"; break;
            case 24:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784634/-W_aeysc0.mp4"; title = "W"; break;
            case 25:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784564/-X_t46coe.mp4"; title = "X"; break;
            case 26:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784583/-Y_keud8b.mp4"; title = "Y"; break;
            case 27:
                url = "https://res.cloudinary.com/dbkvtunx6/video/upload/v1743784661/-Z_strmmg.mp4"; title = "Z"; break;
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