package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.ViewLead_Sales_Activity;
import com.smartloan.smtrick.smart_loan_admin_new.view.holders.GetterSetterInvoice;

import java.util.ArrayList;

public class Sales_fragment_lead_tab_accepted extends Fragment {

    ArrayList<GetterSetterInvoice> searchResults = GetSearchResults();

    ListView listleads;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.tc_fragment_lead_tab_generatedlead, container, false);

        listleads = (ListView) view.findViewById(R.id.listleads);
        listleads.setAdapter(new CustumadapterReports(getActivity(), searchResults));
        listleads.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a, View v, int position, long id) {

                Object o = listleads.getItemAtPosition(position);


                listleads.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> a, View v, int position, long id) {
                        Intent i = new Intent(getActivity(), ViewLead_Sales_Activity.class);
                        startActivity(i);


                    }
                });

            }
        });


        return view;
    }

    private ArrayList<GetterSetterInvoice> GetSearchResults(){
        ArrayList<GetterSetterInvoice> results = new ArrayList<GetterSetterInvoice>();

        GetterSetterInvoice sr = new GetterSetterInvoice();
        sr.setName("2345");
        sr.setCityState("Mr Pratik Patel");
        sr.setPhone("India Buls");
        results.add(sr);

        sr = new GetterSetterInvoice();
        sr.setName("2345");
        sr.setCityState("Axis Bank");
        sr.setPhone("Mr Pratik Patel");
        results.add(sr);

        sr = new GetterSetterInvoice();
        sr.setName("2345");
        sr.setCityState("Axis Bank");
        sr.setPhone("Mr Pratik Patel");
        results.add(sr);

        sr = new GetterSetterInvoice();
        sr.setName("2345");
        sr.setCityState("Axis Bank");
        sr.setPhone("Mr Pratik Patel");
        results.add(sr);

        sr = new GetterSetterInvoice();
        sr.setName("2345");
        sr.setCityState("Axis Bank");
        sr.setPhone("Mr Pratik Patel");
        results.add(sr);

        sr = new GetterSetterInvoice();
        sr.setName("2345");
        sr.setCityState("Axis Bank");
        sr.setPhone("Mr Pratik Patel");
        results.add(sr);
        return results;
    }
}
