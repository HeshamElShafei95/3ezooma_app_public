package com.ezooma.caterer.utilities;

import android.content.Context;
import android.util.Patterns;

import com.ezooma.caterer.R;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public class Validations {

    public String signUpValidation(Context pContext, String pOwnerName, String pBusinessName, String pEmail
            , String pAddress, String pContactNumber, ArrayList<String> pServicesList, String pMinimumPersons,
                                   String pDeliveryDays, ArrayList<String> pAvailableDaysList, String pOpenTimings,
                                   String pClosingTimings, String pPassword, String pConfirmPassword) {

        if (pOwnerName.isEmpty()) {
            return pContext.getString(R.string.error__owner_name);
        } else if (pBusinessName.isEmpty()) {
            return pContext.getString(R.string.error_business_name);
        } else if (pEmail.isEmpty()) {
            return pContext.getString(R.string.error_email);
        } else if (!Patterns.EMAIL_ADDRESS.matcher(pEmail).matches()) {
            return pContext.getString(R.string.error_email_format);
        } else if (pAddress.isEmpty()) {
            return pContext.getString(R.string.error_address);
        } else if (pContactNumber.isEmpty()) {
            return pContext.getString(R.string.error_contact_number);
        } else if (pServicesList.size() == 0) {
            return pContext.getString(R.string.error_service_list);
        } else if (pMinimumPersons.isEmpty()) {
            return pContext.getString(R.string.error_minimum_persons);
        } else if (pDeliveryDays.isEmpty()) {
            return pContext.getString(R.string.error_delivery_days);
        } else if (pAvailableDaysList.size() == 0) {
            return pContext.getString(R.string.error_deliverydays_list);
        } else if (pOpenTimings.isEmpty()) {
            return pContext.getString(R.string.error_open_timings);
        } else if (pClosingTimings.isEmpty()) {
            return pContext.getString(R.string.error_closing_timings);
        } else if (pPassword.isEmpty()) {
            return pContext.getString(R.string.error_password);
        } else if (pPassword.length() < 6) {
            return pContext.getString(R.string.error_password_length);
        } else if (pConfirmPassword.isEmpty()) {
            return pContext.getString(R.string.error_confirm_password);
        } else if (!pPassword.equals(pConfirmPassword)) {
            return pContext.getString(R.string.error_password_match);
        } else {
            return "";
        }
    }

    public String loginValidation(Context pContext, String pEmail, String pPassword) {
        if (pEmail.isEmpty()) {
            return pContext.getString(R.string.error_email);
        } else if (!Patterns.EMAIL_ADDRESS.matcher(pEmail).matches()) {
            return pContext.getString(R.string.error_email_format);
        } else if (pPassword.isEmpty()) {
            return pContext.getString(R.string.error_password);
        } else if (pPassword.length() < 6) {
            return pContext.getString(R.string.error_password_length);
        } else {
            return "";
        }
    }

    public String forgotPasswordValidation(Context pContext, String pEmail) {
        if (pEmail.isEmpty()) {
            return pContext.getString(R.string.error_email);
        } else if (!Patterns.EMAIL_ADDRESS.matcher(pEmail).matches()) {
            return pContext.getString(R.string.error_email_format);
        } else {
            return "";
        }
    }

    public String changePasswordValidation(Context pContext, String pOldPassword, String pNewPassword,
                                           String pConfirmNewPassword) {
        if (pOldPassword.isEmpty()) {
            return pContext.getString(R.string.error_password);
        } else if (pNewPassword.isEmpty()) {
            return pContext.getString(R.string.error_password_length);
        } else if (pNewPassword.length() < 6) {
            return pContext.getString(R.string.error_password_length);
        } else if (!pNewPassword.equals(pConfirmNewPassword)) {
            return pContext.getString(R.string.error_password_match);
        } else {
            return "";
        }
    }

    public String locationValidation(Context pContext, String pLocation) {
        if (pLocation.isEmpty()) {
            return pContext.getString(R.string.error_location);
        } else {
            return "";
        }
    }

    public String pBusinessSettingsValidation(Context pContext, String pBusinessName, String pAddress,
                                              ArrayList<String> pServicesList, String pMinimumPersons, String pDeliveryDays
            , ArrayList<String> pAvailableDaysList, String pOpenTimings, String pClosingTimings) {
        if (pBusinessName.isEmpty()) {
            return pContext.getString(R.string.error_business_name);
        } else if (pAddress.isEmpty()) {
            return pContext.getString(R.string.error_address);
        } else if (pServicesList.size() == 0) {
            return pContext.getString(R.string.error_service_list);
        } else if (pMinimumPersons.isEmpty()) {
            return pContext.getString(R.string.error_minimum_persons);
        } else if (pDeliveryDays.isEmpty()) {
            return pContext.getString(R.string.error_delivery_days);
        } else if (pAvailableDaysList.size() == 0) {
            return pContext.getString(R.string.error_deliverydays_list);
        } else if (pOpenTimings.isEmpty()) {
            return pContext.getString(R.string.error_open_timings);
        } else if (pClosingTimings.isEmpty()) {
            return pContext.getString(R.string.error_closing_timings);
        } else {
            return "";
        }
    }

    public String pProfileValidations(Context pContext, String pImage, String pOwnerName, String pEmail, String pContactNumber) {
        if (pOwnerName.isEmpty()) {
            return pContext.getString(R.string.error__owner_name);
        }
        if (pEmail.isEmpty()) {
            return pContext.getString(R.string.error_email);
        } else if (!Patterns.EMAIL_ADDRESS.matcher(pEmail).matches()) {
            return pContext.getString(R.string.error_email_format);
        } else if (pContactNumber.isEmpty()) {
            return pContext.getString(R.string.error_contact_number);
        } else {
            return "";
        }
    }

    public String addSubCategoryValidation(Context pContext, File pImage, String subCategoryName, String chosenParentCategory) {
        if (pImage == null) {
            return "Please add category image";
        } else if (subCategoryName.isEmpty()) {
            return "Please add category name";
        } else if (chosenParentCategory.isEmpty()) {
            return "Please choose parent category";
        } else {
            return "";
        }
    }


}
