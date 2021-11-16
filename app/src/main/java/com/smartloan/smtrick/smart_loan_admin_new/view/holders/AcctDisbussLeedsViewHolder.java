package com.smartloan.smtrick.smart_loan_admin_new.view.holders;

import androidx.recyclerview.widget.RecyclerView;

import com.smartloan.smtrick.smart_loan_admin_new.databinding.AccountantDisbussLeedsAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.TelecallerLeedsAdapterLayoutBinding;

public class AcctDisbussLeedsViewHolder extends RecyclerView.ViewHolder {
    public AccountantDisbussLeedsAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding;

    public AcctDisbussLeedsViewHolder(AccountantDisbussLeedsAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding) {
        super(telecallerLeedsAdapterLayoutBinding.getRoot());
        this.telecallerLeedsAdapterLayoutBinding = telecallerLeedsAdapterLayoutBinding;
    }
}
