package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
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
import androidx.cardview.widget.CardView;
import androidx.appcompat.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
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
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Fragment_Calculator;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.LoanCalculatorFragement;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Tc_fragment_lead_tab_generatedlead;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Telecaller_Fragment_leads;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Telecaller_fragment_Reports;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import androidx.core.content.ContextCompat;


import java.util.ArrayList;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.REQUEST_CODE;

public class MainActivity_telecaller extends AppCompatActivity implements
        OnFragmentInteractionListener,
        Telecaller_Fragment_leads.OnFragmentInteractionListener,
        Telecaller_fragment_Reports.OnFragmentInteractionListener,
        Fragment_Calculator.OnFragmentInteractionListener,
        NavigationView.OnNavigationItemSelectedListener {

    private AppSharedPreference appSharedPreference;
    private NavigationView navigationView;
    ProgressDialogClass progressDialogClass;
    LeedRepository leedRepository;
    ArrayList<LeedsModel> leedsModelArrayList;

    private CardView cardTotalLeeds, cardTargets, cardEvents;
    TextView txtleedscount, txtTargetsCount, txtEventsCount, txtleedscountmonth, txtTargetsCountmonth, txtEventsCountmonth;

    BarChart barChart;
    BarData barData;
    BarDataSet barDataSet;
    ArrayList barEntries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_telecaller);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        appSharedPreference = new AppSharedPreference(this);
        this.leedRepository = new LeedRepositoryImpl();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.Leads);
        Menu nav_Menu = navigationView.getMenu();
        nav_Menu.findItem(R.id.Banks).setVisible(false);
        updateNavigationHeader();

        progressDialogClass = new ProgressDialogClass(this);

        cardTotalLeeds = (CardView) findViewById(R.id.leedcardId);
        cardTargets = (CardView) findViewById(R.id.cardTargets);
        cardEvents = (CardView) findViewById(R.id.cardEvents);

        txtleedscount = (TextView) findViewById(R.id.txttotalLeedvalue);
        txtTargetsCount = (TextView) findViewById(R.id.txtTargetsValue);
        txtEventsCount = (TextView) findViewById(R.id.txtEventValue);
        txtleedscountmonth = (TextView) findViewById(R.id.txtleadsinmonthvalue);
        txtTargetsCountmonth = (TextView) findViewById(R.id.txtTargetsValueinthisMonth);
        txtEventsCountmonth = (TextView) findViewById(R.id.txteventsvalue);

        barChart = findViewById(R.id.barChart);
        BarData data = new BarData(getXAxisValues(), getDataSet());
        barChart.setData(data);
//        barChart.setDescription("My Chart");
        barChart.setBackgroundColor(Color.TRANSPARENT); //set whatever color you prefer
        barChart.setDrawGridBackground(false);
        barChart.getAxisRight().setTextColor(Color.WHITE);
        barChart.getXAxis().setTextColor(Color.WHITE);

        barChart.invalidate();


        cardTotalLeeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity_telecaller.this, MainActivity_Telecaller_new.class);
                intent.putExtra("value", "leeds");
                startActivity(intent);
            }
        });

        getteLeed();

    }

    private ArrayList getDataSet() {
        ArrayList<BarDataSet> dataSets = null;
        ArrayList<BarEntry> valueSet1 = new ArrayList<>();
        BarEntry v1e1 = new BarEntry(110.000f, 0); // Jan
        valueSet1.add(v1e1);
        BarEntry v1e2 = new BarEntry(40.000f, 1); // Feb
        valueSet1.add(v1e2);
        BarEntry v1e3 = new BarEntry(60.000f, 2); // Mar
        valueSet1.add(v1e3);
        BarEntry v1e4 = new BarEntry(30.000f, 3); // Apr
        valueSet1.add(v1e4);
        BarEntry v1e5 = new BarEntry(90.000f, 4); // May
        valueSet1.add(v1e5);
        BarEntry v1e6 = new BarEntry(100.000f, 5); // Jun
        valueSet1.add(v1e6);

        BarDataSet barDataSet1 = new BarDataSet(valueSet1, "Brand 1");
//        barDataSet1.setColor(Color.rgb(0, 155, 0));
        barDataSet1.setColors(Utility.MATERIAL_COLORS);
        barDataSet1.setValueTextColor(Color.WHITE);
        barDataSet1.setValueTextSize(16f);

        dataSets = new ArrayList<>();
        dataSets.add(barDataSet1);

        return dataSets;
    }

    private ArrayList getXAxisValues() {
        ArrayList<String> xAxis = new ArrayList<>();
        xAxis.add("JAN");
        xAxis.add("FEB");
        xAxis.add("MAR");
        xAxis.add("APR");
        xAxis.add("MAY");
        xAxis.add("JUN");
        return xAxis;
    }


    private void getteLeed() {
        this.progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));
        this.leedRepository.readLeedsByStatus(Constant.STATUS_GENERATED, new CallBack() {
            @Override
            public void onSuccess(Object object) {

                if (object != null) {
                    leedsModelArrayList = (ArrayList) object;
                }
                int a = leedsModelArrayList.size();
                txtleedscount.setText(String.valueOf(a));
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
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        Fragment fragment = null;

        if (id == R.id.Leads) {
            Intent intent = new Intent(MainActivity_telecaller.this, MainActivity_Telecaller_new.class);
            intent.putExtra("value", "leeds");
            startActivity(intent);

        } else if (id == R.id.Reports) {
            fragment = new Telecaller_fragment_Reports();
        } else if (id == R.id.Calulator) {
            fragment = new LoanCalculatorFragement();
        } else if (id == R.id.Logout) {
            clearDataWithSignOut();
        }
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

        getSupportActionBar().setTitle(title);
    }

    public void updateNavigationHeader() {
        try {
            View header = navigationView.getHeaderView(0);
            TextView textViewAgentId = header.findViewById(R.id.textView_agent_id);
            TextView textViewUserName = header.findViewById(R.id.textView_user_name);
            TextView textViewEmailId = header.findViewById(R.id.text_view_email);
            TextView textViewMobileNumber = header.findViewById(R.id.textView_contact);
            final ImageView imageViewProfile = header.findViewById(R.id.imageView8);
            final ImageView ivProfileLayout = header.findViewById(R.id.ivProfileLayout);

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
                                        imageViewProfile.setImageBitmap(Utility.blur(MainActivity_telecaller.this, innerBitmap));
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
                    Intent intent = new Intent(MainActivity_telecaller.this, UpdateProfileActivity.class);
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
