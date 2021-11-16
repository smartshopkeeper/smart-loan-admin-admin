package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.InvoiceAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.Invoice;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.InvoicesViewHolder;

import java.util.ArrayList;

public class InvoiceAdapter extends RecyclerView.Adapter<InvoicesViewHolder> {

    private ArrayList<Invoice> leedModelArrayList;
    private Context context;

    public InvoiceAdapter(){}

    public InvoiceAdapter(Context context, ArrayList<Invoice> data) {
        this.leedModelArrayList = data;
        this.context = context;
    }

    @Override
    public InvoicesViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        InvoiceAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding;
        telecallerLeedsAdapterLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.invoice_adapter_layout, parent, false);
        return new InvoicesViewHolder(telecallerLeedsAdapterLayoutBinding);
    }

    private Invoice getModel(int position) {
        return leedModelArrayList.get(getItemCount() - 1 - position);
    }

    @Override
    public void onBindViewHolder(final InvoicesViewHolder holder, final int listPosition) {
        try {
            Invoice leedModel = getModel(listPosition);
            if (!Utility.isEmptyOrNull(leedModel.getCustomerName()))
                holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.setText(leedModel.getCustomerName());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getInvoiceId()))
                holder.telecallerLeedsAdapterLayoutBinding.txtcnamevalue.setText(leedModel.getInvoiceId());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtcnamevalue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getStatus()))
                holder.telecallerLeedsAdapterLayoutBinding.txtBankValue.setText(leedModel.getStatus());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtBankValue.setText(getString(R.string.na));
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
            if (!Utility.isEmptyOrNull(leedModel.getPhone()))
                holder.telecallerLeedsAdapterLayoutBinding.txtLoanTypeValue.setText(leedModel.getPhone());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtLoanTypeValue.setText(getString(R.string.na));
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

    public void reload(ArrayList<Invoice> leedsModelArrayList) {
        leedModelArrayList.clear();
        leedModelArrayList.addAll(leedsModelArrayList);
        notifyDataSetChanged();
    }
}