package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.constants.Constant;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;

public class DisplaySettingsFragment extends Fragment {

    LeedsModel invoice;
//    TextView name;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_display_settings, container, false);

//        name = (TextView) rootView.findViewById(R.id.name);
        Bundle args = this.getArguments();
        if (args != null) {
            invoice = (LeedsModel) args.getSerializable(Constant.LEED_MODEL);

        }
        try {
//            name.setText(invoice.getCustomerName());
        }catch (Exception e){}

        return rootView;
    }
}
