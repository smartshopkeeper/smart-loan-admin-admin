package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.app.DatePickerDialog;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.exception.ExceptionUtil;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.AccountantInvoiceAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.AccountantLeedsAdapter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.CALANDER_DATE_FORMATE;

public class InvoiceReporsFragement extends Fragment {
    private RecyclerView recyclerView;
    AccountantInvoiceAdapter accountantInvoiceAdapter;

    private LeedRepository leedsRepository;
    ArrayList<LeedsModel> leedsArraylist;
    AccountantLeedsAdapter adapter;
    TextView totalleeds;
    EditText fromdate, todate;
    int fromYear, fromMonth, fromDay;
    int toYear, toMonth, toDay;
    long fromDate, toDate;

    public InvoiceReporsFragement() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_leeds_report, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_leeds);

        totalleeds = (TextView) view.findViewById(R.id.textviewtotalleads);
        fromdate = (EditText) view.findViewById(R.id.edittextfromdate);
        todate = (EditText) view.findViewById(R.id.edittexttodate);

        leedsRepository = new LeedRepositoryImpl();
        leedsArraylist = new ArrayList<>();

        getInvoiceReport();

        setFromDateClickListner();
        setToDateClickListner();
//        recyclerView.setHasFixedSize(true);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
//       /* recyclerView.addItemDecoration(new DividerItemDecoration(getContext(),
//                DividerItemDecoration.VERTICAL));*/
//        accountantInvoiceAdapter = new AccountantInvoiceAdapter(Invoice.getPaidInvoices());
//        recyclerView.setAdapter(accountantInvoiceAdapter);
//        onClickListner();
        return view;
    }

    private void getInvoiceReport() {
        leedsRepository.readAllInvoices(new CallBack() {
            @Override
            public void onSuccess(Object object) {

                if (object != null) {
                    leedsArraylist = (ArrayList<LeedsModel>) object;
                }
                adapter = new AccountantLeedsAdapter(leedsArraylist);

                //adding adapter to recyclerview
                recyclerView.setAdapter(adapter);
                // CatalogAdapter catalogAdapter = new CatalogAdapter(catalogList);
                recyclerView.setHasFixedSize(true);
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                setReports(leedsArraylist);
            }

            @Override
            public void onError(Object object) {

            }
        });
    }


    private void setFromCurrentDate() {
        Calendar mcurrentDate = Calendar.getInstance();
        fromYear = mcurrentDate.get(Calendar.YEAR);
        fromMonth = mcurrentDate.get(Calendar.MONTH);
        fromDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);
    }

    private void setFromDateClickListner() {
        setFromCurrentDate();
        fromdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog mDatePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        Calendar myCalendar = Calendar.getInstance();
                        myCalendar.set(Calendar.YEAR, selectedyear);
                        myCalendar.set(Calendar.MONTH, selectedmonth);
                        myCalendar.set(Calendar.DAY_OF_MONTH, selectedday);
                        SimpleDateFormat sdf = new SimpleDateFormat(CALANDER_DATE_FORMATE, Locale.FRANCE);
                        String formatedDate = sdf.format(myCalendar.getTime());
                        fromdate.setText(formatedDate);
                        fromDay = selectedday;
                        fromMonth = selectedmonth;
                        fromYear = selectedyear;
                        fromDate = Utility.convertFormatedDateToMilliSeconds(formatedDate, CALANDER_DATE_FORMATE);
                        filterByDate(leedsArraylist);
                    }
                }, fromYear, fromMonth, fromDay);
                mDatePicker.show();
            }
        });
    }

    private void setToCurrentDate() {
        toDate = System.currentTimeMillis();
        Calendar mcurrentDate = Calendar.getInstance();
        toYear = mcurrentDate.get(Calendar.YEAR);
        toMonth = mcurrentDate.get(Calendar.MONTH);
        toDay = mcurrentDate.get(Calendar.DAY_OF_MONTH);
    }

    private void setToDateClickListner() {
        setToCurrentDate();
        todate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog mDatePicker = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    public void onDateSet(DatePicker datepicker, int selectedyear, int selectedmonth, int selectedday) {
                        Calendar myCalendar = Calendar.getInstance();
                        myCalendar.set(Calendar.YEAR, selectedyear);
                        myCalendar.set(Calendar.MONTH, selectedmonth);
                        myCalendar.set(Calendar.DAY_OF_MONTH, selectedday);
                        SimpleDateFormat sdf = new SimpleDateFormat(CALANDER_DATE_FORMATE, Locale.FRANCE);
                        todate.setText(sdf.format(myCalendar.getTime()));
                        toDay = selectedday;
                        toMonth = selectedmonth;
                        toYear = selectedyear;
                        toDate = myCalendar.getTimeInMillis();
                        filterByDate(leedsArraylist);
                    }
                }, toYear, toMonth, toDay);
                mDatePicker.show();
            }
        });
    }

    private void filterByDate(ArrayList<LeedsModel> leedsModelArrayList) {
        try {
            ArrayList<LeedsModel> filterArrayList = new ArrayList<>();
            if (leedsModelArrayList != null) {
                if (fromDate > 0) {
                    for (LeedsModel leedsModel : leedsModelArrayList) {
                        if (leedsModel.getCreatedDateTimeLong() >= fromDate && leedsModel.getCreatedDateTimeLong() <= toDate) {
                            filterArrayList.add(leedsModel);
                        }
                    }
                } else {
                    for (LeedsModel leedsModel : leedsModelArrayList) {
                        if (leedsModel.getCreatedDateTimeLong() <= toDate) {
                            filterArrayList.add(leedsModel);
                        }
                    }
                }
            }
            serAdapter(filterArrayList);
        } catch (Exception e) {
            ExceptionUtil.logException(e);
        }
    }

    private void serAdapter(ArrayList<LeedsModel> reportmodels) {
        setReports(reportmodels);
        if (reportmodels != null) {
            if (adapter == null) {
                adapter = new AccountantLeedsAdapter(reportmodels);
                recyclerView.setAdapter(adapter);
                //onClickListner();
            } else {
                ArrayList<LeedsModel> leedsModelArrayList = new ArrayList<>();
                leedsModelArrayList.addAll(reportmodels);
                adapter.reload(leedsModelArrayList);
                recyclerView.setAdapter(adapter);
            }
        }
    }
//    private void onClickListner() {
//        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), recyclerView, new RecyclerTouchListener.ClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//                showDetailDialog();
//            }
//
//            @Override
//            public void onLongClick(View view, int position) {
//
//            }
//        }));
//    }

//    private void showDetailDialog() {
//        final Dialog dialog = new Dialog(getActivity());
//        dialog.setContentView(R.layout.invoicedialog);
//        dialog.setTitle("Title...");
//        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonaccept);
//        dialogButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dialog.dismiss();
//            }
//        });
//
//        dialog.show();
//    }

    private void setReports(ArrayList<LeedsModel> leedsModelArrayList) {
        int approvedCount = 0, rejectedCount = 0;
        double totalPayout = 0;
        if (leedsModelArrayList != null) {
            for (LeedsModel leedsModel :
                    leedsModelArrayList) {

                approvedCount++;
            }//end of for

            totalleeds.setText("Total:" +String.valueOf(approvedCount));
            // fragmentReportBinding.textViewPayoutAmount.setText(String.valueOf(totalPayout));
        } else {

            totalleeds.setText("Total : 0");
            //fragmentReportBinding.textViewPayoutAmount.setText("0.0");
        }
    }
}
