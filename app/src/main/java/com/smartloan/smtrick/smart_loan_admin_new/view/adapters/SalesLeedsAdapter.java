package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.content.Context;
import androidx.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.SalesLeedsAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.View_Bank_Submited_Lead_Details_Fragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.View_Lead_Details_Fragment1;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.SalesLeedsViewHolder;

import java.util.ArrayList;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.GLOBAL_DATE_FORMATE;

public class SalesLeedsAdapter extends RecyclerView.Adapter<SalesLeedsViewHolder> {

    private ArrayList<LeedsModel> leedModelArrayList;
    private Context context;
    int index = -1;
    private int selectedPosition = 0;
    static int m = 0;


    public SalesLeedsAdapter(Context context, ArrayList<LeedsModel> data) {
        this.leedModelArrayList = data;
        this.context = context;
    }

    @Override
    public SalesLeedsViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        SalesLeedsAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding;
        telecallerLeedsAdapterLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.sales_leeds_adapter_layout, parent, false);
        return new SalesLeedsViewHolder(telecallerLeedsAdapterLayoutBinding);
    }

    private LeedsModel getModel(int position) {
        return leedModelArrayList.get(getItemCount() - 1 - position);
    }

    @Override
    public void onBindViewHolder(final SalesLeedsViewHolder holder, final int listPosition) {
        try {

            LeedsModel leedModel2 = getModel(listPosition);

            holder.telecallerLeedsAdapterLayoutBinding.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    index = listPosition;
                    notifyDataSetChanged();
                }
            });

            if(index==listPosition){
                holder.telecallerLeedsAdapterLayoutBinding.cardView.setBackgroundColor(Color.parseColor("#1E88E5"));
                holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.setTextColor(Color.parseColor("#FFFFFF"));
                holder.telecallerLeedsAdapterLayoutBinding.txtcnamevalue.setTextColor(Color.parseColor("#FFFFFF"));
                holder.telecallerLeedsAdapterLayoutBinding.txtLoanTypeValue.setTextColor(Color.parseColor("#FFFFFF"));
                holder.telecallerLeedsAdapterLayoutBinding.txtLo.setTextColor(Color.parseColor("#FFFFFF"));
            }else{
                holder.telecallerLeedsAdapterLayoutBinding.cardView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.setTextColor(Color.parseColor("#000000"));
                holder.telecallerLeedsAdapterLayoutBinding.txtcnamevalue.setTextColor(Color.parseColor("#000000"));
                holder.telecallerLeedsAdapterLayoutBinding.txtLoanTypeValue.setTextColor(Color.parseColor("#000000"));
                holder.telecallerLeedsAdapterLayoutBinding.txtLo.setTextColor(Color.parseColor("#000000"));
            }

            if (m == 0) {
            if(listPosition == selectedPosition){
                holder.itemView.setSelected(true);
                holder.telecallerLeedsAdapterLayoutBinding.cardView.setBackgroundColor(Color.parseColor("#1E88E5"));
                holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.setTextColor(Color.parseColor("#FFFFFF"));
                holder.telecallerLeedsAdapterLayoutBinding.txtcnamevalue.setTextColor(Color.parseColor("#FFFFFF"));
                holder.telecallerLeedsAdapterLayoutBinding.txtLoanTypeValue.setTextColor(Color.parseColor("#FFFFFF"));
                holder.telecallerLeedsAdapterLayoutBinding.txtLo.setTextColor(Color.parseColor("#FFFFFF"));
                Bundle bundle = new Bundle();
                bundle.putSerializable(Constant.LEED_MODEL, leedModel2);// Put anything what you want
                View_Bank_Submited_Lead_Details_Fragment fragment2 = new View_Bank_Submited_Lead_Details_Fragment();
                fragment2.setArguments(bundle);
                FragmentTransaction ft = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.detailContainer,  fragment2);
                ft.commit();

            } else {
                holder.itemView.setSelected(false);
                holder.telecallerLeedsAdapterLayoutBinding.cardView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.setTextColor(Color.parseColor("#000000"));
                holder.telecallerLeedsAdapterLayoutBinding.txtcnamevalue.setTextColor(Color.parseColor("#000000"));
                holder.telecallerLeedsAdapterLayoutBinding.txtLoanTypeValue.setTextColor(Color.parseColor("#000000"));
                holder.telecallerLeedsAdapterLayoutBinding.txtLo.setTextColor(Color.parseColor("#000000"));

            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int currentPosition = holder.getLayoutPosition();
                    if(selectedPosition != currentPosition){
                        // Temporarily save the last selected position
                        int lastSelectedPosition = selectedPosition;
                        // Save the new selected position
                        selectedPosition = currentPosition;
                        // update the previous selected row
                        notifyItemChanged(lastSelectedPosition);
                        // select the clicked row
                        holder.itemView.setSelected(true);
                    }
                }
            });
                m++;
            }


            LeedsModel leedModel = getModel(listPosition);
            if (!Utility.isEmptyOrNull(leedModel.getCustomerName()))
                holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.setText(leedModel.getCustomerName());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getLoanType()))
                holder.telecallerLeedsAdapterLayoutBinding.txtcnamevalue.setText(leedModel.getLoanType());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtcnamevalue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getAgentName()))
                holder.telecallerLeedsAdapterLayoutBinding.txtLoanTypeValue.setText(leedModel.getAgentName());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtLoanTypeValue.setText(getString(R.string.na));
//            if (!Utility.isEmptyOrNull(leedModel.getBanknName()))
//                holder.telecallerLeedsAdapterLayoutBinding.txtBankValue.setText(leedModel.getBanknName());
//            else
//                holder.telecallerLeedsAdapterLayoutBinding.txtBankValue.setText(getString(R.string.na));
//            if (!Utility.isEmptyOrNull(leedModel.getAgentName()))
//                holder.telecallerLeedsAdapterLayoutBinding.txtAssignbyValue.setText(leedModel.getAgentName());
//            else
//                holder.telecallerLeedsAdapterLayoutBinding.txtAssignbyValue.setText(getString(R.string.na));
//            if (!Utility.isEmptyOrNull(leedModel.getStatus()))
//                holder.telecallerLeedsAdapterLayoutBinding.txtappointmentvalue.setText(leedModel.getAppointment());
//            else
//                holder.telecallerLeedsAdapterLayoutBinding.txtappointmentvalue.setText(getString(R.string.na));
//            if (!Utility.isEmptyOrNull(leedModel.getLoanType()))
//                holder.telecallerLeedsAdapterLayoutBinding.txtLoanTypeValue.setText(leedModel.getAgentName());
//            else
//                holder.telecallerLeedsAdapterLayoutBinding.txtLoanTypeValue.setText(getString(R.string.na));
//            if (leedModel.getCreatedDateTimeLong() > 0)
//                holder.telecallerLeedsAdapterLayoutBinding.txtAssignDatetimeValue.setText(Utility.convertMilliSecondsToFormatedDate(leedModel.getCreatedDateTimeLong(), GLOBAL_DATE_FORMATE));
//            else
//                holder.telecallerLeedsAdapterLayoutBinding.txtAssignDatetimeValue.setText(getString(R.string.na));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getString(int id) {
        return context.getString(id);
    }

    @Override
    public int getItemCount() {
        return leedModelArrayList.size();
    }

    public void reload(ArrayList<LeedsModel> leedsModelArrayList) {
        leedModelArrayList.clear();
        leedModelArrayList.addAll(leedsModelArrayList);
        notifyDataSetChanged();
    }
}