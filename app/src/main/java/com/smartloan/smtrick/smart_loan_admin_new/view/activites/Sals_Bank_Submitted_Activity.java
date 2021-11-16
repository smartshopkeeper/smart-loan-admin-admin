package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.app.Fragment;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
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
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Sales_Fragment_Labels;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Sales_fragment_lead_tab_recived;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Sales_fragment_lead_tab_submited;

public class Sals_Bank_Submitted_Activity extends AppCompatActivity implements Sales_Fragment_Labels.OnFragmentInteractionListener {

    LeedsModel leedsModel;
    private ActionBar toolbar1;
    private FragmentManager fragmentManager;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sals__bank__submitted);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        toolbar1 = getSupportActionBar();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

//        fragmentManager = getSupportFragmentManager();
//        fragmentManager.beginTransaction()
//                .add(R.id.frame_container, new Sales_fragment_lead_tab_submited())
//                .commit();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_container, new Sales_fragment_lead_tab_submited());
        ft.commit();
        getSupportActionBar().setTitle("Leeds");

//        leedsModel = (LeedsModel) getIntent().getSerializableExtra(Constant.LEED_MODEL);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment;
            switch (item.getItemId()) {
                case R.id.navigation_leeds:
                    toolbar1.setTitle("Leeds");
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.frame_container, new Sales_fragment_lead_tab_submited())
                            .commit();
                    getSupportActionBar().setTitle("Leeds");

                    return true;
                case R.id.navigation_customer:
                    toolbar1.setTitle("Customers");
                    getSupportActionBar().setTitle("Customers");
                    return true;
                case R.id.navigation_label:
                    toolbar1.setTitle("Labels");
                    fragmentManager = getSupportFragmentManager();
                    fragmentManager.beginTransaction()
                            .replace(R.id.frame_container, new Sales_Fragment_Labels())
                            .commit();
                    getSupportActionBar().setTitle("Labels");
                    return true;
                case R.id.navigation_tasks:
                    toolbar1.setTitle("Tasks");
                    getSupportActionBar().setTitle("Tasks");
                    return true;
                case R.id.navigation_business:
                    toolbar1.setTitle("My Business");
                    getSupportActionBar().setTitle("My Business");

                    return true;
            }
            return false;
        }
    };


    @Override
    public void onFragmentInteraction(String title) {

    }
}
