package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import androidx.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.SalesBanksubmittedLeedsAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.SalesReceivedLeedsAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.MainActivity_telecaller;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.TL_Updatelead_property_Details_Activity;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.SalesBankSubmittedLeedsViewHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.GLOBAL_DATE_FORMATE;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.STATUS_VERIFIED;

public class SalesLeedsBankSubmittedAdapter extends RecyclerView.Adapter<SalesBankSubmittedLeedsViewHolder> {

    private ArrayList<LeedsModel> leedModelArrayList;
    private Context context;
    int index = -1;
    private int selectedPosition = 0;
    static int m = 0;
    private static final int REQUEST_PHONE_CALL = 1;
    LeedRepository leedRepository;
    ArrayList<String> checklist;
    CheckListAdapter checkListAdapter;


    public SalesLeedsBankSubmittedAdapter(Context context, ArrayList<LeedsModel> data) {
        this.leedModelArrayList = data;
        this.context = context;
    }

    @Override
    public SalesBankSubmittedLeedsViewHolder onCreateViewHolder(ViewGroup parent,
                                                                int viewType) {
        SalesBanksubmittedLeedsAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding;
        telecallerLeedsAdapterLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.sales_banksubmitted_leeds_adapter_layout, parent, false);
        return new SalesBankSubmittedLeedsViewHolder(telecallerLeedsAdapterLayoutBinding);
    }

    private LeedsModel getModel(int position) {
        return leedModelArrayList.get(getItemCount() - 1 - position);
    }

    @Override
    public void onBindViewHolder(final SalesBankSubmittedLeedsViewHolder holder, final int listPosition) {
        try {

            LeedsModel leedModel2 = getModel(listPosition);
            checklist = new ArrayList<>();

            holder.telecallerLeedsAdapterLayoutBinding.cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    index = listPosition;
                    notifyDataSetChanged();
                }
            });

            final LeedsModel leedModel = getModel(listPosition);
            if (!Utility.isEmptyOrNull(leedModel.getCustomerName()))
                holder.telecallerLeedsAdapterLayoutBinding.txtNameValue.setText(leedModel.getCustomerName());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtNameValue.setText(getString(R.string.na));

            if (!Utility.isEmptyOrNull(leedModel.getBanknName()))
                holder.telecallerLeedsAdapterLayoutBinding.txtContact.setText(leedModel.getBanknName());
            else
                holder.telecallerLeedsAdapterLayoutBinding.txtContact.setText(getString(R.string.na));


            holder.telecallerLeedsAdapterLayoutBinding.dots.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    PopupWindow popUp = displayPopupWindow(v, leedModel);
                    popUp.showAsDropDown(v, 0, 250);
                }
            });
            holder.telecallerLeedsAdapterLayoutBinding.pin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });


//            if (leedModel.getUpdatedDateTimeLong() > 0)
//                holder.telecallerLeedsAdapterLayoutBinding.txtAssignDateTimeValue.setText(Utility.convertMilliSecondsToFormatedDate(leedModel.getUpdatedDateTimeLong(), GLOBAL_DATE_FORMATE));
//            else
//                holder.telecallerLeedsAdapterLayoutBinding.txtAssignDateTimeValue.setText(getString(R.string.na));


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

        String number = item.getMobileNumber();
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_PHONE_CALL);
            context.startActivity(intent);

            return;
        } else {
            context.startActivity(intent);
        }
    }

    public ArrayList<LeedsModel> getData() {
        return leedModelArrayList;
    }

    private PopupWindow displayPopupWindow(View anchorView, final LeedsModel leedsModel) {
        PopupWindow popup = new PopupWindow(context);
        View layout = ((Activity) context).getLayoutInflater().inflate(R.layout.customdialogboxdots, null);
        popup.setContentView(layout);
        // Set content width and height
        popup.setHeight(WindowManager.LayoutParams.WRAP_CONTENT);
        popup.setWidth(WindowManager.LayoutParams.MATCH_PARENT);
        // Closes the popup window when touch outside of it - when looses focus
        popup.setOutsideTouchable(true);
        popup.setFocusable(true);
        popup.setBackgroundDrawable(new BitmapDrawable());
        // Show anchored to button
//        popup.showAtLocation(anchorView, Gravity.TOP, 0, -500);
        ImageView AddLoginId = (ImageView) layout.findViewById(R.id.add_loginid);
        ImageView ViewChecklist = (ImageView) layout.findViewById(R.id.view_checklist);
        ImageView RemoveLeed = (ImageView) layout.findViewById(R.id.delete_leed);

        AddLoginId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog1 = new Dialog(context);
                dialog1.setContentView(R.layout.customdialogboxloginid);

                final EditText AddLoginId = (EditText) dialog1.findViewById(R.id.edtloginid);
                Button btnLoginId = (Button) dialog1.findViewById(R.id.btn_addlogin);
                btnLoginId.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String loginId = AddLoginId.getText().toString();
                        setLeedStatus(leedsModel,loginId);
                        dialog1.dismiss();
                    }
                });

                dialog1.show();

            }
        });
        ViewChecklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog1 = new Dialog(context);
                dialog1.setContentView(R.layout.customdialogbox);

                checklist = leedsModel.getChecklistCollected();
                RecyclerView recycleChecklist = (RecyclerView) dialog1.findViewById(R.id.dialog_recycle);
                recycleChecklist.setHasFixedSize(true);
                recycleChecklist.setLayoutManager(new LinearLayoutManager(context));
                if (checklist != null) {
                    checkListAdapter = new CheckListAdapter(context, checklist);
                    recycleChecklist.setAdapter(checkListAdapter);
                }

                dialog1.show();
            }
        });
        RemoveLeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });


        popup.showAsDropDown(anchorView);
        return popup;
    }

    private void setLeedStatus(LeedsModel leedsModel,String loginid) {
        leedsModel.setLoginid(loginid);

        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap());


    }

    private void updateLeed(String leedId, Map leedsMap) {
        leedRepository = new LeedRepositoryImpl();
        leedRepository.updateLeed(leedId, leedsMap, new CallBack() {
            @Override
            public void onSuccess(Object object) {

                Toast.makeText(context, "Lead Updated Successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Object object) {

                Utility.showLongMessage(context, getString(R.string.server_error));
            }
        });
    }
}