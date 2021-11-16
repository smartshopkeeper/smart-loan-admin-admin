package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.app.Dialog;
import android.content.Context;

import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.LeadSummaryAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.Bank;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedModel;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.BanksViewHolder;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.LeedsSummaryViewHolder;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.GLOBAL_DATE_FORMATE;

public class Lead_Summary_Adapter extends RecyclerView.Adapter<LeedsSummaryViewHolder> {

    private ArrayList<LeedsModel> leedModelArrayList;
    private Context context;

    public Lead_Summary_Adapter(Context context, ArrayList<LeedsModel> data) {
        this.leedModelArrayList = data;
        this.context = context;
    }

    @Override
    public LeedsSummaryViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        LeadSummaryAdapterLayoutBinding leadSummaryAdapterLayoutBinding;
        leadSummaryAdapterLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.lead_summary_adapter_layout, parent, false);
        return new LeedsSummaryViewHolder(leadSummaryAdapterLayoutBinding);
    }

    private LeedsModel getModel(int position) {
        return leedModelArrayList.get(getItemCount() - 1 - position);
    }

    @Override
    public void onBindViewHolder(final LeedsSummaryViewHolder holder, final int listPosition) {
        try {
            LeedsModel leedModel = getModel(listPosition);

            if (leedModel.getCustomerName() != null) {
                holder.leadSummaryAdapterLayoutBinding.leadname.setText(leedModel.getCustomerName());
            } else {
                holder.leadSummaryAdapterLayoutBinding.leadname.setText("");
            }

            if (leedModel.getExpectedLoanAmount() != null) {
                holder.leadSummaryAdapterLayoutBinding.applied.setText(leedModel.getExpectedLoanAmount());
            } else {
                holder.leadSummaryAdapterLayoutBinding.applied.setText("");
            }

            if (leedModel.getLoanType() != null) {
                if (leedModel.getLoanType().equalsIgnoreCase(Constant.LOAN_TYPE_BALANCE_TRANSFER)) {

                    holder.leadSummaryAdapterLayoutBinding.loantype.setText("BT");

                } else if (leedModel.getLoanType().equalsIgnoreCase(Constant.LOAN_TYPE_LAP)) {

                    holder.leadSummaryAdapterLayoutBinding.loantype.setText("LAP");

                } else if (leedModel.getLoanType().equalsIgnoreCase(Constant.LOAN_TYPE_HL)) {

                    holder.leadSummaryAdapterLayoutBinding.loantype.setText("HL");

                }

            } else {
                holder.leadSummaryAdapterLayoutBinding.loantype.setText("");
            }

            if (leedModel.getBankName() != null) {
                holder.leadSummaryAdapterLayoutBinding.bank.setText(leedModel.getBankName());
            } else {
                holder.leadSummaryAdapterLayoutBinding.bank.setText("");
            }

            if (leedModel.getStatus() != null) {
                holder.leadSummaryAdapterLayoutBinding.status.setText(leedModel.getStatus());
                if (leedModel.getStatus().equalsIgnoreCase(Constant.STATUS_GENERATED)) {

                    holder.leadSummaryAdapterLayoutBinding.status.setTextColor(ContextCompat.getColor(context, R.color.blue));

                } else if (leedModel.getStatus().equalsIgnoreCase(Constant.STATUS_APPROVED)) {

                    holder.leadSummaryAdapterLayoutBinding.status.setTextColor(ContextCompat.getColor(context, R.color.cream));

                } else if (leedModel.getStatus().equalsIgnoreCase(Constant.STATUS_REJECTED)) {

                    holder.leadSummaryAdapterLayoutBinding.status.setTextColor(ContextCompat.getColor(context, R.color.red));

                } else if (leedModel.getStatus().equalsIgnoreCase(Constant.STATUS_IN_PROGRESS)) {

                    holder.leadSummaryAdapterLayoutBinding.status.setTextColor(ContextCompat.getColor(context, R.color.yello));

                }

            } else {
                holder.leadSummaryAdapterLayoutBinding.status.setText("");
            }
            if (leedModel.getApprovedLoan() != null) {
                holder.leadSummaryAdapterLayoutBinding.approved.setText(leedModel.getApprovedLoan());
            } else {
                holder.leadSummaryAdapterLayoutBinding.approved.setText("");
            }
            if (leedModel.getRejectionReason() != null) {
                holder.leadSummaryAdapterLayoutBinding.rejected.setText(leedModel.getRejectionReason());
            } else {
                holder.leadSummaryAdapterLayoutBinding.rejected.setText("");
            }
            if (leedModel.getSalesPerson() != null) {
                holder.leadSummaryAdapterLayoutBinding.salesperson.setText(leedModel.getSalesPerson());
            } else {
                holder.leadSummaryAdapterLayoutBinding.salesperson.setText("");
            }


            holder.leadSummaryAdapterLayoutBinding.leadname.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final Dialog dialog1 = new Dialog(holder.leadSummaryAdapterLayoutBinding.leadname.getContext());
                    dialog1.setContentView(R.layout.dialog_user_detail);

                    TextView txtUserName = (TextView) dialog1.findViewById(R.id.txtUserNameValue);
                    TextView txtLeedId = (TextView) dialog1.findViewById(R.id.txtLeedIdValue);
                    TextView txtAgent = (TextView) dialog1.findViewById(R.id.txt_agent_value);
                    TextView txtStatus = (TextView) dialog1.findViewById(R.id.txt_status_value);
                    TextView txtDate = (TextView) dialog1.findViewById(R.id.txt_generated_date_value);
                    TextView txtApplied = (TextView) dialog1.findViewById(R.id.txt_applied_value);
                    TextView txtApproved = (TextView) dialog1.findViewById(R.id.txt_approved_value);
                    TextView txtLoanType = (TextView) dialog1.findViewById(R.id.txt_loan_type_value);

                    txtUserName.setText(leedModel.getCustomerName());
                    txtLeedId.setText(leedModel.getLeedId());
                    txtAgent.setText(leedModel.getAgentName());
                    txtStatus.setText(leedModel.getStatus());
                    txtDate.setText(Utility.convertMilliSecondsToFormatedDate(leedModel.getCreatedDateTimeLong(), GLOBAL_DATE_FORMATE));
                    txtApplied.setText(leedModel.getExpectedLoanAmount());
                    txtApproved.setText(leedModel.getApprovedLoan());
                    txtLoanType.setText(leedModel.getLoanType());


                    dialog1.show();
                }
            });


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