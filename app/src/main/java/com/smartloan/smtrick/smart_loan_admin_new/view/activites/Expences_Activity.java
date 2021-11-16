package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.models.Expences;
import com.smartloan.smtrick.smart_loan_admin_new.models.User;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.UserRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.UserRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.util.ArrayList;
import java.util.List;

public class Expences_Activity extends AppCompatActivity implements View.OnClickListener {

    public EditText edtemployeesalary, edttravellingallowence, edtrent, edtlightbill, edtother;
    public Spinner Employees;
    public Button btnsalary, btnallowance, btnrent, btnbill, btnother;
    public TextView AgentName;
    private UserRepository userRepository;
    ArrayList<User> UserArraylist;
    List<String> UserArraylist1;

    private DatabaseReference mDatabase;
    LeedRepository leedRepository;

    private ProgressDialogClass progressDialog;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expences_);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_expence);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));

        mDatabase = FirebaseDatabase.getInstance().getReference(Constant.DATABASE_PATH_UPLOADS);
        leedRepository = new LeedRepositoryImpl();
        userRepository = new UserRepositoryImpl();
        UserArraylist = new ArrayList<>();
        UserArraylist1 = new ArrayList<>();

        edtemployeesalary = (EditText) findViewById(R.id.employee_salary_amount);
        edttravellingallowence = (EditText) findViewById(R.id.travelling_amount);
        edtrent = (EditText) findViewById(R.id.rent_amount);
        edtlightbill = (EditText) findViewById(R.id.light_bill_amount);
        edtother = (EditText) findViewById(R.id.other_amount);

        Employees = (Spinner) findViewById(R.id.employee_spinner);

        btnsalary = (Button) findViewById(R.id.btn_payment);
        btnallowance = (Button) findViewById(R.id.btn_travel_payment);
        btnrent = (Button) findViewById(R.id.btn_rent_payment);
        btnbill = (Button) findViewById(R.id.btn_light_payment);
        btnother = (Button) findViewById(R.id.btn_other_payment);

        AgentName = (TextView) findViewById(R.id.agentName);

        getUsers();
        Employees.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                getUser();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnsalary.setOnClickListener(this);
        btnallowance.setOnClickListener(this);
        btnrent.setOnClickListener(this);
        btnbill.setOnClickListener(this);
        btnother.setOnClickListener(this);
    }

    private void getUsers() {

        progressDialog = new ProgressDialogClass(this);
        progressDialog.showDialog(this.getString(R.string.loading), this.getString(R.string.PLEASE_WAIT));

        userRepository.readAllusers(new CallBack() {
            @Override
            public void onSuccess(Object object) {

                if (object != null) {
                    UserArraylist = (ArrayList<User>) object;

                    for (int i = 0; i < UserArraylist.size(); i++) {
                        if (!UserArraylist.get(i).getRole().equalsIgnoreCase("AGENT")) {
                            UserArraylist1.add(UserArraylist.get(i).getAgentId());
                        }
                    }
                }

                ArrayAdapter<String> spinnerArrayAdapterRecidential = new ArrayAdapter(getApplicationContext(), R.layout.sppinner_layout_listitem, UserArraylist1);
                spinnerArrayAdapterRecidential.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                Employees.setAdapter(spinnerArrayAdapterRecidential);

                getUser();


            }

            @Override
            public void onError(Object object) {
                progressDialog.dismissDialog();
            }
        });
    }

    private void getUser() {
        String userid = Employees.getSelectedItem().toString();
        userRepository.readUserByAgentId(userid, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    User user = (User) object;

                    AgentName.setText(user.getUserName());
                    progressDialog.dismissDialog();
                }

            }

            @Override
            public void onError(Object object) {

            }
        });
    }

    @Override
    public void onClick(View view) {



            String key = mDatabase.push().getKey();
            String agentname = AgentName.getText().toString();
            String agentid = Employees.getSelectedItem().toString();
            String Employeesalary = edtemployeesalary.getText().toString();

        if (view == btnsalary){
            if (Employeesalary.isEmpty()) {
                edtemployeesalary.setError("Salary is required");
                edtemployeesalary.requestFocus();
                return;
            }
            Expences salary = new Expences();
            salary.setAgentid(agentid);
            salary.setAgentname(agentname);
            salary.setBillAmount(Employeesalary);
            salary.setBillname("SALARY");
            salary.setStatus(Constant.STATUS_GENERATED_BILL);
            salary.setGeneratedid(key);
            leedRepository.createSalary(salary, new CallBack() {
                @Override
                public void onSuccess(Object object) {
                    Toast.makeText(Expences_Activity.this, "Bill Sent for aprovel", Toast.LENGTH_SHORT).show();
                    edtemployeesalary.setText("");
                }

                @Override
                public void onError(Object object) {

                }
            });

        }
        if (view == btnallowance){

            String key1 = mDatabase.push().getKey();
            String allowance = edttravellingallowence.getText().toString();
            if (allowance.isEmpty()) {
                edttravellingallowence.setError("Allawance is required");
                edttravellingallowence.requestFocus();
                return;
            }
//            String agentid = Employees.getSelectedItem().toString();
            Expences salary = new Expences();
            salary.setBillAmount(allowance);
            salary.setStatus(Constant.STATUS_GENERATED_BILL);
            salary.setBillname("TRAVELLING ALLOWANCE");
            salary.setGeneratedid(key1);
            leedRepository.createTravellingAllowance(salary, new CallBack() {
                @Override
                public void onSuccess(Object object) {
                    Toast.makeText(Expences_Activity.this, "Travelling Allowence Sent for aprovel", Toast.LENGTH_SHORT).show();
                    edttravellingallowence.setText("");
                }

                @Override
                public void onError(Object object) {

                }
            });
        }
        if (view == btnbill){

            String key2 = mDatabase.push().getKey();
            String bill = edtlightbill.getText().toString();
            if (bill.isEmpty()) {
                edtlightbill.setError("Light Bill is required");
                edtlightbill.requestFocus();
                return;
            }
//            String agentid = Employees.getSelectedItem().toString();
            Expences salary = new Expences();
            salary.setBillAmount(bill);
            salary.setStatus(Constant.STATUS_GENERATED_BILL);
            salary.setBillname("LIGHT BILL");
            salary.setGeneratedid(key2);
            leedRepository.createlightBill(salary, new CallBack() {
                @Override
                public void onSuccess(Object object) {
                    Toast.makeText(Expences_Activity.this, "Bill Sent for aprovel", Toast.LENGTH_SHORT).show();
                    edtlightbill.setText("");
                }

                @Override
                public void onError(Object object) {

                }
            });

        }
        if (view == btnrent){

            String key3 = mDatabase.push().getKey();
            String rent = edtrent.getText().toString();
            if (rent.isEmpty()) {
                edtrent.setError("Rent is required");
                edtrent.requestFocus();
                return;
            }
//            String agentid = Employees.getSelectedItem().toString();
            Expences salary = new Expences();
            salary.setBillAmount(rent);
            salary.setStatus(Constant.STATUS_GENERATED_BILL);
            salary.setBillname("RENT");
            salary.setGeneratedid(key3);
            leedRepository.createRent(salary, new CallBack() {
                @Override
                public void onSuccess(Object object) {
                    Toast.makeText(Expences_Activity.this, "Rent Bill Sent for approvel", Toast.LENGTH_SHORT).show();
                    edtrent.setText("");
                }

                @Override
                public void onError(Object object) {

                }
            });

        }
        if (view == btnother){

            String key4 = mDatabase.push().getKey();
            String otherexpence = edtother.getText().toString();
            if (otherexpence.isEmpty()) {
                edtother.setError("Other Expences required");
                edtother.requestFocus();
                return;
            }
//            String agentid = Employees.getSelectedItem().toString();
            Expences salary = new Expences();
            salary.setBillAmount(otherexpence);
            salary.setStatus(Constant.STATUS_GENERATED_BILL);
            salary.setBillname("OTHER EXPENCE");
            salary.setGeneratedid(key4);
            leedRepository.createOtherExpence(salary, new CallBack() {
                @Override
                public void onSuccess(Object object) {
                    Toast.makeText(Expences_Activity.this, "Other Bill Sent for approvel", Toast.LENGTH_SHORT).show();
                    edtother.setText("");
                }

                @Override
                public void onError(Object object) {

                }
            });

        }
    }
}
