package bme.hu.sziaclientapp.presenters;

import javax.inject.Inject;

import bme.hu.sziaclientapp.screens.MenuScreen;

/**
 * Created by mobsoft on 2016. 04. 08..
 */
public class MenuPresenter {

    MenuScreen menuScreen;

    public MenuPresenter(MenuScreen menuScreen) {
        this.menuScreen = menuScreen;
    }


    public void flightsButtonPressed() {
        menuScreen.showToast("Flights button pressed");
    }
}
