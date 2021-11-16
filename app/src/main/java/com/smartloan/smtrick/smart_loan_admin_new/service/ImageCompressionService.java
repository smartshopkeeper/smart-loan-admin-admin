package com.smartloan.smtrick.smart_loan_admin_new.service;


import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;

public interface ImageCompressionService {
    void compressImage(String ImagePath, CallBack callBack);
}
