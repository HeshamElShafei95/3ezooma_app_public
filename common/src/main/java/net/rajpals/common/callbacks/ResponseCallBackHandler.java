package net.rajpals.common.callbacks;


import net.rajpals.common.data_models.ResponseHandler;

/**
 * Author - J.K.Joshi
 * Date -  25-10-2016.
 */

public interface ResponseCallBackHandler<T> {
    void  returnResponse(ResponseHandler<T> responseHandler);
}
