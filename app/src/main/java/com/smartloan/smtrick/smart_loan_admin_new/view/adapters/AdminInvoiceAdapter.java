package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.content.Context;
import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.AdminInvoiceAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.InvoiceAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.Invoice;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.MainActivity_telecaller;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.TL_Updatelead_property_Details_Activity;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.AdminInvoicesViewHolder;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.InvoicesViewHolder;

import java.util.ArrayList;
import java.util.Map;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.STATUS_APPROVED;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.STATUS_INVOICE_APPROVED;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.STATUS_INVOICE_REJECTED;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.STATUS_VERIFIED;

public class AdminInvoiceAdapter extends RecyclerView.Adapter<AdminInvoicesViewHolder> {

    private ArrayList<Invoice> leedModelArrayList;
    private Context context;
    LeedRepository leedRepository;

    public AdminInvoiceAdapter() {
    }

    public AdminInvoiceAdapter(Context context, ArrayList<Invoice> data) {
        this.leedModelArrayList = data;
        this.context = context;
    }

    @Override
    public AdminInvoicesViewHolder onCreateViewHolder(ViewGroup parent,
                                                      int viewType) {
        AdminInvoiceAdapterLayoutBinding adminInvoiceAdapterLayoutBinding;
        adminInvoiceAdapterLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.admin_invoice_adapter_layout, parent, false);
        return new AdminInvoicesViewHolder(adminInvoiceAdapterLayoutBinding);
    }

    private Invoice getModel(int position) {
        return leedModelArrayList.get(getItemCount() - 1 - position);
    }

    @Override
    public void onBindViewHolder(final AdminInvoicesViewHolder holder, final int listPosition) {
        try {
            leedRepository = new LeedRepositoryImpl();
            final Invoice leedModel = getModel(listPosition);
            if (!Utility.isEmptyOrNull(leedModel.getCustomerName()))
                holder.adminInvoiceAdapterLayoutBinding.txtCustomerValue.setText(leedModel.getCustomerName());
            else
                holder.adminInvoiceAdapterLayoutBinding.txtCustomerValue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getLoanapprovedaamount()))
                holder.adminInvoiceAdapterLayoutBinding.txtapprovedloanvalue.setText(leedModel.getLoanapprovedaamount());
            else
                holder.adminInvoiceAdapterLayoutBinding.txtapprovedloanvalue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getLoandisbussedamount()))
                holder.adminInvoiceAdapterLayoutBinding.txtTxtDisbussloanValue.setText(leedModel.getLoandisbussedamount());
            else
                holder.adminInvoiceAdapterLayoutBinding.txtTxtDisbussloanValue.setText(getString(R.string.na));

            if (!Utility.isEmptyOrNull(leedModel.getPayoutPayableAfterTdsAmount()))
                holder.adminInvoiceAdapterLayoutBinding.txtTxtCommissionValue.setText(leedModel.getPayoutPayableAfterTdsAmount());
            else
                holder.adminInvoiceAdapterLayoutBinding.txtTxtCommissionValue.setText(getString(R.string.na));

            holder.adminInvoiceAdapterLayoutBinding.cardViewApprove.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setLeedStatus(leedModel);
                }

                private void setLeedStatus(Invoice invoice) {

                    invoice.setStatus(STATUS_INVOICE_APPROVED);
//                    Toast.makeText(holder.adminInvoiceAdapterLayoutBinding.cardView.getContext(), "Lead Verify Successfully", Toast.LENGTH_SHORT).show();
                    updateLeed(invoice.getInvoiceId(), invoice.getLeedStatusMap());

                }

                private void updateLeed(String leedId, Map leedsMap) {
                    leedRepository.updateInvoice(leedId, leedsMap, new CallBack() {
                        @Override
                        public void onSuccess(Object object) {
                            Toast.makeText(holder.adminInvoiceAdapterLayoutBinding.cardView.getContext(), "Invoice Approved Successfully", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onError(Object object) {

                            Utility.showLongMessage(holder.adminInvoiceAdapterLayoutBinding.cardView.getContext(), getString(R.string.server_error));
                        }
                    });
                }
            });

            holder.adminInvoiceAdapterLayoutBinding.cardViewReject.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    setLeedStatus(leedModel);
                }

                private void setLeedStatus(Invoice invoice) {

                    invoice.setStatus(STATUS_INVOICE_REJECTED);
                    Toast.makeText(holder.adminInvoiceAdapterLayoutBinding.cardView.getContext(), "Lead Verify Successfully", Toast.LENGTH_SHORT).show();
                    updateLeed(invoice.getInvoiceId(), invoice.getLeedStatusMap1());

                }

                private void updateLeed(String leedId, Map leedsMap) {
                    leedRepository.updateInvoice(leedId, leedsMap, new CallBack() {
                        @Override
                        public void onSuccess(Object object) {
                            Toast.makeText(holder.adminInvoiceAdapterLayoutBinding.cardView.getContext(), "Invoice Rejected", Toast.LENGTH_SHORT).show();

                        }

                        @Override
                        public void onError(Object object) {

                            Utility.showLongMessage(holder.adminInvoiceAdapterLayoutBinding.cardView.getContext(), getString(R.string.server_error));
                        }
                    });
                }
            });

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