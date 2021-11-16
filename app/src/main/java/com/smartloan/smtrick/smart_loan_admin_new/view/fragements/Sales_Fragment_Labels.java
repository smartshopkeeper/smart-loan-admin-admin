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

import com.smartloan.smtrick.smart_loan_admin_new.Listners.OnCheckedClickListener;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.models.Bank;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.SalesChecklistAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.SalesLabelsAdapter;

import java.util.ArrayList;

public class Sales_Fragment_Labels extends Fragment implements AdapterView.OnItemSelectedListener {

    // NOTE: Removed Some unwanted Boiler Plate Codes
    private OnFragmentInteractionListener mListener;

    public Sales_Fragment_Labels() {
    }


    RecyclerView recycleChecklist;
    SalesLabelsAdapter checkListAdapter;
    LeedsModel leedsModel;
    LeedRepository leedRepository;
    ArrayList<Bank> BanksArraylist;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_labels, container, false);

        // NOTE : We are calling the onFragmentInteraction() declared in the MainActivity
        // ie we are sending "Fragment 1" as title parameter when fragment1 is activated
        if (mListener != null) {
            mListener.onFragmentInteraction("Leads");
        }

        Bundle args = this.getArguments();
        if (args != null) {
            leedsModel = (LeedsModel) args.getSerializable(Constant.LEED_MODEL);

        }

        leedRepository = new LeedRepositoryImpl();

        getBanks();

        BanksArraylist = new ArrayList<>();
        recycleChecklist = (RecyclerView) view.findViewById(R.id.recycler_view_labels);
        recycleChecklist.setHasFixedSize(true);
        recycleChecklist.setLayoutManager(new LinearLayoutManager(getContext()));



        return view;
    }

    private void getBanks() {
        leedRepository.readAllBanks(new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    BanksArraylist = (ArrayList<Bank>) object;
                }
                checkListAdapter = new SalesLabelsAdapter(getContext(), BanksArraylist);
                recycleChecklist.setAdapter(checkListAdapter);
            }

            @Override
            public void onError(Object object) {

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


    public interface OnFragmentInteractionListener {
        // NOTE : We changed the Uri to String.
        void onFragmentInteraction(String title);
    }
}
