package com.smartloan.smtrick.smart_loan_admin_new.models;


import com.google.firebase.database.Exclude;
import com.google.firebase.database.ServerValue;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Commission implements Serializable {

    private String minAmount;
    private String maxAmount;
    private String percentage;
    private String generatedId;
//    private String branch;
    private Long createdDateTime, updatedDateTime;


    //empty constructor is neaded
    public Commission() {
    }

    @Exclude
    public Long getCreatedDateTimeLong() {
        return createdDateTime;
    }

    public Map<String, String> getCreatedDateTime() {
        return ServerValue.TIMESTAMP;
    }

    public void setCreatedDateTime(Long createdDateTime) {
        this.createdDateTime = (Long) createdDateTime;
    }
    @Exclude
    public Long getUpdatedDateTimeLong() {
        return updatedDateTime;
    }

    public void setUpdatedDateTime(Long updatedDateTime) {
        this.updatedDateTime = updatedDateTime;
    }

    public Map<String, String> getUpdatedDateTime() {
        return ServerValue.TIMESTAMP;
    }

    public String getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(String minAmount) {
        this.minAmount = minAmount;
    }

    public String getMaxAmount() {
        return maxAmount;
    }

    public void setMaxAmount(String maxAmount) {
        this.maxAmount = maxAmount;
    }

    public String getPercentage() {
        return percentage;
    }

    public void setPercentage(String percentage) {
        this.percentage = percentage;
    }

    public String getGeneratedId() {
        return generatedId;
    }

    public void setGeneratedId(String generatedId) {
        this.generatedId = generatedId;
    }



    @Exclude
    public Map<String, Object> getLeedStatusMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("minAmount", minAmount);
        result.put("maxAmount",maxAmount);
        result.put("percentage", percentage);
        result.put("generatedId", generatedId);
        result.put("createdDateTime", getCreatedDateTime());
        result.put("updatedDateTime", getUpdatedDateTime());

        return result;
    }

}