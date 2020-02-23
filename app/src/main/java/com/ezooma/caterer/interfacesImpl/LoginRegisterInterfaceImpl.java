package com.ezooma.caterer.interfacesImpl;

import com.ezooma.caterer.app.MyApplication;
import com.ezooma.caterer.app.rest.APIClientInterface;
import com.ezooma.caterer.app.rest.ResponseCallBackHandler;
import com.ezooma.caterer.app.rest.ResponseHandler;
import com.ezooma.caterer.app.rest.RestParser;
import com.ezooma.caterer.app.rest.dto.ResponseDto;
import com.ezooma.caterer.app.rest.onServerResponseCallBack;
import com.ezooma.caterer.interfaces.LoginRegisterInterface;
import com.ezooma.caterer.models.categoriesModels.CategoriesAndDaysModel;
import com.ezooma.caterer.models.servicesModels.ServicesAndDaysModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.rajpals.common.logger.AppLogger;

import java.util.Map;

import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public class LoginRegisterInterfaceImpl implements LoginRegisterInterface {
    public static final String TAG = LoginRegisterInterfaceImpl.class.getSimpleName();

    private Gson mGson;
    private APIClientInterface mAPIClientInterface;

    public LoginRegisterInterfaceImpl() {
        mGson = MyApplication.getMyApplicationInstance().getGsonBuilder();
        if (mGson == null)
            throw new RuntimeException("Gson object can not be empty");

        Retrofit retrofit = MyApplication.getMyApplicationInstance().getRetrofitClient(mGson);
        if (retrofit == null)
            throw new RuntimeException("Retrofit object can not created");

        mAPIClientInterface = retrofit.create(APIClientInterface.class);
    }


    @Override
    public void getServicesAndDaysApi(final ResponseCallBackHandler pResponseCallBackHandler) {
        try {
            Call<ResponseDto> call = mAPIClientInterface.getServicesAndDays();
            RestParser.getRequestToServer(call, new onServerResponseCallBack() {
                @Override
                public void onServerResponse(ResponseHandler responseHandler) {
                    if (responseHandler.isExecuted()) {
                        String response = responseHandler.getValue().toString();
                        ServicesAndDaysModel lServicesAndDaysModel = mGson.fromJson(response, new TypeToken<ServicesAndDaysModel>() {
                        }.getType());
                        responseHandler.setValue(lServicesAndDaysModel);
                    }
                    pResponseCallBackHandler.returnResponse(responseHandler);
                }
            });
        } catch (Exception ex) {
            if (pResponseCallBackHandler != null)
                pResponseCallBackHandler.returnResponse(new ResponseHandler());
            AppLogger.Logger.error(TAG, ex.getMessage(), ex);
        }
    }

    @Override
    public void registerApi(ResponseCallBackHandler pResponseCallBackHandler, Map<String, Object> pMap) {

    }

    @Override
    public void forgotPasswordApi(ResponseCallBackHandler pResponseCallBackHandler, Map<String, Object> pMap) {

    }

    @Override
    public void loginApi(ResponseCallBackHandler pResponseCallBackHandler, Map<String, Object> pMap) {

    }

    @Override
    public void logoutApi(ResponseCallBackHandler pResponseCallBackHandler, Map<String, Object> pMap) {

    }
}
