package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.AdminApprovedInvoiceAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.AdminInvoiceAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.Invoice;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.AdminInvoicesViewHolder;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.AdminapprovedInvoicesViewHolder;

import java.util.ArrayList;
import java.util.Map;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.STATUS_APPROVED;

public class AdminApprovedInvoiceAdapter extends RecyclerView.Adapter<AdminapprovedInvoicesViewHolder> {

    private ArrayList<Invoice> leedModelArrayList;
    private Context context;
    LeedRepository leedRepository;

    public AdminApprovedInvoiceAdapter(){}

    public AdminApprovedInvoiceAdapter(Context context, ArrayList<Invoice> data) {
        this.leedModelArrayList = data;
        this.context = context;
    }

    @Override
    public AdminapprovedInvoicesViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        AdminApprovedInvoiceAdapterLayoutBinding adminApprovedInvoiceAdapterLayoutBinding;
        adminApprovedInvoiceAdapterLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.admin_approved_invoice_adapter_layout, parent, false);
        return new AdminapprovedInvoicesViewHolder(adminApprovedInvoiceAdapterLayoutBinding);
    }

    private Invoice getModel(int position) {
        return leedModelArrayList.get(getItemCount() - 1 - position);
    }

    @Override
    public void onBindViewHolder(final AdminapprovedInvoicesViewHolder holder, final int listPosition) {
        try {
            leedRepository = new LeedRepositoryImpl();
            final Invoice leedModel = getModel(listPosition);
            if (!Utility.isEmptyOrNull(leedModel.getCustomerName()))
                holder.adminApprovedInvoiceAdapterLayoutBinding.txtCustomerValue.setText(leedModel.getCustomerName());
            else
                holder.adminApprovedInvoiceAdapterLayoutBinding.txtCustomerValue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getLoanapprovedaamount()))
                holder.adminApprovedInvoiceAdapterLayoutBinding.txtapprovedloanvalue.setText(leedModel.getLoanapprovedaamount());
            else
                holder.adminApprovedInvoiceAdapterLayoutBinding.txtapprovedloanvalue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getLoandisbussedamount()))
                holder.adminApprovedInvoiceAdapterLayoutBinding.txtTxtDisbussloanValue.setText(leedModel.getLoandisbussedamount());
            else
                holder.adminApprovedInvoiceAdapterLayoutBinding.txtTxtDisbussloanValue.setText(getString(R.string.na));

            if (!Utility.isEmptyOrNull(leedModel.getPayoutPayableAfterTdsAmount()))
                holder.adminApprovedInvoiceAdapterLayoutBinding.txtTxtCommissionValue.setText(leedModel.getPayoutPayableAfterTdsAmount());
            else
                holder.adminApprovedInvoiceAdapterLayoutBinding.txtTxtCommissionValue.setText(getString(R.string.na));

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