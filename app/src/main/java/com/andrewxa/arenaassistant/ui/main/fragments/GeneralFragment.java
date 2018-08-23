package com.andrewxa.arenaassistant.ui.main.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andrewxa.arenaassistant.R;
import com.andrewxa.arenaassistant.datasource.model.arenamodel.ArenaAccInfo;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class GeneralFragment extends Fragment {

    View view;
    private ArenaAccInfo player;

    public GeneralFragment() {
    }

    public static GeneralFragment newInstance(ArenaAccInfo playerInfo) {
        GeneralFragment fragment = new GeneralFragment();
        Bundle args = new Bundle();
        args.putSerializable("player", playerInfo);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.general_fragment, container, false);

        TextView nickName = (TextView) view.findViewById(R.id.generalNickName11);
        TextView winRate = (TextView) view.findViewById(R.id.generalWinRate);
        TextView battlePlayed = (TextView) view.findViewById(R.id.generalField_BattlePlayed);
        TextView winBattles = (TextView) view.findViewById(R.id.generalField_WinBattles);
        TextView defeatsBattles = (TextView) view.findViewById(R.id.generalField_defeatsBattles);
        TextView damage = (TextView) view.findViewById(R.id.generalField_damage);
        TextView damagePer = (TextView) view.findViewById(R.id.generalField_damage_per);
        TextView kills = (TextView) view.findViewById(R.id.generalField_kills);
        TextView killsPer = (TextView) view.findViewById(R.id.generalField_kills_per);

        player = (ArenaAccInfo) getArguments().getSerializable("player");

        long btlPlayed  = player.getTotals().getBattlesPlayed();
        long vistories = player.getTotals().getResults().getVictories();
        long defeats = player.getTotals().getResults().getDefeats();
        long damages = player.getTotals().getDamage();
        long killz = player.getTotals().getKills();

        nickName.setText("Nickname: ");
        battlePlayed.setText("Battles: " + battlePlayed);
        winBattles.setText("Win: " + vistories);
        defeatsBattles.setText("Defeat: " + defeats);

        winRate.setText("Winrate: " +
                Integer.toString(((int) vistories * 100) / (int) btlPlayed) + "%");

        damage.setText("Damage: " + damages);
        damagePer.setText("Damage per battle: " + Long.toString(
                damages / btlPlayed));


        kills.setText("Kills: " + killz);
        killsPer.setText("Kills per battle: " + Long.toString(
                killz / btlPlayed));

        List<Long> stats = new ArrayList<>();
       /* stats.add(btlPlayed);*/
        stats.add(vistories);
        stats.add(defeats);
        initalGraph(view,stats);

        return view;
    }

    public void initalGraph(View view,List<Long> stats) {
        PieChart pieChart = (PieChart) view.findViewById(R.id.chart);

        List<PieEntry> yValues = new ArrayList<>();

        yValues.add(new PieEntry(stats.get(0),"Victories"));
        yValues.add(new PieEntry(stats.get(1),"Defeats"));

        PieDataSet dataSet = new PieDataSet(yValues,"Battles");

        dataSet.setSliceSpace(3f);
        dataSet.setSelectionShift(5f);
        dataSet.setColors(ColorTemplate.JOYFUL_COLORS);

        PieData pieData = new PieData();



    }


}
