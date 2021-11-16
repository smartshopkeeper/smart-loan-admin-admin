package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import androidx.appcompat.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.models.Bank;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.models.User;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.UserRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.UserRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.BanksAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.SalesPersonAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.SALES;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.STATUS_DISBUSED;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.STATUS_REJECTED;

public class Co_View_Disbussed_Lead_Details_Fragment extends Fragment {

    TextView CoapplicantRalationship;

    TextView Recidential;

    AppSharedPreference appSharedPreference;
    TextView area;

    TextView chAdhar, chDL, chPAN, chPassport, chProofAdhar, chProofCurrentacctStmt, chProofElectricitybill, chProofGovtEmpid,
            chProofGumasta, chProofPassport, chProofRntagmt, chProofVoterid, chProofdl, chVoterID;

    TextView Currentarea, Currentlandmark, Currentpin, Currentstreet, AddressYN, edtotherrelationship, edtreferenceaddress, edtreferenceaddress2, edtreferencecontactno,
            edtreferencecontactno2, edtreferencename, edtreferencename2, edtreferencerelationship, edtreferencerelationship2,
            etaddress, etalternatecontact, etbirthdate, etcEmail, etcname, etcontatct,
            etoffaddress, etother, etpermanantaddress;

    TextView txtGender, txtEducation, txtCoApplicant, txtOccupationtype, txtAboutProperty;

    TextView landmark, pin, street, txtpannumber;
    LeedRepository leedRepository;
    UserRepository UserRepository;
    LeedsModel leedsModel;
    ProgressDialogClass progressDialogClass;
    TextView spinloantype;
    String sploantype;
    TextView etleednumber, txtgeneratedby, txtldate, txtleadid, txtleadidvalue, txtleedtime;

    //////////////////////////////INCOME///////////////////////////////////

    TextView SPcompanytype, SPsalarytype, SPsalesperson;

    TextView edtagrreculturincom, edtannualincome, edtbonus, edtdepartment, edtdesignation, edtexperience, edtgrosssalary,
            edtincentive, edtnetsalary, edtothercompany, edtotheremidetails, edtotherincome, edtovertime, edtrental, edtrentalincome,
            edttenure, txtCarloan, txtHomeloan, txtpersonalloan, txtsocietyloan;

    TextView chNREbankstatement, chPOA, chappointmentletter, chbankstatement, chbisunessagreement, chcarloan, chconfermationletter,
            chcontractletter, chcurrentbankstatement, chemployerletter, chexperieceletter, chformno16, chhomloan, chitr, chotherloan,
            choverbankdetails, chpartnersheepdeed, chpassport, chpersonalloan, chqualification, chsalarysleep, chsavingacctstatement,
            chsocietyloan, chvisa;

    //PROPERTY
    TextView SPpropertytype;
    TextView edtloanrequirement, edtdownpayment, edtdescription, edtpropertypin, edtpropertylandmark, edtpropertyarea,
            edtprojectname, edtbankname, edtbranchname, edtifsccode, edtappointment, edtappointmentreschedule;

    List<String> SalesPerson;
    List<User> userlist;

//    ImageView btnUpdate;

    RelativeLayout layoutDate, layoutContact, layoutAltContact, layoutEmail, layoutEducation, layoutOtherDetails,
            layoutCurrentAddress, layoutPin, layoutLandmark, layoutArea, layoutStreet, layoutIfSame,
            layoutpin1, layoutland, layoutSameArea, layoutSameStreet, layoutResidentialtype, layoutOfficeAddress,
            layoutpancard, layoutcoapplicantrelation, layoutRelation, layoutothercompany, layouttenure, layoutexperience, layoutdepartment,
            layoutdesignation, layoutgrosssalary, layoutnetsalary, layoutovertime, layoutincentive, layoutbonus, layoutrent,
            layoutagreecultureincome, layoutannualincome, layoutotherincome, layoutothers, layoutrentalexpence, layoutcarloan,
            layouthomeloan, layoutsocietyloan, layoutpersonalloan, layoutotheremidetails, layoutpropertyaddresspin,
            layoutpropertyaddresslandmark, layoutpropertyaddressarea, layoutpropertyaddressprojectname, layoutpropertytype,
            layoutLoanrequirement, layoutDownpayment, layotDescription, layoutsalesperson, layoutreferencefullname, layoutreferenceaddress, layoutreferencecontactno,
            layoutreferencerelationhsip, layoutreference2fullname, layoutreference2address, layoutreference2contactno, layoutreference2relationhsip,
            layoutCompanytype, layoutpermenantaddress, layoutotherrelationship,
            layoutbankname, layoutbranchname, layoutifsccode, layoutlognid, layoutappointment, lauoutappointmentreschedule, Layoutsalesperson;

    RelativeLayout layoutMECarloan, layoutMEhomeloan, layoutMEsocietyloan, layoutMEpersonalloan, layoutMEotherlon,
            layoutkycadaar, layoutkycpan, layoutkycvoterid, layoutkycdl, layoutkycpassport;
    RelativeLayout layoutkycproofadhar, layoutkycproofvoterid, layoutkycproofdl,
            layoutkycproofelectricitybill, layoutkycproofrentaggrement, layoutkycproofpassport, layoutkycproofgovid, layoutkycproofgumasta, layoutkycproofcurrentacctstmt,
            layoutsalarysalarysleep, layoutsalarybankstmt, layoutsalaryform16, layoutsalaryappointment, layoutsalaryconfermation, layoutsalaryreleiving,
            layoutnrivisa, layoutnripassport, layoutnriemployerletter, layoutnricontractletter, layoutnriPOA, layoutnriNREbankacctstmt, layoutnrioverseasebank,
            layoutselfITR, layoutselfcurrentacctstmt, layoutselfsavingacct, layoutselfpartnersheepdeed, layoutselfbusinessagreement, layoutselfqualificationcertificate;

    TextView txtLeedId, txtCustomerName, txtLoanRequirement, txtAgent, txtLoanType;
    EditText edtloginId, edtapprovedamount, edtdisbussamount, edtpendingamount, edtrejectionreason;
    TextView txtLoginId;

    LinearLayout layoutDisbussAmount;

    ArrayList<Bank> leedsArraylist;
    ArrayList<User> userArraylist;
    private List<String> listmaritalstatus;
    BanksAdapter adapter;

    Button UpdateBankAndSales,  btnDisbussAmount, btnDISBUSS;

    private User getUserModel(int position) {
        return userArraylist.get(userArraylist.size() - 1 - position);
    }

    private Bank getModel(int position) {
        return leedsArraylist.get(leedsArraylist.size() - 1 - position);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.co_view_disbussed_lead_details, container, false);

        ((AppCompatActivity) getActivity()).setSupportActionBar((Toolbar) view.findViewById(R.id.toolbar));

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
        leedsArraylist = new ArrayList<>();
        userArraylist = new ArrayList<>();
        listmaritalstatus = new ArrayList<>();
        getSalesperson();

        txtLeedId = (TextView) view.findViewById(R.id.txt_id_value);
        txtCustomerName = (TextView) view.findViewById(R.id.txtcnamevalue);
        txtLoanRequirement = (TextView) view.findViewById(R.id.txt_loan_requirement_value);
        txtAgent = (TextView) view.findViewById(R.id.txt_bp_value);
        txtLoanType = (TextView) view.findViewById(R.id.txt_loan_type_value);
        edtloginId = (EditText) view.findViewById(R.id.edtloginid);
        edtapprovedamount = (EditText) view.findViewById(R.id.edtapprovedamount);
        edtdisbussamount = (EditText) view.findViewById(R.id.edtdisbussamount);
        edtpendingamount = (EditText) view.findViewById(R.id.edtpendingamount);
        edtrejectionreason = (EditText) view.findViewById(R.id.edtreejctreason);

        UpdateBankAndSales = (Button) view.findViewById(R.id.buttonupdate2);

        txtLeedId.setText(leedsModel.getLeedNumber());
        txtCustomerName.setText(leedsModel.getCustomerName());
        if (leedsModel.getExpectedLoanAmount() != null) {
            txtLoanRequirement.setText(leedsModel.getExpectedLoanAmount());
        } else {
            txtLoanRequirement.setText("Null");
        }
        txtAgent.setText(leedsModel.getAgentName());
        txtLoanType.setText(leedsModel.getLoanType());


        edtbankname = (TextView) view.findViewById(R.id.txtbankname1);
        edtbranchname = (TextView) view.findViewById(R.id.txtbranchname1);
        edtifsccode = (TextView) view.findViewById(R.id.txtifsccode1);
        txtLoginId = (TextView) view.findViewById(R.id.txtloginid1);
        edtappointment = (TextView) view.findViewById(R.id.txtappointment1);
        edtappointmentreschedule = (TextView) view.findViewById(R.id.txtappointmentreschedule1);

        SPsalesperson = (TextView) view.findViewById(R.id.txtsalespersonname1);
        spinloantype = (TextView) view.findViewById(R.id.sploantypevalue);

        txtleadid = (TextView) view.findViewById(R.id.textheader);

        etcname = (TextView) view.findViewById(R.id.txtcamevalue);
        etaddress = (TextView) view.findViewById(R.id.txtcurrentaddressvalue);
        etpermanantaddress = (TextView) view.findViewById(R.id.txtpermenantaddressvalue);
        Currentpin = (TextView) view.findViewById(R.id.txtcurrentpin1);
        Currentlandmark = (TextView) view.findViewById(R.id.txtcurrentlandmark1);
        Currentarea = (TextView) view.findViewById(R.id.txtcurrentarea1);
        Currentstreet = (TextView) view.findViewById(R.id.txtcurrentstreet1);
        AddressYN = (TextView) view.findViewById(R.id.adressYN);
        pin = (TextView) view.findViewById(R.id.txtpin1);
        landmark = (TextView) view.findViewById(R.id.txtlandmark1);
        area = (TextView) view.findViewById(R.id.txtarea1);
        street = (TextView) view.findViewById(R.id.txtstreet1);
        etoffaddress = (TextView) view.findViewById(R.id.txtofficeaddressvalue);
        etbirthdate = (TextView) view.findViewById(R.id.txtbirthdatevalue);
        etcontatct = (TextView) view.findViewById(R.id.txtcontatctvalue);
        etalternatecontact = (TextView) view.findViewById(R.id.edtaltcontact);
        etcEmail = (TextView) view.findViewById(R.id.txtemail1);

        Recidential = (TextView) view.findViewById(R.id.spinnerrecidencialvalue);

        CoapplicantRalationship = (TextView) view.findViewById(R.id.txtcoapplicantrelation1);

        edtotherrelationship = (TextView) view.findViewById(R.id.txtotherrelationship1);
        edtreferencename = (TextView) view.findViewById(R.id.txtreferencefullname1);
        edtreferenceaddress = (TextView) view.findViewById(R.id.txtreferenceaddress1);
        edtreferencecontactno = (TextView) view.findViewById(R.id.txtreferencecontactno1);
        edtreferencerelationship = (TextView) view.findViewById(R.id.txtreferencecrelationship1);
        edtreferencename2 = (TextView) view.findViewById(R.id.txtreference2fullname1);
        edtreferenceaddress2 = (TextView) view.findViewById(R.id.txtreference2address1);
        edtreferencecontactno2 = (TextView) view.findViewById(R.id.txtreference2contactno1);
        edtreferencerelationship2 = (TextView) view.findViewById(R.id.txtreferencec2relationship1);
        txtpannumber = (TextView) view.findViewById(R.id.txtpannumber);
        etother = (TextView) view.findViewById(R.id.txtOthervalue);

        chAdhar = (TextView) view.findViewById(R.id.checkboxadhar);
        chPAN = (TextView) view.findViewById(R.id.checkboxpan);
        chVoterID = (TextView) view.findViewById(R.id.checkboxvoterid);
        chDL = (TextView) view.findViewById(R.id.checkboxdrivinglicence);
        chPassport = (TextView) view.findViewById(R.id.checkboxpassport);
        chProofAdhar = (TextView) view.findViewById(R.id.checkboxproofAdhar);
        chProofVoterid = (TextView) view.findViewById(R.id.checkboxproofVoterid);
        chProofdl = (TextView) view.findViewById(R.id.checkboxproofDL);
        chProofElectricitybill = (TextView) view.findViewById(R.id.checkboxproofElectricitybill);
        chProofRntagmt = (TextView) view.findViewById(R.id.checkboxpeoofRentAgmt);
        chProofPassport = (TextView) view.findViewById(R.id.checkboxproofPassport);
        chProofGovtEmpid = (TextView) view.findViewById(R.id.checkboxproofGevtEmpID);
        chProofGumasta = (TextView) view.findViewById(R.id.checkboxproofGumasta);
        chProofCurrentacctStmt = (TextView) view.findViewById(R.id.checkboxproofCurrentAcctStmt);

        ///////////////////////////////////////leed details////////////////////////////////////////////////////

        txtldate = (TextView) view.findViewById(R.id.txtdate1);
        txtleadid = (TextView) view.findViewById(R.id.textheader);
        txtleadidvalue = (TextView) view.findViewById(R.id.txtleadidvalue);
        etleednumber = (TextView) view.findViewById(R.id.txtleadidvalue);
        txtleedtime = (TextView) view.findViewById(R.id.txtleedtime1);
        txtgeneratedby = (TextView) view.findViewById(R.id.txtagentid1);

        //////////////////////////////////////////INCOME/////////////////////////////////////////////////////

        String[] CompanyType = new String[]{"Private ltd", "Public ltd", "Limited Liability Partnership", "Partnership", "Sole Partnership", "Liason office/Repesentative office", "Project Office", "Branch Office", "joint venture company", "Subsidiary company", "Unilimited Company", "Other"};
        String[] SalaryType = new String[]{"AC Credit/Cheque", "Cash", "Comission"};

        SPcompanytype = (TextView) view.findViewById(R.id.spinnercompanytype);
//        SPcompanytype.setOnItemSelectedListener(this);
        SPsalarytype = (TextView) view.findViewById(R.id.spsalarytype);

        edttenure = (TextView) view.findViewById(R.id.txttenure1);
        edtexperience = (TextView) view.findViewById(R.id.txtexperience1);
        edtdepartment = (TextView) view.findViewById(R.id.txtdepartment1);
        edtdesignation = (TextView) view.findViewById(R.id.txtdesignation1);
        edtgrosssalary = (TextView) view.findViewById(R.id.txtmontlygrossincome1);
        edtnetsalary = (TextView) view.findViewById(R.id.txtnetsalary1);
        edtovertime = (TextView) view.findViewById(R.id.txtovertime1);
        edtincentive = (TextView) view.findViewById(R.id.txtiincentive1);
        edtbonus = (TextView) view.findViewById(R.id.txtbonus1);
        edtrentalincome = (TextView) view.findViewById(R.id.txtrent1);
        edtannualincome = (TextView) view.findViewById(R.id.txtannualincome1);
        edtrental = (TextView) view.findViewById(R.id.txtrentalexpence1);
        edtothercompany = (TextView) view.findViewById(R.id.txtothercompany1);
        edtagrreculturincom = (TextView) view.findViewById(R.id.txtagreecultureincome1);
        edtotherincome = (TextView) view.findViewById(R.id.txtotherincome1);
        edtotheremidetails = (TextView) view.findViewById(R.id.txtotheremi1);
        txtCarloan = (TextView) view.findViewById(R.id.txtcarloanamount);
        txtHomeloan = (TextView) view.findViewById(R.id.txthomeloanamount);
        txtsocietyloan = (TextView) view.findViewById(R.id.txtsocietyloanamount);
        txtpersonalloan = (TextView) view.findViewById(R.id.txtpersonalloanamount);

        chsalarysleep = (TextView) view.findViewById(R.id.checkboxsalarysleep);
        chbankstatement = (TextView) view.findViewById(R.id.checkboxbankstatement);
        chformno16 = (TextView) view.findViewById(R.id.checkboxform16);
        chappointmentletter = (TextView) view.findViewById(R.id.checkboxappointmentletter);
        chconfermationletter = (TextView) view.findViewById(R.id.checkboxconfermationletter);
        chexperieceletter = (TextView) view.findViewById(R.id.checkboxexpletter);
        chvisa = (TextView) view.findViewById(R.id.checkboxvisa);
        chpassport = (TextView) view.findViewById(R.id.checkboxpassport);
        chemployerletter = (TextView) view.findViewById(R.id.checkboxEmployerletter);
        chcontractletter = (TextView) view.findViewById(R.id.checkboxcontractletter);
        chPOA = (TextView) view.findViewById(R.id.checkboxPOA);
        chNREbankstatement = (TextView) view.findViewById(R.id.checkboxNREbank);
        choverbankdetails = (TextView) view.findViewById(R.id.checkboxOverseasbank);
        chitr = (TextView) view.findViewById(R.id.checkboxITR);
        chcurrentbankstatement = (TextView) view.findViewById(R.id.checkboxcurrentaccountstatement);
        chsavingacctstatement = (TextView) view.findViewById(R.id.checkboxsavingacctstatement);
        chpartnersheepdeed = (TextView) view.findViewById(R.id.checkboxpartnerdeed);
        chbisunessagreement = (TextView) view.findViewById(R.id.checkboxbusinessagreement);
        chqualification = (TextView) view.findViewById(R.id.checkboxqualification);
        chcarloan = (TextView) view.findViewById(R.id.checkboxCarloan);
        chhomloan = (TextView) view.findViewById(R.id.checkboxHomeloan);
        chsocietyloan = (TextView) view.findViewById(R.id.checkboxSocietyloan);
        chpersonalloan = (TextView) view.findViewById(R.id.checkboxPersonalloan);
        chotherloan = (TextView) view.findViewById(R.id.txtotheremi1);

///////////////////////////////////////////PROPERTY/////////////////////////////////////////////////////////////////

        String[] APPropertytype = new String[]{"Perchase of flat", "Purchase of vila", "Purchase of plot", "Balance transfer",
                "Balance transfer +Top-Up", "Self Construction", "Renovation/Improvement", "Top-Up existing home loan", "loan for resale property",
                "Ready posession flat", "Under construction flat"};

        SPpropertytype = (TextView) view.findViewById(R.id.txtpropertytype1);
        SPpropertytype.setEnabled(false);


        edtloanrequirement = (TextView) view.findViewById(R.id.txtloanrequirement1);
        edtloanrequirement.setEnabled(false);
        edtdownpayment = (TextView) view.findViewById(R.id.txtdownpayment1);
        edtdownpayment.setEnabled(false);
        edtdescription = (TextView) view.findViewById(R.id.txtdescription1);
        edtdescription.setEnabled(false);

        edtpropertypin = (TextView) view.findViewById(R.id.txtpropertyaddresspin1);
        edtpropertypin.setEnabled(false);
        edtpropertylandmark = (TextView) view.findViewById(R.id.txtpropertylandmark1);
        edtpropertylandmark.setEnabled(false);
        edtpropertyarea = (TextView) view.findViewById(R.id.txtpropertyarea1);
        edtpropertyarea.setEnabled(false);
        edtprojectname = (TextView) view.findViewById(R.id.txtpropertyprojectname1);
        edtprojectname.setEnabled(false);

//        btnUpdate = (ImageView) view.findViewById(R.id.buttonupdateimage);

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
        layoutRelation = (RelativeLayout) view.findViewById(R.id.layoutcoapplicantrelation);
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
        layoutlognid = (RelativeLayout) view.findViewById(R.id.layoutloginid);
        layoutappointment = (RelativeLayout) view.findViewById(R.id.layoutappointment);
        lauoutappointmentreschedule = (RelativeLayout) view.findViewById(R.id.layoutappointmentreschedule);
        Layoutsalesperson = (RelativeLayout) view.findViewById(R.id.layoutsalesperson);

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

        layoutMECarloan = (RelativeLayout) view.findViewById(R.id.layoutcarloan);
        layoutMEhomeloan = (RelativeLayout) view.findViewById(R.id.layouthomeloan);
        layoutMEsocietyloan = (RelativeLayout) view.findViewById(R.id.layoutsocietyloan);
        layoutMEpersonalloan = (RelativeLayout) view.findViewById(R.id.layoutpersonalloan);
        layoutMEotherlon = (RelativeLayout) view.findViewById(R.id.layoutotheremidetails);

        layoutkycadaar = (RelativeLayout) view.findViewById(R.id.layoutcheckboxadhar);
        layoutkycpan = (RelativeLayout) view.findViewById(R.id.layoutcheckboxpan);
        layoutkycvoterid = (RelativeLayout) view.findViewById(R.id.layoutcheckboxvoterid);
        layoutkycdl = (RelativeLayout) view.findViewById(R.id.layoutcheckboxdrivinglicence);
        layoutkycpassport = (RelativeLayout) view.findViewById(R.id.layoutcheckpassport);

        layoutkycproofadhar = (RelativeLayout) view.findViewById(R.id.layoutcheckboxproofAdhar);
        layoutkycproofvoterid = (RelativeLayout) view.findViewById(R.id.layoutcheckboxroofVoterid);
        layoutkycproofdl = (RelativeLayout) view.findViewById(R.id.layoutcheckboxproofDL);
        layoutkycproofelectricitybill = (RelativeLayout) view.findViewById(R.id.layoutcheckboxproofElectricitybill);
        layoutkycproofrentaggrement = (RelativeLayout) view.findViewById(R.id.layoutcheckboxpeoofRentAgmt);
        layoutkycproofpassport = (RelativeLayout) view.findViewById(R.id.layoutcheckboxproofPassport);
        layoutkycproofgovid = (RelativeLayout) view.findViewById(R.id.layoutcheckboxproofGevtEmpID);
        layoutkycproofgumasta = (RelativeLayout) view.findViewById(R.id.layoutcheckboxproofGumasta);
        layoutkycproofcurrentacctstmt = (RelativeLayout) view.findViewById(R.id.layoutcheckboxproofCurrentAcctStmt);

        layoutsalarysalarysleep = (RelativeLayout) view.findViewById(R.id.layoutcheckboxsalarysleep);
        layoutsalarybankstmt = (RelativeLayout) view.findViewById(R.id.layoutcheckboxbankstatement);
        layoutsalaryform16 = (RelativeLayout) view.findViewById(R.id.layoutcheckboxform16);
        layoutsalaryappointment = (RelativeLayout) view.findViewById(R.id.layoutcheckboxappointmentletter);
        layoutsalaryconfermation = (RelativeLayout) view.findViewById(R.id.layoutcheckboxconfermationletter);
        layoutsalaryreleiving = (RelativeLayout) view.findViewById(R.id.layoutcheckboxexpletter);

        layoutnrivisa = (RelativeLayout) view.findViewById(R.id.layoutcheckboxvisa);
        layoutnripassport = (RelativeLayout) view.findViewById(R.id.layoutcheckboxnripassport);
        layoutnriemployerletter = (RelativeLayout) view.findViewById(R.id.layoutcheckboxEmployerletter);
        layoutnricontractletter = (RelativeLayout) view.findViewById(R.id.layoutcheckboxcontractletter);
        layoutnriPOA = (RelativeLayout) view.findViewById(R.id.layoutcheckboxPOA);
        layoutnriNREbankacctstmt = (RelativeLayout) view.findViewById(R.id.layoutcheckboxNREbank);
        layoutnrioverseasebank = (RelativeLayout) view.findViewById(R.id.layoutcheckboxOverseasbank);

        layoutselfITR = (RelativeLayout) view.findViewById(R.id.layoutcheckboxITR);
        layoutselfcurrentacctstmt = (RelativeLayout) view.findViewById(R.id.layoutcheckboxcurrentaccountstatement);
        layoutselfsavingacct = (RelativeLayout) view.findViewById(R.id.layoutcheckboxsavingacctstatement);
        layoutselfpartnersheepdeed = (RelativeLayout) view.findViewById(R.id.layoutcheckboxpartnerdeed);
        layoutselfbusinessagreement = (RelativeLayout) view.findViewById(R.id.layoutcheckboxbusinessagreement);
        layoutselfqualificationcertificate = (RelativeLayout) view.findViewById(R.id.layoutcheckboxqualification);

        layoutDisbussAmount = (LinearLayout) view.findViewById(R.id.layoutapprovedamount);
        layoutDisbussAmount.setVisibility(LinearLayout.GONE);


        txtGender = (TextView) view.findViewById(R.id.txtgender);
        txtEducation = (TextView) view.findViewById(R.id.educationvalue);
        txtCoApplicant = (TextView) view.findViewById(R.id.coapplicantYN);
        txtOccupationtype = (TextView) view.findViewById(R.id.txtoccupationvalue);
        txtAboutProperty = (TextView) view.findViewById(R.id.txtaboutpropertyvalue);

        btnDisbussAmount = (Button) view.findViewById(R.id.buttondisbuss);
        btnDISBUSS = (Button) view.findViewById(R.id.buttonsubmit);

        getdata();

        UpdateBankAndSales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateLeadDetails(leedsModel, "updateBank");
            }
        });

        btnDisbussAmount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                layoutDisbussAmount.setVisibility(LinearLayout.VISIBLE);
            }
        });

        btnDISBUSS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String approved = edtapprovedamount.getText().toString();
                if(TextUtils.isEmpty(approved)) {
                    edtapprovedamount.setError("Required");
                    return;
                }

                String disbuss = edtdisbussamount.getText().toString();
                if(TextUtils.isEmpty(disbuss)) {
                    edtdisbussamount.setError("Required");
                    return;
                }

                String pending = edtpendingamount.getText().toString();
                if(TextUtils.isEmpty(pending)) {
                    edtpendingamount.setError("Required");
                    return;
                }
                updateLeadDetails(leedsModel, "disbuss");
            }
        });

        return view;
    }

    private void updateLeadDetails(LeedsModel leedsModel, String data) {
        if (data.equalsIgnoreCase("updateBank")) {
            leedsModel.setLoginid(edtloginId.getText().toString());
        } else if (data.equalsIgnoreCase("disbuss")) {
            String approved = edtapprovedamount.getText().toString();
            String disbuss = edtdisbussamount.getText().toString();
            String pending = edtpendingamount.getText().toString();

            Date c = Calendar.getInstance().getTime();
            System.out.println("Current time => " + c);
            SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
            String formattedDate = df.format(c);

            leedsModel.setStatus(STATUS_DISBUSED);
            leedsModel.setDisbussmentDate(formattedDate);
            leedsModel.setApprovedLoan(approved);
            leedsModel.setDisbusedLoanAmount(disbuss);
            leedsModel.setPendingLoanAmount(pending);
        }

        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap());
    }

    private void updateLeed(String leedId, Map leedsMap) {
        progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));
        leedRepository.updateLeed(leedId, leedsMap, new CallBack() {
            @Override
            public void onSuccess(Object object) {
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

    private void getdata() {

        ////////////////////////////////////LEED DETAILS////////////////////////////////////////////////

        String leedid = leedsModel.getLeedNumber();
        String agentname = leedsModel.getAgentName();
        Long ldatetime = leedsModel.getCreatedDateTimeLong();
        Long time = leedsModel.getCreatedDateTimeLong();
        spinloantype.setText(leedsModel.getLoanType());


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
            txtGender.setText(gender);
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
            txtEducation.setText(education);
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
            AddressYN.setText("Yes");
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

                Recidential.setText(residencial);

            } else {
                HideFields(layoutResidentialtype);
            }
        } catch (Exception e) {
            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
        }

        if (adhar != null) {
            chAdhar.setText("✔");
        } else {
            HideFields(layoutkycadaar);
        }
        if (pannumber != null) {
            chPAN.setText("✔");
            txtpannumber.setText(pannumber);
        } else {
            HideFields(layoutkycpan);
        }
        if (apvoterid != null) {
            chVoterID.setText("✔");
        } else {
            HideFields(layoutkycvoterid);
        }
        if (apdrivinglicence != null) {
            chDL.setText("✔");
        } else {
            HideFields(layoutkycdl);
        }
        if (passport != null) {
            chPassport.setText("✔");
        } else {
            HideFields(layoutkycpassport);
        }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////
        if (proofadhar != null) {
            chProofAdhar.setText("✔");
        } else {
            HideFields(layoutkycproofadhar);
        }
        if (proofvoterid != null) {
            chProofVoterid.setText("✔");
        } else {
            HideFields(layoutkycproofvoterid);
        }
        if (dlproof != null) {
            chProofdl.setText("✔");
        } else {
            HideFields(layoutkycproofdl);
        }
        if (electricitybillproof != null) {
            chProofElectricitybill.setText("✔");
        } else {
            HideFields(layoutkycproofelectricitybill);
        }
        if (rentagmtproof != null) {
            chProofRntagmt.setText("✔");
        } else {
            HideFields(layoutkycproofrentaggrement);
        }
        if (passportproof != null) {
            chProofPassport.setText("✔");
        } else {
            HideFields(layoutkycproofpassport);
        }
        if (gevtidproof != null) {
            chProofGovtEmpid.setText("✔");
        } else {
            HideFields(layoutkycproofgovid);
        }
        if (gumastaproof != null) {
            chProofGumasta.setText("✔");
        } else {
            HideFields(layoutkycproofgumasta);
        }
        if (currentacctprrof != null) {
            chProofCurrentacctStmt.setText("✔");
        } else {
            HideFields(layoutkycproofcurrentacctstmt);
        }
        if (applicantYN != null) {
            txtCoApplicant.setText(applicantYN);

            if (applicantYN.equalsIgnoreCase("No")) {
                HideFields(layoutcoapplicantrelation);
                HideFields(layoutRelation);
            } else if (applicantYN.equalsIgnoreCase("Yes")) {
                CoapplicantRalationship.setText((prapplicantrelation));
            }
//                HideFields(layoutDate );

        }
//        try {
//            if (prapplicantrelation != null) {
//                CoapplicantRalationship.setText((prapplicantrelation));
//            } else {
//                HideFields(layoutcoapplicantrelation);
//            }
//        } catch (Exception e) {
//
//        }
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
        String loginid1 = leedsModel.getLoginid();
        String appointment = leedsModel.getAppointment();
        String appointmentreschedule = leedsModel.getAppointreschedualreason();
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
        if (loginid1 != null && !loginid1.equalsIgnoreCase("")) {
            txtLoginId.setText(loginid1);
        } else {
            HideFields(layoutlognid);
        }
        if (appointment != null && !appointment.equalsIgnoreCase("")) {
            edtappointment.setText(appointment);
        } else {
            HideFields(layoutappointment);
        }
        if (appointmentreschedule != null && !appointmentreschedule.equalsIgnoreCase("")) {
            edtappointmentreschedule.setText(appointmentreschedule);
        } else {
            HideFields(lauoutappointmentreschedule);
        }
        try {
            if (salsepersone != null && !salsepersone.equalsIgnoreCase("")) {
                SPsalesperson.setText(salsepersone);
            } else {
                HideFields(Layoutsalesperson);
            }
        } catch (Exception e) {

        }
        if (sCompanytype != null) {
//                ArrayAdapter myAdap = (ArrayAdapter) SPcompanytype.getAdapter();
            SPcompanytype.setText(sCompanytype);
        }

        if (sEmployed != null) {
            txtOccupationtype.setText(sEmployed);
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
            SPsalarytype.setText(sSalarytype);
        } else {
//                HideFields(layoutDate );
        }

        if (sRental != null && !sRental.equalsIgnoreCase("")) {
            edtrental.setText(sRental);
        } else {
            HideFields(layoutrentalexpence);
        }
        if (sEMIcar != null && !sEMIcar.equalsIgnoreCase("")) {
            chcarloan.setText("✔");
            txtCarloan.setText(carloanamt);
        } else {
            HideFields(layoutMECarloan);
        }
        if (sEMIhome != null && !sEMIhome.equalsIgnoreCase("")) {

            chhomloan.setText("✔");
            txtHomeloan.setText(homeloanamt);
        } else {
            HideFields(layoutMEhomeloan);
        }
        if (sEMIsociety != null && !sEMIsociety.equalsIgnoreCase("")) {
            chsocietyloan.setText("✔");
            txtsocietyloan.setText(societyloanamt);
        } else {
            HideFields(layoutMEsocietyloan);
        }
        if (sEMIpersonal != null && !sEMIpersonal.equalsIgnoreCase("")) {
            chpersonalloan.setText("✔");
            txtpersonalloan.setText(personalloanamt);
        } else {
            HideFields(layoutMEpersonalloan);
        }
        if (sEMIother != null && !sEMIother.equalsIgnoreCase("")) {
            chotherloan.setText("✔");
            edtotheremidetails.setText(emiOtherDetails);

        } else {
            HideFields(layoutMEotherlon);
        }
        if (sSalrysleep != null) {
            chsalarysleep.setText("✔");
        } else {
            HideFields(layoutsalarysalarysleep);
        }
        if (sBankstmt != null) {
            chbankstatement.setText("✔");
        } else {
            HideFields(layoutsalarybankstmt);
        }
        if (sForm != null) {
            chformno16.setText("✔");
        } else {
            HideFields(layoutsalaryform16);
        }
        if (sAppointmentltr != null) {
            chappointmentletter.setText("✔");
        } else {
            HideFields(layoutsalaryappointment);
        }
        if (sConfermationltr != null) {
            chconfermationletter.setText("✔");
        } else {
            HideFields(layoutsalaryconfermation);
        }
        if (sExperinceltr != null) {
            chexperieceletter.setText("✔");
        } else {
            HideFields(layoutsalaryreleiving);
        }

        if (sVisa != null) {
            chvisa.setText("✔");
        } else {
            HideFields(layoutnrivisa);
        }
        if (sPassport != null) {
            chpassport.setText("✔");
        } else {
            HideFields(layoutnripassport);
        }
        if (sEmployerltr != null) {
            chemployerletter.setText("✔");
        } else {
            HideFields(layoutnriemployerletter);
        }
        if (sContractltr != null) {
            chcontractletter.setText("✔");
        } else {
            HideFields(layoutnricontractletter);
        }
        if (sPOA != null) {
            chPOA.setText("✔");
        } else {
            HideFields(layoutnriPOA);
        }
        if (sNREbank != null) {
            chNREbankstatement.setText("✔");
        } else {
            HideFields(layoutnriNREbankacctstmt);
        }
        if (sOverseasebank != null) {
            choverbankdetails.setText("✔");
        } else {
            HideFields(layoutnrioverseasebank);
        }

        if (sITR != null) {
            chitr.setText("✔");
        } else {
            HideFields(layoutselfITR);
        }
        if (sCurrentbank != null) {
            chcurrentbankstatement.setText("✔");
        } else {
            HideFields(layoutselfcurrentacctstmt);
        }
        if (sSavingbank != null) {
            chsavingacctstatement.setText("✔");
        } else {
            HideFields(layoutselfsavingacct);
        }
        if (sPartnerdeed != null) {
            chpartnersheepdeed.setText("✔");
        } else {
            HideFields(layoutselfpartnersheepdeed);
        }
        if (sBusinessagmt != null) {
            chbisunessagreement.setText("✔");
        } else {
            HideFields(layoutselfbusinessagreement);
        }
        if (sQualification != null) {
            chqualification.setText("✔");
        } else {
            HideFields(layoutselfqualificationcertificate);
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

        SPpropertytype.setText(propertytype);

        if (property != null) {
            txtAboutProperty.setText(property);
        }

        if (YN != null) {

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

        String loginid = leedsModel.getLoginid();
        if (loginid != null) {
            edtloginId.setText(loginid);
        }

//        } catch (Exception e) {
//            Toast.makeText(getContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
//        }

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

                }
            }

            @Override
            public void onError(Object object) {

            }
        });
    }


    private void HideFields(RelativeLayout layout) {
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) layout.getLayoutParams();
        params1.height = 0;
        layout.setLayoutParams(params1);
    }

    public void onItemSelected(AdapterView<?> adapterView, View arg1, int position, long id) {
//        sploantype = spinloantype.getSelectedItem().toString();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

}
