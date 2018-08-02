package com.andrewxa.arenaassistant.datasource.network;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ArenaApi {

    @GET("{playerarena}")
    Observable<ResponseBody> getArenaPlayerId(@Path("playerarena") String playerArenaId);





}
