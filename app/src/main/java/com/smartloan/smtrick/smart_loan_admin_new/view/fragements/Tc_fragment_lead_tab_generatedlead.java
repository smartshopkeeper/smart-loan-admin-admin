package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;


import androidx.databinding.DataBindingUtil;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.RecyclerListener.RecyclerTouchListener;
import com.smartloan.smtrick.smart_loan_admin_new.RecyclerListener.RecyclerTouchListener.ClickListener;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.TcFragmentLeadTabGeneratedleadBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.singleton.AppSingleton;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.TelecallerGeneratedLeedsAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;
import java.util.ArrayList;

public class Tc_fragment_lead_tab_generatedlead extends Fragment {
    AppSharedPreference appSharedPreference;
    AppSingleton appSingleton;
    long fromDate;
    int fromDay;
    int fromMonth;
    int fromYear;
    LeedRepository leedRepository;
    ArrayList<LeedsModel> leedsModelArrayList;
    ArrayList<LeedsModel> leedsModelArrayList1;
    ProgressDialogClass progressDialogClass;
    TcFragmentLeadTabGeneratedleadBinding tcFragmentLeadTabGeneratedleadBinding;
    TelecallerGeneratedLeedsAdapter telecallerLeedsAdapter;
    long toDate;
    int toDay;
    int toMonth;
    int toYear;
    EditText Search;

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            // load data here
        }else{
            // fragment is no longer visible
        }
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (this.tcFragmentLeadTabGeneratedleadBinding == null) {
            this.tcFragmentLeadTabGeneratedleadBinding = (TcFragmentLeadTabGeneratedleadBinding) DataBindingUtil.inflate(inflater, R.layout.tc_fragment_lead_tab_generatedlead, container, false);
            this.progressDialogClass = new ProgressDialogClass(getActivity());
            this.appSingleton = AppSingleton.getInstance(getActivity());
            this.leedRepository = new LeedRepositoryImpl();
            this.appSharedPreference = new AppSharedPreference(getActivity());
            leedsModelArrayList = new ArrayList<>();
            leedsModelArrayList1 = new ArrayList<>();
            this.tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.setHasFixedSize(true);
            this.tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.setLayoutManager(new LinearLayoutManager(getActivity()));
            this.tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.setItemAnimator(new DefaultItemAnimator());
            this.tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.addItemDecoration(new DividerItemDecoration(getContext(), 1));
            this.tcFragmentLeadTabGeneratedleadBinding.txtsearch1.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    if (!s.toString().isEmpty()) {
                        setAdapter(s.toString());
                    } else {
                        /*
                         * Clear the list when editText is empty
                         * */
                        leedsModelArrayList.clear();
                        tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.removeAllViews();

                    }
                }
            });
            getteLeed();
        }
        return this.tcFragmentLeadTabGeneratedleadBinding.getRoot();
    }

    private void setAdapter(final String toString) {
        this.progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));
        leedsModelArrayList1.clear();
        this.leedRepository.readLeedsByStatus(Constant.STATUS_GENERATED, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {

                    leedsModelArrayList = (ArrayList) object;
                    for (LeedsModel leedsModel: leedsModelArrayList
                         ) {
                        if (leedsModel.getCustomerName().toLowerCase().contains(toString)){
                            leedsModelArrayList1.add(leedsModel);
                        }

                    }
                    serAdapter(leedsModelArrayList1);
                }
                progressDialogClass.dismissDialog();
            }

            @Override
            public void onError(Object object) {
                progressDialogClass.dismissDialog();

            }
        });

    }

    private LeedsModel getModel(int position) {
        ArrayList arrayList = this.leedsModelArrayList;
        return (LeedsModel) arrayList.get((arrayList.size() - 1) - position);
    }

    private void onClickListner() {
        this.tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), this.tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                LeedsModel leedsModel = getModel(position);

                Bundle bundle = new Bundle();
                bundle.putSerializable(Constant.LEED_MODEL, leedsModel);// Put anything what you want

                Updatelead_Fragment fragment2 = new Updatelead_Fragment();
                fragment2.setArguments(bundle);

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.detailContainer,  fragment2);
                ft.commit();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    private void getteLeed() {
        this.progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));
        this.leedRepository.readLeedsByStatus(Constant.STATUS_GENERATED, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    leedsModelArrayList = (ArrayList) object;
                    serAdapter(leedsModelArrayList);
                }
                progressDialogClass.dismissDialog();
            }

            @Override
            public void onError(Object object) {
                progressDialogClass.dismissDialog();

            }
        });
    }

    private void serAdapter(ArrayList<LeedsModel> leedsModels) {
        if (leedsModels == null) {
            return;
        }
        if (this.telecallerLeedsAdapter == null) {
            this.telecallerLeedsAdapter = new TelecallerGeneratedLeedsAdapter(getActivity(), leedsModels);
            this.tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.setAdapter(this.telecallerLeedsAdapter);
            onClickListner();
            return;
        }
        ArrayList<LeedsModel> leedsModelArrayList = new ArrayList();
        leedsModelArrayList.addAll(leedsModels);
        this.telecallerLeedsAdapter.reload(leedsModelArrayList);
    }
}
