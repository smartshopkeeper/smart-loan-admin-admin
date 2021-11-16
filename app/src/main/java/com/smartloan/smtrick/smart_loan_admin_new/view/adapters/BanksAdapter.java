package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.BanksAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.Bank;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.BanksViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BanksAdapter extends RecyclerView.Adapter<BanksViewHolder> {

    private ArrayList<Bank> leedModelArrayList;
    private Context context;

    public BanksAdapter(Context context, ArrayList<Bank> data) {
        this.leedModelArrayList = data;
        this.context = context;
    }

    @Override
    public BanksViewHolder onCreateViewHolder(ViewGroup parent,
                                              int viewType) {
        BanksAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding;
        telecallerLeedsAdapterLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.banks_adapter_layout, parent, false);
        return new BanksViewHolder(telecallerLeedsAdapterLayoutBinding);
    }

    private Bank getModel(int position) {
        return leedModelArrayList.get(getItemCount() - 1 - position);
    }

    @Override
    public void onBindViewHolder(final BanksViewHolder holder, final int listPosition) {
        try {
            Bank leedModel = getModel(listPosition);
            if (!Utility.isEmptyOrNull(leedModel.getBankname()))
                holder.BabksAdapterLayoutBinding.textView.setText(leedModel.getBankname());
            else
                holder.BabksAdapterLayoutBinding.textView.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getBanklogo()))
                Picasso.with(context).load(leedModel.getBanklogo()).placeholder(R.drawable.ic_launcher_background).into(holder.BabksAdapterLayoutBinding.imageView);
            else
                Picasso.with(context).load(R.drawable.ic_launcher_background).placeholder(R.drawable.ic_launcher_background).into(holder.BabksAdapterLayoutBinding.imageView);
//                holder.telecallerLeedsAdapterLayoutBinding.imageView.setImageDrawable(R.drawable.add_person);
//            if (!Utility.isEmptyOrNull(leedModel.getLoanrequirement()))
//                holder.telecallerLeedsAdapterLayoutBinding.txtBankValue.setText(leedModel.getLoanrequirement());
//            else
//                holder.telecallerLeedsAdapterLayoutBinding.txtBankValue.setText(getString(R.string.na));
//            if (!Utility.isEmptyOrNull(leedModel.getExpectedLoanAmount()))
//                holder.telecallerLeedsAdapterLayoutBinding.txtAmountValue.setText(leedModel.getExpectedLoanAmount());
//            else
//                holder.telecallerLeedsAdapterLayoutBinding.txtAmountValue.setText(getString(R.string.na));
//            if (!Utility.isEmptyOrNull(leedModel.getAgentId()))
//                holder.telecallerLeedsAdapterLayoutBinding.txtAgentValue.setText(leedModel.getAgentId());
//            else
//                holder.telecallerLeedsAdapterLayoutBinding.txtAgentValue.setText(getString(R.string.na));
//            if (!Utility.isEmptyOrNull(leedModel.getStatus()))
//                holder.telecallerLeedsAdapterLayoutBinding.txtStatusValue.setText(leedModel.getStatus());
//            else
//                holder.telecallerLeedsAdapterLayoutBinding.txtStatusValue.setText(getString(R.string.na));
//            if (!Utility.isEmptyOrNull(leedModel.getAgentName()))
//                holder.telecallerLeedsAdapterLayoutBinding.txtLoanTypeValue.setText(leedModel.getAgentName());
//            else
//                holder.telecallerLeedsAdapterLayoutBinding.txtLoanTypeValue.setText(getString(R.string.na));
//            if (leedModel.getCreatedDateTimeLong() > 0)
//                holder.telecallerLeedsAdapterLayoutBinding.txtDateValue.setText(Utility.convertMilliSecondsToFormatedDate(leedModel.getCreatedDateTimeLong(), GLOBAL_DATE_FORMATE));
//            else
//                holder.telecallerLeedsAdapterLayoutBinding.txtDateValue.setText(getString(R.string.na));

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

    public void reload(ArrayList<Bank> leedsModelArrayList) {
        leedModelArrayList.clear();
        leedModelArrayList.addAll(leedsModelArrayList);
        notifyDataSetChanged();
    }
}