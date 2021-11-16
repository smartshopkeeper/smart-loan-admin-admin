package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import androidx.annotation.NonNull;
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

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.exception.ExceptionUtil;
import com.smartloan.smtrick.smart_loan_admin_new.models.User;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.UserRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.UserRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.util.concurrent.TimeUnit;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.ACCOUNTANT;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.ADMIN;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.AGENT_PREFIX;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.CORDINATOR;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.FEMALE;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.MALE;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.SALES;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.TELECALLER;

public class Registeractivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener, View.OnTouchListener, View.OnClickListener {
    TextView txtlogin, txttc;
    Button btlogin, btnotp;
    EditText etname, etaddress, etmobile, editTextPassword, etusername, etpassword, emailid, etreenterpassword, etotp;
    Spinner spin;
    RadioButton Rdmale, RdFemale;
    private UserRepository userRepository;
    private ProgressDialogClass progressDialogClass;
    private AppSharedPreference appSharedPreference;


    private String verificationId;
    private FirebaseAuth mAuth;
//    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);
        userRepository = new UserRepositoryImpl(this);
        progressDialogClass = new ProgressDialogClass(this);
        appSharedPreference = new AppSharedPreference(this);
        mAuth = FirebaseAuth.getInstance();
        String[] Userstype = new String[]{"Agent"};


        String[] Userstypeall = new String[]{
                "Admin",
                "Accountant",
                "Telecaller",
                "Coordinator",
                "Sales"};

        //txtlogin = (TextView) findViewById(R.id.txtRegister);
        btlogin = (Button) findViewById(R.id.buttonsubmit);
        btnotp = (Button) findViewById(R.id.buttongenerateotp);
        etname = (EditText) findViewById(R.id.edittextname);
        etaddress = (EditText) findViewById(R.id.edittextaddress);
        etmobile = (EditText) findViewById(R.id.edittextmobile);
        etusername = (EditText) findViewById(R.id.edittextusername);
        etpassword = (EditText) findViewById(R.id.edittextpassword);
        emailid = (EditText) findViewById(R.id.edittextemailid);
        etreenterpassword = (EditText) findViewById(R.id.edittextreenterpassword);
        editTextPassword = (EditText) findViewById(R.id.edittextreenterpassword);
        etotp = (EditText) findViewById(R.id.edittextenterotp);
        Rdmale = (RadioButton) findViewById(R.id.radiomale);
        RdFemale = (RadioButton) findViewById(R.id.radiofemale);

        spin = (Spinner) findViewById(R.id.spinnerselectusertype);
        spin.setOnItemSelectedListener(this);


        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this, R.layout.sppinner_layout_listitem2, Userstypeall
        );
        spinnerArrayAdapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spin.setAdapter(spinnerArrayAdapter);

        txttc = (TextView) findViewById(R.id.txttermsandconditions);
        txtlogin = (TextView) findViewById(R.id.textViewLogin);
        setClickListners();
        setTouchListner();
    }

    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    private void setClickListners() {
        btlogin.setOnClickListener(this);
        txttc.setOnClickListener(this);
        txtlogin.setOnClickListener(this);
        btnotp.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonsubmit:
                String code = etotp.getText().toString();
                validateAndCreateUser();
                verifyCode(code);
                break;
            case R.id.txttermsandconditions:
                Intent intent = new Intent(Registeractivity.this, TermsCondition_Activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.backslide_in, R.anim.backslide_out);
                break;
            case R.id.buttongenerateotp:
                String phonenumber ="+91" + etmobile.getText().toString()  ;
                sendVerificationCode(phonenumber);
                break;
            case R.id.textViewLogin:
                Intent intent1 = new Intent(Registeractivity.this, LoginScreen.class);
                startActivity(intent1);
                overridePendingTransition(R.anim.backslide_in, R.anim.backslide_out);
                break;
        }
    }

    private void setTouchListner() {
        Rdmale.setOnTouchListener(this);
        RdFemale.setOnTouchListener(this);
        etname.setOnTouchListener(this);
        etaddress.setOnTouchListener(this);
        etmobile.setOnTouchListener(this);
        etusername.setOnTouchListener(this);
        etpassword.setOnTouchListener(this);
        emailid.setOnTouchListener(this);
        etreenterpassword.setOnTouchListener(this);
        etotp.setOnTouchListener(this);
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
            createUser(user);
    }

    private User fillUserModel() {
        User user = new User();
        user.setUserName(etname.getText().toString());
        user.setMobileNumber(etmobile.getText().toString());
        user.setAddress(etaddress.getText().toString());
        user.setEmail(emailid.getText().toString());
        user.setPassword(etpassword.getText().toString());
        user.setStatus("Deactive");
        user.setAgentId(Utility.generateAgentId(AGENT_PREFIX));

        String spinvalue = spin.getSelectedItem().toString();

        if (spinvalue == "Admin") {
            user.setRole(ADMIN);

        } else if (spinvalue == "Telecaller")
        {
            user.setRole(TELECALLER);

        } else if (spinvalue == "Coordinator")
        {
            user.setRole(CORDINATOR);

        } else if(spinvalue == "Sales")
        {
            user.setRole(SALES);

        } else if(spinvalue == "Accountant")
        {
            user.setRole(ACCOUNTANT);

        }

        if (Rdmale.isChecked())
            user.setGender(MALE);
        else
            user.setGender(FEMALE);
        return user;
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
            }else if (!Utility.isValidMobileNumber(user.getMobileNumber())) {
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
            ExceptionUtil.logException( e);
        }
        return isValid;
    }



    private String getMessage(int id) {
        return getString(id);
    }

    private void createUser(final User user) {
        progressDialogClass.showDialog(getMessage(R.string.loading), getMessage(R.string.please_wait));
        userRepository.createUser(user, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                addUserDataToPreferences(user);
                loginToApp();
            }

            @Override
            public void onError(Object object) {
                Utility.showMessage(Registeractivity.this, getMessage(R.string.registration_fail));
                progressDialogClass.dismissDialog();
            }
        });
    }

    private void addUserDataToPreferences(User user) {
        appSharedPreference.addUserDetails(user);
        appSharedPreference.createUserLoginSession();
    }

    private void loginToApp() {
        Toast.makeText(Registeractivity.this, "User Register Successfully", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(Registeractivity.this, LoginScreen.class);
        startActivity(i);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }

    private void sendVerificationCode(String number) {
//        progressBar.setVisibility(View.VISIBLE);
        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                number,
                60,
                TimeUnit.SECONDS,
                (Activity) TaskExecutors.MAIN_THREAD,
                mCallBack
        );

    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
            mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationId = s;
        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            if (code != null) {
                etotp.setText(code);
                verifyCode(code);
            }
        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            Toast.makeText(Registeractivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    };

    private void verifyCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
        signInWithCredential(credential);
    }

    private void signInWithCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            validateAndCreateUser();
//                            User user = fillUserModel();
//                            Users user = new Users();
//                            user.setName(username);
//                            user.setMobilenumber(phonenumber);
//                            user.setAgentId(Utility.generateAgentId(AGENT_PREFIX));
//                            String uploadId = mDatabase.push().getKey();
//                            user.setUserid(uploadId);
//                            mDatabase.child(uploadId).setValue(user);
//                            appSharedPreference.addUserDetails(user);
//                            appSharedPreference.createUserLoginSession();
//                            Intent intent = new Intent(Registeractivity.this, MainActivity.class);
//                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//
//                            startActivity(intent);

                        } else {
                            Toast.makeText(Registeractivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
}//end of activity
