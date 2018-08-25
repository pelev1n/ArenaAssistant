package com.andrewxa.arenaassistant.ui.main.fragments.Commanders;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.andrewxa.arenaassistant.datasource.model.arenamodel.Stat;

import java.util.List;


public class CommandersAdapter extends RecyclerView.Adapter<CommandersAdapter.ViewHolder> {
    private List<Stat> commanders;
    private Context context;

    public CommandersAdapter(List<Stat> commanders, Context context) {
        this.commanders = commanders;
        this.context = context;
    }


    @Override
    public CommandersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        private Button updateButton, deleteButton;
        private TextView text_name;
        private TextView text_email;

        ViewHolder(View view){
            super(view);
          /*  updateButton = (Button) view.findViewById(R.id.updateButton);
            deleteButton = (Button) view.findViewById(R.id.deleteButton);
            text_name = (TextView) view.findViewById(R.id.text_name);
            text_email = (TextView) view.findViewById(R.id.text_email);*/
        }
    }
}

