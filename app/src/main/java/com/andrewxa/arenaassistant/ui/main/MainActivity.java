package com.andrewxa.arenaassistant.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.andrewxa.arenaassistant.ArenaAssistant;
import com.andrewxa.arenaassistant.R;
import com.andrewxa.arenaassistant.datasource.model.arenamodel.ArenaAccInfo;
import com.andrewxa.arenaassistant.datasource.model.wgmodel.WgAccInfo;
import com.andrewxa.arenaassistant.ui.main.presenter.Contract;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private Button mainButton;
    private EditText playerName;
    private TextView arenaField;
    private TextView finalResult;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private String playerWgName;
    private String playerWgId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainButton = findViewById(R.id.playerSearchButton);
        playerName = findViewById(R.id.playerNameField);
        arenaField = findViewById(R.id.arenaIdField);
        finalResult = findViewById(R.id.finalResult);

        mainButton.setOnClickListener(view -> {
            fetchData();
            // Have to fix it secondStep(playerWgId);
            /*secondStep(playerWgId);*/
        });
    }

    // First Part
    private void fetchData() {
        compositeDisposable.add(ArenaAssistant.getWgApi().getWgPlayerId(playerName.getText().toString())
                .subscribeOn(Schedulers.io())
                .flatMap((Function<WgAccInfo, Observable<ResponseBody>>) accountInfo ->
                        ArenaAssistant.getArenaApi().getArenaPlayerId(Long.toString(accountInfo.getData().get(0).getAccountID()))
                )
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body ->
                {
                    finalStep(body.string());
                    Timber.d("body: " + body.string());
                    Timber.d("body: " + body.string());
                }, throwable -> {
                    Timber.d("throwable: " + throwable.getCause());
                    Timber.d("throwable: " + throwable.getMessage());
                }));
    }

    private void finalStep(String playerArenaId) {
        showArenaPlayerId(playerArenaId);
        compositeDisposable.add(ArenaAssistant.getArenaInfoApi().getArenaPlayerInfo(playerArenaId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(arenaAccInfo -> {
                    showArenaPlayerInfo(arenaAccInfo);
                }));
    }

    private void showArenaPlayerId(String arenaPlayerId) {
        arenaField.setText("ArenaAccInfo ID: " + arenaPlayerId);
    }

    private void showArenaPlayerInfo(ArenaAccInfo playerInfo) {
        String formattedDate = formatDate(playerInfo.getJoinDate());

        String finalString =
                "Level: " + Long.toString(playerInfo.getPlayersLevel()) + ", " +
                "Joid date: " + formattedDate + ", " +
                "Battles played: " + Long.toString(playerInfo.getTotals().getBattlesPlayed()) + ", " +
                "Victories: " + Long.toString(playerInfo.getTotals().getResults().getVictories()) + ", " +
                "Total kills: " + Long.toString(playerInfo.getTotals().getKills());

        finalResult.setText(finalString);
    }

    public String formatDate(long unixSeconds) {

        // convert seconds to milliseconds
        Date date = new java.util.Date(unixSeconds);
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("dd/MM/yyyy");

        sdf.setTimeZone(java.util.TimeZone.getTimeZone("GMT-4"));
        String formattedDate = sdf.format(date);

       return formattedDate;
    }

/*
    //Second Step
    public void secondStep(String playerWgId) {
        getSecondRequest(playerWgId);
    }

    // Second Part
    private void getSecondRequest(String playerId) {
        compositeDisposable.add(ArenaAssistant.getArenaApi().getArenaPlayerId(playerId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                    showArenaPlayerId(body.string());
                }));
    }
*/


}