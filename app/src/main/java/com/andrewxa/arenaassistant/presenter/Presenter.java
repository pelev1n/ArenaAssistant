package com.andrewxa.arenaassistant.presenter;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.andrewxa.arenaassistant.contract.Contract;

import java.io.IOException;

public class Presenter implements Contract.Presenter{

    Contract.View view;
    Context context;

    public Presenter(Contract.View view, Context context) {
        this.view = view;
        this.context = context;
    }

/*    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    public void getPlayerInfo(String playerName) {
        String playerInfo = null;
        try {
            playerInfo = getPlayerId(playerName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        view.showPlayerInfo(playerInfo);
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public String getPlayerId(String playerName) throws IOException {
        return  arenaApi.getPlayerId(playerName);
    }*/
}
