package com.smartloan.smtrick.smart_loan_admin_new.models;

import java.util.ArrayList;

public class LeedModel {
    private String leedId, customerName, dateTime, bankName, agentId, totalAmount, status,loanType;


    public LeedModel(String leedId, String customerName, String dateTime, String bankName, String agentId, String totalAmount, String status, String loanType) {
        this.leedId = leedId;
        this.customerName = customerName;
        this.dateTime = dateTime;
        this.bankName = bankName;
        this.agentId = agentId;
        this.totalAmount = totalAmount;
        this.status = status;
        this.loanType = loanType;
    }

    public LeedModel() {
    }

    public String getLeedId() {
        return leedId;
    }

    public void setLeedId(String leedId) {
        this.leedId = leedId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAgentId() {
        return agentId;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public static ArrayList<LeedModel> getLeedsModelList() {
        ArrayList<LeedModel> leedModelArrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            LeedModel leedModel = new LeedModel();
            leedModel.setLeedId("001233");
            leedModel.setCustomerName("Mr. Pratik Patel");
            leedModel.setAgentId("AG-0007");
            leedModel.setDateTime("10/01/2018");
            leedModel.setBankName("BOI");
            leedModel.setTotalAmount("20,000,00");
            leedModel.setStatus("Approved");
            leedModel.setLoanType("LAP");
            leedModelArrayList.add(leedModel);
        }
        return leedModelArrayList;
    }
}
