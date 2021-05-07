package com.example.sidebar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;

public class AllTransactions extends AppCompatActivity {
        DrawerLayout dl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_transactions);
        dl = findViewById(R.id.drawer_layout);
    }
    public void ClickMenu(View v)
    {
        MainActivity.openDrawer(dl);
    }
    public void ClickLogo(View v)
    {
        MainActivity.closeDrawer(dl);
    }
    public void Home(View v)
    {
        MainActivity.redirectActivity(this,MainActivity.class);
    }
    protected void onPause() {

        super.onPause();
        MainActivity.closeDrawer(dl);
    }
}