package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class Sales_Reschedule_Appointment_Activity extends AppCompatActivity {

    TextView txtCustomerName,txtAppointmentTime,txtRescheduledAppointment,txtToolbarname;
    Button btnReschedule,btnUpdate;
    LeedsModel leedsModel;
    LinearLayout layoutReschedule;
    ProgressDialogClass progressDialogClass;
    LeedRepository leedRepository;
    private DatePickerDialog mDatePickerDialog;
    int mHour;
    int mMinute;
    String fdate;


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales__reschedule__appointment_);

        leedsModel = (LeedsModel) getIntent().getSerializableExtra(Constant.LEED_MODEL);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar1));
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        progressDialogClass = new ProgressDialogClass(this);
        leedRepository = new LeedRepositoryImpl();

        txtCustomerName = (TextView) findViewById(R.id.customer_Name);
        txtAppointmentTime = (TextView) findViewById(R.id.appointment_time);
        txtRescheduledAppointment = (TextView) findViewById(R.id.rescheduled_appointment_time);
        txtToolbarname = (TextView) findViewById(R.id.toolbar_Name);
        btnReschedule = (Button) findViewById(R.id.btnReschedule);
        btnUpdate = (Button) findViewById(R.id.btnUpdate);
        layoutReschedule = (LinearLayout) findViewById(R.id.layout_Reschedule);

        if (leedsModel.getRescheduledappointment() != null){
            txtRescheduledAppointment.setText(leedsModel.getRescheduledappointment());
            layoutReschedule.setVisibility(View.VISIBLE);
        }else {
            layoutReschedule.setVisibility(View.GONE);
        }

        txtCustomerName.setText(leedsModel.getCustomerName());
        txtAppointmentTime.setText(leedsModel.getAppointment());
        txtToolbarname.setText("Reschedule Appointment");

        setDateTimeField();
        btnReschedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatePickerDialog.show();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateLeadDetails(leedsModel);
            }
        });
    }


    private void setDateTimeField() {

        Calendar newCalendar = Calendar.getInstance();
        mDatePickerDialog = new DatePickerDialog(Sales_Reschedule_Appointment_Activity.this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
                final Date startDate = newDate.getTime();
                fdate = sd.format(startDate);

                timePicker();
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

    }

    private void timePicker() {
        // Get Current Time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(Sales_Reschedule_Appointment_Activity.this,
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        mHour = hourOfDay;
                        mMinute = minute;

                        layoutReschedule.setVisibility(View.VISIBLE);
                        txtRescheduledAppointment.setText(fdate + " " + hourOfDay + ":" + minute);
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
    }

    private void updateLeadDetails(LeedsModel leedsModel) {

            leedsModel.setRescheduledappointment(txtRescheduledAppointment.getText().toString());

        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap());
    }

    private void updateLeed(String leedId, Map leedsMap) {
        progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));
        leedRepository.updateLeed(leedId, leedsMap, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                progressDialogClass.dismissDialog();
            }

            @Override
            public void onError(Object object) {
                progressDialogClass.dismissDialog();

                Utility.showLongMessage(Sales_Reschedule_Appointment_Activity.this, getString(R.string.server_error));

            }
        });
    }

}
