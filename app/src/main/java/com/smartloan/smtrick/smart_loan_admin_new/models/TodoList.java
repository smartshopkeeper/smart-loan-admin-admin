package com.smartloan.smtrick.smart_loan_admin_new.models;


import com.google.firebase.database.Exclude;
import com.google.firebase.database.ServerValue;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class TodoList implements Serializable {

    private String todolistId;
    private String adinId;
    private String leedNumber;
    private String date;
    private String time;
    private String description;
    private Long createdDateTime, updatedDateTime;


    //empty constructor is neaded
    public TodoList() {
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


    public String getTodolistId() {
        return todolistId;
    }

    public void setTodolistId(String todolistId) {
        this.todolistId = todolistId;
    }

    public String getAdinId() {
        return adinId;
    }

    public void setAdinId(String adinId) {
        this.adinId = adinId;
    }

    public String getLeedNumber() {
        return leedNumber;
    }

    public void setLeedNumber(String leedNumber) {
        this.leedNumber = leedNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("todolistId", todolistId);
        result.put("adinId", adinId);
        result.put("leedNumber", leedNumber);
        result.put("date", date);
        result.put("time", time);
        result.put("description", description);
        result.put("createdDateTime", getCreatedDateTime());
        result.put("updatedDateTime", getUpdatedDateTime());

        return result;
    }

}