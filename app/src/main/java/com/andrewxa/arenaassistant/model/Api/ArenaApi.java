package com.andrewxa.arenaassistant.model.Api;

import com.andrewxa.arenaassistant.model.GsonSerialized.Wg.WgAccountInfo;

import io.reactivex.Observable;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ArenaApi {

    @GET("{playerarena}")
    Observable<ResponseBody> getArenaPlayerId(@Path("playerarena") String playerArenaId);





}
