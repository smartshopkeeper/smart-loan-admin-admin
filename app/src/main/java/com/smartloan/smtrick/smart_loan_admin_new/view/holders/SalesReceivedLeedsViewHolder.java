package com.smartloan.smtrick.smart_loan_admin_new.view.holders;

import androidx.recyclerview.widget.RecyclerView;

import com.smartloan.smtrick.smart_loan_admin_new.databinding.SalesLeedsAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.SalesReceivedLeedsAdapterLayoutBinding;

public class SalesReceivedLeedsViewHolder extends RecyclerView.ViewHolder {
    public SalesReceivedLeedsAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding;

    public SalesReceivedLeedsViewHolder(SalesReceivedLeedsAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding) {
        super(telecallerLeedsAdapterLayoutBinding.getRoot());
        this.telecallerLeedsAdapterLayoutBinding = telecallerLeedsAdapterLayoutBinding;
    }
}
