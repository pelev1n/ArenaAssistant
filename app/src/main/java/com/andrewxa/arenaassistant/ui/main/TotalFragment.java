package com.andrewxa.arenaassistant.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.andrewxa.arenaassistant.R;
import com.andrewxa.arenaassistant.datasource.model.arenamodel.ArenaAccInfo;
import com.andrewxa.arenaassistant.ui.main.presenter.MainPresenterImpl;

public class TotalFragment extends Fragment {

    View view;
    private ArenaAccInfo player;

    public TotalFragment() {
    }

    public static TotalFragment newInstance(ArenaAccInfo playerInfo) {
        TotalFragment fragment = new TotalFragment();
        Bundle args = new Bundle();
        args.putSerializable("player",playerInfo);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.total_fragment,container,false);

        TextView battlePlayed = (TextView) view.findViewById(R.id.totalField_BattlePlayed);
        TextView winBattles = (TextView) view.findViewById(R.id.totalField_WinBattles);
        TextView defeatsBattles = (TextView) view.findViewById(R.id.totalField_defeatsBattles);
        TextView damage = (TextView) view.findViewById(R.id.totalField_damage);
        TextView kills = (TextView) view.findViewById(R.id.totalField_kills);

        player = (ArenaAccInfo) getArguments().getSerializable("player");

        battlePlayed.setText("Played Battles: 1" + player.getTotals().getBattlesPlayed());
        winBattles.setText("Win battles: "+ player.getTotals().getResults().getVictories());
        defeatsBattles.setText("defeat battles: "+ player.getTotals().getResults().getDefeats());
        damage.setText("Damage: "+ player.getTotals().getDamage());
        kills.setText("Kills: "+ player.getTotals().getKills());
        return view;
    }
}
