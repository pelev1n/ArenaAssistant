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

import org.w3c.dom.Text;

public class GeneralFragment extends Fragment {

    View view;
    private ArenaAccInfo player;

    public GeneralFragment() {
    }

    public static GeneralFragment newInstance(ArenaAccInfo playerInfo) {
        GeneralFragment fragment = new GeneralFragment();
        Bundle args = new Bundle();
        args.putSerializable("player",playerInfo);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.general_fragment,container,false);

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

        nickName.setText("Nickname: ");
        battlePlayed.setText("Battles: " + player.getTotals().getBattlesPlayed());
        winBattles.setText("Win: "+ player.getTotals().getResults().getVictories());
        defeatsBattles.setText("Defeat: "+ player.getTotals().getResults().getDefeats());

        winRate.setText("Winrate: " +
                Integer.toString(
                ((int) player.getTotals().getResults().getVictories() * 100) /
                        (int)player.getTotals().getBattlesPlayed()) + "%");

        damage.setText("Damage: "+ player.getTotals().getDamage());
        damagePer.setText("Damage per battle: " + Long.toString(
                        player.getTotals().getDamage() /
                        player.getTotals().getBattlesPlayed()));


        kills.setText("Kills: "+ player.getTotals().getKills());
        killsPer.setText("Kills per battle: " + Long.toString(
                        player.getTotals().getKills() /
                        player.getTotals().getBattlesPlayed()));


        return view;
    }
}
