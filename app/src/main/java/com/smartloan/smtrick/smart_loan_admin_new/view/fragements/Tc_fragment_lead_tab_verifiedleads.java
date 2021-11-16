package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.app.ProgressDialog;
import androidx.databinding.DataBindingUtil;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.TcFragmentLeadTabGeneratedleadBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.singleton.AppSingleton;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.TelecallerLeedsAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;
import java.util.ArrayList;

public class Tc_fragment_lead_tab_verifiedleads extends Fragment {
    AppSharedPreference appSharedPreference;
    AppSingleton appSingleton;
    LeedRepository leedRepository;
    ArrayList<LeedsModel> leedsModelArrayList;
    ProgressDialogClass progressDialogClass;
    TcFragmentLeadTabGeneratedleadBinding tcFragmentLeadTabGeneratedleadBinding;
    TelecallerLeedsAdapter telecallerLeedsAdapter;
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
//            getteLeed();
        }
        return this.tcFragmentLeadTabGeneratedleadBinding.getRoot();
    }

    private LeedsModel getModel(int position) {
        ArrayList arrayList = this.leedsModelArrayList;
        return (LeedsModel) arrayList.get((arrayList.size() - 1) - position);
    }

    private void getteLeed() {
//        this.progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));
        this.leedRepository.readLeedsByStatus(Constant.STATUS_VERIFIED, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    leedsModelArrayList = (ArrayList) object;
                    serAdapter(leedsModelArrayList);
                }
            }

            @Override
            public void onError(Object object) {

            }
        });
    }

    private void serAdapter(ArrayList<LeedsModel> leedsModels) {
        if (leedsModels == null) {
            return;
        }
        if (this.telecallerLeedsAdapter == null) {
            this.telecallerLeedsAdapter = new TelecallerLeedsAdapter(getActivity(), leedsModels);
            this.tcFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.setAdapter(this.telecallerLeedsAdapter);
            return;
        }
        ArrayList<LeedsModel> leedsModelArrayList = new ArrayList();
        leedsModelArrayList.addAll(leedsModels);
        this.telecallerLeedsAdapter.reload(leedsModelArrayList);
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
