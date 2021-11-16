package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;


import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_admin_new.models.Bank;
import com.smartloan.smtrick.smart_loan_admin_new.models.CheckList;
import com.smartloan.smtrick.smart_loan_admin_new.models.Target;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.CALANDER_DATE_FORMATE;

public class Add_Target_Fragement extends Fragment implements AdapterView.OnItemSelectedListener {
    private OnFragmentInteractionListener mListener;

    Button btnAddTarget;
    EditText edtMonth, edtTarget, edtPercentage;
    Spinner spinnerBank;

    private DatabaseReference mDatabase;
    ProgressDialogClass progressDialogClass;
    LeedRepository leedRepository;
    ArrayList<Bank> bankList;
    List<String> banknameList;

    int fromYear, fromMonth, fromDay;
    long fromDate, toDate;


    public Add_Target_Fragement() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_add_target, container, false);
        // NOTE : We are calling the onFragmentInteraction() declared in the MainActivity
        // ie we are sending "Fragment 1" as title parameter when fragment1 is activated
        if (mListener != null) {
            mListener.onFragmentInteraction("Under Construction");
        }

        progressDialogClass = new ProgressDialogClass(getActivity());
        leedRepository = new LeedRepositoryImpl();
        mDatabase = FirebaseDatabase.getInstance().getReference("Target");

        bankList = new ArrayList<>();
        banknameList = new ArrayList<>();

        edtMonth = (EditText) view.findViewById(R.id.edt_month);
        edtTarget = (EditText) view.findViewById(R.id.edt_target);
        edtPercentage = (EditText) view.findViewById(R.id.edt_percentage);
        spinnerBank = (Spinner) view.findViewById(R.id.spinner_bank);
        btnAddTarget = (Button) view.findViewById(R.id.btnaddtarget);

        setFromDateClickListner();
        readBanks();

        btnAddTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.please_wait));
                String bank = spinnerBank.getSelectedItem().toString();
                String month = edtMonth.getText().toString();
                String target = edtTarget.getText().toString();
                String percentage = edtPercentage.getText().toString();
                String key = mDatabase.push().getKey();

                Target target1 = new Target();
                target1.setBankname(bank);
                target1.setMonth(month);
                target1.setTarget(target);
                target1.setPercentage(percentage);
                target1.setTargetId(key);
                createTarget(target1);
            }
        });
        return view;
    }

    private void createTarget(Target target) {
        leedRepository.createTarget(target, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                Toast.makeText(getContext(), "Target Set Successfully", Toast.LENGTH_SHORT).show();
                edtMonth.setText("");
                edtPercentage.setText("");
                edtTarget.setText("");
                progressDialogClass.dismissDialog();
            }

            @Override
            public void onError(Object object) {
                progressDialogClass.dismissDialog();
            }
        });
    }

    private void readBanks() {
        progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.please_wait));
        leedRepository.readAllBanks(new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    bankList = (ArrayList<Bank>) object;

                    for (Bank bank : bankList) {
                        banknameList.add(bank.getBankname());
                    }
                    ArrayAdapter<String> spinnerArrayAdapterRecidential = new ArrayAdapter(getContext(), R.layout.sppinner_layout_listitem, banknameList);
                    spinnerArrayAdapterRecidential.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                    spinnerBank.setAdapter(spinnerArrayAdapterRecidential);
                    progressDialogClass.dismissDialog();
                }
            }


            @Override
            public void onError(Object object) {
                progressDialogClass.dismissDialog();
            }
        });
    }

    private void setFromCurrentDate() {
        Calendar mcurrentDate = Calendar.getInstance();
        fromYear = mcurrentDate.get(Calendar.YEAR);
        fromMonth = mcurrentDate.get(Calendar.MONTH);
        fromDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);
    }

    private void setFromDateClickListner() {
        setFromCurrentDate();
        edtMonth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog mDatePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        Calendar myCalendar = Calendar.getInstance();
                        myCalendar.set(Calendar.YEAR, selectedyear);
                        myCalendar.set(Calendar.MONTH, selectedmonth);
                        myCalendar.set(Calendar.DAY_OF_MONTH, selectedday);
                        SimpleDateFormat sdf = new SimpleDateFormat(CALANDER_DATE_FORMATE, Locale.FRANCE);
                        String formatedDate = sdf.format(myCalendar.getTime());
                        edtMonth.setText(formatedDate);
                        fromDay = selectedday;
                        fromMonth = selectedmonth;
                        fromYear = selectedyear;
                        fromDate = Utility.convertFormatedDateToMilliSeconds(formatedDate, CALANDER_DATE_FORMATE);
                    }
                }, fromYear, fromMonth, fromDay);
                mDatePicker.show();
            }
        });
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            // NOTE: This is the part that usually gives you the error
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}