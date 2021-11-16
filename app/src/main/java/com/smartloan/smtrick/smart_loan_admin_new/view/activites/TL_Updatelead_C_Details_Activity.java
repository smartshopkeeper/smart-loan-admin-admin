package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.appcompat.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import java.util.ArrayList;
import java.util.Map;

public class TL_Updatelead_C_Details_Activity extends AppCompatActivity implements OnItemSelectedListener {
    Spinner CoapplicantRalationship;
    RadioButton REducation;
    RadioButton RYN;
    RadioButton Rcoapplicant;
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
    TextView area1;
    Button btcancel;
    Button btnnext;
    Button btnsave;
    Button btupdate;
    Button btverify;
    String cAdhar;
    String cAdress;
    String cAltcontatct;
    String cBdate;
    String cContatct;
    String cCurrentPIN;
    String cCurrentarea;
    String cCurrentlandmark;
    String cCurrentstreet;
    String cDL;
    String cEducation;
    String cEmail;
    String cGender;
    String cNmae;
    String cOffaddress;
    String cOther;
    String cPAN;
    String cPANnumber;
    String cPIN;
    String cPadress;
    String cPassport;
    String cProofDL;
    String cProofadhar;
    String cProofcurrentacctstmt;
    String cProofelectricitybill;
    String cProofgovtid;
    String cProofgumasta;
    String cProofpassport;
    String cProofrentagmt;
    String cProofvoterid;
    String cVoterid;
    String cYesNo;
    String carea;
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
    String clandmark;
    String cparents;
    String cresidencial;
    String cstreet;
    EditText currentarea;
    EditText currentlandmark;
    EditText currentpin;
    EditText currentstreet;
    EditText edtotherrelationship;
    EditText edtreferenceaddress;
    EditText edtreferenceaddress2;
    EditText edtreferencecontactno;
    EditText edtreferencecontactno2;
    EditText edtreferencename;
    EditText edtreferencename2;
    EditText edtreferencerelationship;
    EditText edtreferencerelationship2;
    EditText eparents;
    EditText eresidencial;
    EditText etaddress;
    EditText etalternatecontact;
    EditText etbirthdate;
    EditText etcEmail;
    EditText etcname;
    EditText etcontatct;
    EditText etoffaddress;
    EditText etother;
    EditText etpermanantaddress;
    RadioGroup groupRadio;
    RadioGroup groupRadioEducation;
    RadioGroup groupRadioGender;
    RadioGroup groupRadiocoapplicant;
    EditText landmark;
    TextView landmark1;
    RelativeLayout layoutarea;
    RelativeLayout layoutlandmark;
    RelativeLayout layoutotherrelationship;
    RelativeLayout layoutothervalue;
    RelativeLayout layoutpin;
    RelativeLayout layoutref1address;
    RelativeLayout layoutref1contact;
    RelativeLayout layoutref1name;
    RelativeLayout layoutref1relationship;
    RelativeLayout layoutref2address;
    RelativeLayout layoutref2contact;
    RelativeLayout layoutref2name;
    RelativeLayout layoutref2relationship;
    RelativeLayout layoutrelationship;
    RelativeLayout layoutsavebutton;
    RelativeLayout layoutstreet;
    LeedRepository leedRepository;
    LeedsModel leedsModel;
    ArrayList<LeedsModel> leedsModelArrayList;
    String padress;
    EditText pin;
    TextView pin1;
    ProgressDialogClass progressDialogClass;
    String sapplicantrelation;
    String scoapplicantYN;
    String sotherrelationship;
    Spinner spinemptype;
    Spinner spinincome;
    Spinner spinloantype;
    String sreference1address;
    String sreference1name;
    String sreference2address;
    String sreference2contactno;
    String sreference2name;
    String sreference2relationship;
    String sreferencecontactno;
    String sreferencerelationship;
    EditText street;
    TextView street1;
    TextView txtldate;
    TextView txtleadid;
    EditText txtpannumber;
    String code = "100";

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.TL_Updatelead_C_Details_Activity$1 */
    class C08161 implements OnCheckedChangeListener {
        C08161() {
        }

        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                txtpannumber.setVisibility(View.VISIBLE);
            } else {
                txtpannumber.setVisibility(View.INVISIBLE);
            }
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.TL_Updatelead_C_Details_Activity$2 */
    class C08172 implements RadioGroup.OnCheckedChangeListener {
        C08172() {
        }

        public void onCheckedChanged(RadioGroup group, int checkedId) {

            Rcoapplicant = (RadioButton) findViewById(checkedId);
            scoapplicantYN = Rcoapplicant.getText().toString();
            if (Rcoapplicant.getText().toString().equalsIgnoreCase("Yes")) {
                ShowApplicant();
            } else {
                HideApplicant();
            }
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.TL_Updatelead_C_Details_Activity$3 */
    class C08183 implements RadioGroup.OnCheckedChangeListener {
        C08183() {
        }

        public void onCheckedChanged(RadioGroup group, int checkedId) {
            REducation = (RadioButton) findViewById(checkedId);
            if (REducation.getText().toString().equalsIgnoreCase("Other")) {
                Showother();
            } else {
                hideother();
            }
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.TL_Updatelead_C_Details_Activity$4 */
    class C08194 implements RadioGroup.OnCheckedChangeListener {
        C08194() {
        }

        public void onCheckedChanged(RadioGroup group, int checkedId) {

            Rgender = (RadioButton) findViewById(checkedId);
          
            cGender = Rgender.getText().toString();
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.TL_Updatelead_C_Details_Activity$5 */
    class C08205 implements RadioGroup.OnCheckedChangeListener {
        C08205() {
        }

        public void onCheckedChanged(RadioGroup group, int checkedId) {

            RYN = (RadioButton) findViewById(checkedId);
          
            cYesNo = RYN.getText().toString();
            if (RYN.getText().toString().equalsIgnoreCase("No")) {
                fieldVisibility();
            } else {
                FieldInvisible();
            }
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.TL_Updatelead_C_Details_Activity$6 */
    class C08216 implements OnClickListener {
        C08216() {
        }

        public void onClick(View v) {

            cNmae = etcname.getText().toString();
          
            cAdress = etaddress.getText().toString();
          
            cCurrentPIN = currentpin.getText().toString();
          
            cCurrentlandmark = currentlandmark.getText().toString();
          
            cCurrentarea = currentarea.getText().toString();
          
            cCurrentstreet = currentstreet.getText().toString();
          
         //   cPadress = etpermanantaddress.getText().toString();
          
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
                Toast.makeText(getApplicationContext(), "Enter Customers full Name!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(cBdate)) {
                etbirthdate.setError("Required");
                Toast.makeText(getApplicationContext(), "Enter Birth Date!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(cContatct)) {
                etcontatct.setError("Required");
                Toast.makeText(getApplicationContext(), "Enter Contact!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(cAltcontatct)) {
                etalternatecontact.setError("Required");
                Toast.makeText(getApplicationContext(), "Enter Alternate Contact!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(cEmail)) {
                etcEmail.setError("Required");
                Toast.makeText(getApplicationContext(), "Enter Email!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(cOffaddress)) {
                etoffaddress.setError("Required");
                Toast.makeText(getApplicationContext(), "Enter Office address!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(cAdhar)) {
                Toast.makeText(getApplicationContext(), "Provide Adhar Card!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(cPAN)) {
                Toast.makeText(getApplicationContext(), "Provide PAN Card!", Toast.LENGTH_SHORT).show();
            } else {
                updateLeadDetails(leedsModel);
                Intent i = new Intent(getApplicationContext(), TL_Updatelead_Coapplicant_Detail_Activity.class);
                i.putExtra(Constant.LEED_MODEL, leedsModel);
                i.putExtra("Code",code);
                startActivity(i);
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.TL_Updatelead_C_Details_Activity$7 */
    class C08227 implements OnClickListener {
        C08227() {
        }

        public void onClick(View v) {
            cNmae = etcname.getText().toString();
          
            cAdress = etaddress.getText().toString();
          
            cCurrentPIN = currentpin.getText().toString();
          
            cCurrentlandmark = currentlandmark.getText().toString();
          
            cCurrentarea = currentarea.getText().toString();
          
            cCurrentstreet = currentstreet.getText().toString();
          
          //  cPadress = etpermanantaddress.getText().toString();
          
            cPIN = pin.getText().toString();
          
            clandmark = landmark.getText().toString();
          
            carea = area.getText().toString();
          
            cstreet = street.getText().toString();
          
            cOffaddress = etoffaddress.getText().toString();
          
            cBdate = etbirthdate.getText().toString();
          
            cPANnumber = txtpannumber.getText().toString();

            if (groupRadioGender.getCheckedRadioButtonId() != -1) {
                RadioButton btn = (RadioButton) groupRadioGender.getChildAt(groupRadioGender.indexOfChild(groupRadioGender.findViewById(groupRadioGender.getCheckedRadioButtonId())));
                cGender = btn.getText().toString();
            }
            if (groupRadio.getCheckedRadioButtonId() != -1) {
                RadioButton  btn = (RadioButton) groupRadio.getChildAt(groupRadio.indexOfChild(groupRadio.findViewById(groupRadio.getCheckedRadioButtonId())));
                cYesNo = btn.getText().toString();
            }
            if (groupRadioEducation.getCheckedRadioButtonId() != -1) {
                RadioButton  btn = (RadioButton) groupRadioEducation.getChildAt(groupRadioEducation.indexOfChild(groupRadioEducation.findViewById(groupRadioEducation.getCheckedRadioButtonId())));
                cEducation = btn.getText().toString();
            }
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
            sapplicantrelation = CoapplicantRalationship.getSelectedItem().toString();
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
                Toast.makeText(getApplicationContext(), "Enter Name!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(cBdate)) {
                etbirthdate.setError("Required");
                Toast.makeText(getApplicationContext(), "Enter Birth Date!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(cContatct)) {
                etcontatct.setError("Required");
                Toast.makeText(getApplicationContext(), "Enter Contact!", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(cAltcontatct)) {
                etalternatecontact.setError("Required");
                Toast.makeText(getApplicationContext(), "Enter Alternete Contact!", Toast.LENGTH_SHORT).show();
            } else {
                String emialpattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if (TextUtils.isEmpty(cEmail)) {
                    etcEmail.setError("Required");
                    Toast.makeText(getApplicationContext(), "Enter Email Address!", Toast.LENGTH_SHORT).show();
                } else if (!cEmail.matches(emialpattern)) {
                    etcEmail.setError("Invalid Email");
                    Toast.makeText(getApplicationContext(), "Invalid Email Address", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(cOffaddress)) {
                    Toast.makeText(getApplicationContext(), "Enter Office Address!", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(cAdhar)) {
                    Toast.makeText(getApplicationContext(), "Provide Adhar Card!", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(cPAN)) {
                    Toast.makeText(getApplicationContext(), "Provide PAN Card!", Toast.LENGTH_SHORT).show();
                } else {
                    updateLeadDetails(leedsModel);
                    Intent i = new Intent(getApplicationContext(), Tl_Updatelead_incomedetails_Activity.class);
                    i.putExtra(Constant.LEED_MODEL, leedsModel);
                    startActivity(i);
                    overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                }
            }
        }
    }

    /* renamed from: com.smartloan.smtrick.smart_loan_admin_new.view.activites.TL_Updatelead_C_Details_Activity$8 */
    class C09288 extends CallBack {
        C09288() {
        }

        public void onSuccess(Object object) {
            Toast.makeText(getApplicationContext(), "Lead Verify Successfully", Toast.LENGTH_SHORT).show();
            progressDialogClass.dismissDialog();
        }

        public void onError(Object object) {
            Context context = getApplicationContext();
            Utility.showLongMessage(context, context.getString(R.string.server_error));
        }
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tl_updatelead_cdetails_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        layoutpin = (RelativeLayout) findViewById(R.id.layoutpin);
        layoutlandmark = (RelativeLayout) findViewById(R.id.layoutland);
        layoutarea = (RelativeLayout) findViewById(R.id.layoutArea);
        layoutstreet = (RelativeLayout) findViewById(R.id.layoutstreet);
        layoutothervalue = (RelativeLayout) findViewById(R.id.layoutothervalue);
        layoutrelationship = (RelativeLayout) findViewById(R.id.layoutcoapplicantrelation);
        layoutotherrelationship = (RelativeLayout) findViewById(R.id.layoutotherrelationship);
        layoutsavebutton = (RelativeLayout) findViewById(R.id.layoutbuttonsave);
        layoutref1name = (RelativeLayout) findViewById(R.id.layoutreferencefullname);
        layoutref1address = (RelativeLayout) findViewById(R.id.layoutreferenceaddress);
        layoutref1contact = (RelativeLayout) findViewById(R.id.layoutreferencecontactno);
        layoutref1relationship = (RelativeLayout) findViewById(R.id.layoutreferencerelationhsip);
        layoutref2name = (RelativeLayout) findViewById(R.id.layoutreference2fullname);
        layoutref2address = (RelativeLayout) findViewById(R.id.layoutreference2address);
        layoutref2contact = (RelativeLayout) findViewById(R.id.layoutreference2contactno);
        layoutref2relationship = (RelativeLayout) findViewById(R.id.layoutreference2relationhsip);
        setSupportActionBar(toolbar);
        leedsModel = (LeedsModel) getIntent().getSerializableExtra(Constant.LEED_MODEL);


        progressDialogClass = new ProgressDialogClass(this);
        leedRepository = new LeedRepositoryImpl();
        appSharedPreference = new AppSharedPreference(this);
        String[] loanType = new String[]{"HL", "LAP"};
        String[] empType = new String[]{"Salaried", "Businessman"};
        String[] recidential = new String[]{"Owned", "Rented", "Allotted by Employer", "Family"};
        String[] CoapplicantRelation = new String[]{"Spouse", "Parents", "Children", "Power of Attorney", "Please specify"};
        btnnext = (Button) findViewById(R.id.buttonupdatenext);
        btnsave = (Button) findViewById(R.id.buttonsave);
        etcname = (EditText) findViewById(R.id.txtcamevalue);
        etaddress = (EditText) findViewById(R.id.txtcurrentaddressvalue);
        //etpermanantaddress = (EditText) findViewById(R.id.txtpermenantaddressvalue);
        groupRadio = (RadioGroup) findViewById(R.id.radioGYN);
        currentpin = (EditText) findViewById(R.id.txtcurrentpin1);
        currentlandmark = (EditText) findViewById(R.id.txtcurrentlandmark1);
        currentarea = (EditText) findViewById(R.id.txtcurrentarea1);
        currentstreet = (EditText) findViewById(R.id.txtcurrentstreet1);
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
        CoapplicantRalationship = (Spinner) findViewById(R.id.txtcoapplicantrelation1);
        CoapplicantRalationship.setOnItemSelectedListener(this);
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

        ArrayAdapter<String> spinnerArrayAdapterRecidential = new ArrayAdapter(this, R.layout.sppinner_layout_listitem, recidential);
        spinnerArrayAdapterRecidential.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        Recidential.setAdapter(spinnerArrayAdapterRecidential);

        ArrayAdapter<String> spinnerArrayAdapterRelationship = new ArrayAdapter(this, R.layout.sppinner_layout_listitem, CoapplicantRelation);
        spinnerArrayAdapterRelationship.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        CoapplicantRalationship.setAdapter(spinnerArrayAdapterRelationship);

        etother = (EditText) findViewById(R.id.txtOthervalue);
        chAdhar = (CheckBox) findViewById(R.id.checkboxadhar);
        chPAN = (CheckBox) findViewById(R.id.checkboxpan);
        if (chPAN.isChecked()) {
            txtpannumber.setVisibility(View.VISIBLE);
        } else {
            txtpannumber.setVisibility(View.INVISIBLE);
        }
        chPAN.setOnCheckedChangeListener(new C08161());
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
        RcoapplicantYES = (RadioButton) findViewById(R.id.radioapplicantYes);
        RcoapplicantNO = (RadioButton) findViewById(R.id.radioapplicantNo);
        groupRadiocoapplicant = (RadioGroup) findViewById(R.id.radiocoapplicantYN);
        groupRadiocoapplicant.setOnCheckedChangeListener(new C08172());
        groupRadioEducation.setOnCheckedChangeListener(new C08183());
        groupRadioGender.setOnCheckedChangeListener(new C08194());
        groupRadio.setOnCheckedChangeListener(new C08205());
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
        if (groupRadioEducation.getCheckedRadioButtonId() != -1) {
            cEducation = ((RadioButton) groupRadioEducation.getChildAt(groupRadioEducation.indexOfChild(groupRadioEducation.findViewById(groupRadioEducation.getCheckedRadioButtonId())))).getText().toString();
            if (cEducation.equalsIgnoreCase("Other")) {
                Showother();
            } else {
                hideother();
            }
        }
        if (groupRadiocoapplicant.getCheckedRadioButtonId() != -1) {
            scoapplicantYN = ((RadioButton) groupRadiocoapplicant.getChildAt(groupRadiocoapplicant.indexOfChild(groupRadiocoapplicant.findViewById(groupRadiocoapplicant.getCheckedRadioButtonId())))).getText().toString();
            if (scoapplicantYN.equalsIgnoreCase("Yes")) {
                ShowApplicant();
            } else {
                HideApplicant();
            }
        }
        Ryes = (RadioButton) findViewById(R.id.radioYes);
        Rno = (RadioButton) findViewById(R.id.radioNo);
        Rug = (RadioButton) findViewById(R.id.radioUG);
        Rg = (RadioButton) findViewById(R.id.radioGraguate);
        Rpg = (RadioButton) findViewById(R.id.radioPG);
        Rpro = (RadioButton) findViewById(R.id.radioprofessional);
        Rother = (RadioButton) findViewById(R.id.radioother);
        Rmale = (RadioButton) findViewById(R.id.radioMale);
        Rfemale = (RadioButton) findViewById(R.id.radioFemale);
        btnsave.setOnClickListener(new C08216());
        btnnext.setOnClickListener(new C08227());
        Intent in = getIntent();
        String code1 = in.getStringExtra("code");
        if (code.equalsIgnoreCase(code1)){
            edtreferencename.requestFocus();
        }
        getdata();
    }

    private void getdata() {
        try {
            String currentPIN;
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
                    Rug.setChecked(true);
                    hideother();
                } else if (education.equalsIgnoreCase("Graduate")) {
                    Rg.setChecked(true);
                    hideother();
                } else if (education.equalsIgnoreCase("Post Graduate")) {
                    Rpg.setChecked(true);
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
            if (Rno.isChecked()) {
                birthdate = PIN;
                PIN = cname;
                cname = Sstreet;
            } else {
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
                cname = pannumber;
                txtpannumber.setText(cname);
            } else {
                cname = pannumber;
            }
            if (leednumber2 != null) {
                pannumber = cname;
                cname = leednumber2;
                txtleadid.setText(cname);
            } else {
                cname = leednumber2;
            }
            if (cname2 != null) {
                leednumber2 = cname;
                cname = cname2;
                etcname.setText(cname);
            } else {
                cname = cname2;
            }
            if (caddress2 != null) {
                cname2 = cname;
                cname = caddress2;
                etaddress.setText(cname);
            } else {
                cname = caddress2;
            }
            if (permanataddress2 != null) {
                caddress2 = cname;
                cname = permanataddress2;
                //etpermanantaddress.setText(cname);
            } else {
                cname = permanataddress2;
            }
            if (officeaddress2 != null) {
                permanataddress2 = cname;
                cname = officeaddress2;
                etoffaddress.setText(cname);
            } else {
                cname = officeaddress2;
            }
            if (contact2 != null) {
                officeaddress2 = cname;
                cname = contact2;
                etcontatct.setText(cname);
            } else {
                cname = contact2;
            }
            if (altcontact2 != null) {
                contact2 = cname;
                cname = altcontact2;
                etalternatecontact.setText(cname);
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
        } catch (Exception e) {
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
        leedRepository.updateLeed(leedId, leedsMap, new C09288());
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
        LayoutParams params = (LayoutParams) layoutpin.getLayoutParams();
        LayoutParams params1 = (LayoutParams) layoutlandmark.getLayoutParams();
        LayoutParams params2 = (LayoutParams) layoutarea.getLayoutParams();
        LayoutParams params3 = (LayoutParams) layoutstreet.getLayoutParams();
        params.height = -1;
        params1.height = -1;
        params2.height = -1;
        params3.height = -1;
        layoutpin.setLayoutParams(params);
        layoutlandmark.setLayoutParams(params1);
        layoutarea.setLayoutParams(params2);
        layoutstreet.setLayoutParams(params3);
    }

    public void FieldInvisible() {
        LayoutParams params = (LayoutParams) layoutpin.getLayoutParams();
        LayoutParams params1 = (LayoutParams) layoutlandmark.getLayoutParams();
        LayoutParams params2 = (LayoutParams) layoutarea.getLayoutParams();
        LayoutParams params3 = (LayoutParams) layoutstreet.getLayoutParams();
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
        LayoutParams params = (LayoutParams) layoutothervalue.getLayoutParams();
        params.height = 0;
        layoutothervalue.setLayoutParams(params);
    }

    public void Showother() {
        LayoutParams params = (LayoutParams) layoutothervalue.getLayoutParams();
        params.height = -1;
        layoutothervalue.setLayoutParams(params);
    }

    public void ShowApplicant() {
        LayoutParams params = (LayoutParams) layoutrelationship.getLayoutParams();
        LayoutParams params2 = (LayoutParams) layoutsavebutton.getLayoutParams();
        params.height = -1;
        params2.height = -1;
        layoutrelationship.setLayoutParams(params);
        layoutsavebutton.setLayoutParams(params2);
    }

    public void showotherRelation() {
        LayoutParams params1 = (LayoutParams) layoutotherrelationship.getLayoutParams();
        params1.height = -1;
        layoutotherrelationship.setLayoutParams(params1);
    }

    public void hideotherRelation() {
        LayoutParams params1 = (LayoutParams) layoutotherrelationship.getLayoutParams();
        params1.height = 0;
        layoutotherrelationship.setLayoutParams(params1);
    }

    public void HideApplicant() {
        LayoutParams params = (LayoutParams) layoutrelationship.getLayoutParams();
        LayoutParams params1 = (LayoutParams) layoutotherrelationship.getLayoutParams();
        LayoutParams params2 = (LayoutParams) layoutsavebutton.getLayoutParams();
        params.height = 0;
        params1.height = 0;
        params2.height = 0;
        layoutrelationship.setLayoutParams(params);
        layoutotherrelationship.setLayoutParams(params1);
        layoutsavebutton.setLayoutParams(params2);
    }

    public void Hidereference() {
        LayoutParams params1 = (LayoutParams) layoutref1name.getLayoutParams();
        LayoutParams params2 = (LayoutParams) layoutref1address.getLayoutParams();
        LayoutParams params3 = (LayoutParams) layoutref1contact.getLayoutParams();
        LayoutParams params4 = (LayoutParams) layoutref1relationship.getLayoutParams();
        LayoutParams params5 = (LayoutParams) layoutref2name.getLayoutParams();
        LayoutParams params6 = (LayoutParams) layoutref2address.getLayoutParams();
        LayoutParams params7 = (LayoutParams) layoutref2contact.getLayoutParams();
        LayoutParams params8 = (LayoutParams) layoutref2relationship.getLayoutParams();
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
        LayoutParams params1 = (LayoutParams) layoutref1name.getLayoutParams();
        LayoutParams params2 = (LayoutParams) layoutref1address.getLayoutParams();
        LayoutParams params3 = (LayoutParams) layoutref1contact.getLayoutParams();
        LayoutParams params4 = (LayoutParams) layoutref1relationship.getLayoutParams();
        LayoutParams params5 = (LayoutParams) layoutref2name.getLayoutParams();
        LayoutParams params6 = (LayoutParams) layoutref2address.getLayoutParams();
        LayoutParams params7 = (LayoutParams) layoutref2contact.getLayoutParams();
        LayoutParams params8 = (LayoutParams) layoutref2relationship.getLayoutParams();
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

    public void onBackPressed() {
        Toast.makeText(getApplicationContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();
    }

    protected void onResume() {
        super.onResume();
        Log.d("lifecycle", "onResume invoked");
    }

    protected void onRestart() {
        super.onRestart();
        edtreferencename.requestFocus();
    }
}
