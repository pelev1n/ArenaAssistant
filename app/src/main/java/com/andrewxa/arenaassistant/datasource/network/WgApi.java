package com.andrewxa.arenaassistant.datasource.network;

import com.andrewxa.arenaassistant.datasource.model.wgmodel.WgAccInfo;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface WgApi {

    @GET(" ")
    Observable<WgAccInfo> getWgPlayerId(@Query("search") String playerName);
}
