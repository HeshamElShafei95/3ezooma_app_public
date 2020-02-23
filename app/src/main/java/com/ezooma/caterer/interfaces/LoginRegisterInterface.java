package com.ezooma.caterer.interfaces;

import com.ezooma.caterer.app.rest.ResponseCallBackHandler;

import java.util.Map;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public interface LoginRegisterInterface {

    void getServicesAndDaysApi(ResponseCallBackHandler pResponseCallBackHandler);

    void registerApi(ResponseCallBackHandler pResponseCallBackHandler, Map<String, Object> pMap);

    void forgotPasswordApi(ResponseCallBackHandler pResponseCallBackHandler, Map<String, Object> pMap);

    void loginApi(ResponseCallBackHandler pResponseCallBackHandler, Map<String, Object> pMap);

    void logoutApi(ResponseCallBackHandler pResponseCallBackHandler, Map<String, Object> pMap);


}
