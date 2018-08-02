package com.andrewxa.arenaassistant.ui.main;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.andrewxa.arenaassistant.ArenaAssistant;
import com.andrewxa.arenaassistant.R;
import com.andrewxa.arenaassistant.datasource.model.WgAccountInfo;
import com.andrewxa.arenaassistant.datasource.network.ArenaApi;
import com.andrewxa.arenaassistant.datasource.network.WgApi;
import com.andrewxa.arenaassistant.ui.main.presenter.Contract;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import timber.log.Timber;

public class MainActivity extends AppCompatActivity implements Contract.View {

    private Button mainButton;
    private EditText playerName;
    private TextView nameWgField;
    private TextView arenaField;
    private TextView idWgField;

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private String playerWgName;
    private String playerWgId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainButton = findViewById(R.id.playerSearchButton);
        playerName = findViewById(R.id.playerNameField);
        nameWgField = findViewById(R.id.nameField);
        idWgField = findViewById(R.id.wgIdField);
        arenaField = findViewById(R.id.arenaIdField);

        mainButton.setOnClickListener(view -> {
            fetchData();
            // Have to fix it secondStep(playerWgId);
            secondStep("1591667");
        });
    }

    // First Part
    private void fetchData() {
        compositeDisposable.add(ArenaAssistant.getWgApi().getWgPlayerId(playerName.getText().toString())
                .subscribeOn(Schedulers.io())
                .flatMap((Function<WgAccountInfo, Observable<ResponseBody>>) accountInfo ->
                        ArenaAssistant.getArenaApi().getArenaPlayerId(Long.toString(accountInfo.getData().get(0).getAccountID())))
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(body -> {
                    Timber.d("body: " + body.string());
                    Timber.d("body: " + body.string());
                }, throwable -> {
                    Timber.d("throwable: " + throwable.getCause());
                    Timber.d("throwable: " + throwable.getMessage());
                }));
    }

    public void displayPlayerWgName(String playerWgName) {
        nameWgField.setText("Player Name: " + playerWgName);
    }

    public void displayPlayerWgId(String playerWgId) {
        idWgField.setText("WG ID: " + playerWgId);
    }

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

    private void showArenaPlayerId(String arenaPlayerId) {
        arenaField.setText("Arena ID: " + arenaPlayerId);
    }

    // Third Part
    @Override
    public void showPlayerInfo(String playerInfo) {
        nameWgField.setText(playerInfo);
    }
}