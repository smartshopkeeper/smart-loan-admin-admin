package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.content.Context;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.singleton.AppSingleton;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.Tab_Adapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.util.ArrayList;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.STATUS_VERIFIED;

public class Coordinator_Fragment_lead extends Fragment implements AdapterView.OnItemSelectedListener {

    // NOTE: Removed Some unwanted Boiler Plate Codes
    private OnFragmentInteractionListener mListener;

    public Coordinator_Fragment_lead() {
    }

    private Tab_Adapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    LeedRepository leedRepository;
    ProgressDialogClass progressDialogClass;
    ArrayList<LeedsModel> leedsModelArrayList;
    int count;

    Spinner spinloantype, spinemptype, spinincome;
    ProgressBar progressBar;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.coordinator_fragment_leads, container, false);

        // NOTE : We are calling the onFragmentInteraction() declared in the MainActivity
        // ie we are sending "Fragment 1" as title parameter when fragment1 is activated
        if (mListener != null) {
            mListener.onFragmentInteraction("Leads");
        }

        leedRepository = new LeedRepositoryImpl();
        progressDialogClass = new ProgressDialogClass(getActivity());

        leedsModelArrayList = new ArrayList<>();

        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        tabLayout = (TabLayout) view.findViewById(R.id.tabLayout);

        viewPager.setOffscreenPageLimit(0);
        adapter = new Tab_Adapter(getChildFragmentManager());

        getteLeed();

        return view;
    }


    private void getteLeed() {
        progressDialogClass.showDialog(this.getString(R.string.loading), this.getString(R.string.PLEASE_WAIT));
        leedRepository.readLeedsByStatus(STATUS_VERIFIED, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    leedsModelArrayList = (ArrayList<LeedsModel>) object;

                    count = leedsModelArrayList.size();

                    setViewpager();

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

    private void setViewpager() {
        adapter.addFragment(new Co_fragment_lead_tab_verified(), "Verified("+String.valueOf(count)+")");
        adapter.addFragment(new Coordinator_fragment_lead_tab_submited(), "Bank Submitted");
        adapter.addFragment(new Co_fragment_lead_tab_Disbussed(), "Disbussed");
        adapter.addFragment(new Sales_fragment_lead_tab_rejected(), "Rejected");

        viewPager.setAdapter(adapter);

        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
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
