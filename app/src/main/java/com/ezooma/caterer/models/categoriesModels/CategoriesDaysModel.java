package com.ezooma.caterer.models.categoriesModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public class CategoriesDaysModel {
    @SerializedName("dayId")
    @Expose
    private String dayId;
    @SerializedName("dayName")
    @Expose
    private String dayName;
    @SerializedName("createdOn")
    @Expose
    private String createdOn;

    public String getDayId() {
        return dayId;
    }

    public void setDayId(String dayId) {
        this.dayId = dayId;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

}
