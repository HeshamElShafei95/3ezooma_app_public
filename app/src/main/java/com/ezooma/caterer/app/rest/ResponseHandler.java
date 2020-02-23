package com.ezooma.caterer.app.rest;

import android.content.Context;

import com.ezooma.caterer.R;
import com.ezooma.caterer.app.MyApplication;



public class ResponseHandler {

    private boolean mExecuted;
    private String mMessage;
    private Object value;
    private String mResponseCode;
    private String mStatus;
/*
    private String endDate;
    private String purchaseDate;
    private boolean subscribedEver;
    private boolean subscrictionIsActive;
    private String planType;
*/

/*
    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String pEndDate) {
        endDate = pEndDate;
    }

    public String getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(String pPurchaseDate) {
        purchaseDate = pPurchaseDate;
    }

    public boolean isSubscribedEver() {
        return subscribedEver;
    }

    public void setSubscribedEver(boolean pSubscribedEver) {
        subscribedEver = pSubscribedEver;
    }

    public boolean isSubscrictionIsActive() {
        return subscrictionIsActive;
    }

    public void setSubscrictionIsActive(boolean pSubscrictionIsActive) {
        subscrictionIsActive = pSubscrictionIsActive;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String pPlanType) {
        planType = pPlanType;
    }
*/

    public String getmStatus() {
        return mStatus;
    }

    public void setmStatus(String mStatus) {
        this.mStatus = mStatus;
    }

    public String getResponseCode() {
        return mResponseCode;
    }

    public void setResponseCode(String responseCode) {
        this.mResponseCode = responseCode;
    }

    public ResponseHandler() {
        Context context = MyApplication.getMyApplicationInstance().getApplicationContext();
        this.mMessage = context.getString(R.string.error_common);
    }

    public ResponseHandler(String message) {
        this.mMessage = message;
    }

    /*public ResponseHandler(int responseCode) {
        this.mResponseCode = responseCode;
    }*/

    public boolean isExecuted() {
        return mExecuted;
    }

    public void setExecuted(boolean executed) {
        mExecuted = executed;
    }

    public String getMessage() {
        return mMessage;
    }

    public void setMessage(String message) {
        mMessage = message;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ResponseHandler{" +
                "mResponseCode='" + mResponseCode + '\'' +
                "mResponseSTATUS='" + mStatus + '\'' +
                ", mMessage='" + mMessage + '\'' +
                ", value=" + value +
                '}';
    }
}
