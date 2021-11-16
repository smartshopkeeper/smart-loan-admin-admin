package com.smartloan.smtrick.smart_loan_admin_new.view.holders;

import androidx.recyclerview.widget.RecyclerView;

import com.smartloan.smtrick.smart_loan_admin_new.databinding.SalesLeedsAdapterLayoutBinding;

public class SalesLeedsViewHolder extends RecyclerView.ViewHolder {
    public SalesLeedsAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding;

    public SalesLeedsViewHolder(SalesLeedsAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding) {
        super(telecallerLeedsAdapterLayoutBinding.getRoot());
        this.telecallerLeedsAdapterLayoutBinding = telecallerLeedsAdapterLayoutBinding;
    }
}
