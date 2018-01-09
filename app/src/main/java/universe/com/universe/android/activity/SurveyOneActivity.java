package universe.com.universe.android.activity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import universe.com.universe.android.R;
import universe.com.universe.android.adapter.StateAdapter;
import universe.com.universe.android.dao.State;
import universe.com.universe.android.utils.RecyclerTouchListener;


/**
 * Created by gaurav.pandey on 09-01-2018.
 */

public class SurveyOneActivity extends BaseActivity {

    EditText editTextDate;
    EditText editTextState;
    DatePickerDialog datePickerDialog;
    RecyclerView recyclerViewSearchList;
    EditText editTextSearch;
    ArrayList<State> stateLists;
    LinearLayoutManager linearLayoutManager;
    StateAdapter stateAdapter;
     Dialog dialog;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey1);
        initialization();
        setUpElements();
    }


    private void setUpElements() {
        editTextDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                int mMonth = c.get(Calendar.MONTH); // current month
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                datePickerDialog = new DatePickerDialog(SurveyOneActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @SuppressLint("SetTextI18n")
                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                editTextDate.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });

        editTextState.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create custom dialog object
                dialog= new Dialog(SurveyOneActivity.this);
                // Include dialog.xml file
                dialog.setContentView(R.layout.dialog_state_fragment);
                // Set dialog title
                dialog.setTitle("Custom Dialog");
                stateLists = new ArrayList<>();

                // set values for custom dialog components - text, image and button
                editTextSearch =  dialog.findViewById(R.id.dateEditText);
                recyclerViewSearchList =  dialog.findViewById(R.id.recyclerviewStateList);
                stateLists = new ArrayList<>();
                linearLayoutManager = new LinearLayoutManager(SurveyOneActivity.this);
                stateAdapter = new StateAdapter(mContext, stateLists);
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(SurveyOneActivity.this);
                recyclerViewSearchList.setLayoutManager(mLayoutManager);
                recyclerViewSearchList.setItemAnimator(new DefaultItemAnimator());
                recyclerViewSearchList.setAdapter(stateAdapter);
                setUpData();
                setUpDialogListeners();
                dialog.show();
            }
        });

    }

    private void setUpDialogListeners() {
        recyclerViewSearchList.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerViewSearchList, new RecyclerTouchListener.ClickListener() {

            @Override
            public void onClick(View view, int position) {
                State state = stateLists.get(position);
                editTextState.setText(state.getTitle());
                dialog.dismiss();
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    private void setUpData() {
        State state = new State("Andhra Pradesh");
        stateLists.add(state);

        state = new State("Arunachal Pradesh");
        stateLists.add(state);

        state = new State("Assam");
        stateLists.add(state);

        state = new State("Bihar");
        stateLists.add(state);

        state = new State("Chhattisgarh");
        stateLists.add(state);

        state = new State("Goa");
        stateLists.add(state);

        state = new State("Gujarat");
        stateLists.add(state);

        state = new State("Haryana");
        stateLists.add(state);

        state = new State("Himachal Pradesh");
        stateLists.add(state);

        state = new State("Jammu and Kashmir");
        stateLists.add(state);

        state = new State("Jharkhand");
        stateLists.add(state);

        state = new State("Kerala");
        stateLists.add(state);

        state = new State("Madhya Pradesh");
        stateLists.add(state);

        state = new State("Maharashtra");
        stateLists.add(state);

        state = new State("Mizoram");
        stateLists.add(state);

        state = new State("Nagaland");
        stateLists.add(state);

        state = new State("Odisha");
        stateLists.add(state);

        state = new State("Punjab");
        stateLists.add(state);

        state = new State("Rajasthan");
        stateLists.add(state);

        state = new State("Sikkim");
        stateLists.add(state);

        state = new State("Tamil Nadu");
        stateLists.add(state);

        state = new State("Uttar Pradesh");
        stateLists.add(state);

        state = new State("Uttarakhand");
        stateLists.add(state);

        state = new State("West Bengal");
        stateLists.add(state);

        stateAdapter.notifyDataSetChanged();
    }


    private void setUpAdapter() {

    }


    private void initialization() {
        editTextDate = findViewById(R.id.dateEditText);
        editTextState = findViewById(R.id.stateList);

    }

}
