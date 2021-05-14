package com.example.sidebar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class addexpense extends AppCompatActivity {
    DrawerLayout dl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addexpense);
        dl = findViewById(R.id.expense_layout);
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