package com.andrewxa.arenaassistant.ui.main.fragments.Commanders;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andrewxa.arenaassistant.R;
import com.andrewxa.arenaassistant.datasource.model.arenamodel.ArenaAccInfo;
import com.andrewxa.arenaassistant.datasource.model.arenamodel.Stat;

import java.util.ArrayList;
import java.util.List;

public class CommandersFragment extends Fragment {

    View view;
    ArenaAccInfo player;

    public CommandersFragment() {
    }

    public static CommandersFragment newInstance(ArenaAccInfo playerInfo) {
        CommandersFragment fragment = new CommandersFragment();
        Bundle args = new Bundle();
        args.putSerializable("player", playerInfo);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.commanders_fragment, container, false);


        player = (ArenaAccInfo) getArguments().getSerializable("player");
        List<Stat> commanders = new ArrayList<>();


        for( Stat com : player.getStats() ) {
            if(com.getUnitKey() == "") {
                System.out.println(com.getCommanderKey());
                commanders.add(com);
            }
        }

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.commanders_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        CommandersAdapter commandersAdapter = new CommandersAdapter(commanders,getContext());
        recyclerView.setAdapter(commandersAdapter);


        return view;
    }
}
