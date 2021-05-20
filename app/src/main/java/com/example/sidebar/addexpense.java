package com.example.sidebar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.Calendar;

public class addexpense extends AppCompatActivity {
    DrawerLayout dl;
    EditText e1,e2,e3;
    Button b1;
    RadioButton rb1,rb2;
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
        rb1 = findViewById(R.id.rbcash);
        rb2 = findViewById(R.id.rbcard);
        rb2 = findViewById(R.id.rbcard);

        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        e1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    DatePickerDialog dpd1 = new DatePickerDialog(addexpense.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth,setListener,year,month,day);
                    dpd1.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                    dpd1.show();
            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month += 1;
                String date = day + "/" + month + "/" + year ;
                e1.setText(date);

            }
        };
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
}