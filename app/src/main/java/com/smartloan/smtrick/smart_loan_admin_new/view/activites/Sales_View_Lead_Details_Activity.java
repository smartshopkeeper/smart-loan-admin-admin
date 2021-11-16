package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import androidx.cardview.widget.CardView;
import androidx.appcompat.widget.Toolbar;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.LEED_MODEL;

public class Sales_View_Lead_Details_Activity extends AppCompatActivity implements View.OnClickListener {

    CardView cardLabel, cardFollow_up, cardNotes, cardAppointment, cardDocuments;
    ImageView imgCall, imgMessage, imgEmail, imgNavigate, imgProfile;
    TextView TXTusername;

    LeedsModel leedsModel;
    private static final int REQUEST_PHONE_CALL = 1;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales__view__lead__details_);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar1));
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        leedsModel = (LeedsModel) getIntent().getSerializableExtra(Constant.LEED_MODEL);

        cardLabel = (CardView) findViewById(R.id.card_view_labels);
        cardFollow_up = (CardView) findViewById(R.id.card_view_foloup_task);
        cardNotes = (CardView) findViewById(R.id.card_view_notes);
        cardAppointment = (CardView) findViewById(R.id.card_view_appointment);
        cardDocuments = (CardView) findViewById(R.id.card_view_documents);

        imgCall = (ImageView) findViewById(R.id.imgCall);
        imgMessage = (ImageView) findViewById(R.id.imgMessage);
        imgEmail = (ImageView) findViewById(R.id.imgEmail);
        imgNavigate = (ImageView) findViewById(R.id.imgNavigate);
        imgProfile = (ImageView) findViewById(R.id.imgProfile);

        TXTusername = (TextView) findViewById(R.id.txtUsername);
        TXTusername.setText(leedsModel.getCustomerName());

        cardLabel.setOnClickListener(this);
        cardFollow_up.setOnClickListener(this);
        cardNotes.setOnClickListener(this);
        cardAppointment.setOnClickListener(this);
        cardDocuments.setOnClickListener(this);
        imgCall.setOnClickListener(this);
        imgMessage.setOnClickListener(this);
        imgEmail.setOnClickListener(this);
        imgNavigate.setOnClickListener(this);
        imgProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == cardLabel) {
            Intent intent = new Intent(Sales_View_Lead_Details_Activity.this, Sales_Tasks_Activity.class);
            intent.putExtra("Task", "Label");
            intent.putExtra(LEED_MODEL, leedsModel);
            startActivity(intent);
        } else if (v == cardFollow_up) {
            Intent intent = new Intent(Sales_View_Lead_Details_Activity.this, Sales_FollowUP_Activity.class);
            intent.putExtra("Task", "FallowUp");
            intent.putExtra(LEED_MODEL, leedsModel);
            startActivity(intent);
        } else if (v == cardNotes) {
            Intent intent = new Intent(Sales_View_Lead_Details_Activity.this, Sales_Tasks_Activity.class);
            intent.putExtra("Task", "Notes");
            intent.putExtra(LEED_MODEL, leedsModel);
            startActivity(intent);
        } else if (v == cardAppointment) {
            Intent intent = new Intent(Sales_View_Lead_Details_Activity.this, Sales_Reschedule_Appointment_Activity.class);
            intent.putExtra(LEED_MODEL, leedsModel);
            startActivity(intent);
        } else if (v == cardDocuments) {
            Intent intent = new Intent(Sales_View_Lead_Details_Activity.this, Sales_Checklist_Activity.class);
            intent.putExtra("Task", "Docs");
            intent.putExtra(LEED_MODEL, leedsModel);
            startActivity(intent);
        } else if (v == imgCall) {
            String customer_number = leedsModel.getMobileNumber();
            Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + customer_number));
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // TODO: Consider calling
                //    ActivityCompat#requestPermissions
                // here to request the missing permissions, and then overriding
                ActivityCompat.requestPermissions((Activity) this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_PHONE_CALL);
                startActivity(intent);

                return;
            }
            startActivity(intent);
        } else if (v == imgMessage) {

            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_APP_MESSAGING);
            startActivity(intent);

        } else if (v == imgEmail) {

            final Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
            emailIntent.setType("text/plain");
            emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{leedsModel.getEmail()});
            emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "");
            emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, "");
            emailIntent.setType("message/rfc822");

            try {
                startActivity(Intent.createChooser(emailIntent,
                        "Send email using..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(getApplicationContext(),
                        "No email clients installed.",
                        Toast.LENGTH_SHORT).show();
            }


        }
    }

}
