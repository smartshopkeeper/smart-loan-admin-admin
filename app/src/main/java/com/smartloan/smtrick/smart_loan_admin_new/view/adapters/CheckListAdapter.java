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
import android.widget.Toast;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.ChecklistAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.SalespersonAdapterLayoutBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.CheckList;
import com.smartloan.smtrick.smart_loan_admin_new.models.User;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.CheckListViewHolder;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.SalesPersonViewHolder;

import java.util.ArrayList;

public class CheckListAdapter extends RecyclerView.Adapter<CheckListViewHolder> {

    private ArrayList<String> leedModelArrayList;
    private ArrayList<String> checkedArrayList;
    private Context context;

    public CheckListAdapter(Context context, ArrayList<String> data) {
        this.leedModelArrayList = data;
        this.context = context;

    }

    @Override
    public CheckListViewHolder onCreateViewHolder(ViewGroup parent,
                                                  int viewType) {
        ChecklistAdapterLayoutBinding telecallerLeedsAdapterLayoutBinding;
        telecallerLeedsAdapterLayoutBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.checklist_adapter_layout, parent, false);
        return new CheckListViewHolder(telecallerLeedsAdapterLayoutBinding);
    }


    private String getModel(int position) {
        return leedModelArrayList.get(getItemCount() - 1 - position);
    }

    @Override
    public void onBindViewHolder(final CheckListViewHolder holder, final int listPosition) {
        try {
            final String leedModel = getModel(listPosition);
            if (!Utility.isEmptyOrNull(leedModel))
                holder.checklistAdapterLayoutBinding.checklistitem.setText(leedModel);
            else
                holder.checklistAdapterLayoutBinding.checklistitem.setText(getString(R.string.na));

            holder.checklistAdapterLayoutBinding.cardViewChecklist.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {

                    AlertDialog.Builder builder1 = new AlertDialog.Builder(context);
                    builder1.setMessage("Do you want to delete the list item");
                    builder1.setCancelable(true);

                    builder1.setPositiveButton(
                            "Yes",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    int i = leedModelArrayList.indexOf(leedModel);
                                    leedModelArrayList.remove(i);
                                    notifyDataSetChanged();
                                    dialog.cancel();
                                }
                            });

                    builder1.setNegativeButton(
                            "No",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });

                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                    return false;
                }
            });
//            holder.checklistAdapterLayoutBinding.checklistitem.setOnCheckedChangeListener(
//                    new CompoundButton.OnCheckedChangeListener() {
//                        @Override
//                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                            if (isChecked){
//                                checkedArrayList.add(leedModel.getRule());
//                                Toast.makeText(holder.checklistAdapterLayoutBinding.checklistitem.getContext(),
//                                        String.valueOf(checkedArrayList.size()), Toast.LENGTH_SHORT).show();
//                            }else if (!isChecked){
//                                int i = checkedArrayList.indexOf(leedModel.getRule());
//                                checkedArrayList.remove(i);
//                                Toast.makeText(holder.checklistAdapterLayoutBinding.checklistitem.getContext(),
//                                        String.valueOf(checkedArrayList.size()), Toast.LENGTH_SHORT).show();
//                            }
//                        }
//                    }
//            );

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