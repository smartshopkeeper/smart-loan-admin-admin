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
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.models.User;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.UserRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.UserRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.Agents_Adapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.Lead_Summary_Adapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.util.ArrayList;
import java.util.List;

public class Leads_Summary_Fragment extends Fragment implements AdapterView.OnItemSelectedListener {
    // NOTE: Removed Some unwanted Boiler Plate Codes
    private OnFragmentInteractionListener mListener;
    private LeedRepository leedRepository;
    private ArrayList<LeedsModel> leedsModelList;
    RecyclerView listView;
    Lead_Summary_Adapter adapter;
    TextView txtHLcount, txtBTcount, txtLAPcount, txtLeadscount, txtApprovedcount, txtRejectCount, txtInProcesscount, txtLeadsSummarycount;
    ProgressDialogClass progressDialogClass;

    public Leads_Summary_Fragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leads_summary, container, false);
        // NOTE : We are calling the onFragmentInteraction() declared in the MainActivity
        // ie we are sending "Fragment 1" as title parameter when fragment1 is activated
        if (mListener != null) {
            mListener.onFragmentInteraction("Leeds Summary");

            leedRepository = new LeedRepositoryImpl();
            progressDialogClass = new ProgressDialogClass(getActivity());

            leedsModelList = new ArrayList<>();
            listView = (RecyclerView) view.findViewById(R.id.recycler_view_agents);

            txtHLcount = view.findViewById(R.id.txtHLcount);
            txtBTcount = view.findViewById(R.id.txtbtcount);
            txtLAPcount = view.findViewById(R.id.txtlapcount);
            txtLeadscount = view.findViewById(R.id.leadscount);
            txtApprovedcount = view.findViewById(R.id.leadsapprovedcount);
            txtInProcesscount = view.findViewById(R.id.inprocesscount);
            txtRejectCount = view.findViewById(R.id.rejectcount);
            txtLeadsSummarycount = view.findViewById(R.id.leadsummarycount);

            readExpences();
        }

        return view;
    }

    private void readExpences() {
        progressDialogClass.showDialog(this.getString(R.string.loading), this.getString(R.string.PLEASE_WAIT));

        leedsModelList.clear();
        leedRepository.readAllLeeds(new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    leedsModelList = (ArrayList<LeedsModel>) object;

                }

                adapter = new Lead_Summary_Adapter(getActivity(), leedsModelList);
                //adding adapter to recyclerview
                listView.setAdapter(adapter);
                // CatalogAdapter catalogAdapter = new CatalogAdapter(catalogList);
                listView.setHasFixedSize(true);
                listView.setLayoutManager(new LinearLayoutManager(getContext()));

                setDetails(leedsModelList);

                progressDialogClass.dismissDialog();

            }

            @Override
            public void onError(Object object) {
                Utility.showLongMessage(getActivity(), getString(R.string.server_error));
                progressDialogClass.dismissDialog();
            }
        });
    }

    private void setDetails(ArrayList<LeedsModel> leedsModelList) {
        int HLcount = 0;
        int BTcount = 0;
        int LAPcount = 0;
        int Approvedcount = 0;
        int Inprocesscount = 0;
        int Rejectcount = 0;

        int leedsCount = leedsModelList.size();

        for (LeedsModel leedmodel : leedsModelList) {
            if (leedmodel.getLoanType().equalsIgnoreCase(Constant.LOAN_TYPE_HL)) {
                HLcount++;
            }
            if (leedmodel.getLoanType().equalsIgnoreCase(Constant.LOAN_TYPE_LAP)) {
                LAPcount++;
            }
            if (leedmodel.getLoanType().equalsIgnoreCase(Constant.LOAN_TYPE_BALANCE_TRANSFER)) {
                BTcount++;
            }
            if (leedmodel.getStatus().equalsIgnoreCase(Constant.STATUS_APPROVED)) {
                Approvedcount++;
            }
            if (leedmodel.getStatus().equalsIgnoreCase(Constant.STATUS_IN_PROGRESS)) {
                Inprocesscount++;
            }
            if (leedmodel.getStatus().equalsIgnoreCase(Constant.STATUS_REJECTED)) {
                Rejectcount++;
            }

        }

        txtHLcount.setText(String.valueOf("("+HLcount+")"));
        txtBTcount.setText(String.valueOf("("+BTcount+")"));
        txtLAPcount.setText(String.valueOf("("+LAPcount+")"));
        txtApprovedcount.setText(String.valueOf(Approvedcount));
        txtInProcesscount.setText(String.valueOf(Inprocesscount));
        txtRejectCount.setText(String.valueOf(Rejectcount));
        txtLeadsSummarycount.setText(String.valueOf("("+leedsCount+")"));
        txtLeadscount.setText(String.valueOf(leedsCount));

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