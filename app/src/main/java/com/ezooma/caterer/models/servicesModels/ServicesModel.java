package com.ezooma.caterer.models.servicesModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by Sonal grover.
 * Contact on sonal.grover12@gmail.com
 */
public class ServicesModel implements Serializable {

    @SerializedName("serviceId")
    @Expose
    private String serviceId;
    @SerializedName("serviceName")
    @Expose
    private String serviceName;
    @SerializedName("createdOn")
    @Expose
    private String createdOn;

    private boolean serviceChecked =false;

    public boolean isServiceChecked() {
        return serviceChecked;
    }

    public void setServiceChecked(boolean pServiceChecked) {
        serviceChecked = pServiceChecked;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }
}
