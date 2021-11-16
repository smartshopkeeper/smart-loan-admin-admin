package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.ViewPagerAdapter;

public class LeedsTabsFragment extends Fragment {
    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    public LeedsTabsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user_tabs, container, false);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(0);
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragement(new Add_fragment_lead_tab_generated(), "Generated");
        viewPagerAdapter.addFragement(new Add_fragment_Admin_lead_tab_verified(), "Verified");
        viewPagerAdapter.addFragement(new Add_fragment_Admin_lead_tab_approved(), "Approved");
        viewPagerAdapter.addFragement(new Add_fragment_Admin_lead_tab_rejected(), "Rejected");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }
}

