package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.smartloan.smtrick.smart_loan_admin_new.R;

public class Coordinator_BanksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator__banks);

        BottomNavigationView bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.btmbanks);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                switch (menuItem.getItemId()){
                    case R.id.btmbanks:


                    case R.id.btmleads:
                        startActivity(new Intent(getApplicationContext(),MainActivity_Coorinator_new.class));
                        finish();
                        overridePendingTransition(0,0);
                        break;
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


    }
}