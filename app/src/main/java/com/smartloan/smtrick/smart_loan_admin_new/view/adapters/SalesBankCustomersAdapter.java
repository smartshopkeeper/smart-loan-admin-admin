package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.content.Context;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin_new.Listners.OnCheckedClickListener;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedModel;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;

import java.util.ArrayList;
import java.util.List;

public class SalesBankCustomersAdapter extends RecyclerView.Adapter<SalesBankCustomersAdapter.ViewHolder> {

    private static ArrayList<LeedsModel> searchArrayList;
    private Context context;
    private boolean isFromRequest;

    public SalesBankCustomersAdapter(Context context, ArrayList<LeedsModel> userArrayList) {
        this.context = context;
        this.searchArrayList = userArrayList;

    }

    @Override
    public SalesBankCustomersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sales_bankcustomers_adapter_layout, parent, false);
        SalesBankCustomersAdapter.ViewHolder viewHolder = new ViewHolder(v);
        //  context = parent.getContext();
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final SalesBankCustomersAdapter.ViewHolder holder, int position) {
        final LeedsModel leedsModel = searchArrayList.get(position);

        holder.Item.setText(leedsModel.getCustomerName());



    }

    @Override
    public int getItemCount() {
        return searchArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CardView card_view;
        TextView Item;
        EditText edtCustomer;


        public ViewHolder(View itemView) {
            super(itemView);

            Item = (TextView) itemView.findViewById(R.id.Customername);
            edtCustomer = (EditText) itemView.findViewById(R.id.customer);

            card_view = (CardView) itemView.findViewById(R.id.card_view_customer);

        }
    }

}