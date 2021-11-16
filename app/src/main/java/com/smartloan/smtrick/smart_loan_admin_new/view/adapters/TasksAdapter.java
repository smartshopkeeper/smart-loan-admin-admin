package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.content.Context;
import android.graphics.Color;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin_new.Listners.OnCheckedClickListener;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.models.FollowUp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.ViewHolder> {

    private static List<FollowUp> searchArrayList;
    private Context context;
    private boolean isFromRequest;
    private OnCheckedClickListener onImageClickListener;

    public TasksAdapter(Context context, List<FollowUp> userArrayList) {
        this.context = context;
        this.searchArrayList = userArrayList;
        this.onImageClickListener = onImageClickListener;

    }

    @Override
    public TasksAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tasks_adapter_layout, parent, false);
        TasksAdapter.ViewHolder viewHolder = new ViewHolder(v);
        //  context = parent.getContext();
        return viewHolder;

    }

    @Override
    public void onBindViewHolder(final TasksAdapter.ViewHolder holder, int position) {
        final FollowUp item = searchArrayList.get(position);

        holder.Item.setText(item.getDescription());
        holder.DateTime.setText(item.getDate()+"  "+item.getTime());



        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        Date strDate = null;
        try {
            strDate = sdf.parse(item.getDate());
        } catch (ParseException e) {


        }
        if (new Date().after(strDate)) {
            holder.DateTime.setTextColor(Color.RED);

        }


//        holder.Item.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (isChecked) {
//                    String item = holder.Item.getText().toString();
//                    onImageClickListener.onImageClick(item, true);
//                    holder.Item.setEnabled(false);
//
//                } else if (!isChecked) {
//                    String item1 = holder.Item.getText().toString();
//                    onImageClickListener.onImageClick(item1, false);
//                    holder.Item.setEnabled(true);
//                }
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return searchArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        CardView card_view;
        CheckBox Item;
        TextView DateTime;

        public ViewHolder(View itemView) {
            super(itemView);

            Item = (CheckBox) itemView.findViewById(R.id.checklistitem);
            DateTime = (TextView) itemView.findViewById(R.id.tasks_date);
            card_view = (CardView) itemView.findViewById(R.id.card_view_checklist);

        }
    }

}