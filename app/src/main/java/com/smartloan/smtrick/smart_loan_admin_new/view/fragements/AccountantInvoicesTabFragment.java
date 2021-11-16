package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;


import android.content.Context;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.ViewPagerAdapter;

public class AccountantInvoicesTabFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;
    public OnFragmentInteractionListener mListener;

    public AccountantInvoicesTabFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mListener != null) {
            mListener.onFragmentInteraction("Invoices");
        }
        View view = inflater.inflate(R.layout.fragment_accountant_invoices_tab, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragement(new AccountantSentInvoiceFragment(), "Sent");
        viewPagerAdapter.addFragement(new AccountantApprovedInvoiceFragment(), "Approved");
        viewPagerAdapter.addFragement(new AccountantPaidInvoiceFragment(), "Paid");
        viewPagerAdapter.addFragement(new AccountantRejectedInvoiceFragment(), "Rejected");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setTabMode(1);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
