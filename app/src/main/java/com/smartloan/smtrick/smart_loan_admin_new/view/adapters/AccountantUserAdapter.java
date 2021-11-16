package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.models.UserModel;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.UserViewHolder;

import java.util.ArrayList;

public class AccountantUserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private ArrayList<UserModel> userModelArrayList;

    public AccountantUserAdapter(ArrayList<UserModel> data) {
        this.userModelArrayList = data;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent,
                                             int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.accountant_user_adapter_layout, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final UserViewHolder holder, final int listPosition) {
        try {
            UserModel userModel = userModelArrayList.get(listPosition);
            holder.txtName.setText(userModel.getName());
            holder.txtType.setText(userModel.getType());
            holder.txtcontact.setText(userModel.getMobileNumber());
            holder.txtstatus.setText(userModel.getUserStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return userModelArrayList.size();
    }
}