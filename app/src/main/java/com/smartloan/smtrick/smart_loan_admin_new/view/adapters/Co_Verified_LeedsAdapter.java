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

import com.bumptech.glide.Glide;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.CoVerifiedLeedsAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.TelecallerLeedsAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Co_View_Lead_Details_Fragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.CoVerifiedLeedsViewHolder;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.TelecallerLeedsViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Co_Verified_LeedsAdapter extends RecyclerView.Adapter<CoVerifiedLeedsViewHolder> {

    private ArrayList<LeedsModel> leedModelArrayList;
    private Context context;
    int index = -1;
    private int selectedPosition = 0;
    static int m = 0;

    public Co_Verified_LeedsAdapter(){}

    public Co_Verified_LeedsAdapter(Context context, ArrayList<LeedsModel> data) {
        this.leedModelArrayList = data;
        this.context = context;
    }

    @Override
    public CoVerifiedLeedsViewHolder onCreateViewHolder(ViewGroup parent,
                                                        int viewType) {
        CoVerifiedLeedsAdapterLayoutBinding coVerifiedLeedsAdapterLayoutBinding;
        coVerifiedLeedsAdapterLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.co_verified_leeds_adapter_layout, parent, false);
        return new CoVerifiedLeedsViewHolder(coVerifiedLeedsAdapterLayoutBinding);
    }

    private LeedsModel getModel(int position) {
        return leedModelArrayList.get(getItemCount() - 1 - position);
    }

    @Override
    public void onBindViewHolder(final CoVerifiedLeedsViewHolder holder, final int listPosition) {
        try {

            LeedsModel leedModel2 = getModel(listPosition);

            holder.coVerifiedLeedsAdapterLayoutBinding.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    index = listPosition;
                    notifyDataSetChanged();
                }
            });

            if(index==listPosition){
                holder.coVerifiedLeedsAdapterLayoutBinding.cardView.setBackgroundColor(Color.parseColor("#1E88E5"));
                holder.coVerifiedLeedsAdapterLayoutBinding.txtIdValue.setTextColor(Color.parseColor("#FFFFFF"));
                holder.coVerifiedLeedsAdapterLayoutBinding.txtcnamevalue.setTextColor(Color.parseColor("#FFFFFF"));
                holder.coVerifiedLeedsAdapterLayoutBinding.txtLoanTypeValue.setTextColor(Color.parseColor("#FFFFFF"));
                holder.coVerifiedLeedsAdapterLayoutBinding.txtLo.setTextColor(Color.parseColor("#FFFFFF"));
            }else{
                holder.coVerifiedLeedsAdapterLayoutBinding.cardView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                holder.coVerifiedLeedsAdapterLayoutBinding.txtIdValue.setTextColor(Color.parseColor("#000000"));
                holder.coVerifiedLeedsAdapterLayoutBinding.txtcnamevalue.setTextColor(Color.parseColor("#000000"));
                holder.coVerifiedLeedsAdapterLayoutBinding.txtLoanTypeValue.setTextColor(Color.parseColor("#000000"));
                holder.coVerifiedLeedsAdapterLayoutBinding.txtLo.setTextColor(Color.parseColor("#000000"));
            }

            if (m == 0) {
                if(listPosition == selectedPosition){
                    holder.itemView.setSelected(true);
                    holder.coVerifiedLeedsAdapterLayoutBinding.cardView.setBackgroundColor(Color.parseColor("#1E88E5"));
                    holder.coVerifiedLeedsAdapterLayoutBinding.txtIdValue.setTextColor(Color.parseColor("#FFFFFF"));
                    holder.coVerifiedLeedsAdapterLayoutBinding.txtcnamevalue.setTextColor(Color.parseColor("#FFFFFF"));
                    holder.coVerifiedLeedsAdapterLayoutBinding.txtLoanTypeValue.setTextColor(Color.parseColor("#FFFFFF"));
                    holder.coVerifiedLeedsAdapterLayoutBinding.txtLo.setTextColor(Color.parseColor("#FFFFFF"));
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(Constant.LEED_MODEL, leedModel2);// Put anything what you want
                    Co_View_Lead_Details_Fragment fragment2 = new Co_View_Lead_Details_Fragment();
                    fragment2.setArguments(bundle);
                    FragmentTransaction ft = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.detailContainer,  fragment2);
                    ft.commit();

                } else {
                    holder.itemView.setSelected(false);
                    holder.coVerifiedLeedsAdapterLayoutBinding.cardView.setBackgroundColor(Color.parseColor("#FFFFFF"));
                    holder.coVerifiedLeedsAdapterLayoutBinding.txtIdValue.setTextColor(Color.parseColor("#000000"));
                    holder.coVerifiedLeedsAdapterLayoutBinding.txtcnamevalue.setTextColor(Color.parseColor("#000000"));
                    holder.coVerifiedLeedsAdapterLayoutBinding.txtLoanTypeValue.setTextColor(Color.parseColor("#000000"));
                    holder.coVerifiedLeedsAdapterLayoutBinding.txtLo.setTextColor(Color.parseColor("#000000"));

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

            if (leedModel.getStatus().equalsIgnoreCase("")){
                Picasso.with(holder.coVerifiedLeedsAdapterLayoutBinding.imgleadStatus.getContext())
                        .load(R.drawable.dot_green)
                        .placeholder(R.drawable.loading)
                        .into(holder.coVerifiedLeedsAdapterLayoutBinding.imgleadStatus);
            }else if (leedModel.getStatus().equalsIgnoreCase("")){
                Picasso.with(holder.coVerifiedLeedsAdapterLayoutBinding.imgleadStatus.getContext())
                        .load(R.drawable.dot_orenge)
                        .placeholder(R.drawable.loading)
                        .into(holder.coVerifiedLeedsAdapterLayoutBinding.imgleadStatus);
            }

            if (!Utility.isEmptyOrNull(leedModel.getCustomerName()))
                holder.coVerifiedLeedsAdapterLayoutBinding.txtIdValue.setText(leedModel.getCustomerName());
            else
                holder.coVerifiedLeedsAdapterLayoutBinding.txtIdValue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getLoanType()))
                holder.coVerifiedLeedsAdapterLayoutBinding.txtcnamevalue.setText(leedModel.getLoanType());
            else
                holder.coVerifiedLeedsAdapterLayoutBinding.txtcnamevalue.setText(getString(R.string.na));

            if (!Utility.isEmptyOrNull(leedModel.getAgentName()))
                holder.coVerifiedLeedsAdapterLayoutBinding.txtLoanTypeValue.setText(leedModel.getAgentName());
            else
                holder.coVerifiedLeedsAdapterLayoutBinding.txtLoanTypeValue.setText(getString(R.string.na));

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