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

public class Customers_Adapter extends RecyclerView.Adapter<Customers_Adapter.ViewHolder> {

    private static List<User> searchArrayList;
    private Context context;
    private boolean isFromRequest;
    private LeedRepository leedRepository;
    private List<LeedsModel> leedsModelList;
    int count = 0;


    public Customers_Adapter(Context context, List<User> userArrayList, boolean isFromRequest) {
        this.context = context;
        this.searchArrayList = userArrayList;
        this.isFromRequest = isFromRequest;
    }

    @Override
    public Customers_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.customers_adapter_layout, parent, false);
        Customers_Adapter.ViewHolder viewHolder = new ViewHolder(v);
        //  context = parent.getContext();
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final Customers_Adapter.ViewHolder holder, int position) {

        leedRepository = new LeedRepositoryImpl();
        leedsModelList = new ArrayList<>();

        final User user = searchArrayList.get(position);


        if (user.getUserName() != null) {
            holder.txtName.setText(user.getUserName());
        } else {
            holder.txtName.setText("null");
        }

        String id = user.getAgentId();
        if (id != null) {
            leedRepository.readLeedsByUserId(id, new CallBack() {
                @Override
                public void onSuccess(Object object) {
                    leedsModelList = (List<LeedsModel>) object;
                    if (leedsModelList != null) {
                        count = leedsModelList.size();
                    }

                    if (count != 0) {
                        holder.txtFiles.setText(String.valueOf(count));
                    } else {
                        holder.txtFiles.setText("0");
                    }
                }

                @Override
                public void onError(Object object) {

                }
            });
        }


    }

    @Override
    public int getItemCount() {
        return searchArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtFiles;
        CardView card_view;
        LinearLayout layout;

        public ViewHolder(View itemView) {
            super(itemView);


            txtName = (TextView) itemView.findViewById(R.id.txtname);
            txtFiles = (TextView) itemView.findViewById(R.id.txtfilescount);


        }
    }

}