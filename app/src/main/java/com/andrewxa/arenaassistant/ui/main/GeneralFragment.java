package com.andrewxa.arenaassistant.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.andrewxa.arenaassistant.R;
import com.andrewxa.arenaassistant.datasource.model.arenamodel.ArenaAccInfo;

public class GeneralFragment extends Fragment {

    View v;
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
        v = inflater.inflate(R.layout.general_fragment,container,false);

        return v;
    }
}
