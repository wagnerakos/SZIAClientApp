package bme.hu.sziaclientapp.presenters;

/**
 * Created by Ákos on 2016.05.06..
 */
public abstract class Presenter<S> {
    protected S screen;

    public void attachScreen(S screen) {
        this.screen = screen;
    }

    public void detachScreen() {
        this.screen = null;
    }
}
