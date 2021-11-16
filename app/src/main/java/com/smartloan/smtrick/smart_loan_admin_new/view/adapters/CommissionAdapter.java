package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.models.Commission;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.View_Bank_Customers_Activity;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.util.List;
import java.util.Map;

public class CommissionAdapter extends RecyclerView.Adapter<CommissionAdapter.ViewHolder> {

    private Context context;
    private List<Commission> list;
    LeedRepository leedRepository;
    ProgressDialogClass progressDialogClass;
    String item;


    public CommissionAdapter(Context context, List<Commission> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public CommissionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.commission_list, parent, false);
        CommissionAdapter.ViewHolder viewHolder = new CommissionAdapter.ViewHolder(v);


        leedRepository = new LeedRepositoryImpl();
        //  context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CommissionAdapter.ViewHolder holder, final int position) {
        //String pname = list.get(position);
        final Commission pveo = list.get(position);
//

        holder.minvalue.setText(pveo.getMinAmount());
        holder.maxvalue.setText(pveo.getMaxAmount());
        holder.percentage.setText(pveo.getPercentage());
        holder.updateCommission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UpdateCommission();

            }

            private void UpdateCommission() {

//                Commission bank = new Commission();
                pveo.setMinAmount(pveo.getMinAmount());
                pveo.setMaxAmount(pveo.getMaxAmount());
                pveo.setPercentage(holder.percentage.getText().toString());

                updateLeed(pveo.getGeneratedId(), pveo.getLeedStatusMap());

            }

            private void updateLeed(String generatedId, Map<String, Object> toMap) {
                final ProgressDialog dialog = new ProgressDialog(context);
                dialog.setMessage("Please wait.....");
                dialog.show();
                leedRepository.updateCommission(generatedId, toMap, new CallBack() {
                    @Override
                    public void onSuccess(Object object) {

                        Toast.makeText(holder.cardView.getContext(), "Updated", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }

                    @Override
                    public void onError(Object object) {
                        dialog.dismiss();
                    }
                });
            }
        });


    }


    @Override
    public int getItemCount() {

        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView minvalue, maxvalue;
        EditText percentage;
        public CardView cardView;
        Button updateCommission;

        public ViewHolder(View itemView) {
            super(itemView);
            minvalue = (TextView) itemView.findViewById(R.id.minvalue);
            maxvalue = (TextView) itemView.findViewById(R.id.maxvalue);
            percentage = (EditText) itemView.findViewById(R.id.commissionpercentage);
            updateCommission = (Button) itemView.findViewById(R.id.btn_update);
            cardView = (CardView) itemView.findViewById(R.id.card);

        }
    }
}
