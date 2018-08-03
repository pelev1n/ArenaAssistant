package com.andrewxa.arenaassistant.datasource.network;

import com.andrewxa.arenaassistant.datasource.model.arenamodel.ArenaAccInfo;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ArenaApi {

    @GET("{playerWgId}")
    Observable<ResponseBody> getArenaPlayerId(@Path("playerWgId") String playerWgId);

    @GET("{playerArenaId}.json")
    Observable<ArenaAccInfo> getArenaPlayerInfo(@Path("playerArenaId") String playerArenaId);





}
