package com.smartloan.smtrick.smart_loan_admin_new.models;


import android.os.Parcelable;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.ServerValue;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Bank implements Serializable {

    private String bankname;
    private String banklogo;
    private String leedid;
//    private String branch;
    private Long createdDateTime, updatedDateTime;


    //empty constructor is neaded
    public Bank() {
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

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }

    public String getBanklogo() {
        return banklogo;
    }

    public void setBanklogo(String banklogo) {
        this.banklogo = banklogo;
    }

    public String getLeedid() {
        return leedid;
    }

    public void setLeedid(String leedid) {
        this.leedid = leedid;
    }

//    public String getBranch() {
//        return branch;
//    }
//
//    public void setBranch(String branch) {
//        this.branch = branch;
//    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("bankname", bankname);
        result.put("banklogo", banklogo);
        result.put("leedid", leedid);
//        result.put("branch", branch);
        result.put("createdDateTime", getCreatedDateTime());
        result.put("updatedDateTime", getUpdatedDateTime());

        return result;
    }

}