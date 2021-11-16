package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.content.Intent;
import androidx.databinding.DataBindingUtil;
import android.graphics.Color;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.Snackbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.ItemTouchHelper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Toast;

import com.smartloan.smtrick.smart_loan_admin_new.Listners.SwipeableRecyclerViewTouchListener;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.RecyclerListener.RecyclerTouchListener;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.callback.SwipeToDeleteCallback;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.SalesFragmentLeadTabReceivedleadBinding;
import com.smartloan.smtrick.smart_loan_admin_new.databinding.TcFragmentLeadTabGeneratedleadBinding;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.singleton.AppSingleton;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.Sales_Update_Activity;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.Sales_View_Lead_Details_Activity;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.Sals_Bank_Submitted_Activity;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.SalesLeedsAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.SalesLeedsReceivedAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.dialog.ProgressDialogClass;

import java.util.ArrayList;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.LEED_MODEL;

public class Sales_fragment_lead_tab_recived extends Fragment {

    SalesLeedsReceivedAdapter telecallerLeedsAdapter;
    LeedRepository leedRepository;
    AppSingleton appSingleton;
    ProgressDialogClass progressDialogClass;
    AppSharedPreference appSharedPreference;
    SalesFragmentLeadTabReceivedleadBinding salesFragmentLeadTabGeneratedleadBinding;
    int fromYear, fromMonth, fromDay;
    int toYear, toMonth, toDay;
    long fromDate, toDate;
    String name;
    ArrayList<LeedsModel> leedsModelArrayList;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        if (salesFragmentLeadTabGeneratedleadBinding == null) {
            salesFragmentLeadTabGeneratedleadBinding = DataBindingUtil.inflate(inflater, R.layout.sales_fragment_lead_tab_receivedlead, container, false);
            progressDialogClass = new ProgressDialogClass(getActivity());
            appSingleton = AppSingleton.getInstance(getActivity());
            leedRepository = new LeedRepositoryImpl();
            appSharedPreference = new AppSharedPreference(getActivity());
            salesFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.setHasFixedSize(true);
            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
            salesFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.setLayoutManager(layoutManager);
            salesFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.setItemAnimator(new DefaultItemAnimator());
            salesFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.addItemDecoration(new DividerItemDecoration(getContext(),
                    DividerItemDecoration.VERTICAL));

            name = appSharedPreference.getUserName();
            getteLeed();
        }
        return salesFragmentLeadTabGeneratedleadBinding.getRoot();
    }

    private LeedsModel getModel(int position) {
        return leedsModelArrayList.get(leedsModelArrayList.size() - 1 - position);
    }

    private void getteLeed() {
        progressDialogClass.showDialog(this.getString(R.string.loading), this.getString(R.string.PLEASE_WAIT));
        leedRepository.readLeedsByName(name, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {

                    leedsModelArrayList = (ArrayList<LeedsModel>) object;
                    serAdapter(leedsModelArrayList);
                }
                progressDialogClass.dismissDialog();
            }

            @Override
            public void onError(Object object) {
                progressDialogClass.dismissDialog();
                Utility.showLongMessage(getActivity(), getString(R.string.server_error));
            }
        });
    }


    private void onClickListner() {
        salesFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.addOnItemTouchListener(new RecyclerTouchListener(getActivity().getApplicationContext(), salesFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds, new RecyclerTouchListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                LeedsModel leedsModel = getModel(position);
                Intent intent = new Intent(getActivity(), Sales_View_Lead_Details_Activity.class);
                intent.putExtra(LEED_MODEL, leedsModel);
                startActivity(intent);

//                Bundle bundle = new Bundle();
//                bundle.putSerializable(Constant.LEED_MODEL, leedsModel);// Put anything what you want
//                View_Sales_Received_Lead_Details_Fragment fragment2 = new View_Sales_Received_Lead_Details_Fragment();
//                fragment2.setArguments(bundle);
//                FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
//                ft.replace(R.id.container,  fragment2);
//                ft.commit();
            }

            @Override
            public void onLongClick(View view, int position) {
            }

        }));
    }


    private void serAdapter(ArrayList<LeedsModel> leedsModels) {
        if (leedsModels != null) {
            if (telecallerLeedsAdapter == null) {
                telecallerLeedsAdapter = new SalesLeedsReceivedAdapter(getActivity(), leedsModels);
                salesFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.setAdapter(telecallerLeedsAdapter);

                SwipeableRecyclerViewTouchListener swipeTouchListener =
                        new SwipeableRecyclerViewTouchListener( salesFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds,
                                new SwipeableRecyclerViewTouchListener.SwipeListener() {

                                    @Override
                                    public boolean canSwipeLeft(int position) {
                                        return false;
                                    }

                                    @Override
                                    public boolean canSwipeRight(int position) {
                                        return true;
                                    }

                                    @Override
                                    public void onDismissedBySwipeLeft(RecyclerView recyclerView, int[] reverseSortedPositions) {
                                        for (int position : reverseSortedPositions) {

                                        }
                                        telecallerLeedsAdapter.notifyDataSetChanged();
                                    }

                                    @Override
                                    public void onDismissedBySwipeRight(RecyclerView recyclerView, int[] reverseSortedPositions) {
                                        for (int position : reverseSortedPositions) {

                                            final LeedsModel item = telecallerLeedsAdapter.getData().get(getItemCount()-1-position);
                                            telecallerLeedsAdapter.MakeCall(item);
                                        }
                                        telecallerLeedsAdapter.notifyDataSetChanged();
                                    }
                                });

                salesFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds.addOnItemTouchListener(swipeTouchListener);

//                enableSwipeToDeleteAndUndo();
                onClickListner();
            } else {
                ArrayList<LeedsModel> leedsModelArrayList = new ArrayList<>();
                leedsModelArrayList.addAll(leedsModels);
                telecallerLeedsAdapter.reload(leedsModelArrayList);
            }
        }
    }

    public int getItemCount() {
        return leedsModelArrayList.size();
    }

//    private void enableSwipeToDeleteAndUndo() {
//        SwipeToDeleteCallback swipeToDeleteCallback = new SwipeToDeleteCallback(getContext()) {
//            @Override
//            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
//
//
//                final int position = viewHolder.getAdapterPosition();
//                final LeedsModel item = telecallerLeedsAdapter.getData().get(position);
//
//                telecallerLeedsAdapter.MakeCall(item);
//                getteLeed();
//
//            }
//        };
//
//        ItemTouchHelper itemTouchhelper = new ItemTouchHelper(swipeToDeleteCallback);
//        itemTouchhelper.attachToRecyclerView(salesFragmentLeadTabGeneratedleadBinding.recyclerViewLeeds);
//    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // Do something that differs the Activity's menu here
        menu.clear();
        inflater.inflate(R.menu.menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_banksubmit:
                Intent intent = new Intent(getContext(), Sals_Bank_Submitted_Activity.class);
                startActivity(intent);
                // Not implemented here
                return false;

            default:
                break;
        }

        return false;
    }

}
