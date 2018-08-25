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

import com.andrewxa.arenaassistant.R;
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
        View view = inflater.inflate(R.layout.commander_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        String commanderName = commanders.get(position).getCommanderKey();
        String commanderBattles = Long.toString(commanders.get(position).getVictories()+
                                                + commanders.get(position).getDefeats());
        String commanderMaxPointsCent = Long.toString(commanders.get(position).getMaxPointsCents()/100);
        String commanderFreeXpCents = Long.toString(commanders.get(position).getFreeXPCents()/100);
        String commanderUnitXpCents = Long.toString(commanders.get(position).getUnitXPCents()/100);
        String commanderSilverCents = Long.toString(commanders.get(position).getSilverCents()/100);

        holder.commanderName.setText("Имя: " + commanderName);
        holder.commanderBattles.setText("Битвы: " + commanderBattles);
        holder.commanderMaxPointsCent.setText("Рекорд по очкам: " + commanderMaxPointsCent);
        holder.commanderFreeXpCents.setText("Свободный опыт: " + commanderFreeXpCents);
        holder.commanderUnitXpCents.setText("Опыт отряда: " + commanderUnitXpCents);
        holder.commanderSilverCents.setText("Серебро: " + commanderSilverCents);
    }

    @Override
    public int getItemCount() {
        return commanders.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView commanderName;
        TextView commanderBattles;
        TextView commanderMaxPointsCent;
        TextView commanderFreeXpCents;
        TextView commanderUnitXpCents;
        TextView commanderSilverCents;

        ViewHolder(View view){
            super(view);
            commanderName = (TextView) view.findViewById(R.id.commander_name);
            commanderBattles = (TextView) view.findViewById(R.id.commander_battles);
            commanderMaxPointsCent = (TextView) view.findViewById(R.id.commander_max_points_cent);
            commanderFreeXpCents = (TextView) view.findViewById(R.id.commander_free_xp_cents);
            commanderUnitXpCents = (TextView) view.findViewById(R.id.commander_unit_xp_cents);
            commanderSilverCents = (TextView) view.findViewById(R.id.commander_silver_cents);
        }
    }
}

