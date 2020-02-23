package com.ezooma.caterer.app.rest.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseDto {


    @Expose
    @SerializedName("responseCode")
    private String mResponseCode;

    @Expose
    @SerializedName("status")
    private boolean mStatus;

    @Expose
    @SerializedName("responseData")
    private Object mResponseBody;

    @Expose
    @SerializedName("responseMessage")
    private String mResponseMessage;

    /*@Expose
    @SerializedName("subscribedEver")
    private boolean subscribedEver ;

    @Expose
    @SerializedName("purchasedDate")
    private String purchasedDate ;
    @Expose
    @SerializedName("lastDate")
    private String lastDate ;

    @Expose
    @SerializedName("planType")
    private String planType ;

    @Expose
    @SerializedName("subscriptionIsactive")
    private boolean subscriptionIsactive ;
*/
  /*  public boolean isSubscribedEver() {
        return subscribedEver;
    }

    public void setSubscribedEver(boolean pSubscribedEver) {
        subscribedEver = pSubscribedEver;
    }

    public String getPurchasedDate() {
        return purchasedDate;
    }

    public void setPurchasedDate(String pPurchasedDate) {
        purchasedDate = pPurchasedDate;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String pLastDate) {
        lastDate = pLastDate;
    }

    public String getPlanType() {
        return planType;
    }

    public void setPlanType(String pPlanType) {
        planType = pPlanType;
    }

    public boolean isSubscriptionIsactive() {
        return subscriptionIsactive;
    }

    public void setSubscriptionIsactive(boolean pSubscriptionIsactive) {
        subscriptionIsactive = pSubscriptionIsactive;
    }
*/
    public boolean ismStatus() {
        return mStatus;
    }

    public void setmStatus(boolean mStatus) {
        this.mStatus = mStatus;
    }

    public String getResponseCode() {
        return mResponseCode;
    }

    public Object getResponseBody() {
        return mResponseBody;
    }

    public String getResponseMessage() {
        return mResponseMessage;
    }
}
