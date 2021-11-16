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
import com.smartloan.smtrick.smart_loan_admin_new.models.User;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.Update_User_Activity;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder> {

    private static List<User> searchArrayList;
    private Context context;
    private boolean isFromRequest;


    public UsersAdapter(Context context, List<User> userArrayList, boolean isFromRequest) {
        this.context = context;
        this.searchArrayList = userArrayList;
        this.isFromRequest = isFromRequest;
    }

    @Override
    public UsersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_adapter_layout, parent, false);
        UsersAdapter.ViewHolder viewHolder = new ViewHolder(v);
        //  context = parent.getContext();
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final UsersAdapter.ViewHolder holder, int position) {
        final User user = searchArrayList.get(position);

        holder.txtName.setText(searchArrayList.get(position).getUserName());
        holder.txtType.setText(searchArrayList.get(position)
                .getRole());
        holder.txtcontact.setText(searchArrayList.get(position).getMobileNumber());
        try {
            holder.txtstatus.setText(searchArrayList.get(position).getStatus());
        }catch (Exception e){}

        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.card_view.getContext(), Update_User_Activity.class);
                intent.putExtra("user", user);
                holder.card_view.getContext().startActivity(intent);
            }
        });
        holder.txtstatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return searchArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtType, txtcontact, txtstatus;
        CardView card_view;
        LinearLayout layout;

        public ViewHolder(View itemView) {
            super(itemView);


            txtName = (TextView) itemView.findViewById(R.id.txtidvalue);
            txtType = (TextView) itemView.findViewById(R.id.txtcnamevalue);
            txtcontact = (TextView) itemView.findViewById(R.id.txtbankvalue);
            txtstatus = (TextView) itemView.findViewById(R.id.textview_user_status);
            card_view = (CardView) itemView.findViewById(R.id.card_view);
            layout = (LinearLayout) itemView.findViewById(R.id.layoutdetails);

        }
    }
//    public UsersAdapter(Context context, ArrayList<UserModel> results, boolean isFromRequest) {
//        searchArrayList = results;
//        this.isFromRequest = isFromRequest;
//        mInflater = LayoutInflater.from(context);
//    }
//
//    public int getCount() {
//        return searchArrayList.size();
//    }
//
//    public Object getItem(int position) {
//        return searchArrayList.get(position);
//    }
//
//    public long getItemId(int position) {
//        return position;
//    }
//
//    public View getView(int position, View convertView, ViewGroup parent) {
//        ViewHolder holder;
//        if (convertView == null) {
//            convertView = mInflater.inflate(R.layout.user_adapter_layout, null);
//            holder = new ViewHolder();
//            holder.txtName = (TextView) convertView.findViewById(R.id.txtidvalue);
//            holder.txtType = (TextView) convertView.findViewById(R.id.txtcnamevalue);
//            holder.txtcontact = (TextView) convertView.findViewById(R.id.txtbankvalue);
//            holder.txtstatus = (TextView) convertView.findViewById(R.id.textview_user_status);
//            holder.card_view = (CardView) convertView.findViewById(R.id.card_view);
//            convertView.setTag(holder);
//        } else {
//            holder = (ViewHolder) convertView.getTag();
//        }
//        holder.txtName.setText(searchArrayList.get(position).getName());
//        holder.txtType.setText(searchArrayList.get(position)
//                .getType());
//        holder.txtcontact.setText(searchArrayList.get(position).getMobileNumber());
//        if (isFromRequest) {
//            holder.card_view.setVisibility(View.GONE);
//        } else {
//            holder.txtstatus.setText(searchArrayList.get(position).getUserStatus());
//        }
//        return convertView;
//    }
//
//    static class ViewHolder {
//        TextView txtName;
//        TextView txtType;
//        TextView txtcontact;
//        TextView txtstatus;
//        CardView card_view;
//    }
}