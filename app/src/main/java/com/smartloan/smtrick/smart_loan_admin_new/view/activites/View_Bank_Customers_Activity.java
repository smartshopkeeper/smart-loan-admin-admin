package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import com.google.firebase.database.ValueEventListener;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.BankCustomerAdapter;

import java.util.ArrayList;
import java.util.List;

public class View_Bank_Customers_Activity extends AppCompatActivity {

    private RecyclerView subcatalogRecycler;
    private List<String> subcatalogList;
    private List<String> subcatalogList1;
    private List<String> images;
    private String name;
    LeedsModel invoice;
    BankCustomerAdapter bankCustomerAdapter;
    private ProgressBar subCatalogProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__bank__customers_);

        subCatalogProgress = (ProgressBar) findViewById(R.id.Sub_progress);
        subCatalogProgress.setVisibility(View.VISIBLE);

        subcatalogRecycler = (RecyclerView) findViewById(R.id.subcatalog_recycle);
        subcatalogList = new ArrayList<>();
        subcatalogList1 = new ArrayList<>();

        Intent intent = getIntent();
//        name = intent.getStringExtra("itemName");
        invoice = (LeedsModel) intent.getSerializableExtra("invoice");
        name = invoice.getBanknName();

//        getSupportActionBar().setTitle("Customers");
//        assert getSupportActionBar() != null;   //null check
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Query query3 = FirebaseDatabase.getInstance().getReference("leeds")
                .orderByChild("banknName")
                .equalTo(name);
        query3.addValueEventListener(valueEventListener);

    }

    ValueEventListener valueEventListener = new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            subcatalogList.clear();
            if (dataSnapshot.exists()) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    LeedsModel subproducts1 = snapshot.getValue(LeedsModel.class);
                    subcatalogList.add(subproducts1.getCustomerName());

                    int size = subcatalogList.size()-1;
                    subcatalogList1.clear();
                    for(int i=size;i>=0;i--){
                        subcatalogList1.add(subcatalogList.get(i));
                    }
                }
                // subCatalogAdapter.notifyDataSetChanged();
            }
            bankCustomerAdapter = new BankCustomerAdapter(View_Bank_Customers_Activity.this, subcatalogList1);
            subcatalogRecycler.setHasFixedSize(true);
            subcatalogRecycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            subcatalogRecycler.setAdapter(bankCustomerAdapter);
            subCatalogProgress.setVisibility(View.GONE);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };

}
