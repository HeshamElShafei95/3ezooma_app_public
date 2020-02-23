package com.ezooma.caterer.interfacesImpl;

import com.ezooma.caterer.interfaces.UserSession;
import com.ezooma.caterer.models.User;
import com.google.gson.Gson;

import net.rajpals.common.logger.AppLogger;

import net.rajpals.common.utilities.PreferencesUtil;


public class UserSessionImpl implements UserSession {

    private final static String TAG = UserSessionImpl.class.getName();
    private String IS_LOGIN = "isLoginWineDiary";
    private String USER_DATA = "prefDataWineDiary";
    private String USER_PREFERENCE = "user_preference";
    private String USER_TYPE = "userType";
    private String SELECTED_LANGUAGE = "selectedLanguage";
    private static final String IS_CHANGE_PASSWORD_DONE = "isChangePasswordDone";
    private static final String FCM_DEVICE_TOKEN = "fcm_device_token";
    private static final String BUZ_PASSWORD = "buzzPassword";
    private static final String SELECTED_SLUG = "selectedSlug";

    private PreferencesUtil mPreferencesUtil;
    private Gson mGson;
    //private CardListDao mCardListDao;


    public UserSessionImpl(PreferencesUtil preferencesUtil, Gson gson) {
        AppLogger.Logger.debug("UserSession", "Cons");
        this.mPreferencesUtil = preferencesUtil;
        this.mGson = gson;

    }

    @Override
    public void login(User user) {
        mPreferencesUtil.savePreferences(USER_DATA, mGson.toJson(user));
        mPreferencesUtil.savePreferencesBoolean(IS_LOGIN, true);

    }

    @Override
    public void loginNew() {
        mPreferencesUtil.savePreferencesBoolean(IS_LOGIN, true);
    }

    @Override
    public User getLoggedUserData() {
        User user = null;
        try {
            user = mGson.fromJson(mPreferencesUtil.getPreferences(USER_DATA), User.class);
        } catch (Exception ex) {
            AppLogger.Logger.error(TAG, ex.getMessage(), ex);
        }
        return user;
    }

    /*@Override
    public long getUserID() {
        User user = getLoggedUserData();
        if (user == null)
            return 0;
        return Long.parseLong(user.getUserId());
    }*/

    @Override
    public void logout() {
        mPreferencesUtil.savePreferencesBoolean(IS_LOGIN, false);
        mPreferencesUtil.savePreferences(USER_DATA, null);
        //Clearing card table
       /* mCardListDao = new CardDaoImpl();
        mCardListDao.clearTable();*/
    }

    @Override
    public void clearPreferences() {
        mPreferencesUtil.savePreferencesBoolean(IS_LOGIN, false);
        mPreferencesUtil.savePreferences(USER_DATA, null);
    }

    @Override
    public boolean isLogin() {
        return mPreferencesUtil.getPreferencesBoolean(IS_LOGIN);
    }

    @Override
    public String getUserType() {
        return mPreferencesUtil.getPreferences(USER_TYPE);
    }

    @Override
    public void setUserType(String userType) {
        mPreferencesUtil.savePreferences(USER_TYPE, userType);
    }

    @Override
    public void setIsVerified(String isVerified) {

    }


    @Override
    public void setSelectedLanguage(String language) {
        mPreferencesUtil.savePreferences(USER_DATA, language);
    }

    @Override
    public String getSelectedLanguage() {
        return mPreferencesUtil.getPreferences(USER_DATA);
    }

    @Override
    public void setChangePasswordDone(boolean isDone) {
        mPreferencesUtil.savePreferencesBoolean(IS_CHANGE_PASSWORD_DONE, true);
    }

    @Override
    public boolean isChangePasswordDone() {
        return mPreferencesUtil.getPreferencesBoolean(IS_CHANGE_PASSWORD_DONE);
    }

    @Override
    public void setDeviceToken(String token) {
        mPreferencesUtil.savePreferences(FCM_DEVICE_TOKEN, token);
    }

    @Override
    public String getDeviceToken() {
        return mPreferencesUtil.getPreferences(FCM_DEVICE_TOKEN);
    }

    /*public static User mapUser(User oldUser, User newUser) {

        String email = oldUser.getmEmail();
        String firstName = oldUser.getmFirstName();
        String lastName = oldUser.getmLastName();
        String selectLanguage = oldUser.getSelectedLanguage();

        newUser.setToken(token);
        newUser.setTokenType(tokentype);
        newUser.setTokenExpires(tokenExpires);
        return newUser;

    }*/

    @Override
    public void updateUser(User user) {
        if (user == null)
            return;
        mPreferencesUtil.savePreferences(USER_DATA, mGson.toJson(user));
    }
}
