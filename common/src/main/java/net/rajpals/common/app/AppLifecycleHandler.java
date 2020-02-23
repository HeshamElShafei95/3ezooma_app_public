package net.rajpals.common.app;


import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;

public class AppLifecycleHandler implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2 {

    private final LifeCycleDelegate mLifeCycleDelegate;
    private boolean appInForeground = false;

    public AppLifecycleHandler(LifeCycleDelegate lifeCycleDelegate) {
        mLifeCycleDelegate = lifeCycleDelegate;
    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {
        if (!appInForeground) {
            appInForeground = true;
            mLifeCycleDelegate.onAppForegrounded();
        }
    }


    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivityCreated(Activity activity, Bundle savedInstanceState) {

    }

    @Override
    public void onLowMemory() {

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {

    }

    @Override
    public void onTrimMemory(int level) {
        if (level == ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN) {
            appInForeground = false;
            mLifeCycleDelegate.onAppBackgrounded();
        }
    }

    interface LifeCycleDelegate {
        void onAppBackgrounded();
        void onAppForegrounded();
    }

}
