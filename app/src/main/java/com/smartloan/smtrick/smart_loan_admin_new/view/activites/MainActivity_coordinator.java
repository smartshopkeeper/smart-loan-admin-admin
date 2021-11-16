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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.content.ContextCompat;
import androidx.cardview.widget.CardView;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
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
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Coordinator_Fragment_lead;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Coordinator_Report_Fragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Fragment_Calculator;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.LoanCalculatorFragement;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Telecaller_fragment_Reports;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.REQUEST_CODE;

public class MainActivity_coordinator extends AppCompatActivity


        //Note : OnFragmentInteractionListener of all the fragments
        implements

        OnFragmentInteractionListener,
        //Fragment_GenerateLeads.OnFragmentInteractionListener,
        Coordinator_Fragment_lead.OnFragmentInteractionListener,
        Telecaller_fragment_Reports.OnFragmentInteractionListener,
         Fragment_Calculator.OnFragmentInteractionListener,

        NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;

    private CardView cardTotalLeeds, cardBanks, cardLoanCalculator, cardActiveUsers, cardReports;
    TextView leedscount, bankscount, userscount, reportscount;

    private AppSharedPreference appSharedPreference;
    ProgressDialogClass progressDialogClass;
    LeedRepository leedRepository;
    ArrayList<LeedsModel> leedsModelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_coordinator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // NOTE : Just remove the fab button
        appSharedPreference = new AppSharedPreference(this);
        this.leedRepository = new LeedRepositoryImpl();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.Leads);
        updateNavigationHeader();

        progressDialogClass = new ProgressDialogClass(this);

        cardTotalLeeds = (CardView) findViewById(R.id.leedcardId);
        cardBanks = (CardView) findViewById(R.id.bankscardId);
//        cardLoanCalculator = (CardView) findViewById(R.id.calculatorcardId);
//        cardActiveUsers = (CardView) findViewById(R.id.userscardId);
        cardReports = (CardView) findViewById(R.id.reportscardId);

        leedscount = (TextView) findViewById(R.id.txttotalLeedvalue);
        bankscount = (TextView) findViewById(R.id.txtbanksvalue);
//        userscount = (TextView) findViewById(R.id.txtactiveusersvalue);
        reportscount = (TextView) findViewById(R.id.txtreportsvalue);

        cardTotalLeeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity_coordinator.this, MainActivity_Coorinator_new.class);
                intent.putExtra("value", "leeds");
                startActivity(intent);
            }
        });

//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
//
//        //NOTE:  Checks first item in the navigation drawer initially
//        navigationView.setCheckedItem(R.id.Leads);

        //NOTE:  Open fragment1 initially.
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.replace(R.id.mainFrame, new Coordinator_Fragment_lead());
//        ft.commit();
//        getteLeed();
        geteAllLeed();

    }

    private void getteLeed() {
        this.progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));
        this.leedRepository.readLeedsByStatus(Constant.STATUS_VERIFIED, new CallBack() {
            @Override
            public void onSuccess(Object object) {

                if (object != null) {
                    leedsModelArrayList = (ArrayList) object;
                }
                int a = leedsModelArrayList.size();
                leedscount.setText( String.valueOf(a));
                progressDialogClass.dismissDialog();
            }

            @Override
            public void onError(Object object) {
                progressDialogClass.dismissDialog();
            }
        });
    }

    private void geteAllLeed() {
        this.progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));
        this.leedRepository.readAllLeeds( new CallBack() {
            @Override
            public void onSuccess(Object object) {

                if (object != null) {
                    leedsModelArrayList = (ArrayList) object;
                }
                int a = leedsModelArrayList.size();
                leedscount.setText( String.valueOf(a));
                progressDialogClass.dismissDialog();
            }

            @Override
            public void onError(Object object) {
                progressDialogClass.dismissDialog();
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        //NOTE: creating fragment object
        Fragment fragment = null;

        if  (id == R.id.Leads) {
            fragment = new Coordinator_Fragment_lead();
        } else if (id == R.id.Reports) {
            fragment = new Coordinator_Report_Fragment();
        }else if (id == R.id.Calulator) {
            fragment = new LoanCalculatorFragement();
        }else if (id == R.id.Logout) {
            clearDataWithSignOut();
        }

        //NOTE: Fragment changing code
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, fragment);
            ft.commit();
        }

        //NOTE:  Closing the drawer after selecting
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout); //Ya you can also globalize this variable :P
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    private void clearDataWithSignOut()
    {
        FirebaseAuth.getInstance().signOut();
        appSharedPreference.clear();
        logOut();
    }

    private void logOut()
    {
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
            final ImageView imageViewProfile = header.findViewById(R.id.imageView6);
            final ImageView ivProfileLayout = header.findViewById(R.id.ivProfileLayout);
//            textViewUserName.setText(appSharedPreference.getUserName());
//            textViewEmailId.setText(appSharedPreference.getEmaiId());
//            textViewAgentId.setText(appSharedPreference.getAgeniId());
//            textViewMobileNumber.setText(appSharedPreference.getMobileNo());
//            if (!Utility.isEmptyOrNull(appSharedPreference.getProfileLargeImage())) {
//                Picasso.with(this).load(appSharedPreference.getProfileLargeImage()).resize(200, 200).centerCrop().placeholder(R.drawable.imagelogo).into(imageViewProfile);
//                Picasso.with(this)
//                        .load(appSharedPreference.getProfileLargeImage())
//                        .into(imageViewProfile, new Callback() {
//                            @Override
//                            public void onSuccess() {
//                                new Handler().postDelayed(new Runnable() {
//                                    @Override
//                                    public void run() {
//                                        Bitmap innerBitmap = ((BitmapDrawable) imageViewProfile.getDrawable()).getBitmap();
//                                        ivProfileLayout.setImageBitmap(Utility.blur(MainActivity_coordinator.this, innerBitmap));
//                                    }
//                                }, 100);
//                            }
//
//                            @Override
//                            public void onError() {
//                            }
//                        });
//            } else {
//                imageViewProfile.setImageResource(R.drawable.imagelogo);
//                ivProfileLayout.setImageResource(0);
//            }
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
                                        imageViewProfile.setImageBitmap(Utility.blur(MainActivity_coordinator.this, innerBitmap));
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
                    Intent intent = new Intent(MainActivity_coordinator.this, UpdateProfileActivity.class);
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
