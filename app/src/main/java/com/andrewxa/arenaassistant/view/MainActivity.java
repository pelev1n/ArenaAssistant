package com.andrewxa.arenaassistant.view;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.andrewxa.arenaassistant.R;
import com.andrewxa.arenaassistant.contract.Contract;
import com.andrewxa.arenaassistant.model.Api.ArenaApi;
import com.andrewxa.arenaassistant.model.Api.RetrofitClient;
import com.andrewxa.arenaassistant.model.Api.RetrofitClientArena;
import com.andrewxa.arenaassistant.model.Api.WgApi;
import com.andrewxa.arenaassistant.model.GsonSerialized.Wg.WgAccountInfo;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements Contract.View {
    Button mainButton;
    EditText playerName;
    TextView nameWgField;
    TextView arenaField;
    TextView idWgField;

    Retrofit retrofit;
    WgApi wgApi;
    ArenaApi arenaApi;
    CompositeDisposable compositeDisposable = new CompositeDisposable();
    String playerWgName;
    public String playerWgId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();*/

        mainButton = (Button) findViewById(R.id.playerSearchButton);
        playerName = (EditText) findViewById(R.id.playerNameField);
        nameWgField = (TextView) findViewById(R.id.nameField);
        idWgField = (TextView) findViewById(R.id.wgIdField);
        arenaField = (TextView) findViewById(R.id.arenaIdField);

        retrofit = RetrofitClient.getInstance();
        wgApi = retrofit.create(WgApi.class);


        mainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fetchData();

                /*while (playerWgId == null) {
                    continue;
                }*/

                secondStep(playerWgId);
            }


        });

    }


    // First Part
    private void fetchData() {
        compositeDisposable.add(wgApi.getWgPlayerId(playerName.getText().toString())
        .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<WgAccountInfo>() {
                    @Override
                    public void accept(WgAccountInfo wgAccountInfo) throws Exception {
                        playerWgName = wgAccountInfo.getData().get(0).getNickname();
                        playerWgId = Long.toString(wgAccountInfo.getData().get(0).getAccountID());

                        displayPlayerWgName(playerWgName);
                        displayPlayerWgId(playerWgId);

                    }
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

        retrofit = RetrofitClientArena.getInstance();
        arenaApi = retrofit.create(ArenaApi.class);

        getSecondRequest(playerWgId);
    }

    // Second Part
    private void getSecondRequest(String playerId) {

        compositeDisposable.add(
                arenaApi.getArenaPlayerId(playerId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResponseBody>() {

                    @Override
                    public void accept(ResponseBody responseBody) throws Exception {
                        showArenaPlayerId(responseBody.string());
                    }

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
