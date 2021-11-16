package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.app.Dialog;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.RecyclerListener.RecyclerTouchListener;
import com.smartloan.smtrick.smart_loan_admin_new.models.Invoice;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.AccountantInvoiceAdapter;

public class AccountantPaidInvoiceFragment extends Fragment {
    private RecyclerView recyclerView;
    AccountantInvoiceAdapter accountantInvoiceAdapter;

    public AccountantPaidInvoiceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_accountant_sent_invoice, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
       /* recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL));*/
        accountantInvoiceAdapter = new AccountantInvoiceAdapter(Invoice.getPaidInvoices());
        recyclerView.setAdapter(accountantInvoiceAdapter);
        onClickListner();
        return view;
    }

    private void onClickListner() {
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                showDetailDialog();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    private void showDetailDialog() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.setContentView(R.layout.accountant_invoices_detail_dialog_layout);
        dialog.setTitle("Title...");
        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonaccept);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        Button dialogButton2 = (Button) dialog.findViewById(R.id.dialogButtonreject);
        dialogButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
