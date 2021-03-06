package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.app.ActionBar;
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
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
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
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.Home_Activity;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.MainActivity_Telecaller_new;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.MainActivity_telecaller;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.TL_Updatelead_property_Details_Activity;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.STATUS_VERIFIED;

public class TL_Updatelead_property_Details_Fragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener{

    Spinner spinloantype, spinemptype, spinincome;
    Button btupdate, btverify, btcancel, btnnext;
    LeedsModel leedsModel;
    ProgressDialogClass progressDialogClass;
    AppSharedPreference appSharedPreference;
    LeedRepository leedRepository;

    EditText etflatno, etprojectname, etpropertyaddress, etpropropertyage, etpropertyarea, etpincode, etcity, etstate;
    TextView txtldate, txtleadid;
    String sleed, sflat, sproject, spaddress, spage, sparea, spincode, scity, sstate;

    String sgender, sedu, spropertyaddress, spropertypin, spropertylandmark, spropertyarea, sprojectname, sapplicantfullname,
            sapplicantdob, sapplicantcontactno, sapplicantaltcontactno, sapplicantemail, sapplicantcurrentaddress, sapplicantperaddress,
            saplicantoffceaddress, sreference1name, sreference1address, sreferencecontactno, sreferencerelationship,
            sreference2name, sreference2address, sreference2contactno, sreference2relationship, sAPadhar, sAappsn, sAapvoterid, sAapdl,
            sAappassport, sadadhar, sadvoterid, saddl, sadelectricity, sadpassport, sadrentagmt, sadgovtid, sadgumasta, sadcurrentacctstmt,
            spropertytype, srecidenttype, sapplicantrelation,
            sloanreqirement, sdownpayment, saboutpropety, sYN, sdescription;

    RadioGroup groupAPGender, groupAPEducation,
            groupAboutproperty, groupAboutpropetyYN;
    RadioButton Rmale, Rfemale, RGraduation, RUGraduation, RPGraduation, Rprofessional, ROther, Rgend, Redu,
            Rpresanctioned, Rpurchasepropety, Ryes, Rno, Rproperty, Ryn;

    Spinner SPpropertytype, SPrecidenttype, coapplicantrelation;

    EditText edtpropertyaddress, edtpropertypin, edtpropertylandmark, edtpropertyarea, edtprojectname, edtapplicantfullname,
            edtapplicantdob, edtapplicantcontactno, edtapplicantaltno, edtapplicantemail, edtapplicantcurrentaddress, edtapplicantpermanentaddress,
            edtapplicantofficeaddress, edtreferencename, edtreferenceaddress, edtreferencecontactno, edtreferencerelationship,
            edtreferencename2, edtreferenceaddress2, edtreferencecontactno2, edtreferencerelationship2,
            edtloanrequirement, edtdownpayment, edtdescription;

    CheckBox CHadhar, CHpan, CHvoterid, CHdl, CHpassport, CHadAdhar, CHadVoterid, CHadDL, CHadElectricity, CHadPassport, CHadRentagreement,
            CHadGovtid, CHadGumasta, CHadCurrentacctstmt;

    RelativeLayout layoutYN, layoutpin, layoutlandmarl, layoutarea, layoutprojectname, layoutpropertytype, layoutloanrequirement, layoutdownpayment;


    @Override
    public void onClick(View view) {

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.tl_updatelead_property_details_activity, container, false);

        ((AppCompatActivity) getActivity()).setSupportActionBar((Toolbar) view.findViewById(R.id.toolbar));
//        leedsModel = (LeedsModel) getActivity().getIntent().getSerializableExtra(Constant.LEED_MODEL);
        Bundle args = this.getArguments();
        if (args != null) {
            leedsModel = (LeedsModel) args.getSerializable(Constant.LEED_MODEL);

        }
        progressDialogClass = new ProgressDialogClass(getActivity());
        leedRepository = new LeedRepositoryImpl();
        appSharedPreference = new AppSharedPreference(getContext());
        String[] APPropertytype = new String[]{"Perchase of flat", "Purchase of vila", "Purchase of plot", "Balance transfer",
                "Balance transfer +Top-Up", "Self Construction", "Renovation/Improvement", "Top-Up existing home loan", "loan for resale property",
                "Ready posession flat", "Under construction flat"};
        String[] APRecidenttype = new String[]{"Owned", "Rental", "Alloted byb employer", "Family"};
        String[] APApplicantRelation = new String[]{"Spouse", "Parent", "Children", "Power of attorny"};

        layoutYN = (RelativeLayout) view.findViewById(R.id.layoutpurchasepropertyYN);
        layoutpin = (RelativeLayout) view.findViewById(R.id.layoutpropertyaddresspin);
        layoutlandmarl = (RelativeLayout) view.findViewById(R.id.layoutpropertyaddresslandmark);
        layoutarea = (RelativeLayout) view.findViewById(R.id.layoutpropertyaddressarea);
        layoutprojectname = (RelativeLayout) view.findViewById(R.id.layoutpropertyaddressprojectname);
        layoutpropertytype = (RelativeLayout) view.findViewById(R.id.layoutpropertytype);
        layoutloanrequirement = (RelativeLayout) view.findViewById(R.id.layoutLoanrequirement);
        layoutdownpayment = (RelativeLayout) view.findViewById(R.id.layoutDownpayment);

        groupAboutproperty = (RadioGroup) view.findViewById(R.id.radioGroupaboutproperty);
        groupAboutpropetyYN = (RadioGroup) view.findViewById(R.id.radioGroupaboutpropertyYesNo);

        Rpresanctioned = (RadioButton) view.findViewById(R.id.radioPresanction);
        Rpurchasepropety = (RadioButton) view.findViewById(R.id.radiopurchasepropety);
        Ryes = (RadioButton) view.findViewById(R.id.radioYES);
        Rno = (RadioButton) view.findViewById(R.id.radioNO);

        groupAboutproperty.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Rproperty = (RadioButton) view.findViewById(checkedId);
                saboutpropety = Rproperty.getText().toString();
                if (Rproperty.getText().toString().equalsIgnoreCase("Purchase Propety identified")) {
                    ShowYN();
                } else if (Rproperty.getText().toString().equalsIgnoreCase("Pre-Sanction")) {
                    HideYN();
                    hideDetails();
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
                if (Ryn.getText().toString().equalsIgnoreCase("Yes")) {
                    ShowDetails();
                } else {
                    hideDetails();
                }
            }
        });


        if (groupAboutproperty.getCheckedRadioButtonId() != -1) {
            int id = groupAboutproperty.getCheckedRadioButtonId();
            View radioButton = groupAboutproperty.findViewById(id);
            int radioId = groupAboutproperty.indexOfChild(radioButton);
            RadioButton btn = (RadioButton) groupAboutproperty.getChildAt(radioId);
            saboutpropety = btn.getText().toString();

            if (saboutpropety.equalsIgnoreCase("Purchase Propety identified")) {
                ShowYN();
            } else if (saboutpropety.equalsIgnoreCase("Pre-Sanction")) {
                HideYN();
                hideDetails();
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

            if (sYN.equalsIgnoreCase("Yes")) {
                ShowDetails();
            } else {
                hideDetails();
            }
        }


//        groupAPGender = (RadioGroup) findViewById(R.id.radioapSex);
//        groupAPEducation = (RadioGroup) findViewById(R.id.radioeapplicantducation);
//        groupAPGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                Rgend = (RadioButton) findViewById(checkedId);
//            }
//        });
//        groupAPEducation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                Redu = (RadioButton) findViewById(checkedId);
//            }
//        });

//        Rmale = (RadioButton) findViewById(R.id.radioapMale);
//        Rfemale = (RadioButton) findViewById(R.id.radioapFemale);
//        RGraduation = (RadioButton) findViewById(R.id.radioapGraguate);
//        RUGraduation = (RadioButton) findViewById(R.id.radioapUG);
//        RPGraduation = (RadioButton) findViewById(R.id.radioapPG);
//        Rprofessional = (RadioButton) findViewById(R.id.radioapprofessional);
//        ROther = (RadioButton) findViewById(R.id.radioapother);

        SPpropertytype = (Spinner) view.findViewById(R.id.txtpropertytype1);
//        SPrecidenttype = (Spinner) findViewById(R.id.txtresidenttype1);
//        coapplicantrelation = (Spinner) findViewById(R.id.txtcoapplicant1);

        ArrayAdapter<String> spinnerArrayAdapterProppertyType = new ArrayAdapter<String>(getContext(), R.layout.sppinner_layout_listitem, APPropertytype);
        spinnerArrayAdapterProppertyType.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SPpropertytype.setAdapter(spinnerArrayAdapterProppertyType);

//        ArrayAdapter<String> spinnerArrayAdapterRecidenttype = new ArrayAdapter<String>(this, R.layout.sppinner_layout_listitem, APRecidenttype);
//        spinnerArrayAdapterRecidenttype.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//        SPrecidenttype.setAdapter(spinnerArrayAdapterRecidenttype);
//
//        ArrayAdapter<String> spinnerArrayAdapterRelationship = new ArrayAdapter<String>(this, R.layout.sppinner_layout_listitem, APApplicantRelation);
//        spinnerArrayAdapterRelationship.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
//        coapplicantrelation.setAdapter(spinnerArrayAdapterRelationship);

        edtloanrequirement = (EditText) view.findViewById(R.id.txtloanrequirement1);
        edtdownpayment = (EditText) view.findViewById(R.id.txtdownpayment1);
        edtdescription = (EditText) view.findViewById(R.id.txtdescription1);
        edtdescription.setText("Description"+"\n");

//        edtdescription.setOnKeyListener(this);
        try {
            edtdescription.addTextChangedListener(new TextWatcher() {
                @Override
                public void afterTextChanged(Editable e) {
                    // here you can change the text in the editor
                    try {
                        if (e.charAt(e.length() - 1) == '\n') {
                            // add the new char you need
                            e.append("???");
                        }
                    }catch (Exception ex){}
                }

                @Override
                public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) { /* not action */ }

                @Override
                public void onTextChanged(CharSequence val, int arg1, int arg2, int arg3) { /* not action */
                    if (arg2 > arg3) {
                        if (val.toString().length() == 1) {
                            val = "??? " + val;
                            edtdescription.setText(val);
                            edtdescription.setSelection(edtdescription.getText().length());
                        }
                        if (val.toString().endsWith("\n")) {
                            val = val.toString().replace("\n", "\n??? ");
                            val = val.toString().replace("???", "???");
                            edtdescription.setText(val);
                            edtdescription.setSelection(edtdescription.getText().length());
                        }
                    }}
            });
        }catch (Exception e){}

//        edtpropertyaddress = (EditText) findViewById(R.id.txtproprtyaddrss1);
        edtpropertypin = (EditText) view.findViewById(R.id.txtpropertyaddresspin1);
        edtpropertylandmark = (EditText) view.findViewById(R.id.txtpropertylandmark1);
        edtpropertyarea = (EditText) view.findViewById(R.id.txtpropertyarea1);
        edtprojectname = (EditText) view.findViewById(R.id.txtpropertyprojectname1);
//        edtapplicantfullname = (EditText) findViewById(R.id.txtapplicantname1);
//        edtapplicantdob = (EditText) findViewById(R.id.txtapplicantdob1);
//        edtapplicantcontactno = (EditText) findViewById(R.id.txtapplicantcontactno1);
//        edtapplicantaltno = (EditText) findViewById(R.id.txtapplicantaltcontactno1);
//        edtapplicantemail = (EditText) findViewById(R.id.txtapplicantemail1);
//        edtapplicantcurrentaddress = (EditText) findViewById(R.id.txtapplicantcurrentaddress1);
//        edtapplicantpermanentaddress = (EditText) findViewById(R.id.txtapplicantperaddress1);
//        edtapplicantofficeaddress = (EditText) findViewById(R.id.txtapplicantofficeaddress1);
//        edtreferencename = (EditText) findViewById(R.id.txtreferencefullname1);
//        edtreferenceaddress = (EditText) findViewById(R.id.txtreferenceaddress1);
//        edtreferencecontactno = (EditText) findViewById(R.id.txtreferencecontactno1);
//        edtreferencerelationship = (EditText) findViewById(R.id.txtreferencecrelationship1);
//        edtreferencename2 = (EditText) findViewById(R.id.txtreference2fullname1);
//        edtreferenceaddress2 = (EditText) findViewById(R.id.txtreference2address1);
//        edtreferencecontactno2 = (EditText) findViewById(R.id.txtreference2contactno1);
//        edtreferencerelationship2 = (EditText) findViewById(R.id.txtreferencec2relationship1);

//        CHadhar = (CheckBox) findViewById(R.id.checkboxadhar);
//        CHpan = (CheckBox) findViewById(R.id.checkboxpan);
//        CHvoterid = (CheckBox) findViewById(R.id.checkboxvoterid);
//        CHdl = (CheckBox) findViewById(R.id.checkboxDL);
//        CHpassport = (CheckBox) findViewById(R.id.checkboxkycpassport);
//        CHadAdhar = (CheckBox) findViewById(R.id.checkboxproofadhar);
//        CHadVoterid = (CheckBox) findViewById(R.id.checkboxproofvoterid);
//        CHadDL = (CheckBox) findViewById(R.id.checkboxproofdl);
//        CHadElectricity = (CheckBox) findViewById(R.id.checkboxprrofelectricitybill);
//        CHadPassport = (CheckBox) findViewById(R.id.checkboxproofpassport);
//        CHadRentagreement = (CheckBox) findViewById(R.id.checkboxproofrentagreement);
//        CHadGovtid = (CheckBox) findViewById(R.id.checkboxproofgvtempid);
//        CHadGumasta = (CheckBox) findViewById(R.id.checkboxproofgumasta);
//        CHadCurrentacctstmt = (CheckBox) findViewById(R.id.checkboxproofcurrentacctstmt);

        btnnext = (Button) view.findViewById(R.id.buttonupdatenext);
        btnnext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {


            }
        });


        btverify = (Button) view.findViewById(R.id.buttonveryfy);
        txtleadid = (TextView) view.findViewById(R.id.textheader);
//        etpropertyaddress = (EditText) findViewById(R.id.txtproprtyaddrssvalue);


        getdata();

        btnnext.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
//                sgender = Rgend.getText().toString();
//                sedu = Redu.getText().toString();
                spropertytype = SPpropertytype.getSelectedItem().toString();

                sloanreqirement = edtloanrequirement.getText().toString();
                sdownpayment = edtdownpayment.getText().toString();
//                srecidenttype = SPrecidenttype.getSelectedItem().toString();
//                sapplicantrelation = coapplicantrelation.getSelectedItem().toString();
//                spropertyaddress = edtpropertyaddress.getText().toString();
                spropertypin = edtpropertypin.getText().toString();
                spropertylandmark = edtpropertylandmark.getText().toString();
                spropertyarea = edtpropertyarea.getText().toString();
                sprojectname = edtprojectname.getText().toString();
                sdescription = edtdescription.getText().toString();

//                sapplicantfullname = edtapplicantfullname.getText().toString();
//                sapplicantdob = edtapplicantdob.getText().toString();
//                sapplicantcontactno = edtapplicantcontactno.getText().toString();
//                sapplicantaltcontactno = edtapplicantaltno.getText().toString();
//                sapplicantemail = edtapplicantemail.getText().toString();
//                sapplicantcurrentaddress = edtapplicantcurrentaddress.getText().toString();
//                sapplicantperaddress = edtapplicantpermanentaddress.getText().toString();
//                saplicantoffceaddress = edtapplicantofficeaddress.getText().toString();
//                sreference1name = edtreferencename.getText().toString();
//                sreference1address = edtreferenceaddress.getText().toString();
//                sreferencecontactno = edtreferencecontactno.getText().toString();
//                sreferencerelationship = edtreferencerelationship.getText().toString();
//                sreference2name = edtreferencename2.getText().toString();
//                sreference2address = edtreferenceaddress2.getText().toString();
//                sreference2contactno = edtreferencecontactno2.getText().toString();
//                sreference2relationship = edtreferencerelationship2.getText().toString();

//               if (CHadhar.isChecked()) {
//                   sAPadhar = CHadhar.getText().toString();
//               }
//                if (CHpan.isChecked()) {
//                    sAappsn = CHpan.getText().toString();
//                }
//                if (CHvoterid.isChecked()) {
//                    sAapvoterid = CHvoterid.getText().toString();
//                }
//                if (CHdl.isChecked()) {
//                    sAapdl = CHdl.getText().toString();
//                }
//                if (CHpassport.isChecked()) {
//                    sAappassport = CHpassport.getText().toString();
//                }
//                if (CHadAdhar.isChecked()) {
//                    sadadhar = CHadAdhar.getText().toString();
//                }
//
//                if (CHadVoterid.isChecked()) {
//                    sadvoterid = CHadVoterid.getText().toString();
//
//                }
//                if (CHadDL.isChecked()) {
//                    saddl = CHadDL.getText().toString();
//                }
//                if (CHadElectricity.isChecked()) {
//                    sadelectricity = CHadElectricity.getText().toString();
//                }
//                if (CHadPassport.isChecked()) {
//                    sadpassport = CHadPassport.getText().toString();
//                }
//                if (CHadRentagreement.isChecked()) {
//                    sadrentagmt = CHadRentagreement.getText().toString();
//                }
//                if (CHadGovtid.isChecked()) {
//                    sadgovtid = CHadGovtid.getText().toString();
//                }
//                if (CHadGumasta.isChecked()) {
//                    sadgumasta = CHadGumasta.getText().toString();
//                }
//                if (CHadCurrentacctstmt.isChecked()) {
//                    sadcurrentacctstmt = CHadCurrentacctstmt.getText().toString();
//                }
                if (saboutpropety.equalsIgnoreCase("Purchase Propety identified")) {
                    if (sYN.equalsIgnoreCase("Yes")) {
                        if (sloanreqirement.isEmpty()) {
                            edtloanrequirement.setError("Loan Required");
                            Toast.makeText(getContext(), "Provide Loan Requirement!", Toast.LENGTH_SHORT).show();
                            edtloanrequirement.requestFocus();
                            return;
                        }
                    }
                }

                updateLeadDetails(leedsModel);
                Toast.makeText(getContext(), "Lead Update Successfully", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getContext(), MainActivity_Telecaller_new.class);
                startActivity(intent);
            }
        });

        btverify.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setLeedStatus(leedsModel);
            }
        });

        return view;
    }

    private void getdata() {

        try {


            String leedid = leedsModel.getLeedNumber();
//            String gender = leedsModel.getPrgender();
//            String edu = leedsModel.getPredu();
//            String propertyaddress = leedsModel.getPrpropertyaddress();
            String property = leedsModel.getPropety();
            String YN = leedsModel.getPropetyYN();
            String loanrequirement = leedsModel.getExpectedLoanAmount();
            String downpayment = leedsModel.getDownpayment();

            String propertypin = leedsModel.getPrpropertypin();
            String propertylandmark = leedsModel.getPrpropertylandmark();
            String propertyarea = leedsModel.getPrpropertyarea();
            String projectname = leedsModel.getPrprojectname();
            String description = leedsModel.getPrdescripiton();
//            String applicantname = leedsModel.getPrapplicantfullname();
//            String dob = leedsModel.getPrapplicantdob();
//            String contact = leedsModel.getPrapplicantcontactno();
//            String altcontact = leedsModel.getPrapplicantaltcontactno();
//            String emial = leedsModel.getPrapplicantemail();
//            String curaddress = leedsModel.getPrapplicantcurrentaddress();
//            String peraddress = leedsModel.getPrapplicantperaddress();
//            String officeaddress = leedsModel.getPraplicantoffceaddress();
//            String ref1name = leedsModel.getPrreference1name();
//            String ref1address = leedsModel.getPrreference1address();
//            String ref1contact = leedsModel.getPrreferencecontactno();
//            String ref1relation = leedsModel.getPrreferencerelationship();
//            String ref2name = leedsModel.getPrreference2name();
//            String ref2address = leedsModel.getPrreference2address();
//            String ref2contact = leedsModel.getPrreference2contactno();
//            String ref2relation = leedsModel.getPrreference2relationship();
//            String kycadhar = leedsModel.getPrAPadhar();
//            String kycpan= leedsModel.getPrAapan();
//            String kycvoterid = leedsModel.getPrAapvoterid();
//            String kycdl = leedsModel.getPrAapdl();
//            String kycpassport = leedsModel.getPrAappassport();
//            String proofadhar = leedsModel.getPradadhar();
//            String proofvoterid = leedsModel.getPradvoterid();
//            String proofdl = leedsModel.getPraddl();
//            String proofelectricity = leedsModel.getPradelectricity();
//            String proofpassport = leedsModel.getPradpassport();
//            String proofrentagmt = leedsModel.getPradrentagmt();
//            String proofgovtid = leedsModel.getPradgovtid();
//            String proofgumasta = leedsModel.getPradgumasta();
//            String proofcurrentacctstmt = leedsModel.getPradcurrentacctstmt();
            String propertytype = leedsModel.getPrpropertytype();
//            String residenttype = leedsModel.getPrrecidenttype();
//            String relatioship = leedsModel.getPrapplicantrelation();


            if (leedid != null) {
                txtleadid.setText(leedid);

            }
            ArrayAdapter myAdap = (ArrayAdapter) SPpropertytype.getAdapter();
            int spinnerPosition = myAdap.getPosition(propertytype);
            SPpropertytype.setSelection(spinnerPosition);

            if (property != null) {
                if (property.equalsIgnoreCase("Pre-Sanction")) {
                    Rpresanctioned.setChecked(true);
                    Ryes.setChecked(false);
                    Rno.setChecked(true);
                    HideYN();
                    hideDetails();

                } else if (property.equalsIgnoreCase("Purchase Propety identified")) {
                    Rpurchasepropety.setChecked(true);
                    ShowYN();
                }
            }

            if (YN != null) {
                if (YN.equalsIgnoreCase("No")) {
                    Rno.setChecked(true);
                    hideDetails();

                } else if (YN.equalsIgnoreCase("Yes")) {
                    Ryes.setChecked(true);
                    ShowDetails();
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

            }else{
                edtdescription.setText("??? ");
            }

        } catch (Exception e) {
        }

    }

    private void setLeedStatus(LeedsModel leedsModel) {
        leedsModel.setStatus(STATUS_VERIFIED);
        Toast.makeText(getContext(), "Lead Verify Successfully", Toast.LENGTH_SHORT).show();
        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap1());

        Intent i = new Intent(getActivity(), MainActivity_Telecaller_new.class);
        startActivity(i);
        getActivity().overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

    }


    private void updateLeadDetails(LeedsModel leedsModel) {

//        leedsModel.setPrgender(sgender);
//        leedsModel.setPredu(sedu);
//        leedsModel.setPrpropertyaddress(spropertyaddress);
        try {
            leedsModel.setPropety(saboutpropety);
            leedsModel.setPropetyYN(sYN);
        } catch (Exception e) {

        }
        leedsModel.setExpectedLoanAmount(sloanreqirement);
        leedsModel.setDownpayment(sdownpayment);

        leedsModel.setPrpropertypin(spropertypin);
        leedsModel.setPrpropertylandmark(spropertylandmark);
        leedsModel.setPrpropertyarea(spropertyarea);
        leedsModel.setPrprojectname(sprojectname);
        leedsModel.setPrdescripiton(sdescription);
//        leedsModel.setPrapplicantfullname(sapplicantfullname);
//        leedsModel.setPrapplicantdob(sapplicantdob);
//        leedsModel.setPrapplicantcontactno(sapplicantcontactno);
//        leedsModel.setPrapplicantaltcontactno(sapplicantaltcontactno);
//        leedsModel.setPrapplicantemail(sapplicantemail);
//        leedsModel.setPrapplicantcurrentaddress(sapplicantcurrentaddress);
//        leedsModel.setPrapplicantperaddress(sapplicantperaddress);
//        leedsModel.setPraplicantoffceaddress(saplicantoffceaddress);
//        leedsModel.setPrreference1name(sreference1name);
//        leedsModel.setPrreference1address(sreference1address);
//        leedsModel.setPrreferencecontactno(sreferencecontactno);
//        leedsModel.setPrreferencerelationship(sreferencerelationship);
//        leedsModel.setPrreference2name(sreference2name);
//        leedsModel.setPrreference2address(sreference2address);
//        leedsModel.setPrreference2contactno(sreference2contactno);
//        leedsModel.setPrreference2relationship(sreference2relationship);
//        leedsModel.setPrAPadhar(sAPadhar);
//        leedsModel.setPrAapan(sAappsn);
//        leedsModel.setPrAapvoterid(sAapvoterid);
//        leedsModel.setPrAapdl(sAapdl);
//        leedsModel.setPrAappassport(sAappassport);
//        leedsModel.setPradadhar(sadadhar);
//        leedsModel.setPradvoterid(sadvoterid);
//        leedsModel.setPraddl(saddl);
//        leedsModel.setPradelectricity(sadelectricity);
//        leedsModel.setPradpassport(sadpassport);
//        leedsModel.setPradrentagmt(sadrentagmt);
//        leedsModel.setPradgovtid(sadgovtid);
//        leedsModel.setPradgumasta(sadgumasta);
//        leedsModel.setPradcurrentacctstmt(sadcurrentacctstmt);
        leedsModel.setPrpropertytype(spropertytype);
//        leedsModel.setPrrecidenttype(srecidenttype);
//        leedsModel.setPrapplicantrelation(sapplicantrelation);

        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap());

    }

    private void updateLeed(String leedId, Map leedsMap) {
        progressDialogClass.showDialog(this.getString(R.string.loading), this.getString(R.string.PLEASE_WAIT));
        leedRepository.updateLeed(leedId, leedsMap, new CallBack() {
            @Override
            public void onSuccess(Object object) {

                progressDialogClass.dismissDialog();
            }

            @Override
            public void onError(Object object) {
                progressDialogClass.dismissDialog();
                Utility.showLongMessage(getActivity(), getString(R.string.server_error));
            }
        });
    }

    public void onBackPressed() {
        // super.onBackPressed(); commented this line in order to disable back press
        //Write your code here
        Toast.makeText(getContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();
    }

    public void HideYN() {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutYN.getLayoutParams();
        params.height = 0;
        layoutYN.setLayoutParams(params);
    }

    public void ShowYN() {
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutYN.getLayoutParams();
        params.height = ActionBar.LayoutParams.FILL_PARENT;
        layoutYN.setLayoutParams(params);

    }

    public void hideDetails() {

        RelativeLayout.LayoutParams paramspin = (RelativeLayout.LayoutParams) layoutpin.getLayoutParams();
        RelativeLayout.LayoutParams paramsland = (RelativeLayout.LayoutParams) layoutlandmarl.getLayoutParams();
        RelativeLayout.LayoutParams paramsarea = (RelativeLayout.LayoutParams) layoutarea.getLayoutParams();
        RelativeLayout.LayoutParams paramsproject = (RelativeLayout.LayoutParams) layoutprojectname.getLayoutParams();
        RelativeLayout.LayoutParams paramsproperty = (RelativeLayout.LayoutParams) layoutpropertytype.getLayoutParams();
        //  RelativeLayout.LayoutParams paramsloanrequirement = (RelativeLayout.LayoutParams) layoutloanrequirement.getLayoutParams();
        RelativeLayout.LayoutParams paramsdownpayment = (RelativeLayout.LayoutParams) layoutdownpayment.getLayoutParams();

        paramspin.height = 0;
        paramsland.height = 0;
        paramsarea.height = 0;
        paramsproject.height = 0;
        paramsproperty.height = 0;
        //    paramsloanrequirement.height = 0;
        paramsdownpayment.height = 0;

        layoutpin.setLayoutParams(paramspin);
        layoutlandmarl.setLayoutParams(paramsland);
        layoutarea.setLayoutParams(paramsarea);
        layoutprojectname.setLayoutParams(paramsproject);
        layoutpropertytype.setLayoutParams(paramsproperty);
        //   layoutloanrequirement.setLayoutParams(paramsloanrequirement);
        layoutdownpayment.setLayoutParams(paramsdownpayment);

    }

    public void ShowDetails() {

        RelativeLayout.LayoutParams paramspin = (RelativeLayout.LayoutParams) layoutpin.getLayoutParams();
        RelativeLayout.LayoutParams paramsland = (RelativeLayout.LayoutParams) layoutlandmarl.getLayoutParams();
        RelativeLayout.LayoutParams paramsarea = (RelativeLayout.LayoutParams) layoutarea.getLayoutParams();
        RelativeLayout.LayoutParams paramsproject = (RelativeLayout.LayoutParams) layoutprojectname.getLayoutParams();
        RelativeLayout.LayoutParams paramsproperty = (RelativeLayout.LayoutParams) layoutpropertytype.getLayoutParams();
        // RelativeLayout.LayoutParams paramsloanrequirement = (RelativeLayout.LayoutParams) layoutloanrequirement.getLayoutParams();
        RelativeLayout.LayoutParams paramsdownpayment = (RelativeLayout.LayoutParams) layoutdownpayment.getLayoutParams();

        paramspin.height = ActionBar.LayoutParams.FILL_PARENT;
        paramsland.height = ActionBar.LayoutParams.FILL_PARENT;
        paramsarea.height = ActionBar.LayoutParams.FILL_PARENT;
        paramsproject.height = ActionBar.LayoutParams.FILL_PARENT;
        paramsproperty.height = ActionBar.LayoutParams.FILL_PARENT;
        //  paramsloanrequirement.height = ActionBar.LayoutParams.FILL_PARENT;
        paramsdownpayment.height = ActionBar.LayoutParams.FILL_PARENT;

        layoutpin.setLayoutParams(paramspin);
        layoutlandmarl.setLayoutParams(paramsland);
        layoutarea.setLayoutParams(paramsarea);
        layoutprojectname.setLayoutParams(paramsproject);
        layoutpropertytype.setLayoutParams(paramsproperty);
        //   layoutloanrequirement.setLayoutParams(paramsloanrequirement);
        layoutdownpayment.setLayoutParams(paramsdownpayment);
    }

//    @Override
//    public boolean onKey(View v, int keyCode, KeyEvent event) {
//
//        // TODO Auto-generated method stub
//
//        // Listen to "Enter" key press
//        if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//
//            return true;
//        }
//        return false;
//    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
