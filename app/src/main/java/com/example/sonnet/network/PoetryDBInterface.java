package com.example.sonnet.network;

import com.example.sonnet.model.LinesArray;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PoetryDBInterface {
    @GET("/author,linecount/Shakespeare;14/lines")
    Call<LinesArray> getLines();
}
