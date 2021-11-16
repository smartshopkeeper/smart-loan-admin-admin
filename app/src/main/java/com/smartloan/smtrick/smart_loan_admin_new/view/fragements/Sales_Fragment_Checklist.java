package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.content.Context;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.smartloan.smtrick.smart_loan_admin_new.Listners.OnCheckedClickListener;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.CheckListAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.SalesChecklistAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.Tab_Adapter;

import java.util.ArrayList;

public class Sales_Fragment_Checklist extends Fragment implements AdapterView.OnItemSelectedListener,
        OnCheckedClickListener {

    // NOTE: Removed Some unwanted Boiler Plate Codes
    private OnFragmentInteractionListener mListener;

    public Sales_Fragment_Checklist() {
    }


    RecyclerView recycleChecklist;
    SalesChecklistAdapter checkListAdapter;
    ArrayList<String> checklist;
    LeedsModel leedsModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_checklist, container, false);

        // NOTE : We are calling the onFragmentInteraction() declared in the MainActivity
        // ie we are sending "Fragment 1" as title parameter when fragment1 is activated
        if (mListener != null) {
            mListener.onFragmentInteraction("Leads");
        }

        Bundle args = this.getArguments();
        if (args != null) {
            leedsModel = (LeedsModel) args.getSerializable(Constant.LEED_MODEL);

        }

        checklist = new ArrayList<>();
        checklist = leedsModel.getChecklist();

        if (checklist != null) {
            recycleChecklist = (RecyclerView) view.findViewById(R.id.recycler_view_users);
            recycleChecklist.setHasFixedSize(true);
            recycleChecklist.setLayoutManager(new LinearLayoutManager(getContext()));
            checkListAdapter = new SalesChecklistAdapter(getContext(), checklist, (OnCheckedClickListener) Sales_Fragment_Checklist.this);
            recycleChecklist.setAdapter(checkListAdapter);
        }


        return view;
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

    @Override
    public void onImageClick(String CheckedData, boolean isChecked) {

    }


    public interface OnFragmentInteractionListener {
        // NOTE : We changed the Uri to String.
        void onFragmentInteraction(String title);
    }
}
