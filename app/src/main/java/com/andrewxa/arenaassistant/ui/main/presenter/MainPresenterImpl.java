package com.andrewxa.arenaassistant.ui.main.presenter;

import com.andrewxa.arenaassistant.datasource.model.arenamodel.ArenaAccInfo;
import com.andrewxa.arenaassistant.datasource.repository.Repository;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Caramel Heaven on 02.08.2018
 */
public class MainPresenterImpl {

    public static ArenaAccInfo arenaAcc;
    private static volatile MainPresenterImpl instance;
    private static ArenaAccInfo arenaInfoCache = null;

    private static CompositeDisposable disposable;
    private static Repository repository;
    private static MainView getViewState;

    private MainPresenterImpl() {
        if (instance != null) {
            throw new RuntimeException("reflection api");
        }
    }

    public static MainPresenterImpl getInstance(MainView mainView) {
        getViewState = mainView;
        if (instance == null) {
            synchronized (MainPresenterImpl.class) {
                if (instance == null) {
                    repository = Repository.getInstance();
                    disposable = new CompositeDisposable();
                    instance = new MainPresenterImpl();
                }
            }
        }
        return instance;
    }

    public static void searchUserFromNet() {
        String userName = getViewState.searchUser();
        getViewState.showLoading();
        disposable.add(repository.getAccountInfo(userName)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(arenaAccInfo -> {
                    arenaAcc = arenaAccInfo;
                    getViewState.stopLoading();
                    arenaInfoCache = arenaAccInfo;
                    getViewState.showInformation(arenaAccInfo);
                }));
    }

    public static void checkingCache() {
        if (arenaInfoCache != null) {
            getViewState.showInformation(arenaInfoCache);
        }
    }
}