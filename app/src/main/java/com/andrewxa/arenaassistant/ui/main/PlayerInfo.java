package com.andrewxa.arenaassistant.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.andrewxa.arenaassistant.R;

public class PlayerInfo extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player_info);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TabLayout tabLayout = findViewById(R.id.tablayout_id);

        ViewPager viewPager = findViewById(R.id.viewpager_id);
        ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());

        adapter.addFragment(GeneralFragment.newInstance(),"General");
        adapter.addFragment(StatFragment.newInstance(),"Stat");
        adapter.addFragment(TotalFragment.newInstance(),"Total");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
