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

public class Documents_Adapter extends RecyclerView.Adapter<Documents_Adapter.ViewHolder> {

    private static List<String> searchArrayList;
    private Context context;
    private boolean isFromRequest;
    private LeedRepository leedRepository;
    private List<LeedsModel> leedsModelList;
    int count = 0;


    public Documents_Adapter(Context context, List<String> userArrayList) {
        this.context = context;
        this.searchArrayList = userArrayList;

    }

    @Override
    public Documents_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.documents_adapter_layout, parent, false);
        Documents_Adapter.ViewHolder viewHolder = new ViewHolder(v);
        //  context = parent.getContext();
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final Documents_Adapter.ViewHolder holder, int position) {


        String Doc = searchArrayList.get(position);

        holder.txtDoc.setText(Doc);


    }

    @Override
    public int getItemCount() {
        return searchArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtDoc;
        CardView card_view;
        LinearLayout layout;

        public ViewHolder(View itemView) {
            super(itemView);

            txtDoc = (TextView) itemView.findViewById(R.id.txtdoc);

        }
    }

}