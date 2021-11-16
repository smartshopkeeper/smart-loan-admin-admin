package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.app.ActionBar;
import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
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
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModelCo;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.util.ArrayList;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.COAPPLICANT_LEEDS_TABLE_REF;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.LEED_MODEL;

public class TL_Updatelead_Coapplicant_Detail_Activity extends AppCompatActivity {

    Button btupdate, btverify, btcancel, btnnext, btnsave;
    LeedsModel leedsModel;
  //  LeedsModelCo leedsModelCo;
    LeedsModel leedsModelCoapplicant;
    ProgressDialogClass progressDialogClass;
    AppSharedPreference appSharedPreference;
    LeedRepository leedRepository;

    ArrayList<LeedsModel> CoApplicantList;
    EditText etother, eparents, eresidencial, etpermanantaddress, etcname, etaddress, etoffaddress, etcontatct, etalternatecontact, etbirthdate,
            currentpin, currentlandmark, currentarea, currentstreet;
    String padress, cresidencial, cparents, cNmae, cAdress, cPadress, cOffaddress, cContatct, cAltcontatct, cBdate, cOther,
            cCurrentPIN, cCurrentlandmark, cCurrentarea, cCurrentstreet;
    TextView txtldate, txtleadid;
    RadioGroup groupRadio, groupRadioEducation, groupRadioGender;

    EditText pin, landmark, area, street;

    RelativeLayout layoutpin, layoutlandmark, layoutarea, layoutstreet, layoutothervalue, layoutsavebutton;
    EditText etcEmail,
            edtreferencename, edtreferenceaddress, edtreferencecontactno, edtreferencerelationship,
            edtreferencename2, edtreferenceaddress2, edtreferencecontactno2, edtreferencerelationship2;
    CheckBox chAdhar, chPAN, chVoterID, chDL, chPassport, chProofAdhar, chProofVoterid, chProofdl, chProofElectricitybill,
            chProofRntagmt, chProofPassport, chProofGovtEmpid, chProofGumasta, chProofCurrentacctStmt;
    String cYesNo, cPIN, clandmark, carea, cstreet, cEducation, cGender, cEmail, cAdhar, cPAN, cVoterid, cDL, cPassport,
            cProofadhar, cProofvoterid, cProofDL, cProofelectricitybill, cProofrentagmt, cProofpassport, cProofgovtid, cProofgumasta,
            cProofcurrentacctstmt,
            sreference1name, sreference1address, sreferencecontactno, sreferencerelationship,
            sreference2name, sreference2address, sreference2contactno, sreference2relationship;
    RadioButton REducation, Rgender, RYN, Ryes, Rno, Rug, Rg, Rpg, Rpro, Rother, Rmale, Rfemale;

    String LeedNumber;
    Spinner Recidential;
    String code;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tl__updatelead__coapplicant__detail_);

        String[] recidential = new String[]{"Owned", "Rented", "Allotted by Employer", "Family"};

        layoutpin = (RelativeLayout) findViewById(R.id.layoutpin);
        layoutlandmark = (RelativeLayout) findViewById(R.id.layoutland);
        layoutarea = (RelativeLayout) findViewById(R.id.layoutArea);
        layoutstreet = (RelativeLayout) findViewById(R.id.layoutstreet);
        layoutothervalue = (RelativeLayout) findViewById(R.id.layoutothervalue);
        layoutsavebutton = (RelativeLayout) findViewById(R.id.layoutbuttonsave);

        leedsModel = (LeedsModel) getIntent().getSerializableExtra(LEED_MODEL);
        Intent i = getIntent();
        code = i.getStringExtra("Code");

        LeedNumber = leedsModel.getLeedNumber();
        leedRepository = new LeedRepositoryImpl();

        btnsave = (Button) findViewById(R.id.buttonsave);

        currentpin = (EditText) findViewById(R.id.txtcurrentpin1);
        currentlandmark = (EditText) findViewById(R.id.txtcurrentlandmark1);
        currentarea = (EditText) findViewById(R.id.txtcurrentarea1);
        currentstreet = (EditText) findViewById(R.id.txtcurrentstreet1);

        etcname = (EditText) findViewById(R.id.txtcamevalue);
        etaddress = (EditText) findViewById(R.id.txtcurrentaddressvalue);
        etpermanantaddress = (EditText) findViewById(R.id.txtpermenantaddressvalue);
        groupRadio = (RadioGroup) findViewById(R.id.radioGYN);
        pin = (EditText) findViewById(R.id.txtpin1);
        landmark = (EditText) findViewById(R.id.txtlandmark1);
        area = (EditText) findViewById(R.id.txtarea1);
        street = (EditText) findViewById(R.id.txtstreet1);
        etoffaddress = (EditText) findViewById(R.id.txtofficeaddressvalue);
        etbirthdate = (EditText) findViewById(R.id.txtbirthdatevalue);
        groupRadioEducation = (RadioGroup) findViewById(R.id.radioeducation);
        groupRadioGender = (RadioGroup) findViewById(R.id.radioSex);
        etcontatct = (EditText) findViewById(R.id.txtcontatctvalue);
        etalternatecontact = (EditText) findViewById(R.id.edtaltcontact);
        etcEmail = (EditText) findViewById(R.id.txtemail1);
        Recidential = (Spinner) findViewById(R.id.spinnerrecidencialvalue);

        ArrayAdapter<String> spinnerArrayAdapterRecidential = new ArrayAdapter<String>(this, R.layout.sppinner_layout_listitem, recidential);
        spinnerArrayAdapterRecidential.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        Recidential.setAdapter(spinnerArrayAdapterRecidential);

//        edtreferencename = (EditText) findViewById(R.id.txtreferencefullname1);
//        edtreferenceaddress = (EditText) findViewById(R.id.txtreferenceaddress1);
//        edtreferencecontactno = (EditText) findViewById(R.id.txtreferencecontactno1);
//        edtreferencerelationship = (EditText) findViewById(R.id.txtreferencecrelationship1);
//        edtreferencename2 = (EditText) findViewById(R.id.txtreference2fullname1);
//        edtreferenceaddress2 = (EditText) findViewById(R.id.txtreference2address1);
//        edtreferencecontactno2 = (EditText) findViewById(R.id.txtreference2contactno1);
//        edtreferencerelationship2 = (EditText) findViewById(R.id.txtreferencec2relationship1);

        //eparents = (EditText) findViewById(R.id.txtparentsvalue);
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

        txtleadid = (TextView) findViewById(R.id.textheader);

        groupRadioEducation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                REducation = (RadioButton) findViewById(checkedId);
                if (REducation.getText().toString().equalsIgnoreCase("Other")) {
                    Showother();
                } else {
                    hideother();
                }
            }
        });

        groupRadioGender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Rgender = (RadioButton) findViewById(checkedId);
            }
        });

        groupRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RYN = (RadioButton) findViewById(checkedId);
                if (RYN.getText().toString().equalsIgnoreCase("No")) {
                    fieldVisibility();
                } else {
                    FieldInvisible();
                }
            }
        });


        Ryes = (RadioButton) findViewById(R.id.radioYes);
        Rno = (RadioButton) findViewById(R.id.radioNo);
        Rug = (RadioButton) findViewById(R.id.radioUG);
        Rg = (RadioButton) findViewById(R.id.radioGraguate);
        Rpg = (RadioButton) findViewById(R.id.radioPG);
        Rpro = (RadioButton) findViewById(R.id.radioprofessional);
        Rother = (RadioButton) findViewById(R.id.radioother);
        Rmale = (RadioButton) findViewById(R.id.radioMale);
        Rfemale = (RadioButton) findViewById(R.id.radioFemale);

        if(groupRadioGender.getCheckedRadioButtonId()!=-1){
            int id= groupRadioGender.getCheckedRadioButtonId();
            View radioButton = groupRadioGender.findViewById(id);
            int radioId = groupRadioGender.indexOfChild(radioButton);
            RadioButton btn = (RadioButton) groupRadioGender.getChildAt(radioId);
            cGender = btn.getText().toString();
        }
        if(groupRadio.getCheckedRadioButtonId()!=-1){
            int id= groupRadio.getCheckedRadioButtonId();
            View radioButton = groupRadio.findViewById(id);
            int radioId = groupRadio.indexOfChild(radioButton);
            RadioButton btn = (RadioButton) groupRadio.getChildAt(radioId);
            cYesNo = btn.getText().toString();

            if (cYesNo.equalsIgnoreCase("No")) {
                fieldVisibility();
            } else {
                FieldInvisible();
            }
        }
        if(groupRadioEducation.getCheckedRadioButtonId()!=-1){
            int id= groupRadioEducation.getCheckedRadioButtonId();
            View radioButton = groupRadioEducation.findViewById(id);
            int radioId = groupRadioEducation.indexOfChild(radioButton);
            RadioButton btn = (RadioButton) groupRadioEducation.getChildAt(radioId);
            cEducation = btn.getText().toString();

            if (cEducation.equalsIgnoreCase("Other")) {
                Showother();
            } else {
                hideother();
            }
        }

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cNmae = etcname.getText().toString();
                cAdress = etaddress.getText().toString();
                cCurrentPIN = currentpin.getText().toString();
                cCurrentlandmark = currentlandmark.getText().toString();
                cCurrentarea = currentarea.getText().toString();
                cCurrentstreet = currentstreet.getText().toString();
                cPadress = etpermanantaddress.getText().toString();
                cPIN = pin.getText().toString();
                clandmark = landmark.getText().toString();
                carea = area.getText().toString();
                cstreet = street.getText().toString();
                cOffaddress = etoffaddress.getText().toString();
                cBdate = etbirthdate.getText().toString();
                cContatct = etcontatct.getText().toString();
                cAltcontatct = etalternatecontact.getText().toString();
                cEmail = etcEmail.getText().toString();
                String emialpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (!cEmail.matches(emialpattern)) {
                    etcEmail.setError("Invalid Email");
                }

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

                if (TextUtils.isEmpty(cAdhar)) {
                    Toast.makeText(getApplicationContext(), "Provide Adhar Card!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cPAN)) {
                    Toast.makeText(getApplicationContext(), "Provide PAN Card!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(cNmae)) {
                    etcname.setError("Required");
                    Toast.makeText(getApplicationContext(), "Enter Customers full Name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cBdate)) {
                    etbirthdate.setError("Required");
                    Toast.makeText(getApplicationContext(), "Enter Birth Date!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cContatct)) {
                    etcontatct.setError("Required");
                    Toast.makeText(getApplicationContext(), "Enter Contact!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cAltcontatct)) {
                    etalternatecontact.setError("Required");
                    Toast.makeText(getApplicationContext(), "Enter Alternate Contact!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cEmail)) {
                    etcEmail.setError("Required");
                    Toast.makeText(getApplicationContext(), "Enter Email!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cOffaddress)) {
                    etoffaddress.setError("Required");
                    Toast.makeText(getApplicationContext(), "Enter Office address!", Toast.LENGTH_SHORT).show();
                    return;
                }


                generateLeed();
                Toast.makeText(TL_Updatelead_Coapplicant_Detail_Activity.this, "Create Co_Applicant Successfully", Toast.LENGTH_SHORT).show();

                Intent i = new Intent(TL_Updatelead_Coapplicant_Detail_Activity.this, TL_Updatelead_C_Details_Activity.class);
                i.putExtra(LEED_MODEL, leedsModel);
                i.putExtra("code", code);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

            }
        });

    }//End of OnCreate


//    private void getdata() {
//
//        try {
//
//
//            String leednumber = leedsModelCoapplicant.getLeedNumber();
//            String cname = leedsModelCoapplicant.getCustomerName();
//            String caddress = leedsModelCoapplicant.getAddress();
//            String officeaddress = leedsModelCoapplicant.getofficeAdderess();
//            String contact = leedsModelCoapplicant.getMobileNumber();
//            String altcontact = leedsModelCoapplicant.getaltmobile();
//            String birthdate = leedsModelCoapplicant.getDateOfBirth();
//            String parents = leedsModelCoapplicant.getParents();
//            String residencial = leedsModelCoapplicant.getRecidential();
//            String permanataddress = leedsModelCoapplicant.getPeraddress();
//            String addressYN = leedsModelCoapplicant.getAddressYesNo();
//            String otherEdu = leedsModelCoapplicant.getOtherEducation();
//
//            String PIN = leedsModelCoapplicant.getPincode();
//            String land = leedsModelCoapplicant.getLandmark();
//            String Sarea = leedsModelCoapplicant.getArea();
//            String Sstreet = leedsModelCoapplicant.getStreet();
//            String education = leedsModelCoapplicant.getEducation();
//            String gender = leedsModelCoapplicant.getGender();
//            String email = leedsModelCoapplicant.getEmail();
//            String adhar = leedsModelCoapplicant.getadharNo();
//            String pan = leedsModelCoapplicant.getPanCardNumber();
//            String voterid = leedsModelCoapplicant.getApvoterid();
//            String driverlicence = leedsModelCoapplicant.getApdrivinglicence();
//            String passport = leedsModelCoapplicant.getAppassport();
//
//            String adharproof = leedsModelCoapplicant.getProofadhar();
//            String voteridproof = leedsModelCoapplicant.getProofvoterid();
//            String dlproof = leedsModelCoapplicant.getProofdl();
//            String electricitybillproof = leedsModelCoapplicant.getProofelectricitybill();
//            String rentagmtproof = leedsModelCoapplicant.getProofrentagmt();
//            String passportproof = leedsModelCoapplicant.getProofpassport();
//            String gevtidproof = leedsModelCoapplicant.getProofgevtid();
//            String gumastaproof = leedsModelCoapplicant.getProofgumasta();
//            String currentacctprrof = leedsModelCoapplicant.getProofcurrentacctstmt();
//
//            String ref1name = leedsModelCoapplicant.getPrreference1name();
//            String ref1address = leedsModelCoapplicant.getPrreference1address();
//            String ref1contact = leedsModelCoapplicant.getPrreferencecontactno();
//            String ref1relation = leedsModelCoapplicant.getPrreferencerelationship();
//            String ref2name = leedsModelCoapplicant.getPrreference2name();
//            String ref2address = leedsModelCoapplicant.getPrreference2address();
//            String ref2contact = leedsModelCoapplicant.getPrreference2contactno();
//            String ref2relation = leedsModelCoapplicant.getPrreference2relationship();
//
//
//            if (ref1name != null) {
//                edtreferencename.setText(ref1name);
//
//            }
//            if (ref1address != null) {
//                edtreferenceaddress.setText(ref1address);
//
//            }
//            if (ref1contact != null) {
//                edtreferencecontactno.setText(ref1contact);
//
//            }
//            if (ref1relation != null) {
//                edtreferencerelationship.setText(ref1relation);
//
//            }
//            if (ref2name != null) {
//                edtreferencename2.setText(ref2name);
//
//            }
//            if (ref2address != null) {
//                edtreferenceaddress2.setText(ref2address);
//
//            }
//            if (ref2contact != null) {
//                edtreferencecontactno2.setText(ref2contact);
//
//            }
//            if (ref2relation != null) {
//                edtreferencerelationship2.setText(ref2relation);
//
//            }
//
//
//            if (education.equalsIgnoreCase("Under Graduate")) {
//                Rug.setChecked(true);
//                hideother();
//            } else if (education.equalsIgnoreCase("Graduate")) {
//                Rg.setChecked(true);
//                hideother();
//            } else if (education.equalsIgnoreCase("Post Graduate")) {
//                Rpg.setChecked(true);
//                hideother();
//            } else if (education.equalsIgnoreCase("Professional")) {
//                Rpro.setChecked(true);
//                hideother();
//            } else {
//                Rother.setChecked(true);
//                Showother();
//            }
//            if (gender.equalsIgnoreCase("Male")) {
//                Rmale.setChecked(true);
//            } else {
//                Rfemale.setChecked(true);
//            }
//
//            if (addressYN.equalsIgnoreCase("Yes")) {
//                Ryes.setChecked(true);
//                FieldInvisible();
//
//            } else {
//                Rno.setChecked(true);
//                fieldVisibility();
//
//            }
//
//            if (Rno.isChecked()) {
//
//
//            } else {
//                if (PIN != null) {
//                    pin.setText(PIN);
//
//                }
//                if (land != null) {
//                    landmark.setText(land);
//
//                }
//                if (Sarea != null) {
//                    area.setText(Sarea);
//
//                }
//                if (Sstreet != null) {
//                    street.setText(Sstreet);
//
//                }
//            }
//
//            if (adharproof != null) {
//                chProofAdhar.setChecked(true);
//
//            }
//            if (voteridproof != null) {
//                chProofVoterid.setChecked(true);
//
//            }
//            if (dlproof != null) {
//                chProofdl.setChecked(true);
//
//            }
//            if (electricitybillproof != null) {
//                chProofElectricitybill.setChecked(true);
//
//            }
//            if (rentagmtproof != null) {
//                chProofRntagmt.setChecked(true);
//
//            }
//            if (passportproof != null) {
//                chProofPassport.setChecked(true);
//
//            }
//            if (gevtidproof != null) {
//                chProofGovtEmpid.setChecked(true);
//
//            }
//            if (gumastaproof != null) {
//                chProofGumasta.setChecked(true);
//
//            }
//            if (currentacctprrof != null) {
//                chProofCurrentacctStmt.setChecked(true);
//
//            }
//
//
//            if (voterid != null) {
//                chVoterID.setChecked(true);
//
//            }
//            if (driverlicence != null) {
//                chDL.setChecked(true);
//
//            }
//            if (passport != null) {
//                chPassport.setChecked(true);
//
//            }
//            if (otherEdu != null) {
//                etother.setText(otherEdu);
//
//            }
//            if (email != null) {
//                etcEmail.setText(email);
//
//            }
//            if (adhar != null) {
//                chAdhar.setChecked(true);
//
//            }
//            if (pan != null) {
//                chPAN.setChecked(true);
//
//            }
//
//
//            if (leednumber != null) {
//                txtleadid.setText(leednumber);
//
//            }
//            if (cname != null) {
//                etcname.setText(cname);
//
//            }
//            if (caddress != null) {
//                etaddress.setText(caddress);
//
//            }
//            if (permanataddress != null) {
//                etpermanantaddress.setText(permanataddress);
//
//            }
//            if (officeaddress != null) {
//                etoffaddress.setText(officeaddress);
//            }
//
//            if (contact != null) {
//                etcontatct.setText(contact);
//
//            }
//            if (altcontact != null) {
//                etalternatecontact.setText(altcontact);
//            }
//            if (residencial != null) {
//
//                ArrayAdapter myAdap = (ArrayAdapter) Recidential.getAdapter();
//                int spinnerPosition = myAdap.getPosition(residencial);
//                Recidential.setSelection(spinnerPosition);
//            }
//            if (parents != null) {
//                eparents.setText(parents);
//
//            }
//            if (birthdate != null) {
//                etbirthdate.setText(birthdate);
//            }
//
//
//        } catch (Exception e) {
//        }
//
//    }


    private LeedsModelCo updateLeadDetails() {
        LeedsModelCo leedsModelCo = new LeedsModelCo();
        leedsModelCo.setLeedId(COAPPLICANT_LEEDS_TABLE_REF.push().getKey());
        try {
            leedsModelCo.setLeedNumber(LeedNumber);
        } catch (Exception e) {
        }
        leedsModelCo.setCustomerName(cNmae);
        leedsModelCo.setAddress(cAdress);
        leedsModelCo.setMobileNumber(cContatct);
        leedsModelCo.setAltmobile(cAltcontatct);
        leedsModelCo.setDateOfBirth(cBdate);
        leedsModelCo.setOfficeAdderess(cOffaddress);
        leedsModelCo.setRecidential(cresidencial);
        leedsModelCo.setPeraddress(cPadress);

        leedsModelCo.setCurrentpin(cCurrentPIN);
        leedsModelCo.setCurrentarea(cCurrentarea);
        leedsModelCo.setCurrentlandmark(cCurrentlandmark);
        leedsModelCo.setCurrentstreet(cCurrentstreet);

        if (cYesNo.equalsIgnoreCase("No")) {
            leedsModelCo.setPincode(cPIN);
            leedsModelCo.setArea(carea);
            leedsModelCo.setLandmark(clandmark);
            leedsModelCo.setStreet(cstreet);
        } else if (cYesNo.equalsIgnoreCase("Yes")) {
            leedsModelCo.setPincode(cCurrentPIN);
            leedsModelCo.setArea(cCurrentarea);
            leedsModelCo.setLandmark(cCurrentlandmark);
            leedsModelCo.setStreet(cCurrentstreet);
        }

        leedsModelCo.setEducation(cEducation);
        leedsModelCo.setGender(cGender);
        leedsModelCo.setEmail(cEmail);
        leedsModelCo.setAdharNo(cAdhar);
        leedsModelCo.setPanCardNumber(cPAN);
        leedsModelCo.setAddressYesNo(cYesNo);
        leedsModelCo.setOtherEducation(cOther);
        leedsModelCo.setApvoterid(cVoterid);
        leedsModelCo.setApdrivinglicence(cDL);
        leedsModelCo.setAppassport(cPassport);
        leedsModelCo.setProofadhar(cProofadhar);
        leedsModelCo.setProofvoterid(cProofvoterid);
        leedsModelCo.setProofdl(cProofDL);
        leedsModelCo.setProofelectricitybill(cProofelectricitybill);
        leedsModelCo.setProofrentagmt(cProofrentagmt);
        leedsModelCo.setProofpassport(cProofpassport);
        leedsModelCo.setProofgevtid(cProofgovtid);
        leedsModelCo.setProofgumasta(cProofgumasta);
        leedsModelCo.setProofcurrentacctstmt(cProofcurrentacctstmt);
//        leedsModelCo.setPrreference1name(sreference1name);
//        leedsModelCo.setPrreference1address(sreference1address);
//        leedsModelCo.setPrreferencecontactno(sreferencecontactno);
//        leedsModelCo.setPrreferencerelationship(sreferencerelationship);
//        leedsModelCo.setPrreference2name(sreference2name);
//        leedsModelCo.setPrreference2address(sreference2address);
//        leedsModelCo.setPrreference2contactno(sreference2contactno);
//        leedsModelCo.setPrreference2relationship(sreference2relationship);


        return leedsModelCo;
        // updateLeed(leedsModel.getLeedId());
    }

//    private void updateLeed(String leedId,LeedsModel leedsModel) {
//     //   progressDialogClass.showDialog(this.getString(R.string.loading), this.getString(R.string.PLEASE_WAIT));
//        leedRepository.updateCoApplicantLeed(LeedsModel leedsModel, new CallBack() {
//            @Override
//            public void onSuccess(Object object) {
//                Toast.makeText(TL_Updatelead_Coapplicant_Detail_Activity.this, "Lead Verify Successfully", Toast.LENGTH_SHORT).show();
//            //    progressDialogClass.dismissDialog();
//            }
//
//            @Override
//            public void onError(Object object) {
//               // progressDialogClass.dismissDialog();
//                Utility.showLongMessage(TL_Updatelead_Coapplicant_Detail_Activity.this, getString(R.string.server_error));
//            }
//        });
//    }

    private void generateLeed() {
        LeedsModelCo leedsModelCoAp = updateLeadDetails();
        //progressDialogClass.showDialog(this.getString(R.string.leed_In_loading), this.getString(R.string.PLEASE_WAIT));
        leedRepository.updateCoApplicantLeed(leedsModelCoAp, new CallBack() {
            @Override
            public void onSuccess(Object object) {

            }

            @Override
            public void onError(Object object) {
                if (progressDialogClass != null)
                    progressDialogClass.dismissDialog();
                //Utility.showLongMessage(getActivity(), getString(R.string.lead_generated_fails_message));
            }
        });


    }

//    private void getteLeed() {
//       // progressDialogClass.showDialog(this.getString(R.string.loading), this.getString(R.string.PLEASE_WAIT));
//        leedRepository.readLeedsByID(leedsModel.getLeedNumber(), new CallBack() {
//            @Override
//            public void onSuccess(Object object) {
//                if (object != null) {
//                    CoApplicantList = (ArrayList<LeedsModel>) object;
//                    // serAdapter(leedsModelArrayList);
//                }
//             //   progressDialogClass.dismissDialog();
//            }
//
//            @Override
//            public void onError(Object object) {
//              //  progressDialogClass.dismissDialog();
//                Utility.showLongMessage(getApplication(), getString(R.string.server_error));
//            }
//        });
    //  }

    public void fieldVisibility() {

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutpin.getLayoutParams();
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) layoutlandmark.getLayoutParams();
        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) layoutarea.getLayoutParams();
        RelativeLayout.LayoutParams params3 = (RelativeLayout.LayoutParams) layoutstreet.getLayoutParams();
        params.height = ActionBar.LayoutParams.FILL_PARENT;
        params1.height = ActionBar.LayoutParams.FILL_PARENT;
        params2.height = ActionBar.LayoutParams.FILL_PARENT;
        params3.height = ActionBar.LayoutParams.FILL_PARENT;
        layoutpin.setLayoutParams(params);
        layoutlandmark.setLayoutParams(params1);
        layoutarea.setLayoutParams(params2);
        layoutstreet.setLayoutParams(params3);

    }

    public void FieldInvisible() {

        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutpin.getLayoutParams();
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) layoutlandmark.getLayoutParams();
        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) layoutarea.getLayoutParams();
        RelativeLayout.LayoutParams params3 = (RelativeLayout.LayoutParams) layoutstreet.getLayoutParams();
        params.height = 0;
        params1.height = 0;
        params2.height = 0;
        params3.height = 0;
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
        params.height = ActionBar.LayoutParams.FILL_PARENT;
        ;
        layoutothervalue.setLayoutParams(params);
    }
}
