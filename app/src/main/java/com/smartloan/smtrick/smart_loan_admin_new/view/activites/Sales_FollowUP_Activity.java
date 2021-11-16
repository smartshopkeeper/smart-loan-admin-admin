package com.smartloan.smtrick.smart_loan_admin_new.view.activites;

import android.content.Intent;
import android.graphics.Color;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin_new.Listners.OnCheckedClickListener;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.models.Expences;
import com.smartloan.smtrick.smart_loan_admin_new.models.FollowUp;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.SalesChecklistAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.TasksAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.LEED_MODEL;

public class Sales_FollowUP_Activity extends AppCompatActivity {

    TextView title;
    ImageView AdTask;
    LeedsModel leedsModel;
    RecyclerView recycleTasks;
    LeedRepository leedRepository;
    AppSharedPreference appSharedPreference;
    private List<FollowUp> followUpList;
    private List<FollowUp> followUpList1;
    TasksAdapter tasksAdapter;

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales__follow_up_);

//        setSupportActionBar((Toolbar) findViewById(R.id.toolbar1));
        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        leedsModel = (LeedsModel) getIntent().getSerializableExtra(Constant.LEED_MODEL);
        leedRepository = new LeedRepositoryImpl();
        appSharedPreference = new AppSharedPreference(this);

        followUpList = new ArrayList<>();
        followUpList1 = new ArrayList<>();

        title = (TextView) findViewById(R.id.title);
        title.setText(leedsModel.getCustomerName());
        AdTask = (ImageView) findViewById(R.id.add_task);
        recycleTasks = (RecyclerView) findViewById(R.id.recycler_view_tasks);
        recycleTasks.setHasFixedSize(true);
        recycleTasks.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        AdTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Sales_FollowUP_Activity.this, Sales_Add_Task_Activity.class);
                intent.putExtra(LEED_MODEL, leedsModel);
                startActivity(intent);
            }
        });
        getFollowUp();
    }

    private void getFollowUp() {

        String id = appSharedPreference.getAgeniId();
        followUpList1.clear();
        followUpList.clear();
        leedRepository.readFolloUpByLeedId(id, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {

                    followUpList = (List<FollowUp>) object;
                    for (FollowUp followup: followUpList) {
                        if (followup.getLeedNumber().equalsIgnoreCase(leedsModel.getLeedNumber())){
                            followUpList1.add(followup);
                        }
                    }
                }
                tasksAdapter = new TasksAdapter(getApplicationContext(), followUpList1);
                recycleTasks.setAdapter(tasksAdapter);
            }

            @Override
            public void onError(Object object) {

            }
        });

    }

    @Override
    protected void onRestart() {
        getFollowUp();
        super.onRestart();
    }
}
