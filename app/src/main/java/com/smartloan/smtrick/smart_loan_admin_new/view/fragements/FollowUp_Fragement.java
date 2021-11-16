package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_admin_new.models.FollowUp;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.Documents_Adapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.util.ArrayList;

public class FollowUp_Fragement extends Fragment implements AdapterView.OnItemSelectedListener {
    // NOTE: Removed Some unwanted Boiler Plate Codes
    private OnFragmentInteractionListener mListener;


    public FollowUp_Fragement() {
    }

    private ArrayList<FollowUp> followUps;
    private LeedRepository leedRepository;
    String LeedId;
    private RecyclerView recyclerViewFollowUp;
    private ArrayList<String> documentList;
    private Documents_Adapter documents_adapter;
    private LinearLayout layoutMain;
    ProgressDialogClass progressDialogClass;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_followup, container, false);
        // NOTE : We are calling the onFragmentInteraction() declared in the MainActivity
        // ie we are sending "Fragment 1" as title parameter when fragment1 is activated
        if (mListener != null) {
            mListener.onFragmentInteraction("Documents");
        }

        leedRepository = new LeedRepositoryImpl();
        progressDialogClass = new ProgressDialogClass(getActivity());
        documentList = new ArrayList<>();
        followUps = new ArrayList<>();

        recyclerViewFollowUp = view.findViewById(R.id.recycler_view_folow);
        layoutMain = view.findViewById(R.id.layoutMainDisplay);

        try {
            Bundle b = this.getArguments();
            if (b != null) {
                LeedId = b.getString("leedId");
                readFollowUp();
            }
        } catch (Exception e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }


        return view;
    }

    private void readFollowUp() {
        if (LeedId != null) {
            progressDialogClass.showDialog(this.getString(R.string.loading), this.getString(R.string.PLEASE_WAIT));
            leedRepository.readFolloUpByLeedId(LeedId, new CallBack() {
                @Override
                public void onSuccess(Object object) {
                    if (object != null) {
                        followUps = (ArrayList<FollowUp>) object;


                    }else {
//                        layoutMain.setBackgroundResource(R.drawable.empty);
                        Toast.makeText(getContext(), "Sorry nothing to display", Toast.LENGTH_SHORT).show();
                    }
                    if (followUps != null) {
                        for (int i = 0; i < followUps.size(); i++)
                            documentList.add(followUps.get(i).getDescription());
                    }

                    documents_adapter = new Documents_Adapter(getActivity(), documentList);
                    //adding adapter to recyclerview
                    recyclerViewFollowUp.setAdapter(documents_adapter);
                    recyclerViewFollowUp.setHasFixedSize(true);
                    recyclerViewFollowUp.setLayoutManager(new LinearLayoutManager(getContext()));

                    progressDialogClass.dismissDialog();
                }

                @Override
                public void onError(Object object) {
                    progressDialogClass.dismissDialog();
                }
            });

        }

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