package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;


import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_admin_new.models.CheckList;
import com.smartloan.smtrick.smart_loan_admin_new.models.Commission;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.CommissionAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.util.ArrayList;

public class Add_CheckList_Fragement extends Fragment implements AdapterView.OnItemSelectedListener {
    private OnFragmentInteractionListener mListener;

//    Spinner Bankname;
//    EditText Percentage;
    Button btnAddRule;
    EditText edtRule;
    Spinner RuleType;

    private DatabaseReference mDatabase;
    ProgressDialogClass progressDialogClass;
    LeedRepository leedRepository;

//    FirebaseStorage storage;
//    StorageReference storageReference;
//    LeedRepository leedRepository;
//    private DatabaseReference mDatabase;
//    ProgressDialogClass progressDialogClass;
//    ArrayList<Commission> commissionArraylist;
//
//    RecyclerView CommissionRecycle;
//    ImageView AddCommission;
//    CommissionAdapter adapter;

    public Add_CheckList_Fragement() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_add_checklist, container, false);
        // NOTE : We are calling the onFragmentInteraction() declared in the MainActivity
        // ie we are sending "Fragment 1" as title parameter when fragment1 is activated
        if (mListener != null) {
            mListener.onFragmentInteraction("Under Construction");
        }


        progressDialogClass = new ProgressDialogClass(getActivity());
        leedRepository = new LeedRepositoryImpl();
        mDatabase = FirebaseDatabase.getInstance().getReference("banks");

        String[] RuleTypes = new String[]{"SALARIED", "SELF EMPLOYED", "NRI SALARIED", "SALARIED(BT OR BT+TOPUP)",
                "SELF EMPLOYED(BT OR BT+TOPUP)"};

        RuleType = (Spinner) view.findViewById(R.id.spinner_ruletype);
        edtRule = (EditText) view.findViewById(R.id.edt_rule);
        btnAddRule = (Button) view.findViewById(R.id.btnaddrule);


        ArrayAdapter<String> spinnerArrayAdapterRecidential = new ArrayAdapter(getContext(), R.layout.sppinner_layout_listitem, RuleTypes);
        spinnerArrayAdapterRecidential.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        RuleType.setAdapter(spinnerArrayAdapterRecidential);

        btnAddRule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddRule();
            }
        });
        return view;
    }

    private void AddRule() {
        progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));
        CheckList check = new CheckList();
        check.setRuleType(RuleType.getSelectedItem().toString());
        check.setRule(edtRule.getText().toString());
        check.setGeneratedId(mDatabase.push().getKey());

        leedRepository.createCheckList(check, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                progressDialogClass.dismissDialog();
                Toast.makeText(getContext(), "Updated", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onError(Object object) {

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