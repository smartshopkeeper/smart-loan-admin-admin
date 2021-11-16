package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.content.ContextCompat;
import androidx.appcompat.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
import java.util.List;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.SALES;

public class View_Leed_Details_Fragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {


    Spinner CoapplicantRalationship;
    RadioButton REducation;
    RadioButton RYN;
    RadioButton RcoapplicantNO;
    RadioButton RcoapplicantYES;
    Spinner Recidential;
    RadioButton Rfemale,   Rg,  Rmale, Rno, Rother, Rpg, Rpro, Rug, Ryes;

    AppSharedPreference appSharedPreference;
    EditText area;

    CheckBox chAdhar, chDL, chPAN, chPassport, chProofAdhar, chProofCurrentacctStmt, chProofElectricitybill, chProofGovtEmpid,
            chProofGumasta, chProofPassport, chProofRntagmt, chProofVoterid, chProofdl, chVoterID;

    EditText Currentarea, Currentlandmark, Currentpin, Currentstreet, edtotherrelationship, edtreferenceaddress, edtreferenceaddress2, edtreferencecontactno,
            edtreferencecontactno2, edtreferencename, edtreferencename2, edtreferencerelationship, edtreferencerelationship2,
            etaddress,  etalternatecontact,  etbirthdate, etcEmail, etcname, etcontatct,
               etoffaddress, etother,  etpermanantaddress;


    String lGenby;
    EditText landmark, pin, street, txtpannumber;
    LeedRepository leedRepository;
    com.smartloan.smtrick.smart_loan_admin_new.repository.UserRepository UserRepository;
    LeedsModel leedsModel;
    ProgressDialogClass progressDialogClass;
    Spinner   spinloantype;
    String sploantype;
    TextView etleednumber,txtgeneratedby, txtldate, txtleadid, txtleadidvalue, txtleedtime;

    //////////////////////////////INCOME///////////////////////////////////

    Spinner SPcompanytype, SPsalarytype,SPsalesperson;
    RadioButton Rsalaried,Rselfemployed, Rpresanctioned, Rpurchasepropety;

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

    RadioGroup groupAboutproperty, groupAboutpropetyYN, groupRadioGender, groupRadioEducation, groupRadio, groupRadiocoapplicant;

    RadioGroup groupRadioEmployed;

    List<String> SalesPerson;
    List<User> userlist;

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

    @Override
    public void onClick(View view) {

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.view_lead_details, container, false);

        ((AppCompatActivity)getActivity()).setSupportActionBar((Toolbar) view.findViewById(R.id.toolbar));

        Bundle args = this.getArguments();
        if (args != null) {
            leedsModel = (LeedsModel) args.getSerializable(Constant.LEED_MODEL);

        }

        progressDialogClass = new ProgressDialogClass(getActivity());
        leedRepository = new LeedRepositoryImpl();
        UserRepository = new UserRepositoryImpl();
        appSharedPreference = new AppSharedPreference(getContext());
        String[] loanType = new String[]{"HOME LOAN", "LOAN AGAINST PROPERTY"};
        String[] recidential = new String[]{"Owned", "Rented", "Allotted by Employer", "Family"};
        String[] CoapplicantRelation = new String[]{"Spouse", "Parents", "Children", "Power of Attorney", "Please specify"};

        SalesPerson = new ArrayList<>();
        getSalesperson();

        groupAboutproperty = (RadioGroup) view.findViewById(R.id.radioGroupaboutproperty);
        groupAboutpropetyYN = (RadioGroup) view.findViewById(R.id.radioGroupaboutpropertyYesNo);

        groupRadioGender = (RadioGroup) view.findViewById(R.id.radioSex);
        groupRadioEducation = (RadioGroup) view.findViewById(R.id.radioeducation);
        groupRadio = (RadioGroup) view.findViewById(R.id.radioGYN);
        groupRadiocoapplicant = (RadioGroup) view.findViewById(R.id.radiocoapplicantYN);

        groupRadioEmployed = (RadioGroup) view.findViewById(R.id.radioOccupation);

        edtbankname = (EditText) view.findViewById(R.id.txtbankname1);
        edtbankname.setEnabled(false);
        edtbranchname = (EditText) view.findViewById(R.id.txtbranchname1);
        edtbranchname.setEnabled(false);
        edtifsccode = (EditText) view.findViewById(R.id.txtifsccode1);
        edtifsccode.setEnabled(false);
        edtappointment = (EditText) view.findViewById(R.id.txtappointment1);
        edtappointment.setEnabled(false);

        SPsalesperson = (Spinner) view.findViewById(R.id.txtsalespersonname1);
        SPsalesperson.setEnabled(false);
        spinloantype = (Spinner) view.findViewById(R.id.sploantype1);
        spinloantype.setEnabled(false);

        txtleadid = (TextView) view.findViewById(R.id.textheader);

        etcname = (EditText) view.findViewById(R.id.txtcamevalue);
        etaddress = (EditText) view.findViewById(R.id.txtcurrentaddressvalue);
        etaddress.setEnabled(false);
        etpermanantaddress = (EditText) view.findViewById(R.id.txtpermenantaddressvalue);
        etpermanantaddress.setEnabled(false);
        Currentpin = (EditText) view.findViewById(R.id.txtcurrentpin1);
        Currentpin.setEnabled(false);
        Currentlandmark = (EditText) view.findViewById(R.id.txtcurrentlandmark1);
        Currentlandmark.setEnabled(false);
        Currentarea = (EditText) view.findViewById(R.id.txtcurrentarea1);
        Currentarea.setEnabled(false);
        Currentstreet = (EditText) view.findViewById(R.id.txtcurrentstreet1);
        Currentstreet.setEnabled(false);
        pin = (EditText) view.findViewById(R.id.txtpin1);
        pin.setEnabled(false);
        landmark = (EditText) view.findViewById(R.id.txtlandmark1);
        landmark.setEnabled(false);
        area = (EditText) view.findViewById(R.id.txtarea1);
        area.setEnabled(false);
        street = (EditText) view.findViewById(R.id.txtstreet1);
        street.setEnabled(false);
        etoffaddress = (EditText) view.findViewById(R.id.txtofficeaddressvalue);
        etoffaddress.setEnabled(false);
        etbirthdate = (EditText) view.findViewById(R.id.txtbirthdatevalue);
        etbirthdate.setEnabled(false);
        etcontatct = (EditText) view.findViewById(R.id.txtcontatctvalue);
        etcontatct.setEnabled(false);
        etalternatecontact = (EditText) view.findViewById(R.id.edtaltcontact);
        etalternatecontact.setEnabled(false);
        etcEmail = (EditText) view.findViewById(R.id.txtemail1);
        etcEmail.setEnabled(false);

        Recidential = (Spinner) view.findViewById(R.id.spinnerrecidencialvalue);
        Recidential.setEnabled(false);
        ArrayAdapter<String> spinnerArrayAdapterRecidential = new ArrayAdapter(getContext(), R.layout.sppinner_layout_listitem, recidential);
        spinnerArrayAdapterRecidential.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        Recidential.setAdapter(spinnerArrayAdapterRecidential);

        CoapplicantRalationship = (Spinner) view.findViewById(R.id.txtcoapplicantrelation1);
        CoapplicantRalationship.setEnabled(false);
        ArrayAdapter<String> spinnerArrayAdapterRelationship = new ArrayAdapter(getContext(), R.layout.sppinner_layout_listitem, CoapplicantRelation);
        spinnerArrayAdapterRelationship.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        CoapplicantRalationship.setAdapter(spinnerArrayAdapterRelationship);

        edtotherrelationship = (EditText) view.findViewById(R.id.txtotherrelationship1);
        edtreferencename = (EditText) view.findViewById(R.id.txtreferencefullname1);
        edtreferenceaddress = (EditText) view.findViewById(R.id.txtreferenceaddress1);
        edtreferencecontactno = (EditText) view.findViewById(R.id.txtreferencecontactno1);
        edtreferencecontactno.setEnabled(false);
        edtreferencerelationship = (EditText) view.findViewById(R.id.txtreferencecrelationship1);
        edtreferencename2 = (EditText) view.findViewById(R.id.txtreference2fullname1);
        edtreferenceaddress2 = (EditText) view.findViewById(R.id.txtreference2address1);
        edtreferencecontactno2 = (EditText) view.findViewById(R.id.txtreference2contactno1);
        edtreferencecontactno2.setEnabled(false);
        edtreferencerelationship2 = (EditText) view.findViewById(R.id.txtreferencec2relationship1);
        txtpannumber = (EditText) view.findViewById(R.id.txtpannumber);
        etother = (EditText) view.findViewById(R.id.txtOthervalue);

        chAdhar = (CheckBox) view.findViewById(R.id.checkboxadhar);
        chAdhar.setEnabled(false);
        chPAN = (CheckBox) view.findViewById(R.id.checkboxpan);
        chPAN.setEnabled(false);
        chVoterID = (CheckBox) view.findViewById(R.id.checkboxvoterid);
        chVoterID.setEnabled(false);
        chDL = (CheckBox) view.findViewById(R.id.checkboxdrivinglicence);
        chDL.setEnabled(false);
        chPassport = (CheckBox) view.findViewById(R.id.checkboxpassport);
        chPassport.setEnabled(false);
        chProofAdhar = (CheckBox) view.findViewById(R.id.checkboxproofAdhar);
        chProofAdhar.setEnabled(false);
        chProofVoterid = (CheckBox) view.findViewById(R.id.checkboxproofVoterid);
        chProofVoterid.setEnabled(false);
        chProofdl = (CheckBox) view.findViewById(R.id.checkboxproofDL);
        chProofdl.setEnabled(false);
        chProofElectricitybill = (CheckBox) view.findViewById(R.id.checkboxproofElectricitybill);
        chProofElectricitybill.setEnabled(false);
        chProofRntagmt = (CheckBox) view.findViewById(R.id.checkboxpeoofRentAgmt);
        chProofRntagmt.setEnabled(false);
        chProofPassport = (CheckBox) view.findViewById(R.id.checkboxproofPassport);
        chProofPassport.setEnabled(false);
        chProofGovtEmpid = (CheckBox) view.findViewById(R.id.checkboxproofGevtEmpID);
        chProofGovtEmpid.setEnabled(false);
        chProofGumasta = (CheckBox) view.findViewById(R.id.checkboxproofGumasta);
        chProofGumasta.setEnabled(false);
        chProofCurrentacctStmt = (CheckBox) view.findViewById(R.id.checkboxproofCurrentAcctStmt);
        chProofCurrentacctStmt.setEnabled(false);

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

        ///////////////////////////////////////leed details////////////////////////////////////////////////////

        txtldate = (TextView) view.findViewById(R.id.txtdate1);
        txtleadid = (TextView) view.findViewById(R.id.textheader);
        txtleadidvalue = (TextView) view.findViewById(R.id.txtleadidvalue);
        etleednumber = (TextView) view.findViewById(R.id.txtleadidvalue);
        txtleedtime = (TextView) view.findViewById(R.id.txtleedtime1);
        txtgeneratedby = (TextView) view.findViewById(R.id.txtagentid1);

        ArrayAdapter<String> spinnerArrayAdapterloantype = new ArrayAdapter(getContext(), R.layout.sppinner_layout_listitem, loanType);
        spinnerArrayAdapterloantype.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinloantype.setAdapter(spinnerArrayAdapterloantype);

        //////////////////////////////////////////INCOME/////////////////////////////////////////////////////

        String[] CompanyType = new String[]{"Private ltd", "Public ltd", "Limited Liability Partnership", "Partnership", "Sole Partnership", "Liason office/Repesentative office", "Project Office", "Branch Office", "joint venture company", "Subsidiary company", "Unilimited Company", "Other"};
        String[] SalaryType = new String[]{"AC Credit/Cheque", "Cash", "Comission"};

        Rsalaried = (RadioButton) view.findViewById(R.id.radioSalaried);
        Rselfemployed = (RadioButton) view.findViewById(R.id.radioselfEmployed);
        SPcompanytype = (Spinner) view.findViewById(R.id.spinnercompanytype);
        SPcompanytype.setEnabled(false);
        SPcompanytype.setOnItemSelectedListener(this);
        SPsalarytype = (Spinner) view.findViewById(R.id.spsalarytype);
        SPsalarytype.setEnabled(false);

        edttenure = (EditText) view.findViewById(R.id.txttenure1);
        edtexperience = (EditText) view.findViewById(R.id.txtexperience1);
        edtdepartment = (EditText) view.findViewById(R.id.txtdepartment1);
        edtdesignation = (EditText) view.findViewById(R.id.txtdesignation1);
        edtgrosssalary = (EditText) view.findViewById(R.id.txtmontlygrossincome1);
        edtgrosssalary.setEnabled(false);
        edtnetsalary = (EditText) view.findViewById(R.id.txtnetsalary1);
        edtnetsalary.setEnabled(false);
        edtovertime = (EditText) view.findViewById(R.id.txtovertime1);
        edtovertime.setEnabled(false);
        edtincentive = (EditText) view.findViewById(R.id.txtiincentive1);
        edtincentive.setEnabled(false);
        edtbonus = (EditText) view.findViewById(R.id.txtbonus1);
        edtbonus.setEnabled(false);
        edtrentalincome = (EditText) view.findViewById(R.id.txtrent1);
        edtrentalincome.setEnabled(false);
        edtannualincome = (EditText) view.findViewById(R.id.txtannualincome1);
        edtannualincome.setEnabled(false);
        edtrental = (EditText) view.findViewById(R.id.txtrentalexpence1);
        edtrental.setEnabled(false);
        edtothercompany = (EditText) view.findViewById(R.id.txtothercompany1);
        edtagrreculturincom = (EditText) view.findViewById(R.id.txtagreecultureincome1);
        edtagrreculturincom.setEnabled(false);
        edtotherincome = (EditText) view.findViewById(R.id.txtotherincome1);
        edtotherincome.setEnabled(false);
        edtotheremidetails = (EditText) view.findViewById(R.id.txtotheremi1);
        txtCarloan = (EditText) view.findViewById(R.id.txtcarloanamount);
        txtHomeloan = (EditText) view.findViewById(R.id.txthomeloanamount);
        txtsocietyloan = (EditText) view.findViewById(R.id.txtsocietyloanamount);
        txtpersonalloan = (EditText) view.findViewById(R.id.txtpersonalloanamount);

        chsalarysleep = (CheckBox) view.findViewById(R.id.checkboxsalarysleep);
        chsalarysleep.setEnabled(false);
        chbankstatement = (CheckBox) view.findViewById(R.id.checkboxbankstatement);
        chbankstatement.setEnabled(false);
        chformno16 = (CheckBox) view.findViewById(R.id.checkboxform16);
        chformno16.setEnabled(false);
        chappointmentletter = (CheckBox) view.findViewById(R.id.checkboxappointmentletter);
        chappointmentletter.setEnabled(false);
        chconfermationletter = (CheckBox) view.findViewById(R.id.checkboxconfermationletter);
        chconfermationletter.setEnabled(false);
        chexperieceletter = (CheckBox) view.findViewById(R.id.checkboxexpletter);
        chexperieceletter.setEnabled(false);
        chvisa = (CheckBox) view.findViewById(R.id.checkboxvisa);
        chvisa.setEnabled(false);
        chpassport = (CheckBox) view.findViewById(R.id.checkboxpassport);
        chpassport.setEnabled(false);
        chemployerletter = (CheckBox) view.findViewById(R.id.checkboxEmployerletter);
        chemployerletter.setEnabled(false);
        chcontractletter = (CheckBox) view.findViewById(R.id.checkboxcontractletter);
        chcontractletter.setEnabled(false);
        chPOA = (CheckBox) view.findViewById(R.id.checkboxPOA);
        chPOA.setEnabled(false);
        chNREbankstatement = (CheckBox) view.findViewById(R.id.checkboxNREbank);
        chNREbankstatement.setEnabled(false);
        choverbankdetails = (CheckBox) view.findViewById(R.id.checkboxOverseasbank);
        choverbankdetails.setEnabled(false);
        chitr = (CheckBox) view.findViewById(R.id.checkboxITR);
        chitr.setEnabled(false);
        chcurrentbankstatement = (CheckBox) view.findViewById(R.id.checkboxcurrentaccountstatement);
        chcurrentbankstatement.setEnabled(false);
        chsavingacctstatement = (CheckBox) view.findViewById(R.id.checkboxsavingacctstatement);
        chsavingacctstatement.setEnabled(false);
        chpartnersheepdeed = (CheckBox) view.findViewById(R.id.checkboxpartnerdeed);
        chpartnersheepdeed.setEnabled(false);
        chbisunessagreement = (CheckBox) view.findViewById(R.id.checkboxbusinessagreement);
        chbisunessagreement.setEnabled(false);
        chqualification = (CheckBox) view.findViewById(R.id.checkboxqualification);
        chqualification.setEnabled(false);
        chcarloan = (CheckBox) view.findViewById(R.id.checkboxCarloan);
        chcarloan.setEnabled(false);
        chhomloan = (CheckBox) view.findViewById(R.id.checkboxHomeloan);
        chhomloan.setEnabled(false);
        chsocietyloan = (CheckBox) view.findViewById(R.id.checkboxSocietyloan);
        chsocietyloan.setEnabled(false);
        chpersonalloan = (CheckBox) view.findViewById(R.id.checkboxPersonalloan);
        chpersonalloan.setEnabled(false);
        chotherloan = (CheckBox) view.findViewById(R.id.checkboxOtherloan);
        chotherloan.setEnabled(false);

        ArrayAdapter<String> spinnerArrayAdaptercompanyType = new ArrayAdapter(getContext(), R.layout.sppinner_layout_listitem, CompanyType);
        spinnerArrayAdaptercompanyType.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        SPcompanytype.setAdapter(spinnerArrayAdaptercompanyType);
        ArrayAdapter<String> spinnerArrayAdapterSalaryType = new ArrayAdapter(getContext(), R.layout.sppinner_layout_listitem, SalaryType);
        spinnerArrayAdapterSalaryType.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        SPsalarytype.setAdapter(spinnerArrayAdapterSalaryType);

///////////////////////////////////////////PROPERTY/////////////////////////////////////////////////////////////////

        String[] APPropertytype = new String[]{"Perchase of flat", "Purchase of vila", "Purchase of plot", "Balance transfer",
                "Balance transfer +Top-Up", "Self Construction", "Renovation/Improvement", "Top-Up existing home loan", "loan for resale property",
                "Ready posession flat", "Under construction flat"};

        Rpresanctioned = (RadioButton) view.findViewById(R.id.radioPresanction);
        Rpurchasepropety = (RadioButton) view.findViewById(R.id.radiopurchasepropety);
        Ryes = (RadioButton) view.findViewById(R.id.radioYES);
        Rno = (RadioButton) view.findViewById(R.id.radioNO);

        SPpropertytype = (Spinner) view.findViewById(R.id.txtpropertytype1);
        SPpropertytype.setEnabled(false);
        ArrayAdapter<String> spinnerArrayAdapterProppertyType = new ArrayAdapter<String>(getContext(), R.layout.sppinner_layout_listitem, APPropertytype);
        spinnerArrayAdapterProppertyType.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        SPpropertytype.setAdapter(spinnerArrayAdapterProppertyType);

        edtloanrequirement = (EditText) view.findViewById(R.id.txtloanrequirement1);
        edtloanrequirement.setEnabled(false);
        edtdownpayment = (EditText) view.findViewById(R.id.txtdownpayment1);
        edtdownpayment.setEnabled(false);
        edtdescription = (EditText) view.findViewById(R.id.txtdescription1);
        edtdescription.setEnabled(false);

        edtpropertypin = (EditText) view.findViewById(R.id.txtpropertyaddresspin1);
        edtpropertypin.setEnabled(false);
        edtpropertylandmark = (EditText) view.findViewById(R.id.txtpropertylandmark1);
        edtpropertylandmark.setEnabled(false);
        edtpropertyarea = (EditText) view.findViewById(R.id.txtpropertyarea1);
        edtpropertyarea.setEnabled(false);
        edtprojectname = (EditText) view.findViewById(R.id.txtpropertyprojectname1);
        edtprojectname.setEnabled(false);

        btnUpdate = (ImageButton) view.findViewById(R.id.buttonupdate);

        layoutDate = (RelativeLayout) view.findViewById(R.id.layoutbirthdate);
        layoutContact = (RelativeLayout) view.findViewById(R.id.layoutcontact);
        layoutAltContact = (RelativeLayout) view.findViewById(R.id.layoutaltcontact);
        layoutEmail = (RelativeLayout) view.findViewById(R.id.layoutemail);
        layoutEducation = (RelativeLayout) view.findViewById(R.id.layouteducation);
        layoutOtherDetails = (RelativeLayout) view.findViewById(R.id.layoutothervalue);
        layoutCurrentAddress = (RelativeLayout) view.findViewById(R.id.layouthomeaddress);
        layoutpermenantaddress = (RelativeLayout) view.findViewById(R.id.layoutpermenantaddress);
        layoutPin = (RelativeLayout) view.findViewById(R.id.layoutcurrentpin);
        layoutLandmark = (RelativeLayout) view.findViewById(R.id.layoutcurrentland);
        layoutArea = (RelativeLayout) view.findViewById(R.id.layoutcurrentArea);
        layoutStreet = (RelativeLayout) view.findViewById(R.id.layoutcurrentstreet);
        layoutIfSame = (RelativeLayout) view.findViewById(R.id.layoutaddress1);
        layoutpin1 = (RelativeLayout) view.findViewById(R.id.layoutpin);
        layoutland = (RelativeLayout) view.findViewById(R.id.layoutland);
        layoutSameArea = (RelativeLayout) view.findViewById(R.id.layoutArea);
        layoutSameStreet = (RelativeLayout) view.findViewById(R.id.layoutstreet);
        layoutResidentialtype = (RelativeLayout) view.findViewById(R.id.layoutresidencial);
        layoutOfficeAddress = (RelativeLayout) view.findViewById(R.id.layoutofficeaddress);
        layoutpancard = (RelativeLayout) view.findViewById(R.id.layoutpancard);
        layoutcoapplicantrelation = (RelativeLayout) view.findViewById(R.id.layoutcoapplicant);
        layoutotherrelationship = (RelativeLayout) view.findViewById(R.id.layoutotherrelationship);
        layoutothercompany = (RelativeLayout) view.findViewById(R.id.layoutothercompany);
        layouttenure = (RelativeLayout) view.findViewById(R.id.layouttenure);
        layoutexperience = (RelativeLayout) view.findViewById(R.id.layoutexperience);
        layoutdepartment = (RelativeLayout) view.findViewById(R.id.layoutdepartment);
        layoutdesignation = (RelativeLayout) view.findViewById(R.id.layoutdesignation);
        layoutgrosssalary = (RelativeLayout) view.findViewById(R.id.layoutgrosssalary);
        layoutnetsalary = (RelativeLayout) view.findViewById(R.id.layoutnetsalary);
        layoutovertime = (RelativeLayout) view.findViewById(R.id.layoutovertime);
        layoutincentive = (RelativeLayout) view.findViewById(R.id.layoutincentive);
        layoutbonus = (RelativeLayout) view.findViewById(R.id.layoutbonus);
        layoutrent = (RelativeLayout) view.findViewById(R.id.layoutrent);
        layoutagreecultureincome = (RelativeLayout) view.findViewById(R.id.layoutagreecultureincome);
        layoutannualincome = (RelativeLayout) view.findViewById(R.id.layoutannualincome);
        layoutotherincome = (RelativeLayout) view.findViewById(R.id.layoutotherincome);
        layoutothers = (RelativeLayout) view.findViewById(R.id.layoutothers);
        layoutrentalexpence = (RelativeLayout) view.findViewById(R.id.layoutrentalexpence);
        layoutcarloan = (RelativeLayout) view.findViewById(R.id.layoutcarloan);
        layouthomeloan = (RelativeLayout) view.findViewById(R.id.layouthomeloan);
        layoutsocietyloan = (RelativeLayout) view.findViewById(R.id.layoutsocietyloan);
        layoutpersonalloan = (RelativeLayout) view.findViewById(R.id.layoutpersonalloan);
        layoutotheremidetails = (RelativeLayout) view.findViewById(R.id.layoutotheremidetails);
        layoutpropertyaddresspin = (RelativeLayout) view.findViewById(R.id.layoutpropertyaddresspin);
        layoutpropertyaddresslandmark = (RelativeLayout) view.findViewById(R.id.layoutpropertyaddresslandmark);
        layoutpropertyaddressarea = (RelativeLayout) view.findViewById(R.id.layoutpropertyaddressarea);
        layoutpropertyaddressprojectname = (RelativeLayout) view.findViewById(R.id.layoutpropertyaddressprojectname);
        layoutpropertytype = (RelativeLayout) view.findViewById(R.id.layoutpropertytype);
        layoutLoanrequirement = (RelativeLayout) view.findViewById(R.id.layoutLoanrequirement);
        layoutDownpayment = (RelativeLayout) view.findViewById(R.id.layoutDownpayment);
        layotDescription = (RelativeLayout) view.findViewById(R.id.layotDescription);
        layoutsalesperson = (RelativeLayout) view.findViewById(R.id.layoutsalesperson);
        layoutbankname = (RelativeLayout) view.findViewById(R.id.layoutbankname);
        layoutbranchname = (RelativeLayout) view.findViewById(R.id.layoutbranchname);
        layoutifsccode = (RelativeLayout) view.findViewById(R.id.layoutifsccode);
        layoutappointment = (RelativeLayout) view.findViewById(R.id.layoutappointment);

        layoutreferenceaddress = (RelativeLayout) view.findViewById(R.id.layoutreferenceaddress);
        layoutreferencecontactno = (RelativeLayout) view.findViewById(R.id.layoutreferencecontactno);
        layoutreferencerelationhsip = (RelativeLayout) view.findViewById(R.id.layoutreferencerelationhsip);
        layoutreference2fullname = (RelativeLayout) view.findViewById(R.id.layoutreference2fullname);
        layoutreference2address = (RelativeLayout) view.findViewById(R.id.layoutreference2address);
        layoutreference2contactno = (RelativeLayout) view.findViewById(R.id.layoutreference2contactno);
        layoutreference2relationhsip = (RelativeLayout) view.findViewById(R.id.layoutreference2relationhsip);
        layoutCompanytype = (RelativeLayout) view.findViewById(R.id.layoutCompanytype);
        layoutreferencefullname = (RelativeLayout) view.findViewById(R.id.layoutreferencefullname);

        layoutbankname = (RelativeLayout) view.findViewById(R.id.layoutbankname);
        layoutbranchname = (RelativeLayout) view.findViewById(R.id.layoutbranchname);
        layoutifsccode = (RelativeLayout) view.findViewById(R.id.layoutifsccode);

        getdata();

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent Bintent = new Intent(getContext(), Coordinator_Update_Activity.class);
//                Bintent.putExtra(Constant.LEED_MODEL, leedsModel);
//                startActivity(Bintent);
                Bundle bundle = new Bundle();
//            bundle.putString("key","abc");
                bundle.putSerializable(Constant.LEED_MODEL, leedsModel);// Put anything what you want

                View_Lead_Details_Fragment1 fragment2 = new View_Lead_Details_Fragment1();
                fragment2.setArguments(bundle);

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.detailContainer,  fragment2);
                ft.commit();
            }
        });


        return view;
    }


    private void HideFields(RelativeLayout layout) {
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) layout.getLayoutParams();
        params1.height = 0;
        layout.setLayoutParams(params1);
    }

    private void getdata() {
        try {

            ////////////////////////////////////LEED DETAILS////////////////////////////////////////////////

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

            ///////////////////////////////////////APPLICANT DETAILS/////////////////////////////////////////////////////

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
                Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
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


            /////////////////////////////////////////INCOME DETAILS//////////////////////////////////////////////////////////

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


            //////////////////////////////////////////////PROPERTY DETAILS///////////////////////////////////////////////////////

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
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

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

                    ArrayAdapter<String> spinnerArrayAdaptersalesperson = new ArrayAdapter(getContext(), R.layout.sppinner_layout_listitem, SalesPerson);
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
