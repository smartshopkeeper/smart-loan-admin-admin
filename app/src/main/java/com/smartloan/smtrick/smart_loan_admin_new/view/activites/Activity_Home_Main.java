package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.AddBankFragement;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Add_CheckList_Fragement;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Add_Comission_Rules_Fragement;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Add_Target_Fragement;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Admin_Bills_Tab_Fragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Admin_Calander_Fragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Admin_Invoices_Tab_Fragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Admin_Leads_Fragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Admin_TodoList_Fragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Agents_Fragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Bank_Target_Fragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Leads_Summary_Fragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.LeedsTabsFragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.LoanCalculatorFragement;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.PL_Fragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.ReportsTabFragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Sales_Fragment;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.UserTabsFragment;

public class Activity_Home_Main extends AppCompatActivity
        implements
        OnFragmentInteractionListener,
        NavigationView.OnNavigationItemSelectedListener{

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__home__main);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setTitle("Calculator");

        Intent intent = getIntent();
        String value = intent.getStringExtra("value");
//        if (value.equalsIgnoreCase("leeds")) {
//            Intent intent1 = new Intent(Activity_Home_Main.this, MainActivity_Admin_new.class);
//            intent1.putExtra("value", "leeds");
//            startActivity(intent1);
//
//        } else if (value.equalsIgnoreCase("banks")) {
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.mainFrame, new AddBankFragement());
//            ft.commit();
//
//        } else if (value.equalsIgnoreCase("calc")) {
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.mainFrame, new LoanCalculatorFragement());
//            ft.commit();
//
//        } else if (value.equalsIgnoreCase("user")) {
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.mainFrame, new UserTabsFragment());
//            ft.commit();
//
//        } else if (value.equalsIgnoreCase("report")) {
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.mainFrame, new ReportsTabFragment());
//            ft.commit();
//
//        } else if (value.equalsIgnoreCase("comission")) {
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.mainFrame, new Add_Comission_Rules_Fragement());
//            ft.commit();
//
//        } else if (value.equalsIgnoreCase("bills")) {
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.mainFrame, new Admin_Bills_Tab_Fragment());
//            ft.commit();
//
//        } else if (value.equalsIgnoreCase("checklist")) {
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.mainFrame, new Add_CheckList_Fragement());
//            ft.commit();
//
//        }else if (value.equalsIgnoreCase("invoice")) {
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.mainFrame, new Admin_Invoices_Tab_Fragment());
//            ft.commit();
//
//        }else if (value.equalsIgnoreCase("target")) {
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.mainFrame, new Add_Target_Fragement());
//            ft.commit();
//
//        }else if (value.equalsIgnoreCase("todolist")) {
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.mainFrame, new Admin_TodoList_Fragment());
//            ft.commit();
//
//        }else if (value.equalsIgnoreCase("calender")) {
//            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
//            ft.replace(R.id.mainFrame, new Admin_Calander_Fragment());
//            ft.commit();
//
//        }

        if (value.equalsIgnoreCase("leeds")) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, new Admin_Leads_Fragment());
            ft.commit();
            getSupportActionBar().setTitle("Bills Approved");

        } else if (value.equalsIgnoreCase("agents")) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, new Agents_Fragment());
            ft.commit();
            getSupportActionBar().setTitle("Agents");

        } else if (value.equalsIgnoreCase("sales")) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, new Sales_Fragment());
            ft.commit();
            getSupportActionBar().setTitle("Sales Persons");

        }else if (value.equalsIgnoreCase("summary")) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, new Leads_Summary_Fragment());
            ft.commit();
            getSupportActionBar().setTitle("Leed Summary");

        }else if (value.equalsIgnoreCase("banktarget")) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, new Bank_Target_Fragment());
            ft.commit();
            getSupportActionBar().setTitle("Bank Targets");

        }else if (value.equalsIgnoreCase("pl")) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, new PL_Fragment());
            ft.commit();
            getSupportActionBar().setTitle("Profit and Loss");

        }
        else if (value.equalsIgnoreCase("addbank")) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, new AddBankFragement());
            ft.commit();
            getSupportActionBar().setTitle("Add Bank");

        }
        else if (value.equalsIgnoreCase("todolist")) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, new Admin_TodoList_Fragment());
            ft.commit();
            getSupportActionBar().setTitle("To Do List");

        }
        else if (value.equalsIgnoreCase("checklist")) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, new Add_CheckList_Fragement());
            ft.commit();
            getSupportActionBar().setTitle("CheckList");

        }
        else if (value.equalsIgnoreCase("bills")) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainFrame, new Admin_Bills_Tab_Fragment());
            ft.commit();
            getSupportActionBar().setTitle("Bills");

        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        return false;
    }

    @Override
    public void onFragmentInteraction(String title) {

    }
}
