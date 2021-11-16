package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.content.Context;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
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
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.UserRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.SALES;

public class View_Leed_Details_Activity extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {

    Spinner CoapplicantRalationship;
    RadioButton REducation;
    RadioButton RYN;
    RadioButton RcoapplicantNO;
    RadioButton RcoapplicantYES;
    Spinner Recidential;
    RadioButton Rfemale,   Rg, Rgender, Rmale, Rno, Rother, Rpg, Rpro, Rug, Ryes;

    AppSharedPreference appSharedPreference;
    EditText area;
    Button btcancel, btupdate, btverify;
    String cAdharno, cAdress, cAltcontatct, cBank, cBdate, cContatct, cDescreption, cExamount, cIncome, cNmae,
            cOffaddress, cPadress, cPanno;

    CheckBox chAdhar, chDL, chPAN, chPassport, chProofAdhar, chProofCurrentacctStmt, chProofElectricitybill, chProofGovtEmpid,
            chProofGumasta, chProofPassport, chProofRntagmt, chProofVoterid, chProofdl, chVoterID;

    EditText Currentarea, Currentlandmark, Currentpin, Currentstreet, edtotherrelationship, edtreferenceaddress, edtreferenceaddress2, edtreferencecontactno,
            edtreferencecontactno2, edtreferencename, edtreferencename2, edtreferencerelationship, edtreferencerelationship2,
            etaddress, etadharno, etalternatecontact, etbank, etbirthdate, etcEmail, etcname, etcontatct, etdescription, etexammount,
            etgenerated, etincome, etoccupation, etoffaddress, etother, etpanno, etpermanantaddress, etpropaddress;


    String lGenby;
    EditText landmark, pin, street, txtpannumber;
    LeedRepository leedRepository;
    com.smartloan.smtrick.smart_loan_admin_new.repository.UserRepository UserRepository;
    LeedsModel leedsModel;
    ProgressDialogClass progressDialogClass;
    Spinner spinemptype, spinincome, spinloantype;
    String sploantype, spoccupation;
    TextView etleednumber,txtgeneratedby, txtldate, txtleadid, txtleadidvalue, txtleedtime;

    //INCOME
    Spinner SPcompanytype, SPsalarytype,SPsalesperson;
    RadioButton Rsalaried,Rselfemployed, Rpresanctioned, Rpurchasepropety, Rproperty, Ryn,
            Rcoapplicant, Remployed;

    EditText edtagrreculturincom, edtannualincome, edtbonus, edtdepartment, edtdesignation, edtexperience, edtgrosssalary,
            edtincentive, edtnetsalary, edtothercompany, edtotheremidetails, edtotherincome, edtovertime, edtrental, edtrentalincome,
            edttenure, txtCarloan, txtHomeloan, txtpersonalloan, txtsocietyloan;

    CheckBox chNREbankstatement, chPOA, chappointmentletter, chbankstatement, chbisunessagreement, chcarloan, chconfermationletter,
            chcontractletter, chcurrentbankstatement, chemployerletter, chexperieceletter, chformno16, chhomloan, chitr, chotherloan,
            choverbankdetails, chpartnersheepdeed, chpassport, chpersonalloan, chqualification, chsalarysleep, chsavingacctstatement,
            chsocietyloan, chvisa;

    //PROPERTY
    Spinner SPpropertytype;
    EditText edtloanrequirement, edtdownpayment, edtdescription, edtpropertypin, edtpropertylandmark, edtpropertyarea,
            edtprojectname, edtbankname, edtbranchname, edtifsccode,edtappointment;

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
            Sbankname, Sbranchname, Sifsccode, Sappointment,Ssalespersone,
            saboutpropety, sYN;

    RadioGroup groupAboutproperty, groupAboutpropetyYN, groupRadioGender, groupRadioEducation, groupRadio, groupRadiocoapplicant;

    RadioGroup groupRadioEmployed;

    List<String> SalesPerson;
    List<User> userlist;

//    Button btnBank, btnChecklist, btnAppointment, btnSales;
ImageButton btnUpdate;

    RelativeLayout layoutDate, layoutContact, layoutAltContact, layoutEmail, layoutEducation, layoutOtherDetails,
            layoutCurrentAddress, layoutPin, layoutLandmark, layoutArea, layoutStreet, layoutIfSame,
            layoutpin1, layoutland, layoutSameArea, layoutSameStreet, layoutResidentialtype, layoutOfficeAddress,
            layoutpancard, layoutcoapplicantrelation, layoutothercompany, layouttenure, layoutexperience, layoutdepartment,
            layoutdesignation, layoutgrosssalary, layoutnetsalary, layoutovertime, layoutincentive, layoutbonus, layoutrent,
            layoutagreecultureincome, layoutannualincome, layoutotherincome, layoutothers, layoutrentalexpence, layoutcarloan,
            layouthomeloan, layoutsocietyloan, layoutpersonalloan, layoutotheremidetails, layoutpropertyaddresspin,
            layoutpropertyaddresslandmark, layoutpropertyaddressarea, layoutpropertyaddressprojectname, layoutpropertytype,
            layoutLoanrequirement, layoutDownpayment, layotDescription, layoutsalesperson, layoutreferencefullname, layoutreferenceaddress, layoutreferencecontactno,
            layoutreferencerelationhsip, layoutreference2fullname, layoutreference2address, layoutreference2contactno, layoutreference2relationhsip,
            layoutCompanytype, layoutpermenantaddress, layoutotherrelationship,
            layoutbankname, layoutbranchname, layoutifsccode,layoutappointment;

    int fromYear, fromMonth, fromDay;
    int toYear, toMonth, toDay;
    long fromDate, toDate;

    @Override
    public void onClick(View v) {

    }

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
            if (chpassport.isChecked()) {
                Snripassport = chpassport.getText().toString();
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
            Sappointment = edtappointment.getText().toString();
            Ssalespersone = SPsalesperson.getSelectedItem().toString();

            updateLeadDetails(leedsModel);
            Toast.makeText(getApplicationContext(), "Lead Update Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.Coordinator_Update_Activity$4 */
    class C09234 extends CallBack {
        C09234() {
        }

        public void onSuccess(Object object) {
            Toast.makeText(getApplicationContext(), "Lead Updated Successfully", Toast.LENGTH_SHORT).show();
            progressDialogClass.dismissDialog();
        }

        public void onError(Object object) {
            progressDialogClass.dismissDialog();
            Context context = View_Leed_Details_Activity.this;
            Utility.showLongMessage(context, context.getString(R.string.server_error));
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_lead_details);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        leedsModel = (LeedsModel) getIntent().getSerializableExtra(Constant.LEED_MODEL);
        progressDialogClass = new ProgressDialogClass(this);
        leedRepository = new LeedRepositoryImpl();
        UserRepository = new UserRepositoryImpl();
        appSharedPreference = new AppSharedPreference(this);

        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"#ffffff\">" + leedsModel.getLeedNumber() + "</font>"));


        String[] loanType = new String[]{"HOME LOAN", "LOAN AGAINST PROPERTY"};
        String[] empType = new String[]{"Salaried", "Businessman"};
        String[] recidential = new String[]{"Owned", "Rented", "Allotted by Employer", "Family"};
        String[] CoapplicantRelation = new String[]{"Spouse", "Parents", "Children", "Power of Attorney", "Please specify"};
        String[] salesperson = new String[]{"Amit Kumar", "Rahul rathi", "Suraj chavan", "sagar mule"};

        SalesPerson = new ArrayList<>();
        getSalesperson();

        groupAboutproperty = (RadioGroup) findViewById(R.id.radioGroupaboutproperty);
        groupAboutpropetyYN = (RadioGroup) findViewById(R.id.radioGroupaboutpropertyYesNo);

        groupRadioGender = (RadioGroup) findViewById(R.id.radioSex);
        groupRadioEducation = (RadioGroup) findViewById(R.id.radioeducation);
        groupRadio = (RadioGroup) findViewById(R.id.radioGYN);
        groupRadiocoapplicant = (RadioGroup) findViewById(R.id.radiocoapplicantYN);

        groupRadioEmployed = (RadioGroup) findViewById(R.id.radioOccupation);

        edtbankname = (EditText) findViewById(R.id.txtbankname1);
        edtbankname.setEnabled(false);
        edtbranchname = (EditText) findViewById(R.id.txtbranchname1);
        edtbranchname.setEnabled(false);
        edtifsccode = (EditText) findViewById(R.id.txtifsccode1);
        edtifsccode.setEnabled(false);
        edtappointment = (EditText) findViewById(R.id.txtappointment1);
        edtappointment.setEnabled(false);

        SPsalesperson = (Spinner) findViewById(R.id.txtsalespersonname1);
        SPsalesperson.setEnabled(false);
        spinloantype = (Spinner) findViewById(R.id.sploantype1);
        spinloantype.setEnabled(false);

        //  btupdate = (Button) findViewById(R.id.buttonupdate);

        txtleadid = (TextView) findViewById(R.id.textheader);

        etcname = (EditText) findViewById(R.id.txtcamevalue);
        etaddress = (EditText) findViewById(R.id.txtcurrentaddressvalue);
        etaddress.setEnabled(false);
        etpermanantaddress = (EditText) findViewById(R.id.txtpermenantaddressvalue);
        etpermanantaddress.setEnabled(false);
        Currentpin = (EditText) findViewById(R.id.txtcurrentpin1);
        Currentpin.setEnabled(false);
        Currentlandmark = (EditText) findViewById(R.id.txtcurrentlandmark1);
        Currentlandmark.setEnabled(false);
        Currentarea = (EditText) findViewById(R.id.txtcurrentarea1);
        Currentarea.setEnabled(false);
        Currentstreet = (EditText) findViewById(R.id.txtcurrentstreet1);
        Currentstreet.setEnabled(false);
        pin = (EditText) findViewById(R.id.txtpin1);
        pin.setEnabled(false);
        landmark = (EditText) findViewById(R.id.txtlandmark1);
        landmark.setEnabled(false);
        area = (EditText) findViewById(R.id.txtarea1);
        area.setEnabled(false);
        street = (EditText) findViewById(R.id.txtstreet1);
        street.setEnabled(false);
        etoffaddress = (EditText) findViewById(R.id.txtofficeaddressvalue);
        etoffaddress.setEnabled(false);
        etbirthdate = (EditText) findViewById(R.id.txtbirthdatevalue);
        etbirthdate.setEnabled(false);
        etcontatct = (EditText) findViewById(R.id.txtcontatctvalue);
        etcontatct.setEnabled(false);
        etalternatecontact = (EditText) findViewById(R.id.edtaltcontact);
        etalternatecontact.setEnabled(false);
        etcEmail = (EditText) findViewById(R.id.txtemail1);
        etcEmail.setEnabled(false);

        Recidential = (Spinner) findViewById(R.id.spinnerrecidencialvalue);
        Recidential.setEnabled(false);
        ArrayAdapter<String> spinnerArrayAdapterRecidential = new ArrayAdapter(this, R.layout.sppinner_layout_listitem, recidential);
        spinnerArrayAdapterRecidential.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        Recidential.setAdapter(spinnerArrayAdapterRecidential);

        CoapplicantRalationship = (Spinner) findViewById(R.id.txtcoapplicantrelation1);
        CoapplicantRalationship.setEnabled(false);
        ArrayAdapter<String> spinnerArrayAdapterRelationship = new ArrayAdapter(this, R.layout.sppinner_layout_listitem, CoapplicantRelation);
        spinnerArrayAdapterRelationship.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        CoapplicantRalationship.setAdapter(spinnerArrayAdapterRelationship);

        edtotherrelationship = (EditText) findViewById(R.id.txtotherrelationship1);
        edtreferencename = (EditText) findViewById(R.id.txtreferencefullname1);
        edtreferenceaddress = (EditText) findViewById(R.id.txtreferenceaddress1);
        edtreferencecontactno = (EditText) findViewById(R.id.txtreferencecontactno1);
        edtreferencecontactno.setEnabled(false);
        edtreferencerelationship = (EditText) findViewById(R.id.txtreferencecrelationship1);
        edtreferencename2 = (EditText) findViewById(R.id.txtreference2fullname1);
        edtreferenceaddress2 = (EditText) findViewById(R.id.txtreference2address1);
        edtreferencecontactno2 = (EditText) findViewById(R.id.txtreference2contactno1);
        edtreferencecontactno2.setEnabled(false);
        edtreferencerelationship2 = (EditText) findViewById(R.id.txtreferencec2relationship1);
        txtpannumber = (EditText) findViewById(R.id.txtpannumber);
        etother = (EditText) findViewById(R.id.txtOthervalue);

        chAdhar = (CheckBox) findViewById(R.id.checkboxadhar);
        chAdhar.setEnabled(false);
        chPAN = (CheckBox) findViewById(R.id.checkboxpan);
        chPAN.setEnabled(false);
        chVoterID = (CheckBox) findViewById(R.id.checkboxvoterid);
        chVoterID.setEnabled(false);
        chDL = (CheckBox) findViewById(R.id.checkboxdrivinglicence);
        chDL.setEnabled(false);
        chPassport = (CheckBox) findViewById(R.id.checkboxpassport);
        chPassport.setEnabled(false);
        chProofAdhar = (CheckBox) findViewById(R.id.checkboxproofAdhar);
        chProofAdhar.setEnabled(false);
        chProofVoterid = (CheckBox) findViewById(R.id.checkboxproofVoterid);
        chProofVoterid.setEnabled(false);
        chProofdl = (CheckBox) findViewById(R.id.checkboxproofDL);
        chProofdl.setEnabled(false);
        chProofElectricitybill = (CheckBox) findViewById(R.id.checkboxproofElectricitybill);
        chProofElectricitybill.setEnabled(false);
        chProofRntagmt = (CheckBox) findViewById(R.id.checkboxpeoofRentAgmt);
        chProofRntagmt.setEnabled(false);
        chProofPassport = (CheckBox) findViewById(R.id.checkboxproofPassport);
        chProofPassport.setEnabled(false);
        chProofGovtEmpid = (CheckBox) findViewById(R.id.checkboxproofGevtEmpID);
        chProofGovtEmpid.setEnabled(false);
        chProofGumasta = (CheckBox) findViewById(R.id.checkboxproofGumasta);
        chProofGumasta.setEnabled(false);
        chProofCurrentacctStmt = (CheckBox) findViewById(R.id.checkboxproofCurrentAcctStmt);
        chProofCurrentacctStmt.setEnabled(false);

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
        spinloantype.setOnItemSelectedListener(View_Leed_Details_Activity.this);

        //INCOME
        String[] CompanyType = new String[]{"Private ltd", "Public ltd", "Limited Liability Partnership", "Partnership", "Sole Partnership", "Liason office/Repesentative office", "Project Office", "Branch Office", "joint venture company", "Subsidiary company", "Unilimited Company", "Other"};
        String[] SalaryType = new String[]{"AC Credit/Cheque", "Cash", "Comission"};

        Rsalaried = (RadioButton) findViewById(R.id.radioSalaried);
        Rselfemployed = (RadioButton) findViewById(R.id.radioselfEmployed);
        SPcompanytype = (Spinner) findViewById(R.id.spinnercompanytype);
        SPcompanytype.setEnabled(false);
        SPcompanytype.setOnItemSelectedListener(this);
        SPsalarytype = (Spinner) findViewById(R.id.spsalarytype);
        SPsalarytype.setEnabled(false);

        edttenure = (EditText) findViewById(R.id.txttenure1);
        edtexperience = (EditText) findViewById(R.id.txtexperience1);
        edtdepartment = (EditText) findViewById(R.id.txtdepartment1);
        edtdesignation = (EditText) findViewById(R.id.txtdesignation1);
        edtgrosssalary = (EditText) findViewById(R.id.txtmontlygrossincome1);
        edtgrosssalary.setEnabled(false);
        edtnetsalary = (EditText) findViewById(R.id.txtnetsalary1);
        edtnetsalary.setEnabled(false);
        edtovertime = (EditText) findViewById(R.id.txtovertime1);
        edtovertime.setEnabled(false);
        edtincentive = (EditText) findViewById(R.id.txtiincentive1);
        edtincentive.setEnabled(false);
        edtbonus = (EditText) findViewById(R.id.txtbonus1);
        edtbonus.setEnabled(false);
        edtrentalincome = (EditText) findViewById(R.id.txtrent1);
        edtrentalincome.setEnabled(false);
        edtannualincome = (EditText) findViewById(R.id.txtannualincome1);
        edtannualincome.setEnabled(false);
        edtrental = (EditText) findViewById(R.id.txtrentalexpence1);
        edtrental.setEnabled(false);
        edtothercompany = (EditText) findViewById(R.id.txtothercompany1);
        edtagrreculturincom = (EditText) findViewById(R.id.txtagreecultureincome1);
        edtagrreculturincom.setEnabled(false);
        edtotherincome = (EditText) findViewById(R.id.txtotherincome1);
        edtotherincome.setEnabled(false);
        edtotheremidetails = (EditText) findViewById(R.id.txtotheremi1);
        txtCarloan = (EditText) findViewById(R.id.txtcarloanamount);
        txtHomeloan = (EditText) findViewById(R.id.txthomeloanamount);
        txtsocietyloan = (EditText) findViewById(R.id.txtsocietyloanamount);
        txtpersonalloan = (EditText) findViewById(R.id.txtpersonalloanamount);

        chsalarysleep = (CheckBox) findViewById(R.id.checkboxsalarysleep);
        chsalarysleep.setEnabled(false);
        chbankstatement = (CheckBox) findViewById(R.id.checkboxbankstatement);
        chbankstatement.setEnabled(false);
        chformno16 = (CheckBox) findViewById(R.id.checkboxform16);
        chformno16.setEnabled(false);
        chappointmentletter = (CheckBox) findViewById(R.id.checkboxappointmentletter);
        chappointmentletter.setEnabled(false);
        chconfermationletter = (CheckBox) findViewById(R.id.checkboxconfermationletter);
        chconfermationletter.setEnabled(false);
        chexperieceletter = (CheckBox) findViewById(R.id.checkboxexpletter);
        chexperieceletter.setEnabled(false);
        chvisa = (CheckBox) findViewById(R.id.checkboxvisa);
        chvisa.setEnabled(false);
        chpassport = (CheckBox) findViewById(R.id.checkboxpassport);
        chpassport.setEnabled(false);
        chemployerletter = (CheckBox) findViewById(R.id.checkboxEmployerletter);
        chemployerletter.setEnabled(false);
        chcontractletter = (CheckBox) findViewById(R.id.checkboxcontractletter);
        chcontractletter.setEnabled(false);
        chPOA = (CheckBox) findViewById(R.id.checkboxPOA);
        chPOA.setEnabled(false);
        chNREbankstatement = (CheckBox) findViewById(R.id.checkboxNREbank);
        chNREbankstatement.setEnabled(false);
        choverbankdetails = (CheckBox) findViewById(R.id.checkboxOverseasbank);
        choverbankdetails.setEnabled(false);
        chitr = (CheckBox) findViewById(R.id.checkboxITR);
        chitr.setEnabled(false);
        chcurrentbankstatement = (CheckBox) findViewById(R.id.checkboxcurrentaccountstatement);
        chcurrentbankstatement.setEnabled(false);
        chsavingacctstatement = (CheckBox) findViewById(R.id.checkboxsavingacctstatement);
        chsavingacctstatement.setEnabled(false);
        chpartnersheepdeed = (CheckBox) findViewById(R.id.checkboxpartnerdeed);
        chpartnersheepdeed.setEnabled(false);
        chbisunessagreement = (CheckBox) findViewById(R.id.checkboxbusinessagreement);
        chbisunessagreement.setEnabled(false);
        chqualification = (CheckBox) findViewById(R.id.checkboxqualification);
        chqualification.setEnabled(false);
        chcarloan = (CheckBox) findViewById(R.id.checkboxCarloan);
        chcarloan.setEnabled(false);
        chhomloan = (CheckBox) findViewById(R.id.checkboxHomeloan);
        chhomloan.setEnabled(false);
        chsocietyloan = (CheckBox) findViewById(R.id.checkboxSocietyloan);
        chsocietyloan.setEnabled(false);
        chpersonalloan = (CheckBox) findViewById(R.id.checkboxPersonalloan);
        chpersonalloan.setEnabled(false);
        chotherloan = (CheckBox) findViewById(R.id.checkboxOtherloan);
        chotherloan.setEnabled(false);

        ArrayAdapter<String> spinnerArrayAdaptercompanyType = new ArrayAdapter(this, R.layout.sppinner_layout_listitem, CompanyType);
        spinnerArrayAdaptercompanyType.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        SPcompanytype.setAdapter(spinnerArrayAdaptercompanyType);
        ArrayAdapter<String> spinnerArrayAdapterSalaryType = new ArrayAdapter(this, R.layout.sppinner_layout_listitem, SalaryType);
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
        SPpropertytype.setEnabled(false);
        ArrayAdapter<String> spinnerArrayAdapterProppertyType = new ArrayAdapter<String>(this, R.layout.sppinner_layout_listitem, APPropertytype);
        spinnerArrayAdapterProppertyType.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        SPpropertytype.setAdapter(spinnerArrayAdapterProppertyType);

        edtloanrequirement = (EditText) findViewById(R.id.txtloanrequirement1);
        edtloanrequirement.setEnabled(false);
        edtdownpayment = (EditText) findViewById(R.id.txtdownpayment1);
        edtdownpayment.setEnabled(false);
        edtdescription = (EditText) findViewById(R.id.txtdescription1);
        edtdescription.setEnabled(false);

        edtpropertypin = (EditText) findViewById(R.id.txtpropertyaddresspin1);
        edtpropertypin.setEnabled(false);
        edtpropertylandmark = (EditText) findViewById(R.id.txtpropertylandmark1);
        edtpropertylandmark.setEnabled(false);
        edtpropertyarea = (EditText) findViewById(R.id.txtpropertyarea1);
        edtpropertyarea.setEnabled(false);
        edtprojectname = (EditText) findViewById(R.id.txtpropertyprojectname1);
        edtprojectname.setEnabled(false);

        btnUpdate = (ImageButton) findViewById(R.id.buttonupdate);

        layoutDate = (RelativeLayout) findViewById(R.id.layoutbirthdate);
        layoutContact = (RelativeLayout) findViewById(R.id.layoutcontact);
        layoutAltContact = (RelativeLayout) findViewById(R.id.layoutaltcontact);
        layoutEmail = (RelativeLayout) findViewById(R.id.layoutemail);
        layoutEducation = (RelativeLayout) findViewById(R.id.layouteducation);
        layoutOtherDetails = (RelativeLayout) findViewById(R.id.layoutothervalue);
        layoutCurrentAddress = (RelativeLayout) findViewById(R.id.layouthomeaddress);
        layoutpermenantaddress = (RelativeLayout) findViewById(R.id.layoutpermenantaddress);
        layoutPin = (RelativeLayout) findViewById(R.id.layoutcurrentpin);
        layoutLandmark = (RelativeLayout) findViewById(R.id.layoutcurrentland);
        layoutArea = (RelativeLayout) findViewById(R.id.layoutcurrentArea);
        layoutStreet = (RelativeLayout) findViewById(R.id.layoutcurrentstreet);
        layoutIfSame = (RelativeLayout) findViewById(R.id.layoutaddress1);
        layoutpin1 = (RelativeLayout) findViewById(R.id.layoutpin);
        layoutland = (RelativeLayout) findViewById(R.id.layoutland);
        layoutSameArea = (RelativeLayout) findViewById(R.id.layoutArea);
        layoutSameStreet = (RelativeLayout) findViewById(R.id.layoutstreet);
        layoutResidentialtype = (RelativeLayout) findViewById(R.id.layoutresidencial);
        layoutOfficeAddress = (RelativeLayout) findViewById(R.id.layoutofficeaddress);
        layoutpancard = (RelativeLayout) findViewById(R.id.layoutpancard);
        layoutcoapplicantrelation = (RelativeLayout) findViewById(R.id.layoutcoapplicant);
        layoutotherrelationship = (RelativeLayout) findViewById(R.id.layoutotherrelationship);
        layoutothercompany = (RelativeLayout) findViewById(R.id.layoutothercompany);
        layouttenure = (RelativeLayout) findViewById(R.id.layouttenure);
        layoutexperience = (RelativeLayout) findViewById(R.id.layoutexperience);
        layoutdepartment = (RelativeLayout) findViewById(R.id.layoutdepartment);
        layoutdesignation = (RelativeLayout) findViewById(R.id.layoutdesignation);
        layoutgrosssalary = (RelativeLayout) findViewById(R.id.layoutgrosssalary);
        layoutnetsalary = (RelativeLayout) findViewById(R.id.layoutnetsalary);
        layoutovertime = (RelativeLayout) findViewById(R.id.layoutovertime);
        layoutincentive = (RelativeLayout) findViewById(R.id.layoutincentive);
        layoutbonus = (RelativeLayout) findViewById(R.id.layoutbonus);
        layoutrent = (RelativeLayout) findViewById(R.id.layoutrent);
        layoutagreecultureincome = (RelativeLayout) findViewById(R.id.layoutagreecultureincome);
        layoutannualincome = (RelativeLayout) findViewById(R.id.layoutannualincome);
        layoutotherincome = (RelativeLayout) findViewById(R.id.layoutotherincome);
        layoutothers = (RelativeLayout) findViewById(R.id.layoutothers);
        layoutrentalexpence = (RelativeLayout) findViewById(R.id.layoutrentalexpence);
        layoutcarloan = (RelativeLayout) findViewById(R.id.layoutcarloan);
        layouthomeloan = (RelativeLayout) findViewById(R.id.layouthomeloan);
        layoutsocietyloan = (RelativeLayout) findViewById(R.id.layoutsocietyloan);
        layoutpersonalloan = (RelativeLayout) findViewById(R.id.layoutpersonalloan);
        layoutotheremidetails = (RelativeLayout) findViewById(R.id.layoutotheremidetails);
        layoutpropertyaddresspin = (RelativeLayout) findViewById(R.id.layoutpropertyaddresspin);
        layoutpropertyaddresslandmark = (RelativeLayout) findViewById(R.id.layoutpropertyaddresslandmark);
        layoutpropertyaddressarea = (RelativeLayout) findViewById(R.id.layoutpropertyaddressarea);
        layoutpropertyaddressprojectname = (RelativeLayout) findViewById(R.id.layoutpropertyaddressprojectname);
        layoutpropertytype = (RelativeLayout) findViewById(R.id.layoutpropertytype);
        layoutLoanrequirement = (RelativeLayout) findViewById(R.id.layoutLoanrequirement);
        layoutDownpayment = (RelativeLayout) findViewById(R.id.layoutDownpayment);
        layotDescription = (RelativeLayout) findViewById(R.id.layotDescription);
        layoutsalesperson = (RelativeLayout) findViewById(R.id.layoutsalesperson);
        layoutbankname = (RelativeLayout) findViewById(R.id.layoutbankname);
        layoutbranchname = (RelativeLayout) findViewById(R.id.layoutbranchname);
        layoutifsccode = (RelativeLayout) findViewById(R.id.layoutifsccode);
        layoutappointment = (RelativeLayout) findViewById(R.id.layoutappointment);

        layoutreferenceaddress = (RelativeLayout) findViewById(R.id.layoutreferenceaddress);
        layoutreferencecontactno = (RelativeLayout) findViewById(R.id.layoutreferencecontactno);
        layoutreferencerelationhsip = (RelativeLayout) findViewById(R.id.layoutreferencerelationhsip);
        layoutreference2fullname = (RelativeLayout) findViewById(R.id.layoutreference2fullname);
        layoutreference2address = (RelativeLayout) findViewById(R.id.layoutreference2address);
        layoutreference2contactno = (RelativeLayout) findViewById(R.id.layoutreference2contactno);
        layoutreference2relationhsip = (RelativeLayout) findViewById(R.id.layoutreference2relationhsip);
        layoutCompanytype = (RelativeLayout) findViewById(R.id.layoutCompanytype);
        layoutreferencefullname = (RelativeLayout) findViewById(R.id.layoutreferencefullname);

        layoutbankname = (RelativeLayout) findViewById(R.id.layoutbankname);
        layoutbranchname = (RelativeLayout) findViewById(R.id.layoutbranchname);
        layoutifsccode = (RelativeLayout) findViewById(R.id.layoutifsccode);

        getdata();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent Bintent = new Intent(View_Leed_Details_Activity.this, Coordinator_Update_Activity.class);
                Bintent.putExtra(Constant.LEED_MODEL, leedsModel);
                startActivity(Bintent);
            }
        });



    }

    private void setFromCurrentDate() {
        Calendar mcurrentDate = Calendar.getInstance();
        fromYear = mcurrentDate.get(Calendar.YEAR);
        fromMonth = mcurrentDate.get(Calendar.MONTH);
        fromDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);
    }

    private void HideFields(RelativeLayout layout) {
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) layout.getLayoutParams();
        params1.height = 0;
        layout.setLayoutParams(params1);
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
//                txtleadid.setText(leedid);
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
            String peraddress = leedsModel.getPeraddress();
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
            } else {
                HideFields(layoutDate);
            }
            if (contact != null) {
                etcontatct.setText(contact);
            } else {
                HideFields(layoutContact);
            }
            if (altcontact != null) {
                etalternatecontact.setText(altcontact);
            } else {
                HideFields(layoutAltContact);
            }
            if (email != null) {
                etcEmail.setText(email);
            } else {
                HideFields(layoutEmail);
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
            } else {
                HideFields(layoutEducation);
            }
            if (otherEdu != null && !otherEdu.equalsIgnoreCase("")) {
                etother.setText(otherEdu);
            } else {
                HideFields(layoutOtherDetails);
            }
            if (caddress != null && !caddress.equalsIgnoreCase("")) {
                etaddress.setText(caddress);
            } else {
                HideFields(layoutCurrentAddress);
            }
            if (peraddress != null && !peraddress.equalsIgnoreCase("")) {
                etpermanantaddress.setText(peraddress);
            } else {
                HideFields(layoutpermenantaddress);
            }
            if (currentpin != null && !currentpin.equalsIgnoreCase("")) {
                Currentpin.setText(currentpin);
            } else {
                HideFields(layoutPin);
            }
            if (currentlandmark != null && !currentlandmark.equalsIgnoreCase("")) {

                Currentlandmark.setText(currentlandmark);
            } else {
                HideFields(layoutLandmark);
            }
            if (currentarea != null && !currentarea.equalsIgnoreCase("")) {
                Currentarea.setText(currentarea);
            } else {
                HideFields(layoutArea);
            }
            if (currentstreet != null && !currentstreet.equalsIgnoreCase("")) {
                Currentstreet.setText(currentstreet);
            } else {
                HideFields(layoutStreet);
            }
            if (addressYN != null) {
                if (addressYN.equalsIgnoreCase("Yes")) {
                    Ryes.setChecked(true);
                } else {
                    Rno.setChecked(true);
                }
            } else {
                HideFields(layoutIfSame);
            }

            if (perPIN != null && !perPIN.equalsIgnoreCase("")) {
                pin.setText(perPIN);
            } else {
                HideFields(layoutpin1);
            }
            if (perLand != null && !perLand.equalsIgnoreCase("")) {

                landmark.setText(perLand);
            } else {
                HideFields(layoutland);
            }
            if (perArea != null && !perArea.equalsIgnoreCase("")) {
                area.setText(perArea);
            } else {
                HideFields(layoutSameArea);
            }
            if (perStreet != null && !perStreet.equalsIgnoreCase("")) {
                street.setText(perStreet);
            } else {
                HideFields(layoutSameStreet);
            }
            if (officeaddress != null && !officeaddress.equalsIgnoreCase("")) {
                etoffaddress.setText(officeaddress);
            } else {
                HideFields(layoutOfficeAddress);
            }

            try {
                if (residencial != null) {
                    ArrayAdapter myAdap2 = (ArrayAdapter) Recidential.getAdapter();
                    int spinnerpos = myAdap2.getPosition(residencial);
                    Recidential.setSelection(spinnerpos);

                } else {
                    HideFields(layoutResidentialtype);
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
            } else {
                HideFields(layoutpancard);
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

//                HideFields(layoutDate );

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
                } else {
                    HideFields(layoutcoapplicantrelation);
                }
            } catch (Exception e) {

            }
            if (coapplicantotherrelation != null && !coapplicantotherrelation.equalsIgnoreCase("")) {
                edtotherrelationship.setText(coapplicantotherrelation);
            } else {
                HideFields(layoutotherrelationship);
            }
            if (prreference1name != null && !prreference1name.equalsIgnoreCase("")) {
                edtreferencename.setText(prreference1name);
            } else {
                HideFields(layoutreferencefullname);
            }

            if (prreference1address != null && !prreference1address.equalsIgnoreCase("")) {
                edtreferenceaddress.setText(prreference1address);
            } else {
                HideFields(layoutreferenceaddress);
            }
            if (prreferencecontactno != null && !prreferencecontactno.equalsIgnoreCase("")) {
                edtreferencecontactno.setText(prreferencecontactno);
            } else {
                HideFields(layoutreferencecontactno);
            }
            if (prreferencerelationship != null && !prreferencerelationship.equalsIgnoreCase("")) {
                edtreferencerelationship.setText(prreferencerelationship);
            } else {
                HideFields(layoutreferencerelationhsip);
            }
            if (prreference2name != null && !prreference2name.equalsIgnoreCase("")) {
                edtreferencename2.setText(prreference2name);
            } else {
                HideFields(layoutreference2fullname);
            }
            if (prreference2address != null && !prreference2address.equalsIgnoreCase("")) {
                edtreferenceaddress2.setText(prreference2address);
            } else {
                HideFields(layoutreference2address);
            }
            if (prreference2contactno != null && !prreference2contactno.equalsIgnoreCase("")) {
                edtreferencecontactno2.setText(prreference2contactno);
            } else {
                HideFields(layoutreference2contactno);
            }
            if (prreference2relationship != null && !prreference2relationship.equalsIgnoreCase("")) {
                edtreferencerelationship2.setText(prreference2relationship);
            } else {
                HideFields(layoutreference2relationhsip);
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
            String appointment = leedsModel.getAppointment();
            String salsepersone = leedsModel.getSalesPerson();

            if (bankname != null && !bankname.equalsIgnoreCase("")) {
                edtbankname.setText(bankname);
            } else {
                HideFields(layoutbankname);
            }
            if (branchname != null && !branchname.equalsIgnoreCase("")) {
                edtbranchname.setText(branchname);
            } else {
                HideFields(layoutbranchname);
            }
            if (ifsccode != null && !ifsccode.equalsIgnoreCase("")) {
                edtifsccode.setText(ifsccode);
            } else {
                HideFields(layoutifsccode);
            }
            if (appointment != null && !appointment.equalsIgnoreCase("")) {
                edtappointment.setText(appointment);
            } else {
                HideFields(layoutappointment);
            }
            try {
                if (salsepersone != null) {
                    ArrayAdapter myAdap0 = (ArrayAdapter) SPsalesperson.getAdapter();
                    SPsalesperson.setSelection(myAdap0.getPosition(salsepersone));
                }
            } catch (Exception e) {

            }
            if (sCompanytype != null) {
                ArrayAdapter myAdap = (ArrayAdapter) SPcompanytype.getAdapter();
                SPcompanytype.setSelection(myAdap.getPosition(sCompanytype));
            }

            if (sEmployed == null) {
            } else if (sEmployed.equalsIgnoreCase("Salaried")) {
                Rsalaried.setChecked(true);
            } else {
                if (sEmployed.equalsIgnoreCase("Self Employed")) {
                    Rselfemployed.setChecked(true);
                }
            }
            if (othercompany != null && !othercompany.equalsIgnoreCase("")) {
                edtothercompany.setText(othercompany);
            } else {
                HideFields(layoutothercompany);
            }
            if (sTenure != null && !sTenure.equalsIgnoreCase("")) {
                edttenure.setText(sTenure);
            } else {
                HideFields(layouttenure);
            }
            if (experience != null && !experience.equalsIgnoreCase("")) {
                edtexperience.setText(experience);
            } else {
                HideFields(layoutexperience);
            }
            if (department != null && !department.equalsIgnoreCase("")) {
                edtdepartment.setText(department);
            } else {
                HideFields(layoutdepartment);
            }
            if (designation != null && !designation.equalsIgnoreCase("")) {
                edtdesignation.setText(designation);
            } else {
                HideFields(layoutdesignation);
            }

            if (grosssalary != null && !grosssalary.equalsIgnoreCase("")) {
                edtgrosssalary.setText(grosssalary);
            } else {
                HideFields(layoutgrosssalary);
            }
            if (netsalary != null && !netsalary.equalsIgnoreCase("")) {
                edtnetsalary.setText(netsalary);
            } else {
                HideFields(layoutnetsalary);
            }
            if (overtime != null && !overtime.equalsIgnoreCase("")) {
                edtovertime.setText(overtime);
            } else {
                HideFields(layoutovertime);
            }
            if (incentive != null && !incentive.equalsIgnoreCase("")) {
                edtincentive.setText(incentive);
            } else {
                HideFields(layoutincentive);
            }
            if (bonus != null && !bonus.equalsIgnoreCase("")) {

                edtbonus.setText(bonus);
            } else {
                HideFields(layoutbonus);
            }
            if (sRentalincom != null && !sRentalincom.equalsIgnoreCase("")) {
                edtrentalincome.setText(sRentalincom);
            } else {
                HideFields(layoutrent);
            }
            if (sAnnualincome != null && !sAnnualincome.equalsIgnoreCase("")) {
                edtannualincome.setText(sAnnualincome);
            } else {
                HideFields(layoutannualincome);
            }
            if (sAgreeincome != null && !sAgreeincome.equalsIgnoreCase("")) {
                edtagrreculturincom.setText(sAgreeincome);
            } else {
                HideFields(layoutagreecultureincome);
            }
            if (sotherincome != null && !sotherincome.equalsIgnoreCase("")) {
                edtotherincome.setText(sotherincome);
            } else {
                HideFields(layoutotherincome);
            }
            if (sSalarytype != null) {
                SPsalarytype.setSelection(((ArrayAdapter) SPsalarytype.getAdapter()).getPosition(sSalarytype));
            } else {
//                HideFields(layoutDate );
            }

            if (sRental != null && !sRental.equalsIgnoreCase("")) {
                edtrental.setText(sRental);
            } else {
                HideFields(layoutrentalexpence);
            }
            if (sEMIcar != null && !sEMIcar.equalsIgnoreCase("")) {
                chcarloan.setChecked(true);
                txtCarloan.setText(carloanamt);
            } else {
//                HideFields(layoutcarloan);
            }
            if (sEMIhome != null && !sEMIhome.equalsIgnoreCase("")) {

                chhomloan.setChecked(true);
                txtHomeloan.setText(homeloanamt);
            } else {
//                HideFields(layouthomeloan);
            }
            if (sEMIsociety != null && !sEMIsociety.equalsIgnoreCase("")) {
                chsocietyloan.setChecked(true);
                txtsocietyloan.setText(societyloanamt);
            } else {
//                HideFields(layoutsocietyloan);
            }
            if (sEMIpersonal != null && !sEMIpersonal.equalsIgnoreCase("")) {
                chpersonalloan.setChecked(true);
                txtpersonalloan.setText(personalloanamt);
            } else {
//                HideFields(layoutpersonalloan);
            }
            if (sEMIother != null && !sEMIother.equalsIgnoreCase("")) {
                chotherloan.setChecked(true);
                edtotheremidetails.setText(emiOtherDetails);

            } else {
//                HideFields(layoutotheremidetails);
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
                chpassport.setChecked(true);
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

            if (loanrequirement != null && !loanrequirement.equalsIgnoreCase("")) {
                edtloanrequirement.setText(loanrequirement);

            } else {
                HideFields(layoutLoanrequirement);
            }

            if (downpayment != null && !downpayment.equalsIgnoreCase("")) {
                edtdownpayment.setText(downpayment);

            } else {
                HideFields(layoutDownpayment);
            }
            if (propertypin != null && !propertypin.equalsIgnoreCase("")) {
                edtpropertypin.setText(propertypin);

            } else {
                HideFields(layoutpropertyaddresspin);
            }
            if (propertylandmark != null && !propertylandmark.equalsIgnoreCase("")) {
                edtpropertylandmark.setText(propertylandmark);

            } else {
                HideFields(layoutpropertyaddresslandmark);
            }
            if (propertyarea != null && !propertyarea.equalsIgnoreCase("")) {
                edtpropertyarea.setText(propertyarea);

            } else {
                HideFields(layoutpropertyaddressarea);
            }
            if (projectname != null && !projectname.equalsIgnoreCase("")) {
                edtprojectname.setText(projectname);

            } else {
                HideFields(layoutpropertyaddressprojectname);
            }
            if (description != null && !description.equalsIgnoreCase("")) {
                edtdescription.setText(description);

            } else {
                HideFields(layotDescription);
            }

        } catch (Exception e) {
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }

    private void setLeedStatus(LeedsModel leedsModel) {
        leedsModel.setStatus(Constant.STATUS_SALES_SUBMITED);
        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap1());
    }

    private void updateLeadDetails(LeedsModel leedsModel) {

        leedsModel.setCustomerName(Scusomername);
        leedsModel.setAddress(cAdress);
        leedsModel.setMobileNumber(Scontactno);
        leedsModel.setLoanType(Sloantype);
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
        leedsModel.setAppointment(Sappointment);
        leedsModel.setSalesPerson(Ssalespersone);

        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap());
    }

    private void updateLeed(String leedId, Map leedsMap) {
        progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));
        leedRepository.updateLeed(leedId, leedsMap, new C09234());
    }

    private void getSalesperson() {
        UserRepository.readsalesperson(SALES, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {

                    userlist = (ArrayList<User>) object;
                    for (int i = 0; i < userlist.size(); i++) {
                        SalesPerson.add(userlist.get(i).getUserName());

                    }

                    ArrayAdapter<String> spinnerArrayAdaptersalesperson = new ArrayAdapter(getApplicationContext(), R.layout.sppinner_layout_listitem, SalesPerson);
                    spinnerArrayAdaptersalesperson.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                    SPsalesperson.setAdapter(spinnerArrayAdaptersalesperson);
                }
            }

            @Override
            public void onError(Object object) {

            }
        });
    }

    public void onItemSelected(AdapterView<?> adapterView, View arg1, int position, long id) {
        sploantype = spinloantype.getSelectedItem().toString();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
