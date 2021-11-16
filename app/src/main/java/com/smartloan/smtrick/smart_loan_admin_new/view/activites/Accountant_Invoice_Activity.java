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
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Accountant_Invoice_fragment_lead_tab_Disbussed;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Accountant_Invoices_Tab_Fragment;

public class Accountant_Invoice_Activity extends AppCompatActivity
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
        setContentView(R.layout.activity__invoice);

//        setSupportActionBar((Toolbar) findViewById(R.id.toolbar1));
//        assert getSupportActionBar() != null;   //null check
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setTitle("Invoices");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Invoices");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));


            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame1, new Accountant_Invoices_Tab_Fragment());
            ft.commit();


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onFragmentInteraction(String title) {

    }
}
