package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.GetterSetterInvoice;

import java.util.ArrayList;

public class Co_CustumadapterLead extends BaseAdapter {


    private static ArrayList<GetterSetterInvoice> searchArrayList;

    private LayoutInflater mInflater;

    public Co_CustumadapterLead(Context context, ArrayList<GetterSetterInvoice> results) {
        searchArrayList = results;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return searchArrayList.size();
    }

    public Object getItem(int position) {
        return searchArrayList.get(position);
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.leadlistitem_coordinator, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.txtid1);
            holder.txtCityState = (TextView) convertView.findViewById(R.id.txtcname1);
            holder.txtPhone = (TextView) convertView.findViewById(R.id.txtgby1);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtName.setText(searchArrayList.get(position).getName());
        holder.txtCityState.setText(searchArrayList.get(position).getCityState());
        holder.txtPhone.setText(searchArrayList.get(position).getPhone());

        return convertView;
    }

    static class ViewHolder {
        TextView txtName;
        TextView txtCityState;
        TextView txtPhone;
    }
}