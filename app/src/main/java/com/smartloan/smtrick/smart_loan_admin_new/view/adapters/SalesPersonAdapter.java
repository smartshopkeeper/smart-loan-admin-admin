package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.SalespersonAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.User;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.SalesPersonViewHolder;

import java.util.ArrayList;

public class SalesPersonAdapter extends RecyclerView.Adapter<SalesPersonViewHolder> {

    private ArrayList<User> leedModelArrayList;
    private Context context;

    public SalesPersonAdapter(Context context, ArrayList<User> data) {
        this.leedModelArrayList = data;
        this.context = context;
    }

    @Override
    public SalesPersonViewHolder onCreateViewHolder(ViewGroup parent,
                                              int viewType) {
        SalespersonAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding;
        telecallerLeedsAdapterLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.salesperson_adapter_layout, parent, false);
        return new SalesPersonViewHolder(telecallerLeedsAdapterLayoutBinding);
    }



    private User getModel(int position) {
        return leedModelArrayList.get(getItemCount() - 1 - position);
    }

    @Override
    public void onBindViewHolder(final SalesPersonViewHolder holder, final int listPosition) {
        try {
            User leedModel = getModel(listPosition);
            if (!Utility.isEmptyOrNull(leedModel.getUserName()))
                holder.telecallerLeedsAdapterLayoutBinding.salesname.setText(leedModel.getUserName());
            else
                holder.telecallerLeedsAdapterLayoutBinding.salesname.setText(getString(R.string.na));


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

    public void reload(ArrayList<User> leedsModelArrayList) {
        leedModelArrayList.clear();
        leedModelArrayList.addAll(leedsModelArrayList);
        notifyDataSetChanged();
    }
}