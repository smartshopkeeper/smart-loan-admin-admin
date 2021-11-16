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

public class Telecaller_Adapter extends RecyclerView.Adapter<Telecaller_Adapter.ViewHolder> {

    private static List<User> searchArrayList;
    private Context context;
    private boolean isFromRequest;
    private LeedRepository leedRepository;
    private List<LeedsModel> leedsModelList;


    public Telecaller_Adapter(Context context, List<User> userArrayList, boolean isFromRequest) {
        this.context = context;
        this.searchArrayList = userArrayList;
        this.isFromRequest = isFromRequest;
    }

    @Override
    public Telecaller_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.telecaller_adapter_layout, parent, false);
        Telecaller_Adapter.ViewHolder viewHolder = new ViewHolder(v);
        //  context = parent.getContext();
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final Telecaller_Adapter.ViewHolder holder, int position) {

        leedRepository = new LeedRepositoryImpl();
        leedsModelList = new ArrayList<>();

        final User user = searchArrayList.get(position);

        String id = user.getAgentId();
        leedRepository.readLeedsByUserId(id, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                leedsModelList = (List<LeedsModel>) object;
                int count = leedsModelList.size();

                if (user.getUserName() != null) {
                    holder.txtName.setText(user.getUserName());
                }else {
                    holder.txtName.setText("null");
                }
                if (count != 0) {
                    holder.txtName.setText(count);
                }else {
                    holder.txtFiles.setText("0");
                }
            }

            @Override
            public void onError(Object object) {

            }
        });



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