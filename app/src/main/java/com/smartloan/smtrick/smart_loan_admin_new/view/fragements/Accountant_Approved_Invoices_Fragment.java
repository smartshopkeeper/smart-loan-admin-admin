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

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_admin_new.models.Expences;
import com.smartloan.smtrick.smart_loan_admin_new.models.Invoice;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.AccountantApprovedExpenceAdapter;

import java.util.ArrayList;
import java.util.List;

public class Accountant_Approved_Invoices_Fragment extends Fragment implements AdapterView.OnItemSelectedListener {
    // NOTE: Removed Some unwanted Boiler Plate Codes
    private OnFragmentInteractionListener mListener;
    private LeedRepository leedRepository;
    private List<Invoice> invoiceList;

    public Accountant_Approved_Invoices_Fragment() {
    }

//    ArrayList<UserModel> searchResults = GetSearchResults();
    RecyclerView listView;
    AccountantApprovedExpenceAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_acct_approved_invoices, container, false);
        // NOTE : We are calling the onFragmentInteraction() declared in the MainActivity
        // ie we are sending "Fragment 1" as title parameter when fragment1 is activated
        if (mListener != null) {
            mListener.onFragmentInteraction("Approved");

            leedRepository = new LeedRepositoryImpl();
            invoiceList = new ArrayList<>();
            listView = (RecyclerView) view.findViewById(R.id.recycler_view_users);

            readApprovedInvoices();
        }

        return view;
    }

    private void readApprovedInvoices() {
        invoiceList.clear();
        leedRepository.readInvoicesByStatus(Constant.STATUS_INVOICE_AGENT_YES,new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    invoiceList = (ArrayList<Invoice>) object;


                }

//                adapter = new AccountantApprovedExpenceAdapter(getActivity(), invoiceList,false);
//                //adding adapter to recyclerview
//                listView.setAdapter(adapter);
//                listView.setHasFixedSize(true);
//                listView.setLayoutManager(new LinearLayoutManager(getContext()));

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