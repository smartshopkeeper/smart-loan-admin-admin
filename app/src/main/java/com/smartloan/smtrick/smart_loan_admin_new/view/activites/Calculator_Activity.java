package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.content.Context;
import android.os.Build;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Fragment_Calculator;

public class Calculator_Activity extends AppCompatActivity {

    EditText loan_amt, Tenure, Interest_rate;
    SeekBar SK_loanamt, SK_tenure, SK_interestrate;
    int principle;
    int rate;
    int time;
    TextView EMIamt;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator_);

        Toolbar toolbar = (Toolbar) findViewById(R.id.calculatortoolbar);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        loan_amt = (EditText) findViewById(R.id.text_view_loanamt);
        Tenure = (EditText) findViewById(R.id.text_view_tenure);
        Interest_rate = (EditText) findViewById(R.id.text_view_interest);

        SK_loanamt = (SeekBar) findViewById(R.id.seekBar_loanamt);
        SK_tenure = (SeekBar) findViewById(R.id.seekBar_tenure);
        SK_interestrate = (SeekBar) findViewById(R.id.seekBar_interest);

        EMIamt = (TextView) findViewById(R.id.text_view_emi);

        SK_loanamt.setMax(1500000);
        SK_tenure.setMax(30);
        SK_interestrate.setMax(30);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            SK_interestrate.setMin(8);
            SK_tenure.setMin(3);
        }


        SK_loanamt.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                loan_amt.setText("" + progress );
                principle = Integer.parseInt(loan_amt.getText().toString());
                rate = Integer.parseInt(Interest_rate.getText().toString());
                time = Integer.parseInt(Tenure.getText().toString());

                float p =  Float.parseFloat(String.valueOf(principle));
                float i =  Float.parseFloat(String.valueOf(rate));
                float y = Float.parseFloat(String.valueOf(time));
                float Principal = calPric(p);
                float Rate = calInt(i);
                float Months = calMonth(y);
                float Dvdnt = calDvdnt(Rate, Months);
                float FD = calFinalDvdnt(Principal, Rate, Dvdnt);
                float D = calDivider(Dvdnt);
                float emi = calEmi(FD, D);
                float TA = calTa(emi, Months);
                float ti = calTotalInt(TA, Principal);
                String emi1 = String.valueOf(emi);
                EMIamt.setText("Your EMI Amount Is" + "\n" +emi1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        SK_tenure.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Tenure.setText("" + progress );
                principle = Integer.parseInt(loan_amt.getText().toString());
                rate = Integer.parseInt(Interest_rate.getText().toString());
                time = Integer.parseInt(Tenure.getText().toString());

                float p =  Float.parseFloat(String.valueOf(principle));
                float i =  Float.parseFloat(String.valueOf(rate));
                float y = Float.parseFloat(String.valueOf(time));
                float Principal = calPric(p);
                float Rate = calInt(i);
                float Months = calMonth(y);
                float Dvdnt = calDvdnt(Rate, Months);
                float FD = calFinalDvdnt(Principal, Rate, Dvdnt);
                float D = calDivider(Dvdnt);
                float emi = calEmi(FD, D);
                float TA = calTa(emi, Months);
                float ti = calTotalInt(TA, Principal);
                String emi1 = String.valueOf(emi);
                EMIamt.setText("Your EMI Amount Is" + "\n" +emi1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        SK_interestrate.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                Interest_rate.setText("" + progress );
                principle = Integer.parseInt(loan_amt.getText().toString());
                rate = Integer.parseInt(Interest_rate.getText().toString());
                time = Integer.parseInt(Tenure.getText().toString());

                float p =  Float.parseFloat(String.valueOf(principle));
                float i =  Float.parseFloat(String.valueOf(rate));
                float y = Float.parseFloat(String.valueOf(time));
                float Principal = calPric(p);
                float Rate = calInt(i);
                float Months = calMonth(y);
                float Dvdnt = calDvdnt(Rate, Months);
                float FD = calFinalDvdnt(Principal, Rate, Dvdnt);
                float D = calDivider(Dvdnt);
                float emi = calEmi(FD, D) * 12;
                float TA = calTa(emi, Months);
                float ti = calTotalInt(TA, Principal);
                String emi1 = String.valueOf(emi);
                EMIamt.setText("Your EMI Amount Is" + "\n" +emi1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public float calPric(float p) {
        return (float) (p);
    }

    public float calInt(float i) {
        return (float) (i / 12 / 100);
    }

    public float calMonth(float y) {
        return (float) (y * 12);
    }

    public float calDvdnt(float Rate, float Months) {
        return (float) (Math.pow(1 + Rate, Months));
    }

    public float calFinalDvdnt(float Principal, float Rate, float Dvdnt) {
        return (float) (Principal * Rate * Dvdnt);
    }

    public float calDivider(float Dvdnt) {
        return (float) (Dvdnt - 1);
    }

    public float calEmi(float FD, Float D) {
        return (float) (FD / D);
    }

    public float calTa(float emi, Float Months) {
        return (float) (emi * Months);
    }

    public float calTotalInt(float TA, float Principal) {
        return (float) (TA - Principal);
    }

}
