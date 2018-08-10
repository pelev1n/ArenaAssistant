package com.andrewxa.arenaassistant.datasource.repository;

import com.andrewxa.arenaassistant.ArenaAssistant;
import com.andrewxa.arenaassistant.datasource.model.arenamodel.ArenaAccInfo;
import com.andrewxa.arenaassistant.datasource.model.wgmodel.WgAccInfo;
import com.andrewxa.arenaassistant.ui.main.presenter.MainPresenterImpl;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import okhttp3.ResponseBody;

public class Repository {

    private static volatile Repository instance;

    private Repository() {

    }

    public static Repository getInstance() {
        if (instance == null) {
            synchronized (MainPresenterImpl.class) {
                if (instance == null) {
                    instance = new Repository();
                }
            }
        }
        return instance;
    }

    public Observable<ArenaAccInfo> getAccountInfo(String playerName) {
        return ArenaAssistant.getWgApi().getWgPlayerId(playerName)
                .flatMap((Function<WgAccInfo, Observable<ResponseBody>>) wgAccInfo -> {
                    //playerWgId = Long.toString(wgAccInfo.getData().get(0).getAccountID());
                    return ArenaAssistant.getArenaApi().getArenaPlayerId(Long
                            .toString(wgAccInfo.getData().get(0).getAccountID()));
                })
                .flatMap((Function<ResponseBody, Observable<ArenaAccInfo>>) responseBody ->
                        ArenaAssistant.getArenaInfoApi().getArenaPlayerInfo(responseBody.string()));
    }
}
