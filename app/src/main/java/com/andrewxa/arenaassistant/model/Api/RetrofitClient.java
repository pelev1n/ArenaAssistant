package com.andrewxa.arenaassistant.model.Api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitClient {
    final static String APP_ID = "0cce5605f03c92966b3b1254a0af8509";
    final static String SERVER = "&r_realm=ru";
    final static String LANG = "language=en";
    final static String ACCOUNTINFO = "https://api.worldoftanks.ru/wgn/account/list/?";

    final static String ARENA_REQUEST_SECOND = "https://s3-eu-west-1.amazonaws.com/live-usermap.twaservers.com/wgid/1591667";
    final static String ARENA_REQUEST_THIRD = "https://s3-eu-west-1.amazonaws.com/live-caprofile-profiles.twaservers.com/";


    private static Retrofit instance;

    public static Retrofit getInstance() {
        if(instance == null)
        {
            instance = new Retrofit.Builder()
                   .baseUrl("https://api.worldoftanks.ru/wot/account/list/?"+ LANG +"&application_id="+APP_ID)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return instance;
    }

    public static void changeApiBaseUrl() {
            instance = new Retrofit.Builder()
                    .baseUrl("https://api.worldoftanks.ru/wot/account/list/?"+ LANG +"&application_id="+APP_ID)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

    }
}
