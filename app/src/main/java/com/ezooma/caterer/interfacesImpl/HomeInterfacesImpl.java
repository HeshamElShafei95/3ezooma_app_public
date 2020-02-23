package com.ezooma.caterer.interfacesImpl;

import com.ezooma.caterer.app.MyApplication;
import com.ezooma.caterer.app.rest.APIClientInterface;
import com.ezooma.caterer.app.rest.ResponseCallBackHandler;
import com.ezooma.caterer.app.rest.ResponseHandler;
import com.ezooma.caterer.app.rest.RestParser;
import com.ezooma.caterer.app.rest.dto.ResponseDto;
import com.ezooma.caterer.app.rest.onServerResponseCallBack;
import com.ezooma.caterer.interfaces.HomeInterface;
import com.ezooma.caterer.models.categoriesModels.CategoriesAndDaysModel;
import com.ezooma.caterer.models.notificationModels.NotificationModel;
import com.ezooma.caterer.models.servicesModels.ServicesAndDaysModel;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import net.rajpals.common.logger.AppLogger;

import java.util.Map;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Retrofit;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public class HomeInterfacesImpl implements HomeInterface {
    public static final String TAG = HomeInterfacesImpl.class.getSimpleName();

    private Gson mGson;
    private APIClientInterface mAPIClientInterface;

    public HomeInterfacesImpl() {
        mGson = MyApplication.getMyApplicationInstance().getGsonBuilder();
        if (mGson == null)
            throw new RuntimeException("Gson object can not be empty");

        Retrofit retrofit = MyApplication.getMyApplicationInstance().getRetrofitClient(mGson);
        if (retrofit == null)
            throw new RuntimeException("Retrofit object can not created");

        mAPIClientInterface = retrofit.create(APIClientInterface.class);
    }

    @Override
    public void getCategoriesApi(final ResponseCallBackHandler pResponseCallBackHandler) {
        try {
            Call<ResponseDto> call = mAPIClientInterface.getCategories();
            RestParser.getRequestToServer(call, new onServerResponseCallBack() {
                @Override
                public void onServerResponse(ResponseHandler responseHandler) {
                    if (responseHandler.isExecuted()) {
                        String response = responseHandler.getValue().toString();
                        CategoriesAndDaysModel lCategoriesAndDaysModel = mGson.fromJson(response, new TypeToken<CategoriesAndDaysModel>() {
                        }.getType());
                        responseHandler.setValue(lCategoriesAndDaysModel);
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
    public void notificationsApi(final ResponseCallBackHandler pResponseCallBackHandler, Map<String, Object> params) {
        try {
            Call<ResponseDto> call = mAPIClientInterface.notificationApi(params);
            RestParser.getRequestToServer(call, new onServerResponseCallBack() {
                @Override
                public void onServerResponse(ResponseHandler responseHandler) {
                    if (responseHandler.isExecuted()) {
                        String response = responseHandler.getValue().toString();
                        NotificationModel lNotificationModel = mGson.fromJson(response, new TypeToken<NotificationModel>() {
                        }.getType());
                        responseHandler.setValue(lNotificationModel);
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
    public void addSubCategoryApi(ResponseCallBackHandler pResponseCallBackHandler, MultipartBody subCategoryData) {

    }

    @Override
    public void addNewItem(ResponseCallBackHandler pResponseCallBackHandler, MultipartBody newItemData) {

    }

    @Override
    public void getAddedMenuCategories(ResponseCallBackHandler pResponseCallBackHandler, Map<String, Object> params) {

    }

    @Override
    public void getCategoryMenuItems(ResponseCallBackHandler pResponseCallBackHandler, Map<String, Object> params) {

    }

    @Override
    public void deleteAddedCategory(ResponseCallBackHandler pResponseCallBackHandler, Map<String, Object> params) {

    }

    @Override
    public void editAddedCategory(ResponseCallBackHandler pResponseCallBackHandler, Map<String, Object> params) {

    }

    @Override
    public void deleteCategoryItem(ResponseCallBackHandler pResponseCallBackHandler, Map<String, Object> params) {

    }

    @Override
    public void editCategoryItem(ResponseCallBackHandler pResponseCallBackHandler, Map<String, Object> params) {

    }
}
