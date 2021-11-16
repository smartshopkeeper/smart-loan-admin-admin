package com.smartloan.smtrick.smart_loan_admin_new.view.holders;

import androidx.recyclerview.widget.RecyclerView;

import com.smartloan.smtrick.smart_loan_admin_new.databinding.ChecklistAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.SalespersonAdapterLayoutBinding;

public class CheckListViewHolder extends RecyclerView.ViewHolder {
    public ChecklistAdapterLayoutBinding checklistAdapterLayoutBinding;

    public CheckListViewHolder(ChecklistAdapterLayoutBinding checklistAdapterLayoutBinding) {
        super(checklistAdapterLayoutBinding.getRoot());
        this.checklistAdapterLayoutBinding = checklistAdapterLayoutBinding;
    }
}
