package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.models.User;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.UserRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.UserRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.SALES;

public class Bank_Submit_Update_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner CoapplicantRalationship;
    RadioButton REducation;
    RadioButton RYN;
    RadioButton RcoapplicantNO;
    RadioButton RcoapplicantYES;
    Spinner Recidential;
    RadioButton Rfemale;
    RadioButton Rg;
    RadioButton Rgender;
    RadioButton Rmale;
    RadioButton Rno;
    RadioButton Rother;
    RadioButton Rpg;
    RadioButton Rpro;
    RadioButton Rug;
    RadioButton Ryes;
    AppSharedPreference appSharedPreference;
    EditText area;
    Button btcancel;
    Button btupdate;
    Button btverify;
    String cAdharno;
    String cAdress;
    String cAltcontatct;
    String cBank;
    String cBdate;
    String cContatct;
    String cDescreption;
    String cExamount;
    String cIncome;
    String cNmae;
    String cOffaddress;
    String cPadress;
    String cPanno;
    CheckBox chAdhar;
    CheckBox chDL;
    CheckBox chPAN;
    CheckBox chPassport;
    CheckBox chProofAdhar;
    CheckBox chProofCurrentacctStmt;
    CheckBox chProofElectricitybill;
    CheckBox chProofGovtEmpid;
    CheckBox chProofGumasta;
    CheckBox chProofPassport;
    CheckBox chProofRntagmt;
    CheckBox chProofVoterid;
    CheckBox chProofdl;
    CheckBox chVoterID;
    EditText Currentarea;
    EditText Currentlandmark;
    EditText Currentpin;
    EditText Currentstreet;
    EditText edtotherrelationship;
    EditText edtreferenceaddress;
    EditText edtreferenceaddress2;
    EditText edtreferencecontactno;
    EditText edtreferencecontactno2;
    EditText edtreferencename;
    EditText edtreferencename2;
    EditText edtreferencerelationship;
    EditText edtreferencerelationship2;
    EditText etaddress;
    EditText etadharno;
    EditText etalternatecontact;
    EditText etbank;
    EditText etbirthdate;
    EditText etcEmail;
    EditText etcname;
    EditText etcontatct;
    EditText etdescription;
    EditText etexammount;
    EditText etgenerated;
    EditText etincome;
    TextView etleednumber;
    EditText etoccupation;
    EditText etoffaddress;
    EditText etother;
    EditText etpanno;
    EditText etpermanantaddress;
    EditText etpropaddress;
    String lGenby;
    EditText landmark;
    LeedRepository leedRepository;
    UserRepository userRepository;
    LeedsModel leedsModel;
    EditText pin;
    ProgressDialogClass progressDialogClass;
    Spinner spinemptype;
    Spinner spinincome;
    Spinner spinloantype;
    String sploantype;
    String spoccupation;
    EditText street;
    TextView txtgeneratedby;
    TextView txtldate;
    TextView txtleadid;
    TextView txtleadidvalue;
    TextView txtleedtime;
    EditText txtpannumber;

    //INCOME
    Spinner SPcompanytype;
    Spinner SPsalarytype;
    RadioButton Rsalaried;
    RadioButton Rselfemployed;

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
    EditText txtCarloan;
    EditText txtHomeloan;
    EditText txtpersonalloan;
    EditText txtsocietyloan;

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

    //PROPERTY
    Spinner SPpropertytype;
    RadioButton Rpresanctioned, Rpurchasepropety;
    EditText edtloanrequirement, edtdownpayment, edtdescription, edtpropertypin, edtpropertylandmark, edtpropertyarea, edtprojectname;
    EditText edtbankname, edtbranchname, edtifsccode,edtloginid;
    Spinner SPsalesperson;
    String Sagenname, Sloantype, Scusomername, Scustomergender, Sbirthdate, Scontactno, Saltcontact,
            Semail, SEducation, Sotheredudetails, Scurrentpin, Scurrentland, Scurrentarea, Scurrentstreet, SaddressYN,
            Sperpin, Sperland, Sperarea, Sperstreet, Sresidentialtype, Sofficeaddress, Skycadhar, Skycpan, Akycpannumber,
            Skycvoterid, SkycDL, Skycpassport, Sproofadhar, Sproofvoterid, SproofDL, Sproofelectricitybill, Sproofrentagmt,
            Sproofpassport, Sproofgovtid, Sproofgumasta, Sproofcurrentacctstmt, ScoapplicantYN, Scoapplicantrelation,
            Scoapplicantotherrelationdetails, Sref1nmae, Sref1address, Sref1contact, Sref1relation, Sref2name, Sref2address,
            Sref2contact, Sref2relation, Soccupationtype, Scompanytype, Sothercmptype, Stenure, Sworkexp, Sdepartment,
            Sdesignation, Smonthlygrosssalary, Snetsalary, Sovertime, Sinsentive, Sbonus, Srentalincome, Sagreeincome,
            Sannualincome, Sotherincome, Ssalarycomesin, Srentalexpence, Scarloan, Scarloanamt, Shomelloan, Shomeloanamt,
            Ssocietyloan, Ssocietyloanamt, Spersonalloan, Spersonalloanamt, Sotherloan, Sotherloanamt, Ssalarysleep,
            Sbankstmt, Sform16, Sappointmentletter, Sconfermationletter, Sexperienceletter, Snrivisa, Snripassport,
            Snriemployerletter, Snricontractletter, Snripoa, SNREbankacct, Soverseasebankacct, Sitr, Scurrentacctstmt,
            Ssavingacctstmt, Spartnershipdeed, Sbusinessagmt, Squalificationcirtificate, Spropertytype, SpropertyYN, Sprpin, Sprland, Sprarea, Sprprojectname, Sprpropertytype, Sprloanrequirement, Sprdownpayment, Sprdescriptio,
            Sbankname, Sbranchname, Sifsccode,Sloginid, Ssalespersone,
            saboutpropety, sYN;

    RadioGroup groupAboutproperty, groupAboutpropetyYN;
    RadioButton Rproperty, Ryn;
    RadioGroup groupRadioGender;
    RadioGroup groupRadioEducation;
    RadioGroup groupRadio;
    RadioGroup groupRadiocoapplicant;

    RadioGroup groupRadioEmployed;

    RadioButton Rcoapplicant, Remployed;

    List<String> salesPerson;
    List<User> userlist;

    Button bankSubmit;
//
//    @Override
//    public void onClick(View v) {
//
//    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Coordinator_Update_Activity$1 */
    class C08031 implements View.OnClickListener {
        C08031() {
        }

        public void onClick(View v) {

            Sagenname = txtgeneratedby.getText().toString();
            Sloantype = spinloantype.getSelectedItem().toString();
            Scusomername = etcname.getText().toString();

            if (groupRadioGender.getCheckedRadioButtonId() != -1) {
                RadioButton btn = (RadioButton) groupRadioGender.getChildAt(groupRadioGender.indexOfChild(groupRadioGender.findViewById(groupRadioGender.getCheckedRadioButtonId())));
                Scustomergender = btn.getText().toString();
            }
            groupRadioGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Rgender = (RadioButton) findViewById(checkedId);

                    Scustomergender = Rgender.getText().toString();
                }
            });

            Sbirthdate = etbirthdate.getText().toString();
            Scontactno = etcontatct.getText().toString();
            Saltcontact = etalternatecontact.getText().toString();
            Semail = etcEmail.getText().toString();

            //  SEducation = txtgeneratedby.getText().toString();
            if (groupRadioEducation.getCheckedRadioButtonId() != -1) {
                RadioButton btn = (RadioButton) groupRadioEducation.getChildAt(groupRadioEducation.indexOfChild(groupRadioEducation.findViewById(groupRadioEducation.getCheckedRadioButtonId())));
                SEducation = btn.getText().toString();
            }
            groupRadioEducation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    REducation = (RadioButton) findViewById(checkedId);
                    SEducation = REducation.getText().toString();
                }
            });

            Sotheredudetails = etother.getText().toString();
            Scurrentpin = Currentpin.getText().toString();
            Scurrentland = Currentlandmark.getText().toString();
            Scurrentarea = Currentarea.getText().toString();
            Scurrentstreet = Currentstreet.getText().toString();

            //  SaddressYN = txtgeneratedby.getText().toString();
            if (groupRadio.getCheckedRadioButtonId() != -1) {
                RadioButton btn = (RadioButton) groupRadio.getChildAt(groupRadio.indexOfChild(groupRadio.findViewById(groupRadio.getCheckedRadioButtonId())));
                SaddressYN = btn.getText().toString();
            }
            groupRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    RYN = (RadioButton) findViewById(checkedId);

                    SaddressYN = RYN.getText().toString();
                }
            });

            Sperpin = pin.getText().toString();
            Sperland = landmark.getText().toString();
            Sperarea = area.getText().toString();
            Sperstreet = street.getText().toString();
            Sresidentialtype = Recidential.getSelectedItem().toString();
            Sofficeaddress = etoffaddress.getText().toString();
            if (chAdhar.isChecked()) {
                Skycadhar = chAdhar.getText().toString();
            }
            if (chPAN.isChecked()) {
                Skycpan = chPAN.getText().toString();
            }
            if (chAdhar.isChecked()) {
                Akycpannumber = txtpannumber.getText().toString();
            }
            if (chVoterID.isChecked()) {
                Skycvoterid = chVoterID.getText().toString();
            }
            if (chDL.isChecked()) {
                SkycDL = chDL.getText().toString();
            }
            if (chPassport.isChecked()) {
                Skycpassport = chPassport.getText().toString();
            }
            if (chProofAdhar.isChecked()) {
                Sproofadhar = chProofAdhar.getText().toString();
            }
            if (chProofVoterid.isChecked()) {
                Sproofvoterid = chProofVoterid.getText().toString();
            }
            if (chProofdl.isChecked()) {
                SproofDL = chProofdl.getText().toString();
            }
            if (chProofElectricitybill.isChecked()) {
                Sproofelectricitybill = chProofElectricitybill.getText().toString();
            }
            if (chProofRntagmt.isChecked()) {
                Sproofrentagmt = chProofRntagmt.getText().toString();
            }
            if (chProofPassport.isChecked()) {
                Sproofpassport = chProofPassport.getText().toString();
            }
            if (chProofGovtEmpid.isChecked()) {
                Sproofgovtid = chProofGovtEmpid.getText().toString();
            }
            if (chProofGumasta.isChecked()) {
                Sproofgumasta = chProofGumasta.getText().toString();
            }
            if (chProofCurrentacctStmt.isChecked()) {
                Sproofcurrentacctstmt = chProofCurrentacctStmt.getText().toString();
            }

            //  ScoapplicantYN = txtgeneratedby.getText().toString();
            if (groupRadiocoapplicant.getCheckedRadioButtonId() != -1) {
                RadioButton btn2 = (RadioButton) groupRadiocoapplicant.getChildAt(groupRadiocoapplicant.indexOfChild(groupRadiocoapplicant.findViewById(groupRadiocoapplicant.getCheckedRadioButtonId())));
                ScoapplicantYN = btn2.getText().toString();
            }
            groupRadiocoapplicant.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Rcoapplicant = (RadioButton) findViewById(checkedId);
                    ScoapplicantYN = Rcoapplicant.getText().toString();
                }
            });

            Scoapplicantrelation = CoapplicantRalationship.getSelectedItem().toString();
            Scoapplicantotherrelationdetails = edtotherrelationship.getText().toString();
            Sref1nmae = edtreferencename.getText().toString();
            Sref1address = edtreferenceaddress.getText().toString();
            Sref1contact = edtreferencecontactno.getText().toString();
            Sref1relation = edtreferencerelationship.getText().toString();
            Sref2name = edtreferencename2.getText().toString();
            Sref2address = edtreferenceaddress2.getText().toString();
            Sref2contact = edtreferencecontactno2.getText().toString();
            Sref2relation = edtreferencerelationship2.getText().toString();

            //   Soccupationtype = txtgeneratedby.getText().toString();
            if (groupRadioEmployed.getCheckedRadioButtonId() != -1) {
                RadioButton btn = (RadioButton) groupRadioEmployed.getChildAt(groupRadioEmployed.indexOfChild(groupRadioEmployed.findViewById(groupRadioEmployed.getCheckedRadioButtonId())));
                Soccupationtype = btn.getText().toString();
            }
            groupRadioEmployed.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Remployed = (RadioButton) findViewById(checkedId);
                    Soccupationtype = Remployed.getText().toString();
                }
            });

            Scompanytype = SPcompanytype.getSelectedItem().toString();
            Sothercmptype = edtothercompany.getText().toString();
            Stenure = edttenure.getText().toString();
            Sworkexp = edtexperience.getText().toString();
            Sdepartment = edtdepartment.getText().toString();
            Sdesignation = edtdesignation.getText().toString();
            Smonthlygrosssalary = edtgrosssalary.getText().toString();
            Snetsalary = edtnetsalary.getText().toString();
            Sovertime = edtovertime.getText().toString();
            Sinsentive = edtincentive.getText().toString();
            Sbonus = edtbonus.getText().toString();
            Srentalincome = edtrentalincome.getText().toString();
            Sagreeincome = edtagrreculturincom.getText().toString();
            Sannualincome = edtannualincome.getText().toString();
            Sotherincome = edtotherincome.getText().toString();
            Ssalarycomesin = SPsalarytype.getSelectedItem().toString();
            Srentalexpence = edtrental.getText().toString();
            if (chcarloan.isChecked()) {
                Scarloan = chcarloan.getText().toString();
                Scarloanamt = txtCarloan.getText().toString();
            }
            if (chhomloan.isChecked()) {
                Shomelloan = chhomloan.getText().toString();
                Shomeloanamt = txtHomeloan.getText().toString();
            }
            if (chsocietyloan.isChecked()) {
                Ssocietyloan = chsocietyloan.getText().toString();
                Ssocietyloanamt = txtsocietyloan.getText().toString();
            }
            if (chpersonalloan.isChecked()) {
                Spersonalloan = chpersonalloan.getText().toString();
                Spersonalloanamt = txtpersonalloan.getText().toString();
            }
            if (chotherloan.isChecked()) {
                Sotherloan = chotherloan.getText().toString();
                Sotherloanamt = edtotheremidetails.getText().toString();
            }
            if (chsalarysleep.isChecked()) {
                Ssalarysleep = chsalarysleep.getText().toString();
            }
            if (chbankstatement.isChecked()) {
                Sbankstmt = chbankstatement.getText().toString();
            }
            if (chformno16.isChecked()) {
                Sform16 = chformno16.getText().toString();
            }
            if (chappointmentletter.isChecked()) {
                Sappointmentletter = chappointmentletter.getText().toString();
            }
            if (chconfermationletter.isChecked()) {
                Sconfermationletter = chconfermationletter.getText().toString();
            }
            if (chexperieceletter.isChecked()) {
                Sexperienceletter = chexperieceletter.getText().toString();
            }
            if (chvisa.isChecked()) {
                Snrivisa = chvisa.getText().toString();
            }
            if (chpasspoet.isChecked()) {
                Snripassport = chpasspoet.getText().toString();
            }
            if (chemployerletter.isChecked()) {
                Snriemployerletter = chemployerletter.getText().toString();
            }
            if (chcontractletter.isChecked()) {
                Snricontractletter = chcontractletter.getText().toString();
            }
            if (chPOA.isChecked()) {
                Snripoa = chPOA.getText().toString();
            }
            if (chbankstatement.isChecked()) {
                SNREbankacct = chbankstatement.getText().toString();
            }
            if (choverbankdetails.isChecked()) {
                Soverseasebankacct = choverbankdetails.getText().toString();
            }
            if (chitr.isChecked()) {
                Sitr = chitr.getText().toString();
            }
            if (chcurrentbankstatement.isChecked()) {
                Scurrentacctstmt = chcurrentbankstatement.getText().toString();
            }
            if (chsavingacctstatement.isChecked()) {
                Ssavingacctstmt = chsavingacctstatement.getText().toString();
            }
            if (chpartnersheepdeed.isChecked()) {
                Spartnershipdeed = chpartnersheepdeed.getText().toString();
            }
            if (chbisunessagreement.isChecked()) {
                Sbusinessagmt = chbisunessagreement.getText().toString();
            }
            if (chqualification.isChecked()) {
                Squalificationcirtificate = chqualification.getText().toString();
            }


            groupAboutproperty.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Rproperty = (RadioButton) findViewById(checkedId);
                    saboutpropety = Rproperty.getText().toString();
                    if (Rproperty.getText().toString().equalsIgnoreCase("Purchase Propety identified")) {

                    } else if (Rproperty.getText().toString().equalsIgnoreCase("Pre-Sanction")) {

                        Rno.setChecked(true);
                        Ryes.setChecked(false);
                    }
                }
            });
            groupAboutpropetyYN.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup group, int checkedId) {
                    Ryn = (RadioButton) findViewById(checkedId);
                    sYN = Ryn.getText().toString();

                }
            });


            if (groupAboutproperty.getCheckedRadioButtonId() != -1) {
                int id = groupAboutproperty.getCheckedRadioButtonId();
                View radioButton = groupAboutproperty.findViewById(id);
                int radioId = groupAboutproperty.indexOfChild(radioButton);
                RadioButton btn = (RadioButton) groupAboutproperty.getChildAt(radioId);
                saboutpropety = btn.getText().toString();

                if (saboutpropety.equalsIgnoreCase("Purchase Propety identified")) {

                } else if (saboutpropety.equalsIgnoreCase("Pre-Sanction")) {
                    Rno.setChecked(true);
                    Ryes.setChecked(false);
                }
            }
            if (groupAboutpropetyYN.getCheckedRadioButtonId() != -1) {
                int id = groupAboutpropetyYN.getCheckedRadioButtonId();
                View radioButton = groupAboutpropetyYN.findViewById(id);
                int radioId = groupAboutpropetyYN.indexOfChild(radioButton);
                RadioButton btn = (RadioButton) groupAboutpropetyYN.getChildAt(radioId);
                sYN = btn.getText().toString();

            }

            Sprpin = edtpropertypin.getText().toString();
            Sprland = edtpropertylandmark.getText().toString();
            Sprarea = edtpropertyarea.getText().toString();
            Sprprojectname = edtprojectname.getText().toString();
            Sprpropertytype = SPpropertytype.getSelectedItem().toString();
            Sprloanrequirement = edtloanrequirement.getText().toString();
            Sprdownpayment = edtdownpayment.getText().toString();
            Sprdescriptio = edtdescription.getText().toString();

            Sbankname = edtbankname.getText().toString();
            Sbranchname = edtbranchname.getText().toString();
            Sifsccode = edtifsccode.getText().toString();
            Sloginid = edtloginid.getText().toString();
            Ssalespersone = SPsalesperson.getSelectedItem().toString();

            updateLeadDetails(leedsModel);
            Toast.makeText(getApplicationContext(), "Lead Update Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Coordinator_Update_Activity$2 */
    class C08042 implements View.OnClickListener {
        C08042() {
        }

        public void onClick(View v) {
            Sloginid = edtloginid.getText().toString();
            if (TextUtils.isEmpty(Sloginid)) {
                edtloginid.setError("Required");
                Toast.makeText(getApplicationContext(), "Enter Login ID!", Toast.LENGTH_SHORT).show();
                return;
            }
            setLeedStatus(leedsModel);
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Coordinator_Update_Activity$3 */
    class C08053 implements View.OnClickListener {
        C08053() {
        }

        public void onClick(View v) {
            startActivity(new Intent(getApplicationContext(), MainActivity_coordinator.class));
            overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Coordinator_Update_Activity$4 */
    class C09234 extends CallBack {
        C09234() {
        }

        public void onSuccess(Object object) {
            Toast.makeText(getApplicationContext(), "Lead Submited Successfully", Toast.LENGTH_SHORT).show();
            progressDialogClass.dismissDialog();
        }

        public void onError(Object object) {
            progressDialogClass.dismissDialog();
            Context context = Bank_Submit_Update_Activity.this;
            Utility.showLongMessage(context, context.getString(R.string.server_error));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank__submit__update_);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        leedsModel = (LeedsModel) getIntent().getSerializableExtra(Constant.LEED_MODEL);
        progressDialogClass = new ProgressDialogClass(this);
        leedRepository = new LeedRepositoryImpl();
        userRepository = new UserRepositoryImpl();
        appSharedPreference = new AppSharedPreference(this);

        String[] loanType = new String[]{"HL", "LAP"};
        String[] empType = new String[]{"Salaried", "Businessman"};
        String[] recidential = new String[]{"Owned", "Rented", "Allotted by Employer", "Family"};
        String[] CoapplicantRelation = new String[]{"Spouse", "Parents", "Children", "Power of Attorney", "Please specify"};
        //   String[] salesperson = new String[]{"soma dornal", "vikas test user", "sagar mule"};

        salesPerson = new ArrayList<>();

        groupAboutproperty = (RadioGroup) findViewById(R.id.radioGroupaboutproperty);
        groupAboutpropetyYN = (RadioGroup) findViewById(R.id.radioGroupaboutpropertyYesNo);

        groupRadioGender = (RadioGroup) findViewById(R.id.radioSex);
        groupRadioEducation = (RadioGroup) findViewById(R.id.radioeducation);
        groupRadio = (RadioGroup) findViewById(R.id.radioGYN);
        groupRadiocoapplicant = (RadioGroup) findViewById(R.id.radiocoapplicantYN);

        groupRadioEmployed = (RadioGroup) findViewById(R.id.radioOccupation);


        edtbankname = (EditText) findViewById(R.id.txtbankname1);
        edtbranchname = (EditText) findViewById(R.id.txtbranchname1);
        edtifsccode = (EditText) findViewById(R.id.txtifsccode1);
        edtloginid = (EditText) findViewById(R.id.txtloginid1);
        SPsalesperson = (Spinner) findViewById(R.id.txtsalespersonname1);
//        ArrayAdapter<String> spinnerArrayAdaptersalesperson = new ArrayAdapter(this, R.layout.sppinner_layout_listitem,
//                salesPerson);
//        spinnerArrayAdaptersalesperson.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//        SPsalesperson.setAdapter(spinnerArrayAdaptersalesperson);

        spinloantype = (Spinner) findViewById(R.id.sploantype1);

        btupdate = (Button) findViewById(R.id.buttonupdate);

        txtleadid = (TextView) findViewById(R.id.textheader);

        etcname = (EditText) findViewById(R.id.txtcamevalue);
        etaddress = (EditText) findViewById(R.id.txtcurrentaddressvalue);
        etpermanantaddress = (EditText) findViewById(R.id.txtpermenantaddressvalue);
        Currentpin = (EditText) findViewById(R.id.txtcurrentpin1);
        Currentlandmark = (EditText) findViewById(R.id.txtcurrentlandmark1);
        Currentarea = (EditText) findViewById(R.id.txtcurrentarea1);
        Currentstreet = (EditText) findViewById(R.id.txtcurrentstreet1);
        pin = (EditText) findViewById(R.id.txtpin1);
        landmark = (EditText) findViewById(R.id.txtlandmark1);
        area = (EditText) findViewById(R.id.txtarea1);
        street = (EditText) findViewById(R.id.txtstreet1);
        etoffaddress = (EditText) findViewById(R.id.txtofficeaddressvalue);
        etbirthdate = (EditText) findViewById(R.id.txtbirthdatevalue);
        etcontatct = (EditText) findViewById(R.id.txtcontatctvalue);
        etalternatecontact = (EditText) findViewById(R.id.edtaltcontact);
        etcEmail = (EditText) findViewById(R.id.txtemail1);

        Recidential = (Spinner) findViewById(R.id.spinnerrecidencialvalue);
        ArrayAdapter<String> spinnerArrayAdapterRecidential = new ArrayAdapter(this, R.layout.sppinner_layout_listitem, recidential);
        spinnerArrayAdapterRecidential.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        Recidential.setAdapter(spinnerArrayAdapterRecidential);

        CoapplicantRalationship = (Spinner) findViewById(R.id.txtcoapplicantrelation1);
        ArrayAdapter<String> spinnerArrayAdapterRelationship = new ArrayAdapter(this, R.layout.sppinner_layout_listitem, CoapplicantRelation);
        spinnerArrayAdapterRelationship.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        CoapplicantRalationship.setAdapter(spinnerArrayAdapterRelationship);

        edtotherrelationship = (EditText) findViewById(R.id.txtotherrelationship1);
        edtreferencename = (EditText) findViewById(R.id.txtreferencefullname1);
        edtreferenceaddress = (EditText) findViewById(R.id.txtreferenceaddress1);
        edtreferencecontactno = (EditText) findViewById(R.id.txtreferencecontactno1);
        edtreferencerelationship = (EditText) findViewById(R.id.txtreferencecrelationship1);
        edtreferencename2 = (EditText) findViewById(R.id.txtreference2fullname1);
        edtreferenceaddress2 = (EditText) findViewById(R.id.txtreference2address1);
        edtreferencecontactno2 = (EditText) findViewById(R.id.txtreference2contactno1);
        edtreferencerelationship2 = (EditText) findViewById(R.id.txtreferencec2relationship1);
        txtpannumber = (EditText) findViewById(R.id.txtpannumber);
        etother = (EditText) findViewById(R.id.txtOthervalue);

        chAdhar = (CheckBox) findViewById(R.id.checkboxadhar);
        chPAN = (CheckBox) findViewById(R.id.checkboxpan);
        chVoterID = (CheckBox) findViewById(R.id.checkboxvoterid);
        chDL = (CheckBox) findViewById(R.id.checkboxdrivinglicence);
        chPassport = (CheckBox) findViewById(R.id.checkboxpassport);
        chProofAdhar = (CheckBox) findViewById(R.id.checkboxproofAdhar);
        chProofVoterid = (CheckBox) findViewById(R.id.checkboxproofVoterid);
        chProofdl = (CheckBox) findViewById(R.id.checkboxproofDL);
        chProofElectricitybill = (CheckBox) findViewById(R.id.checkboxproofElectricitybill);
        chProofRntagmt = (CheckBox) findViewById(R.id.checkboxpeoofRentAgmt);
        chProofPassport = (CheckBox) findViewById(R.id.checkboxproofPassport);
        chProofGovtEmpid = (CheckBox) findViewById(R.id.checkboxproofGevtEmpID);
        chProofGumasta = (CheckBox) findViewById(R.id.checkboxproofGumasta);
        chProofCurrentacctStmt = (CheckBox) findViewById(R.id.checkboxproofCurrentAcctStmt);

        RcoapplicantYES = (RadioButton) findViewById(R.id.radioapplicantYes);
        RcoapplicantNO = (RadioButton) findViewById(R.id.radioapplicantNo);
        Ryes = (RadioButton) findViewById(R.id.radioYes);
        Rno = (RadioButton) findViewById(R.id.radioNo);
        Rug = (RadioButton) findViewById(R.id.radioUG);
        Rg = (RadioButton) findViewById(R.id.radioGraguate);
        Rpg = (RadioButton) findViewById(R.id.radioPG);
        Rpro = (RadioButton) findViewById(R.id.radioprofessional);
        Rother = (RadioButton) findViewById(R.id.radioother);
        Rmale = (RadioButton) findViewById(R.id.radioMale);
        Rfemale = (RadioButton) findViewById(R.id.radioFemale);

        //leed detaila
        txtldate = (TextView) findViewById(R.id.txtdate1);
        txtleadid = (TextView) findViewById(R.id.textheader);
        txtleadidvalue = (TextView) findViewById(R.id.txtleadidvalue);
        etleednumber = (TextView) findViewById(R.id.txtleadidvalue);
        txtleedtime = (TextView) findViewById(R.id.txtleedtime1);
        txtgeneratedby = (TextView) findViewById(R.id.txtagentid1);

        ArrayAdapter<String> spinnerArrayAdapterloantype = new ArrayAdapter(this, R.layout.sppinner_layout_listitem, loanType);
        spinnerArrayAdapterloantype.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinloantype.setAdapter(spinnerArrayAdapterloantype);
        spinloantype.setOnItemSelectedListener(Bank_Submit_Update_Activity.this);


        //INCOME
        String[] CompanyType = new String[]{"Private ltd", "Public ltd", "Limited Liability Partnership", "Partnership",
                "Sole Partnership", "Liason office/Repesentative office", "Project Office", "Branch Office", "joint venture company",
                "Subsidiary company", "Unilimited Company", "Other"};
        String[] SalaryType = new String[]{"AC Credit/Cheque", "Cash", "Comission"};

        Rsalaried = (RadioButton) findViewById(R.id.radioSalaried);
        Rselfemployed = (RadioButton) findViewById(R.id.radioselfEmployed);

        SPcompanytype = (Spinner) findViewById(R.id.spinnercompanytype);
        SPcompanytype.setOnItemSelectedListener(this);
        SPsalarytype = (Spinner) findViewById(R.id.spsalarytype);

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

        ArrayAdapter<String> spinnerArrayAdaptercompanyType = new ArrayAdapter(this, R.layout.sppinner_layout_listitem, CompanyType);
        spinnerArrayAdaptercompanyType.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        SPcompanytype.setAdapter(spinnerArrayAdaptercompanyType);
        ArrayAdapter<String> spinnerArrayAdapterSalaryType = new ArrayAdapter(this, R.layout.sppinner_layout_listitem,
                SalaryType);
        spinnerArrayAdapterSalaryType.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        SPsalarytype.setAdapter(spinnerArrayAdapterSalaryType);

//PROPERTY
        String[] APPropertytype = new String[]{"Perchase of flat", "Purchase of vila", "Purchase of plot", "Balance transfer",
                "Balance transfer +Top-Up", "Self Construction", "Renovation/Improvement", "Top-Up existing home loan", "loan for resale property",
                "Ready posession flat", "Under construction flat"};

        Rpresanctioned = (RadioButton) findViewById(R.id.radioPresanction);
        Rpurchasepropety = (RadioButton) findViewById(R.id.radiopurchasepropety);
        Ryes = (RadioButton) findViewById(R.id.radioYES);
        Rno = (RadioButton) findViewById(R.id.radioNO);

        SPpropertytype = (Spinner) findViewById(R.id.txtpropertytype1);
        ArrayAdapter<String> spinnerArrayAdapterProppertyType = new ArrayAdapter<String>(this, R.layout.sppinner_layout_listitem, APPropertytype);
        spinnerArrayAdapterProppertyType.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        SPpropertytype.setAdapter(spinnerArrayAdapterProppertyType);

        edtloanrequirement = (EditText) findViewById(R.id.txtloanrequirement1);
        edtdownpayment = (EditText) findViewById(R.id.txtdownpayment1);
        edtdescription = (EditText) findViewById(R.id.txtdescription1);

        edtpropertypin = (EditText) findViewById(R.id.txtpropertyaddresspin1);
        edtpropertylandmark = (EditText) findViewById(R.id.txtpropertylandmark1);
        edtpropertyarea = (EditText) findViewById(R.id.txtpropertyarea1);
        edtprojectname = (EditText) findViewById(R.id.txtpropertyprojectname1);

        bankSubmit = (Button) findViewById(R.id.buttonApprove);

        getSalesperson();

//        getdata();

        btupdate.setOnClickListener(new Bank_Submit_Update_Activity.C08031());
        bankSubmit.setOnClickListener(new Bank_Submit_Update_Activity.C08042());
    }

    private void getSalesperson() {

        userRepository.readsalesperson(SALES, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {

                    userlist = (ArrayList<User>) object;
                    for (int i = 0; i < userlist.size(); i++) {
                        salesPerson.add(userlist.get(i).getUserName());

                    }

                    ArrayAdapter<String> spinnerArrayAdaptersalesperson = new ArrayAdapter(getApplicationContext(),
                            R.layout.sppinner_layout_listitem, salesPerson);
                    spinnerArrayAdaptersalesperson.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                    SPsalesperson.setAdapter(spinnerArrayAdaptersalesperson);

                    getdata();
                }
            }

            @Override
            public void onError(Object object) {

            }
        });

    }

    private void getdata() {
        try {

            //LEED DETAILS
            String leedid = leedsModel.getLeedNumber();
            String agentname = leedsModel.getAgentName();
            Long ldatetime = leedsModel.getCreatedDateTimeLong();
            Long time = leedsModel.getCreatedDateTimeLong();
            spinloantype.setSelection(((ArrayAdapter) spinloantype.getAdapter()).getPosition(leedsModel.getLoanType()));


            if (ldatetime != null) {
                txtldate.setText(Utility.convertMilliSecondsToFormatedDate(leedsModel.getCreatedDateTimeLong().longValue(), Constant.GLOBAL_DATE_FORMATE));
            }
            if (time != null) {
                txtleedtime.setText(Utility.convertMilliSecondsToFormatedDate(leedsModel.getCreatedDateTimeLong().longValue(), "hh:mm a"));
            }
            if (leedid != null) {
                txtleadid.setText(leedid);
                txtleadidvalue.setText(leedid);
            }
            if (agentname != null) {
                txtgeneratedby.setText(agentname);
            }

            //APPLICANT DETAILS

            String cname = leedsModel.getCustomerName();
            String gender = leedsModel.getGender();
            String birthdate = leedsModel.getDateOfBirth();
            String contact = leedsModel.getMobileNumber();
            String altcontact = leedsModel.getAlternetMobileNumber();
            String email = leedsModel.getEmail();
            String education = leedsModel.getEducation();
            String otherEdu = leedsModel.getOtherEducation();
            String caddress = leedsModel.getAddress();
            String currentpin = leedsModel.getCurrentpin();
            String currentlandmark = leedsModel.getCurrentlandmark();
            String currentarea = leedsModel.getCurrentarea();
            String currentstreet = leedsModel.getCurrentstreet();
            String addressYN = leedsModel.getAddressYesNo();
            String perPIN = leedsModel.getPincode();
            String perLand = leedsModel.getLandmark();
            String perArea = leedsModel.getArea();
            String perStreet = leedsModel.getStreet();
            String residencial = leedsModel.getRecidential();
            String officeaddress = leedsModel.getofficeAdderess();

            String adhar = leedsModel.getadharNo();
            String pan = leedsModel.getCheckpanCardNumber();
            String pannumber = leedsModel.getPanCardNumber();
            String apvoterid = leedsModel.getApvoterid();
            String apdrivinglicence = leedsModel.getApdrivinglicence();
            String passport = leedsModel.getAppassport();

            String proofadhar = leedsModel.getProofadhar();
            String proofvoterid = leedsModel.getProofvoterid();
            String dlproof = leedsModel.getProofdl();
            String electricitybillproof = leedsModel.getProofelectricitybill();
            String rentagmtproof = leedsModel.getProofrentagmt();
            String passportproof = leedsModel.getProofpassport();
            String gevtidproof = leedsModel.getProofgevtid();
            String gumastaproof = leedsModel.getProofgumasta();
            String currentacctprrof = leedsModel.getProofcurrentacctstmt();

            String applicantYN = leedsModel.getCoApplicantYN();
            String prapplicantrelation = leedsModel.getPrapplicantrelation();
            String coapplicantotherrelation = leedsModel.getCoapplicantotherrelation();

            String prreference1name = leedsModel.getPrreference1name();
            String prreference1address = leedsModel.getPrreference1address();
            String prreferencecontactno = leedsModel.getPrreferencecontactno();
            String prreferencerelationship = leedsModel.getPrreferencerelationship();
            String prreference2name = leedsModel.getPrreference2name();
            String prreference2address = leedsModel.getPrreference2address();
            String prreference2contactno = leedsModel.getPrreference2contactno();
            String prreference2relationship = leedsModel.getPrreference2relationship();

            if (cname != null) {
                etcname.setText(cname);
            }
            if (gender != null) {
                if (gender.equalsIgnoreCase(Constant.MALE)) {
                    Rmale.setChecked(true);
                } else {
                    Rfemale.setChecked(true);
                }
            }
            if (birthdate != null) {
                etbirthdate.setText(birthdate);
            }
            if (contact != null) {
                etcontatct.setText(contact);
            }
            if (altcontact != null) {
                etalternatecontact.setText(altcontact);
            }
            if (email != null) {
                etcEmail.setText(email);
            }
            if (education != null) {
                if (education.equalsIgnoreCase("Under Graduate")) {
                    Rug.setChecked(true);
                } else if (education.equalsIgnoreCase("Graduate")) {
                    Rg.setChecked(true);
                } else if (education.equalsIgnoreCase("Post Graduate")) {
                    Rpg.setChecked(true);
                } else if (education.equalsIgnoreCase("Professional")) {
                    Rpro.setChecked(true);
                } else {
                    Rother.setChecked(true);
                }
            }
            if (otherEdu != null) {
                etother.setText(otherEdu);
            }
            if (caddress != null) {
                etaddress.setText(caddress);
            }
            if (currentpin != null) {
                Currentpin.setText(currentpin);
            }
            if (currentlandmark != null) {

                Currentlandmark.setText(currentlandmark);
            }
            if (currentarea != null) {
                Currentarea.setText(currentarea);
            }
            if (currentstreet != null) {
                Currentstreet.setText(currentstreet);
            }
            if (addressYN != null) {
                if (addressYN.equalsIgnoreCase("Yes")) {
                    Ryes.setChecked(true);
                } else {
                    Rno.setChecked(true);
                }
            }

            if (perPIN != null) {
                pin.setText(perPIN);
            }
            if (perLand != null) {

                landmark.setText(perLand);
            }
            if (perArea != null) {
                area.setText(perArea);
            }
            if (perStreet != null) {
                street.setText(perStreet);
            }
            if (officeaddress != null) {
                etoffaddress.setText(officeaddress);
            }

            try {
                if (residencial != null) {
                    ArrayAdapter myAdap2 = (ArrayAdapter) Recidential.getAdapter();
                    int spinnerpos = myAdap2.getPosition(residencial);
                    Recidential.setSelection(spinnerpos);

                }
            } catch (Exception e) {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            if (adhar != null) {
                chAdhar.setChecked(true);
            }
            if (pannumber != null) {
                chPAN.setChecked(true);
                txtpannumber.setText(pannumber);
            }
            if (apvoterid != null) {
                chVoterID.setChecked(true);
            }
            if (apdrivinglicence != null) {
                chDL.setChecked(true);
            }
            if (passport != null) {
                chPassport.setChecked(true);
            }

            if (proofadhar != null) {
                chProofAdhar.setChecked(true);
            }
            if (proofvoterid != null) {
                chProofVoterid.setChecked(true);
            }
            if (dlproof != null) {
                chProofdl.setChecked(true);
            }
            if (electricitybillproof != null) {
                chProofElectricitybill.setChecked(true);
            }
            if (rentagmtproof != null) {
                chProofRntagmt.setChecked(true);
            }
            if (passportproof != null) {
                chProofPassport.setChecked(true);
            }
            if (gevtidproof != null) {
                chProofGovtEmpid.setChecked(true);
            }
            if (gumastaproof != null) {
                chProofGumasta.setChecked(true);
            }
            if (currentacctprrof != null) {
                chProofCurrentacctStmt.setChecked(true);
            }
            if (applicantYN == null) {

            } else if (applicantYN.equalsIgnoreCase("Yes")) {

                RcoapplicantYES.setChecked(true);
            } else {

                if (applicantYN.equalsIgnoreCase("No")) {
                    RcoapplicantNO.setChecked(true);
                }
            }
            try {
                if (prapplicantrelation != null) {
                    ArrayAdapter myAdap = (ArrayAdapter) CoapplicantRalationship.getAdapter();
                    CoapplicantRalationship.setSelection(myAdap.getPosition(prapplicantrelation));
                }
            } catch (Exception e) {

            }
            if (coapplicantotherrelation != null) {
                edtotherrelationship.setText(coapplicantotherrelation);
            }
            if (prreference1name != null) {
                edtreferencename.setText(prreference1name);
            }

            if (prreference1address != null) {
                edtreferenceaddress.setText(prreference1address);
            }
            if (prreferencecontactno != null) {
                edtreferencecontactno.setText(prreferencecontactno);
            }
            if (prreferencerelationship != null) {
                edtreferencerelationship.setText(prreferencerelationship);
            }
            if (prreference2name != null) {
                edtreferencename2.setText(prreference2name);
            }
            if (prreference2address != null) {
                edtreferenceaddress2.setText(prreference2address);
            }
            if (prreference2contactno != null) {
                edtreferencecontactno2.setText(prreference2contactno);
            }
            if (prreference2relationship != null) {
                edtreferencerelationship2.setText(prreference2relationship);
            }


            //INCOME DETAILS

            String sEmployed = leedsModel.getEmployed();
            String sCompanytype = leedsModel.getCompanytype();
            String othercompany = leedsModel.getOthercompany();
            String sTenure = leedsModel.getTenure();
            String experience = leedsModel.getExperience();
            String department = leedsModel.getDepartment();
            String designation = leedsModel.getDesignation();
            String grosssalary = leedsModel.getGrosssalary();
            String netsalary = leedsModel.getNetsalary();
            String overtime = leedsModel.getOvertime();
            String incentive = leedsModel.getIncentive();
            String bonus = leedsModel.getBonus();
            String sRentalincom = leedsModel.getRentalincome();
            String sAgreeincome = leedsModel.getAggrecultureIncome();
            String sAnnualincome = leedsModel.getAnnualincome();
            String sotherincome = leedsModel.getOtherIncome();
            String sSalarytype = leedsModel.getSalaytype();

            String sRental = leedsModel.getRental();
            String sEMIcar = leedsModel.getEmicar();
            String sEMIhome = leedsModel.getEmihome();
            String sEMIsociety = leedsModel.getEmisociety();
            String sEMIpersonal = leedsModel.getEmipersonal();
            String carloanamt = leedsModel.getCarLoanAmount();
            String homeloanamt = leedsModel.getHomeLoanAmount();
            String societyloanamt = leedsModel.getSocietyLoanAmount();
            String personalloanamt = leedsModel.getPersonalLoanAmount();
            String sEMIother = leedsModel.getEmiother();
            String emiOtherDetails = leedsModel.getEmiOtherDetails();

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

            String bankname = leedsModel.getBanknName();
            String branchname = leedsModel.getBranchName();
            String ifsccode = leedsModel.getIfscCode();
            String loginid = leedsModel.getLoginid();
            String salsepersone = leedsModel.getSalesPerson();

            if (bankname != null) {
                edtbankname.setText(bankname);
            }
            if (branchname != null) {
                edtbranchname.setText(branchname);
            }
            if (ifsccode != null) {
                edtifsccode.setText(ifsccode);
            }
            if (loginid != null) {
                edtloginid.setText(loginid);
            }
            ArrayAdapter myAdap0 = (ArrayAdapter) SPsalesperson.getAdapter();
            SPsalesperson.setSelection(myAdap0.getPosition(salsepersone));

            ArrayAdapter myAdap = (ArrayAdapter) SPcompanytype.getAdapter();
            SPcompanytype.setSelection(myAdap.getPosition(sCompanytype));


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
            if (sTenure != null) {
                edttenure.setText(sTenure);
            }
            if (experience != null) {
                edtexperience.setText(experience);
            }
            if (department != null) {
                edtdepartment.setText(department);
            }
            if (designation != null) {
                edtdesignation.setText(designation);
            }

            if (grosssalary != null) {
                edtgrosssalary.setText(grosssalary);
            }
            if (netsalary != null) {
                edtnetsalary.setText(netsalary);
            }
            if (overtime != null) {
                edtovertime.setText(overtime);
            }
            if (incentive != null) {
                edtincentive.setText(incentive);
            }
            if (bonus != null) {

                edtbonus.setText(bonus);
            }
            if (sRentalincom != null) {
                edtrentalincome.setText(sRentalincom);
            }
            if (sAnnualincome != null) {
                edtannualincome.setText(sAnnualincome);
            }
            if (sAgreeincome != null) {
                edtagrreculturincom.setText(sAgreeincome);
            }
            if (sotherincome != null) {
                edtotherincome.setText(sotherincome);
            }

            ArrayAdapter myAdap3 = (ArrayAdapter) SPsalarytype.getAdapter();
            SPsalarytype.setSelection(myAdap3.getPosition(sSalarytype));
            //         SPsalarytype.setSelection(((ArrayAdapter) SPsalarytype.getAdapter()).getPosition(sSalarytype));

            if (sRental != null) {
                edtrental.setText(sRental);
            }
            if (sEMIcar != null) {
                chcarloan.setChecked(true);
                txtCarloan.setText(carloanamt);
            }
            if (sEMIhome != null) {

                chhomloan.setChecked(true);
                txtHomeloan.setText(homeloanamt);
            }
            if (sEMIsociety != null) {
                chsocietyloan.setChecked(true);
                txtsocietyloan.setText(societyloanamt);
            }
            if (sEMIpersonal != null) {
                chpersonalloan.setChecked(true);
                txtpersonalloan.setText(personalloanamt);
            }
            if (sEMIother != null) {
                chotherloan.setChecked(true);
                edtotheremidetails.setText(emiOtherDetails);

            }
            if (sSalrysleep != null) {
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


            //PROPERTY DETAILS
            String property = leedsModel.getPropety();
            String YN = leedsModel.getPropetyYN();
            String loanrequirement = leedsModel.getExpectedLoanAmount();
            String downpayment = leedsModel.getDownpayment();

            String propertypin = leedsModel.getPrpropertypin();
            String propertylandmark = leedsModel.getPrpropertylandmark();
            String propertyarea = leedsModel.getPrpropertyarea();
            String projectname = leedsModel.getPrprojectname();
            String description = leedsModel.getPrdescripiton();

            String propertytype = leedsModel.getPrpropertytype();

            ArrayAdapter myAdap4 = (ArrayAdapter) SPpropertytype.getAdapter();
            int spinnerPosition = myAdap4.getPosition(propertytype);
            SPpropertytype.setSelection(spinnerPosition);

            if (property != null) {
                if (property.equalsIgnoreCase("Pre-Sanction")) {
                    Rpresanctioned.setChecked(true);
                    Ryes.setChecked(false);
                    Rno.setChecked(true);

                } else if (property.equalsIgnoreCase("Purchase Propety identified")) {
                    Rpurchasepropety.setChecked(true);
                }
            }

            if (YN != null) {
                if (YN.equalsIgnoreCase("No")) {
                    Rno.setChecked(true);

                } else if (YN.equalsIgnoreCase("Yes")) {
                    Ryes.setChecked(true);
                }
            }

            if (loanrequirement != null) {
                edtloanrequirement.setText(loanrequirement);

            }

            if (downpayment != null) {
                edtdownpayment.setText(downpayment);

            }
            if (propertypin != null) {
                edtpropertypin.setText(propertypin);

            }
            if (propertylandmark != null) {
                edtpropertylandmark.setText(propertylandmark);

            }
            if (propertyarea != null) {
                edtpropertyarea.setText(propertyarea);

            }
            if (projectname != null) {
                edtprojectname.setText(projectname);

            }
            if (description != null) {
                edtdescription.setText(description);

            }

        } catch (Exception e) {
        }

    }

    private void setLeedStatus(LeedsModel leedsModel) {
        leedsModel.setStatus(Constant.STATUS_BANK_APPROVED);
        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap1());
    }

    private void updateLeadDetails(LeedsModel leedsModel) {

        leedsModel.setCustomerName(Scusomername);
        leedsModel.setAddress(cAdress);
        leedsModel.setMobileNumber(Scontactno);
        leedsModel.setAlternetMobileNumber(Saltcontact);
        leedsModel.setDateOfBirth(cBdate);
        leedsModel.setOfficeAdderess(Sofficeaddress);
        leedsModel.setRecidential(Sresidentialtype);
        leedsModel.setCurrentpin(Scurrentpin);
        leedsModel.setCurrentarea(Scurrentarea);
        leedsModel.setCurrentlandmark(Scurrentland);
        leedsModel.setCurrentstreet(Scurrentstreet);
        if (SaddressYN.equalsIgnoreCase("No")) {
            leedsModel.setPincode(Sperpin);
            leedsModel.setArea(Sperarea);
            leedsModel.setLandmark(Sperland);
            leedsModel.setStreet(Sperstreet);
        } else if (SaddressYN.equalsIgnoreCase("Yes")) {
            leedsModel.setPincode(Scurrentpin);
            leedsModel.setArea(Scurrentarea);
            leedsModel.setLandmark(Scurrentland);
            leedsModel.setStreet(Scurrentstreet);
        }
        leedsModel.setEmail(Semail);
        leedsModel.setAdharNo(Skycadhar);
        leedsModel.setCheckpanCardNumber(Skycpan);
        leedsModel.setPanCardNumber(Akycpannumber);
        leedsModel.setOtherEducation(Sotheredudetails);
        leedsModel.setApvoterid(Skycvoterid);
        leedsModel.setApdrivinglicence(SkycDL);
        leedsModel.setAppassport(Skycpassport);
        leedsModel.setProofadhar(Sproofadhar);
        leedsModel.setProofvoterid(Sproofvoterid);
        leedsModel.setProofdl(SproofDL);
        leedsModel.setProofelectricitybill(Sproofelectricitybill);
        leedsModel.setProofrentagmt(Sproofrentagmt);
        leedsModel.setProofpassport(Sproofpassport);
        leedsModel.setProofgevtid(Sproofgovtid);
        leedsModel.setProofgumasta(Sproofgumasta);
        leedsModel.setProofcurrentacctstmt(Sproofcurrentacctstmt);
        leedsModel.setPrapplicantrelation(Scoapplicantrelation);
        leedsModel.setCoapplicantotherrelation(Scoapplicantotherrelationdetails);
        leedsModel.setPrreference1name(Sref1nmae);
        leedsModel.setPrreference1address(Sref1address);
        leedsModel.setPrreferencecontactno(Sref1contact);
        leedsModel.setPrreferencerelationship(Sref1relation);
        leedsModel.setPrreference2name(Sref2name);
        leedsModel.setPrreference2address(Sref2address);
        leedsModel.setPrreference2contactno(Sref2contact);
        leedsModel.setPrreference2relationship(Sref2relation);
        leedsModel.setEducation(SEducation);
        leedsModel.setGender(Scustomergender);
        leedsModel.setAddressYesNo(SaddressYN);
        leedsModel.setCoApplicantYN(ScoapplicantYN);


        leedsModel.setEmployed(Soccupationtype);
        leedsModel.setCompanytype(Scompanytype);
        leedsModel.setSalaytype(Ssalarycomesin);
        leedsModel.setEmicar(Scarloan);
        leedsModel.setEmihome(Shomelloan);
        leedsModel.setEmisociety(Ssocietyloan);
        leedsModel.setEmipersonal(Spersonalloan);
        leedsModel.setCarLoanAmount(Scarloanamt);
        leedsModel.setHomeLoanAmount(Shomeloanamt);
        leedsModel.setSocietyLoanAmount(Ssocietyloanamt);
        leedsModel.setPersonalLoanAmount(Spersonalloanamt);
        leedsModel.setEmiother(Sotherloan);
        leedsModel.setOthercompany(Sothercmptype);
        leedsModel.setTenure(Stenure);
        leedsModel.setExperience(Sworkexp);
        leedsModel.setDepartment(Sdepartment);
        leedsModel.setDesignation(Sdesignation);
        leedsModel.setGrosssalary(Smonthlygrosssalary);
        leedsModel.setNetsalary(Snetsalary);
        leedsModel.setOvertime(Sovertime);
        leedsModel.setIncentive(Sinsentive);
        leedsModel.setBonus(Sbonus);
        leedsModel.setRentalincome(Srentalincome);
        leedsModel.setAnnualincome(Sannualincome);
        leedsModel.setRental(Srentalexpence);
        leedsModel.setSalarysleep(Ssalarysleep);
        leedsModel.setBankstmt(Sbankstmt);
        leedsModel.setForm(Sform16);
        leedsModel.setAppointmentltr(Sappointmentletter);
        leedsModel.setConformationltr(Sconfermationletter);
        leedsModel.setExperinceltr(Sexperienceletter);
        leedsModel.setVisa(Snrivisa);
        leedsModel.setPassport(Snripassport);
        leedsModel.setEmploerltr(Snriemployerletter);
        leedsModel.setContractltr(Snricontractletter);
        leedsModel.setPoa(Snripoa);
        leedsModel.setNrebankstmt(SNREbankacct);
        leedsModel.setOverseasbankdetail(Soverseasebankacct);
        leedsModel.setItr(Sitr);
        leedsModel.setCurrentbankstmt(Scurrentacctstmt);
        leedsModel.setSavingacctstmt(Ssavingacctstmt);
        leedsModel.setPartnersheepdeed(Spartnershipdeed);
        leedsModel.setBusinessagmt(Sbusinessagmt);
        leedsModel.setQualification(Squalificationcirtificate);
        leedsModel.setAggrecultureIncome(Sagreeincome);
        leedsModel.setOtherIncome(Sotherincome);
        leedsModel.setEmiOtherDetails(Sotherloanamt);

        leedsModel.setPropety(saboutpropety);
        leedsModel.setPropetyYN(sYN);
        leedsModel.setExpectedLoanAmount(Sprloanrequirement);
        leedsModel.setDownpayment(Sprdownpayment);

        leedsModel.setPrpropertypin(Sprpin);
        leedsModel.setPrpropertylandmark(Sprland);
        leedsModel.setPrpropertyarea(Sprarea);
        leedsModel.setPrprojectname(Sprprojectname);
        leedsModel.setPrdescripiton(Sprdescriptio);
        leedsModel.setPrpropertytype(Sprpropertytype);

        leedsModel.setBanknName(Sbankname);
        leedsModel.setBranchName(Sbranchname);
        leedsModel.setIfscCode(Sifsccode);
        leedsModel.setLoginid(Sloginid);
        leedsModel.setSalesPerson(Ssalespersone);

        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap());
    }



    private void updateLeed(String leedId, Map leedsMap) {
        progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));
        leedRepository.updateLeed(leedId, leedsMap, new C09234());
    }

    public void onItemSelected(AdapterView<?> adapterView, View arg1, int position, long id) {
        sploantype = spinloantype.getSelectedItem().toString();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

}
