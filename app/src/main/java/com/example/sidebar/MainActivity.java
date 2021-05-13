package com.example.sidebar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DrawerLayout dl;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dl = findViewById(R.id.drawer_layout);
        iv = findViewById(R.id.menu1);
    }

    public void ClickMenu(View v) {
        openDrawer(dl);
    }
    public static void openDrawer(DrawerLayout dl) { dl.openDrawer(GravityCompat.START); }
    public void ClickLogo(View v) {
        closeDrawer(dl);
    }
    public static void closeDrawer(DrawerLayout dl) {
        if (dl.isDrawerOpen(GravityCompat.START)) {
            dl.closeDrawer(GravityCompat.START);
        }
    }
    public void Home(View v) {
        recreate();
    }
    public static void redirectActivity(Activity activity, Class aclass) {
        Intent i = new Intent(activity, aclass);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(i);
    }
    public void AllTransactions(View v) { redirectActivity(this, AllTransactions.class); }
    public void DayView(View v) {
        redirectActivity(this, DayView.class);
    }
    public void MonthView(View v) {
        redirectActivity(this, MonthView.class);
    }
    public void CustomView(View v) {
        redirectActivity(this, CustomView.class);
    }
    public void Budget(View v) {
        redirectActivity(this, Budget.class);
    }
    public void Category(View v) {
        redirectActivity(this, Category.class);
    }
    public void Settings(View v) {
        redirectActivity(this, Settings.class);
    }
    protected void onPause() {
        super.onPause();
        dl.closeDrawer(GravityCompat.START);
    }
}