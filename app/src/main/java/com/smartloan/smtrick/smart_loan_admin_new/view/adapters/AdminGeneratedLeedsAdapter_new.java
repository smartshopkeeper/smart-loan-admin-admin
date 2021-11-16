package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.AdminGeneratedLeedsAdapterNewLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.TelecallerLeedsAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.View_Admin_Generated_Lead_Details_Fragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.AdminGeneratedLeedsViewHolder;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.TelecallerLeedsViewHolder;

import java.util.ArrayList;

public class AdminGeneratedLeedsAdapter_new extends RecyclerView.Adapter<AdminGeneratedLeedsViewHolder> {

    private ArrayList<LeedsModel> leedModelArrayList;
    private Context context;
    int index = -1;
    private int selectedPosition = 0;
    static int m = 0;

    public AdminGeneratedLeedsAdapter_new() {
    }

    public AdminGeneratedLeedsAdapter_new(Context context, ArrayList<LeedsModel> data) {
        this.leedModelArrayList = data;
        this.context = context;
    }

    @Override
    public AdminGeneratedLeedsViewHolder onCreateViewHolder(ViewGroup parent,
                                                            int viewType) {
        AdminGeneratedLeedsAdapterNewLayoutBinding adminGeneratedLeedsAdapterNewLayoutBinding;
        adminGeneratedLeedsAdapterNewLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.admin_generated_leeds_adapter_new_layout, parent, false);
        return new AdminGeneratedLeedsViewHolder(adminGeneratedLeedsAdapterNewLayoutBinding);
    }

    private LeedsModel getModel(int position) {
        return leedModelArrayList.get(getItemCount() - 1 - position);
    }

    @Override
    public void onBindViewHolder(final AdminGeneratedLeedsViewHolder holder, final int listPosition) {
        try {

            LeedsModel leedModel = getModel(listPosition);

            if (leedModel.getCustomerName() != null) {
                holder.adminGeneratedLeedsAdapterNewLayoutBinding.clientNameValue.setText(leedModel.getCustomerName());
            }
            if (leedModel.getAgentName() != null) {
                holder.adminGeneratedLeedsAdapterNewLayoutBinding.agentNameValue.setText(leedModel.getAgentName());
            }
            if (leedModel.getAgentId() != null) {
                holder.adminGeneratedLeedsAdapterNewLayoutBinding.agentIdValue.setText(leedModel.getAgentId());
            }
            if (leedModel.getBankName() != null) {
                holder.adminGeneratedLeedsAdapterNewLayoutBinding.bankValue.setText(leedModel.getBankName());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getString(int id) {
        return context.getString(id);
    }

    @Override
    public int getItemCount() {
        return leedModelArrayList.size();
    }

    public void reload(ArrayList<LeedsModel> leedsModelArrayList) {
        leedModelArrayList.clear();
        leedModelArrayList.addAll(leedsModelArrayList);
        notifyDataSetChanged();
    }
}