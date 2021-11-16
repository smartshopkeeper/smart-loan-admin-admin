package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.app.ProgressDialog;
import androidx.databinding.DataBindingUtil;
import android.os.AsyncTask;
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
import com.smartloan.smtrick.smart_loan_admin_new.databinding.CoFragmentLeadTabDisbussleadBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.singleton.AppSingleton;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.AccountantDisbussLeedsAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.CoDisbussLeedsAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.util.ArrayList;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.STATUS_DISBUSED;

public class Co_fragment_lead_tab_Disbussed extends Fragment {

    CoDisbussLeedsAdapter telecallerLeedsAdapter;
    LeedRepository leedRepository;
    AppSingleton appSingleton;
    ProgressDialogClass progressDialogClass;
    AppSharedPreference appSharedPreference;
    CoFragmentLeadTabDisbussleadBinding coFragmentLeadTabDisbussleadBinding;
    int fromYear, fromMonth, fromDay;
    int toYear, toMonth, toDay;
    long fromDate, toDate;
    ArrayList<LeedsModel> leedsModelArrayList;
    private boolean _hasLoadedOnce= false;
    private ProgressDialog progress;

    @Override
    public void setUserVisibleHint(boolean isFragmentVisible_) {
        super.setUserVisibleHint(true);
        if (this.isVisible()) {
// we check that the fragment is becoming visible
            if (isFragmentVisible_ && !_hasLoadedOnce) {
                new Loaddata().execute();
                _hasLoadedOnce = true;
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (coFragmentLeadTabDisbussleadBinding == null) {
            coFragmentLeadTabDisbussleadBinding = DataBindingUtil.inflate(inflater, R.layout.co_fragment_lead_tab_disbusslead, container, false);
            progressDialogClass = new ProgressDialogClass(getActivity());
            appSingleton = AppSingleton.getInstance(getActivity());
            leedRepository = new LeedRepositoryImpl();
            appSharedPreference = new AppSharedPreference(getActivity());
            coFragmentLeadTabDisbussleadBinding.recyclerViewLeeds.setHasFixedSize(true);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
            coFragmentLeadTabDisbussleadBinding.recyclerViewLeeds.setLayoutManager(layoutManager);
            coFragmentLeadTabDisbussleadBinding.recyclerViewLeeds.setItemAnimator(new DefaultItemAnimator());
            coFragmentLeadTabDisbussleadBinding.recyclerViewLeeds.addItemDecoration(new DividerItemDecoration(getContext(),
                    DividerItemDecoration.VERTICAL));
//            getteLeed();
        }
        return coFragmentLeadTabDisbussleadBinding.getRoot();
    }

    private LeedsModel getModel(int position) {
        return leedsModelArrayList.get(leedsModelArrayList.size() - 1 - position);
    }

    private void getteLeed() {
//        progressDialogClass.showDialog(this.getString(R.string.loading), this.getString(R.string.PLEASE_WAIT));
        leedRepository.readLeedsByStatus(STATUS_DISBUSED, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    leedsModelArrayList = (ArrayList<LeedsModel>) object;
                    serAdapter(leedsModelArrayList);
                }
//                progressDialogClass.dismissDialog();
            }

            @Override
            public void onError(Object object) {
//                progressDialogClass.dismissDialog();
                Utility.showLongMessage(getActivity(), getString(R.string.server_error));
            }
        });
    }

    private void onClickListner() {
        coFragmentLeadTabDisbussleadBinding.recyclerViewLeeds.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), coFragmentLeadTabDisbussleadBinding.recyclerViewLeeds, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                LeedsModel leedsModel = getModel(position);

                Bundle bundle = new Bundle();
                bundle.putSerializable(Constant.LEED_MODEL, leedsModel);// Put anything what you want
                Co_View_Disbussed_Lead_Details_Fragment fragment2 = new Co_View_Disbussed_Lead_Details_Fragment();
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

    private void serAdapter(ArrayList<LeedsModel> leedsModels) {
        if (leedsModels != null) {
            if (telecallerLeedsAdapter == null) {
                telecallerLeedsAdapter = new CoDisbussLeedsAdapter(getActivity(), leedsModels);
                coFragmentLeadTabDisbussleadBinding.recyclerViewLeeds.setAdapter(telecallerLeedsAdapter);
//                postAndNotifyAdapter(new Handler(), tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds);

                onClickListner();
            } else {
                ArrayList<LeedsModel> leedsModelArrayList = new ArrayList<>();
                leedsModelArrayList.addAll(leedsModels);
                telecallerLeedsAdapter.reload(leedsModelArrayList);
            }
        }
    }

    private class Loaddata extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress=new ProgressDialog(getContext());
            progress.setMessage("Downloading Data");
            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        }

        @Override
        protected Void doInBackground(Void... arg0) {

            getteLeed();

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if(progress.isShowing())
            {
                progress.dismiss();
            }



        }
    }
}
