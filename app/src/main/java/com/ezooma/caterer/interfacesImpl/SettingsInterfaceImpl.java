package com.ezooma.caterer.interfacesImpl;

import com.ezooma.caterer.app.MyApplication;
import com.ezooma.caterer.app.rest.APIClientInterface;
import com.ezooma.caterer.app.rest.ResponseCallBackHandler;
import com.ezooma.caterer.interfaces.SettingsInterface;
import com.google.gson.Gson;

import java.util.Map;

import retrofit2.Retrofit;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public class SettingsInterfaceImpl implements SettingsInterface {
    public static final String TAG = SettingsInterfaceImpl.class.getSimpleName();

    private Gson mGson;
    private APIClientInterface mAPIClientInterface;

    public SettingsInterfaceImpl() {
        mGson = MyApplication.getMyApplicationInstance().getGsonBuilder();
        if (mGson == null)
            throw new RuntimeException("Gson object can not be empty");

        Retrofit retrofit = MyApplication.getMyApplicationInstance().getRetrofitClient(mGson);
        if (retrofit == null)
            throw new RuntimeException("Retrofit object can not created");

        mAPIClientInterface = retrofit.create(APIClientInterface.class);
    }

    @Override
    public void logoutApi(ResponseCallBackHandler pResponseCallBackHandler, Map<String, Object> params) {

    }

    @Override
    public void termsANdConditionsApi(ResponseCallBackHandler pResponseCallBackHandler) {

    }

    @Override
    public void businessSettingsApi(ResponseCallBackHandler pResponseCallBackHandler) {

    }

    @Override
    public void privacyPolicyApi(ResponseCallBackHandler pResponseCallBackHandler) {

    }

    @Override
    public void aboutUsApi(ResponseCallBackHandler pResponseCallBackHandler) {

    }

    @Override
    public void changePasswordApi(ResponseCallBackHandler pResponseCallBackHandler, Map<String, Object> params) {

    }
}
