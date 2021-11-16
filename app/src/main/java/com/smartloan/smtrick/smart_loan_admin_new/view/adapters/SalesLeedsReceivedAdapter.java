package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import androidx.databinding.DataBindingUtil;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.SalesLeedsAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.SalesReceivedLeedsAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.View_Bank_Submited_Lead_Details_Fragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.View_Sales_Received_Lead_Details_Fragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.SalesLeedsViewHolder;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.SalesReceivedLeedsViewHolder;

import java.util.ArrayList;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.GLOBAL_DATE_FORMATE;

public class SalesLeedsReceivedAdapter extends RecyclerView.Adapter<SalesReceivedLeedsViewHolder> {

    private ArrayList<LeedsModel> leedModelArrayList;
    private Context context;
    int index = -1;
    private int selectedPosition = 0;
    static int m = 0;
    private static final int REQUEST_PHONE_CALL = 1;



    public SalesLeedsReceivedAdapter(Context context, ArrayList<LeedsModel> data) {
        this.leedModelArrayList = data;
        this.context = context;
    }

    @Override
    public SalesReceivedLeedsViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        SalesReceivedLeedsAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding;
        telecallerLeedsAdapterLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.sales_received_leeds_adapter_layout, parent, false);
        return new SalesReceivedLeedsViewHolder(telecallerLeedsAdapterLayoutBinding);
    }

    private LeedsModel getModel(int position) {
        return leedModelArrayList.get(getItemCount() - 1 - position);
    }

    @Override
    public void onBindViewHolder(final SalesReceivedLeedsViewHolder holder, final int listPosition) {
        try {

            LeedsModel leedModel2 = getModel(listPosition);

            holder.telecallerLeedsAdapterLayoutBinding.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    index = listPosition;
                    notifyDataSetChanged();
                }
            });

//            if(index==listPosition){
//                holder.telecallerLeedsAdapterLayoutBinding.cardView.setBackgroundColor(Color.parseColor("#1E88E5"));
//                holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.setTextColor(Color.parseColor("#FFFFFF"));
//                holder.telecallerLeedsAdapterLayoutBinding.txtcnamevalue.setTextColor(Color.parseColor("#FFFFFF"));
//                holder.telecallerLeedsAdapterLayoutBinding.txtLoanTypeValue.setTextColor(Color.parseColor("#FFFFFF"));
//                holder.telecallerLeedsAdapterLayoutBinding.txtLo.setTextColor(Color.parseColor("#FFFFFF"));
//            }else{
//                holder.telecallerLeedsAdapterLayoutBinding.cardView.setBackgroundColor(Color.parseColor("#FFFFFF"));
//                holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.setTextColor(Color.parseColor("#000000"));
//                holder.telecallerLeedsAdapterLayoutBinding.txtcnamevalue.setTextColor(Color.parseColor("#000000"));
//                holder.telecallerLeedsAdapterLayoutBinding.txtLoanTypeValue.setTextColor(Color.parseColor("#000000"));
//                holder.telecallerLeedsAdapterLayoutBinding.txtLo.setTextColor(Color.parseColor("#000000"));
//            }

//            if (m == 0) {
//            if(listPosition == selectedPosition){
//                holder.itemView.setSelected(true);
//                holder.telecallerLeedsAdapterLayoutBinding.cardView.setBackgroundColor(Color.parseColor("#1E88E5"));
//                holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.setTextColor(Color.parseColor("#FFFFFF"));
//                holder.telecallerLeedsAdapterLayoutBinding.txtcnamevalue.setTextColor(Color.parseColor("#FFFFFF"));
//                holder.telecallerLeedsAdapterLayoutBinding.txtLoanTypeValue.setTextColor(Color.parseColor("#FFFFFF"));
//                holder.telecallerLeedsAdapterLayoutBinding.txtLo.setTextColor(Color.parseColor("#FFFFFF"));
//                Bundle bundle = new Bundle();
//                bundle.putSerializable(Constant.LEED_MODEL, leedModel2);// Put anything what you want
//                View_Sales_Received_Lead_Details_Fragment fragment2 = new View_Sales_Received_Lead_Details_Fragment();
//                fragment2.setArguments(bundle);
//                FragmentTransaction ft = ((FragmentActivity)context).getSupportFragmentManager().beginTransaction();
//                ft.replace(R.id.container,  fragment2);
//                ft.commit();
//
//            } else {
//                holder.itemView.setSelected(false);
//                holder.telecallerLeedsAdapterLayoutBinding.cardView.setBackgroundColor(Color.parseColor("#FFFFFF"));
//                holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.setTextColor(Color.parseColor("#000000"));
//                holder.telecallerLeedsAdapterLayoutBinding.txtcnamevalue.setTextColor(Color.parseColor("#000000"));
//                holder.telecallerLeedsAdapterLayoutBinding.txtLoanTypeValue.setTextColor(Color.parseColor("#000000"));
//                holder.telecallerLeedsAdapterLayoutBinding.txtLo.setTextColor(Color.parseColor("#000000"));
//
//            }
//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    int currentPosition = holder.getLayoutPosition();
//                    if(selectedPosition != currentPosition){
//                        // Temporarily save the last selected position
//                        int lastSelectedPosition = selectedPosition;
//                        // Save the new selected position
//                        selectedPosition = currentPosition;
//                        // update the previous selected row
//                        notifyItemChanged(lastSelectedPosition);
//                        // select the clicked row
//                        holder.itemView.setSelected(true);
//                    }
//                }
//            });
//                m++;
//            }


            LeedsModel leedModel = getModel(listPosition);
            if (!Utility.isEmptyOrNull(leedModel.getCustomerName()))
                holder.telecallerLeedsAdapterLayoutBinding.txtNameValue.setText(leedModel.getCustomerName());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtNameValue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getMobileNumber()))
                holder.telecallerLeedsAdapterLayoutBinding.txtContactValue.setText(leedModel.getMobileNumber());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtContactValue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getAddress()))
                holder.telecallerLeedsAdapterLayoutBinding.txtAddressValue.setText(leedModel.getAddress());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtAddressValue.setText(getString(R.string.na));

            if (!Utility.isEmptyOrNull(leedModel.getBanknName()))
                holder.telecallerLeedsAdapterLayoutBinding.txtBankValue.setText(leedModel.getBanknName());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtBankValue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getAgentName()))
                holder.telecallerLeedsAdapterLayoutBinding.txtAgentValue.setText(leedModel.getAgentName());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtAgentValue.setText(getString(R.string.na));
            if (leedModel.getUpdatedDateTimeLong() > 0)
                holder.telecallerLeedsAdapterLayoutBinding.txtAssignDateTimeValue.setText(Utility.convertMilliSecondsToFormatedDate(leedModel.getUpdatedDateTimeLong(), GLOBAL_DATE_FORMATE));
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtAssignDateTimeValue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel.getAppointment()))
                holder.telecallerLeedsAdapterLayoutBinding.txtAppointmentDateValue.setText(leedModel.getAppointment());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtAppointmentDateValue.setText(getString(R.string.na));

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

    public void MakeCall(LeedsModel item) {
//        leedModelArrayList.add(position, item);
//        notifyItemInserted(position);
        String number = item.getMobileNumber();
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CALL_PHONE},REQUEST_PHONE_CALL);
            context.startActivity(intent);
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }else {
            context.startActivity(intent);
        }
    }

    public ArrayList<LeedsModel> getData() {
        return leedModelArrayList;
    }
}