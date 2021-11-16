package com.smartloan.smtrick.smart_loan_admin_new.models;

import androidx.core.app.NotificationCompat;

import com.google.firebase.database.Exclude;
import com.google.firebase.database.ServerValue;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Invoice implements Serializable {

    private String customerName;
    private String invoiceId;
    private String invoiceNumber;
    private String disbussmentDate;

    private String loanapprovedaamount;
    private String totalpayoutamount;
    private String loandisbussedamount;
    private String pendingdisbussedamount;
//    private String payoutbussedamount;
    private String tdsAmount;
//    private String commisionwithtdsAmount;

    private String balancePayout;
    private String balancePayoutWithTdsAmount;
    private String lastPayoutPaidAmount;
    private String lastPayoutPaidDate;
    private String payOutOnDisbursementAmount;
    private String payoutPayableAfterTdsAmount;

    private String phone;
    private String status;
    private String agentId;
    private String leedId;
    private String loanType;
    private String rejectionReason;

    public Invoice() {
        this.invoiceId = "";
        this.invoiceNumber = "";
        this.phone = "";
        this.status = "";
        this.customerName = "";
        this.leedId = "";
        this.loanapprovedaamount = "";
        this.loandisbussedamount = "";
        this.totalpayoutamount = "";
        this.pendingdisbussedamount = "";
//        this.payoutbussedamount = "";
//        this.commisionwithtdsAmount = "";
        this.tdsAmount = "";
        this.balancePayout = "";
        this.balancePayoutWithTdsAmount = "";
        this.lastPayoutPaidAmount = "";
        this.lastPayoutPaidDate = "";
        this.payOutOnDisbursementAmount = "";
        this.payoutPayableAfterTdsAmount = "";

        this.disbussmentDate = "";
        this.agentId = "";
        this.loanType = "";
        this.rejectionReason = "";
    }


    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public String getStatus() {
        return status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getLeedId() {
        return leedId;
    }

    public void setLeedId(String leedId) {
        this.leedId = leedId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getLoanapprovedaamount() {
        return loanapprovedaamount;
    }

    public void setLoanapprovedaamount(String loanapprovedaamount) {
        this.loanapprovedaamount = loanapprovedaamount;
    }

    public String getLoandisbussedamount() {
        return loandisbussedamount;
    }

    public void setLoandisbussedamount(String loandisbussedamount) {
        this.loandisbussedamount = loandisbussedamount;
    }

    public String getTdsAmount() {
        return tdsAmount;
    }

    public void setTdsAmount(String tdsAmount) {
        this.tdsAmount = tdsAmount;
    }

    public String getAgentId() {
        return agentId;
    }

    public void setAgentId(String agentId) {
        this.agentId = agentId;
    }


    public String getTotalpayoutamount() {
        return totalpayoutamount;
    }

    public void setTotalpayoutamount(String totalpayoutamount) {
        this.totalpayoutamount = totalpayoutamount;
    }

    public String getPendingdisbussedamount() {
        return pendingdisbussedamount;
    }

    public void setPendingdisbussedamount(String pendingdisbussedamount) {
        this.pendingdisbussedamount = pendingdisbussedamount;
    }

//    public String getPayoutbussedamount() {
//        return payoutbussedamount;
//    }
//
//    public void setPayoutbussedamount(String payoutbussedamount) {
//        this.payoutbussedamount = payoutbussedamount;
//    }
//
//    public String getCommisionwithtdsAmount() {
//        return commisionwithtdsAmount;
//    }
//
//    public void setCommisionwithtdsAmount(String commisionwithtdsAmount) {
//        this.commisionwithtdsAmount = commisionwithtdsAmount;
//    }

    public String getDisbussmentDate() {
        return disbussmentDate;
    }

    public void setDisbussmentDate(String disbussmentDate) {
        this.disbussmentDate = disbussmentDate;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getRejectionReason() {
        return rejectionReason;
    }

    public void setRejectionReason(String rejectionReason) {
        this.rejectionReason = rejectionReason;
    }

    public String getBalancePayout() {
        return balancePayout;
    }

    public void setBalancePayout(String balancePayout) {
        this.balancePayout = balancePayout;
    }

    public String getBalancePayoutWithTdsAmount() {
        return balancePayoutWithTdsAmount;
    }

    public void setBalancePayoutWithTdsAmount(String balancePayoutWithTdsAmount) {
        this.balancePayoutWithTdsAmount = balancePayoutWithTdsAmount;
    }

    public String getLastPayoutPaidAmount() {
        return lastPayoutPaidAmount;
    }

    public void setLastPayoutPaidAmount(String lastPayoutPaidAmount) {
        this.lastPayoutPaidAmount = lastPayoutPaidAmount;
    }

    public String getLastPayoutPaidDate() {
        return lastPayoutPaidDate;
    }

    public void setLastPayoutPaidDate(String lastPayoutPaidDate) {
        this.lastPayoutPaidDate = lastPayoutPaidDate;
    }

    public String getPayOutOnDisbursementAmount() {
        return payOutOnDisbursementAmount;
    }

    public void setPayOutOnDisbursementAmount(String payOutOnDisbursementAmount) {
        this.payOutOnDisbursementAmount = payOutOnDisbursementAmount;
    }

    public String getPayoutPayableAfterTdsAmount() {
        return payoutPayableAfterTdsAmount;
    }

    public void setPayoutPayableAfterTdsAmount(String payoutPayableAfterTdsAmount) {
        this.payoutPayableAfterTdsAmount = payoutPayableAfterTdsAmount;
    }

    @Exclude
    public Map getLeedStatusMap() {
        Map<String, Object> leedMap = new HashMap();
        leedMap.put(NotificationCompat.CATEGORY_STATUS, getStatus());

        return leedMap;
    }

    @Exclude
    public Map getLeedStatusMap1() {
        Map<String, Object> leedMap = new HashMap();
        leedMap.put(customerName, getCustomerName());
        leedMap.put(invoiceId, getInvoiceId());
        leedMap.put(invoiceNumber, getInvoiceNumber());
        leedMap.put(disbussmentDate, getDisbussmentDate());
        leedMap.put(loanapprovedaamount, getLoanapprovedaamount());
        leedMap.put(totalpayoutamount, getTotalpayoutamount());
        leedMap.put(loandisbussedamount, getLoandisbussedamount());
        leedMap.put(pendingdisbussedamount, getPendingdisbussedamount());
        leedMap.put(phone, getPhone());
        leedMap.put(status, getStatus());
        leedMap.put(agentId, getAgentId());
        leedMap.put(leedId, getLeedId());
        leedMap.put(loanType, getLoanType());
        leedMap.put(tdsAmount, getTdsAmount());
        leedMap.put(rejectionReason, getRejectionReason());
        leedMap.put(balancePayout, getBalancePayout());
        leedMap.put(balancePayoutWithTdsAmount, getBalancePayoutWithTdsAmount());
        leedMap.put(lastPayoutPaidAmount, getLastPayoutPaidAmount());
        leedMap.put(lastPayoutPaidDate, getLastPayoutPaidDate());
        leedMap.put(payOutOnDisbursementAmount, getPayOutOnDisbursementAmount());
        leedMap.put(payoutPayableAfterTdsAmount, getPayoutPayableAfterTdsAmount());


        return leedMap;
    }

    public static ArrayList<Invoice> getSentInvoices() {
        ArrayList<Invoice> results = new ArrayList<Invoice>();
        for (int i = 0; i < 20; i++) {
            Invoice sr = new Invoice();
            sr.setInvoiceId("INV 000" + i);
            sr.setCustomerName("Mr Pratik Patel");
            sr.setPhone("Axis Bank");
            sr.setStatus("Sent");
            results.add(sr);
        }
        return results;
    }

    public static ArrayList<Invoice> getAcceptedInvoices() {
        ArrayList<Invoice> results = new ArrayList<Invoice>();
        for (int i = 0; i < 20; i++) {
            Invoice sr = new Invoice();
            sr.setInvoiceId("INV 000" + i);
            sr.setCustomerName("Mr Pratik Patel");
            sr.setPhone("Axis Bank");
            sr.setStatus("Unpaid");
            results.add(sr);
        }
        return results;
    }

    public static ArrayList<Invoice> getPaidInvoices() {
        ArrayList<Invoice> results = new ArrayList<Invoice>();
        for (int i = 0; i < 20; i++) {
            Invoice sr = new Invoice();
            sr.setInvoiceId("INV 000" + i);
            sr.setCustomerName("Mr Pratik Patel");
            sr.setPhone("Axis Bank");
            sr.setStatus("Paid");
            results.add(sr);
        }
        return results;
    }

    public static ArrayList<Invoice> getRejectedInvoices() {
        ArrayList<Invoice> results = new ArrayList<Invoice>();
        for (int i = 0; i < 20; i++) {
            Invoice sr = new Invoice();
            sr.setInvoiceId("INV 000" + i);
            sr.setCustomerName("Mr Pratik Patel");
            sr.setPhone("Axis Bank");
            sr.setStatus("Rejected");
            results.add(sr);
        }
        return results;
    }
}
