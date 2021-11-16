package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.google.firebase.database.DatabaseReference;
import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_admin_new.models.User;
import com.smartloan.smtrick.smart_loan_admin_new.repository.UserRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.UserRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.utilities.Utility;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.UsersAdapter;

import java.util.ArrayList;
import java.util.List;

public class UsersFragement extends Fragment implements AdapterView.OnItemSelectedListener {
    // NOTE: Removed Some unwanted Boiler Plate Codes
    private OnFragmentInteractionListener mListener;
    private DatabaseReference mdataRefuser;
    private UserRepository userRepository;
    private List<User> userList;

    public UsersFragement() {
    }

//    ArrayList<UserModel> searchResults = GetSearchResults();
    RecyclerView listView;
    UsersAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_users_fragement, container, false);
        // NOTE : We are calling the onFragmentInteraction() declared in the MainActivity
        // ie we are sending "Fragment 1" as title parameter when fragment1 is activated
        if (mListener != null) {
            mListener.onFragmentInteraction("Users");
        }
        userRepository = new UserRepositoryImpl(getActivity());
        userList = new ArrayList<>();
        listView = (RecyclerView) view.findViewById(R.id.recycler_view_users);

       readUsers();
        return view;
    }

    private void readUsers() {
        userRepository.readUserByStatus("Active", new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {
                    userList = (ArrayList<User>) object;


                }
                adapter = new UsersAdapter(getActivity(), userList,false);

                //adding adapter to recyclerview
                listView.setAdapter(adapter);
                // CatalogAdapter catalogAdapter = new CatalogAdapter(catalogList);
                listView.setHasFixedSize(true);
                listView.setLayoutManager(new LinearLayoutManager(getContext()));
            }

            @Override
            public void onError(Object object) {
                Utility.showLongMessage(getActivity(), getString(R.string.server_error));
            }
        });
    }

//    private ArrayList<UserModel> GetSearchResults() {
//        ArrayList<UserModel> results = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            if (i % 2 == 0) {
//                UserModel sr = new UserModel();
//                sr.setName("Mr Pratik Patel");
//                sr.setType("Accountant");
//                sr.setMobileNumber("7030648899");
//                sr.setUserStatus("Active");
//                results.add(sr);
//            } else {
//                UserModel sr = new UserModel();
//                sr.setName("Mr Sagar Mule");
//                sr.setType("TelleCaller");
//                sr.setMobileNumber("7030648899");
//                sr.setUserStatus("Deactive");
//                results.add(sr);
//            }
//        }
//
//        return results;
//    }

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
}