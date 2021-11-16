package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.LeedsViewHolder;

import java.util.ArrayList;

public class AccountantLeedsAdapter extends RecyclerView.Adapter<LeedsViewHolder> {

    private ArrayList<LeedsModel> leedModelArrayList;

    public AccountantLeedsAdapter(ArrayList<LeedsModel> data) {
        this.leedModelArrayList = data;
    }

    @Override
    public LeedsViewHolder onCreateViewHolder(ViewGroup parent,
                                              int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.accountant_leeds_adapter_layout, parent, false);
        //view.setOnClickListener(MainActivity.myOnClickListener);
        return new LeedsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final LeedsViewHolder holder, final int listPosition) {
        try {
            LeedsModel leedModel = leedModelArrayList.get(listPosition);
            holder.txtLeedId.setText(leedModel.getLeedNumber());
            holder.txtCustomerName.setText(leedModel.getCustomerName());
            holder.txtBank.setText(leedModel.getBankName());
            holder.txtTotalAmount.setText(leedModel.getExpectedLoanAmount());
            holder.txtAgentID.setText(leedModel.getAgentId());
            holder.txtLoanType.setText(leedModel.getLoanType());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return leedModelArrayList.size();
    }

    public void reload(ArrayList<LeedsModel> list) {
        list.clear();
        list.addAll(list);
        notifyDataSetChanged();
    }
}