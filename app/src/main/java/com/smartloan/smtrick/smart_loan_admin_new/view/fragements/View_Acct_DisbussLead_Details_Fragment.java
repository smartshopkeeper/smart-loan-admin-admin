package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.RecyclerListener.RecyclerTouchListener;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
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
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.BanksAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.SalesPersonAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.AGENT_PREFIX;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.GLOBAL_DATE_FORMATE;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.INV_PREFIX;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.SALES;
import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.STATUS_INVOICE_SENT;

public class View_Acct_DisbussLead_Details_Fragment extends Fragment {

    AppSharedPreference appSharedPreference;
    LeedRepository leedRepository;
    UserRepository UserRepository;
    LeedsModel leedsModel;
    ProgressDialogClass progressDialogClass;

    List<String> SalesPerson;
    List<User> userlist;

    TextView txtLeedId, txtCustomerName, txtLoanRequirement, txtAgent, txtLoanType;
    EditText edtComissionAmount;

    ArrayList<Bank> leedsArraylist;
    ArrayList<User> userArraylist;
    private List<String> listmaritalstatus;
    BanksAdapter adapter;
    SalesPersonAdapter useradapter;

    Button UpdateComission, btnSendInvoice;
    TextView txtApproved, txtDisbuss, txtPending, txtTDS;
    private DatabaseReference mDatabase;

    private User getUserModel(int position) {
        return userArraylist.get(userArraylist.size() - 1 - position);
    }

    private Bank getModel(int position) {
        return leedsArraylist.get(leedsArraylist.size() - 1 - position);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.view_acct_disbuss_lead_details, container, false);

        ((AppCompatActivity) getActivity()).setSupportActionBar((Toolbar) view.findViewById(R.id.toolbar));

        Bundle args = this.getArguments();
        if (args != null) {
            leedsModel = (LeedsModel) args.getSerializable(Constant.LEED_MODEL);

        }

        progressDialogClass = new ProgressDialogClass(getActivity());
        leedRepository = new LeedRepositoryImpl();
        UserRepository = new UserRepositoryImpl();
        appSharedPreference = new AppSharedPreference(getContext());
        mDatabase = Constant.INVOICE_TABLE_REF;

        SalesPerson = new ArrayList<>();
        leedsArraylist = new ArrayList<>();
        userArraylist = new ArrayList<>();
        listmaritalstatus = new ArrayList<>();
        getSalesperson();

        txtLeedId = (TextView) view.findViewById(R.id.txt_id_value);
        txtCustomerName = (TextView) view.findViewById(R.id.txtcnamevalue);
        txtLoanRequirement = (TextView) view.findViewById(R.id.txt_loan_requirement_value);
        txtAgent = (TextView) view.findViewById(R.id.txt_bp_value);
        txtLoanType = (TextView) view.findViewById(R.id.txt_loan_type_value);
        edtComissionAmount = (EditText) view.findViewById(R.id.edtcommisionamount);
        UpdateComission = (Button) view.findViewById(R.id.buttonupdate2);
        btnSendInvoice = (Button) view.findViewById(R.id.buttonsendinvoice);

        txtApproved = (TextView) view.findViewById(R.id.txtapprovedamtvalue);
        txtDisbuss = (TextView) view.findViewById(R.id.txtdisbussedamtvalue);
        txtPending = (TextView) view.findViewById(R.id.txtpandingamtvalue);
        txtTDS = (TextView) view.findViewById(R.id.txttdsamt);

        txtLeedId.setText(leedsModel.getLeedNumber());
        txtCustomerName.setText(leedsModel.getCustomerName());
        if (leedsModel.getExpectedLoanAmount() != null) {
            txtLoanRequirement.setText(leedsModel.getExpectedLoanAmount());
        } else {
            txtLoanRequirement.setText("Null");
        }
        txtAgent.setText(leedsModel.getAgentName());
        txtLoanType.setText(leedsModel.getLoanType());

        getdata();


        UpdateComission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateLeadDetails(leedsModel);
            }
        });

        btnSendInvoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int TotalCommission = Integer.parseInt(leedsModel.getApprovedLoan());
                int DisbussCommission = Integer.parseInt(leedsModel.getDisbusedLoanAmount());


                double Totalcom = (TotalCommission * 0.30) / 100;
                double Disbussmentcom = (DisbussCommission * 0.30) / 100;
                double TDSAmount = (Disbussmentcom * 10) / 100;
                double CommisionwithTDS = Disbussmentcom - TDSAmount;
                double BalancePayoutWithTdsAmount = Totalcom - Disbussmentcom;

                Date c = Calendar.getInstance().getTime();
                System.out.println("Current time => " + c);
                SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                String formattedDate = df.format(c);

                Invoice invoice = new Invoice();
                invoice.setCustomerName(leedsModel.getCustomerName());
                invoice.setInvoiceNumber(Utility.generateAgentId(INV_PREFIX));
                invoice.setInvoiceId(mDatabase.push().getKey());
                invoice.setLoanapprovedaamount(leedsModel.getApprovedLoan());
                invoice.setLoandisbussedamount(leedsModel.getDisbusedLoanAmount());
                invoice.setPendingdisbussedamount(leedsModel.getPendingLoanAmount());
                invoice.setTotalpayoutamount(String.valueOf(Totalcom));
                invoice.setBalancePayoutWithTdsAmount(String.valueOf(BalancePayoutWithTdsAmount));
                invoice.setPayOutOnDisbursementAmount(String.valueOf(Disbussmentcom));
                invoice.setPayoutPayableAfterTdsAmount(String.valueOf(CommisionwithTDS));
                invoice.setBalancePayout(String.valueOf(String.valueOf(BalancePayoutWithTdsAmount)));
                invoice.setLastPayoutPaidAmount(String.valueOf(CommisionwithTDS));
                invoice.setLastPayoutPaidDate(formattedDate);
                invoice.setAgentId(leedsModel.getAgentId());
                invoice.setStatus(STATUS_INVOICE_SENT);
                invoice.setDisbussmentDate(leedsModel.getDisbussmentDate());
                invoice.setLoanType(leedsModel.getLoanType());
                invoice.setTdsAmount(String.valueOf(TDSAmount));

                leedRepository.createInvoice1(invoice, new CallBack() {
                    @Override
                    public void onSuccess(Object object) {
                        Toast.makeText(getContext(), "Invoice Sent", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onError(Object object) {

                    }
                });
            }
        });

        return view;
    }

    private void updateLeadDetails(LeedsModel leedsModel) {
        leedsModel.setComissionamount(edtComissionAmount.getText().toString());

        updateLeed(leedsModel.getLeedId(), leedsModel.getLeedStatusMap());
    }

    private void updateLeed(String leedId, Map leedsMap) {
        progressDialogClass.showDialog(getString(R.string.loading), getString(R.string.PLEASE_WAIT));
        leedRepository.updateLeed(leedId, leedsMap, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                Toast.makeText(getContext(), "Comission Updated", Toast.LENGTH_SHORT).show();
                progressDialogClass.dismissDialog();
            }

            @Override
            public void onError(Object object) {
                progressDialogClass.dismissDialog();
                Context context = getContext();
                Utility.showLongMessage(context, context.getString(R.string.server_error));

            }
        });
    }

    private void getdata() {

        String approved = leedsModel.getApprovedLoan();
        String disbuss = leedsModel.getDisbusedLoanAmount();
        String pending = leedsModel.getPendingLoanAmount();

        if (approved != null) {
            txtApproved.setText(approved);
        } else {
            txtApproved.setText("Null");
        }
        if (disbuss != null) {
            txtDisbuss.setText(disbuss);
        } else {
            txtDisbuss.setText("Null");
        }
        if (pending != null) {
            txtPending.setText(pending);
        } else {
            txtPending.setText("Null");
        }

        String comission = leedsModel.getComissionamount();
        if (comission != null) {
            edtComissionAmount.setText(comission);

        } else {
            int commission = Integer.parseInt(leedsModel.getDisbusedLoanAmount());
            if (commission > 1000000 && commission <= 9000000) {
                double com = (commission * 0.30) / 100;
                double com1 = (com * 10) / 100;
                double com2 = com - com1;
                edtComissionAmount.setText(String.valueOf(com2));
            } else if (commission > 9000000 && commission <= 15000000) {
                double com = (commission * 0.40) / 100;
                double com1 = (com * 10) / 100;
                double com2 = com - com1;
                edtComissionAmount.setText(String.valueOf(com2));
            } else if (commission > 15000000 && commission <= 35000000) {
                double com = (commission * 0.55) / 100;
                double com1 = (com * 10) / 100;
                double com2 = com - com1;
                edtComissionAmount.setText(String.valueOf(com2));
            } else if (commission > 35000000) {
                double com = (commission * 0.65) / 100;
                double com1 = (com * 10) / 100;
                double com2 = com - com1;
                edtComissionAmount.setText(String.valueOf(com2));
            }
        }
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


    private void HideFields(RelativeLayout layout) {
        RelativeLayout.LayoutParams params1 = (RelativeLayout.LayoutParams) layout.getLayoutParams();
        params1.height = 0;
        layout.setLayoutParams(params1);
    }

    public void onItemSelected(AdapterView<?> adapterView, View arg1, int position, long id) {

    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

}
