package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.app.Fragment;
import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.ActionBar;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Sales_Fragment_Checklist;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.View_Sales_Received_Lead_Details_Fragment;

public class Sales_Tasks_Activity extends AppCompatActivity implements Sales_Fragment_Checklist.OnFragmentInteractionListener {

    LeedsModel leedsModel;
    private ActionBar toolbar;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales__tasks_);


        setSupportActionBar((Toolbar) findViewById(R.id.toolbar1));
        assert getSupportActionBar() != null;   //null check
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar = getSupportActionBar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

//        toolbar.setTitle("Shop");

        leedsModel = (LeedsModel) getIntent().getSerializableExtra(Constant.LEED_MODEL);
        Intent intent = getIntent();
        String task = intent.getStringExtra("Task");


        if (task.equalsIgnoreCase("Label")) {

//            Bundle bundle = new Bundle();
//            bundle.putSerializable(Constant.LEED_MODEL, leedsModel);// Put anything what you want
//            View_Sales_Received_Lead_Details_Fragment fragment2 = new View_Sales_Received_Lead_Details_Fragment();
//            fragment2.setArguments(bundle);
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.frame_container, fragment2);
//            ft.commit();

        } else if (task.equalsIgnoreCase("FallowUp")) {

        } else if (task.equalsIgnoreCase("Notes")) {

        } else if (task.equalsIgnoreCase("Appointment")) {

        } else if (task.equalsIgnoreCase("Docs")) {
//            Bundle bundle = new Bundle();
//            bundle.putSerializable(Constant.LEED_MODEL, leedsModel);// Put anything what you want
//            Sales_Fragment_Checklist fragment2 = new Sales_Fragment_Checklist();
//            fragment2.setArguments(bundle);
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.frame_container, fragment2);
//            ft.commit();
        }

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_leeds:
                    toolbar.setTitle("Leeds");
                    return true;
                case R.id.navigation_customer:
                    toolbar.setTitle("Customers");
                    return true;
                case R.id.navigation_label:
                    toolbar.setTitle("Labels");
                    return true;
                case R.id.navigation_tasks:
                    toolbar.setTitle("Tasks");
                    return true;
                case R.id.navigation_business:
                    toolbar.setTitle("My Business");
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(Constant.LEED_MODEL, leedsModel);// Put anything what you want
                    Sales_Fragment_Checklist fragment2 = new Sales_Fragment_Checklist();
                    fragment2.setArguments(bundle);
                    FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                    ft.replace(R.id.frame_container, fragment2);
                    ft.commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    public void onFragmentInteraction(String title) {

    }
}
