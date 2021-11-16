package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.models.Invoice;

import java.util.ArrayList;

public class RejectedInvoicesFragement extends Fragment implements AdapterView.OnItemSelectedListener {
    public RejectedInvoicesFragement() {
    }

    ArrayList<Invoice> searchResults = GetSearchResults();
    ListView listinvoices;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sent_invoice, container, false);
//        listinvoices = (ListView) view.findViewById(R.id.listinvoices);
//        listinvoices.setAdapter(new InvoicesAdapter(getActivity(), searchResults));
//        listinvoices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> a, View v, int position, long id) {
//                Object o = listinvoices.getItemAtPosition(position);
//                listinvoices.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> a, View v, int position, long id) {
//                        Object o = listinvoices.getItemAtPosition(position);
//                        // custom dialog
//                        final Dialog dialog = new Dialog(getActivity());
//                        dialog.setContentView(R.layout.invoicedialog);
//                        dialog.setTitle("Title...");
//                        // set the custom dialog components - text, image and button
//                        //  TextView text = (TextView) dialog.findViewById(R.id.text);
//                        // text.setText("Android custom dialog example!");
//                        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonaccept);
//                        // if button is clicked, close the custom dialog
//                        dialogButton.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                dialog.dismiss();
//                            }
//                        });
//                        Button dialogButton2 = (Button) dialog.findViewById(R.id.dialogButtonreject);
//                        // if button is clicked, close the custom dialog
//                        dialogButton2.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                dialog.dismiss();
//                            }
//                        });
//                        dialog.show();
//                    }
//                });
//            }
//        });
        return view;
    }

    private ArrayList<Invoice> GetSearchResults() {
        ArrayList<Invoice> results = new ArrayList<Invoice>();
        for (int i = 0; i < 20; i++) {
            Invoice sr = new Invoice();
            sr.setInvoiceId("2345");
            sr.setCustomerName("Mr Pratik Patel");
            sr.setPhone("Axis Bank");
            sr.setStatus("Rejected");
            results.add(sr);
        }
        return results;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}