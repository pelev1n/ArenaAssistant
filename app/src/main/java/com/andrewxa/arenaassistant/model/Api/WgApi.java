package com.andrewxa.arenaassistant.model.Api;

import com.andrewxa.arenaassistant.model.GsonSerialized.Wg.WgAccountInfo;


import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface WgApi {

    @GET(" ")
    Observable<WgAccountInfo> getWgPlayerId(@Query("search") String playerName);
}
