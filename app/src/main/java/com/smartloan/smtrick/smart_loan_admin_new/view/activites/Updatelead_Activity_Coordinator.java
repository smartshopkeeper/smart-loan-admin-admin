package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.smartloan.smtrick.smart_loan_admin_new.R;

public class Updatelead_Activity_Coordinator extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{
    Spinner spinloantype,spinemptype,spinincome;
    Button btupdate,btverify,btcancel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatelead_activity_coordinator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        String[] loanType = new String[]{"HL","LAP"};
        String[] empType = new String[]{"Salaried","Businessman"};

        spinloantype = (Spinner) findViewById(R.id.sploantype1);
        spinemptype = (Spinner) findViewById(R.id.spoccupation1);

        btupdate = (Button) findViewById(R.id.buttonupdate);


        spinloantype.setOnItemSelectedListener(this);
        spinemptype.setOnItemSelectedListener(this);


        ArrayAdapter<String> spinnerArrayAdapterloantype = new ArrayAdapter<String>(this,R.layout.sppinner_layout_listitem,loanType);
        spinnerArrayAdapterloantype.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinloantype.setAdapter(spinnerArrayAdapterloantype);

        ArrayAdapter<String> spinnerArrayAdapteremptype = new ArrayAdapter<String>(this,R.layout.sppinner_layout_listitem,empType);
        spinnerArrayAdapteremptype.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinemptype.setAdapter(spinnerArrayAdapteremptype);


        btupdate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent i = new Intent(Updatelead_Activity_Coordinator.this, MainActivity_coordinator.class);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

            }
        });




    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}
