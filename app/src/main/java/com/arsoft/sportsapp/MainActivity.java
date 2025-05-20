package com.arsoft.sportsapp;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import kotlin.jvm.internal.SpreadBuilder;

public class MainActivity extends AppCompatActivity {

    // 1- Adapter View
    private RecyclerView recyclerView;

    // 2- Data source
    private List<Sport> sportList;

    // 3- Adapter
    private CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        sportList = new ArrayList<>();

        Sport s1 = new Sport("Football", R.drawable.football);
        Sport s2 = new Sport("Basketball", R.drawable.basketball);
        Sport s3 = new Sport("VolleyBall", R.drawable.volley);
        Sport s4 = new Sport("Ping Pong", R.drawable.ping);
        Sport s5 = new Sport("Tennis", R.drawable.tennis);

        sportList.add(s1);
        sportList.add(s2);
        sportList.add(s3);
        sportList.add(s4);
        sportList.add(s5);

        adapter = new CustomAdapter(sportList);

        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);





    }
}