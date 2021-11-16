package com.smartloan.smtrick.smart_loan_admin_new.view.holders;

import androidx.recyclerview.widget.RecyclerView;

import com.smartloan.smtrick.smart_loan_admin_new.databinding.CoVerifiedLeedsAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.TelecallerLeedsAdapterLayoutBinding;

public class CoVerifiedLeedsViewHolder extends RecyclerView.ViewHolder {
    public CoVerifiedLeedsAdapterLayoutBinding coVerifiedLeedsAdapterLayoutBinding;

    public CoVerifiedLeedsViewHolder(CoVerifiedLeedsAdapterLayoutBinding coVerifiedLeedsAdapterLayoutBinding) {
        super(coVerifiedLeedsAdapterLayoutBinding.getRoot());
        this.coVerifiedLeedsAdapterLayoutBinding = coVerifiedLeedsAdapterLayoutBinding;
    }
}
