package com.vasyo.igor.vasyo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.data.ApnSetting;
import android.util.Log;

import com.google.gson.Gson;
import com.vasyo.igor.vasyo.Entity.Result;
import com.vasyo.igor.vasyo.Retrofit.APIServise;
import com.vasyo.igor.vasyo.Retrofit.ApiUtil;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private APIServise apiService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        apiService = ApiUtil.getSOService();
        apiService.getBools().enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                if (response.isSuccessful()) {
                    Gson gson = new Gson();
                    String json = gson.toJson(response.body());
                    Log.d("MainActivity", json);
                } else {
                   Log.e("MainActivity", "cannot load data");
                }
            }
            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.d("MainActivity", "error loading from API");
            }
        });
    }
}
