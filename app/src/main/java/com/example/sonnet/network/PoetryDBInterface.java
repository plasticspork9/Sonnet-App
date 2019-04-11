package com.example.sonnet.network;

import com.example.sonnet.model.LinesArray;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PoetryDBInterface {
    @GET("/plasticspork9/0c5a3ca58bf12f9b0cbd6ff206832ac7/raw/c50ee9234fe40738e1324a057e8587a7c4b54b1f/PoetryDB%2520Shakespearean%2520Sonnets")
    Call <List<LinesArray>> getLines();
}
