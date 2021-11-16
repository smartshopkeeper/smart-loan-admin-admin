package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.content.Context;
import android.content.Intent;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin_new.Listners.OnCheckedClickListener;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.models.Bank;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.Sales_Bank_Customers_Activity;

import java.util.ArrayList;
import java.util.List;

public class SalesLabelsAdapter extends RecyclerView.Adapter<SalesLabelsAdapter.ViewHolder> {

    private static ArrayList<Bank> searchArrayList;
    private Context context;
    LeedRepository leedRepository;
    ArrayList<LeedsModel> leedsModelArrayList;
    String count;


    public SalesLabelsAdapter(Context context, ArrayList<Bank> userArrayList) {
        this.context = context;
        this.searchArrayList = userArrayList;

    }

    @Override
    public SalesLabelsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sales_labels_adapter_layout, parent, false);
        SalesLabelsAdapter.ViewHolder viewHolder = new ViewHolder(v);
        //  context = parent.getContext();
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final SalesLabelsAdapter.ViewHolder holder, int position) {
        final Bank item = searchArrayList.get(position);

        leedRepository = new LeedRepositoryImpl();
        leedsModelArrayList = new ArrayList<>();
        holder.bankName.setText(item.getBankname());

        if (position % 2 == 0) {
            holder.bankName.setBackgroundResource(R.color.black_color);
        } else {
            holder.bankName.setBackgroundResource(R.color.red);
        }

        leedsModelArrayList.clear();
        leedRepository.readLeedsByBankName(item.getBankname(), new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    leedsModelArrayList = (ArrayList<LeedsModel>) object;
                    count = String.valueOf(leedsModelArrayList.size());
                    if (count != null) {
                        holder.CustomerCount.setText(count + " Customers");
                    }
                } else {
                    holder.CustomerCount.setText("0 Customers");
                }

            }

            @Override
            public void onError(Object object) {

            }
        });

        holder.card_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.card_view.getContext(), Sales_Bank_Customers_Activity.class);
                intent.putExtra("bank", item.getBankname());
                holder.card_view.getContext().startActivity(intent);

            }

        });

    }

    @Override
    public int getItemCount() {
        return searchArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CardView card_view;
        TextView bankName, CustomerCount;
        LinearLayout layout;

        public ViewHolder(View itemView) {
            super(itemView);

            bankName = (TextView) itemView.findViewById(R.id.bankname);
            CustomerCount = (TextView) itemView.findViewById(R.id.customercount);
            layout = (LinearLayout) itemView.findViewById(R.id.layout);
            card_view = (CardView) itemView.findViewById(R.id.card_view_checklist);

        }
    }

}