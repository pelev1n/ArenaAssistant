package com.andrewxa.arenaassistant.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.andrewxa.arenaassistant.R;
import com.andrewxa.arenaassistant.datasource.model.arenamodel.ArenaAccInfo;
import com.andrewxa.arenaassistant.ui.main.fragments.GeneralFragment;
import com.andrewxa.arenaassistant.ui.main.fragments.CommandersFragment;
import com.andrewxa.arenaassistant.ui.main.fragments.TotalFragment;

public class PlayerInfo extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArenaAccInfo arenaAccInfo = (ArenaAccInfo) getIntent().getSerializableExtra("player");

        TabLayout tabLayout = findViewById(R.id.tablayout_id);

        ViewPager viewPager = findViewById(R.id.viewpager_id);
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());

        adapter.addFragment(GeneralFragment.newInstance(arenaAccInfo),"General");
        adapter.addFragment(CommandersFragment.newInstance(arenaAccInfo),"Commanders");
        adapter.addFragment(TotalFragment.newInstance(arenaAccInfo),"Total");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
