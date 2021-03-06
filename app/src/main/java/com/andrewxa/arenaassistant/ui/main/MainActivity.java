package com.andrewxa.arenaassistant.ui.main;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.andrewxa.arenaassistant.R;
import com.andrewxa.arenaassistant.datasource.model.arenamodel.ArenaAccInfo;
import com.andrewxa.arenaassistant.ui.main.presenter.MainPresenterImpl;
import com.andrewxa.arenaassistant.ui.main.presenter.MainView;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity implements MainView {

    private Button mainButton;
    private EditText etEnterPlayerName;
    private TextView arenaField;
    private TextView finalResult;
    private Toolbar toolbar;
    private ProgressBar progressBar;
    private ViewPager viewPager;
    private ViewPageAdapter adapter;
    private TabLayout tabLayout;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private String playerWgName;
    private String playerWgId;

    private MainPresenterImpl presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainButton = findViewById(R.id.playerSearchButton);
        etEnterPlayerName = findViewById(R.id.playerNameField);
      /*  arenaField = findViewById(R.id.arenaIdField);
        finalResult = findViewById(R.id.finalResult);*/
        progressBar = findViewById(R.id.progressBar);
        tabLayout = findViewById(R.id.tablayout_id);
        toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);

        presenter = MainPresenterImpl.getInstance(this);
        presenter.checkingCache();

        mainButton.setOnClickListener(view -> {
            presenter.searchUserFromNet();
        });
    }

    private void showArenaPlayerInfo(ArenaAccInfo playerInfo) {
        Intent intent = new Intent(this,PlayerInfo.class);
        intent.putExtra("player",playerInfo);
        startActivity(intent);
    }

    private void loadGeneralFragment() {

    }

    private void loadStatFragment() {

    }

    private void loadTotalFragment() {
    }


    public String formatDate(long unixSeconds) {
        // convert seconds to milliseconds
        Date date = new java.util.Date(unixSeconds);
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");

        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT-4"));
        String formattedDate = sdf.format(date);

        return formattedDate;
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showInformation(ArenaAccInfo arenaAccInfo) {
        showArenaPlayerInfo(arenaAccInfo);
    }

    @Override
    public void refreshInformation(ArenaAccInfo arenaAccInfo) {

    }

    @Override
    public String searchUser() {
        return etEnterPlayerName.getText().toString();
    }
}