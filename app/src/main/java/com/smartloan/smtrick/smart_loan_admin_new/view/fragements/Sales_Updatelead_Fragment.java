package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
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
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.CheckListAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.SALES;

public class Sales_Updatelead_Fragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    Spinner CoapplicantRalationship,Recidential;
    RadioButton REducation,  RYN, RcoapplicantNO, RcoapplicantYES, Rfemale, Rg, Rgender, Rmale, Rno, Rother, Rpg,Rpro, Rug, Ryes;

    AppSharedPreference appSharedPreference;
    EditText area;
    Button btcancel, btupdate, btverify;
    String cAdharno,  cAdress, cAltcontatct, cBank, cBdate, cContatct, cDescreption, cExamount, cIncome, cNmae, cOffaddress,
            cPadress, cPanno;

    CheckBox chAdhar, chDL, chPAN, chPassport, chProofAdhar, chProofCurrentacctStmt, chProofElectricitybill, chProofGovtEmpid,
            chProofGumasta, chProofPassport, chProofRntagmt, chProofVoterid, chProofdl, chVoterID;

    EditText Currentarea, Currentlandmark, Currentpin, Currentstreet, edtotherrelationship, edtreferenceaddress, edtreferenceaddress2,
            edtreferencecontactno, edtreferencecontactno2, edtreferencename, edtreferencename2, edtreferencerelationship,
            edtreferencerelationship2, etaddress, etadharno, etalternatecontact, etbank, etbirthdate, etcEmail, etcname,
            etcontatct, etdescription, etexammount, etgenerated, etincome, etoccupation, etoffaddress, etother, etpanno,
            etpermanantaddress, etpropaddress,
            edtagrreculturincom, edtannualincome, edtbonus, edtdepartment, edtdesignation, edtexperience, edtgrosssalary,
            edtincentive, edtnetsalary, edtothercompany, edtotheremidetails, edtotherincome, edtovertime, edtrental,
            edtrentalincome, edttenure, txtCarloan, txtHomeloan, txtpersonalloan, txtsocietyloan;
    TextView etleednumber;


    EditText pin,landmark;
    LeedRepository leedRepository;
    UserRepository userRepository;
    LeedsModel leedsModel;
    String StartValue;
    ProgressDialogClass progressDialogClass;

    String sploantype, spoccupation;
    EditText street;
    TextView txtgeneratedby, txtldate, txtleadid, txtleadidvalue, txtleedtime;
    EditText txtpannumber;
    Spinner spinemptype, spinincome, spinloantype;

    //INCOME
    Spinner SPcompanytype,SPsalarytype;
    RadioButton Rsalaried,Rselfemployed;

    CheckBox chNREbankstatement, chPOA, chappointmentletter, chbankstatement, chbisunessagreement, chcarloan, chconfermationletter,
            chcontractletter, chcurrentbankstatement, chemployerletter, chexperieceletter, chformno16, chhomloan, chitr,
            chotherloan, choverbankdetails, chpartnersheepdeed, chpasspoet, chpersonalloan, chqualification, chsalarysleep,
            chsavingacctstatement, chsocietyloan, chvisa;


    //PROPERTY
    Spinner SPpropertytype,SPsalesperson;
    RadioButton Rpresanctioned, Rpurchasepropety;
    EditText edtloanrequirement, edtdownpayment, edtdescription, edtpropertypin, edtpropertylandmark, edtpropertyarea,
            edtprojectname, edtbankname, edtbranchname, edtifsccode, edtappointment, edtappointmentreschedulreason;
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
            Sbankname, Sbranchname, Sifsccode, Sappointment, Sappointmentreschedulreason, Ssalespersone,
            saboutpropety, sYN;

    RadioGroup groupAboutproperty, groupAboutpropetyYN, groupRadioGender, groupRadioEducation, groupRadio,
            groupRadiocoapplicant, groupRadioEmployed;
    RadioButton Rcoapplicant, Remployed, Rproperty, Ryn;

    EditText edtChecklist;

    List<String> salesPerson;
    List<User> userlist;

    CheckListAdapter checkdapter;
    Button bankSubmit;
    int fromYear, fromMonth, fromDay;
    long fromDate, toDate;
    private DatePickerDialog mDatePickerDialog;
    int mHour;
    int mMinute;
    String date_time = "";
    String fdate;


    @Override
    public void onClick(View view) {

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sales_updatelead_activity, container, false);

        ((AppCompatActivity)getActivity()).setSupportActionBar((Toolbar) view.findViewById(R.id.toolbar));
//        leedsModel = (LeedsModel) getActivity().getIntent().getSerializableExtra(Constant.LEED_MODEL);
        Bundle args = this.getArguments();
        if (args != null) {
            leedsModel = (LeedsModel) args.getSerializable(Constant.LEED_MODEL);
            StartValue = leedsModel.getAppointment();
            progressDialogClass = new ProgressDialogClass(getActivity());
            leedRepository = new LeedRepositoryImpl();
            userRepository = new UserRepositoryImpl();
            appSharedPreference = new AppSharedPreference(getContext());

            String[] loanType = new String[]{"HOME LOAN", "LOAN AGAINST PROPERTY"};
            String[] empType = new String[]{"Salaried", "Businessman"};
            String[] recidential = new String[]{"Owned", "Rented", "Allotted by Employer", "Family"};
            String[] CoapplicantRelation = new String[]{"Spouse", "Parents", "Children", "Power of Attorney", "Please specify"};
            //   String[] salesperson = new String[]{"soma dornal", "vikas test user", "sagar mule"};

            salesPerson = new ArrayList<>();


            groupAboutproperty = (RadioGroup) view.findViewById(R.id.radioGroupaboutproperty);
            groupAboutpropetyYN = (RadioGroup) view.findViewById(R.id.radioGroupaboutpropertyYesNo);

            groupRadioGender = (RadioGroup) view.findViewById(R.id.radioSex);
            groupRadioEducation = (RadioGroup) view.findViewById(R.id.radioeducation);
            groupRadio = (RadioGroup) view.findViewById(R.id.radioGYN);
            groupRadiocoapplicant = (RadioGroup) view.findViewById(R.id.radiocoapplicantYN);

            groupRadioEmployed = (RadioGroup) view.findViewById(R.id.radioOccupation);

            edtChecklist = (EditText) view.findViewById(R.id.txtsaleschecklistitems1);
//            edtChecklist.seted(false);

            edtbankname = (EditText) view.findViewById(R.id.txtbankname1);
            edtbranchname = (EditText) view.findViewById(R.id.txtbranchname1);
            edtifsccode = (EditText) view.findViewById(R.id.txtifsccode1);
            edtappointment = (EditText) view.findViewById(R.id.txtappointment1);
            edtappointmentreschedulreason = (EditText) view.findViewById(R.id.txtappointmentreschedualreason1);
            SPsalesperson = (Spinner) view.findViewById(R.id.txtsalespersonname1);
//        ArrayAdapter<String> spinnerArrayAdaptersalesperson = new ArrayAdapter(this, R.layout.sppinner_layout_listitem,
//                salesPerson);
//        spinnerArrayAdaptersalesperson.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//        SPsalesperson.setAdapter(spinnerArrayAdaptersalesperson);

            spinloantype = (Spinner) view.findViewById(R.id.sploantype1);
            ArrayAdapter<String> spinnerArrayAdapterloantype = new ArrayAdapter(getContext(), R.layout.sppinner_layout_listitem,
                    loanType);
            spinnerArrayAdapterloantype.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            spinloantype.setAdapter(spinnerArrayAdapterloantype);
            spinloantype.setOnItemSelectedListener(this);

            btupdate = (Button) view.findViewById(R.id.buttonupdate);

            txtleadid = (TextView) view.findViewById(R.id.textheader);

            etcname = (EditText) view.findViewById(R.id.txtcamevalue);
            etaddress = (EditText) view.findViewById(R.id.txtcurrentaddressvalue);
            etpermanantaddress = (EditText) view.findViewById(R.id.txtpermenantaddressvalue);
            Currentpin = (EditText) view.findViewById(R.id.txtcurrentpin1);
            Currentlandmark = (EditText) view.findViewById(R.id.txtcurrentlandmark1);
            Currentarea = (EditText) view.findViewById(R.id.txtcurrentarea1);
            Currentstreet = (EditText) view.findViewById(R.id.txtcurrentstreet1);
            pin = (EditText) view.findViewById(R.id.txtpin1);
            landmark = (EditText) view.findViewById(R.id.txtlandmark1);
            area = (EditText) view.findViewById(R.id.txtarea1);
            street = (EditText) view.findViewById(R.id.txtstreet1);
            etoffaddress = (EditText) view.findViewById(R.id.txtofficeaddressvalue);
            etbirthdate = (EditText) view.findViewById(R.id.txtbirthdatevalue);
            etcontatct = (EditText) view.findViewById(R.id.txtcontatctvalue);
            etalternatecontact = (EditText) view.findViewById(R.id.edtaltcontact);
            etcEmail = (EditText) view.findViewById(R.id.txtemail1);

            Recidential = (Spinner) view.findViewById(R.id.spinnerrecidencialvalue);
            ArrayAdapter<String> spinnerArrayAdapterRecidential = new ArrayAdapter(getContext(), R.layout.sppinner_layout_listitem, recidential);
            spinnerArrayAdapterRecidential.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            Recidential.setAdapter(spinnerArrayAdapterRecidential);

            CoapplicantRalationship = (Spinner) view.findViewById(R.id.txtcoapplicantrelation1);
            ArrayAdapter<String> spinnerArrayAdapterRelationship = new ArrayAdapter(getContext(), R.layout.sppinner_layout_listitem, CoapplicantRelation);
            spinnerArrayAdapterRelationship.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            CoapplicantRalationship.setAdapter(spinnerArrayAdapterRelationship);

            edtotherrelationship = (EditText) view.findViewById(R.id.txtotherrelationship1);
            edtreferencename = (EditText) view.findViewById(R.id.txtreferencefullname1);
            edtreferenceaddress = (EditText) view.findViewById(R.id.txtreferenceaddress1);
            edtreferencecontactno = (EditText) view.findViewById(R.id.txtreferencecontactno1);
            edtreferencerelationship = (EditText) view.findViewById(R.id.txtreferencecrelationship1);
            edtreferencename2 = (EditText) view.findViewById(R.id.txtreference2fullname1);
            edtreferenceaddress2 = (EditText) view.findViewById(R.id.txtreference2address1);
            edtreferencecontactno2 = (EditText) view.findViewById(R.id.txtreference2contactno1);
            edtreferencerelationship2 = (EditText) view.findViewById(R.id.txtreferencec2relationship1);
            txtpannumber = (EditText) view.findViewById(R.id.txtpannumber);
            etother = (EditText) view.findViewById(R.id.txtOthervalue);

            chAdhar = (CheckBox) view.findViewById(R.id.checkboxadhar);
            chPAN = (CheckBox) view.findViewById(R.id.checkboxpan);
            chVoterID = (CheckBox) view.findViewById(R.id.checkboxvoterid);
            chDL = (CheckBox) view.findViewById(R.id.checkboxdrivinglicence);
            chPassport = (CheckBox) view.findViewById(R.id.checkboxpassport);
            chProofAdhar = (CheckBox) view.findViewById(R.id.checkboxproofAdhar);
            chProofVoterid = (CheckBox) view.findViewById(R.id.checkboxproofVoterid);
            chProofdl = (CheckBox) view.findViewById(R.id.checkboxproofDL);
            chProofElectricitybill = (CheckBox) view.findViewById(R.id.checkboxproofElectricitybill);
            chProofRntagmt = (CheckBox) view.findViewById(R.id.checkboxpeoofRentAgmt);
            chProofPassport = (CheckBox) view.findViewById(R.id.checkboxproofPassport);
            chProofGovtEmpid = (CheckBox) view.findViewById(R.id.checkboxproofGevtEmpID);
            chProofGumasta = (CheckBox) view.findViewById(R.id.checkboxproofGumasta);
            chProofCurrentacctStmt = (CheckBox) view.findViewById(R.id.checkboxproofCurrentAcctStmt);

            RcoapplicantYES = (RadioButton) view.findViewById(R.id.radioapplicantYes);
            RcoapplicantNO = (RadioButton) view.findViewById(R.id.radioapplicantNo);
            Ryes = (RadioButton) view.findViewById(R.id.radioYes);
            Rno = (RadioButton) view.findViewById(R.id.radioNo);
            Rug = (RadioButton) view.findViewById(R.id.radioUG);
            Rg = (RadioButton) view.findViewById(R.id.radioGraguate);
            Rpg = (RadioButton) view.findViewById(R.id.radioPG);
            Rpro = (RadioButton) view.findViewById(R.id.radioprofessional);
            Rother = (RadioButton) view.findViewById(R.id.radioother);
            Rmale = (RadioButton) view.findViewById(R.id.radioMale);
            Rfemale = (RadioButton) view.findViewById(R.id.radioFemale);

            //leed detaila
            txtldate = (TextView) view.findViewById(R.id.txtdate1);
            txtleadidvalue = (TextView) view.findViewById(R.id.txtleadidvalue);
            etleednumber = (TextView) view.findViewById(R.id.txtleadidvalue);
            txtleedtime = (TextView) view.findViewById(R.id.txtleedtime1);
            txtgeneratedby = (TextView) view.findViewById(R.id.txtagentid1);


            //////////////////////////////////////////INCOME///////////////////////////////////////////////////////
            String[] CompanyType = new String[]{"Private ltd", "Public ltd", "Limited Liability Partnership", "Partnership", "Sole Partnership", "Liason office/Repesentative office", "Project Office", "Branch Office", "joint venture company", "Subsidiary company", "Unilimited Company", "Other"};
            String[] SalaryType = new String[]{"AC Credit/Cheque", "Cash", "Comission"};

            Rsalaried = (RadioButton) view.findViewById(R.id.radioSalaried);
            Rselfemployed = (RadioButton) view.findViewById(R.id.radioselfEmployed);

            SPcompanytype = (Spinner) view.findViewById(R.id.spinnercompanytype);
            SPcompanytype.setOnItemSelectedListener(this);
            SPsalarytype = (Spinner) view.findViewById(R.id.spsalarytype);

            edttenure = (EditText) view.findViewById(R.id.txttenure1);
            edtexperience = (EditText) view.findViewById(R.id.txtexperience1);
            edtdepartment = (EditText) view.findViewById(R.id.txtdepartment1);
            edtdesignation = (EditText) view.findViewById(R.id.txtdesignation1);
            edtgrosssalary = (EditText) view.findViewById(R.id.txtmontlygrossincome1);
            edtnetsalary = (EditText) view.findViewById(R.id.txtnetsalary1);
            edtovertime = (EditText) view.findViewById(R.id.txtovertime1);
            edtincentive = (EditText) view.findViewById(R.id.txtiincentive1);
            edtbonus = (EditText) view.findViewById(R.id.txtbonus1);
            edtrentalincome = (EditText) view.findViewById(R.id.txtrent1);
            edtannualincome = (EditText) view.findViewById(R.id.txtannualincome1);
            edtrental = (EditText) view.findViewById(R.id.txtrentalexpence1);
            edtothercompany = (EditText) view.findViewById(R.id.txtothercompany1);
            edtagrreculturincom = (EditText) view.findViewById(R.id.txtagreecultureincome1);
            edtotherincome = (EditText) view.findViewById(R.id.txtotherincome1);
            edtotheremidetails = (EditText) view.findViewById(R.id.txtotheremi1);
            txtCarloan = (EditText) view.findViewById(R.id.txtcarloanamount);
            txtHomeloan = (EditText) view.findViewById(R.id.txthomeloanamount);
            txtsocietyloan = (EditText) view.findViewById(R.id.txtsocietyloanamount);
            txtpersonalloan = (EditText) view.findViewById(R.id.txtpersonalloanamount);
            chsalarysleep = (CheckBox) view.findViewById(R.id.checkboxsalarysleep);
            chbankstatement = (CheckBox) view.findViewById(R.id.checkboxbankstatement);
            chformno16 = (CheckBox) view.findViewById(R.id.checkboxform16);
            chappointmentletter = (CheckBox) view.findViewById(R.id.checkboxappointmentletter);
            chconfermationletter = (CheckBox) view.findViewById(R.id.checkboxconfermationletter);
            chexperieceletter = (CheckBox) view.findViewById(R.id.checkboxexpletter);
            chvisa = (CheckBox) view.findViewById(R.id.checkboxvisa);
            chpasspoet = (CheckBox) view.findViewById(R.id.checkboxpassport);
            chemployerletter = (CheckBox) view.findViewById(R.id.checkboxEmployerletter);
            chcontractletter = (CheckBox) view.findViewById(R.id.checkboxcontractletter);
            chPOA = (CheckBox) view.findViewById(R.id.checkboxPOA);
            chNREbankstatement = (CheckBox) view.findViewById(R.id.checkboxNREbank);
            choverbankdetails = (CheckBox) view.findViewById(R.id.checkboxOverseasbank);
            chitr = (CheckBox) view.findViewById(R.id.checkboxITR);
            chcurrentbankstatement = (CheckBox) view.findViewById(R.id.checkboxcurrentaccountstatement);
            chsavingacctstatement = (CheckBox) view.findViewById(R.id.checkboxsavingacctstatement);
            chpartnersheepdeed = (CheckBox) view.findViewById(R.id.checkboxpartnerdeed);
            chbisunessagreement = (CheckBox) view.findViewById(R.id.checkboxbusinessagreement);
            chqualification = (CheckBox) view.findViewById(R.id.checkboxqualification);
            chcarloan = (CheckBox) view.findViewById(R.id.checkboxCarloan);
            chhomloan = (CheckBox) view.findViewById(R.id.checkboxHomeloan);
            chsocietyloan = (CheckBox) view.findViewById(R.id.checkboxSocietyloan);
            chpersonalloan = (CheckBox) view.findViewById(R.id.checkboxPersonalloan);
            chotherloan = (CheckBox) view.findViewById(R.id.checkboxOtherloan);

            ArrayAdapter<String> spinnerArrayAdaptercompanyType = new ArrayAdapter(getContext(), R.layout.sppinner_layout_listitem, CompanyType);
            spinnerArrayAdaptercompanyType.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            SPcompanytype.setAdapter(spinnerArrayAdaptercompanyType);
            ArrayAdapter<String> spinnerArrayAdapterSalaryType = new ArrayAdapter(getContext(), R.layout.sppinner_layout_listitem,
                    SalaryType);
            spinnerArrayAdapterSalaryType.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            SPsalarytype.setAdapter(spinnerArrayAdapterSalaryType);

////////////////////////////////////////////////////////////PROPERTY///////////////////////////////////////////////////////////
            String[] APPropertytype = new String[]{"Perchase of flat", "Purchase of vila", "Purchase of plot", "Balance transfer",
                    "Balance transfer +Top-Up", "Self Construction", "Renovation/Improvement", "Top-Up existing home loan", "loan for resale property",
                    "Ready posession flat", "Under construction flat"};

            Rpresanctioned = (RadioButton) view.findViewById(R.id.radioPresanction);
            Rpurchasepropety = (RadioButton) view.findViewById(R.id.radiopurchasepropety);
            Ryes = (RadioButton) view.findViewById(R.id.radioYES);
            Rno = (RadioButton) view.findViewById(R.id.radioNO);

            SPpropertytype = (Spinner) view.findViewById(R.id.txtpropertytype1);
            ArrayAdapter<String> spinnerArrayAdapterProppertyType = new ArrayAdapter<String>(getContext(), R.layout.sppinner_layout_listitem, APPropertytype);
            spinnerArrayAdapterProppertyType.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
            SPpropertytype.setAdapter(spinnerArrayAdapterProppertyType);

            edtloanrequirement = (EditText) view.findViewById(R.id.txtloanrequirement1);
            edtdownpayment = (EditText) view.findViewById(R.id.txtdownpayment1);
            edtdescription = (EditText) view.findViewById(R.id.txtdescription1);

            edtpropertypin = (EditText) view.findViewById(R.id.txtpropertyaddresspin1);
            edtpropertylandmark = (EditText) view.findViewById(R.id.txtpropertylandmark1);
            edtpropertyarea = (EditText) view.findViewById(R.id.txtpropertyarea1);
            edtprojectname = (EditText) view.findViewById(R.id.txtpropertyprojectname1);

            bankSubmit = (Button) view.findViewById(R.id.buttonBankSubmit);

            getSalesperson();

//        getdata();
            setDateTimeField();
            setDateTimeField1();
            edtappointment.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    mDatePickerDialog.show();

                    return false;
                }
            });

            etbirthdate.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    mDatePickerDialog.show();

                    return false;
                }
            });

            btupdate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(final View view) {
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
                            Rgender = (RadioButton) view.findViewById(checkedId);

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
                            REducation = (RadioButton) view.findViewById(checkedId);
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
                            RYN = (RadioButton) view.findViewById(checkedId);

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
                            Rcoapplicant = (RadioButton) view.findViewById(checkedId);
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
                            Remployed = (RadioButton) view.findViewById(checkedId);
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
                            Rproperty = (RadioButton) view.findViewById(checkedId);
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
                            Ryn = (RadioButton) view.findViewById(checkedId);
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
                    Sappointmentreschedulreason = edtappointmentreschedulreason.getText().toString();
                    Ssalespersone = SPsalesperson.getSelectedItem().toString();

                    updateLeadDetails(leedsModel);
                    Toast.makeText(getContext(), "Lead Update Successfully", Toast.LENGTH_SHORT).show();
                }
            });
            bankSubmit.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Sbankname = edtbankname.getText().toString();
                    if (TextUtils.isEmpty(Sbankname)) {
                        edtbankname.setError("Required");
                        Toast.makeText(getContext(), "Enter Bank Name!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    setLeedStatus(leedsModel);
                }
            });
        }

        edtChecklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog1 = new Dialog(getContext());
                dialog1.getWindow().setBackgroundDrawableResource(R.drawable.dialogboxanimation);
                dialog1.setContentView(R.layout.customdialogbox);

                RecyclerView recyclechecklist = (RecyclerView) dialog1.findViewById(R.id.dialog_recycle);

                checkdapter = new CheckListAdapter(getContext(), leedsModel.getChecklist());
                //adding adapter to recyclerview
                recyclechecklist.setAdapter(checkdapter);
                // CatalogAdapter catalogAdapter = new CatalogAdapter(catalogList);
                recyclechecklist.setHasFixedSize(true);
                recyclechecklist.setLayoutManager(new LinearLayoutManager(getContext()));

                dialog1.show();
            }
        });

        return view;
    }

    private void setDateTimeField() {

        Calendar newCalendar = Calendar.getInstance();
        mDatePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
                final Date startDate = newDate.getTime();
                fdate = sd.format(startDate);


                timePicker();
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

    }
    private void setDateTimeField1() {

        Calendar newCalendar = Calendar.getInstance();
        mDatePickerDialog = new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {

            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
                final Date startDate = newDate.getTime();
                fdate = sd.format(startDate);
                etbirthdate.setText(fdate);

            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

    }

    private void timePicker() {
        // Get Current Time
        final Calendar c = Calendar.getInstance();
        mHour = c.get(Calendar.HOUR_OF_DAY);
        mMinute = c.get(Calendar.MINUTE);

        // Launch Time Picker Dialog
        TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                new TimePickerDialog.OnTimeSetListener() {

                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        mHour = hourOfDay;
                        mMinute = minute;

                        edtappointment.setText(fdate + " " + hourOfDay + ":" + minute);
                    }
                }, mHour, mMinute, false);
        timePickerDialog.show();
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

                    ArrayAdapter<String> spinnerArrayAdaptersalesperson = new ArrayAdapter(getContext(),
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
                Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
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
            String appointment = leedsModel.getAppointment();
            String appointmentreschedul = leedsModel.getAppointreschedualreason();
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
            if (appointment != null) {
                edtappointment.setText(appointment);
            }
            if (appointmentreschedul != null) {
                edtappointmentreschedulreason.setText(appointmentreschedul);
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

            ArrayList<String> checkelist = new ArrayList<>();
            checkelist = leedsModel.getChecklist();
            if (checkelist != null){
                edtChecklist.setText("!Click Here");
            }else {
                edtChecklist.setText("Empty");

            }

        } catch (Exception e) {
        }

    }

    private void setLeedStatus(LeedsModel leedsModel) {
        leedsModel.setStatus(Constant.STATUS_BANK_SUBMITED);
        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap1());
    }

    private void updateLeadDetails(LeedsModel leedsModel) {

        leedsModel.setCustomerName(Scusomername);
        leedsModel.setAddress(cAdress);
        leedsModel.setMobileNumber(Scontactno);
        leedsModel.setAlternetMobileNumber(Saltcontact);
        leedsModel.setDateOfBirth(Sbirthdate);
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
        leedsModel.setAppointreschedualreason(Sappointmentreschedulreason);
        leedsModel.setSalesPerson(Ssalespersone);

        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap());
    }


    private void updateLeed(String leedId, Map leedsMap) {
        progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));
        leedRepository.updateLeed(leedId, leedsMap, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                Toast.makeText(getContext(), "Lead Submited Successfully", Toast.LENGTH_SHORT).show();
                progressDialogClass.dismissDialog();
            }

            @Override
            public void onError(Object object) {

                progressDialogClass.dismissDialog();
                Context context = getContext();
                Utility.showLongMessage(context, context.getString(R.string.server_error));
            }
        });
    }

//    public void onItemSelected(AdapterView<?> adapterView, View arg1, int position, long id) {
//        sploantype = spinloantype.getSelectedItem().toString();
//    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }
}
