package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.core.content.ContextCompat;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Coordinator_Fragment_lead;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.DisplaySettingsFragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Fragment_Calculator;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Sales_Fragment_leads;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Sales_fragment_lead_tab_recived;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Telecaller_Fragment_leads;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Telecaller_fragment_Reports;

public class MainActivity_Sales_new extends AppCompatActivity implements
        Telecaller_Fragment_leads.OnFragmentInteractionListener,
        OnFragmentInteractionListener,
        //Fragment_GenerateLeads.OnFragmentInteractionListener,
        Sales_Fragment_leads.OnFragmentInteractionListener,
        Telecaller_fragment_Reports.OnFragmentInteractionListener,
        Fragment_Calculator.OnFragmentInteractionListener{

    private boolean isTwoPane;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__sales_new);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_sales);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        fragmentManager = getSupportFragmentManager();

        if (findViewById(R.id.detailContainer) != null) {
            isTwoPane = true;
        } else {
            isTwoPane = false;
        }

        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .add(R.id.container, new Sales_fragment_lead_tab_recived())
                    .commit();
        }

        if (isTwoPane) {
            fragmentManager.beginTransaction()
                    .replace(R.id.detailContainer, new DisplaySettingsFragment())
                    .commit();
        }


    }

    @Override
    public void onFragmentInteraction(String title) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.action_banksubmit:
                // search action
                Intent intent = new Intent(MainActivity_Sales_new.this,Sals_Bank_Submitted_Activity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
