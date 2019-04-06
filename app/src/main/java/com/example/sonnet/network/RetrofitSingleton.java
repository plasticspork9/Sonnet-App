package com.example.sonnet.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSingleton {
    private static final String BASE_URL = "https://raw.githubusercontent.com";
    private static Retrofit instance;

    private RetrofitSingleton(){}

    public static Retrofit getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }
}
