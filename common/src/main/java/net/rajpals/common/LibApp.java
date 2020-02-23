package net.rajpals.common;

import android.app.Application;
import android.content.Context;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.rajpals.common.logger.AppLogger;

/**
 * Base class for those who need to maintain global application state.
 */
public class LibApp extends Application {


    private final static String TAG = LibApp.class.getName();
    /**
     * Instance of the current application.
     */
    private static LibApp instance;
    private Gson mGson;
    /**
     * Constructor.
     */
    public LibApp() {
        instance = this;
    }

    /**
     * Gets the application context.
     *
     * @return the application context
     */
    public  Context getContext() {
        return instance;
    }
    public static LibApp getInstance() {
        return instance;
    }





    public static void showException(String tag,Exception ex) {
        AppLogger.Logger.error(tag,ex.getMessage(),ex);
    }

    // get GSON Object
    public Gson getGsonBuilder() {
        if (mGson == null)
            mGson = new GsonBuilder()
                    .enableComplexMapKeySerialization()
                    .excludeFieldsWithoutExposeAnnotation()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .setPrettyPrinting()
                    .setVersion(1.0)
                    .setLenient()
                    .create();
        return mGson;
    }




}