package net.rajpals.common.callbacks;


import net.rajpals.common.data_models.ResponseHandler;


public interface onServerResponseCallBack<T> {
    void onServerResponse(ResponseHandler<T> responseHandler);
}