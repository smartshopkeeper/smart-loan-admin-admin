package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.content.Context;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin_new.R;

import java.util.List;

public class BankCustomerAdapter extends RecyclerView.Adapter<BankCustomerAdapter.ViewHolder> {

    private Context context;
    private List<String> list;


    String item;


    public BankCustomerAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public BankCustomerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.catalogsublist, parent, false);
        BankCustomerAdapter.ViewHolder viewHolder = new BankCustomerAdapter.ViewHolder(v);
        //  context = parent.getContext();
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final BankCustomerAdapter.ViewHolder holder, final int position) {
        //String pname = list.get(position);
        final String pveo = list.get(position);

        holder.BankName.setText(pveo);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public TextView BankName;
        public CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            BankName = (TextView) itemView.findViewById(R.id.subcatalog_name);

            cardView = (CardView) itemView.findViewById(R.id.card);

        }
    }
}
