package com.example.sonnet.controller;

import android.support.annotation.NonNull;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.example.sonnet.R;
import com.example.sonnet.helper.ItemTouchHelperAdapter;
import com.example.sonnet.helper.OnStartDragListener;
import com.example.sonnet.model.LinesArray;

import java.util.Collections;
import java.util.List;


public class SonnetAdapter extends RecyclerView.Adapter<SonnetViewHolder> implements ItemTouchHelperAdapter {
    List<LinesArray> linesList;

    public SonnetAdapter(){}

    public SonnetAdapter(List<LinesArray> linesList) {
        this.linesList = linesList;
    }

    @NonNull
    @Override
    public SonnetViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_view, viewGroup, false);
        return new SonnetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final SonnetViewHolder holder, int i) {
        holder.onBind(linesList.get(i));
    }

    @Override
    public int getItemCount() {
        return linesList.size();
    }

    @Override
    public boolean onItemMove(int fromPosition, int toPosition) {
        Collections.swap(linesList, fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    @Override
    public void onItemDismiss(int position) {
        linesList.remove(position);
        notifyItemRemoved(position);
    }
}
