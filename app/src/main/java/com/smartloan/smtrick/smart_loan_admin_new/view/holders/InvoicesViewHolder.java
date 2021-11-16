package com.smartloan.smtrick.smart_loan_admin_new.view.holders;

import androidx.recyclerview.widget.RecyclerView;

import com.smartloan.smtrick.smart_loan_admin_new.databinding.InvoiceAdapterLayoutBinding;

public class InvoicesViewHolder extends RecyclerView.ViewHolder {
    public InvoiceAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding;

    public InvoicesViewHolder(InvoiceAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding) {
        super(telecallerLeedsAdapterLayoutBinding.getRoot());
        this.telecallerLeedsAdapterLayoutBinding = telecallerLeedsAdapterLayoutBinding;
    }
}
