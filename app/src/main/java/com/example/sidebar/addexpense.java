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
        MainActivity.redirectActivity(this,MainActivity.class);
    }
    protected void onPause() {
        super.onPause();
        MainActivity.closeDrawer(dl);
    }
}