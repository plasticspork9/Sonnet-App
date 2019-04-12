package com.example.sonnet.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sonnet.helper.ItemTouchHelperCallback;
import com.example.sonnet.helper.OnStartDragListener;
import com.example.sonnet.R;
import com.example.sonnet.controller.SonnetAdapter;
import com.example.sonnet.model.LinesArray;
import com.example.sonnet.network.PoetryDBInterface;
import com.example.sonnet.network.RetrofitSingleton;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainSonnetFragment extends Fragment implements OnStartDragListener {
    private static final String LOGTAG = "TAG TAG TAG";
    private RecyclerView recyclerView;
    private List<LinesArray> linesList = new ArrayList<>();
    private ItemTouchHelper itemTouchHelper;

    public MainSonnetFragment() {
    }

    public static MainSonnetFragment newInstance() {
        return new MainSonnetFragment();
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
        Call<List<LinesArray>> call = RetrofitSingleton.getInstance().create(PoetryDBInterface.class).getLines();
        call.enqueue(new Callback<List<LinesArray>>() {
                    @Override
                    public void onResponse(Call <List<LinesArray>> call, Response<List<LinesArray>> response) {
                        Log.d(LOGTAG, "OnResponse: " + response.body().get(0).getLines());
                        linesList = response.body();

                        Log.e(LOGTAG, "Size: " + linesList.size());


                        setRecyclerView(linesList);
                        recyclerView.setHasFixedSize(true);
                    }

                    @Override
                    public void onFailure(Call<List<LinesArray>> call, Throwable t) {
                        Log.e(LOGTAG, "OnFailure: " + t.getMessage());
                    }
                });
    }

    public void setRecyclerView(List<LinesArray> dataModel) {

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()
                , LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(new SonnetAdapter(dataModel));
        ItemTouchHelper.Callback callback = new ItemTouchHelperCallback(SonnetAdapter);
        itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    @Override
    public void onStartDrag(RecyclerView.ViewHolder viewHolder) {
        itemTouchHelper.startDrag(viewHolder);
    }
}

