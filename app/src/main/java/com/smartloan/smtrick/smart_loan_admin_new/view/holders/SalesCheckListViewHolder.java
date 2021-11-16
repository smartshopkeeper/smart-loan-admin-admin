package com.smartloan.smtrick.smart_loan_admin_new.view.holders;

import androidx.recyclerview.widget.RecyclerView;

import com.smartloan.smtrick.smart_loan_admin_new.databinding.ChecklistAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.SalesChecklistAdapterLayoutBinding;

public class SalesCheckListViewHolder extends RecyclerView.ViewHolder {
    public SalesChecklistAdapterLayoutBinding saleschecklistAdapterLayoutBinding;

    public SalesCheckListViewHolder(SalesChecklistAdapterLayoutBinding saleschecklistAdapterLayoutBinding) {
        super(saleschecklistAdapterLayoutBinding.getRoot());
        this.saleschecklistAdapterLayoutBinding = saleschecklistAdapterLayoutBinding;
    }
}
