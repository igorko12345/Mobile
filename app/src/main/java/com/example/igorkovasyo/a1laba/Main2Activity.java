package com.example.igorkovasyo.a1laba;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;

import java.util.ArrayList;


public class Main2Activity extends AppCompatActivity {
    private User user;
    SharedPreferences shared;
    RecyclerView mRvGames;
    private ArrayList<User> users = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        retriveSharedValue();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRvGames = findViewById(R.id.list);
        mRvGames.setLayoutManager(layoutManager);

        retriveSharedValue();
        final RecyclerView lvMain = findViewById(R.id.list);

        CustomAdapter customAdapter = new CustomAdapter(users);
        lvMain.setAdapter(customAdapter);
    }

    private void retriveSharedValue() {
        Gson gson = new Gson();
        shared = getSharedPreferences("user", Context.MODE_PRIVATE);
        String json = shared.getString("user", "");
        user = gson.fromJson(json, User.class);
        users.add(user);
    }
}
