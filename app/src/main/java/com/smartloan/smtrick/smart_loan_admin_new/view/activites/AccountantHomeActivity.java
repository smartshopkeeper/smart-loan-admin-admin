package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.content.ContextCompat;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.exception.ExceptionUtil;
import com.smartloan.smtrick.smart_loan_admin_new.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_admin_new.models.Expences;
import com.smartloan.smtrick.smart_loan_admin_new.models.Invoice;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.AccountantApprovedExpenceAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.PaidExpenceAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.AccountantApprovedLeedsFragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.AccountantInvoicesTabFragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.AccountantUsersFragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Accountant_Report_Fragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.LoanCalculatorFragement;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.UnderConstrationFragement;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.REQUEST_CODE;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.STATUS_DISBUSED;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.STATUS_REJECTED;

public class AccountantHomeActivity extends AppCompatActivity implements
        OnFragmentInteractionListener,
        NavigationView.OnNavigationItemSelectedListener {
    private AppSharedPreference appSharedPreference;
    private NavigationView navigationView;
    private LeedRepository leedRepository;
    ProgressDialogClass progressDialogClass;

    private CardView cardComission, cardExpences, cardBills, cardInvoices;
    TextView leedscount, expencescount, invoicescount, billscount, paidinvoicescount, unpaidinvoicescount, paidbills,
            unpaidbills, approvedleedscount, rejectedleedscount;

    private List<Expences> expenceList;
    ArrayList<LeedsModel> leedsModelArrayList;
    ArrayList<Invoice> invoiceArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accountant_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        // setSupportActionBar(toolbar);
        appSharedPreference = new AppSharedPreference(this);
        leedRepository = new LeedRepositoryImpl();
        progressDialogClass = new ProgressDialogClass(AccountantHomeActivity.this);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        updateNavigationHeader();

        expenceList = new ArrayList<>();
        leedsModelArrayList = new ArrayList<>();
        invoiceArrayList = new ArrayList<>();

        cardComission = (CardView) findViewById(R.id.card_view_approved_leeds);
        cardExpences = (CardView) findViewById(R.id.card_view_expences);
        cardBills = (CardView) findViewById(R.id.card_view_bills);
        cardInvoices = (CardView) findViewById(R.id.card_view_invoices);

        leedscount = (TextView) findViewById(R.id.aproved_leedcount);
//        expencescount = (TextView) findViewById(R.id.card_view_approved_leeds);
        invoicescount = (TextView) findViewById(R.id.invoices_count);
        billscount = (TextView) findViewById(R.id.bills_count);
        paidinvoicescount = (TextView) findViewById(R.id.paidinvoices_count);
        unpaidinvoicescount = (TextView) findViewById(R.id.unpidinvoices_leedcount);
        paidbills = (TextView) findViewById(R.id.paid_bills_count);
        unpaidbills = (TextView) findViewById(R.id.unpaid_bills_count);
        approvedleedscount = (TextView) findViewById(R.id.approved_leeds_count);
        rejectedleedscount = (TextView) findViewById(R.id.rejected_leeds_count);

        getteLeed();
        getRejectedLeeds();
        readBills();
        readPaidBills();
        readUnpaidBills();
        getInvoices();

        cardExpences.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountantHomeActivity.this, Expences_Activity.class);
                intent.putExtra("value", "leeds");
                startActivity(intent);
            }
        });
        cardComission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountantHomeActivity.this, MainActivity_Accountant_new.class);
                intent.putExtra("value", "leeds");
                startActivity(intent);
            }
        });
        cardBills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountantHomeActivity.this, Accountant_Bills_Activity.class);
                intent.putExtra("value", "leeds");
                startActivity(intent);
            }
        });
        cardInvoices.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AccountantHomeActivity.this, Accountant_Invoice_Activity.class);
                startActivity(intent);
            }
        });
        // get our list view
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.replace(R.id.mainFrame, new AccountantApprovedLeedsFragment());
//        ft.commit();
    }

    private void getInvoices() {
        leedRepository.readAllInvoices(new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null){
                    invoiceArrayList = (ArrayList<Invoice>) object;
                    String count = String.valueOf(invoiceArrayList.size());
                    invoicescount.setText(count);
                }
            }

            @Override
            public void onError(Object object) {

            }
        });
    }

    private void getteLeed() {
        progressDialogClass.showDialog(this.getString(R.string.loading), this.getString(R.string.PLEASE_WAIT));
        leedRepository.readLeedsByStatus(STATUS_DISBUSED, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    leedsModelArrayList = (ArrayList<LeedsModel>) object;
                    String count = String.valueOf(leedsModelArrayList.size());
                    leedscount.setText(count);
                    approvedleedscount.setText(count);
                }
                progressDialogClass.dismissDialog();
            }

            @Override
            public void onError(Object object) {
                progressDialogClass.dismissDialog();
                Utility.showLongMessage(getApplicationContext(), getString(R.string.server_error));
            }
        });
    }

    private void getRejectedLeeds() {
        progressDialogClass.showDialog(this.getString(R.string.loading), this.getString(R.string.PLEASE_WAIT));
        leedRepository.readLeedsByStatus(STATUS_REJECTED, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    leedsModelArrayList = (ArrayList<LeedsModel>) object;
                    String count = String.valueOf(leedsModelArrayList.size());
                    rejectedleedscount.setText(count);
                }
                progressDialogClass.dismissDialog();
            }

            @Override
            public void onError(Object object) {
                progressDialogClass.dismissDialog();
                Utility.showLongMessage(getApplicationContext(), getString(R.string.server_error));
            }
        });
    }

    private void readBills() {
        leedRepository.readExpence(new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    expenceList = (ArrayList<Expences>) object;
                    String count = String.valueOf(expenceList.size());
                    billscount.setText(count);

                }
            }

            @Override
            public void onError(Object object) {

            }
        });
    }

    private void readPaidBills() {
        expenceList.clear();
        leedRepository.readExpenceByStatus(Constant.STATUS_PAID_BILL, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    expenceList = (ArrayList<Expences>) object;
                    String count = String.valueOf(expenceList.size());
                    paidbills.setText(count);

                }


            }

            @Override
            public void onError(Object object) {
                Utility.showLongMessage(getApplicationContext(), getString(R.string.server_error));
            }
        });
    }

    private void readUnpaidBills() {
        expenceList.clear();
        leedRepository.readExpenceByStatus(Constant.STATUS_APPROVED_BILL, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    expenceList = (ArrayList<Expences>) object;
                    String count = String.valueOf(expenceList.size());
                    unpaidbills.setText(count);
                }
            }

            @Override
            public void onError(Object object) {
                Utility.showLongMessage(getApplicationContext(), getString(R.string.server_error));
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        switch (id) {
            case R.id.Users:
                fragment = new AccountantUsersFragment();
                break;
            case R.id.Leads:
                fragment = new AccountantApprovedLeedsFragment();
                break;
            case R.id.Reports:
                fragment = new Accountant_Report_Fragment();
                break;
            case R.id.Settings:
                fragment = new UnderConstrationFragement();
                break;
            case R.id.Invices:
                fragment = new AccountantInvoicesTabFragment();
                break;
            case R.id.Calulator:
                fragment = new LoanCalculatorFragement();
                break;
            case R.id.Logout:
                clearDataWithSignOut();
                break;
        }


        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void clearDataWithSignOut() {
        FirebaseAuth.getInstance().signOut();
        appSharedPreference.clear();
        logOut();
    }

    private void logOut() {
        Intent intent = new Intent(this, LoginScreen.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        finish();
    }

    @Override
    public void onFragmentInteraction(String title) {
        // NOTE:  Code to replace the toolbar title based current visible fragment
        getSupportActionBar().setTitle(title);
    }

    public void updateNavigationHeader() {
        try {
            View header = navigationView.getHeaderView(0);
//            TextView textViewAgentId = header.findViewById(R.id.textView_agent_id);
            TextView textViewUserName = header.findViewById(R.id.acct_name);
            TextView textViewEmailId = header.findViewById(R.id.acct_email);
//            TextView textViewMobileNumber = header.findViewById(R.id.textView_contact);
            final ImageView imageViewProfile = header.findViewById(R.id.imageViewaccount);
            final ImageView ivProfileLayout = header.findViewById(R.id.ivProfileLayout);
            textViewUserName.setText(appSharedPreference.getUserName());
            textViewEmailId.setText(appSharedPreference.getEmaiId());
//            textViewAgentId.setText(appSharedPreference.getAgeniId());
//            textViewMobileNumber.setText(appSharedPreference.getMobileNo());
            if (!Utility.isEmptyOrNull(appSharedPreference.getProfileLargeImage())) {
                Picasso.with(this).load(appSharedPreference.getProfileLargeImage()).resize(200, 200).centerCrop().placeholder(R.drawable.imagelogo).into(imageViewProfile);
                Picasso.with(this)
                        .load(appSharedPreference.getProfileLargeImage())
                        .into(imageViewProfile, new Callback() {
                            @Override
                            public void onSuccess() {
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Bitmap innerBitmap = ((BitmapDrawable) imageViewProfile.getDrawable()).getBitmap();
                                        ivProfileLayout.setImageBitmap(Utility.blur(AccountantHomeActivity.this, innerBitmap));
                                    }
                                }, 100);
                            }

                            @Override
                            public void onError() {
                            }
                        });
            } else {
                imageViewProfile.setImageResource(R.drawable.imagelogo);
                ivProfileLayout.setImageResource(0);
            }
            if (!Utility.isEmptyOrNull(appSharedPreference.getProfileLargeImage())) {
                Picasso.with(this).load(appSharedPreference.getProfileLargeImage()).resize(200, 200).centerCrop().placeholder(R.drawable.imagelogo).into(imageViewProfile);
                Picasso.with(this)
                        .load(appSharedPreference.getProfileLargeImage())
                        .resize(200, 200)
                        .centerCrop()
                        .into(imageViewProfile, new Callback() {
                            @Override
                            public void onSuccess() {
                                new Handler().postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        Bitmap innerBitmap = ((BitmapDrawable) imageViewProfile.getDrawable()).getBitmap();
                                        imageViewProfile.setImageBitmap(Utility.blur(AccountantHomeActivity.this, innerBitmap));
                                    }
                                }, 100);
                            }

                            @Override
                            public void onError() {
                            }
                        });
            } else {
                imageViewProfile.setImageResource(R.drawable.imagelogo);
                ivProfileLayout.setImageResource(0);
            }
            imageViewProfile.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(AccountantHomeActivity.this, UpdateProfileActivity.class);
                    startActivityForResult(intent, REQUEST_CODE);
                }
            });
        } catch (Exception ex) {
            ExceptionUtil.logException(ex);
        }
    }


    public class ImageUploadReceiver extends BroadcastReceiver {
        public static final String PROCESS_RESPONSE = "com.smartloan.smtrick.smart_loan.intent.action.UPDATE_USER_DATA";

        @Override
        public void onReceive(Context context, Intent intent) {
            updateNavigationHeader();
        }
    }
}
