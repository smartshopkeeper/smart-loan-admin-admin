package com.smartloan.smtrick.smart_loan_admin_new.view.holders;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin_new.R;

public class UserViewHolder extends RecyclerView.ViewHolder {
    public TextView txtName;
    public TextView txtType;
    public TextView txtcontact;
    public TextView txtstatus;
    public CardView card_view;

    public UserViewHolder(View itemView) {
        super(itemView);
        txtName = (TextView) itemView.findViewById(R.id.txtidvalue);
        txtType = (TextView) itemView.findViewById(R.id.txtcnamevalue);
        txtcontact = (TextView) itemView.findViewById(R.id.txtbankvalue);
        txtstatus = (TextView) itemView.findViewById(R.id.textview_user_status);
        card_view = (CardView) itemView.findViewById(R.id.card_view);
    }
}
