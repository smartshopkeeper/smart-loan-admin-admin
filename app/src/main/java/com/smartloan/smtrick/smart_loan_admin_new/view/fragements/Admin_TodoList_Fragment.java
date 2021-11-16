package com.smartloan.smtrick.smart_loan_admin_new.view.fragements;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.smartloan.smtrick.smart_loan_admin_new.R;
import com.smartloan.smtrick.smart_loan_admin_new.callback.CallBack;
import com.smartloan.smtrick.smart_loan_admin_new.interfaces.OnFragmentInteractionListener;
import com.smartloan.smtrick.smart_loan_admin_new.models.FollowUp;
import com.smartloan.smtrick.smart_loan_admin_new.models.LeedsModel;
import com.smartloan.smtrick.smart_loan_admin_new.models.TodoList;
import com.smartloan.smtrick.smart_loan_admin_new.preferences.AppSharedPreference;
import com.smartloan.smtrick.smart_loan_admin_new.repository.LeedRepository;
import com.smartloan.smtrick.smart_loan_admin_new.repository.impl.LeedRepositoryImpl;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.Admin_Add_Task_Activity;
import com.smartloan.smtrick.smart_loan_admin_new.view.activites.Sales_Add_Task_Activity;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.TasksAdapter;
import com.smartloan.smtrick.smart_loan_admin_new.view.adapters.TodoAdapter;

import java.util.ArrayList;
import java.util.List;

import static com.smartloan.smtrick.smart_loan_admin_new.constants.Constant.LEED_MODEL;

public class Admin_TodoList_Fragment extends Fragment implements AdapterView.OnItemSelectedListener {
    // NOTE: Removed Some unwanted Boiler Plate Codes
    private OnFragmentInteractionListener mListener;

    TextView title;
    ImageView AdTask;
    LeedsModel leedsModel;
    RecyclerView recycleTasks;
    LeedRepository leedRepository;
    AppSharedPreference appSharedPreference;
    private List<TodoList> followUpList;
    private List<TodoList> followUpList1;
    TodoAdapter todoAdapter;
    private ProgressDialog progress;

    public Admin_TodoList_Fragment() {
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_admin__todolist_, container, false);
        // NOTE : We are calling the onFragmentInteraction() declared in the MainActivity
        // ie we are sending "Fragment 1" as title parameter when fragment1 is activated
        if (mListener != null) {
            mListener.onFragmentInteraction("Approved");

            setHasOptionsMenu(true);

            leedRepository = new LeedRepositoryImpl();
            appSharedPreference = new AppSharedPreference(getContext());

            followUpList = new ArrayList<>();
            followUpList1 = new ArrayList<>();

            recycleTasks = (RecyclerView) view.findViewById(R.id.recycler_view_tasks);
            recycleTasks.setHasFixedSize(true);
            recycleTasks.setLayoutManager(new LinearLayoutManager(getContext()));

            new GetWeather().execute();
        }

        return view;
    }

    private void getTodoList() {

        String id = appSharedPreference.getAgeniId();
        followUpList1.clear();
        followUpList.clear();
        leedRepository.readTodolistByLeedId(id, new CallBack() {
            @Override
            public void onSuccess(Object object) {
                if (object != null) {

                    followUpList = (List<TodoList>) object;
                    todoAdapter = new TodoAdapter(getContext(), followUpList);
                    recycleTasks.setAdapter(todoAdapter);

                }

            }

            @Override
            public void onError(Object object) {

            }
        });

    }

    private class GetWeather extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progress=new ProgressDialog(getContext());
            progress.setMessage("Downloading Todo List");
            progress.setProgressStyle(ProgressDialog.STYLE_SPINNER);

        }

        @Override
        protected Void doInBackground(Void... arg0) {

            getTodoList();

            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);
            if(progress.isShowing())
            {
                progress.dismiss();
            }

        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        // TODO Add your menu entries here
//        getActivity().getMenuInflater().inflate(R.menu.main, menu);

        inflater.inflate(R.menu.main_add, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_add:
                Intent intent = new Intent(getContext(), Admin_Add_Task_Activity.class);
                    intent.putExtra(LEED_MODEL, leedsModel);
                    startActivity(intent);
                // Not implemented here
                return false;

            default:
                break;
        }

        return false;
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

}