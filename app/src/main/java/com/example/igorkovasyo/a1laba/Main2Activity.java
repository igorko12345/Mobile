package com.example.igorkovasyo.a1laba;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class Main2Activity extends AppCompatActivity {
    RecyclerView mRvGames;
    private ArrayList<User> users = new ArrayList<>();
    ArrayList<User> usersFromShared;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        retriveSharedValue();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRvGames = findViewById(R.id.list);
        mRvGames.setLayoutManager(layoutManager);
        usersFromShared = new ArrayList<>();
        retriveSharedValue();
        final RecyclerView lvMain = findViewById(R.id.list);

        UserAdapter customAdapter = new UserAdapter(usersFromShared);
        lvMain.setAdapter(customAdapter);
    }

    private void retriveSharedValue() {
        Gson gson = new Gson();
        SharedPreferences sharedPref = getApplicationContext().getSharedPreferences(
                "users", Context.MODE_PRIVATE);
        String jsonPreferences = sharedPref.getString("users", "");
        Type type = new TypeToken<List<User>>() {
        }.getType();
        usersFromShared = gson.fromJson(jsonPreferences, type);


    }
}
