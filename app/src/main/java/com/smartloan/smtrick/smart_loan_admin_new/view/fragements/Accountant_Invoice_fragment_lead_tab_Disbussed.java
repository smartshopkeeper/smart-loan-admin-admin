package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.RecyclerListener.RecyclerTouchListener;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.AccountantFragmentAdminLeadTabDisbussleadBinding;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.AccountantInvoiceFragmentAdminLeadTabDisbussleadBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.singleton.AppSingleton;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.AccountantDisbussLeedsAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.AccountantInvoiceDisbussLeedsAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.util.ArrayList;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.STATUS_DISBUSED;

public class Accountant_Invoice_fragment_lead_tab_Disbussed extends Fragment {

    AccountantInvoiceDisbussLeedsAdapter telecallerLeedsAdapter;
    LeedRepository leedRepository;
    AppSingleton appSingleton;
    ProgressDialogClass progressDialogClass;
    AppSharedPreference appSharedPreference;
    AccountantInvoiceFragmentAdminLeadTabDisbussleadBinding accountantInvoiceFragmentAdminLeadTabDisbussleadBinding;
    int fromYear, fromMonth, fromDay;
    int toYear, toMonth, toDay;
    long fromDate, toDate;
    ArrayList<LeedsModel> leedsModelArrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (accountantInvoiceFragmentAdminLeadTabDisbussleadBinding == null) {
            accountantInvoiceFragmentAdminLeadTabDisbussleadBinding = DataBindingUtil.inflate(inflater, R.layout.accountant_invoice_fragment_admin_lead_tab_disbusslead, container, false);
            progressDialogClass = new ProgressDialogClass(getActivity());
            appSingleton = AppSingleton.getInstance(getActivity());
            leedRepository = new LeedRepositoryImpl();
            appSharedPreference = new AppSharedPreference(getActivity());
            accountantInvoiceFragmentAdminLeadTabDisbussleadBinding.recyclerViewLeeds.setHasFixedSize(true);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
            accountantInvoiceFragmentAdminLeadTabDisbussleadBinding.recyclerViewLeeds.setLayoutManager(layoutManager);
            accountantInvoiceFragmentAdminLeadTabDisbussleadBinding.recyclerViewLeeds.setItemAnimator(new DefaultItemAnimator());
            accountantInvoiceFragmentAdminLeadTabDisbussleadBinding.recyclerViewLeeds.addItemDecoration(new DividerItemDecoration(getContext(),
                    DividerItemDecoration.VERTICAL));
            getteLeed();
        }
        return accountantInvoiceFragmentAdminLeadTabDisbussleadBinding.getRoot();
    }

    private LeedsModel getModel(int position) {
        return leedsModelArrayList.get(leedsModelArrayList.size() - 1 - position);
    }

    private void getteLeed() {
        progressDialogClass.showDialog(this.getString(R.string.loading), this.getString(R.string.PLEASE_WAIT));
        leedRepository.readLeedsByStatus(STATUS_DISBUSED, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    leedsModelArrayList = (ArrayList<LeedsModel>) object;
                    serAdapter(leedsModelArrayList);
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

    private void onClickListner() {
        accountantInvoiceFragmentAdminLeadTabDisbussleadBinding.recyclerViewLeeds.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), accountantInvoiceFragmentAdminLeadTabDisbussleadBinding.recyclerViewLeeds, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                LeedsModel leedsModel = getModel(position);

//                Bundle bundle = new Bundle();
//                bundle.putSerializable(Constant.LEED_MODEL, leedsModel);// Put anything what you want
//                View_Acct_DisbussLead_Details_Fragment fragment2 = new View_Acct_DisbussLead_Details_Fragment();
//                fragment2.setArguments(bundle);
//                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
//                ft.replace(R.id.detailContainer,  fragment2);
//                ft.commit();
            }

            @Override
            public void onLongClick(View view, int position) {
            }

        }));
    }

    private void serAdapter(ArrayList<LeedsModel> leedsModels) {
        if (leedsModels != null) {
            if (telecallerLeedsAdapter == null) {
                telecallerLeedsAdapter = new AccountantInvoiceDisbussLeedsAdapter(getActivity(), leedsModels);
                accountantInvoiceFragmentAdminLeadTabDisbussleadBinding.recyclerViewLeeds.setAdapter(telecallerLeedsAdapter);
//                postAndNotifyAdapter(new Handler(), tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds);

                onClickListner();
            } else {
                ArrayList<LeedsModel> leedsModelArrayList = new ArrayList<>();
                leedsModelArrayList.addAll(leedsModels);
                telecallerLeedsAdapter.reload(leedsModelArrayList);
            }
        }
    }
}
