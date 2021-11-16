package com.smartloan.smtrick.smart_loan_admin_new.view.holders;

import androidx.recyclerview.widget.RecyclerView;

import com.smartloan.smtrick.smart_loan_admin_new.databinding.AdminInvoiceAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.InvoiceAdapterLayoutBinding;

public class AdminInvoicesViewHolder extends RecyclerView.ViewHolder {
    public AdminInvoiceAdapterLayoutBinding adminInvoiceAdapterLayoutBinding;

    public AdminInvoicesViewHolder(AdminInvoiceAdapterLayoutBinding adminInvoiceAdapterLayoutBinding) {
        super(adminInvoiceAdapterLayoutBinding.getRoot());
        this.adminInvoiceAdapterLayoutBinding = adminInvoiceAdapterLayoutBinding;
    }
}
