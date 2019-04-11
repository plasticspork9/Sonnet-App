package com.example.sonnet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.sonnet.fragments.MainSonnetFragment;
import com.example.sonnet.model.LinesArray;
import com.example.sonnet.network.PoetryDBInterface;
import com.example.sonnet.network.RetrofitSingleton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container_framelayout, MainSonnetFragment.newInstance())
                .addToBackStack(null)
                .commit();
    }
}
