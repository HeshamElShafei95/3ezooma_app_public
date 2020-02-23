package com.ezooma.caterer.interfaces;

import com.ezooma.caterer.app.rest.ResponseCallBackHandler;

import java.util.Map;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public interface SettingsInterface {
    void logoutApi(ResponseCallBackHandler pResponseCallBackHandler, Map<String, Object> params);

    void termsANdConditionsApi(ResponseCallBackHandler pResponseCallBackHandler);

    void businessSettingsApi(ResponseCallBackHandler pResponseCallBackHandler);

    void privacyPolicyApi(ResponseCallBackHandler pResponseCallBackHandler);

    void aboutUsApi(ResponseCallBackHandler pResponseCallBackHandler);

    void changePasswordApi(ResponseCallBackHandler pResponseCallBackHandler, Map<String, Object> params);
}
