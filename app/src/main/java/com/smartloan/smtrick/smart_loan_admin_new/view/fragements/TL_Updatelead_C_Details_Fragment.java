package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.content.ContextCompat;
import androidx.appcompat.widget.Toolbar;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
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
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.MainActivity_telecaller;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.TL_Updatelead_C_Details_Activity;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.TL_Updatelead_Coapplicant_Detail_Activity;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.Tl_Updatelead_incomedetails_Activity;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.CALANDER_DATE_FORMATE;

public class TL_Updatelead_C_Details_Fragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    Spinner CoapplicantRalationship;
    RadioButton REducation, RYN, Rcoapplicant1, RcoapplicantNO, RcoapplicantYES;
    Spinner Recidential;
    RadioButton Rgender, Rfemale, Rmale, Ryes, Rno, Rpro, Rgraduate, Rother, Rpostgraduate, Rundergraduate;
    RadioGroup groupRadio, groupRadioGender, groupRadiocoapplicant;
    AppSharedPreference appSharedPreference;

    Button btnnext, btnsave;
    String cAdhar, cAdress, cAltcontatct, cBdate, cContatct, cCurrentPIN, cCurrentarea, cCurrentlandmark, cCurrentstreet, cDL,
            cEducation, cEmail, cGender, cNmae, cOffaddress, cOther, cPAN, cPANnumber, cAdharNumber, cPIN, cPadress, cPassport, cProofDL,
            cProofadhar, cProofcurrentacctstmt, cProofelectricitybill, cProofgovtid, cProofgumasta, cProofpassport, cProofrentagmt,
            cProofvoterid, cVoterid, cYesNo, carea;
    CheckBox chAdhar, chDL, chPAN, chPassport, chProofAdhar, chProofCurrentacctStmt, chProofElectricitybill, chProofGovtEmpid,
            chProofGumasta, chProofPassport, chProofRntagmt, chProofVoterid, chProofdl, chVoterID;
    String clandmark;

    String cresidencial;
    String cstreet;
    EditText currentarea, currentlandmark, currentpin, currentstreet, edtotherrelationship, edtreferenceaddress, edtreferenceaddress2,
            edtreferencecontactno, edtreferencecontactno2, edtreferencename, edtreferencename2, edtreferencerelationship,
            edtreferencerelationship2, etaddress, etalternatecontact, etbirthdate, etcEmail, etcname,
            etcontatct, etoffaddress, etother;


    EditText PerAddress, landmark, pin, area, street;

    RelativeLayout layoutarea, layoutlandmark, layoutotherrelationship, layoutothervalue, layoutperaddress, layoutpin, layoutref1address, layoutref1contact,
            layoutref1name, layoutref1relationship, layoutref2address, layoutref2contact, layoutref2name, layoutref2relationship,
            layoutrelationship, layoutsavebutton, layoutstreet;

    LeedRepository leedRepository;
    LeedsModel leedsModel;
    ProgressDialogClass progressDialogClass;
    String sapplicantrelation, scoapplicantYN, sotherrelationship;
    String sreference1address, sreference1name, sreference2address, sreference2contactno, sreference2name, sreference2relationship,
            sreferencecontactno, sreferencerelationship;

    TextView txtleadid;
    EditText txtpannumber, txtAdharNumber;
    String code = "100";
    int fromYear, fromMonth, fromDay;
    long fromDate;

    @Override
    public void onClick(View view) {
        if (view == btnsave) {
            cNmae = etcname.getText().toString();
            cAdress = etaddress.getText().toString();
            cCurrentPIN = currentpin.getText().toString();
            cCurrentlandmark = currentlandmark.getText().toString();
            cCurrentarea = currentarea.getText().toString();
            cCurrentstreet = currentstreet.getText().toString();
            cPadress = PerAddress.getText().toString();
            cPIN = pin.getText().toString();
            clandmark = landmark.getText().toString();
            carea = area.getText().toString();
            cstreet = street.getText().toString();
            cOffaddress = etoffaddress.getText().toString();
            cBdate = etbirthdate.getText().toString();
            cContatct = etcontatct.getText().toString();
            cAltcontatct = etalternatecontact.getText().toString();
            cEmail = etcEmail.getText().toString();
            cPANnumber = txtpannumber.getText().toString();
            cAdharNumber = txtAdharNumber.getText().toString();

            if (!cEmail.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+")) {
                etcEmail.setError("Invalid Email");
            }

            cresidencial = Recidential.getSelectedItem().toString();
            sapplicantrelation = CoapplicantRalationship.getSelectedItem().toString();
            sotherrelationship = edtotherrelationship.getText().toString();
            cOther = etother.getText().toString();

            if (chAdhar.isChecked()) {

                cAdhar = chAdhar.getText().toString();
            }
            if (chPAN.isChecked()) {

                cPAN = chPAN.getText().toString();
            }
            if (chVoterID.isChecked()) {

                cVoterid = chVoterID.getText().toString();
            }
            if (chDL.isChecked()) {

                cDL = chDL.getText().toString();
            }
            if (chPassport.isChecked()) {

                cPassport = chPassport.getText().toString();
            }
            if (chProofAdhar.isChecked()) {

                cProofadhar = chProofAdhar.getText().toString();
            }
            if (chProofVoterid.isChecked()) {

                cProofvoterid = chProofVoterid.getText().toString();
            }
            if (chProofdl.isChecked()) {

                cProofDL = chProofdl.getText().toString();
            }
            if (chProofElectricitybill.isChecked()) {

                cProofelectricitybill = chProofElectricitybill.getText().toString();
            }
            if (chProofRntagmt.isChecked()) {

                cProofrentagmt = chProofRntagmt.getText().toString();
            }
            if (chProofPassport.isChecked()) {

                cProofpassport = chProofPassport.getText().toString();
            }
            if (chProofGovtEmpid.isChecked()) {

                cProofgovtid = chProofGovtEmpid.getText().toString();
            }
            if (chProofGumasta.isChecked()) {

                cProofgumasta = chProofGumasta.getText().toString();
            }
            if (chProofCurrentacctStmt.isChecked()) {

                cProofcurrentacctstmt = chProofCurrentacctStmt.getText().toString();
            }
            if (TextUtils.isEmpty(cNmae)) {
                etcname.setError("Required");
                Toast.makeText(getContext(), "Enter Customers full Name!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(cBdate)) {
                etbirthdate.setError("Required");
                Toast.makeText(getContext(), "Enter Birth Date!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(cContatct)) {
                etcontatct.setError("Required");
                Toast.makeText(getContext(), "Enter Contact!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(cAltcontatct)) {
                etalternatecontact.setError("Required");
                Toast.makeText(getContext(), "Enter Alternate Contact!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(cEmail)) {
                etcEmail.setError("Required");
                Toast.makeText(getContext(), "Enter Email!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(cOffaddress)) {
                etoffaddress.setError("Required");
                Toast.makeText(getContext(), "Enter Office address!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(cAdhar)) {
                Toast.makeText(getContext(), "Provide Adhar Card!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(cPAN)) {
                Toast.makeText(getContext(), "Provide PAN Card!", Toast.LENGTH_SHORT).show();
            } else {
                updateLeadDetails(leedsModel);

                Bundle bundle = new Bundle();
                bundle.putSerializable(Constant.LEED_MODEL, leedsModel);// Put anything what you want
                bundle.putString("code", code);
                TL_Updatelead_Coapplicant_Detail_Fragment fragment2 = new TL_Updatelead_Coapplicant_Detail_Fragment();
                fragment2.setArguments(bundle);

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.detailContainer, fragment2);
                ft.commit();
                getActivity().overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
            if (view == btnnext) {
                cNmae = etcname.getText().toString();
                cAdress = etaddress.getText().toString();
                cCurrentPIN = currentpin.getText().toString();
                cCurrentlandmark = currentlandmark.getText().toString();
                cCurrentarea = currentarea.getText().toString();
                cCurrentstreet = currentstreet.getText().toString();
                cPadress = PerAddress.getText().toString();
                cPIN = pin.getText().toString();
                clandmark = landmark.getText().toString();
                carea = area.getText().toString();
                cstreet = street.getText().toString();
                cOffaddress = etoffaddress.getText().toString();
                cBdate = etbirthdate.getText().toString();
                cPANnumber = txtpannumber.getText().toString();
                cAdharNumber = txtAdharNumber.getText().toString();

                if (groupRadioGender.getCheckedRadioButtonId() != -1) {
                    RadioButton btn = (RadioButton) groupRadioGender.getChildAt(groupRadioGender.indexOfChild(groupRadioGender.findViewById(groupRadioGender.getCheckedRadioButtonId())));
                    cGender = btn.getText().toString();
                }
                if (groupRadio.getCheckedRadioButtonId() != -1) {
                    RadioButton btn = (RadioButton) groupRadio.getChildAt(groupRadio.indexOfChild(groupRadio.findViewById(groupRadio.getCheckedRadioButtonId())));
                    cYesNo = btn.getText().toString();
                }
//                if (groupRadioEducation.getCheckedRadioButtonId() != -1) {
//                    RadioButton btn = (RadioButton) groupRadioEducation.getChildAt(groupRadioEducation.indexOfChild(groupRadioEducation.findViewById(groupRadioEducation.getCheckedRadioButtonId())));
//                    cEducation = btn.getText().toString();
//                }
//                if (groupRadioEducation2.getCheckedRadioButtonId() != -1) {
//                    RadioButton btn = (RadioButton) groupRadioEducation2.getChildAt(groupRadioEducation2.indexOfChild(groupRadioEducation2.findViewById(groupRadioEducation2.getCheckedRadioButtonId())));
//                    cEducation = btn.getText().toString();
//                }
                if (groupRadiocoapplicant.getCheckedRadioButtonId() != -1) {
                    RadioButton btn2 = (RadioButton) groupRadiocoapplicant.getChildAt(groupRadiocoapplicant.indexOfChild(groupRadiocoapplicant.findViewById(groupRadiocoapplicant.getCheckedRadioButtonId())));
                    scoapplicantYN = btn2.getText().toString();
                }

                cContatct = etcontatct.getText().toString();
                cAltcontatct = etalternatecontact.getText().toString();
                cEmail = etcEmail.getText().toString();
                cresidencial = Recidential.getSelectedItem().toString();
                cOther = etother.getText().toString();

                if (chAdhar.isChecked()) {

                    cAdhar = chAdhar.getText().toString();
                }
                if (chPAN.isChecked()) {

                    cPAN = chPAN.getText().toString();
                }
                if (chVoterID.isChecked()) {

                    cVoterid = chVoterID.getText().toString();
                }
                if (chDL.isChecked()) {

                    cDL = chDL.getText().toString();
                }
                if (chPassport.isChecked()) {

                    cPassport = chPassport.getText().toString();
                }
                if (chProofAdhar.isChecked()) {
                    cProofadhar = chProofAdhar.getText().toString();
                }
                if (chProofVoterid.isChecked()) {
                    cProofvoterid = chProofVoterid.getText().toString();
                }
                if (chProofdl.isChecked()) {
                    cProofDL = chProofdl.getText().toString();
                }
                if (chProofElectricitybill.isChecked()) {
                    cProofelectricitybill = chProofElectricitybill.getText().toString();
                }
                if (chProofRntagmt.isChecked()) {
                    cProofrentagmt = chProofRntagmt.getText().toString();
                }
                if (chProofPassport.isChecked()) {
                    cProofpassport = chProofPassport.getText().toString();
                }
                if (chProofGovtEmpid.isChecked()) {
                    cProofgovtid = chProofGovtEmpid.getText().toString();
                }
                if (chProofGumasta.isChecked()) {
                    cProofgumasta = chProofGumasta.getText().toString();
                }
                if (chProofCurrentacctStmt.isChecked()) {
                    cProofcurrentacctstmt = chProofCurrentacctStmt.getText().toString();
                }
                if (scoapplicantYN.equalsIgnoreCase("Yes")) {
                    sapplicantrelation = CoapplicantRalationship.getSelectedItem().toString();
                }

                sotherrelationship = edtotherrelationship.getText().toString();
                sreference1name = edtreferencename.getText().toString();
                sreference1address = edtreferenceaddress.getText().toString();
                sreferencecontactno = edtreferencecontactno.getText().toString();
                sreferencerelationship = edtreferencerelationship.getText().toString();
                sreference2name = edtreferencename2.getText().toString();
                sreference2address = edtreferenceaddress2.getText().toString();
                sreference2contactno = edtreferencecontactno2.getText().toString();
                sreference2relationship = edtreferencerelationship2.getText().toString();

                if (TextUtils.isEmpty(cNmae)) {
                    etcname.setError("Required");
                    Toast.makeText(getContext(), "Enter Name!", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(cBdate)) {
                    etbirthdate.setError("Required");
                    Toast.makeText(getContext(), "Enter Birth Date!", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(cContatct)) {
                    etcontatct.setError("Required");
                    Toast.makeText(getContext(), "Enter Contact!", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(cAltcontatct)) {
                    etalternatecontact.setError("Required");
                    Toast.makeText(getContext(), "Enter Alternete Contact!", Toast.LENGTH_SHORT).show();
                } else {
                    String emialpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                    if (TextUtils.isEmpty(cEmail)) {
                        etcEmail.setError("Required");
                        Toast.makeText(getContext(), "Enter Email Address!", Toast.LENGTH_SHORT).show();
                    } else if (!cEmail.matches(emialpattern)) {
                        etcEmail.setError("Invalid Email");
                        Toast.makeText(getContext(), "Invalid Email Address", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(cOffaddress)) {
                        Toast.makeText(getContext(), "Enter Office Address!", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(cAdhar)) {
                        Toast.makeText(getContext(), "Provide Adhar Card!", Toast.LENGTH_SHORT).show();
                    } else if (TextUtils.isEmpty(cPAN)) {
                        Toast.makeText(getContext(), "Provide PAN Card!", Toast.LENGTH_SHORT).show();
                    } else {
                        updateLeadDetails(leedsModel);

                        Bundle bundle = new Bundle();
                        bundle.putSerializable(Constant.LEED_MODEL, leedsModel);// Put anything what you want

                        Tl_Updatelead_incomedetails_Fragment fragment2 = new Tl_Updatelead_incomedetails_Fragment();
                        fragment2.setArguments(bundle);

                        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.detailContainer, fragment2);
                        ft.commit();
                        getActivity().overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                    }
                }
            }
        }


    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.tl_updatelead_c_details_activity, container, false);

        ((AppCompatActivity) getActivity()).setSupportActionBar((Toolbar) view.findViewById(R.id.toolbar));
        Bundle args = this.getArguments();
        if (args != null) {
            leedsModel = (LeedsModel) args.getSerializable(Constant.LEED_MODEL);

        }
        layoutperaddress = (RelativeLayout) view.findViewById(R.id.layoutperaddress);
        layoutpin = (RelativeLayout) view.findViewById(R.id.layoutpin);
        layoutlandmark = (RelativeLayout) view.findViewById(R.id.layoutland);
        layoutarea = (RelativeLayout) view.findViewById(R.id.layoutArea);
        layoutstreet = (RelativeLayout) view.findViewById(R.id.layoutstreet);
        layoutothervalue = (RelativeLayout) view.findViewById(R.id.layoutothervalue);
        layoutrelationship = (RelativeLayout) view.findViewById(R.id.layoutcoapplicantrelation);
        layoutotherrelationship = (RelativeLayout) view.findViewById(R.id.layoutotherrelationship);
        layoutsavebutton = (RelativeLayout) view.findViewById(R.id.layoutbuttonsave);
        layoutref1name = (RelativeLayout) view.findViewById(R.id.layoutreferencefullname);
        layoutref1address = (RelativeLayout) view.findViewById(R.id.layoutreferenceaddress);
        layoutref1contact = (RelativeLayout) view.findViewById(R.id.layoutreferencecontactno);
        layoutref1relationship = (RelativeLayout) view.findViewById(R.id.layoutreferencerelationhsip);
        layoutref2name = (RelativeLayout) view.findViewById(R.id.layoutreference2fullname);
        layoutref2address = (RelativeLayout) view.findViewById(R.id.layoutreference2address);
        layoutref2contact = (RelativeLayout) view.findViewById(R.id.layoutreference2contactno);
        layoutref2relationship = (RelativeLayout) view.findViewById(R.id.layoutreference2relationhsip);

        progressDialogClass = new ProgressDialogClass(getActivity());
        leedRepository = new LeedRepositoryImpl();
        appSharedPreference = new AppSharedPreference(getContext());

        String[] recidential = new String[]{"Owned", "Rented", "Allotted by Employer", "Family"};
        String[] CoapplicantRelation = new String[]{"Spouse", "Parents", "Children", "Power of Attorney", "Please specify"};
        btnnext = (Button) view.findViewById(R.id.buttonupdatenext);
        btnsave = (Button) view.findViewById(R.id.buttonsave);
        etcname = (EditText) view.findViewById(R.id.txtcamevalue);
        etaddress = (EditText) view.findViewById(R.id.txtcurrentaddressvalue);
        groupRadio = (RadioGroup) view.findViewById(R.id.radioGYN);
        currentpin = (EditText) view.findViewById(R.id.txtcurrentpin1);
        currentlandmark = (EditText) view.findViewById(R.id.txtcurrentlandmark1);
        currentarea = (EditText) view.findViewById(R.id.txtcurrentarea1);
        currentstreet = (EditText) view.findViewById(R.id.txtcurrentstreet1);
        PerAddress = (EditText) view.findViewById(R.id.txtperaddress1);
        pin = (EditText) view.findViewById(R.id.txtpin1);
        landmark = (EditText) view.findViewById(R.id.txtlandmark1);
        area = (EditText) view.findViewById(R.id.txtarea1);
        street = (EditText) view.findViewById(R.id.txtstreet1);
        etoffaddress = (EditText) view.findViewById(R.id.txtofficeaddressvalue);
        etbirthdate = (EditText) view.findViewById(R.id.txtbirthdatevalue);
//        groupRadioEducation = (RadioGroup) view.findViewById(R.id.radioeducation);
//        groupRadioEducation2 = (RadioGroup) view.findViewById(R.id.radioeducation2);
        groupRadioGender = (RadioGroup) view.findViewById(R.id.radioSex);
        etcontatct = (EditText) view.findViewById(R.id.txtcontatctvalue);
        etalternatecontact = (EditText) view.findViewById(R.id.edtaltcontact);
        etcEmail = (EditText) view.findViewById(R.id.txtemail1);
        Recidential = (Spinner) view.findViewById(R.id.spinnerrecidencialvalue);
        CoapplicantRalationship = (Spinner) view.findViewById(R.id.txtcoapplicantrelation1);
        CoapplicantRalationship.setOnItemSelectedListener(this);
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
        txtAdharNumber = (EditText) view.findViewById(R.id.txtadharnumber);
        txtpannumber.setFilters(new InputFilter[]{new InputFilter.AllCaps()});

        ArrayAdapter<String> spinnerArrayAdapterRecidential = new ArrayAdapter(getContext(), R.layout.sppinner_layout_listitem, recidential);
        spinnerArrayAdapterRecidential.setDropDownViewResource(R.layout.sppinner_layout_listitem);
        Recidential.setAdapter(spinnerArrayAdapterRecidential);

        ArrayAdapter<String> spinnerArrayAdapterRelationship = new ArrayAdapter(getContext(), R.layout.sppinner_layout_listitem, CoapplicantRelation);
        spinnerArrayAdapterRelationship.setDropDownViewResource(R.layout.sppinner_layout_listitem);
        CoapplicantRalationship.setAdapter(spinnerArrayAdapterRelationship);

        etother = (EditText) view.findViewById(R.id.txtOthervalue);
        chAdhar = (CheckBox) view.findViewById(R.id.checkboxadhar);
        chPAN = (CheckBox) view.findViewById(R.id.checkboxpan);
        if (chPAN.isChecked()) {
            txtpannumber.setVisibility(View.VISIBLE);
        } else {
            txtpannumber.setVisibility(View.INVISIBLE);
        }
        if (chAdhar.isChecked()) {
            txtAdharNumber.setVisibility(View.VISIBLE);
        } else {
            txtAdharNumber.setVisibility(View.INVISIBLE);
        }
        chPAN.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    txtpannumber.setVisibility(View.VISIBLE);
                } else {
                    txtpannumber.setVisibility(View.INVISIBLE);
                }
            }
        });
        chAdhar.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    txtAdharNumber.setVisibility(View.VISIBLE);
                } else {
                    txtAdharNumber.setVisibility(View.INVISIBLE);
                }
            }
        });


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
        txtleadid = (TextView) view.findViewById(R.id.textheader);
        RcoapplicantYES = (RadioButton) view.findViewById(R.id.radioapplicantYES);
        RcoapplicantNO = (RadioButton) view.findViewById(R.id.radioapplicantNO);
        groupRadiocoapplicant = (RadioGroup) view.findViewById(R.id.radiocoapplicantYesNo);
        groupRadiocoapplicant.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                Rcoapplicant1 = (RadioButton) view.findViewById(checkedId);
                scoapplicantYN = Rcoapplicant1.getText().toString();
                if (Rcoapplicant1.getText().toString().equalsIgnoreCase("Yes")) {
                    ShowApplicant();
                } else {
                    HideApplicant();
                }
            }
        });
//        groupRadioEducation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
//
//                if (checkedId != -1) {
//                    groupRadioEducation2.check(-1);
//                }

//                REducation = (RadioButton) view.findViewById(checkedId);
//                if (REducation.getText().toString().equalsIgnoreCase("Other")) {
//                    Showother();
//
//                } else  {
//                    hideother();
//
//                }
//            }
//        });
//        groupRadioEducation2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
//
//                if (checkedId != -1) {
//                    groupRadioEducation.check(-1);
//                }
//
//                REducation = (RadioButton) view.findViewById(checkedId);
//                if (REducation.getText().toString().equalsIgnoreCase("Other")) {
//                    Showother();
//
//                } else  {
//                    hideother();
//
//                }
//            }
//        });
        Ryes = (RadioButton) view.findViewById(R.id.radioYes);
        Rno = (RadioButton) view.findViewById(R.id.radioNo);
        Rundergraduate = (RadioButton) view.findViewById(R.id.radioUG);
        Rgraduate = (RadioButton) view.findViewById(R.id.radioGraguate);
        Rpostgraduate = (RadioButton) view.findViewById(R.id.radioPG);
        Rpro = (RadioButton) view.findViewById(R.id.radioprofessional);
        Rother = (RadioButton) view.findViewById(R.id.radioother);
        Rmale = (RadioButton) view.findViewById(R.id.radioMale);
        Rfemale = (RadioButton) view.findViewById(R.id.radioFemale);

        Rundergraduate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    cEducation = Rundergraduate.getText().toString();
//                    hideother();
                    Rgraduate.setChecked(false);
                    Rpostgraduate.setChecked(false);
                    Rpro.setChecked(false);
                    Rother.setChecked(false);

                }
            }
        });
        Rgraduate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    cEducation = Rundergraduate.getText().toString();
//                    hideother();
                    Rundergraduate.setChecked(false);
                    Rpostgraduate.setChecked(false);
                    Rpro.setChecked(false);
                    Rother.setChecked(false);
                }
            }
        });
        Rpostgraduate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    cEducation = Rundergraduate.getText().toString();
//                    hideother();
                    Rgraduate.setChecked(false);
                    Rundergraduate.setChecked(false);
                    Rpro.setChecked(false);
                    Rother.setChecked(false);
                }
            }
        });
        Rpro.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    cEducation = Rundergraduate.getText().toString();
//                    hideother();
                    Rgraduate.setChecked(false);
                    Rpostgraduate.setChecked(false);
                    Rundergraduate.setChecked(false);
                    Rother.setChecked(false);
                }
            }
        });
        Rother.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    cEducation = Rundergraduate.getText().toString();
//                    Showother();
                    Rgraduate.setChecked(false);
                    Rpostgraduate.setChecked(false);
                    Rpro.setChecked(false);
                    Rundergraduate.setChecked(false);
                }
            }
        });
        groupRadioGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                Rgender = (RadioButton) view.findViewById(checkedId);

                cGender = Rgender.getText().toString();
            }
        });
        groupRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RYN = (RadioButton) view.findViewById(checkedId);

                cYesNo = RYN.getText().toString();
                if (RYN.getText().toString().equalsIgnoreCase("No")) {
                    fieldVisibility();
                } else {
                    FieldInvisible();
                }
            }
        });
        if (groupRadioGender.getCheckedRadioButtonId() != -1) {
            cGender = ((RadioButton) groupRadioGender.getChildAt(groupRadioGender.indexOfChild(groupRadioGender.findViewById(groupRadioGender.getCheckedRadioButtonId())))).getText().toString();
        }
        if (groupRadio.getCheckedRadioButtonId() != -1) {
            cYesNo = ((RadioButton) groupRadio.getChildAt(groupRadio.indexOfChild(groupRadio.findViewById(groupRadio.getCheckedRadioButtonId())))).getText().toString();
            if (cYesNo.equalsIgnoreCase("No")) {
                fieldVisibility();
            } else {
                FieldInvisible();
            }
        }
//        if (groupRadioEducation.getCheckedRadioButtonId() != -1) {
//            cEducation = ((RadioButton) groupRadioEducation.getChildAt(groupRadioEducation.indexOfChild(groupRadioEducation.findViewById(groupRadioEducation.getCheckedRadioButtonId())))).getText().toString();
//            if (cEducation.equalsIgnoreCase("Other")) {
//                Showother();
//            } else {
//                hideother();
//            }
//        }

        if (groupRadiocoapplicant.getCheckedRadioButtonId() != -1) {
            scoapplicantYN = ((RadioButton) groupRadiocoapplicant.getChildAt(groupRadiocoapplicant.indexOfChild(groupRadiocoapplicant.findViewById(groupRadiocoapplicant.getCheckedRadioButtonId())))).getText().toString();
            if (scoapplicantYN.equalsIgnoreCase("Yes")) {
                ShowApplicant();
            } else {
                HideApplicant();
            }
        }


        btnsave.setOnClickListener(this);
        btnnext.setOnClickListener(this);

        String code1 = args.getString("code");
        if (code.equalsIgnoreCase(code1)) {
            edtreferencename.requestFocus();
        }
        getdata();
        setFromDateClickListner();
        return view;
    }

    private void getdata() {

        String currentPIN = null;
        String leednumber = leedsModel.getLeedNumber();
        String cname = leedsModel.getCustomerName();
        String caddress = leedsModel.getAddress();
        String officeaddress = leedsModel.getofficeAdderess();
        String contact = leedsModel.getMobileNumber();
        String altcontact = leedsModel.getAlternetMobileNumber();
        String birthdate = leedsModel.getDateOfBirth();
        String residencial = leedsModel.getRecidential();
        String permanataddress = leedsModel.getPeraddress();
        String addressYN = leedsModel.getAddressYesNo();
        String otherEdu = leedsModel.getOtherEducation();
        String education = leedsModel.getEducation();
        String gender = leedsModel.getGender();
        String applicantYN = leedsModel.getCoApplicantYN();
        String currentPIN2 = leedsModel.getCurrentpin();
        String birthdate2 = birthdate;
        birthdate = leedsModel.getCurrentlandmark();
        String residencial2 = residencial;
        residencial = leedsModel.getCurrentarea();
        String altcontact2 = altcontact;
        altcontact = leedsModel.getCurrentstreet();
        String contact2 = contact;
        contact = leedsModel.getPincode();
        String officeaddress2 = officeaddress;
        officeaddress = leedsModel.getLandmark();
        String permanataddress2 = permanataddress;
        permanataddress = leedsModel.getArea();
        String caddress2 = caddress;
        caddress = leedsModel.getStreet();
        String cname2 = cname;
        cname = leedsModel.getEmail();
        String leednumber2 = leednumber;
        String adhar = leedsModel.getadharNo();
        String pan = leedsModel.getCheckpanCardNumber();
        String pannumber = leedsModel.getPanCardNumber();
        String Adharnumber = leedsModel.getadharNo();
        leednumber = leedsModel.getApvoterid();
        String email = cname;
        cname = leedsModel.getApdrivinglicence();
        String otherEdu2 = otherEdu;
        String passport = leedsModel.getAppassport();
        otherEdu = leedsModel.getProofadhar();
        String driverlicence = cname;
        cname = leedsModel.getProofvoterid();
        String voterid = leednumber;
        String dlproof = leedsModel.getProofdl();
        String electricitybillproof = leedsModel.getProofelectricitybill();
        String rentagmtproof = leedsModel.getProofrentagmt();
        String passportproof = leedsModel.getProofpassport();
        String gevtidproof = leedsModel.getProofgevtid();
        String gumastaproof = leedsModel.getProofgumasta();
        String currentacctprrof = leedsModel.getProofcurrentacctstmt();
        leednumber = leedsModel.getPrapplicantrelation();
        String voteridproof = cname;
        cname = leedsModel.getCoapplicantotherrelation();
        String adharproof = otherEdu;
        otherEdu = leedsModel.getPrreference1name();
        String Sstreet = caddress;
        caddress = leedsModel.getPrreference1address();
        String Sarea = permanataddress;
        permanataddress = leedsModel.getPrreferencecontactno();
        String land = officeaddress;
        officeaddress = leedsModel.getPrreferencerelationship();
        String PIN = contact;
        contact = leedsModel.getPrreference2name();
        String addressYN2 = addressYN;
        addressYN = leedsModel.getPrreference2address();
        String currentSstreet = altcontact;
        altcontact = leedsModel.getPrreference2contactno();
        String currentSarea = residencial;
        residencial = leedsModel.getPrreference2relationship();
        String currentland = birthdate;
        String peraddress = leedsModel.getPeraddress();


        if (applicantYN == null) {
            currentPIN = currentPIN2;
        } else if (applicantYN.equalsIgnoreCase("Yes")) {
            currentPIN = currentPIN2;
            RcoapplicantYES.setChecked(true);
            ShowApplicant();
        } else {
            currentPIN = currentPIN2;
            if (applicantYN.equalsIgnoreCase("No")) {
                RcoapplicantNO.setChecked(true);
                HideApplicant();
            }
        }


        if (leednumber != null) {
            ArrayAdapter myAdap = (ArrayAdapter) CoapplicantRalationship.getAdapter();
            CoapplicantRalationship.setSelection(myAdap.getPosition(leednumber));
            if (leednumber.equalsIgnoreCase("Please specify")) {
                showotherRelation();
            } else {
                hideotherRelation();
            }
        }
        if (cname != null) {
            edtotherrelationship.setText(cname);
        }
        if (otherEdu != null) {
            edtreferencename.setText(otherEdu);
        }
        if (caddress != null) {
            edtreferenceaddress.setText(caddress);
        }
        if (permanataddress != null) {
            edtreferencecontactno.setText(permanataddress);
        }
        if (officeaddress != null) {
            edtreferencerelationship.setText(officeaddress);
        }
        if (contact != null) {
            edtreferencename2.setText(contact);
        }
        if (addressYN != null) {
            edtreferenceaddress2.setText(addressYN);
        }
        if (altcontact != null) {
            edtreferencecontactno2.setText(altcontact);
        }
        if (residencial != null) {
            edtreferencerelationship2.setText(residencial);
        }
        if (education != null) {
            if (education.equalsIgnoreCase("Under Graduate")) {
                Rundergraduate.setChecked(true);
                hideother();
            } else if (education.equalsIgnoreCase("Graduate")) {
                Rgraduate.setChecked(true);
                hideother();
            } else if (education.equalsIgnoreCase("Post Graduate")) {
                Rpostgraduate.setChecked(true);
                hideother();
            } else if (education.equalsIgnoreCase("Professional")) {
                Rpro.setChecked(true);
                hideother();
            } else {
                Rother.setChecked(true);
                Showother();
            }
        }
        if (gender != null) {
            if (gender.equalsIgnoreCase(Constant.MALE)) {
                Rmale.setChecked(true);
            } else {
                Rfemale.setChecked(true);
            }
        }
        if (currentPIN != null) {
            currentpin.setText(currentPIN);
        }
        if (currentland != null) {
            leednumber = currentland;
            currentlandmark.setText(leednumber);
        } else {
            leednumber = currentland;
        }
        if (currentSarea != null) {
            currentland = leednumber;
            leednumber = currentSarea;
            currentarea.setText(leednumber);
        } else {
            leednumber = currentSarea;
        }
        if (currentSstreet != null) {
            currentSarea = leednumber;
            leednumber = currentSstreet;
            currentstreet.setText(leednumber);
        } else {
            leednumber = currentSstreet;
        }
        if (addressYN2 != null) {
            currentSstreet = leednumber;
            leednumber = addressYN2;
            if (leednumber.equalsIgnoreCase("Yes")) {
                addressYN2 = leednumber;
                Ryes.setChecked(true);
                FieldInvisible();
            } else {
                addressYN2 = leednumber;
                Rno.setChecked(true);
                fieldVisibility();
            }
        }
        if (!Rno.isChecked()) {
            birthdate = PIN;
            PIN = cname;
            cname = Sstreet;
        } else {
            if (peraddress != null) {
                PerAddress.setText(peraddress);
            }
            if (PIN != null) {
                pin.setText(PIN);
            }
            if (land != null) {
                cname = land;
                landmark.setText(cname);
            } else {
                cname = land;
            }
            if (Sarea != null) {
                land = cname;
                cname = Sarea;
                area.setText(cname);
            } else {
                cname = Sarea;
            }
            if (Sstreet != null) {
                Sarea = cname;
                cname = Sstreet;
                street.setText(cname);
            } else {
                cname = Sstreet;
            }
        }
        if (adharproof != null) {
            Sstreet = cname;
            chProofAdhar.setChecked(true);
        }
        if (voteridproof != null) {
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
        if (voterid != null) {
            chVoterID.setChecked(true);
        }
        if (driverlicence != null) {
            chDL.setChecked(true);
        }
        if (passport != null) {
            chPassport.setChecked(true);
        }
        if (otherEdu2 != null) {
            cname = otherEdu2;
            etother.setText(cname);
        } else {
            cname = otherEdu2;
        }
        if (email != null) {
            otherEdu2 = cname;
            cname = email;
            etcEmail.setText(cname);
        } else {
            cname = email;
        }
        if (adhar != null) {
            email = cname;
            chAdhar.setChecked(true);
        }
        if (pannumber != null) {
            chPAN.setChecked(true);
            txtpannumber.setText(pannumber);
        }
        if (Adharnumber != null) {
            chAdhar.setChecked(true);
            txtAdharNumber.setText(Adharnumber);
        }
        if (leednumber2 != null) {
            cname = leednumber2;
            txtleadid.setText(cname);
        } else {
            cname = leednumber2;
        }
        if (cname2 != null) {

            cname = cname2;
            etcname.setText(cname);
        } else {
            cname = cname2;
        }
        if (caddress2 != null) {
            etaddress.setText(caddress2);
        } else {
            cname = caddress2;
        }
        if (permanataddress2 != null) {
            cname = permanataddress2;

        } else {
            cname = permanataddress2;
        }
        if (officeaddress2 != null) {
            etoffaddress.setText(officeaddress2);
        } else {
            cname = officeaddress2;
        }
        if (contact2 != null) {
            etcontatct.setText(contact2);
        } else {
            cname = contact2;
        }
        if (altcontact2 != null) {
            etalternatecontact.setText(altcontact2);
        } else {
            cname = altcontact2;
        }
        String residencial3;
        if (residencial2 != null) {
            ArrayAdapter myAdap2 = (ArrayAdapter) Recidential.getAdapter();
            altcontact2 = cname;
            cname = residencial2;
            ArrayAdapter residencial4 = myAdap2;
            residencial3 = cname;
            Recidential.setSelection(myAdap2.getPosition(cname));
        } else {
            residencial3 = residencial2;
        }
        if (birthdate2 != null) {
            etbirthdate.setText(birthdate2);
        }

    }

    private void setLeedStatus(LeedsModel leedsModel) {
        leedsModel.setStatus(Constant.STATUS_VERIFIED);
        updateLeed(leedsModel.getLeedNumber(), leedsModel.getLeedStatusMap1());
    }

    private void updateLeadDetails(LeedsModel leedsModel) {
        try {
            leedsModel.setCustomerName(cNmae);
            leedsModel.setAddress(cAdress);
            leedsModel.setMobileNumber(cContatct);
            leedsModel.setAlternetMobileNumber(cAltcontatct);
            leedsModel.setDateOfBirth(cBdate);
            leedsModel.setOfficeAdderess(cOffaddress);
            leedsModel.setRecidential(cresidencial);
            //  leedsModel.setPeraddress(cPadress);
            leedsModel.setCurrentpin(cCurrentPIN);
            leedsModel.setCurrentarea(cCurrentarea);
            leedsModel.setCurrentlandmark(cCurrentlandmark);
            leedsModel.setCurrentstreet(cCurrentstreet);
            if (cYesNo.equalsIgnoreCase("No")) {
                leedsModel.setPeraddress(cPadress);
                leedsModel.setPincode(cPIN);
                leedsModel.setArea(carea);
                leedsModel.setLandmark(clandmark);
                leedsModel.setStreet(cstreet);
            } else if (cYesNo.equalsIgnoreCase("Yes")) {
                leedsModel.setPincode(cCurrentPIN);
                leedsModel.setArea(cCurrentarea);
                leedsModel.setLandmark(cCurrentlandmark);
                leedsModel.setStreet(cCurrentstreet);
            }
            leedsModel.setEmail(cEmail);
            leedsModel.setAdharNo(cAdhar);
            leedsModel.setCheckpanCardNumber(cPAN);
            leedsModel.setPanCardNumber(cPANnumber);
            leedsModel.setAdharNo(cAdharNumber);
            leedsModel.setOtherEducation(cOther);
            leedsModel.setApvoterid(cVoterid);
            leedsModel.setApdrivinglicence(cDL);
            leedsModel.setAppassport(cPassport);
            leedsModel.setProofadhar(cProofadhar);
            leedsModel.setProofvoterid(cProofvoterid);
            leedsModel.setProofdl(cProofDL);
            leedsModel.setProofelectricitybill(cProofelectricitybill);
            leedsModel.setProofrentagmt(cProofrentagmt);
            leedsModel.setProofpassport(cProofpassport);
            leedsModel.setProofgevtid(cProofgovtid);
            leedsModel.setProofgumasta(cProofgumasta);
            leedsModel.setProofcurrentacctstmt(cProofcurrentacctstmt);
            leedsModel.setPrapplicantrelation(sapplicantrelation);
            leedsModel.setCoapplicantotherrelation(sotherrelationship);
            leedsModel.setPrreference1name(sreference1name);
            leedsModel.setPrreference1address(sreference1address);
            leedsModel.setPrreferencecontactno(sreferencecontactno);
            leedsModel.setPrreferencerelationship(sreferencerelationship);
            leedsModel.setPrreference2name(sreference2name);
            leedsModel.setPrreference2address(sreference2address);
            leedsModel.setPrreference2contactno(sreference2contactno);
            leedsModel.setPrreference2relationship(sreference2relationship);
            leedsModel.setEducation(cEducation);
            leedsModel.setGender(cGender);
            leedsModel.setAddressYesNo(cYesNo);
            leedsModel.setCoApplicantYN(scoapplicantYN);
        } catch (Exception e) {
        }
        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap());
    }

    private void updateLeed(String leedId, Map leedsMap) {
        progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));

        leedRepository.updateLeed(leedId, leedsMap, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                try {
                    Toast.makeText(getContext(), "Lead Verify Successfully", Toast.LENGTH_SHORT).show();
                } catch (Exception e) {
                }
                progressDialogClass.dismissDialog();
            }

            @Override
            public void onError(Object object) {
                Context context = getContext();
                Utility.showLongMessage(context, context.getString(R.string.server_error));
            }
        });
    }

    public void onItemSelected(AdapterView<?> adapterView, View arg1, int position, long id) {
        if (CoapplicantRalationship.getSelectedItem().toString().equalsIgnoreCase("Please specify")) {
            showotherRelation();
        } else {
            hideotherRelation();
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void fieldVisibility() {
        RelativeLayout.LayoutParams params4 = (RelativeLayout.LayoutParams) layoutperaddress.getLayoutParams();
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutpin.getLayoutParams();
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) layoutlandmark.getLayoutParams();
        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) layoutarea.getLayoutParams();
        RelativeLayout.LayoutParams params3 = (RelativeLayout.LayoutParams) layoutstreet.getLayoutParams();
        params.height = -1;
        params1.height = -1;
        params2.height = -1;
        params3.height = -1;
        params4.height = -1;
        layoutperaddress.setLayoutParams(params4);
        layoutpin.setLayoutParams(params);
        layoutlandmark.setLayoutParams(params1);
        layoutarea.setLayoutParams(params2);
        layoutstreet.setLayoutParams(params3);
    }

    public void FieldInvisible() {
        RelativeLayout.LayoutParams params4 = (RelativeLayout.LayoutParams) layoutperaddress.getLayoutParams();
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutpin.getLayoutParams();
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) layoutlandmark.getLayoutParams();
        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) layoutarea.getLayoutParams();
        RelativeLayout.LayoutParams params3 = (RelativeLayout.LayoutParams) layoutstreet.getLayoutParams();
        params.height = 0;
        params1.height = 0;
        params2.height = 0;
        params3.height = 0;
        params4.height = 0;
        layoutperaddress.setLayoutParams(params4);
        layoutpin.setLayoutParams(params);
        layoutlandmark.setLayoutParams(params1);
        layoutarea.setLayoutParams(params2);
        layoutstreet.setLayoutParams(params3);
    }

    public void hideother() {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutothervalue.getLayoutParams();
        params.height = 0;
        layoutothervalue.setLayoutParams(params);
    }

    public void Showother() {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutothervalue.getLayoutParams();
        params.height = -1;
        layoutothervalue.setLayoutParams(params);
    }

    public void ShowApplicant() {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutrelationship.getLayoutParams();
        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) layoutsavebutton.getLayoutParams();
        params.height = -1;
        params2.height = -1;
        layoutrelationship.setLayoutParams(params);
        layoutsavebutton.setLayoutParams(params2);
    }

    public void showotherRelation() {
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) layoutotherrelationship.getLayoutParams();
        params1.height = -1;
        layoutotherrelationship.setLayoutParams(params1);
    }

    public void hideotherRelation() {
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) layoutotherrelationship.getLayoutParams();
        params1.height = 0;
        layoutotherrelationship.setLayoutParams(params1);
    }

    public void HideApplicant() {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutrelationship.getLayoutParams();
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) layoutotherrelationship.getLayoutParams();
        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) layoutsavebutton.getLayoutParams();
        params.height = 0;
        params1.height = 0;
        params2.height = 0;
        layoutrelationship.setLayoutParams(params);
        layoutotherrelationship.setLayoutParams(params1);
        layoutsavebutton.setLayoutParams(params2);
    }

    public void Hidereference() {
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) layoutref1name.getLayoutParams();
        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) layoutref1address.getLayoutParams();
        RelativeLayout.LayoutParams params3 = (RelativeLayout.LayoutParams) layoutref1contact.getLayoutParams();
        RelativeLayout.LayoutParams params4 = (RelativeLayout.LayoutParams) layoutref1relationship.getLayoutParams();
        RelativeLayout.LayoutParams params5 = (RelativeLayout.LayoutParams) layoutref2name.getLayoutParams();
        RelativeLayout.LayoutParams params6 = (RelativeLayout.LayoutParams) layoutref2address.getLayoutParams();
        RelativeLayout.LayoutParams params7 = (RelativeLayout.LayoutParams) layoutref2contact.getLayoutParams();
        RelativeLayout.LayoutParams params8 = (RelativeLayout.LayoutParams) layoutref2relationship.getLayoutParams();
        params1.height = 0;
        params2.height = 0;
        params3.height = 0;
        params4.height = 0;
        params5.height = 0;
        params6.height = 0;
        params7.height = 0;
        params8.height = 0;
        layoutref1name.setLayoutParams(params1);
        layoutref1address.setLayoutParams(params2);
        layoutref1contact.setLayoutParams(params3);
        layoutref1relationship.setLayoutParams(params4);
        layoutref2name.setLayoutParams(params5);
        layoutref2address.setLayoutParams(params6);
        layoutref2contact.setLayoutParams(params7);
        layoutref2relationship.setLayoutParams(params8);
    }

    public void Showreference() {
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) layoutref1name.getLayoutParams();
        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) layoutref1address.getLayoutParams();
        RelativeLayout.LayoutParams params3 = (RelativeLayout.LayoutParams) layoutref1contact.getLayoutParams();
        RelativeLayout.LayoutParams params4 = (RelativeLayout.LayoutParams) layoutref1relationship.getLayoutParams();
        RelativeLayout.LayoutParams params5 = (RelativeLayout.LayoutParams) layoutref2name.getLayoutParams();
        RelativeLayout.LayoutParams params6 = (RelativeLayout.LayoutParams) layoutref2address.getLayoutParams();
        RelativeLayout.LayoutParams params7 = (RelativeLayout.LayoutParams) layoutref2contact.getLayoutParams();
        RelativeLayout.LayoutParams params8 = (RelativeLayout.LayoutParams) layoutref2relationship.getLayoutParams();
        params1.height = -1;
        params2.height = -1;
        params3.height = -1;
        params4.height = -1;
        params5.height = -1;
        params6.height = -1;
        params7.height = -1;
        params8.height = -1;
        layoutref1name.setLayoutParams(params1);
        layoutref1address.setLayoutParams(params2);
        layoutref1contact.setLayoutParams(params3);
        layoutref1relationship.setLayoutParams(params4);
        layoutref2name.setLayoutParams(params5);
        layoutref2address.setLayoutParams(params6);
        layoutref2contact.setLayoutParams(params7);
        layoutref2relationship.setLayoutParams(params8);
    }

    private void setFromDateClickListner() {
        setFromCurrentDate();
        etbirthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog mDatePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        Calendar myCalendar = Calendar.getInstance();
                        myCalendar.set(Calendar.YEAR, selectedyear);
                        myCalendar.set(Calendar.MONTH, selectedmonth);
                        myCalendar.set(Calendar.DAY_OF_MONTH, selectedday);
                        SimpleDateFormat sdf = new SimpleDateFormat(CALANDER_DATE_FORMATE, Locale.FRANCE);
                        String formatedDate = sdf.format(myCalendar.getTime());
                        etbirthdate.setText(formatedDate);
                        fromDay = selectedday;
                        fromMonth = selectedmonth;
                        fromYear = selectedyear;
                        fromDate = Utility.convertFormatedDateToMilliSeconds(formatedDate, CALANDER_DATE_FORMATE);
                    }
                }, fromYear, fromMonth, fromDay);
                mDatePicker.show();
            }
        });
    }

    private void setFromCurrentDate() {
        Calendar mcurrentDate = Calendar.getInstance();
        fromYear = mcurrentDate.get(Calendar.YEAR);
        fromMonth = mcurrentDate.get(Calendar.MONTH);
        fromDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);
    }

    public void onBackPressed() {
        Toast.makeText(getContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();
    }

    public void onResume() {
        super.onResume();
        Log.d("lifecycle", "onResume invoked");
    }

    protected void onRestart() {
//        super.onRestart();
        edtreferencename.requestFocus();
    }
}
