package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.core.content.ContextCompat;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Coordinator_Fragment_lead;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.DisplaySettingsFragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Telecaller_Fragment_leads;

public class MainActivity_Coorinator_new extends AppCompatActivity implements OnFragmentInteractionListener,
        Telecaller_Fragment_leads.OnFragmentInteractionListener {

    private boolean isTwoPane;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__coordinator_new);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.btmleads);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.btmbanks:
                        startActivity(new Intent(getApplicationContext(),Coordinator_BanksActivity.class));
                        finish();
                        overridePendingTransition(0,0);
                        break;
                    case R.id.btmleads:


                    case R.id.btmsalespersons:
                        startActivity(new Intent(getApplicationContext(),Coordinator_SalesPersons_Activity.class));
                        finish();
                        overridePendingTransition(0,0);
                        break;

                    case R.id.btmdailyleads:
                        startActivity(new Intent(getApplicationContext(),Coordinator_SalesPersons_Activity.class));
                        finish();
                        overridePendingTransition(0,0);
                        break;
                }

                return false;
            }
        });
        fragmentManager = getSupportFragmentManager();

            if (findViewById(R.id.detailContainer) != null) {
                isTwoPane = true;
            } else {
                isTwoPane = false;
            }

            if (savedInstanceState == null) {
                fragmentManager.beginTransaction()
                        .add(R.id.container, new Coordinator_Fragment_lead())
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


//    @Override
//    public void onOptionSelected(String option) {
//        if (isTwoPane) {
//            switch (option) {
//                case "network": {
//                    fragmentManager.beginTransaction()
//                            .replace(R.id.detailContainer, new NetworkSettingsFragment())
//                            .commit();
//                    break;
//                }
//                case "display": {
//                    fragmentManager.beginTransaction()
//                            .replace(R.id.detailContainer, new DisplaySettingsFragment())
//                            .commit();
//                    break;
//                }
//                case "storage": {
//                    fragmentManager.beginTransaction()
//                            .replace(R.id.detailContainer, new StorageSettingsFragment())
//                            .commit();
//                    break;
//                }
//            }
//        } else {
//            Intent intent = new Intent(this, SettingsDetailActivity.class);
//            intent.putExtra(SettingsDetailActivity.EXTRA_SETTING_OPTION, option);
//            startActivity(intent);
//        }
//    }
}
