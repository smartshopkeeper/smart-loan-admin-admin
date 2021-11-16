package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.ActionBar;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.MenuItem;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.SalesBankCustomersAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.Sales_Fragment_Checklist;
import com.smartloan.smtrick.smart_loan_admin_new.view.fragements.View_Sales_Received_Lead_Details_Fragment;

import java.util.ArrayList;

public class Sales_Bank_Customers_Activity extends AppCompatActivity implements Sales_Fragment_Checklist.OnFragmentInteractionListener {

    LeedsModel leedsModel;
    String BankName;
    LeedRepository leedRepository;
    ArrayList<LeedsModel> leedsModelArrayList;
    RecyclerView recycleCustomers;
    SalesBankCustomersAdapter salesBankCustomersAdapter;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales__bank_customers);


        setSupportActionBar((Toolbar) findViewById(R.id.toolbar1));
        assert getSupportActionBar() != null;   //null check
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        leedsModel = (LeedsModel) getIntent().getSerializableExtra(Constant.LEED_MODEL);
        Intent intent = getIntent();
        BankName = intent.getStringExtra("bank");

        leedRepository = new LeedRepositoryImpl();

        leedsModelArrayList = new ArrayList<>();

        recycleCustomers= (RecyclerView) findViewById(R.id.customers_recycle);
        recycleCustomers.setHasFixedSize(true);
        recycleCustomers.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        getCustomers(BankName);

    }

    private void getCustomers(String bankname) {
        leedRepository.readLeedsByBankName(bankname, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    leedsModelArrayList = (ArrayList<LeedsModel>) object;
                }
                salesBankCustomersAdapter = new SalesBankCustomersAdapter(getApplicationContext(),leedsModelArrayList);
                recycleCustomers.setAdapter(salesBankCustomersAdapter);

            }

            @Override
            public void onError(Object object) {

            }
        });
    }

    @Override
    public void onFragmentInteraction(String title) {

    }
}
