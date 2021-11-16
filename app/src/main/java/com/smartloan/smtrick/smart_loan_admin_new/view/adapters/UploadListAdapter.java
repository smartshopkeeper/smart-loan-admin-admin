package com.smartloan.smtrick.smart_loan_admin_new.view.adapters;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.smartloan.smtrick.smart_loan_admin_new.R;

import java.util.List;

/**
 * Created by akshayejh on 19/12/17.
 */

public class UploadListAdapter extends RecyclerView.Adapter<UploadListAdapter.ViewHolder> {

    //  public List<String> fileNameList;
    public List<Uri> fileDoneList;
    Context mContext, nContext;
    private static final int REQUEST_CROP_IMAGE = 2342;

    public UploadListAdapter(Context fileNameList, List<Uri> fileDoneList) {

        this.mContext = fileNameList;
        this.fileDoneList = fileDoneList;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_single, parent, false);
        nContext = parent.getContext();
        return new ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        final Uri fileDone = fileDoneList.get(position);


        Glide.with(mContext)
                .load(fileDone)
                .apply(RequestOptions
                        .placeholderOf(R.drawable.loading))
                .into(holder.fileDoneView);


    }


    @Override
    public int getItemCount() {
        return fileDoneList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        View mView;


        public ImageView fileDoneView;
        public CardView imagecard;

        public ViewHolder(View itemView) {
            super(itemView);

            mView = itemView;

            fileDoneView = (ImageView) mView.findViewById(R.id.upload_icon);
            imagecard = (CardView) mView.findViewById(R.id.newcardimage);
        }

    }

}
