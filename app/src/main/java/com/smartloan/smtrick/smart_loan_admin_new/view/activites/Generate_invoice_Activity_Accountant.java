package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

public class Generate_invoice_Activity_Accountant extends AppCompatActivity implements OnItemSelectedListener {
    AppSharedPreference appSharedPreference;
    Button btnsend;
    EditText etagentid;
    EditText etagentname;
    EditText etapploan;
    EditText etbank;
    EditText etcname;
    EditText etcom;
    EditText etdate;
    EditText etdiss;
    EditText etgst;
    EditText etinvoiceid;
    EditText etleadid;
    EditText etloanammount;
    EditText etloantype;
    LeedRepository leedRepository;
    LeedsModel leedsModel;
    ProgressDialogClass progressDialogClass;
    String said;
    String saname;
    String sapamt;
    String sbank;
    String scname;
    String scomm;
    String sdate;
    String sdiss;
    String sgst;
    String sinvoice;
    String sleadid;
    String sloanammount;
    EditText txtleadid;

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Generate_invoice_Activity_Accountant$1 */
    class C08061 implements OnClickListener {
        C08061() {
        }

        public void onClick(View v) {
            Generate_invoice_Activity_Accountant generate_invoice_Activity_Accountant = Generate_invoice_Activity_Accountant.this;
            generate_invoice_Activity_Accountant.sleadid = generate_invoice_Activity_Accountant.txtleadid.getText().toString();
            generate_invoice_Activity_Accountant = Generate_invoice_Activity_Accountant.this;
            generate_invoice_Activity_Accountant.sdate = generate_invoice_Activity_Accountant.etdate.getText().toString();
            generate_invoice_Activity_Accountant = Generate_invoice_Activity_Accountant.this;
            generate_invoice_Activity_Accountant.scname = generate_invoice_Activity_Accountant.etcname.getText().toString();
            generate_invoice_Activity_Accountant = Generate_invoice_Activity_Accountant.this;
            generate_invoice_Activity_Accountant.sbank = generate_invoice_Activity_Accountant.etbank.getText().toString();
            generate_invoice_Activity_Accountant = Generate_invoice_Activity_Accountant.this;
            generate_invoice_Activity_Accountant.sloanammount = generate_invoice_Activity_Accountant.etloanammount.getText().toString();
            generate_invoice_Activity_Accountant = Generate_invoice_Activity_Accountant.this;
            generate_invoice_Activity_Accountant.sdiss = generate_invoice_Activity_Accountant.etdiss.getText().toString();
            generate_invoice_Activity_Accountant = Generate_invoice_Activity_Accountant.this;
            generate_invoice_Activity_Accountant.sgst = generate_invoice_Activity_Accountant.etgst.getText().toString();
            generate_invoice_Activity_Accountant = Generate_invoice_Activity_Accountant.this;
            generate_invoice_Activity_Accountant.scomm = generate_invoice_Activity_Accountant.etcom.getText().toString();
            generate_invoice_Activity_Accountant = Generate_invoice_Activity_Accountant.this;
            generate_invoice_Activity_Accountant.said = generate_invoice_Activity_Accountant.etagentid.getText().toString();
            generate_invoice_Activity_Accountant = Generate_invoice_Activity_Accountant.this;
            generate_invoice_Activity_Accountant.saname = generate_invoice_Activity_Accountant.etagentname.getText().toString();
            generate_invoice_Activity_Accountant = Generate_invoice_Activity_Accountant.this;
            generate_invoice_Activity_Accountant.sapamt = generate_invoice_Activity_Accountant.etapploan.getText().toString();
            generate_invoice_Activity_Accountant = Generate_invoice_Activity_Accountant.this;
            generate_invoice_Activity_Accountant.sinvoice = generate_invoice_Activity_Accountant.etinvoiceid.getText().toString();
            generate_invoice_Activity_Accountant = Generate_invoice_Activity_Accountant.this;
            generate_invoice_Activity_Accountant.updateLeadDetails(generate_invoice_Activity_Accountant.leedsModel);
            Toast.makeText(Generate_invoice_Activity_Accountant.this, "send invoice Successfully", 0).show();
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Generate_invoice_Activity_Accountant$2 */
    class C09242 extends CallBack {
        C09242() {
        }

        public void onSuccess(Object object) {
            Toast.makeText(Generate_invoice_Activity_Accountant.this, "Send Invoice Successfully", 0).show();
            Generate_invoice_Activity_Accountant.this.progressDialogClass.dismissDialog();
        }

        public void onError(Object object) {
            Generate_invoice_Activity_Accountant.this.progressDialogClass.dismissDialog();
            Toast.makeText(Generate_invoice_Activity_Accountant.this, "invoice fail", 0).show();
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.generateinvoice_accountant);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        this.leedsModel = (LeedsModel) getIntent().getSerializableExtra(Constant.LEED_MODEL);
        this.progressDialogClass = new ProgressDialogClass(this);
        this.leedRepository = new LeedRepositoryImpl();
        this.appSharedPreference = new AppSharedPreference(this);
        this.txtleadid = (EditText) findViewById(R.id.txtleadid1);
        this.etdate = (EditText) findViewById(R.id.txtdate1);
        this.etcname = (EditText) findViewById(R.id.txtcname1);
        this.etbank = (EditText) findViewById(R.id.txtbank1);
        this.etloanammount = (EditText) findViewById(R.id.txtloanammount1);
        this.etdiss = (EditText) findViewById(R.id.txtdiss1);
        this.etgst = (EditText) findViewById(R.id.txtgst1);
        this.etcom = (EditText) findViewById(R.id.txtcomm1);
        this.btnsend = (Button) findViewById(R.id.buttonupdate);
        this.etloantype = (EditText) findViewById(R.id.txtloantype1);
        this.etapploan = (EditText) findViewById(R.id.txtapprovedloanvalue);
        this.etagentid = (EditText) findViewById(R.id.txtagentidvalue);
        this.etagentname = (EditText) findViewById(R.id.txtagentnamevalue);
        this.etinvoiceid = (EditText) findViewById(R.id.txtinvoiceidvalue);
        getdata();
        this.btnsend.setOnClickListener(new C08061());
    }

    private void updateLeadDetails(LeedsModel leedsModel) {
        generateinvoice(leedsModel.getLeedId());
    }

    private void getdata() {
        try {
            String leedid = leedsModel.getLeedId();
            String cname = leedsModel.getCustomerName();
            String caddress = leedsModel.getAddress();
            String contact = leedsModel.getMobileNumber();
            String loantype = leedsModel.getLoanType();
            String occupation = leedsModel.getOccupation();
            String loanamount = leedsModel.getExpectedLoanAmount();
            String agentid = leedsModel.getAgentId();
            String leednumber = leedsModel.getLeedNumber();
            Long ldatetime = leedsModel.getCreatedDateTimeLong();
            String sdatetime = Long.toString(ldatetime.longValue());
            String income = leedsModel.getincome();
            String description = leedsModel.getdescription();
            String panno = leedsModel.getPanCardNumber();
            String birthdate = leedsModel.getDateOfBirth();
            String officeaddress = leedsModel.getofficeAdderess();
            String propertyaddress = leedsModel.getpropertyAddress();
            String altmobileno = leedsModel.getAlternetMobileNumber();
            String adhaar = leedsModel.getadharNo();
            leedid = leedsModel.getAgentName();
            occupation = leedsModel.getBankName();
            if (leednumber != null) {
                txtleadid.setText(leednumber);
            }
            if (cname != null) {
                etcname.setText(cname);
            }
            if (caddress != null) {
                etbank.setText(occupation);
            }
            if (contact != null) {
                etloanammount.setText(loanamount);
            }
            if (loantype != null) {
                etagentid.setText(agentid);
            }
            if (income != null) {
                etloantype.setText(loantype);
            }
            if (loanamount != null) {
                etagentname.setText(leedid);
            }
            if (loanamount != null) {
                etdate.setText(sdatetime);
            }
        } catch (Exception e) {
        }
    }

    private void generateinvoice(String leedId) {
        LeedsModel leedsModel = fillUserModel();
        if (validate(leedsModel)) {
            this.progressDialogClass.showDialog(getString(R.string.leed_In_loading), getString(R.string.PLEASE_WAIT));
            this.leedRepository.createInvoice(leedsModel, new C09242());
        }
    }

    private LeedsModel fillUserModel() {
        LeedsModel leedsModel = new LeedsModel();
        leedsModel.setLeedId(Constant.INVOICE_TABLE_REF.push().getKey());
        leedsModel.setCustomerName(this.scname);
        leedsModel.setBankName(this.sbank);
        leedsModel.setApprovedLoan(this.sloanammount);
        leedsModel.setdissbussloan(this.sdiss);
        leedsModel.setPayout(this.scomm);
        leedsModel.setgst(this.sgst);
        leedsModel.setdissbussloan(this.sdiss);
        leedsModel.setPayout(this.scomm);
        leedsModel.setAgentId(this.said);
        leedsModel.setAgentName(this.saname);
        leedsModel.setApprovedLoan(this.sapamt);
        return leedsModel;
    }

    private boolean validate(LeedsModel leedsModel) {
        return true;
    }

    public void onItemSelected(AdapterView<?> adapterView, View arg1, int position, long id) {
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
