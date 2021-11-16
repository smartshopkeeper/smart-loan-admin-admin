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

import com.google.firebase.database.DatabaseReference;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_admin_new.models.Expences;
import com.smartloan.smtrick.smart_loan_admin_new.models.Invoice;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.AdminInvoiceAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.ExpenceAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.InvoiceAdapter;

import java.util.ArrayList;
import java.util.List;

public class Generated_Invoices_Admin_Fragment extends Fragment implements AdapterView.OnItemSelectedListener {
    // NOTE: Removed Some unwanted Boiler Plate Codes
    private OnFragmentInteractionListener mListener;
    private DatabaseReference mdataRefuser;
    private LeedRepository leedRepository;
    private ArrayList<Invoice> invoiceList;
    private ArrayList<Invoice> userList1;

    public Generated_Invoices_Admin_Fragment() {
    }

//    ArrayList<UserModel> searchResults = GetSearchResults();
    RecyclerView listView;
    AdminInvoiceAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_invoices, container, false);
        // NOTE : We are calling the onFragmentInteraction() declared in the MainActivity
        // ie we are sending "Fragment 1" as title parameter when fragment1 is activated
        if (mListener != null) {
            mListener.onFragmentInteraction("Generated");

            leedRepository = new LeedRepositoryImpl();
            invoiceList = new ArrayList<>();
            userList1 = new ArrayList<>();
            listView = (RecyclerView) view.findViewById(R.id.recycler_view_users);

            readUsers();
        }

        return view;
    }

    private void readUsers() {
        invoiceList.clear();
        leedRepository.readInvoicesByStatus(Constant.STATUS_INVOICE_SENT, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    invoiceList = (ArrayList<Invoice>) object;

                }

                adapter = new AdminInvoiceAdapter(getActivity(), invoiceList);
                //adding adapter to recyclerview
                listView.setAdapter(adapter);
                // CatalogAdapter catalogAdapter = new CatalogAdapter(catalogList);
                listView.setHasFixedSize(true);
                listView.setLayoutManager(new LinearLayoutManager(getContext()));
                adapter.notifyDataSetChanged();

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