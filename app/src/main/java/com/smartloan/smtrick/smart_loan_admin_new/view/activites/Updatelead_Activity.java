package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

public class Updatelead_Activity extends AppCompatActivity implements OnItemSelectedListener {
    AppSharedPreference appSharedPreference;
    Button btcancel;
    Button btnupdatenext;
    Button btupdate;
    Button btverify;
    String cPartner;
    String lGenby;
    LeedRepository leedRepository;
    LeedsModel leedsModel;
    ArrayList<LeedsModel> leedsModelArrayList;
    ProgressDialogClass progressDialogClass;
    SimpleDateFormat sfd;
    Spinner spinloantype;
    String sploantype;
    TextView txtgeneratedby;
    TextView txtldate;
    TextView txtleadid;
    TextView txtleadidtop;
    TextView txttime;

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Updatelead_Activity$1 */
   class C08401 implements OnClickListener {
        public C08401() {

        }

        public void onClick(View v) {
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Updatelead_Activity$2 */
    class C08412 implements OnClickListener {
        C08412() {
        }

        public void onClick(View v) {
            setLeedStatus(leedsModel);
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Updatelead_Activity$3 */
    class C08423 implements OnClickListener {
        C08423() {
        }

        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(), MainActivity_telecaller.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Updatelead_Activity$4 */
    class C08434 implements OnClickListener {
        C08434() {
        }

        public void onClick(View v) {
            updateLeadDetails(leedsModel);
            Toast.makeText(getApplicationContext(), "Lead Update Successfully", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(), TL_Updatelead_C_Details_Activity.class);
            i.putExtra(Constant.LEED_MODEL, leedsModel);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Updatelead_Activity$5 */
    class C09325 extends CallBack {
        C09325() {
        }

        public void onSuccess(Object object) {
            progressDialogClass.dismissDialog();
        }

        public void onError(Object object) {
            progressDialogClass.dismissDialog();
            Context context = getApplicationContext();
            Utility.showLongMessage(context, context.getString(R.string.server_error));
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatelead_activity);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        leedsModel = (LeedsModel) getIntent().getSerializableExtra(Constant.LEED_MODEL);
        progressDialogClass = new ProgressDialogClass(this);
        leedRepository = new LeedRepositoryImpl();
        appSharedPreference = new AppSharedPreference(this);
        String[] loanType = new String[]{"HOME LOAN", "LOAN AGAINST PROPERTY"};
        btupdate = (Button) findViewById(R.id.buttonupdate);
        btverify = (Button) findViewById(R.id.buttonverify);
        btcancel = (Button) findViewById(R.id.buttoncancel);
        btnupdatenext = (Button) findViewById(R.id.buttonupdatenext);
        txtldate = (TextView) findViewById(R.id.txtdate1);
        txttime = (TextView) findViewById(R.id.txtleedtime1);
        txtleadid = (TextView) findViewById(R.id.txtleadidvalue);
        spinloantype = (Spinner) findViewById(R.id.sploantype1);
        txtgeneratedby = (TextView) findViewById(R.id.txtagentid1);
        txtleadidtop = (TextView) findViewById(R.id.textheader);
        spinloantype.setOnItemSelectedListener(this);
        ArrayAdapter<String> spinnerArrayAdapterloantype = new ArrayAdapter(this, R.layout.sppinner_layout_listitem, loanType);
        spinnerArrayAdapterloantype.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinloantype.setAdapter(spinnerArrayAdapterloantype);
        getdata();
        btupdate.setOnClickListener(new C08401());
        btverify.setOnClickListener(new C08412());
        btcancel.setOnClickListener(new C08423());
        btnupdatenext.setOnClickListener(new C08434());
    }

    private void getdata() {
        try {
            String leedid = leedsModel.getLeedNumber();
            String agentname = leedsModel.getAgentName();
            Long ldatetime = leedsModel.getCreatedDateTimeLong();
            Long time = leedsModel.getCreatedDateTimeLong();
            spinloantype.setSelection(((ArrayAdapter) spinloantype.getAdapter()).getPosition(leedsModel.getLoanType()));
            if (ldatetime != null) {
                txtldate.setText(Utility.convertMilliSecondsToFormatedDate(leedsModel.getCreatedDateTimeLong().longValue(), Constant.GLOBAL_DATE_FORMATE));
            }
            if (time != null) {
                txttime.setText(Utility.convertMilliSecondsToFormatedDate(leedsModel.getCreatedDateTimeLong().longValue(), "hh:mm a"));
            }
            if (leedid != null) {
                txtleadid.setText(leedid);
                txtleadidtop.setText(leedid);
            }
            if (agentname != null) {
                txtgeneratedby.setText(agentname);
            }
        } catch (Exception e) {
        }
    }

    private void setLeedStatus(LeedsModel leedsModel) {
        leedsModel.setStatus(Constant.STATUS_VERIFIED);
        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap1());
    }

    private void updateLeadDetails(LeedsModel leedsModel) {
        leedsModel.setLoanType(sploantype);
        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap());
    }

    private void updateLeed(String leedId, Map leedsMap) {
        progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));
        leedRepository.updateLeed(leedId, leedsMap, new C09325());
    }

    public void onItemSelected(AdapterView<?> adapterView, View arg1, int position, long id) {
        sploantype = spinloantype.getSelectedItem().toString();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
