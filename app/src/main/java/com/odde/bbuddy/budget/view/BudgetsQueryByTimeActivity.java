package com.odde.bbuddy.budget.view;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.odde.bbuddy.QueryBudgetInTime;
import com.odde.bbuddy.R;
import com.odde.bbuddy.Utils;
import com.odde.bbuddy.budget.viewmodel.Budget;
import com.odde.bbuddy.budget.viewmodel.EditableBudget;

import org.robobinding.ViewBinder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import static com.odde.bbuddy.di.component.ActivityComponentFactory.createActivityComponentBy;

public class BudgetsQueryByTimeActivity extends AppCompatActivity {

    private EditText startDayEditText;
    private EditText endDayEditText;
    private TextView totalAmountTextView;

    private List<Budget> budgets = new ArrayList<>();

//    @Inject
//    EditableBudget editableBudget;
//
//    @Inject
//    ViewBinder viewBinder;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_query_budgets_in_times);
        startDayEditText = (EditText) findViewById(R.id.startDay_editText);
        endDayEditText = (EditText) findViewById(R.id.endDay_editText);
        totalAmountTextView = (TextView) findViewById(R.id.totalAmount_textView);

        budgets = (List<Budget>) getIntent().getSerializableExtra("budget list");

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                QueryBudgetInTime q = new QueryBudgetInTime(budgets);
                Date s = Utils.parsingDateString(startDayEditText.getText().toString());
                Date e = Utils.parsingDateString(endDayEditText.getText().toString());
                int amount = q.query(s,e);
                totalAmountTextView.setText(String.valueOf(amount));
            }
        });
//        createActivityComponentBy(this).inject(this);
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.activity_query_budgets_in_times, container, false);
//    }
//
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        startDayEditText = (EditText) view.findViewById(R.id.startDay_editText);
//        endDayEditText = (EditText) view.findViewById(R.id.endDay_editText);
//        totalAmountTextView = (TextView) view.findViewById(R.id.totalAmount_textView);
//
//        Button button = (Button) view.findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                QueryBudgetInTime q = new QueryBudgetInTime(budgets);
//                Date s = Utils.parsingDateString(startDayEditText.getText().toString());
//                Date e = Utils.parsingDateString(endDayEditText.getText().toString());
//                int amount = q.query(s,e);
//                totalAmountTextView.setText(amount);
//            }
//        });
//    }
}
