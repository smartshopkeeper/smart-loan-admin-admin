package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;


import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_admin_new.models.Invoice;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.InvoiceAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.util.ArrayList;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.STATUS_INVOICE_SENT;

public class SentInvoiceFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    private OnFragmentInteractionListener mListener;

    public SentInvoiceFragment() {
    }

//    ArrayList<Invoice> searchResults = GetSearchResults();
    ListView listinvoices;
    InvoiceAdapter telecallerLeedsAdapter;
    RecyclerView invoiceRecycleView;
    ProgressDialogClass progressDialogClass;
    ArrayList<Invoice> invoiceArrayList;
    LeedRepository leedRepository;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sent_invoice, container, false);
        if (mListener != null) {
            mListener.onFragmentInteraction("Invoices");
        }

        progressDialogClass = new ProgressDialogClass(getActivity());
        invoiceArrayList = new ArrayList<>();
        leedRepository = new LeedRepositoryImpl();
        invoiceRecycleView = (RecyclerView) view.findViewById(R.id.recycler_view_invoices);

        getInvoices();
//        listinvoices = (ListView) view.findViewById(R.id.listinvoices);
//        listinvoices.setAdapter(new InvoicesAdapter(getActivity(), searchResults));
//
//        listinvoices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
//                Object o = listinvoices.getItemAtPosition(position);
//                listinvoices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> a, View v, int position, long id) {
//                        Object o = listinvoices.getItemAtPosition(position);
//                        final Dialog dialog = new Dialog(getActivity());
//                        dialog.setContentView(R.layout.invoicedialog);
//                        dialog.setTitle("Title...");
//                        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonaccept);
//                        dialogButton.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                dialog.dismiss();
//                            }
//                        });
//
//                        dialog.show();
//                    }
//                });
//            }
//        });
        return view;
    }

    private void getInvoices() {
        progressDialogClass.showDialog(this.getString(R.string.loading), this.getString(R.string.PLEASE_WAIT));
        leedRepository.readInvoicesByStatus(STATUS_INVOICE_SENT, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    invoiceArrayList = (ArrayList<Invoice>) object;
                    serAdapter(invoiceArrayList);
                }
                progressDialogClass.dismissDialog();
            }

            @Override
            public void onError(Object object) {
                progressDialogClass.dismissDialog();
                Utility.showLongMessage(getActivity(), getString(R.string.server_error));
            }
        });
    }

    private void serAdapter(ArrayList<Invoice> leedsModels) {
        if (leedsModels != null) {
            if (telecallerLeedsAdapter == null) {
                telecallerLeedsAdapter = new InvoiceAdapter(getActivity(), leedsModels);
                invoiceRecycleView.setAdapter(telecallerLeedsAdapter);
//                onClickListner();
            } else {
                ArrayList<Invoice> leedsModelArrayList = new ArrayList<>();
                leedsModelArrayList.addAll(leedsModels);
                telecallerLeedsAdapter.reload(leedsModelArrayList);
            }
        }
    }

//    private ArrayList<Invoice> GetSearchResults() {
//        ArrayList<Invoice> results = new ArrayList<Invoice>();
//        for (int i = 0; i < 20; i++) {
//            Invoice sr = new Invoice();
//            sr.setInvoiceId("2345");
//            sr.setCustomerName("Mr Pratik Patel");
//            sr.setPhone("Axis Bank");
//            results.add(sr);
//        }
//        return results;
//    }

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