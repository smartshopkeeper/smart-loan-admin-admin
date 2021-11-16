package com.smartloan.smtrick.smart_loan_admin_new.view.holders;

import androidx.recyclerview.widget.RecyclerView;

import com.smartloan.smtrick.smart_loan_admin_new.databinding.AccountantDisbussLeedsAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.CoDisbussLeedsAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.CoFragmentLeadTabDisbussleadBinding;

public class CoDisbussLeedsViewHolder extends RecyclerView.ViewHolder {
    public CoDisbussLeedsAdapterLayoutBinding coDisbussLeedsAdapterLayoutBinding;

    public CoDisbussLeedsViewHolder(CoDisbussLeedsAdapterLayoutBinding coDisbussLeedsAdapterLayoutBinding) {
        super(coDisbussLeedsAdapterLayoutBinding.getRoot());
        this.coDisbussLeedsAdapterLayoutBinding = coDisbussLeedsAdapterLayoutBinding;
    }
}
