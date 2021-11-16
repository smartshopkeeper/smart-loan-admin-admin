package com.smartloan.smtrick.smart_loan_admin_new.view.holders;

import androidx.recyclerview.widget.RecyclerView;

import com.smartloan.smtrick.smart_loan_admin_new.databinding.AccountantDisbussLeedsAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.AccountantInvoiceDisbussLeedsAdapterLayoutBinding;

public class AcctInvoiceDisbussLeedsViewHolder extends RecyclerView.ViewHolder {
    public AccountantInvoiceDisbussLeedsAdapterLayoutBinding accountantInvoiceDisbussLeedsAdapterLayoutBinding;

    public AcctInvoiceDisbussLeedsViewHolder(AccountantInvoiceDisbussLeedsAdapterLayoutBinding accountantInvoiceDisbussLeedsAdapterLayoutBinding) {
        super(accountantInvoiceDisbussLeedsAdapterLayoutBinding.getRoot());
        this.accountantInvoiceDisbussLeedsAdapterLayoutBinding = accountantInvoiceDisbussLeedsAdapterLayoutBinding;
    }
}
