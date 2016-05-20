package bme.hu.sziaclientapp.daggerconfig;

import com.crashlytics.android.Crashlytics;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;
import com.orm.SugarApp;

import bme.hu.sziaclientapp.R;
import io.fabric.sdk.android.Fabric;

/**
 * Created by Ákos on 2016.05.05..
 */
public class SZIAClientAppApplication extends SugarApp {

    private Tracker mTracker;

    public static SZIAClientAppApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

        injector = DaggerSZIAClientAppApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }

    synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker(R.xml.global_tracker);
        }
        return mTracker;
    }
}
