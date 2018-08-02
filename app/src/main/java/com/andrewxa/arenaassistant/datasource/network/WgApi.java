package com.andrewxa.arenaassistant.datasource.network;

import com.andrewxa.arenaassistant.datasource.model.WgAccountInfo;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface WgApi {

    @GET(" ")
    Observable<WgAccountInfo> getWgPlayerId(@Query("search") String playerName);
}
