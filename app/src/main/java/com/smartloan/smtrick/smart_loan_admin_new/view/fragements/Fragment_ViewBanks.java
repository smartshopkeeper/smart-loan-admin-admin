package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.CatalogAdapter;

import java.util.ArrayList;
import java.util.List;


public class Fragment_ViewBanks extends Fragment {

    private RecyclerView catalogRecycler;
    private DatabaseReference mdataRefpatient;
    private List<LeedsModel> catalogList;
    private List<LeedsModel> catalogList1;
    private ProgressBar catalogprogress;
    private RecyclerView.Adapter adapter;

    // int[] animationList = {R.anim.layout_animation_up_to_down};
    int i = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_viewbanks, container, false);

        // getActivity().getActionBar().setTitle("Products");
        catalogprogress = (ProgressBar) view.findViewById(R.id.catalog_progress);
        catalogRecycler = (RecyclerView) view.findViewById(R.id.catalog_recycle);
        catalogList = new ArrayList<>();
        catalogList1 = new ArrayList<>();

        catalogprogress.setVisibility(View.VISIBLE);
        mdataRefpatient = FirebaseDatabase.getInstance().getReference("leeds");
        mdataRefpatient.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                catalogList.clear();
                for (DataSnapshot mainproductSnapshot : dataSnapshot.getChildren()) {

                    LeedsModel mainProducts = mainproductSnapshot.getValue(LeedsModel.class);
                    if (mainProducts.getBanknName() != null && !mainProducts.getBanknName().equalsIgnoreCase("")) {
                        catalogList.add(mainProducts);

                    }
                }

                for (LeedsModel event : catalogList) {
                    boolean isFound = false;
                    // check if the event name exists in noRepeat
                    for (LeedsModel e : catalogList1) {
                        if (event.getBanknName() != null) {
                            if (e.getBanknName().equals(event.getBanknName()) || (e.equals(event))) {
                                isFound = true;
                                break;
                            }
                        }
                    }

                    if (!isFound) catalogList1.add(event);
                }

                adapter = new CatalogAdapter(getActivity(), catalogList1);

                //adding adapter to recyclerview
                catalogRecycler.setAdapter(adapter);
                // CatalogAdapter catalogAdapter = new CatalogAdapter(catalogList);
                catalogRecycler.setHasFixedSize(true);
                catalogRecycler.setLayoutManager(new LinearLayoutManager(getContext()));
                //catalogRecycler.setAdapter(catalogAdapter);
                catalogprogress.setVisibility(View.GONE);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        return view;
    }


}
