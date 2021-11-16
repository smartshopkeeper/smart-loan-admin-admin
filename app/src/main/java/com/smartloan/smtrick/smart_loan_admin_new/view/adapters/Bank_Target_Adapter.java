package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.content.Context;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.models.User;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class Bank_Target_Adapter extends RecyclerView.Adapter<Bank_Target_Adapter.ViewHolder> {

    private static List<LeedsModel> searchArrayList;
    private Context context;


    public Bank_Target_Adapter(Context context, List<LeedsModel> userArrayList) {
        this.context = context;
        this.searchArrayList = userArrayList;

    }

    @Override
    public Bank_Target_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bank_target_adapter_layout, parent, false);
        Bank_Target_Adapter.ViewHolder viewHolder = new ViewHolder(v);
        //  context = parent.getContext();
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final Bank_Target_Adapter.ViewHolder holder, int position) {

        final LeedsModel leedsModel = searchArrayList.get(position);

        if (leedsModel.getBankName() != null) {
            holder.txtBankName.setText(leedsModel.getBankName());
        } else {
            holder.txtBankName.setText("");
        }
        if (leedsModel.getBankName() != null) {
            holder.txtTarget.setText(leedsModel.getBankName());
        } else {
            holder.txtTarget.setText("");
        }
        if (leedsModel.getBankName() != null) {
            holder.txtBalance.setText(leedsModel.getBankName());
        } else {
            holder.txtBalance.setText("");
        }
        if (leedsModel.getBankName() != null) {
            holder.txtLoggedAmt.setText(leedsModel.getBankName());
        } else {
            holder.txtLoggedAmt.setText("");
        }


    }

    @Override
    public int getItemCount() {
        return searchArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtBankName, txtTarget, txtLoggedAmt, txtBalance;

        public ViewHolder(View itemView) {
            super(itemView);


            txtBankName = (TextView) itemView.findViewById(R.id.txtBankname);
            txtTarget = (TextView) itemView.findViewById(R.id.txtsettarget);
            txtLoggedAmt = (TextView) itemView.findViewById(R.id.txtloggedamount);
            txtBalance = (TextView) itemView.findViewById(R.id.txtbalance);


        }
    }

}