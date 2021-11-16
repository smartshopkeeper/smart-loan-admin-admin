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
import android.text.TextUtils;
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
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModelCo;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.MainActivity_telecaller;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.TL_Updatelead_C_Details_Activity;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.TL_Updatelead_Coapplicant_Detail_Activity;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Map;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.COAPPLICANT_LEEDS_TABLE_REF;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.LEED_MODEL;

public class TL_Updatelead_Coapplicant_Detail_Fragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {


    Button  btnsave;
    LeedsModel leedsModel;
    LeedsModel leedsModelCoapplicant;
    ProgressDialogClass progressDialogClass;
    AppSharedPreference appSharedPreference;
    LeedRepository leedRepository;

    ArrayList<LeedsModel> CoApplicantList;
    EditText etother, eparents, eresidencial,  etcname, etaddress, etoffaddress, etcontatct, etalternatecontact, etbirthdate,
            currentpin, currentlandmark, currentarea, currentstreet;
    String padress, cresidencial, cparents, cNmae, cAdress,  cOffaddress, cContatct, cAltcontatct, cBdate, cOther,
            cCurrentPIN, cCurrentlandmark, cCurrentarea, cCurrentstreet;
    TextView txtldate, txtleadid;
    RadioGroup groupRadio, groupRadioEducation, groupRadioGender;

    EditText PerAddress,pin, landmark, area, street;

    RelativeLayout layoutperaddress,layoutpin, layoutlandmark, layoutarea, layoutstreet, layoutothervalue, layoutsavebutton;
    EditText etcEmail,
            edtreferencename, edtreferenceaddress, edtreferencecontactno, edtreferencerelationship,
            edtreferencename2, edtreferenceaddress2, edtreferencecontactno2, edtreferencerelationship2;
    CheckBox chAdhar, chPAN, chVoterID, chDL, chPassport, chProofAdhar, chProofVoterid, chProofdl, chProofElectricitybill,
            chProofRntagmt, chProofPassport, chProofGovtEmpid, chProofGumasta, chProofCurrentacctStmt;
    String cYesNo,cPerAddress, cPIN, clandmark, carea, cstreet, cEducation, cGender, cEmail, cAdhar, cPAN, cVoterid, cDL, cPassport,
            cProofadhar, cProofvoterid, cProofDL, cProofelectricitybill, cProofrentagmt, cProofpassport, cProofgovtid, cProofgumasta,
            cProofcurrentacctstmt,
            sreference1name, sreference1address, sreferencecontactno, sreferencerelationship,
            sreference2name, sreference2address, sreference2contactno, sreference2relationship;
    RadioButton REducation, Rgender, RYN, Ryes, Rno, Rug, Rg, Rpg, Rpro, Rother, Rmale, Rfemale;

    String LeedNumber;
    Spinner Recidential;
    String code = "100";


    @Override
    public void onClick(View view) {

    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.activity_tl__updatelead__coapplicant__detail_, container, false);

        ((AppCompatActivity)getActivity()).setSupportActionBar((Toolbar) view.findViewById(R.id.toolbar));
//        leedsModel = (LeedsModel) getActivity().getIntent().getSerializableExtra(Constant.LEED_MODEL);
        Bundle args = this.getArguments();
        if (args != null) {
            leedsModel = (LeedsModel) args.getSerializable(Constant.LEED_MODEL);
//            code = args.getString("Code");
        }
        String[] recidential = new String[]{"Owned", "Rented", "Allotted by Employer", "Family"};

        layoutperaddress = (RelativeLayout) view.findViewById(R.id.layoutperaddress);
        layoutpin = (RelativeLayout) view.findViewById(R.id.layoutpin);
        layoutlandmark = (RelativeLayout) view.findViewById(R.id.layoutland);
        layoutarea = (RelativeLayout) view.findViewById(R.id.layoutArea);
        layoutstreet = (RelativeLayout) view.findViewById(R.id.layoutstreet);
        layoutothervalue = (RelativeLayout) view.findViewById(R.id.layoutothervalue);
        layoutsavebutton = (RelativeLayout) view.findViewById(R.id.layoutbuttonsave);

        LeedNumber = leedsModel.getLeedNumber();
        leedRepository = new LeedRepositoryImpl();

        btnsave = (Button) view.findViewById(R.id.buttonsave);

        currentpin = (EditText) view.findViewById(R.id.txtcurrentpin1);
        currentlandmark = (EditText) view.findViewById(R.id.txtcurrentlandmark1);
        currentarea = (EditText) view.findViewById(R.id.txtcurrentarea1);
        currentstreet = (EditText) view.findViewById(R.id.txtcurrentstreet1);

        etcname = (EditText) view.findViewById(R.id.txtcamevalue);
        etaddress = (EditText) view.findViewById(R.id.txtcurrentaddressvalue);
//        etpermanantaddress = (EditText) view.findViewById(R.id.txtpermenantaddressvalue);
        groupRadio = (RadioGroup) view.findViewById(R.id.radioGYN);
        PerAddress = (EditText) view.findViewById(R.id.txtperaddress1);
        pin = (EditText) view.findViewById(R.id.txtpin1);
        landmark = (EditText) view.findViewById(R.id.txtlandmark1);
        area = (EditText) view.findViewById(R.id.txtarea1);
        street = (EditText) view.findViewById(R.id.txtstreet1);
        etoffaddress = (EditText) view.findViewById(R.id.txtofficeaddressvalue);
        etbirthdate = (EditText) view.findViewById(R.id.txtbirthdatevalue);
        groupRadioEducation = (RadioGroup) view.findViewById(R.id.radioeducation);
        groupRadioGender = (RadioGroup) view.findViewById(R.id.radioSex);
        etcontatct = (EditText) view.findViewById(R.id.txtcontatctvalue);
        etalternatecontact = (EditText) view.findViewById(R.id.edtaltcontact);
        etcEmail = (EditText) view.findViewById(R.id.txtemail1);
        Recidential = (Spinner) view.findViewById(R.id.spinnerrecidencialvalue);

        ArrayAdapter<String> spinnerArrayAdapterRecidential = new ArrayAdapter<String>(getContext(), R.layout.sppinner_layout_listitem, recidential);
        spinnerArrayAdapterRecidential.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        Recidential.setAdapter(spinnerArrayAdapterRecidential);

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

        txtleadid = (TextView) view.findViewById(R.id.textheader);

        groupRadioEducation.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                REducation = (RadioButton) view.findViewById(checkedId);
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
                Rgender = (RadioButton) view.findViewById(checkedId);
            }
        });

        groupRadio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RYN = (RadioButton) view.findViewById(checkedId);
                cYesNo = RYN.getText().toString();
                if (RYN.getText().toString().equalsIgnoreCase("No")) {
                    fieldVisibility();
                } else {
                    FieldInvisible();
                }
            }
        });


        Ryes = (RadioButton) view.findViewById(R.id.radioYes);
        Rno = (RadioButton) view.findViewById(R.id.radioNo);
        Rug = (RadioButton) view.findViewById(R.id.radioUG);
        Rg = (RadioButton) view.findViewById(R.id.radioGraguate);
        Rpg = (RadioButton) view.findViewById(R.id.radioPG);
        Rpro = (RadioButton) view.findViewById(R.id.radioprofessional);
        Rother = (RadioButton) view.findViewById(R.id.radioother);
        Rmale = (RadioButton) view.findViewById(R.id.radioMale);
        Rfemale = (RadioButton) view.findViewById(R.id.radioFemale);

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
//                cPadress = etpermanantaddress.getText().toString();
                cPIN = pin.getText().toString();
                cPerAddress = PerAddress.getText().toString();
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
                    Toast.makeText(getContext(), "Provide Adhar Card!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cPAN)) {
                    Toast.makeText(getContext(), "Provide PAN Card!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(cNmae)) {
                    etcname.setError("Required");
                    Toast.makeText(getContext(), "Enter Customers full Name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cBdate)) {
                    etbirthdate.setError("Required");
                    Toast.makeText(getContext(), "Enter Birth Date!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cContatct)) {
                    etcontatct.setError("Required");
                    Toast.makeText(getContext(), "Enter Contact!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cAltcontatct)) {
                    etalternatecontact.setError("Required");
                    Toast.makeText(getContext(), "Enter Alternate Contact!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cEmail)) {
                    etcEmail.setError("Required");
                    Toast.makeText(getContext(), "Enter Email!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(cOffaddress)) {
                    etoffaddress.setError("Required");
                    Toast.makeText(getContext(), "Enter Office address!", Toast.LENGTH_SHORT).show();
                    return;
                }


                generateLeed();
                Toast.makeText(getContext(), "Create Co_Applicant Successfully", Toast.LENGTH_SHORT).show();

//                Intent i = new Intent(getContext(), TL_Updatelead_C_Details_Activity.class);
//                i.putExtra(LEED_MODEL, leedsModel);
//                i.putExtra("code", code);
//                startActivity(i);
                Bundle bundle = new Bundle();
                bundle.putSerializable(Constant.LEED_MODEL, leedsModel);// Put anything what you want
                bundle.putString("code", code);
                TL_Updatelead_C_Details_Fragment fragment2 = new TL_Updatelead_C_Details_Fragment();
                fragment2.setArguments(bundle);

                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.detailContainer, fragment2);
                ft.commit();
                getActivity().overridePendingTransition(R.anim.slide_in, R.anim.slide_out);

            }
        });
        return view;
    }


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
//        leedsModelCo.setPeraddress(cPadress);

        leedsModelCo.setCurrentpin(cCurrentPIN);
        leedsModelCo.setCurrentarea(cCurrentarea);
        leedsModelCo.setCurrentlandmark(cCurrentlandmark);
        leedsModelCo.setCurrentstreet(cCurrentstreet);

        if (cYesNo.equalsIgnoreCase("No")) {
            leedsModelCo.setPeraddress(cPerAddress);
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

        return leedsModelCo;
    }

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

    public void fieldVisibility() {
        RelativeLayout.LayoutParams params4 = (RelativeLayout.LayoutParams) layoutperaddress.getLayoutParams();
        RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) layoutpin.getLayoutParams();
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) layoutlandmark.getLayoutParams();
        RelativeLayout.LayoutParams params2 = (RelativeLayout.LayoutParams) layoutarea.getLayoutParams();
        RelativeLayout.LayoutParams params3 = (RelativeLayout.LayoutParams) layoutstreet.getLayoutParams();
        params.height = ActionBar.LayoutParams.FILL_PARENT;
        params1.height = ActionBar.LayoutParams.FILL_PARENT;
        params2.height = ActionBar.LayoutParams.FILL_PARENT;
        params3.height = ActionBar.LayoutParams.FILL_PARENT;
        params4.height = ActionBar.LayoutParams.FILL_PARENT;
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
        params.height = ActionBar.LayoutParams.FILL_PARENT;
        ;
        layoutothervalue.setLayoutParams(params);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
