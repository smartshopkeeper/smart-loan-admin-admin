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
import com.smartloan.smtrick.smart_loan_admin_new.models.Item;
import com.smartloan.smtrick.smart_loan_admin_new.models.User;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.Update_User_Activity;

import java.util.List;

public class SalesChecklistAdapter extends RecyclerView.Adapter<SalesChecklistAdapter.ViewHolder> {

    private static List<String> searchArrayList;
    private Context context;
    private boolean isFromRequest;
    private OnCheckedClickListener onImageClickListener;

    public SalesChecklistAdapter(Context context, List<String> userArrayList, OnCheckedClickListener onImageClickListener) {
        this.context = context;
        this.searchArrayList = userArrayList;
        this.onImageClickListener = onImageClickListener;

    }

    @Override
    public SalesChecklistAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sales_checklist_adapter_layout, parent, false);
        SalesChecklistAdapter.ViewHolder viewHolder = new ViewHolder(v);
        //  context = parent.getContext();
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final SalesChecklistAdapter.ViewHolder holder, int position) {
        final String item = searchArrayList.get(position);

        holder.Item.setText(item);

        holder.Item.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    String item = holder.Item.getText().toString();
                    onImageClickListener.onImageClick(item, true);
                    holder.Item.setEnabled(false);

                } else if (!isChecked) {
                    String item1 = holder.Item.getText().toString();
                    onImageClickListener.onImageClick(item1, false);
                    holder.Item.setEnabled(true);
//                    Toast.makeText(holder.count.getContext(), String.valueOf(servicesList.size()), Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return searchArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CardView card_view;
        CheckBox Item;

        public ViewHolder(View itemView) {
            super(itemView);

            Item = (CheckBox) itemView.findViewById(R.id.checklistitem);
            card_view = (CardView) itemView.findViewById(R.id.card_view_checklist);

        }
    }

}