package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.content.Context;
import android.content.Intent;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.models.Expences;
import com.smartloan.smtrick.smart_loan_admin_new.models.Invoice;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.Accountant_Update_Invoice_Activity;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.Home_Activity;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.GLOBAL_DATE_FORMATE;

public class Accountant_Rejected_Invoices_Adapter extends RecyclerView.Adapter<Accountant_Rejected_Invoices_Adapter.ViewHolder> {

    private static List<Invoice> invoiceArrayList;
    private Context context;
    private boolean isFromRequest;
    ProgressDialogClass progressDialogClass;
    LeedRepository leedRepository;

    public Accountant_Rejected_Invoices_Adapter(Context context, List<Invoice> userArrayList) {
        this.context = context;
        this.invoiceArrayList = userArrayList;

    }

    @Override
    public Accountant_Rejected_Invoices_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.acct_rejected_invoice_adapter_layout, parent, false);
        Accountant_Rejected_Invoices_Adapter.ViewHolder viewHolder = new ViewHolder(v);
        //  context = parent.getContext();
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final Accountant_Rejected_Invoices_Adapter.ViewHolder holder, int position) {
        final Invoice invoice = invoiceArrayList.get(position);

//        holder.txtbillName.setText(": "+searchArrayList.get(position).getBillname());
//        holder.txtbillamount.setText(": "+searchArrayList.get(position).getBillAmount());
//        holder.txtbilldate.setText(": "+Utility.convertMilliSecondsToFormatedDate(searchArrayList.get(position).getCreatedDateTimeLong(), GLOBAL_DATE_FORMATE));
//            holder.txtstatus.setText(": "+searchArrayList.get(position).getStatus());

        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.card_view.getContext(), Accountant_Update_Invoice_Activity.class);
                intent.putExtra(Constant.INVOICE,invoice);
                holder.card_view.getContext().startActivity(intent);
            }
        });
    }

//    private void setLeedStatus(Invoice leedsModel) {
//        leedsModel.setStatus(Constant.STATUS_PAID_BILL);
//        updateLeed(leedsModel.getGeneratedid(), leedsModel.getLeedStatusMap1(),leedsModel.getBillname());
//    }
//    private void updateLeed(String leedId, Map leedsMap, String billname) {
//
//        leedRepository = new LeedRepositoryImpl();
//        leedRepository.updateExpence(leedId, leedsMap, new CallBack() {
//            @Override
//            public void onSuccess(Object object) {
//                progressDialogClass.dismissDialog();
//                Intent intent = new Intent(context, Home_Activity.class);
//                context.startActivity(intent);
//            }
//
//            @Override
//            public void onError(Object object) {
//                progressDialogClass.dismissDialog();
//                Context context1 = context;
//                Utility.showLongMessage(context1, context1.getString(R.string.server_error));
//
//            }
//        });
//    }

    @Override
    public int getItemCount() {
        return invoiceArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtbillName, txtbillamount, txtbilldate, txtstatus;
        CardView card_view;
        LinearLayout layout;

        public ViewHolder(View itemView) {
            super(itemView);


            txtbillName = (TextView) itemView.findViewById(R.id.txt_name_value);
            txtbillamount = (TextView) itemView.findViewById(R.id.txt_amount_value);
            txtbilldate = (TextView) itemView.findViewById(R.id.txt_date_value);
            txtstatus = (TextView) itemView.findViewById(R.id.txt_status_value);
            card_view = (CardView) itemView.findViewById(R.id.card_view_);
            layout = (LinearLayout) itemView.findViewById(R.id.layoutdetails);

        }
    }

}