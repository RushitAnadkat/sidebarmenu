package com.example.sidebar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

public class addincome extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener, View.OnClickListener {
    DrawerLayout dl;
    Spinner spinner;
    EditText ex1,ex2,ex3;
    Button btn1;
    RadioButton rb;
    RadioGroup rg1;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addincome);
        dl = findViewById(R.id.income_layout);
        spinner = findViewById(R.id.spinner);
        ex1 = findViewById(R.id.edtdate);
        ex2 = findViewById(R.id.edtamount);
        ex3 = findViewById(R.id.edtnote);
        btn1 = findViewById(R.id.btnadd);
        DatePickerDialog.OnDateSetListener setListener;

        ArrayList<IncomeItems> customList = new ArrayList<>();
        customList.add(new IncomeItems(R.drawable.investment, "Investment"));
        customList.add(new IncomeItems(R.drawable.entertainment, "Entertainment"));
        customList.add(new IncomeItems(R.drawable.gift, "Gifts"));
        customList.add(new IncomeItems(R.drawable.food, "Food"));
        customList.add(new IncomeItems(R.drawable.mortgage, "Rent"));

        IncomeAdapter incomeAdapter = new IncomeAdapter(this,customList);
        if (spinner != null) {
            spinner.setAdapter(incomeAdapter);
            spinner.setOnItemSelectedListener(this);
        }
        ex1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog dpd1 = new DatePickerDialog(addincome.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month += 1;
                        String date = day + "/" + month + "/" + year;
                        ex1.setText(date);
                    }
                }, year, month, day);
                dpd1.show();
            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month += 1;
                String date = day + "/" + month + "/" + year;
                ex1.setText(date);
            }
        };
        btn1.setOnClickListener(this);
    }
    public void ClickMenu(View v)
    {
        MainActivity.openDrawer(dl);
    }
    public void ClickLogo(View v)
    {
        MainActivity.closeDrawer(dl);
    }
    public void addIncome(View v) { recreate(); }
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
        IncomeItems items = (IncomeItems) parent.getSelectedItem();
        //Toast.makeText(this, items.getSpinnertext(), Toast.LENGTH_SHORT).show();
        name = items.getSpinnertext();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {  }

    @Override
    public void onClick(View v) {
        String dates = ex1.getText().toString();
        int amount = Integer.parseInt(ex2.getText().toString());
        String note = ex3.getText().toString();
        rg1 = findViewById(R.id.rgroup);
        int radioId = rg1.getCheckedRadioButtonId();
        rb = findViewById(radioId);

        dbHelper db = new dbHelper(this);
        String result = db.AddRecord(dates,amount,note,rb.getText().toString());

        Toast.makeText(addincome.this, result,Toast.LENGTH_SHORT).show();

    }
}