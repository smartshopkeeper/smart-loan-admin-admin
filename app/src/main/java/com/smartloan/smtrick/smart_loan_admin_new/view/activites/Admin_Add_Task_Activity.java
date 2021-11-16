package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.models.FollowUp;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.models.TodoList;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.LEED_MODEL;

public class Admin_Add_Task_Activity extends AppCompatActivity {

//    LeedsModel leedsModel;
    ImageView imgReminder, imgTeskDesc;
    TextView inputUserName, inputDate, inputTime;
    EditText edtDescription;
    LinearLayout layoutDescription, layoutDateTime;
    Button btnAddFollowUp;
    AppSharedPreference appSharedPreference;
    private DatePickerDialog mDatePickerDialog;
    String fdate;
    int mHour;
    int mMinute;
    LeedRepository leedRepository;
    private DatabaseReference mDatabase;


    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin__add__task_);

//        leedsModel = (LeedsModel) getIntent().getSerializableExtra(Constant.LEED_MODEL);
        leedRepository = new LeedRepositoryImpl();
        appSharedPreference = new AppSharedPreference(this);
        mDatabase = Constant.TODOLIST_TABLE_REF;

        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        imgReminder = (ImageView) findViewById(R.id.reminder);
        imgTeskDesc = (ImageView) findViewById(R.id.desc);
        inputUserName = (TextView) findViewById(R.id.user_name);
//        inputUserName.setText(leedsModel.getAgentName());
        edtDescription = (EditText) findViewById(R.id.edtDesc);
        layoutDescription = (LinearLayout) findViewById(R.id.layout_Desc);
        btnAddFollowUp = (Button) findViewById(R.id.btn_Add_FollowUp);
        inputDate = (TextView) findViewById(R.id.txt_date);
        inputTime = (TextView) findViewById(R.id.txt_time);
        layoutDateTime = (LinearLayout) findViewById(R.id.layout_date);

        layoutDescription.setVisibility(View.GONE);
        layoutDateTime.setVisibility(View.GONE);
        imgTeskDesc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                layoutDescription.setVisibility(View.VISIBLE);
            }
        });


        btnAddFollowUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String key = mDatabase.push().getKey();
                String Description = edtDescription.getText().toString();
                String AdminId = appSharedPreference.getAgeniId();
                String date = inputDate.getText().toString();
                String Time = inputTime.getText().toString();

                TodoList todoList = new TodoList();
                todoList.setTodolistId(key);
                todoList.setAdinId(AdminId);
                todoList.setDate(date);
                todoList.setTime(Time);
                todoList.setDescription(Description);
                AddFollowUp(todoList);

            }

        });
        setDateTimeField();
        imgReminder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatePickerDialog.show();
                layoutDateTime.setVisibility(View.VISIBLE);
            }
        });
    }


    private void AddFollowUp(TodoList todoList) {
        leedRepository.createTodolist(todoList, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                Toast.makeText(Admin_Add_Task_Activity.this, "Added", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Admin_Add_Task_Activity.this,Sales_FollowUP_Activity.class);
//                startActivity(intent);
            }

            @Override
            public void onError(Object object) {

            }
        });
    }

    private void setDateTimeField() {
        Calendar newCalendar = Calendar.getInstance();
        mDatePickerDialog = new DatePickerDialog(Admin_Add_Task_Activity.this, new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
                final Date startDate = newDate.getTime();
                fdate = sd.format(startDate);

                timePicker();
            }

            private void timePicker() {
                // Get Current Time
                final Calendar c = Calendar.getInstance();
                mHour = c.get(Calendar.HOUR_OF_DAY);
                mMinute = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(Admin_Add_Task_Activity.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                                mHour = hourOfDay;
                                mMinute = minute;

                                inputDate.setText(fdate);
                                inputTime.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour, mMinute, false);
                timePickerDialog.show();
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

    }
}
