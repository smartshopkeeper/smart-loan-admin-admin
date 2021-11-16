package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.exception.ExceptionUtil;
import com.smartloan.smtrick.smart_loan_admin_new.models.User;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.UserRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.UserRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.util.Map;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.FEMALE;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.MALE;

public class Update_User_Activity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener, View.OnTouchListener, View.OnClickListener {
    TextView txtlogin, txttc;
    Button btnUpdate, btnotp;
    EditText etname, etaddress, etmobile, editTextPassword, etusername, etpassword, emailid, etreenterpassword, etotp;
    Spinner spin;
    RadioButton Rdmale, RdFemale;
    private UserRepository userRepository;
    private ProgressDialogClass progressDialogClass;
    private AppSharedPreference appSharedPreference;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_update_user);
        userRepository = new UserRepositoryImpl(this);
        progressDialogClass = new ProgressDialogClass(this);
        appSharedPreference = new AppSharedPreference(this);
        String[] Userstype = new String[]{"Agent"};

        Intent userIntent = getIntent();
        user = (User) userIntent.getSerializableExtra("user");

        String[] Userstypeall = new String[]{
                "ADMIN",
                "ACCOUNTANT",
                "TELECALLER",
                "COORDINATOR",
                "SALES"};

        btnUpdate = (Button) findViewById(R.id.buttonsubmit);
        etname = (EditText) findViewById(R.id.edittextname);
        etaddress = (EditText) findViewById(R.id.edittextaddress);
        etmobile = (EditText) findViewById(R.id.edittextmobile);
        etusername = (EditText) findViewById(R.id.edittextusername);
        emailid = (EditText) findViewById(R.id.edittextemailid);
        Rdmale = (RadioButton) findViewById(R.id.radiomale);
        RdFemale = (RadioButton) findViewById(R.id.radiofemale);

        spin = (Spinner) findViewById(R.id.spinnerselectusertype);

        spin.setOnItemSelectedListener(this);

        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this, R.layout.sppinner_layout_listitem, Userstypeall);
        spinnerArrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spin.setAdapter(spinnerArrayAdapter);

        getData();


        setClickListners();
    }

    private void getData() {
        String name = user.getUserName();
        String address = user.getAddress();
        String email = user.getEmail();
        String gender = user.getGender();
        String mobilenumber = user.getMobileNumber();
        String role = user.getRole();
        String status = user.getStatus();

        if (address != null) {
            etaddress.setText(address);
        }
        if (name != null) {
            etname.setText(name);
        }
        if (email != null) {
            emailid.setText(email);
        }
        if (mobilenumber != null) {
            etmobile.setText(mobilenumber);
        }
        if (gender != null) {
            if (gender.equalsIgnoreCase("Male")) {
                Rdmale.setChecked(true);
            } else if (gender.equalsIgnoreCase("Female")) {
                RdFemale.setChecked(true);
            }
        }
        try {

            ArrayAdapter myAdap = (ArrayAdapter) spin.getAdapter();
            int spinnerPosition = myAdap.getPosition(role);
            spin.setSelection(spinnerPosition);
        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    private void setClickListners() {
        btnUpdate.setOnClickListener(this);
//        txttc.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonsubmit:
                validateAndCreateUser();
                break;
        }
    }



    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        Animation zoomOutAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoomin);
        view.startAnimation(zoomOutAnimation);
        return false;
    }

    private void validateAndCreateUser() {
        User user = fillUserModel();
        if (validate(user))
            UpdateUser(user);
    }

    private User fillUserModel() {
        User user1 = new User();
        user1.setUserName(etname.getText().toString());
        user1.setMobileNumber(etmobile.getText().toString());
        user1.setAddress(etaddress.getText().toString());
        user1.setEmail(emailid.getText().toString());
        user1.setPassword(user.getPassword());
        user1.setStatus(user.getStatus());
        user1.setUserId(user.getUserId());
        user1.setAgentId(user.getAgentId());
        user1.setRole(spin.getSelectedItem().toString());
//        String spinvalue = spin.getSelectedItem().toString();
//
//        if (spinvalue == ADMIN) {
//            user1.setRole(ADMIN);
//
//        } else if (spinvalue == TELECALLER) {
//            user1.setRole(TELECALLER);
//
//        } else if (spinvalue == CORDINATOR) {
//            user1.setRole(CORDINATOR);
//
//        } else if (spinvalue == SALES) {
//            user1.setRole(SALES);
//
//        } else if (spinvalue == ACCOUNTANT) {
//            user1.setRole(ACCOUNTANT);
//
//        }

        if (Rdmale.isChecked())
            user1.setGender(MALE);
        else
            user1.setGender(FEMALE);
        return user1;
    }

    private boolean validate(User user) {
        String validationMessage;
        boolean isValid = true;
        try {
            if (Utility.isEmptyOrNull(user.getUserName())) {
                validationMessage = "User Nmae Should not be empty";
                etname.setError(validationMessage);
                isValid = false;
            }
            if (Utility.isEmptyOrNull(user.getMobileNumber())) {
                validationMessage = getString(R.string.MOBILE_NUMBER_SHOULD_NOT_BE_EMPTY);
                etmobile.setError(validationMessage);
                isValid = false;
            } else if (!Utility.isValidMobileNumber(user.getMobileNumber())) {
                validationMessage = getMessage(R.string.INVALID_MOBILE_NUMBER);
                etmobile.setError(validationMessage);
                isValid = false;
            }
            if (Utility.isEmptyOrNull(user.getPassword())) {
                validationMessage = getString(R.string.PASSWORD_SHOULD_NOT_BE_EMPTY);
                etpassword.setError(validationMessage);
                isValid = false;
            }
        } catch (Exception e) {
            isValid = false;
            ExceptionUtil.logException(e);
        }
        return isValid;
    }


    private String getMessage(int id) {
        return getString(id);
    }

    private void UpdateUser(final User user) {
        updateLeed(user.getUserId(), user.toMap());
    }

    private void updateLeed(String leedId, Map leedsMap) {

        userRepository.updateUser(leedId, leedsMap, new CallBack() {
            @Override
            public void onSuccess(Object object) {

                Toast.makeText(Update_User_Activity.this, "User Updated", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(Update_User_Activity.this,MainActivity.class);
//                startActivity(intent);
            }

            @Override
            public void onError(Object object) {

            }
        });
    }

    private void addUserDataToPreferences(User user) {
        appSharedPreference.addUserDetails(user);
        appSharedPreference.createUserLoginSession();
    }

    private void loginToApp() {
        Toast.makeText(Update_User_Activity.this, "User Register Successfully", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(Update_User_Activity.this, LoginScreen.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}//end of activity
