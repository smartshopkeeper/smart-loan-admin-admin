package com.smartloan.smtrick.smart_loan_admin_new.view.holders;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin_new.R;

public class InvoiceViewHolder extends RecyclerView.ViewHolder {
   public TextView txtInvoiceId;
    public TextView txtCustomerName;
    public TextView txtPhone;
    public TextView txtStatus;
    public InvoiceViewHolder(View itemView) {
        super(itemView);
        txtInvoiceId = (TextView) itemView.findViewById(R.id.txtidvalue);
        txtCustomerName = (TextView) itemView.findViewById(R.id.txtcnamevalue);
        txtPhone = (TextView) itemView.findViewById(R.id.txtbankvalue);
        txtStatus = (TextView) itemView.findViewById(R.id.txt_status_value);
    }
}
