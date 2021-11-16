package com.smartloan.smtrick.smart_loan_admin_new.view.holders;

import androidx.recyclerview.widget.RecyclerView;

import com.smartloan.smtrick.smart_loan_admin_new.databinding.AccountantDisbussLeedsAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.LeadSummaryAdapterLayoutBinding;

public class LeedsSummaryViewHolder extends RecyclerView.ViewHolder {

    public LeadSummaryAdapterLayoutBinding leadSummaryAdapterLayoutBinding;

    public LeedsSummaryViewHolder(LeadSummaryAdapterLayoutBinding leadSummaryAdapterLayoutBinding) {
        super(leadSummaryAdapterLayoutBinding.getRoot());
        this.leadSummaryAdapterLayoutBinding = leadSummaryAdapterLayoutBinding;
    }
}
