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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
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
import java.util.Map;

public class Tl_Updatelead_incomedetails_Activity extends AppCompatActivity implements OnItemSelectedListener {
    RadioButton Remployed;
    RadioButton Rsalaried;
    RadioButton Rselfemployed;
    Spinner SPEMI;
    Spinner SPcompanytype;
    Spinner SPsalarytype;
    AppSharedPreference appSharedPreference;
    Button btcancel;
    Button btnupdatenext;
    Button btupdate;
    Button btverify;
    String cAgrreIncome;
    String cAnnualincome;
    String cAnual;
    String cAppointmentltr;
    String cBankstmt;
    String cBisunessagmt;
    String cBonus;
    String cCarloan;
    String cCarloanamt;
    String cCompanytype;
    String cConfermationltr;
    String cContractltr;
    String cCurrentbnkstmt;
    String cDept;
    String cDesignation;
    String cEMI;
    String cEcperience;
    String cEmployedtype;
    String cEmployerltr;
    String cExperinceltr;
    String cForm16;
    String cGrossslr;
    String cHomeloan;
    String cHomeloanamt;
    String cITR;
    String cIncentive;
    String cMonthly;
    String cNRAbankstmt;
    String cNetslr;
    String cOtherEMIdetails;
    String cOthercompany;
    String cOtherincome;
    String cOtherloan;
    String cOverbank;
    String cOvertime;
    String cPOA;
    String cPartnerdeed;
    String cPassport;
    String cPersonalloan;
    String cPersonalloanamt;
    String cQulification;
    String cRental;
    String cRentalincome;
    String cSalaried;
    String cSalaryType;
    String cSalarysleep;
    String cSavingbnkstmt;
    String cSelfEmployed;
    String cSocietyloan;
    String cSocietyloanamt;
    String cTenure;
    String cVisa;
    CheckBox chNREbankstatement;
    CheckBox chPOA;
    CheckBox chappointmentletter;
    CheckBox chbankstatement;
    CheckBox chbisunessagreement;
    CheckBox chcarloan;
    CheckBox chconfermationletter;
    CheckBox chcontractletter;
    CheckBox chcurrentbankstatement;
    CheckBox chemployerletter;
    CheckBox chexperieceletter;
    CheckBox chformno16;
    CheckBox chhomloan;
    CheckBox chitr;
    CheckBox chotherloan;
    CheckBox choverbankdetails;
    CheckBox chpartnersheepdeed;
    CheckBox chpasspoet;
    CheckBox chpersonalloan;
    CheckBox chqualification;
    CheckBox chsalarysleep;
    CheckBox chsavingacctstatement;
    CheckBox chsocietyloan;
    CheckBox chvisa;
    EditText edtagrreculturincom;
    EditText edtannualincome;
    EditText edtbonus;
    EditText edtdepartment;
    EditText edtdesignation;
    EditText edtexperience;
    EditText edtgrosssalary;
    EditText edtincentive;
    EditText edtnetsalary;
    EditText edtothercompany;
    EditText edtotheremidetails;
    EditText edtotherincome;
    EditText edtovertime;
    EditText edtrental;
    EditText edtrentalincome;
    EditText edttenure;
    RadioGroup groupRadioEmployed;
    RelativeLayout layoutothercompany;
    RelativeLayout layoutotheremi;
    LeedRepository leedRepository;
    String leedid;
    LeedsModel leedsModel;
    ProgressDialogClass progressDialogClass;
    Spinner spinloantype;
    String sploantype;
    EditText txtCarloan;
    EditText txtHomeloan;
    TextView txtgeneratedby;
    TextView txtldate;
    TextView txtleadid;
    EditText txtpersonalloan;
    EditText txtsocietyloan;

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Tl_Updatelead_incomedetails_Activity$1 */
    class C08331 implements OnCheckedChangeListener {
        C08331() {
        }

        public void onCheckedChanged(RadioGroup group, int checkedId) {
            Remployed = (RadioButton) findViewById(checkedId);
            cEmployedtype = Remployed.getText().toString();
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Tl_Updatelead_incomedetails_Activity$2 */
    class C08342 implements OnClickListener {
        C08342() {
        }

        public void onClick(View v) {
            if (groupRadioEmployed.getCheckedRadioButtonId() != -1) {
                RadioButton btn = (RadioButton) groupRadioEmployed.getChildAt(groupRadioEmployed.indexOfChild(groupRadioEmployed.findViewById(groupRadioEmployed.getCheckedRadioButtonId())));
                cEmployedtype = btn.getText().toString();
            }
            cCompanytype = SPcompanytype.getSelectedItem().toString();
            cSalaryType = SPsalarytype.getSelectedItem().toString();
            cOthercompany = edtothercompany.getText().toString();
            cTenure = edttenure.getText().toString();
            cEcperience = edtexperience.getText().toString();
           
            cDept = edtdepartment.getText().toString();
           
            cDesignation = edtdesignation.getText().toString();
           
            cGrossslr = edtgrosssalary.getText().toString();
           
            cNetslr = edtnetsalary.getText().toString();
           
            cOvertime = edtovertime.getText().toString();
           
            cIncentive = edtincentive.getText().toString();
           
            cBonus = edtbonus.getText().toString();
           
            cRentalincome = edtrentalincome.getText().toString();
           
            cAnnualincome = edtannualincome.getText().toString();
           
            cRental = edtrental.getText().toString();
           
            cAgrreIncome = edtagrreculturincom.getText().toString();
           
            cOtherincome = edtotherincome.getText().toString();
           
            cOtherEMIdetails = edtotheremidetails.getText().toString();
           
            cCarloanamt = txtCarloan.getText().toString();
           
            cHomeloanamt = txtHomeloan.getText().toString();
           
            cSocietyloanamt = txtsocietyloan.getText().toString();
           
            cPersonalloanamt = txtpersonalloan.getText().toString();
            if (chcarloan.isChecked()) {
               
                cCarloan = chcarloan.getText().toString();
            }
            if (chhomloan.isChecked()) {
               
                cHomeloan = chhomloan.getText().toString();
            }
            if (chsocietyloan.isChecked()) {
               
                cSocietyloan = chsocietyloan.getText().toString();
            }
            if (chpersonalloan.isChecked()) {
               
                cPersonalloan = chpersonalloan.getText().toString();
            }
            if (chotherloan.isChecked()) {
               
                cOtherloan = chotherloan.getText().toString();
            }
            if (chsalarysleep.isChecked()) {
               
                cSalarysleep = chsalarysleep.getText().toString();
            }
            if (chbankstatement.isChecked()) {
               
                cBankstmt = chbankstatement.getText().toString();
            }
            if (chformno16.isChecked()) {
               
                cForm16 = chformno16.getText().toString();
            }
            if (chappointmentletter.isChecked()) {
               
                cAppointmentltr = chappointmentletter.getText().toString();
            }
            if (chconfermationletter.isChecked()) {
               
                cConfermationltr = chconfermationletter.getText().toString();
            }
            if (chexperieceletter.isChecked()) {
               
                cExperinceltr = chexperieceletter.getText().toString();
            }
            if (chvisa.isChecked()) {
               
                cVisa = chvisa.getText().toString();
            }
            if (chpasspoet.isChecked()) {
               
                cPassport = chpasspoet.getText().toString();
            }
            if (chemployerletter.isChecked()) {
               
                cEmployerltr = chemployerletter.getText().toString();
            }
            if (chPOA.isChecked()) {
               
                cPOA = chPOA.getText().toString();
            }
            if (chNREbankstatement.isChecked()) {
               
                cNRAbankstmt = chNREbankstatement.getText().toString();
            }
            if (chcontractletter.isChecked()) {
               
                cContractltr = chcontractletter.getText().toString();
            }
            if (choverbankdetails.isChecked()) {
               
                cOverbank = choverbankdetails.getText().toString();
            }
            if (chitr.isChecked()) {
               
                cITR = chitr.getText().toString();
            }
            if (chcurrentbankstatement.isChecked()) {
               
                cCurrentbnkstmt = chcurrentbankstatement.getText().toString();
            }
            if (chsavingacctstatement.isChecked()) {
               
                cSavingbnkstmt = chsavingacctstatement.getText().toString();
            }
            if (chpartnersheepdeed.isChecked()) {
               
                cPartnerdeed = chpartnersheepdeed.getText().toString();
            }
            if (chbisunessagreement.isChecked()) {
               
                cBisunessagmt = chbisunessagreement.getText().toString();
            }
            if (chqualification.isChecked()) {
               
                cQulification = chqualification.getText().toString();
            }
           
            updateLeadDetails(leedsModel);
            Toast.makeText(getApplicationContext(), "Lead Update Successfully", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(getApplicationContext(), TL_Updatelead_property_Details_Activity.class);
            i.putExtra(Constant.LEED_MODEL, leedsModel);
            startActivity(i);
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Tl_Updatelead_incomedetails_Activity$3 */
    class C08353 implements CompoundButton.OnCheckedChangeListener {
        C08353() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                ShowotherEMI();
            } else {
                hideotherEMI();
            }
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Tl_Updatelead_incomedetails_Activity$4 */
    class C08364 implements CompoundButton.OnCheckedChangeListener {
        C08364() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
              txtCarloan.setVisibility(View.VISIBLE);
            } else {
                txtCarloan.setVisibility(View.INVISIBLE);
            }
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Tl_Updatelead_incomedetails_Activity$5 */
    class C08375 implements CompoundButton.OnCheckedChangeListener {
        C08375() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                txtHomeloan.setVisibility(View.VISIBLE);
            } else {
               txtHomeloan.setVisibility(View.INVISIBLE);
            }
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Tl_Updatelead_incomedetails_Activity$6 */
    class C08386 implements CompoundButton.OnCheckedChangeListener {
        C08386() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                txtsocietyloan.setVisibility(View.VISIBLE);
            } else {
                txtsocietyloan.setVisibility(View.INVISIBLE);
            }
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Tl_Updatelead_incomedetails_Activity$7 */
    class C08397 implements CompoundButton.OnCheckedChangeListener {
        C08397() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                txtpersonalloan.setVisibility(View.VISIBLE);
            } else {
                txtpersonalloan.setVisibility(View.INVISIBLE);
            }
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Tl_Updatelead_incomedetails_Activity$8 */
    class C09318 extends CallBack {
        C09318() {
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
        setContentView(R.layout.updatelead_income_activity);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        leedsModel = (LeedsModel) getIntent().getSerializableExtra(Constant.LEED_MODEL);
        progressDialogClass = new ProgressDialogClass(this);
        leedRepository = new LeedRepositoryImpl();
        appSharedPreference = new AppSharedPreference(this);
        String[] loanType = new String[]{"Bussiness", "Job"};
        String[] CompanyType = new String[]{"Private ltd", "Public ltd", "Limited Liability Partnership", "Partnership", "Sole Partnership", "Liason office/Repesentative office", "Project Office", "Branch Office", "joint venture company", "Subsidiary company", "Unilimited Company", "Other"};
        String[] SalaryType = new String[]{"AC Credit/Cheque", "Cash", "Comission"};
        String[] EMI = new String[]{"Car", "Home Loan", "Sociaty Loan/Employer Loan", "Other"};
        layoutothercompany = (RelativeLayout) findViewById(R.id.layoutothercompany);
        layoutotheremi = (RelativeLayout) findViewById(R.id.layoutotheremidetails);
        groupRadioEmployed = (RadioGroup) findViewById(R.id.radioOccupation);
        Rsalaried = (RadioButton) findViewById(R.id.radioSalaried);
        Rselfemployed = (RadioButton) findViewById(R.id.radioselfEmployed);
        SPcompanytype = (Spinner) findViewById(R.id.spinnercompanytype);
        SPcompanytype.setOnItemSelectedListener(this);
        SPsalarytype = (Spinner) findViewById(R.id.sploantype1);
        edttenure = (EditText) findViewById(R.id.txttenure1);
        edtexperience = (EditText) findViewById(R.id.txtexperience1);
        edtdepartment = (EditText) findViewById(R.id.txtdepartment1);
        edtdesignation = (EditText) findViewById(R.id.txtdesignation1);
        edtgrosssalary = (EditText) findViewById(R.id.txtmontlygrossincome1);
        edtnetsalary = (EditText) findViewById(R.id.txtnetsalary1);
        edtovertime = (EditText) findViewById(R.id.txtovertime1);
        edtincentive = (EditText) findViewById(R.id.txtiincentive1);
        edtbonus = (EditText) findViewById(R.id.txtbonus1);
        edtrentalincome = (EditText) findViewById(R.id.txtrent1);
        edtannualincome = (EditText) findViewById(R.id.txtannualincome1);
        edtrental = (EditText) findViewById(R.id.txtrentalexpence1);
        edtothercompany = (EditText) findViewById(R.id.txtothercompany1);
        edtagrreculturincom = (EditText) findViewById(R.id.txtagreecultureincome1);
        edtotherincome = (EditText) findViewById(R.id.txtotherincome1);
        edtotheremidetails = (EditText) findViewById(R.id.txtotheremi1);
        txtCarloan = (EditText) findViewById(R.id.txtcarloanamount);
        txtHomeloan = (EditText) findViewById(R.id.txthomeloanamount);
        txtsocietyloan = (EditText) findViewById(R.id.txtsocietyloanamount);
        txtpersonalloan = (EditText) findViewById(R.id.txtpersonalloanamount);
        chsalarysleep = (CheckBox) findViewById(R.id.checkboxsalarysleep);
        chbankstatement = (CheckBox) findViewById(R.id.checkboxbankstatement);
        chformno16 = (CheckBox) findViewById(R.id.checkboxform16);
        chappointmentletter = (CheckBox) findViewById(R.id.checkboxappointmentletter);
        chconfermationletter = (CheckBox) findViewById(R.id.checkboxconfermationletter);
        chexperieceletter = (CheckBox) findViewById(R.id.checkboxexpletter);
        chvisa = (CheckBox) findViewById(R.id.checkboxvisa);
        chpasspoet = (CheckBox) findViewById(R.id.checkboxpassport);
        chemployerletter = (CheckBox) findViewById(R.id.checkboxEmployerletter);
        chcontractletter = (CheckBox) findViewById(R.id.checkboxcontractletter);
        chPOA = (CheckBox) findViewById(R.id.checkboxPOA);
        chNREbankstatement = (CheckBox) findViewById(R.id.checkboxNREbank);
        choverbankdetails = (CheckBox) findViewById(R.id.checkboxOverseasbank);
        chitr = (CheckBox) findViewById(R.id.checkboxITR);
        chcurrentbankstatement = (CheckBox) findViewById(R.id.checkboxcurrentaccountstatement);
        chsavingacctstatement = (CheckBox) findViewById(R.id.checkboxsavingacctstatement);
        chpartnersheepdeed = (CheckBox) findViewById(R.id.checkboxpartnerdeed);
        chbisunessagreement = (CheckBox) findViewById(R.id.checkboxbusinessagreement);
        chqualification = (CheckBox) findViewById(R.id.checkboxqualification);
        chcarloan = (CheckBox) findViewById(R.id.checkboxCarloan);
        chhomloan = (CheckBox) findViewById(R.id.checkboxHomeloan);
        chsocietyloan = (CheckBox) findViewById(R.id.checkboxSocietyloan);
        chpersonalloan = (CheckBox) findViewById(R.id.checkboxPersonalloan);
        chotherloan = (CheckBox) findViewById(R.id.checkboxOtherloan);
        Setchecked();
        btnupdatenext = (Button) findViewById(R.id.buttonupdatenext);
        txtleadid = (TextView) findViewById(R.id.textheader);
        groupRadioEmployed.setOnCheckedChangeListener(new C08331());
        ArrayAdapter<String> spinnerArrayAdaptercompanyType = new ArrayAdapter(this, R.layout.sppinner_layout_listitem, CompanyType);
        spinnerArrayAdaptercompanyType.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        SPcompanytype.setAdapter(spinnerArrayAdaptercompanyType);
        ArrayAdapter<String> spinnerArrayAdapterSalaryType = new ArrayAdapter(this, R.layout.sppinner_layout_listitem, SalaryType);
        spinnerArrayAdapterSalaryType.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        SPsalarytype.setAdapter(spinnerArrayAdapterSalaryType);
        btnupdatenext.setOnClickListener(new C08342());
        getdata();
        Loanvisibility();
    }

    private void Setchecked() {
        chotherloan.setOnCheckedChangeListener(new C08353());
        chcarloan.setOnCheckedChangeListener(new C08364());
        chhomloan.setOnCheckedChangeListener(new C08375());
        chsocietyloan.setOnCheckedChangeListener(new C08386());
        chpersonalloan.setOnCheckedChangeListener(new C08397());
    }

    private void Loanvisibility() {
        if (chcarloan.isChecked()) {
            txtCarloan.setVisibility(View.VISIBLE);
        } else {
            txtCarloan.setVisibility(View.INVISIBLE);
        }
        if (chpersonalloan.isChecked()) {
            txtpersonalloan.setVisibility(View.VISIBLE);
        } else {
            txtpersonalloan.setVisibility(View.INVISIBLE);
        }
        if (chsocietyloan.isChecked()) {
            txtsocietyloan.setVisibility(View.VISIBLE);
        } else {
            txtsocietyloan.setVisibility(View.INVISIBLE);
        }
        if (chhomloan.isChecked()) {
            txtHomeloan.setVisibility(View.VISIBLE);
        } else {
            txtHomeloan.setVisibility(View.INVISIBLE);
        }
    }

    private void getdata() {
        try {
            String cleedid = leedsModel.getLeedNumber();
            String sEmployed = leedsModel.getEmployed();
            String sCompanytype = leedsModel.getCompanytype();
            String sSalarytype = leedsModel.getSalaytype();
            String sEMIcar = leedsModel.getEmicar();
            String sEMIhome = leedsModel.getEmihome();
            String sEMIsociety = leedsModel.getEmisociety();
            String sEMIpersonal = leedsModel.getEmipersonal();
            String carloanamt = leedsModel.getCarLoanAmount();
            String homeloanamt = leedsModel.getHomeLoanAmount();
            String societyloanamt = leedsModel.getSocietyLoanAmount();
            String personalloanamt = leedsModel.getPersonalLoanAmount();
            String sEMIother = leedsModel.getEmiother();
            String othercompany = leedsModel.getOthercompany();
            String sTenure = leedsModel.getTenure();
            String sEMIother2 = sEMIother;
            sEMIother = leedsModel.getExperience();
            String personalloanamt2 = personalloanamt;
            personalloanamt = leedsModel.getDepartment();
            String sEMIpersonal2 = sEMIpersonal;
            sEMIpersonal = leedsModel.getDesignation();
            String societyloanamt2 = societyloanamt;
            societyloanamt = leedsModel.getGrosssalary();
            String sEMIsociety2 = sEMIsociety;
            sEMIsociety = leedsModel.getNetsalary();
            String homeloanamt2 = homeloanamt;
            homeloanamt = leedsModel.getOvertime();
            String sEMIhome2 = sEMIhome;
            sEMIhome = leedsModel.getIncentive();
            String carloanamt2 = carloanamt;
            carloanamt = leedsModel.getBonus();
            String sEMIcar2 = sEMIcar;
            String sRentalincom = leedsModel.getRentalincome();
            String sAnnualincome = leedsModel.getAnnualincome();
            String sRental = leedsModel.getRental();
            String sSalrysleep = leedsModel.getSalarysleep();
            String sBankstmt = leedsModel.getBankstmt();
            String sForm = leedsModel.getForm();
            String sAppointmentltr = leedsModel.getAppointmentltr();
            String sConfermationltr = leedsModel.getConformationltr();
            String sExperinceltr = leedsModel.getExperinceltr();
            String sVisa = leedsModel.getVisa();
            String sPassport = leedsModel.getPassport();
            String sEmployerltr = leedsModel.getEmploerltr();
            String sContractltr = leedsModel.getContractltr();
            String sPOA = leedsModel.getPoa();
            String sNREbank = leedsModel.getNrebankstmt();
            String sOverseasebank = leedsModel.getOverseasbankdetail();
            String sITR = leedsModel.getItr();
            String sCurrentbank = leedsModel.getCurrentbankstmt();
            String sSavingbank = leedsModel.getSavingacctstmt();
            String sPartnerdeed = leedsModel.getPartnersheepdeed();
            String sBusinessagmt = leedsModel.getBusinessagmt();
            String sQualification = leedsModel.getQualification();
            String sAgreeincome = leedsModel.getAggrecultureIncome();
            String sotherincome = leedsModel.getOtherIncome();
            sEMIcar = leedsModel.getEmiOtherDetails();
            String sBonus = carloanamt;
            ArrayAdapter myAdap = (ArrayAdapter) SPcompanytype.getAdapter();
            String sInsentive = sEMIhome;
            SPcompanytype.setSelection(myAdap.getPosition(sCompanytype));
            if (sCompanytype.equalsIgnoreCase("Other")) {
                Showothercompany();
            } else {
                hideothercompany();
            }
            SPsalarytype.setSelection(((ArrayAdapter) SPsalarytype.getAdapter()).getPosition(sSalarytype));
            if (cleedid != null) {
                txtleadid.setText(cleedid);
            }
            if (sEmployed == null) {
            } else if (sEmployed.equalsIgnoreCase("Salaried")) {
                Rsalaried.setChecked(true);
            } else {
                if (sEmployed.equalsIgnoreCase("Self Employed")) {
                    Rselfemployed.setChecked(true);
                }
            }
            if (othercompany != null) {
                edtothercompany.setText(othercompany);
            }
            if (sEMIcar != null) {
                edtotheremidetails.setText(sEMIcar);
            }
            if (sTenure != null) {
                edttenure.setText(sTenure);
            }
            if (sEMIother != null) {
                edtexperience.setText(sEMIother);
            }
            if (personalloanamt != null) {
                edtdepartment.setText(personalloanamt);
            }
            if (sEMIpersonal != null) {
                edtdesignation.setText(sEMIpersonal);
            }
            if (societyloanamt != null) {
                edtgrosssalary.setText(societyloanamt);
            }
            if (sEMIsociety != null) {
                edtnetsalary.setText(sEMIsociety);
            }
            if (homeloanamt != null) {
                edtovertime.setText(homeloanamt);
            }
            if (sInsentive != null) {
                edtincentive.setText(sInsentive);
            }
            if (sBonus != null) {
                sEmployed = sBonus;
                edtbonus.setText(sEmployed);
            } else {
                sEmployed = sBonus;
            }
            if (sRentalincom != null) {
                sBonus = sEmployed;
                sEmployed = sRentalincom;
                edtrentalincome.setText(sEmployed);
            } else {
                sEmployed = sRentalincom;
            }
            if (sAnnualincome != null) {
                sRentalincom = sEmployed;
                sEmployed = sAnnualincome;
                edtannualincome.setText(sEmployed);
            } else {
                sEmployed = sAnnualincome;
            }
            if (sAgreeincome != null) {
                sAnnualincome = sEmployed;
                sEmployed = sAgreeincome;
                edtagrreculturincom.setText(sEmployed);
            } else {
                sEmployed = sAgreeincome;
            }
            if (sotherincome != null) {
                sAgreeincome = sEmployed;
                sEmployed = sotherincome;
                edtotherincome.setText(sEmployed);
            } else {
                sEmployed = sotherincome;
            }
            if (sRental != null) {
                sotherincome = sEmployed;
                sEmployed = sRental;
                edtrental.setText(sEmployed);
            } else {
                sEmployed = sRental;
            }
            if (sSalrysleep != null) {
                sRental = sEmployed;
                chsalarysleep.setChecked(true);
            }
            if (sBankstmt != null) {
                chbankstatement.setChecked(true);
            }
            if (sForm != null) {
                chformno16.setChecked(true);
            }
            if (sAppointmentltr != null) {
                chappointmentletter.setChecked(true);
            }
            if (sConfermationltr != null) {
                chconfermationletter.setChecked(true);
            }
            if (sExperinceltr != null) {
                chexperieceletter.setChecked(true);
            }
            if (sVisa != null) {
                chvisa.setChecked(true);
            }
            if (sPassport != null) {
                chpasspoet.setChecked(true);
            }
            if (sEmployerltr != null) {
                chemployerletter.setChecked(true);
            }
            if (sContractltr != null) {
                chcontractletter.setChecked(true);
            }
            if (sPOA != null) {
                chPOA.setChecked(true);
            }
            if (sNREbank != null) {
                chNREbankstatement.setChecked(true);
            }
            if (sOverseasebank != null) {
                choverbankdetails.setChecked(true);
            }
            if (sITR != null) {
                chitr.setChecked(true);
            }
            if (sCurrentbank != null) {
                chcurrentbankstatement.setChecked(true);
            }
            if (sSavingbank != null) {
                chsavingacctstatement.setChecked(true);
            }
            if (sPartnerdeed != null) {
                chpartnersheepdeed.setChecked(true);
            }
            if (sBusinessagmt != null) {
                chbisunessagreement.setChecked(true);
            }
            if (sQualification != null) {
                chqualification.setChecked(true);
            }
            if (sEMIcar2 != null) {
                chcarloan.setChecked(true);
                sEmployed = carloanamt2;
                txtCarloan.setText(sEmployed);
            } else {
                sEmployed = carloanamt2;
            }
            if (sEMIhome2 != null) {
                carloanamt2 = sEmployed;
                chhomloan.setChecked(true);
                sEmployed = homeloanamt2;
                txtHomeloan.setText(sEmployed);
            } else {
                sEmployed = homeloanamt2;
            }
            if (sEMIsociety2 != null) {
                homeloanamt2 = sEmployed;
                chsocietyloan.setChecked(true);
                sEmployed = societyloanamt2;
                txtsocietyloan.setText(sEmployed);
            } else {
                sEmployed = societyloanamt2;
            }
            if (sEMIpersonal2 != null) {
                societyloanamt2 = sEmployed;
                chpersonalloan.setChecked(true);
                txtpersonalloan.setText(personalloanamt2);
            }
            if (sEMIother2 != null) {
                chotherloan.setChecked(true);
                ShowotherEMI();
            } else {
                hideotherEMI();
            }
        } catch (Exception e) {
        }
    }

    private void updateLeadDetails(LeedsModel leedsModel) {
        try {
            leedsModel.setEmployed(cEmployedtype);
            leedsModel.setCompanytype(cCompanytype);
            leedsModel.setSalaytype(cSalaryType);
            leedsModel.setEmicar(cCarloan);
            leedsModel.setEmihome(cHomeloan);
            leedsModel.setEmisociety(cSocietyloan);
            leedsModel.setEmipersonal(cPersonalloan);
            leedsModel.setCarLoanAmount(cCarloanamt);
            leedsModel.setHomeLoanAmount(cHomeloanamt);
            leedsModel.setSocietyLoanAmount(cSocietyloanamt);
            leedsModel.setPersonalLoanAmount(cPersonalloanamt);
            leedsModel.setEmiother(cOtherloan);
            leedsModel.setOthercompany(cOthercompany);
            leedsModel.setTenure(cTenure);
            leedsModel.setExperience(cEcperience);
            leedsModel.setDepartment(cDept);
            leedsModel.setDesignation(cDesignation);
            leedsModel.setGrosssalary(cGrossslr);
            leedsModel.setNetsalary(cNetslr);
            leedsModel.setOvertime(cOvertime);
            leedsModel.setIncentive(cIncentive);
            leedsModel.setBonus(cBonus);
            leedsModel.setRentalincome(cRentalincome);
            leedsModel.setAnnualincome(cAnnualincome);
            leedsModel.setRental(cRental);
            leedsModel.setSalarysleep(cSalarysleep);
            leedsModel.setBankstmt(cBankstmt);
            leedsModel.setForm(cForm16);
            leedsModel.setAppointmentltr(cAppointmentltr);
            leedsModel.setConformationltr(cConfermationltr);
            leedsModel.setExperinceltr(cExperinceltr);
            leedsModel.setVisa(cVisa);
            leedsModel.setPassport(cPassport);
            leedsModel.setEmploerltr(cEmployerltr);
            leedsModel.setContractltr(cContractltr);
            leedsModel.setPoa(cPOA);
            leedsModel.setNrebankstmt(cNRAbankstmt);
            leedsModel.setOverseasbankdetail(cOverbank);
            leedsModel.setItr(cITR);
            leedsModel.setCurrentbankstmt(cCurrentbnkstmt);
            leedsModel.setSavingacctstmt(cSavingbnkstmt);
            leedsModel.setPartnersheepdeed(cPartnerdeed);
            leedsModel.setBusinessagmt(cBisunessagmt);
            leedsModel.setQualification(cQulification);
            leedsModel.setAggrecultureIncome(cAgrreIncome);
            leedsModel.setOtherIncome(cOtherincome);
            leedsModel.setEmiOtherDetails(cOtherEMIdetails);
            updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap());
        } catch (Exception e) {
        }
    }

    private void updateLeed(String leedId, Map leedsMap) {
        progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));
        leedRepository.updateLeed(leedId, leedsMap, new C09318());
    }

    public void hideothercompany() {
        LayoutParams params = (LayoutParams) layoutothercompany.getLayoutParams();
        params.height = 0;
        layoutothercompany.setLayoutParams(params);
    }

    public void Showothercompany() {
        LayoutParams params = (LayoutParams) layoutothercompany.getLayoutParams();
        params.height = -1;
        layoutothercompany.setLayoutParams(params);
    }

    public void hideotherEMI() {
        LayoutParams params = (LayoutParams) layoutotheremi.getLayoutParams();
        params.height = 0;
        layoutotheremi.setLayoutParams(params);
    }

    public void ShowotherEMI() {
        LayoutParams params = (LayoutParams) layoutotheremi.getLayoutParams();
        params.height = -1;
        layoutotheremi.setLayoutParams(params);
    }

    public void onItemSelected(AdapterView<?> adapterView, View arg1, int position, long id) {
        if (SPcompanytype.getSelectedItem().toString().equalsIgnoreCase("Other")) {
            Showothercompany();
        } else {
            hideothercompany();
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back press disabled!", 0).show();
    }
}
