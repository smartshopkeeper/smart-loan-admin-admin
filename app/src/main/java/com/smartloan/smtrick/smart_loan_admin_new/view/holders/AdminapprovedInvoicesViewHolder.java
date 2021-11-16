package com.smartloan.smtrick.smart_loan_admin_new.view.holders;

import androidx.recyclerview.widget.RecyclerView;

import com.smartloan.smtrick.smart_loan_admin_new.databinding.AdminApprovedInvoiceAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.AdminInvoiceAdapterLayoutBinding;

public class AdminapprovedInvoicesViewHolder extends RecyclerView.ViewHolder {
    public AdminApprovedInvoiceAdapterLayoutBinding adminApprovedInvoiceAdapterLayoutBinding;

    public AdminapprovedInvoicesViewHolder(AdminApprovedInvoiceAdapterLayoutBinding adminInvoiceAdapterLayoutBinding) {
        super(adminInvoiceAdapterLayoutBinding.getRoot());
        this.adminApprovedInvoiceAdapterLayoutBinding = adminInvoiceAdapterLayoutBinding;
    }
}
