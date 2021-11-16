package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.RecyclerListener.RecyclerTouchListener;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.TcFragmentLeadTabGeneratedleadBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.singleton.AppSingleton;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.Bank_Submit_Update_Activity;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.SalesLeedsAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;
import java.util.ArrayList;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.LEED_MODEL;

public class Tc_fragment_lead_tab_acceptedleads extends Fragment {
    AppSharedPreference appSharedPreference;
    AppSingleton appSingleton;
    long fromDate;
    int fromDay;
    int fromMonth;
    int fromYear;
    LeedRepository leedRepository;
    ArrayList<LeedsModel> leedsModelArrayList;
    ProgressDialogClass progressDialogClass;
    TcFragmentLeadTabGeneratedleadBinding tcFragmentLeadTabGeneratedleadBinding;
    SalesLeedsAdapter telecallerLeedsAdapter;
    long toDate;
    int toDay;
    int toMonth;
    int toYear;

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Tc_fragment_lead_tab_acceptedleads$1 */
//    class C09511 extends CallBack {
//        C09511() {
//        }
//
//        public void onSuccess(Object object) {
//            if (object != null) {
//                Tc_fragment_lead_tab_acceptedleads tc_fragment_lead_tab_acceptedleads = Tc_fragment_lead_tab_acceptedleads.this;
//                tc_fragment_lead_tab_acceptedleads.leedsModelArrayList = (ArrayList) object;
//                tc_fragment_lead_tab_acceptedleads.serAdapter(tc_fragment_lead_tab_acceptedleads.leedsModelArrayList);
//            }
//            Tc_fragment_lead_tab_acceptedleads.this.progressDialogClass.dismissDialog();
//        }
//
//        public void onError(Object object) {
//            Tc_fragment_lead_tab_acceptedleads.this.progressDialogClass.dismissDialog();
//        }
//    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.tcFragmentLeadTabGeneratedleadBinding == null) {
            this.tcFragmentLeadTabGeneratedleadBinding = (TcFragmentLeadTabGeneratedleadBinding) DataBindingUtil.inflate(inflater, R.layout.tc_fragment_lead_tab_generatedlead, container, false);
            this.progressDialogClass = new ProgressDialogClass(getActivity());
            this.appSingleton = AppSingleton.getInstance(getActivity());
            this.leedRepository = new LeedRepositoryImpl();
            this.appSharedPreference = new AppSharedPreference(getActivity());
            this.tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.setHasFixedSize(true);
            this.tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.setLayoutManager(new LinearLayoutManager(getActivity()));
            this.tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.setItemAnimator(new DefaultItemAnimator());
            this.tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.addItemDecoration(new DividerItemDecoration(getContext(), 1));
            getteLeed();
        }
        return this.tcFragmentLeadTabGeneratedleadBinding.getRoot();
    }

    private LeedsModel getModel(int position) {
        ArrayList arrayList = this.leedsModelArrayList;
        return (LeedsModel) arrayList.get((arrayList.size() - 1) - position);
    }

    private void getteLeed() {
        this.progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));
        this.leedRepository.readLeedsByStatus(Constant.STATUS_BANK_APPROVED, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    Tc_fragment_lead_tab_acceptedleads tc_fragment_lead_tab_acceptedleads = Tc_fragment_lead_tab_acceptedleads.this;
                    tc_fragment_lead_tab_acceptedleads.leedsModelArrayList = (ArrayList) object;
                    tc_fragment_lead_tab_acceptedleads.serAdapter(tc_fragment_lead_tab_acceptedleads.leedsModelArrayList);
                }
                Tc_fragment_lead_tab_acceptedleads.this.progressDialogClass.dismissDialog();


            }

            @Override
            public void onError(Object object) {

                Tc_fragment_lead_tab_acceptedleads.this.progressDialogClass.dismissDialog();
            }
        });
    }

    private void serAdapter(ArrayList<LeedsModel> leedsModels) {
        if (leedsModels == null) {
            return;
        }
        if (this.telecallerLeedsAdapter == null) {
            this.telecallerLeedsAdapter = new SalesLeedsAdapter(getActivity(), leedsModels);
            this.tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.setAdapter(this.telecallerLeedsAdapter);
            onClickListner();
            return;
        }
        ArrayList<LeedsModel> leedsModelArrayList = new ArrayList();
        leedsModelArrayList.addAll(leedsModels);
        this.telecallerLeedsAdapter.reload(leedsModelArrayList);
    }

    private void onClickListner() {
        tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                LeedsModel leedsModel = getModel(position);
                Intent intent = new Intent(getActivity(), Bank_Submit_Update_Activity.class);
                intent.putExtra(LEED_MODEL, leedsModel);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
            }

        }));
    }
}
