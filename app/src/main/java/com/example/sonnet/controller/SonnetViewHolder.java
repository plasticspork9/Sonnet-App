package com.example.sonnet.controller;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.sonnet.R;
import com.example.sonnet.model.LinesArray;

class SonnetViewHolder extends RecyclerView.ViewHolder {
    TextView sonnet;

    public SonnetViewHolder(@NonNull View itemView) {
        super(itemView);
        sonnet = itemView.findViewById(R.id.line_textview);
    }

    public void onBind(final LinesArray objects){
        sonnet.setText(objects.getLines().toString());
    }
}
