package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.content.Context;
import android.content.DialogInterface;
import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.smartloan.smtrick.smart_loan_admin_new.Listners.OnCheckedClickListener;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.ChecklistAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.SalesChecklistAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.CheckListViewHolder;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.SalesCheckListViewHolder;

import java.util.ArrayList;

public class Sales_CheckListAdapter extends RecyclerView.Adapter<SalesCheckListViewHolder> {

    private ArrayList<String> leedModelArrayList;
    private ArrayList<String> checkedArrayList;
    private Context context;
    private OnCheckedClickListener onImageClickListener;

    public Sales_CheckListAdapter(Context context, ArrayList<String> data, OnCheckedClickListener onImageClickListener) {
        this.leedModelArrayList = data;
        this.context = context;
        this.onImageClickListener = onImageClickListener;

    }

    @Override
    public SalesCheckListViewHolder onCreateViewHolder(ViewGroup parent,
                                                  int viewType) {
        SalesChecklistAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding;
        telecallerLeedsAdapterLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.sales_checklist_adapter_layout, parent, false);
        return new SalesCheckListViewHolder(telecallerLeedsAdapterLayoutBinding);
    }


    private String getModel(int position) {
        return leedModelArrayList.get(getItemCount() - 1 - position);
    }

    @Override
    public void onBindViewHolder(final SalesCheckListViewHolder holder, final int listPosition) {
        try {
            final String leedModel = getModel(listPosition);
            if (!Utility.isEmptyOrNull(leedModel))
                holder.saleschecklistAdapterLayoutBinding.checklistitem.setText(leedModel);
            else
                holder.saleschecklistAdapterLayoutBinding.checklistitem.setText(getString(R.string.na));

//            holder.checklistAdapterLayoutBinding.cardViewChecklist.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View v) {
//
//                    AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
//                    builder1.setMessage("Do you want to delete the list item");
//                    builder1.setCancelable(true);
//
//                    builder1.setPositiveButton(
//                            "Yes",
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    int i = leedModelArrayList.indexOf(leedModel);
//                                    leedModelArrayList.remove(i);
//                                    notifyDataSetChanged();
//                                    dialog.cancel();
//                                }
//                            });
//
//                    builder1.setNegativeButton(
//                            "No",
//                            new DialogInterface.OnClickListener() {
//                                public void onClick(DialogInterface dialog, int id) {
//                                    dialog.cancel();
//                                }
//                            });
//
//                    AlertDialog alert11 = builder1.create();
//                    alert11.show();
//                    return false;
//                }
//            });
            holder.saleschecklistAdapterLayoutBinding.checklistitem.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        String item = holder.saleschecklistAdapterLayoutBinding.checklistitem.getText().toString();
                        onImageClickListener.onImageClick(item, true);

                    } else if (!isChecked) {
                        String item1 = holder.saleschecklistAdapterLayoutBinding.checklistitem.getText().toString();
                        onImageClickListener.onImageClick(item1, false);
//                    Toast.makeText(holder.count.getContext(), String.valueOf(servicesList.size()), Toast.LENGTH_SHORT).show();
                    }
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

    public void reload(ArrayList<String> leedsModelArrayList) {
        leedModelArrayList.clear();
        leedModelArrayList.addAll(leedsModelArrayList);
        notifyDataSetChanged();
    }
}