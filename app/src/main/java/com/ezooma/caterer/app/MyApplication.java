package com.ezooma.caterer.app;

import android.app.Application;
import android.content.Context;

import com.ezooma.caterer.R;
import com.ezooma.caterer.app.rest.APIClientInterface;
import com.ezooma.caterer.interfaces.UserSession;
import com.ezooma.caterer.interfacesImpl.UserSessionImpl;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import net.rajpals.common.logger.AppLogger;
import net.rajpals.common.utilities.PreferencesUtil;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.ezooma.caterer.utilities.AppConstants.PREFERENCE_MODE;
import static com.ezooma.caterer.utilities.AppConstants.PREFERENCE_NAME;


public class MyApplication extends Application {

    private static MyApplication myApplication;

    private Gson mGson;
    private Retrofit mRetrofitClient;
    private PreferencesUtil mPreferencesUtil;
    private UserSession mUserSession;
    private ImageLoader mImageLoader;
    private HttpLoggingInterceptor mHttpLoggingInterceptor;

    @Override
    public void onCreate() {
        super.onCreate();
        /*Fabric.with(this, new Crashlytics());*/
        // FirebaseApp.initializeApp(this);
        myApplication = this;

        // getImageLoader();
    }

    public static synchronized MyApplication getMyApplicationInstance() {
        return myApplication;
    }

    public Context getContext() {
        return this;
    }

    /*  // get GSON Object
      public Gson getGsonBuilder() {
          if (mGson == null)
              mGson = new GsonBuilder()
                      .enableComplexMapKeySerialization()
                      .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                      .setPrettyPrinting()
                      .setVersion(1.0)
                      .setLenient()
                      .create();
          return mGson;
      }*/
// get GSON Object
    public Gson getGsonBuilder() {
        if (mGson == null)
            mGson = new GsonBuilder()
                    .enableComplexMapKeySerialization()
                    .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                    .setPrettyPrinting()
                    .setVersion(1.0)
                    /*.excludeFieldsWithoutExposeAnnotation()*/
                    .setLenient()
                    .create();
        return mGson;
    }


    // get shared preference
    public PreferencesUtil getPreferencesUtil() {
        if (mPreferencesUtil == null)
            mPreferencesUtil = new PreferencesUtil(getMyApplicationInstance().getSharedPreferences(PREFERENCE_NAME, PREFERENCE_MODE));
        return mPreferencesUtil;
    }

    // get User sessions
    public UserSession getUserSession() {
        if (mUserSession == null) {
            mUserSession = new UserSessionImpl(getPreferencesUtil(), getGsonBuilder());
        }
        return mUserSession;
    }

    /**
     * get universal image loader for show the image from server
     *
     * @return
     */
    public ImageLoader getImageLoader() {
        if (mImageLoader == null) {
            DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()
                    .cacheInMemory(true)
                    .cacheOnDisk(true)
                    .considerExifParams(true)
                    .showImageOnFail(R.drawable.logo_orange)
                    .showImageForEmptyUri(R.drawable.logo_orange)
                    .build();
            ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                    .defaultDisplayImageOptions(defaultOptions)
                    .build();
            ImageLoader.getInstance().init(config); // Do it on Application start

            mImageLoader = ImageLoader.getInstance();
        }
        return mImageLoader;
    }

    // get Retrofit object
    public Retrofit getRetrofitClient(Gson gson) {
        if (mRetrofitClient == null) {
            mHttpLoggingInterceptor = new HttpLoggingInterceptor();
            mHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(5, TimeUnit.MINUTES)
                    .readTimeout(5, TimeUnit.MINUTES)
                    .writeTimeout(5, TimeUnit.MINUTES);


            if (AppLogger.DEBUG) {
                okHttpClient.addInterceptor(mHttpLoggingInterceptor);
            }

            OkHttpClient client = okHttpClient.build();
            mRetrofitClient = new Retrofit.Builder()
                    .baseUrl(APIClientInterface.BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }
        return mRetrofitClient;
    }
}
