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
import com.smartloan.smtrick.smart_loan_admin_new.exception.ExceptionUtil;
import com.smartloan.smtrick.smart_loan_admin_new.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Fragment_Calculator;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Fragment_ViewBanks;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.LoanCalculatorFragement;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Sales_Report_Fragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Sales_Fragment_leads;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Telecaller_fragment_Reports;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.REQUEST_CODE;

public class MainActivity_sales extends AppCompatActivity


        //Note : OnFragmentInteractionListener of all the fragments
        implements
        OnFragmentInteractionListener,
        //Fragment_GenerateLeads.OnFragmentInteractionListener,
        Sales_Fragment_leads.OnFragmentInteractionListener,
        Telecaller_fragment_Reports.OnFragmentInteractionListener,
        Fragment_Calculator.OnFragmentInteractionListener,

        NavigationView.OnNavigationItemSelectedListener {

    private NavigationView navigationView;
    TextView user_name,user_contact,user_email;

    private AppSharedPreference appSharedPreference;

    private CardView cardTotalLeeds, cardBanks, cardLoanCalculator, cardActiveUsers, cardReports;
    TextView leedscount, bankscount, userscount, reportscount;

//    @Override
//    public boolean onSupportNavigateUp() {
//        finish();
//        return true;
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sales);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setDisplayShowHomeEnabled(true);

        appSharedPreference = new AppSharedPreference(getApplicationContext());

        // NOTE : Just remove the fab button

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();


        cardTotalLeeds = (CardView) findViewById(R.id.leedcardId);
//        cardBanks = (CardView) findViewById(R.id.bankscardId);
        cardLoanCalculator = (CardView) findViewById(R.id.calculatorcardId);
//        cardActiveUsers = (CardView) findViewById(R.id.userscardId);
        cardReports = (CardView) findViewById(R.id.reportscardId);

        leedscount = (TextView) findViewById(R.id.txttotalLeedvalue);
        bankscount = (TextView) findViewById(R.id.txtbanksvalue);
//        userscount = (TextView) findViewById(R.id.txtactiveusersvalue);
        reportscount = (TextView) findViewById(R.id.txtreportsvalue);

        cardTotalLeeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity_sales.this, MainActivity_Sales_new.class);
                intent.putExtra("value", "leeds");
                startActivity(intent);
            }
        });
        cardLoanCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity_sales.this, Calculator_Activity.class);
                intent.putExtra("value", "leeds");
                startActivity(intent);
            }
        });
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //NOTE:  Checks first item in the navigation drawer initially
        navigationView.setCheckedItem(R.id.Leads);
        updateNavigationHeader();
//        //NOTE:  Open fragment1 initially.
//        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//        ft.replace(R.id.mainFrame, new Sales_Fragment_leads());
//        ft.commit();

    }

//    public void updateNavigationHeader() {
//        try {
//            View header = navigationView.getHeaderView(0);
//
//            user_name = (TextView) header.findViewById(R.id.sales_name);
//            user_contact = (TextView)  header.findViewById(R.id.contact);
//            user_email = (TextView)  header.findViewById(R.id.email);
//
//            String name = appSharedPreference.getUserName();
//            String mobile = appSharedPreference.getMobileNo();
//            String email = appSharedPreference.getEmaiId();
//            user_email.setText(email);
//            user_contact.setText(mobile);
//            user_name.setText(name);
//
//        }catch (Exception e){}
//    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.main, menu);
//        return true;
//
//        }

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        //NOTE: creating fragment object
        Fragment fragment = null;

        if  (id == R.id.Leads) {
            fragment = new Sales_Fragment_leads();
        } else if (id == R.id.Reports) {
            fragment = new Sales_Report_Fragment();
        }else if (id == R.id.Calulator) {
            fragment = new LoanCalculatorFragement();
        } else if (id == R.id.Banks) {
            fragment = new Fragment_ViewBanks();
        } else if (id == R.id.Logout) {
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
            final ImageView imageViewProfile = header.findViewById(R.id.imageView);
            final ImageView ivProfileLayout = header.findViewById(R.id.ivProfileLayout);

            user_name = (TextView) header.findViewById(R.id.sales_name);
            user_contact = (TextView)  header.findViewById(R.id.contact);
            user_email = (TextView)  header.findViewById(R.id.email);

            String name = appSharedPreference.getUserName();
            String mobile = appSharedPreference.getMobileNo();
            String email = appSharedPreference.getEmaiId();
            user_email.setText(email);
            user_contact.setText(mobile);
            user_name.setText(name);
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
//                                        ivProfileLayout.setImageBitmap(Utility.blur(MainActivity_sales.this, innerBitmap));
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
                                        imageViewProfile.setImageBitmap(Utility.blur(MainActivity_sales.this, innerBitmap));
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
                    Intent intent = new Intent(MainActivity_sales.this, UpdateProfileActivity.class);
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
