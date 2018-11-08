package com.vasyo.igor.vasyo.Retrofit;

import com.vasyo.igor.vasyo.Entity.Result;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Igor on 27.10.2018.
 */
public interface APIServise {

    @GET("new")
    Call<Result> getBools();
}