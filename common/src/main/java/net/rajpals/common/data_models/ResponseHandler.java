package net.rajpals.common.data_models;


/**
 * Created by Gurvinder Rajpal on 13/07/18.
 */
public class ResponseHandler<T> {
    private boolean mExecuted;
    private String mMessage;
    private int mResponseCode = -1;
    private T value;

    public ResponseHandler() {
        this.mExecuted = false;
        this.mMessage = "Something went wrong";
        this.value = null;
    }

    public ResponseHandler(String message) {
        this.mExecuted = false;
        this.mMessage = message;
        this.value = null;
    }

    public boolean isExecuted() {
        return mExecuted;
    }

    public void setExecuted(boolean executed) {
        this.mExecuted = executed;
    }

    public void setResponseCode(int responseCode) {
        mResponseCode = responseCode;
    }

    public int getResponseCode() {
        return mResponseCode;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "ResponseHandler{" +
                "mExecuted=" + mExecuted +
                ", mMessage='" + mMessage + '\'' +
                ", mResponseCode=" + mResponseCode +
                ", value=" + value +
                '}';
    }

    public void copy(ResponseHandler<String> responseHandler) {
        this.mExecuted = responseHandler.isExecuted();
        this.mMessage = responseHandler.getMessage();
        this.mResponseCode = responseHandler.getResponseCode();

    }
}