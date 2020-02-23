package com.ezooma.caterer.interfaces;

import com.ezooma.caterer.app.rest.ResponseCallBackHandler;

import java.util.Map;

import okhttp3.MultipartBody;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public interface HomeInterface {
    void getCategoriesApi(ResponseCallBackHandler pResponseCallBackHandler);

    void notificationsApi(ResponseCallBackHandler pResponseCallBackHandler, Map<String, Object> params);

    void addSubCategoryApi(ResponseCallBackHandler pResponseCallBackHandler, MultipartBody subCategoryData);

    void addNewItem(ResponseCallBackHandler pResponseCallBackHandler, MultipartBody newItemData);

    void getAddedMenuCategories(ResponseCallBackHandler pResponseCallBackHandler, Map<String, Object> params);

    void getCategoryMenuItems(ResponseCallBackHandler pResponseCallBackHandler, Map<String, Object> params);

    void deleteAddedCategory(ResponseCallBackHandler pResponseCallBackHandler, Map<String, Object> params);

    void editAddedCategory(ResponseCallBackHandler pResponseCallBackHandler, Map<String, Object> params);

    void deleteCategoryItem(ResponseCallBackHandler pResponseCallBackHandler, Map<String, Object> params);

    void editCategoryItem(ResponseCallBackHandler pResponseCallBackHandler, Map<String, Object> params);

}
