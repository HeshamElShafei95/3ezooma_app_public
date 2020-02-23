package com.ezooma.caterer.interfaces;


import com.ezooma.caterer.models.User;

public interface UserSession {

    void login(User user);

    void loginNew();

    void updateUser(User user);

    User getLoggedUserData();

    ///long getUserID();

    void logout();

    void clearPreferences();

    boolean isLogin();

    String getUserType();

    void setUserType(String userType);

    void setIsVerified(String isVerified);

    void setSelectedLanguage(String language);

    String getSelectedLanguage();

    void setChangePasswordDone(boolean isDone);


    boolean isChangePasswordDone();

    void setDeviceToken(String token);

    String getDeviceToken();


}
