package com.andrewxa.arenaassistant;

import android.app.Application;

import com.andrewxa.arenaassistant.datasource.network.ArenaApi;
import com.andrewxa.arenaassistant.datasource.network.WgApi;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.andrewxa.arenaassistant.utils.Constants.APP_ID;
import static com.andrewxa.arenaassistant.utils.Constants.LANG;

/**
 * Created by Caramel Heaven on 02.08.2018
 */
public class ArenaAssistant extends Application {

    private static ArenaAssistant application;
    private static ArenaApi arenaApi;
    private static ArenaApi arenaInfoApi;
    private static WgApi wgApi;

    @Override
    public void onCreate() {
        super.onCreate();

        application = this;

        arenaApi = initArena().create(ArenaApi.class);
        wgApi = initWg().create(WgApi.class);
        arenaInfoApi = initArenaInfo().create(ArenaApi.class);
    }

    public static ArenaAssistant getApplication() {
        return application;
    }

    public static void setApplication(ArenaAssistant application) {
        ArenaAssistant.application = application;
    }

    public static ArenaApi getArenaApi() {
        return arenaApi;
    }

    public static WgApi getWgApi() {
        return wgApi;
    }

    public static ArenaApi getArenaInfoApi() {
        return arenaInfoApi;
    }

    private static Retrofit initArena() {
        return new Retrofit.Builder()
                .baseUrl(baseUrlArena())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(initClient())
                .build();
    }

    private static Retrofit initWg() {
        return new Retrofit.Builder()
                .baseUrl(baseUrlOther())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(initClient())
                .build();
    }

    private static Retrofit initArenaInfo() {
        return new Retrofit.Builder()
                .baseUrl(baseUrlArenaInfo())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(initClient())
                .build();
    }

    private static OkHttpClient initClient() {
        OkHttpClient.Builder builderArena = initBuilder();
        OkHttpClient client = builderArena.build();
        return client;
    }

    private static OkHttpClient.Builder initBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.connectTimeout(5, TimeUnit.SECONDS);
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(interceptor);
        }
        return builder;
    }

    private static String baseUrlArena() {
        return "https://s3-eu-west-1.amazonaws.com/live-usermap.twaservers.com/wgid/";
    }

    private static String baseUrlOther() {
        return "https://api.worldoftanks.ru/wot/account/list/?" + LANG + "&application_id=" + APP_ID;
    }

    private static String baseUrlArenaInfo() {
        return "https://s3-eu-west-1.amazonaws.com/live-caprofile-profiles.twaservers.com/public/";
    }


}
