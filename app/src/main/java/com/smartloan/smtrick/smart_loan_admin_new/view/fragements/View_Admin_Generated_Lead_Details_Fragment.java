package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.RecyclerListener.RecyclerTouchListener;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.models.Bank;
import com.smartloan.smtrick.smart_loan_admin_new.models.CheckList;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.models.User;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.UserRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.UserRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.BanksAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.CheckListAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.SalesPersonAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.ViewPagerAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.SALES;

public class View_Admin_Generated_Lead_Details_Fragment extends Fragment {


    AppSharedPreference appSharedPreference;

    LeedRepository leedRepository;
    UserRepository UserRepository;
    LeedsModel leedsModel;
    ProgressDialogClass progressDialogClass;

    List<String> SalesPerson;
    List<User> userlist;



    TextView txtCustomerName,txtLeedId,txtAgent,txtLoanType,txtLoanRequirement;
    TextView txtEdit;

    ArrayList<Bank> leedsArraylist;
    ArrayList<User> userArraylist;


    ArrayList<CheckList> checklistArraylist;


    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.view_admin_generated_lead_details, container, false);

        ((AppCompatActivity) getActivity()).setSupportActionBar((Toolbar) view.findViewById(R.id.toolbar));

        Bundle args = this.getArguments();
        if (args != null) {
            leedsModel = (LeedsModel) args.getSerializable(Constant.LEED_MODEL);

        }

        progressDialogClass = new ProgressDialogClass(getActivity());
        leedRepository = new LeedRepositoryImpl();
        UserRepository = new UserRepositoryImpl();
        appSharedPreference = new AppSharedPreference(getContext());

        SalesPerson = new ArrayList<>();
        leedsArraylist = new ArrayList<>();
        userArraylist = new ArrayList<>();
        checklistArraylist = new ArrayList<>();
        getSalesperson();

        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(0);
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragement(new Add_fragment_lead_tab_generated(), "Activities");
        viewPagerAdapter.addFragement(new Add_fragment_Admin_lead_tab_verified(), "Documents");
        viewPagerAdapter.addFragement(new Add_fragment_Admin_lead_tab_approved(), "Follow Up");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);

        txtLeedId = (TextView) view.findViewById(R.id.txt_id_value);
        txtCustomerName = (TextView) view.findViewById(R.id.txtcnamevalue);
        txtLoanRequirement = (TextView) view.findViewById(R.id.txt_loan_requirement_value);
        txtAgent = (TextView) view.findViewById(R.id.txt_bp_value);
        txtLoanType = (TextView) view.findViewById(R.id.txt_loan_type_value);
//        txtEdit = view.findViewById(R.id.txtEditvalue);
//        String html = "<u>Edit</u>";
//        txtEdit.setText(Html.fromHtml(html));

        txtLeedId.setText(leedsModel.getLeedNumber());
        txtCustomerName.setText(leedsModel.getCustomerName());
        if (leedsModel.getExpectedLoanAmount() != null) {
            txtLoanRequirement.setText(leedsModel.getExpectedLoanAmount());
        } else {
            txtLoanRequirement.setText("Null");
        }
        txtAgent.setText(leedsModel.getAgentName());
        txtLoanType.setText(leedsModel.getLoanType());

        return view;
    }


    private void getSalesperson() {
        UserRepository.readsalesperson(SALES, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {

                    userlist = (ArrayList<User>) object;
                    for (int i = 0; i < userlist.size(); i++) {
                        SalesPerson.add(userlist.get(i).getUserName());

                    }

                }
            }

            @Override
            public void onError(Object object) {

            }
        });
    }


    public void onItemSelected(AdapterView<?> adapterView, View arg1, int position, long id) {
//        sploantype = spinloantype.getSelectedItem().toString();
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

}
