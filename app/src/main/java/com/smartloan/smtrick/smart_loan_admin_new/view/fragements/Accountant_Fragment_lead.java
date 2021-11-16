package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.Tab_Adapter;

public class Accountant_Fragment_lead extends Fragment implements AdapterView.OnItemSelectedListener {

    // NOTE: Removed Some unwanted Boiler Plate Codes
    private OnFragmentInteractionListener mListener;

    public Accountant_Fragment_lead() {
    }

    private Tab_Adapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    Spinner spinloantype, spinemptype, spinincome;
    ProgressBar progressBar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.telecaller_fragment_leads, container, false);

        // NOTE : We are calling the onFragmentInteraction() declared in the MainActivity
        // ie we are sending "Fragment 1" as title parameter when fragment1 is activated
        if (mListener != null) {
            mListener.onFragmentInteraction("Leads");
        }

        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);

        viewPager.setOffscreenPageLimit(0);
        //adapter = new Tab_Adapter(getSupportFragmentManager());
        adapter = new Tab_Adapter(getChildFragmentManager());

        adapter.addFragment(new Accountant_fragment_lead_tab_Disbussed(), "Disbussed");
        adapter.addFragment(new Accountant_fragment_lead_tab_Disbussed(), "Bank Submitted");


        viewPager.setAdapter(adapter);
//
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


        return view;
    }


//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            // NOTE: This is the part that usually gives you the error
//            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
//        }
//    }


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


    public interface OnFragmentInteractionListener {
        // NOTE : We changed the Uri to String.
        void onFragmentInteraction(String title);
    }
}
