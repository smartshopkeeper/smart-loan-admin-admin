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

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;

import com.smartloan.smtrick.smart_loan_admin_new.databinding.TelecallerLeedsGeneratedAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.models.User;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.UserRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.UserRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Updatelead_Fragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.View_Lead_Details_Fragment1;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.TelecallerGeneratedLeedsViewHolder;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.GLOBAL_DATE_FORMATE;

public class TelecallerGeneratedLeedsAdapter extends RecyclerView.Adapter<TelecallerGeneratedLeedsViewHolder> {

    private ArrayList<LeedsModel> leedModelArrayList;
    private Context context;
    AppSharedPreference appSharedPreference;
    UserRepository userRepository;
    User user;
    int index = -1;
    private int selectedPosition = 0;
    static int m = 0;

    public TelecallerGeneratedLeedsAdapter() {
    }

    public TelecallerGeneratedLeedsAdapter(Context context, ArrayList<LeedsModel> data) {
        this.leedModelArrayList = data;
        this.context = context;
    }

    @Override
    public TelecallerGeneratedLeedsViewHolder onCreateViewHolder(ViewGroup parent,
                                                                 int viewType) {
        TelecallerLeedsGeneratedAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding;
        telecallerLeedsAdapterLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.telecaller_leeds_generated_adapter_layout, parent, false);
        return new TelecallerGeneratedLeedsViewHolder(telecallerLeedsAdapterLayoutBinding);
    }

    private LeedsModel getModel(int position) {
        return leedModelArrayList.get(getItemCount() - 1 - position);
    }

    @Override
    public void onBindViewHolder(final TelecallerGeneratedLeedsViewHolder holder, final int listPosition) {
        try {

            LeedsModel leedModel2 = getModel(listPosition);

            this.appSharedPreference = new AppSharedPreference(holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.getContext());
            this.userRepository = new UserRepositoryImpl();


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
                    Updatelead_Fragment fragment2 = new Updatelead_Fragment();
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

            userRepository.readUserByName(leedModel2.getAgentName(), new CallBack() {
                @Override
                public void onSuccess(Object object) {
                    user = (User) object;

                }

                @Override
                public void onError(Object object) {

                }
            });

            if (!Utility.isEmptyOrNull(leedModel2.getCustomerName()))
                holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.setText(leedModel2.getCustomerName());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtIdValue.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel2.getLoanType()))
                holder.telecallerLeedsAdapterLayoutBinding.txtcnamevalue.setText(leedModel2.getLoanType());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtcnamevalue.setText(getString(R.string.na));

            if (!Utility.isEmptyOrNull(leedModel2.getAgentName()))
                holder.telecallerLeedsAdapterLayoutBinding.txtLoanTypeValue.setText(leedModel2.getAgentName());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtLoanTypeValue.setText(getString(R.string.na));

            if (!Utility.isEmptyOrNull(leedModel2.getCallingStatus()))
                holder.telecallerLeedsAdapterLayoutBinding.txtCallingStatus.setText(leedModel2.getCallingStatus());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtCallingStatus.setText(getString(R.string.na));
            if (!Utility.isEmptyOrNull(leedModel2.getCallingStatusReason()))
                holder.telecallerLeedsAdapterLayoutBinding.txtCallStatusReason.setText(leedModel2.getCallingStatusReason());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtCallStatusReason.setText(getString(R.string.na));

            Date endDate = Calendar.getInstance().getTime();

            String date = Utility.convertMilliSecondsToFormatedDate(leedModel2.getCreatedDateTimeLong(), GLOBAL_DATE_FORMATE);
            Date startDate = stringToDate(date, "dd MMM yyyy");

            long difference = Math.abs(endDate.getTime() - startDate.getTime());
            long differenceDates = difference / (24 * 60 * 60 * 1000);
            int hours = (int) (difference / (1000 * 60 * 60));
            int minutes = (int) (difference / (1000 * 60));

            //Convert long to String
            String dayDifference = Long.toString(differenceDates);

            if (!Utility.isEmptyOrNull(String.valueOf(leedModel2.getCreatedDateTime())))
            holder.telecallerLeedsAdapterLayoutBinding.txtLeadDays.setText("Lead Days - "+dayDifference);
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtLeadDays.setText(getString(R.string.na));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Date stringToDate(String startDate, String s) {
        if (startDate == null) return null;
        ParsePosition pos = new ParsePosition(0);
        SimpleDateFormat simpledateformat = new SimpleDateFormat(s);
        Date stringDate = simpledateformat.parse(startDate, pos);
        return stringDate;
    }

    private void readagent(String agentName) {
        userRepository.readUserByName(agentName, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                user = (User) object;
            }

            @Override
            public void onError(Object object) {

            }
        });
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