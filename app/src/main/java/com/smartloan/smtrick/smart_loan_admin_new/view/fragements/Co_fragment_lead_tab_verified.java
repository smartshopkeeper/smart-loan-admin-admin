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


import com.smartloan.smtrick.smart_loan_admin_new.databinding.CoFragmentLeadTabVerifiedBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.singleton.AppSingleton;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.Co_Verified_LeedsAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.TelecallerLeedsAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.util.ArrayList;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.STATUS_VERIFIED;

public class Co_fragment_lead_tab_verified extends Fragment {

    Co_Verified_LeedsAdapter co_verified_leedsAdapter;
    LeedRepository leedRepository;
    AppSingleton appSingleton;
    ProgressDialogClass progressDialogClass;
    AppSharedPreference appSharedPreference;
    CoFragmentLeadTabVerifiedBinding coFragmentLeadTabVerifiedBinding;
    int fromYear, fromMonth, fromDay;
    int toYear, toMonth, toDay;
    long fromDate, toDate;
    ArrayList<LeedsModel> leedsModelArrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (coFragmentLeadTabVerifiedBinding == null) {
            coFragmentLeadTabVerifiedBinding = DataBindingUtil.inflate(inflater, R.layout.co_fragment_lead_tab_verified, container, false);
            progressDialogClass = new ProgressDialogClass(getActivity());
            appSingleton = AppSingleton.getInstance(getActivity());
            leedRepository = new LeedRepositoryImpl();
            appSharedPreference = new AppSharedPreference(getActivity());
            coFragmentLeadTabVerifiedBinding.recyclerViewLeeds.setHasFixedSize(true);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
            coFragmentLeadTabVerifiedBinding.recyclerViewLeeds.setLayoutManager(layoutManager);
            coFragmentLeadTabVerifiedBinding.recyclerViewLeeds.setItemAnimator(new DefaultItemAnimator());
            coFragmentLeadTabVerifiedBinding.recyclerViewLeeds.addItemDecoration(new DividerItemDecoration(getContext(),
                    DividerItemDecoration.VERTICAL));
            getteLeed();
        }
        return coFragmentLeadTabVerifiedBinding.getRoot();
    }

    private LeedsModel getModel(int position) {
        return leedsModelArrayList.get(leedsModelArrayList.size() - 1 - position);
    }

    private void getteLeed() {
        progressDialogClass.showDialog(this.getString(R.string.loading), this.getString(R.string.PLEASE_WAIT));
        leedRepository.readLeedsByStatus(STATUS_VERIFIED, new CallBack() {
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
        coFragmentLeadTabVerifiedBinding.recyclerViewLeeds.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), coFragmentLeadTabVerifiedBinding.recyclerViewLeeds, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                LeedsModel leedsModel = getModel(position);
//                Intent intent = new Intent(getActivity(), View_Leed_Details_Activity.class);
//                intent.putExtra(LEED_MODEL, leedsModel);
//                startActivity(intent);

                Bundle bundle = new Bundle();
                bundle.putSerializable(Constant.LEED_MODEL, leedsModel);// Put anything what you want
                Co_View_Lead_Details_Fragment fragment2 = new Co_View_Lead_Details_Fragment();
                fragment2.setArguments(bundle);
                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.detailContainer, fragment2);
                ft.commit();
            }

            @Override
            public void onLongClick(View view, int position) {
            }

        }));
    }

    private void serAdapter(ArrayList<LeedsModel> leedsModels) {
        if (leedsModels != null) {
            if (co_verified_leedsAdapter == null) {
                co_verified_leedsAdapter = new Co_Verified_LeedsAdapter(getActivity(), leedsModels);
                coFragmentLeadTabVerifiedBinding.recyclerViewLeeds.setAdapter(co_verified_leedsAdapter);
//                postAndNotifyAdapter(new Handler(), tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds);

                onClickListner();
            } else {
                ArrayList<LeedsModel> leedsModelArrayList = new ArrayList<>();
                leedsModelArrayList.addAll(leedsModels);
                co_verified_leedsAdapter.reload(leedsModelArrayList);
            }
        }
    }


//    protected void postAndNotifyAdapter(final Handler handler, final RecyclerView recyclerView) {
//        handler.post(new Runnable() {
//            @Override
//            public void run() {
//                if (!recyclerView.isComputingLayout()) {
//                    // This will call first item by calling "performClick()" of view.
//                    ((TelecallerLeedsAdapter.TelecallerLeedsViewHolder) recyclerView.findViewHolderForLayoutPosition(0)).mView.performClick();
//                } else {
//                    postAndNotifyAdapter(handler, recyclerView);
//                }
//            }
//        });
//    }
}
