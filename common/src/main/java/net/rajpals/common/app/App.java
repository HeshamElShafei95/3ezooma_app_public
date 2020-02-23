package net.rajpals.common.app;

import net.rajpals.common.LibApp;

/**
 * Created by Gurvinder Rajpal on 10-04-2018.
 */

public class App extends LibApp implements AppLifecycleHandler.LifeCycleDelegate {

    private AppLifecycleHandler lifeCycleHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        lifeCycleHandler = new AppLifecycleHandler(this);
        registerLifecycleHandler(lifeCycleHandler);
    }

    @Override
    public void onAppBackgrounded() {

    }

    @Override
    public void onAppForegrounded() {

    }

    private void registerLifecycleHandler(AppLifecycleHandler lifeCycleHandler) {
        registerActivityLifecycleCallbacks(lifeCycleHandler);
        registerComponentCallbacks(lifeCycleHandler);
    }


}
