package com.andrewxa.arenaassistant.ui.main.presenter;

import com.andrewxa.arenaassistant.datasource.model.arenamodel.ArenaAccInfo;

public interface MainView {

    void showLoading();

    void stopLoading();

    void showInformation(ArenaAccInfo arenaAccInfo);

    void refreshInformation(ArenaAccInfo arenaAccInfo);

    String searchUser();
}
