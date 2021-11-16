package com.smartloan.smtrick.smart_loan_admin_new.view.holders;

import androidx.recyclerview.widget.RecyclerView;

import com.smartloan.smtrick.smart_loan_admin_new.databinding.BanksAdapterLayoutBinding;

public class BanksViewHolder extends RecyclerView.ViewHolder {
    public BanksAdapterLayoutBinding BabksAdapterLayoutBinding;

    public BanksViewHolder(BanksAdapterLayoutBinding banksAdapterLayoutBinding) {
        super(banksAdapterLayoutBinding.getRoot());
        this.BabksAdapterLayoutBinding = banksAdapterLayoutBinding;
    }
}
