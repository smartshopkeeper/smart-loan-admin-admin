package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.models.Item;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.FoldingCellListAdapter;

import java.util.ArrayList;

public class BankAcceptedLeedsFragment extends Fragment implements AdapterView.OnItemSelectedListener {
    public BankAcceptedLeedsFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_generated_leeds, container, false);
        ListView theListView = view.findViewById(R.id.mainListView);
        final ArrayList<Item> items = Item.getTestingList();
        items.get(0).setRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        final FoldingCellListAdapter adapter = new FoldingCellListAdapter(this.getActivity(), items);
        adapter.setDefaultRequestBtnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        theListView.setAdapter(adapter);
        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
                // toggle clicked cell state
               /* ((FoldingCell) view).toggle(false);
                // register in adapter that state for selected cell is toggled
                adapter.registerToggle(pos);*/
            }
        });
        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
