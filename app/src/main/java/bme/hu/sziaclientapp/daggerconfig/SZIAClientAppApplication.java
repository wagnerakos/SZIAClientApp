package bme.hu.sziaclientapp.daggerconfig;

import com.orm.SugarApp;

/**
 * Created by Ákos on 2016.05.05..
 */
public class SZIAClientAppApplication extends SugarApp {

    public static SZIAClientAppApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector = DaggerSZIAClientAppApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }
}
