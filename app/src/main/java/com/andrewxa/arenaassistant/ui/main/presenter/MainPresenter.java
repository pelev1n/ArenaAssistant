package com.andrewxa.arenaassistant.ui.main.presenter;

import android.content.Context;

/**
 * Created by Caramel Heaven on 02.08.2018
 */
public class MainPresenter implements Contract.Presenter {
    Contract.View view;
    Context context;

    public MainPresenter(Contract.View view, Context context) {
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
