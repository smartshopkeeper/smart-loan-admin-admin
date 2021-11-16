package com.smartloan.smtrick.smart_loan_admin_new.models;

import java.util.ArrayList;

public class UserModel {
    private String name, type, mobileNumber, userStatus, userId, address, email, gender, dateOfBirth, joiningDateTime, createdDateTime;

    public UserModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getJoiningDateTime() {
        return joiningDateTime;
    }

    public void setJoiningDateTime(String joiningDateTime) {
        this.joiningDateTime = joiningDateTime;
    }

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public static ArrayList<UserModel> getUsersList() {
        ArrayList<UserModel> results = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                UserModel sr = new UserModel();
                sr.setName("Mr Pratik Patel");
                sr.setType("Sales");
                sr.setMobileNumber("7030648899");
                sr.setUserStatus("Active");
                results.add(sr);
            } else {
                UserModel sr = new UserModel();
                sr.setName("Mr Sagar Mule");
                sr.setType("TelleCaller");
                sr.setMobileNumber("7030648899");
                sr.setUserStatus("Deactive");
                results.add(sr);
            }
        }
        return results;
    }
}
