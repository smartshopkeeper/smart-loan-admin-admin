package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.core.content.ContextCompat;
import android.os.Bundle;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.DisplaySettingsFragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.NetworkSettingsFragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.SettingOptionsFragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Tc_fragment_lead_tab_generatedlead;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Telecaller_Fragment_leads;

public class MainActivity_Telecaller_new extends AppCompatActivity implements
        Telecaller_Fragment_leads.OnFragmentInteractionListener {

    private boolean isTwoPane;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__telecaller_new);

        fragmentManager = getSupportFragmentManager();

        if (findViewById(R.id.detailContainer) != null) {
            isTwoPane = true;
        } else {
            isTwoPane = false;
        }

        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .add(R.id.container, new Telecaller_Fragment_leads())
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


}
