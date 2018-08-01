package com.andrewxa.arenaassistant.model.Api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClientArena {

    final static String ARENA_REQUEST_SECOND = "https://s3-eu-west-1.amazonaws.com/live-usermap.twaservers.com/wgid/";
    private static Retrofit instance;

    public static Retrofit getInstance() {
        if(instance == null)
        {
            instance = new Retrofit.Builder()
                    .baseUrl(ARENA_REQUEST_SECOND)
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return instance;
    }

}
