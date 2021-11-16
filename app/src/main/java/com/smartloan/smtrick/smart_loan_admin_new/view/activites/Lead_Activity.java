package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.smartloan.smtrick.smart_loan_admin_new.R;

public class Lead_Activity extends AppCompatActivity implements View.OnClickListener {

    private ImageView imgdot, imgAdd, imgHide, imgDelete, imgOptions;
    private RecyclerView recycleCustomers;
    private LinearLayout layoutIcons;
    static int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_);

        imgdot = findViewById(R.id.imgDot);
        imgAdd = findViewById(R.id.imgDot);
        imgHide = findViewById(R.id.imgDot);
        imgDelete = findViewById(R.id.imgDot);
        imgOptions = findViewById(R.id.imgDot);
        recycleCustomers = findViewById(R.id.recycler_view_users);

        layoutIcons = findViewById(R.id.layouticons);

        HideFields(layoutIcons);

        imgdot.setOnClickListener(this);
        imgAdd.setOnClickListener(this);
        imgHide.setOnClickListener(this);
        imgDelete.setOnClickListener(this);
        imgOptions.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == imgdot) {

        }
        if (v == imgOptions) {

        }
        if (v == imgAdd) {

        }
        if (v == imgHide) {

            if (i == 0) {
                HideFields(layoutIcons);
                i =1;
            } else {
                ShowFields(layoutIcons);
                i =0;
            }
        }
        if (v == imgDelete) {

        }
    }

    private void ShowFields(LinearLayout layout) {
        LinearLayout.LayoutParams params1 = (LinearLayout.LayoutParams) layout.getLayoutParams();
        params1.height = 1;
        layout.setLayoutParams(params1);
    }

    private void HideFields(LinearLayout layout) {
        LinearLayout.LayoutParams params1 = (LinearLayout.LayoutParams) layout.getLayoutParams();
        params1.height = 0;
        layout.setLayoutParams(params1);
    }
}