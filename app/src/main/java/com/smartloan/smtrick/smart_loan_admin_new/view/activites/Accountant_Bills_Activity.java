package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.content.ContextCompat;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Accountant_Bills_Tab_Fragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Admin_Bills_Tab_Fragment;

public class Accountant_Bills_Activity extends AppCompatActivity
        implements
        OnFragmentInteractionListener,
        NavigationView.OnNavigationItemSelectedListener{

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__bills);

//        setSupportActionBar((Toolbar) findViewById(R.id.toolbar1));
//        assert getSupportActionBar() != null;   //null check
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Bills");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

//        Intent intent = getIntent();
//        String value = intent.getStringExtra("value");
//        if (value.equalsIgnoreCase("leeds")) {
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.mainFrame, new LeedsTabsFragment());
//            ft.commit();
//
//        } else if (value.equalsIgnoreCase("banks")) {
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.mainFrame, new AddBankFragement());
//            ft.commit();
//
//        } else if (value.equalsIgnoreCase("calc")) {
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.mainFrame, new LoanCalculatorFragement());
//            ft.commit();
//
//        } else if (value.equalsIgnoreCase("user")) {
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.mainFrame, new UserTabsFragment());
//            ft.commit();
//
//        } else if (value.equalsIgnoreCase("report")) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame1, new Accountant_Bills_Tab_Fragment());
            ft.commit();

//        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onFragmentInteraction(String title) {

    }
}
