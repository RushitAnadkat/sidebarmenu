package com.example.sidebar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Budget extends AppCompatActivity {
    DrawerLayout dl;
    FloatingActionButton fbbgt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        dl = findViewById(R.id.drawer_layout);
        fbbgt1 = findViewById(R.id.addbugetclick);

        fbbgt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent();
                i.setClass(Budget.this,AddBudget.class);
                startActivity(i);
            }
        });
    }

    public void ClickMenu(View v) {
        MainActivity.openDrawer(dl);
    }
    public void ClickLogo(View v) {
        MainActivity.closeDrawer(dl);
    }
    public void Budget(View v) {
        recreate();
    }
    public void Home(View v) {
        MainActivity.redirectActivity(this, MainActivity.class);
    }
    public void AllTransactions(View v) { MainActivity.redirectActivity(this, AllTransactions.class); }
    public void DayView(View v) {
        MainActivity.redirectActivity(this, DayView.class);
    }
    public void MonthView(View v) {
        MainActivity.redirectActivity(this, MonthView.class);
    }
    public void CustomView(View v) {
        MainActivity.redirectActivity(this, CustomView.class);
    }
    public void Category(View v) {
        MainActivity.redirectActivity(this, Category.class);
    }
    public void Settings(View v) {
        MainActivity.redirectActivity(this, Settings.class);
    }
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(dl);
    }
}