package com.smartloan.smtrick.smart_loan_admin_new.view.holders;

import androidx.recyclerview.widget.RecyclerView;

import com.smartloan.smtrick.smart_loan_admin_new.databinding.SalesBanksubmittedLeedsAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.SalesReceivedLeedsAdapterLayoutBinding;

public class SalesBankSubmittedLeedsViewHolder extends RecyclerView.ViewHolder {
    public SalesBanksubmittedLeedsAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding;

    public SalesBankSubmittedLeedsViewHolder(SalesBanksubmittedLeedsAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding) {
        super(telecallerLeedsAdapterLayoutBinding.getRoot());
        this.telecallerLeedsAdapterLayoutBinding = telecallerLeedsAdapterLayoutBinding;
    }
}
