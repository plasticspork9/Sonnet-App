package com.example.sonnet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.sonnet.model.LinesArray;
import com.example.sonnet.network.PoetryDBInterface;
import com.example.sonnet.network.RetrofitSingleton;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {
    private static final String LOGTAG = "TAG TAG TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void retroFitResponse() {
        Retrofit retrofit = RetrofitSingleton.getInstance();
        retrofit.create(PoetryDBInterface.class)
                .getLines()
                .enqueue(new Callback<LinesArray>() {
                    @Override
                    public void onResponse(Call<LinesArray> call, Response<LinesArray> response) {
                        Log.d(LOGTAG, "OnResponse: " + response.body().getLines().get(0));
                    }

                    @Override
                    public void onFailure(Call<LinesArray> call, Throwable t) {

                    }
                });
    }
}
