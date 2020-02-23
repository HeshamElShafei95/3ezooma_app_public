package com.ezooma.caterer.models.servicesModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public class ServicesAndDaysModel implements Serializable {
    @SerializedName("services")
    @Expose
    private List<ServicesModel> services = null;
    @SerializedName("days")
    @Expose
    private List<ServicesDaysModel> days = null;

    public List<ServicesModel> getServices() {
        return services;
    }

    public void setServices(List<ServicesModel> services) {
        this.services = services;
    }

    public List<ServicesDaysModel> getDays() {
        return days;
    }

    public void setDays(List<ServicesDaysModel> days) {
        this.days = days;
    }

}
