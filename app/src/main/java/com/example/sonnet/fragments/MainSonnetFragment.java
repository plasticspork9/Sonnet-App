package com.example.sonnet.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sonnet.R;
import com.example.sonnet.model.LinesArray;
import com.example.sonnet.network.PoetryDBInterface;
import com.example.sonnet.network.RetrofitSingleton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainSonnetFragment extends Fragment {
    private static final String LOGTAG = "TAG TAG TAG";
    private RecyclerView recyclerView;
    private List<String> linesList = new ArrayList<String>();

    public MainSonnetFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_sonnet, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);
        Retrofit retrofit = RetrofitSingleton.getInstance();
        retrofit.create(PoetryDBInterface.class)
                .getLines()
                .enqueue(new Callback<LinesArray>() {
                    @Override
                    public void onResponse(Call<LinesArray> call, Response<LinesArray> response) {
                        Log.d(LOGTAG, "OnResponse: " + response.body().getLines().get(0));

                        for (int i = 0; i < response.body().getLines().size(); i++) {
                            linesList.add(response.body().getLines().get(i));
                        }
                        Log.d(LOGTAG, "Size: " + linesList.size());

                        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    }

                    @Override
                    public void onFailure(Call<LinesArray> call, Throwable t) {
                        Log.d(LOGTAG, "OnFailure: " + t.getMessage());
                    }
                });
    }
}
