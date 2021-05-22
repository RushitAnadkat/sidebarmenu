package com.example.sidebar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class addexpense extends AppCompatActivity implements AdapterView.OnItemSelectedListener,AdapterView.OnItemClickListener,View.OnClickListener {
    DrawerLayout dl;
    EditText e1, e2, e3;
    Button b1;
    RadioButton rb;
    RadioGroup rg1;
    Spinner spinner;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addexpense);
        dl = findViewById(R.id.expense_layout);
        e1 = findViewById(R.id.edtdate);
        e2 = findViewById(R.id.edtamount);
        e3 = findViewById(R.id.edtnote);
        b1 = findViewById(R.id.btnadd);
        spinner = findViewById(R.id.spinner);

        ArrayList<ExpenseItems> customList = new ArrayList<>();
        customList.add(new ExpenseItems(R.drawable.investment, "Investment"));
        customList.add(new ExpenseItems(R.drawable.entertainment, "Entertainment"));
        customList.add(new ExpenseItems(R.drawable.gift, "Gifts"));
        customList.add(new ExpenseItems(R.drawable.food, "Food"));
        customList.add(new ExpenseItems(R.drawable.mortgage, "Rent"));

        ExpenseAdapter expenseAdapter = new ExpenseAdapter(this, customList);
        if (spinner != null) {
            spinner.setAdapter(expenseAdapter);
            spinner.setOnItemSelectedListener(addexpense.this);
        }


        e1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dpd1 = new DatePickerDialog(addexpense.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month += 1;
                        String date = day + "/" + month + "/" + year;
                        e1.setText(date);
                    }
                }, year, month, day);
                dpd1.show();
            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month += 1;
                String date = day + "/" + month + "/" + year;
                e1.setText(date);
            }
        };
        b1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                rg1 = findViewById(R.id.rgroup);
                int radioId = rg1.getCheckedRadioButtonId();
                rb = findViewById(radioId);
                Toast.makeText(addexpense.this, rb.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void checkButton(View v) {
        // rg1 = findViewById(R.id.rgroup);
        //int radioId = rg1.getCheckedRadioButtonId();
        //rb = findViewById(radioId);
        //Toast.makeText(this, "Selected Radio Button" + rb.getText().toString() , Toast.LENGTH_SHORT).show();
    }



    public void ClickMenu(View v)
    {
        MainActivity.openDrawer(dl);
    }
    public void ClickLogo(View v)
    {
        MainActivity.closeDrawer(dl);
    }
    public void addExpense(View v)
    {
        recreate();
    }
    public void AllTransactions(View v) { MainActivity.redirectActivity(this,MainActivity.class);}
    public void Home(View v)
    {
        MainActivity.redirectActivity(this,MainActivity.class);
    }
    public void DayView(View v) { MainActivity.redirectActivity(this,DayView.class); }
    public  void MonthView(View v)
    {
        MainActivity.redirectActivity(this,MonthView.class);
    }
    public void CustomView(View v)
    {
        MainActivity.redirectActivity(this,CustomView.class);
    }
    public void Budget(View v)
    {
        MainActivity.redirectActivity(this,Budget.class);
    }
    public void Category(View v)
    {
        MainActivity.redirectActivity(this,Category.class);
    }
    public void Settings(View v)
    {
        MainActivity.redirectActivity(this,Settings.class);
    }
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(dl);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}