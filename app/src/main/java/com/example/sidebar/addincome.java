package com.example.sidebar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class addincome extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener, View.OnClickListener {
    DrawerLayout dl;
    Spinner spinner;
    EditText ex1,ex2,ex3;
    Button btn1,btn2;
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
        btn1.setOnClickListener(this);

        ArrayList<IncomeItems> customList = new ArrayList<>();
        customList.add(new IncomeItems(R.drawable.investment, "Investment"));
        customList.add(new IncomeItems(R.drawable.entertenment, "Entertainment"));
        customList.add(new IncomeItems(R.drawable.gifts, "Gifts"));
        customList.add(new IncomeItems(R.drawable.food, "Food"));
        customList.add(new IncomeItems(R.drawable.rent, "Rent"));

        IncomeAdapter incomeAdapter = new IncomeAdapter(this,customList);
        if (spinner != null) {
            spinner.setAdapter(incomeAdapter);
            spinner.setOnItemSelectedListener(this);
        }
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
        Toast.makeText(this, items.getSpinnertext(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {  }

    @Override
    public void onClick(View v)
    {
        String date = ex1.getText().toString();
        int amount = Integer.parseInt(ex2.getText().toString());
        String note = ex3.getText().toString();
        Toast.makeText(this,"Date"+date+"Amount"+amount+"Note"+note, Toast.LENGTH_SHORT).show();
    }
}