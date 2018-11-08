package com.vasyo.igor.vasyo.Entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Igor on 27.10.2018.
 */
public class Result {
    @SerializedName("books")
    private List<Book> books;

    public List<Book> getBooks() {
        return books;
    }


}