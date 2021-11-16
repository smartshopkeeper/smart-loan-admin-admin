package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;


import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
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

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_admin_new.models.Bank;
import com.smartloan.smtrick.smart_loan_admin_new.models.Commission;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.CommissionAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.ExpenceAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;

import static android.app.Activity.RESULT_OK;

public class Add_Comission_Rules_Fragement extends Fragment implements AdapterView.OnItemSelectedListener {
    private OnFragmentInteractionListener mListener;

//    Spinner Bankname;
//    EditText Percentage;
    Button Addbank;

    FirebaseStorage storage;
    StorageReference storageReference;
    LeedRepository leedRepository;
    private DatabaseReference mDatabase;
    ProgressDialogClass progressDialogClass;
    ArrayList<Commission> commissionArraylist;

    RecyclerView CommissionRecycle;
    ImageView AddCommission;
    CommissionAdapter adapter;

    public Add_Comission_Rules_Fragement() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_commission_details, container, false);
        // NOTE : We are calling the onFragmentInteraction() declared in the MainActivity
        // ie we are sending "Fragment 1" as title parameter when fragment1 is activated
        if (mListener != null) {
            mListener.onFragmentInteraction("Under Construction");
        }

        progressDialogClass = new ProgressDialogClass(getActivity());
        leedRepository = new LeedRepositoryImpl();
        mDatabase = FirebaseDatabase.getInstance().getReference("banks");

        CommissionRecycle = (RecyclerView) view.findViewById(R.id.recycler_view_commission);
        AddCommission = (ImageView) view.findViewById(R.id.addcommission);


        Addbank = (Button) view.findViewById(R.id.btnaddbank);

        storage = FirebaseStorage.getInstance();
        storageReference = storage.getReference();


        AddCommission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final Dialog dialog1 = new Dialog(getContext());
                dialog1.setContentView(R.layout.add_commission_fragement);

                final EditText minvalue = (EditText) dialog1.findViewById(R.id.txtminamount);
                final EditText maxvalue = (EditText) dialog1.findViewById(R.id.txtmaxamount);
                final EditText percetage = (EditText) dialog1.findViewById(R.id.txtcomissionpercentage);
                Button Add = (Button) dialog1.findViewById(R.id.btnaddcommission);
                Button cancle = (Button) dialog1.findViewById(R.id.btncancle);
                cancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog1.dismiss();
                    }
                });
                Add.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));
                        Commission bank = new Commission();
                        bank.setMinAmount(minvalue.getText().toString());
                        bank.setMaxAmount(maxvalue.getText().toString());
                        bank.setPercentage(percetage.getText().toString());

                        bank.setGeneratedId(mDatabase.push().getKey());
                        leedRepository.createCommission(bank, new CallBack() {
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
                });

                dialog1.show();

            }
        });

        getCommission();

        return view;
    }

    private void getCommission() {
        leedRepository.readAllCommission(new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    commissionArraylist = (ArrayList<Commission>) object;

                }
               if (commissionArraylist != null) {
                   adapter = new CommissionAdapter(getContext(), commissionArraylist);
                   //adding adapter to recyclerview
                   CommissionRecycle.setAdapter(adapter);
                   // CatalogAdapter catalogAdapter = new CatalogAdapter(catalogList);
                   CommissionRecycle.setHasFixedSize(true);
//                   CommissionRecycle.setLayoutManager(new LinearLayoutManager(getContext()));
                   CommissionRecycle.setLayoutManager(new GridLayoutManager(getContext(), 2));
               }

            }

            @Override
            public void onError(Object object) {
                Utility.showLongMessage(getActivity(), getString(R.string.server_error));
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