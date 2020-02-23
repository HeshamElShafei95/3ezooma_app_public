package com.ezooma.caterer.models.categoriesModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import androidx.annotation.NonNull;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public class CategoryModel implements Serializable {
    @SerializedName("categoryId")
    @Expose
    private String categoryId;
    @SerializedName("categoryName")
    @Expose
    private String categoryName;
    @SerializedName("createdOn")
    @Expose
    private String createdOn;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    @NonNull
    @Override
    public String toString() {
        return categoryName.toString();
    }
}
