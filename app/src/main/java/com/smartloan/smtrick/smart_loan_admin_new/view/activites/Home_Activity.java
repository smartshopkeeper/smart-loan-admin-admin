package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.material.navigation.NavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


import androidx.core.view.GravityCompat;
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
import com.smartloan.smtrick.smart_loan_admin_new.models.Bank;
import com.smartloan.smtrick.smart_loan_admin_new.models.Invoice;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.models.User;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.UserRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.UserRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.AccountantLeedsAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.TasksAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Admin_TodoList_Fragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.InvoicesTabFragement;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.UnderConstrationFragement;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.REQUEST_CODE;

public class Home_Activity extends AppCompatActivity
        implements
        OnFragmentInteractionListener,
        NavigationView.OnNavigationItemSelectedListener {

    TextView user_name, user_contact, user_email;
    private AppSharedPreference appSharedPreference;
    private NavigationView navigationView;
    private LeedRepository leedsRepository;
    private UserRepository userRepository;
    private ArrayList<LeedsModel> leedsArraylist;
    private ArrayList<Invoice> invoicesArraylist;
    private ArrayList<Invoice> GeneratedinvoicesArraylist;
    private ArrayList<Invoice> ApprovedinvoicesArraylist;
    private ProgressDialogClass progressDialogClass;

    private ArrayList<Bank> BanksArraylist;
    private ArrayList<User> UserArraylist;
    private ArrayList<User> SalesArraylist;
    private ArrayList<User> AgentArraylist;


    private CardView cardViewTotalleeds, cardViewAgents, cardViewSalesPersons, cardViewLeedsummary, cardViewBankTarget,
            cardViewPL, cardAddBank, cardTodolist, cardAddBills, cardChecklist;

    private TextView txtBiilsCount, txtSalesCount, txtAgentsCount, txtSummaryCount;
    private ProgressDialog progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //NOTE:  Checks first item in the navigation drawer initially
        navigationView.setCheckedItem(R.id.Leads);

        leedsRepository = new LeedRepositoryImpl();
        userRepository = new UserRepositoryImpl();
        appSharedPreference = new AppSharedPreference(getApplicationContext());
        progressDialogClass = new ProgressDialogClass(this);
        leedsArraylist = new ArrayList<>();
        BanksArraylist = new ArrayList<>();
        invoicesArraylist = new ArrayList<>();
        GeneratedinvoicesArraylist = new ArrayList<>();
        ApprovedinvoicesArraylist = new ArrayList<>();
        UserArraylist = new ArrayList<>();
        SalesArraylist = new ArrayList<>();
        AgentArraylist = new ArrayList<>();

        updateNavigationHeader();

        cardViewTotalleeds = (CardView) findViewById(R.id.card_view_total_leeds);
        cardViewAgents = (CardView) findViewById(R.id.card_view_agents);
        cardViewSalesPersons = (CardView) findViewById(R.id.card_view_sales_persons);
        cardViewLeedsummary = (CardView) findViewById(R.id.card_view_lead_summary);
        cardViewBankTarget = (CardView) findViewById(R.id.card_view_bank_target);
        cardViewPL = (CardView) findViewById(R.id.card_view_pl);
        cardAddBank = (CardView) findViewById(R.id.card_add_bank);
        cardTodolist = (CardView) findViewById(R.id.card_todo_list);
        cardAddBills = (CardView) findViewById(R.id.card_view_bils);
        cardChecklist = (CardView) findViewById(R.id.card_checklist);

        txtBiilsCount = (TextView) findViewById(R.id.txtBillsCount);
        txtSalesCount = (TextView) findViewById(R.id.txtSalesCount);
        txtAgentsCount = (TextView) findViewById(R.id.txtAgentsCount);
        txtSummaryCount = (TextView) findViewById(R.id.txtSummaryCount);

//        cardTotalLeeds = (CardView) findViewById(R.id.card_view_total_leeds);
//        cardBanks = (CardView) findViewById(R.id.card_view_banks);
//        cardLoanCalculator = (CardView) findViewById(R.id.card_view_loan_calculator);
//        cardActiveUsers = (CardView) findViewById(R.id.card_view_users);
//        cardReports = (CardView) findViewById(R.id.card_view_Reports);
//        cardComission = (CardView) findViewById(R.id.card_view_Commission);
//        cardBills = (CardView) findViewById(R.id.card_view_bills);
//        cardCheckList = (CardView) findViewById(R.id.card_view_Checklist);
//        cardInvoices = (CardView) findViewById(R.id.card_view_Invoice);
//        cardTargets = (CardView) findViewById(R.id.card_view_Target);
//
//        leedscount = (TextView) findViewById(R.id.total_leedcount);
//        bankscount = (TextView) findViewById(R.id.banks_count);
//        userscount = (TextView) findViewById(R.id.users_count);
//        reportscount = (TextView) findViewById(R.id.reports_count);
//        txtInvoiceCount = (TextView) findViewById(R.id.invoices_count);
//        txtgeneratedInvoiceCount = (TextView) findViewById(R.id.generated_invoices_count);
//        txtApprovedInvoiceCount = (TextView) findViewById(R.id.approved_invoices_count);


//        new GetWeather().execute();

//        cardTotalLeeds.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
//                intent.putExtra("value", "leeds");
//                startActivity(intent);
//            }
//        });
//        cardBanks.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
//                intent.putExtra("value", "banks");
//                startActivity(intent);
//            }
//        });
//        cardLoanCalculator.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
//                intent.putExtra("value", "calc");
//                startActivity(intent);
//            }
//        });
//        cardActiveUsers.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
//                intent.putExtra("value", "user");
//                startActivity(intent);
//            }
//        });
//        cardReports.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
//                intent.putExtra("value", "report");
//                startActivity(intent);
//            }
//        });
//        cardComission.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
//                intent.putExtra("value", "comission");
//                startActivity(intent);
//            }
//        });
//        cardBills.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
//                intent.putExtra("value", "bills");
//                startActivity(intent);
//            }
//        });
//        cardCheckList.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
//                intent.putExtra("value", "checklist");
//                startActivity(intent);
//            }
//        });
//        cardInvoices.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
//                intent.putExtra("value", "invoice");
//                startActivity(intent);
//            }
//        });
//
//        cardTargets.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
//                intent.putExtra("value", "target");
//                startActivity(intent);
//            }
//        });

        readAllReports();


        cardViewTotalleeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, MainActivity_Admin_new.class);
                intent.putExtra("value", "leeds");
                startActivity(intent);
            }
        });
        cardViewAgents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "agents");
                startActivity(intent);
            }
        });
        cardViewSalesPersons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "sales");
                startActivity(intent);
            }
        });
        cardViewLeedsummary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "summary");
                startActivity(intent);
            }
        });
        cardViewBankTarget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "banktarget");
                startActivity(intent);
            }
        });
        cardViewPL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "pl");
                startActivity(intent);
            }
        });
        cardAddBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "addbank");
                startActivity(intent);
            }
        });
        cardTodolist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "todolist");
                startActivity(intent);
            }
        });

        cardChecklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "checklist");
                startActivity(intent);
            }
        });
        cardAddBills.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "bills");
                startActivity(intent);
            }
        });

    }

    private class GetWeather extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress = new ProgressDialog(Home_Activity.this);
            progress.setMessage("Downloading tasks");
            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        }

        @Override
        protected Void doInBackground(Void... arg0) {

            getLeedsReport();


            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if (progress.isShowing()) {
                progress.dismiss();
            }

        }
    }

    private void readAllReports() {
        progressDialogClass.showDialog(this.getString(R.string.SIGNING_IN), this.getString(R.string.PLEASE_WAIT));
        leedsRepository.readAllLeeds(new CallBack() {
            @Override
            public void onSuccess(Object object) {

                if (object != null) {
                    leedsArraylist = (ArrayList<LeedsModel>) object;
                }

                String repcount = String.valueOf(leedsArraylist.size());
                txtBiilsCount.setText(repcount);
                txtSummaryCount.setText(repcount);

                readAgents();

                progressDialogClass.dismissDialog();

            }

            @Override
            public void onError(Object object) {
                progressDialogClass.dismissDialog();
            }
        });
    }

    private void readSales() {
        progressDialogClass.showDialog(this.getString(R.string.SIGNING_IN), this.getString(R.string.PLEASE_WAIT));
        SalesArraylist.clear();
        userRepository.readUserByRole(Constant.SALES, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object == null) {
                    SalesArraylist = (ArrayList<User>) object;

                }

                int salescount = SalesArraylist.size();
                txtSalesCount.setText(String.valueOf(salescount));

                progressDialogClass.dismissDialog();

            }

            @Override
            public void onError(Object object) {
                progressDialogClass.dismissDialog();
            }
        });
    }

    private void readAgents() {
        progressDialogClass.showDialog(this.getString(R.string.SIGNING_IN), this.getString(R.string.PLEASE_WAIT));
        AgentArraylist.clear();
        userRepository.readUserByRole(Constant.AGENT, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object == null) {
                    AgentArraylist = (ArrayList<User>) object;

                }
                int agentscount = AgentArraylist.size();
                txtAgentsCount.setText(String.valueOf(agentscount));

                readSales();

                progressDialogClass.dismissDialog();
            }

            @Override
            public void onError(Object object) {
                progressDialogClass.dismissDialog();
            }
        });

    }

    private void getLeedsReport() {
//        progressDialogClass.showDialog(this.getString(R.string.SIGNING_IN), this.getString(R.string.PLEASE_WAIT));
        leedsRepository.readAllLeeds(new CallBack() {
            @Override
            public void onSuccess(Object object) {

                if (object != null) {
                    leedsArraylist = (ArrayList<LeedsModel>) object;
                }
                int a = leedsArraylist.size();
//                leedscount.setText(String.valueOf(a));
                getInvoiceReport();
            }

            @Override
            public void onError(Object object) {

//                progressDialogClass.dismissDialog();
            }
        });
    }

    private void getInvoiceReport() {
        invoicesArraylist.clear();
        GeneratedinvoicesArraylist.clear();
        ApprovedinvoicesArraylist.clear();
        leedsRepository.readAllInvoices1(new CallBack() {
            @Override
            public void onSuccess(Object object) {

                if (object != null) {
                    invoicesArraylist = (ArrayList<Invoice>) object;
                }
                String in = String.valueOf(invoicesArraylist.size());
//                txtInvoiceCount.setText(in);

                for (int i = 0; i < invoicesArraylist.size(); i++) {
                    if (invoicesArraylist.get(i).getStatus().equalsIgnoreCase(Constant.STATUS_INVOICE_SENT)) {
                        GeneratedinvoicesArraylist.add(invoicesArraylist.get(i));
                    }
                }
                for (int i = 0; i < invoicesArraylist.size(); i++) {
                    if (invoicesArraylist.get(i).getStatus().equalsIgnoreCase(Constant.STATUS_INVOICE_APPROVED)) {
                        ApprovedinvoicesArraylist.add(invoicesArraylist.get(i));
                    }
                }
                String gen = String.valueOf(GeneratedinvoicesArraylist.size());
                String app = String.valueOf(ApprovedinvoicesArraylist.size());
//                txtgeneratedInvoiceCount.setText(gen);
//                txtApprovedInvoiceCount.setText(app);
                progressDialogClass.dismissDialog();

                getBanks();

            }

            @Override
            public void onError(Object object) {
                progressDialogClass.dismissDialog();
            }
        });
    }

    private void getBanks() {
        leedsRepository.readAllBanks(new CallBack() {
            @Override
            public void onSuccess(Object object) {

                if (object != null) {
                    BanksArraylist = (ArrayList<Bank>) object;
                }

                int b = BanksArraylist.size();
//                bankscount.setText(String.valueOf(b));


            }

            @Override
            public void onError(Object object) {

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
//                fragment = new UserTabsFragment();
                Intent intentuser = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intentuser.putExtra("value", "user");
                startActivity(intentuser);
                break;
            case R.id.Leads:
//                fragment = new LeedsTabsFragment();
                Intent intent = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intent.putExtra("value", "leeds");
                startActivity(intent);
                break;
            case R.id.Reports:
//                fragment = new ReportsTabFragment();
                Intent intentreport = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intentreport.putExtra("value", "report");
                startActivity(intentreport);
                break;
            case R.id.Settings:
                fragment = new UnderConstrationFragement();
                break;
            case R.id.Invices:
                fragment = new InvoicesTabFragement();
                break;
            case R.id.Calulator:
//                fragment = new LoanCalculatorFragement();
                Intent intentcalc = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intentcalc.putExtra("value", "calc");
                startActivity(intentcalc);
                break;
            case R.id.Bank:
//                fragment = new AddBankFragement();
                Intent intentbank = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intentbank.putExtra("value", "banks");
                startActivity(intentbank);
                break;
            case R.id.todolist:
                Intent intenttodolist = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intenttodolist.putExtra("value", "todolist");
                startActivity(intenttodolist);
                break;
            case R.id.calander:
                Intent intentcalandert = new Intent(Home_Activity.this, Activity_Home_Main.class);
                intentcalandert.putExtra("value", "calender");
                startActivity(intentcalandert);
                break;
            case R.id.mail:
            case R.id.notification:
            case R.id.owntask:
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
            TextView textViewAgentId = header.findViewById(R.id.textView_agent_id);
            TextView textViewUserName = header.findViewById(R.id.textView_user_name);
            TextView textViewEmailId = header.findViewById(R.id.text_view_email);
            TextView textViewMobileNumber = header.findViewById(R.id.textView_contact);
            final ImageView imageViewProfile = header.findViewById(R.id.image_view_profile1);
            final ImageView ivProfileLayout = header.findViewById(R.id.ivProfileLayout);
            textViewUserName.setText(appSharedPreference.getUserName());
            textViewEmailId.setText(appSharedPreference.getEmaiId());
            textViewAgentId.setText(appSharedPreference.getAgeniId());
            textViewMobileNumber.setText(appSharedPreference.getMobileNo());
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
                                        ivProfileLayout.setImageBitmap(Utility.blur(Home_Activity.this, innerBitmap));
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
                                        imageViewProfile.setImageBitmap(Utility.blur(Home_Activity.this, innerBitmap));
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
                    Intent intent = new Intent(Home_Activity.this, UpdateProfileActivity.class);
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
