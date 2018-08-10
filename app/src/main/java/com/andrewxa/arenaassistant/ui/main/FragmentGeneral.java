package com.andrewxa.arenaassistant.ui.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.andrewxa.arenaassistant.R;

public class FragmentGeneral extends Fragment {

    View v;

    public FragmentGeneral() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.total_fragment,container,false);
        return v;
    }
}
