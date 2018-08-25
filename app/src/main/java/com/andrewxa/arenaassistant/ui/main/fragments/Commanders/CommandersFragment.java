package com.andrewxa.arenaassistant.ui.main.fragments.Commanders;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.andrewxa.arenaassistant.R;
import com.andrewxa.arenaassistant.datasource.model.arenamodel.ArenaAccInfo;

public class CommandersFragment extends Fragment {

    View view;

    public CommandersFragment() {
    }

    public static CommandersFragment newInstance(ArenaAccInfo playerInfo) {
        CommandersFragment fragment = new CommandersFragment();
        Bundle args = new Bundle();
        args.putSerializable("player",playerInfo);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.commanders_fragment,container,false);




        return view;
    }
}
