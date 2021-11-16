package com.smartloan.smtrick.smart_loan_admin_new.models;


import androidx.core.app.NotificationCompat;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.ServerValue;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Expences implements Serializable {

    private String agentname;
    private String agentid;
    private String billAmount;
    private String generatedid;
    private String status;
    private String billname;
    private Long createdDateTime, updatedDateTime;


    //empty constructor is neaded
    public Expences() {
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

    public String getAgentname() {
        return agentname;
    }

    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    public String getAgentid() {
        return agentid;
    }

    public void setAgentid(String agentid) {
        this.agentid = agentid;
    }

    public String getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(String billAmount) {
        this.billAmount = billAmount;
    }

    public String getGeneratedid() {
        return generatedid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBillname() {
        return billname;
    }

    public void setBillname(String billname) {
        this.billname = billname;
    }

    public void setGeneratedid(String generatedid) {
        this.generatedid = generatedid;
    }

    @Exclude
    public Map getLeedStatusMap1() {
        Map<String, Object> leedMap = new HashMap();
        leedMap.put(NotificationCompat.CATEGORY_STATUS, getStatus());
        leedMap.put("updatedDateTime", getUpdatedDateTime());
        return leedMap;
    }
    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("agentname", agentname);
        result.put("agentid", agentid);
        result.put("billAmount", billAmount);
        result.put("generatedid", generatedid);
        result.put("status", status);
        result.put("billname", billname);
        result.put("createdDateTime", getCreatedDateTime());
        result.put("updatedDateTime", getUpdatedDateTime());

        return result;
    }

}