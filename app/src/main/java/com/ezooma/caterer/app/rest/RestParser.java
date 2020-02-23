package com.ezooma.caterer.app.rest;

import android.content.Context;

import com.ezooma.caterer.R;
import com.ezooma.caterer.app.MyApplication;
import com.ezooma.caterer.app.rest.dto.ResponseDto;
import com.google.gson.Gson;

import net.rajpals.common.logger.AppLogger;
import net.rajpals.common.receivers.ConnectivityReceiver;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RestParser {

    private static final String TAG = RestParser.class.getName();
    private static Gson mGson = MyApplication.getMyApplicationInstance().getGsonBuilder();
    private static Context mContext = MyApplication.getMyApplicationInstance().getContext();
    private final static String ERROR_INTERNET = MyApplication.getMyApplicationInstance().getContext().getString(R.string.error_internet_connection);

    private static final String STATUS_SUCCESS = "true";
    private static final boolean STATUS_Result = true;


    /**
     * Handle response response dto.
     *
     * @param response the response
     * @return the response dto
     */
    static ResponseHandler handleResponse(Response<ResponseDto> response) {
        ResponseHandler responseHandler = new ResponseHandler();
        try {
            if (response == null) {//SERVER RESPONSE : null
                throw new RuntimeException(mContext.getString(R.string.error_invalid_response));
            } else if (!response.isSuccessful() || response.body() == null) {  //SERVER RESPONSE : some error at server or required response body is null
                throw new RuntimeException(response.errorBody().toString());
            }

            //SERVER RESPONSE : get server response ,but there is some error with service (May be authentication , parameter etc.)
            ResponseDto responseDto = response.body();
            //SERVER RESPONSE : We did it! Successful response.
            /*if (responseDto.getResponseCode() != HttpURLConnection.HTTP_OK) {
                responseHandler.setResponseCode(responseDto.getResponseCode());
                throw new RuntimeException(responseDto.getResponseMessage());
            }*/

            if (responseDto.ismStatus()) {

                responseHandler.setResponseCode(responseDto.getResponseCode());
                //  throw new RuntimeException(responseDto.getResponseMessage());
            } else {
                throw new RuntimeException(responseDto.getResponseMessage());
            }

            responseHandler.setExecuted(responseDto.ismStatus());
            responseHandler.setMessage(responseDto.getResponseMessage());
            responseHandler.setResponseCode(responseDto.getResponseCode());
            /*responseHandler.setEndDate(responseDto.getLastDate());
            responseHandler.setPlanType(responseDto.getPlanType());
            responseHandler.setPurchaseDate(responseDto.getPurchasedDate());
            responseHandler.setSubscribedEver(responseDto.isSubscribedEver());
            responseHandler.setSubscrictionIsActive(responseDto.isSubscriptionIsactive());*/

            if (responseDto.getResponseBody() != null) {
                responseHandler.setValue(mGson.toJson(responseDto.getResponseBody()));
            } else {
                responseHandler.setValue(null);
            }
        } catch (Exception ex) {
            responseHandler.setMessage(ex.getMessage());
            //  AppLogger.showToast(TAG,ex.getMessage());
            return responseHandler;
        }
        return responseHandler;
    }

    // Common rest call

    public static void getRequestToServer(final Call<ResponseDto> call, final onServerResponseCallBack onServerResponseCallBack) {
        try {
            if (ConnectivityReceiver.isConnected(mContext)) {
                call.enqueue(new Callback<ResponseDto>() {
                    @Override
                    public void onResponse(Call<ResponseDto> call, Response<ResponseDto> response) {
                        ResponseHandler responseHandler = handleResponse(response);
                        onServerResponseCallBack.onServerResponse(responseHandler);
                    }

                    @Override
                    public void onFailure(Call<ResponseDto> call, Throwable ex) {
                        AppLogger.Logger.error(TAG, ex.getMessage(), ex);

                        onServerResponseCallBack.onServerResponse(new ResponseHandler(ex.getMessage()));
                    }
                }
                );
            } else {
                onServerResponseCallBack.onServerResponse(new ResponseHandler(ERROR_INTERNET));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static MultipartBody.Builder getMultiPartRequestBody(Object classObject) {
        return createMultiPartForm(createFieldsMap(classObject));
    }

    public static HashMap<String, Object> createFieldsMap(Object classObject) {
        FieldMapHelper mapHelper = new FieldMapHelper(classObject);
        return mapHelper.getFieldMap();
    }

    private static MultipartBody.Builder createMultiPartForm(HashMap<String, Object> hashMap) {

        MultipartBody.Builder mBuilder = new MultipartBody.Builder();
        mBuilder.setType(MultipartBody.FORM);
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            if (entry.getValue() == null) {
                mBuilder.addFormDataPart(entry.getKey(), "");
            } else if (entry.getValue() instanceof ArrayList) {
                for (Object value : (ArrayList) entry.getValue()) {
                    addParameterToBuilder(mBuilder, entry.getKey(), value);
                }
            } else {
                addParameterToBuilder(mBuilder, entry.getKey(), entry.getValue());
               /* if (entry.getValue() instanceof File) {
                    mBuilder.addFormDataPart(entry.getKey(), ((File) entry.getValue()).getName(), getRequestBody(((File) entry.getValue())));
                } else {
                    mBuilder.addFormDataPart(entry.getKey(), String.valueOf(entry.getValue()));
                }*/
            }
        }
        return mBuilder;
    }

    private static void addParameterToBuilder(MultipartBody.Builder mBuilder, String key, Object value) {
        if (value instanceof File) {
            mBuilder.addFormDataPart(key, ((File) value).getName(), getRequestBody(((File) value)));
        } else {
            mBuilder.addFormDataPart(key, String.valueOf(value));
        }
    }

    private static RequestBody getRequestBody(File file) {
        return RequestBody.create(MediaType.parse("multipart/form-data"), file);
    }

    /*   private static MultipartBody.Builder createMultiPartForm(HashMap<String, Object> hashMap) {
        MultipartBody.Builder mBuilder = new MultipartBody.Builder();
        mBuilder.setMenuId(MultipartBody.FORM);
        for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
            System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
            if (entry.getValue() == null) {
                mBuilder.addFormDataPart(entry.getKey(), "");
            } else {
                if (entry.getValue() instanceof File) {
                    mBuilder.addFormDataPart(entry.getKey(), ((File) entry.getValue()).getName(), getRequestBody(((File) entry.getValue())));
                } else {
                    mBuilder.addFormDataPart(entry.getKey(), String.valueOf(entry.getValue()));
                }
            }
        }
        return mBuilder;
    }*/
}
