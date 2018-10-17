package com.example.igorkovasyo.a1laba;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Set;

public class Main2Activity extends AppCompatActivity {

    SharedPreferences shared;
    ArrayList<String> name;
    ArrayList<String> number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        shared = getSharedPreferences("users_list", MODE_PRIVATE);

        name = new ArrayList<>();
        number = new ArrayList<>();

        try {
            retriveSharedValue();
        } catch (Exception e){}

        String[] names = new String[name.size()];
        names = name.toArray(names);
        String[] numbers = new String[number.size()];
        numbers = number.toArray(numbers);

        for(int i = 0; i < names.length ; i++){
            Log.d("string is",names[i]);
            Log.d("string is",numbers[i]);
        }

        final ListView lvMain = findViewById(R.id.list);

        CustomAdapter customAdapter = new CustomAdapter(this, names, numbers);
        lvMain.setAdapter(customAdapter);
    }

    private void retriveSharedValue() {
        Set<String> set_name = shared.getStringSet("name", null);
        name.addAll(set_name);
        Set<String> set_number = shared.getStringSet("number", null);
        number.addAll(set_number);

        Log.d("storesharedPreferences",""+set_name);
    }
}
