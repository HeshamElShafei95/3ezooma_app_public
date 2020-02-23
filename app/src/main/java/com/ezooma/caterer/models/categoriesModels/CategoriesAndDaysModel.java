package com.ezooma.caterer.models.categoriesModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public class CategoriesAndDaysModel implements Serializable {

    @SerializedName("categories")
    @Expose
    private List<CategoryModel> categories = null;
    @SerializedName("days")
    @Expose
    private List<CategoriesDaysModel> days = null;

    public List<CategoryModel> getCategories() {
        return categories;
    }

    public void setCategories(List<CategoryModel> categories) {
        this.categories = categories;
    }

    public List<CategoriesDaysModel> getDays() {
        return days;
    }

    public void setDays(List<CategoriesDaysModel> days) {
        this.days = days;
    }
}
