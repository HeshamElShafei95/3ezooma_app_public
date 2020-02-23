package com.ezooma.caterer.models;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("userId")
    private
    int mUserId;

    @SerializedName("email")
    private
    String mEmail;

    @SerializedName("firstName")
    private String mFirstName;


    @SerializedName("lastName")
    private String mLastName;


    @SerializedName("userLanguage")
    private String selectedLanguage;


    @SerializedName("phoneNumber")
    private String mPhoneNumber;


    @SerializedName("countryCode")
    private String mCountryCode;

    public String getmCountryCode() {
        return mCountryCode;
    }

    public void setmCountryCode(String mCountryCode) {
        this.mCountryCode = mCountryCode;
    }

    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    public void setmPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    public String getSelectedLanguage() {
        return selectedLanguage;
    }

    public void setSelectedLanguage(String selectedLanguage) {
        this.selectedLanguage = selectedLanguage;
    }


    public String getmFirstName() {
        return mFirstName;
    }

    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public String getmLastName() {
        return mLastName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public int getmUserId() {
        return mUserId;
    }

    public void setmUserId(int mUserId) {
        this.mUserId = mUserId;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }


}
