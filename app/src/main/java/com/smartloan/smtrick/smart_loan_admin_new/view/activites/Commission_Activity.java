package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.TelecallerLeedsAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.util.ArrayList;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.STATUS_DISBUSED;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.STATUS_IN_PROGRESS;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.STATUS_SUBMITED;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.STATUS_VERIFIED;

public class Commission_Activity extends AppCompatActivity {

    RecyclerView recyclerViewDisbused;
    LeedRepository leedRepository;
    ProgressDialogClass progressDialogClass;
    ArrayList<LeedsModel> leedsModelArrayList;
    TelecallerLeedsAdapter telecallerLeedsAdapter;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_commission_);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_commission);
        setSupportActionBar(toolbar);
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        leedRepository = new LeedRepositoryImpl();
        leedsModelArrayList = new ArrayList<>();
        progressDialogClass = new ProgressDialogClass(this);
        recyclerViewDisbused = (RecyclerView) findViewById(R.id.recycler_view_disbused_leeds);

        getDisbusedLeeds();

    }

    private void getDisbusedLeeds() {
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
                Utility.showLongMessage(getApplication(), getString(R.string.server_error));
            }
        });
    }

    private void serAdapter(ArrayList<LeedsModel> leedsModels) {
        if (leedsModels != null) {
            if (telecallerLeedsAdapter == null) {
                telecallerLeedsAdapter = new TelecallerLeedsAdapter(getApplicationContext(), leedsModels);
                recyclerViewDisbused.setAdapter(telecallerLeedsAdapter);
                recyclerViewDisbused.setHasFixedSize(true);
                recyclerViewDisbused.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//                onClickListner();
            } else {
                ArrayList<LeedsModel> leedsModelArrayList = new ArrayList<>();
                leedsModelArrayList.addAll(leedsModels);
                telecallerLeedsAdapter.reload(leedsModelArrayList);
            }
        }
    }
}
