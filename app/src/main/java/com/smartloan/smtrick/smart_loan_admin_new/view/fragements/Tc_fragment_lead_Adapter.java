package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.GetterSetterInvoice;

import java.util.ArrayList;

public class Tc_fragment_lead_Adapter extends BaseAdapter {


    private static ArrayList<GetterSetterInvoice> searchArrayList;

    private LayoutInflater mInflater;

    public Tc_fragment_lead_Adapter(Context context, ArrayList<GetterSetterInvoice> results) {
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
            convertView = mInflater.inflate(R.layout.tc_fragment_lead_adapter_listitem, null);
            holder = new ViewHolder();
            holder.txtName = (TextView) convertView.findViewById(R.id.txtidvalue);
            holder.txtCityState = (TextView) convertView.findViewById(R.id.txtcnamevalue);
            holder.txtPhone = (TextView) convertView.findViewById(R.id.txtbankvalue);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.txtName.setText(searchArrayList.get(position).getName());
        holder.txtCityState.setText(searchArrayList.get(position)
                .getCityState());
        holder.txtPhone.setText(searchArrayList.get(position).getPhone());

        return convertView;
    }

    static class ViewHolder {
        TextView txtName;
        TextView txtCityState;
        TextView txtPhone;
    }
}