package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_admin_new.models.Bank;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.models.User;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.UserRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.UserRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.UsersAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.ViewPagerAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.LOAN_TYPE_BALANCE_TRANSFER;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.LOAN_TYPE_HL;

public class Co_View_Lead_Details_Fragment extends Fragment implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    // NOTE: Removed Some unwanted Boiler Plate Codes
    private OnFragmentInteractionListener mListener;

    private TextView txtName,txtAddress, txtid, txtLoanType,txtLoanSubtype, txtLoanRequirement, txtInactive, txtActive, txtApointment,
            txtRejeted, txtSalesPerson1, txtReschedulReason, txtMeeting, txtBank,txtBranchName,
            txtHomeLoan, txtApplied, txtSanctioned, txtDisbursment, txtBalance, txtAgent, txtApplicationId, txtPartDiss, txtRejectReason;
    private ImageView imgcall, imgChat, imgEmail, imgEdi, imgWhatsapp, imgBank,imgAgentCall;
    private EditText edtNote;
    private Spinner spinnerBank, spinnerSalesPerson;
    private LinearLayout layoutActive, layoutInactive,layoutReject;
    private Button btnUpdate;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private LeedsModel leedsModel;
    private ArrayList<Bank> bankArrayList;
    private ArrayList<User> userArrayList;
    private ArrayList<String> bankList;
    private ArrayList<String> salesPersonList;

    private LeedRepository leedRepository;
    private UserRepository userRepository;

    private User Agent;

    public Co_View_Lead_Details_Fragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.co_view_generated_lead_details, container, false);
        // NOTE : We are calling the onFragmentInteraction() declared in the MainActivity
        // ie we are sending "Fragment 1" as title parameter when fragment1 is activated
        if (mListener != null) {
            mListener.onFragmentInteraction("Users");
        }

        Bundle args = this.getArguments();
        if (args != null) {
            leedsModel = (LeedsModel) args.getSerializable(Constant.LEED_MODEL);

        }

        leedRepository = new LeedRepositoryImpl();
        userRepository = new UserRepositoryImpl();

        String[] loanType = new String[]{"HOME LOAN", "LOAN AGAINST PROPERTY"};
        bankArrayList = new ArrayList<>();
        userArrayList = new ArrayList<>();
        bankList = new ArrayList<>();
        salesPersonList = new ArrayList<>();

        Fragment docsfragment = new Documents_Fragement();
        Bundle b = new Bundle();
        b.putString("leedId", leedsModel.getLeedId());
        docsfragment.setArguments(b);

        Fragment followfragment = new FollowUp_Fragement();
        Bundle f = new Bundle();
        f.putString("leedId", leedsModel.getLeedId());
        followfragment.setArguments(b);

        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(0);
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragement(new Activities_Fragement(), "Activities timeline");
        viewPagerAdapter.addFragement(new Social_Fragement(), "Social");
        viewPagerAdapter.addFragement(docsfragment, "Document files");
        viewPagerAdapter.addFragement(followfragment, "Follow Up");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);


        txtName = view.findViewById(R.id.txtcnamevalue);
        txtAddress = view.findViewById(R.id.txtaddressvalue);
        txtid = view.findViewById(R.id.txt_id_value);
        txtLoanType = view.findViewById(R.id.txt_loan_type_value);
        txtLoanSubtype = view.findViewById(R.id.txt_loan_subtype_value);
        txtLoanRequirement = view.findViewById(R.id.txt_loan_requirement_value);
//        txtMore = view.findViewById(R.id.txtMore);
        txtInactive = view.findViewById(R.id.txtInactive);
        txtActive = view.findViewById(R.id.txtActive);
        txtApointment = view.findViewById(R.id.txtApointment);
        txtRejeted = view.findViewById(R.id.txtRejected);
        txtSalesPerson1 = view.findViewById(R.id.txtSalesperson1);
        txtReschedulReason = view.findViewById(R.id.txtreschedul);
        txtMeeting = view.findViewById(R.id.txtMeeting);
        txtBank = view.findViewById(R.id.txtBank_Value);
        txtBranchName = view.findViewById(R.id.txtBank_BranchValue);

        txtHomeLoan = view.findViewById(R.id.txtHomeLoan_Value);
        txtApplied = view.findViewById(R.id.txtApplied_Value);
        txtSanctioned = view.findViewById(R.id.txtSanctioned_Value);
        txtDisbursment = view.findViewById(R.id.txtDisbursment_Value);
        txtBalance = view.findViewById(R.id.txtBalance_Value);
        txtAgent = view.findViewById(R.id.txtAgent_Value);
        txtApplicationId = view.findViewById(R.id.txtAppId_Value);
        txtPartDiss = view.findViewById(R.id.txtPartDis_Value);
        txtRejectReason = view.findViewById(R.id.txtRejectReason_Value);

        spinnerBank = view.findViewById(R.id.spinnerBank);
        spinnerSalesPerson = view.findViewById(R.id.txtSalesPerson_value);

        layoutActive = view.findViewById(R.id.layoutActive);
        layoutInactive = view.findViewById(R.id.layoutInactive);
        layoutReject = view.findViewById(R.id.layoutReject);

        btnUpdate = view.findViewById(R.id.btnUpdate);

        imgcall = view.findViewById(R.id.imgCall);
        imgChat = view.findViewById(R.id.imgChat);
        imgEmail = view.findViewById(R.id.imgEmail);
        imgEdi = view.findViewById(R.id.imgEdit);
        imgWhatsapp = view.findViewById(R.id.imgwhatsapp);
        imgBank = view.findViewById(R.id.imgBank);
        imgAgentCall = view.findViewById(R.id.imgAgentCall);

        edtNote = view.findViewById(R.id.edtAddNote);

        getBanks();
        getSalesPerson();
        getData();
        getAgent();

        imgcall.setOnClickListener(this);
        imgChat.setOnClickListener(this);
        imgEmail.setOnClickListener(this);
        imgEdi.setOnClickListener(this);
        imgWhatsapp.setOnClickListener(this);
//        txtMore.setOnClickListener(this);
        imgAgentCall.setOnClickListener(this);

        btnUpdate.setOnClickListener(this);
        layoutReject.setOnClickListener(this);

        return view;
    }

    private void getAgent() {
        userRepository.readUserByAgentId(leedsModel.getAgentId(), new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null){
                    Agent = (User) object;
                }
            }

            @Override
            public void onError(Object object) {

            }
        });
    }

    private void getSalesPerson() {
        userRepository.readUserByRole(Constant.SALES, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    userArrayList = (ArrayList<User>) object;

                    for (int i = 0; i < userArrayList.size(); i++) {
                        salesPersonList.add(userArrayList.get(i).getUserName());
                    }

                    ArrayAdapter<String> spinnerArrayAdapterSales = new ArrayAdapter(getContext(), R.layout.sppinner_layout_listitem, salesPersonList);
                    spinnerArrayAdapterSales.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                    spinnerSalesPerson.setAdapter(spinnerArrayAdapterSales);
                }
            }

            @Override
            public void onError(Object object) {

            }
        });
    }


    private void getBanks() {
        leedRepository.readAllBanks(new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    bankArrayList = (ArrayList<Bank>) object;

                    for (int i = 0; i < bankArrayList.size(); i++) {
                        bankList.add(bankArrayList.get(i).getBankname());
                    }

                    ArrayAdapter<String> spinnerArrayAdapterRecidential = new ArrayAdapter(getContext(), R.layout.sppinner_layout_listitem, bankList);
                    spinnerArrayAdapterRecidential.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
                    spinnerBank.setAdapter(spinnerArrayAdapterRecidential);

                    for (Bank bank : bankArrayList) {
                        if (leedsModel.getBanknName() != null) {
                            if (leedsModel.getBanknName().equalsIgnoreCase(bank.getBankname())) {
                                Picasso.with(getContext()).load(bank.getBanklogo()).placeholder(R.drawable.bank).into(imgBank);

                            }
                        }
                    }
                }
            }

            @Override
            public void onError(Object object) {

            }
        });
    }

    private void getData() {

        if (leedsModel.getStatus().equalsIgnoreCase(Constant.STATUS_REJECTED)) {
            layoutInactive.setBackgroundResource(R.drawable.boarder_green);
        } else {
            layoutActive.setBackgroundResource(R.drawable.boarder_green);
        }

        txtName.setText(leedsModel.getCustomerName());
        txtAddress.setText(leedsModel.getAddress());
        txtid.setText(leedsModel.getOccupation());
        txtLoanType.setText(leedsModel.getLoanType());
        if (leedsModel.getLoanType().equalsIgnoreCase(LOAN_TYPE_HL)) {
            txtLoanSubtype.setText(leedsModel.getHomeLoanType());
        } else if (leedsModel.getLoanType().equalsIgnoreCase(LOAN_TYPE_BALANCE_TRANSFER)) {
            txtLoanSubtype.setText(leedsModel.getBalanceTransferLoanType());
        }

        txtLoanRequirement.setText(leedsModel.getExpectedLoanAmount());
        txtSalesPerson1.setText(leedsModel.getSalesPerson());
        txtMeeting.setText(leedsModel.getAppointment());
        txtReschedulReason.setText(leedsModel.getRescheduledappointment());
        txtBank.setText(leedsModel.getBanknName());
        txtBranchName.setText(leedsModel.getBranchName());


        txtHomeLoan.setText(leedsModel.getHomeLoanAmount());
        txtApplied.setText(leedsModel.getExpectedLoanAmount());
        txtSanctioned.setText(leedsModel.getApprovedLoan());
        txtDisbursment.setText(leedsModel.getDisbusedLoanAmount());
        txtBalance.setText(leedsModel.getDisbusedLoanAmount());
        txtAgent.setText(leedsModel.getAgentName());
        txtApplicationId.setText(leedsModel.getLoginid());
        txtPartDiss.setText(leedsModel.getDisbusedLoanAmount());
        txtRejectReason.setText(leedsModel.getRejectionReason());

    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            // NOTE: This is the part that usually gives you the error
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    @Override
    public void onClick(View v) {
        if (v == btnUpdate) {
            updateLeed(leedsModel);
        }
        if (v == layoutReject) {
            updateLeed1(leedsModel);
        }
        if (v == imgcall) {
            int number = Integer.parseInt(leedsModel.getMobileNumber());
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        }
        if (v == imgcall) {
            int number = Integer.parseInt(Agent.getMobileNumber());
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + number));
            startActivity(intent);
        }
        if (v == imgChat) {
            int number = Integer.parseInt(leedsModel.getMobileNumber());
            Uri uri = Uri.parse("smsto:" + number);
            Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
            intent.putExtra("sms_body", "");
            startActivity(intent);
        }
        if (v == imgEdi) {

        }
        if (v == imgEmail) {

            String email = leedsModel.getEmail();
            String subject = "/* Your subject here */";
            String body = "/* Your body here */";
            String chooserTitle = "/* Your chooser title here */";

            Uri uri = Uri.parse("mailto:" + email)
                    .buildUpon()
                    .appendQueryParameter("subject", subject)
                    .appendQueryParameter("body", body)
                    .build();

            Intent emailIntent = new Intent(Intent.ACTION_SENDTO, uri);
            startActivity(Intent.createChooser(emailIntent, chooserTitle));
        }
        if (v == imgWhatsapp) {

        }
//        if (v == txtMore) {
//
//        }

    }

    private void updateLeed1(LeedsModel leedsModel) {
        leedsModel.setStatus(Constant.STATUS_REJECTED);

        update(leedsModel.getLeedId(), leedsModel.getLeedStatusMap());
    }

    private void updateLeed(LeedsModel leedsModel) {
        leedsModel.setBanknName(spinnerBank.getSelectedItem().toString());
        leedsModel.setSalesPerson(spinnerSalesPerson.getSelectedItem().toString());

        update(leedsModel.getLeedId(), leedsModel.getLeedStatusMap());
    }

    private void update(String leedId, Map leedStatusMap) {
        leedRepository.updateLeed(leedId, leedStatusMap, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                Toast.makeText(getContext(), "Leed Updated Successfully", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Object object) {

            }
        });
    }
}