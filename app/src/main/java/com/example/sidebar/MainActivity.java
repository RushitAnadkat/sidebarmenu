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
    DrawerLayout dl ;
    ImageView iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dl= findViewById(R.id.drawer_layout);
        iv= findViewById(R.id.menu1);
    }
    public void ClickMenu(View v)
    {
        openDrawer(dl);
    }

    public static void openDrawer(DrawerLayout dl) {

        dl.openDrawer(GravityCompat.START);

    }
    public void ClickLogo(View v)
    {
        closeDrawer(dl);
    }

    public static void closeDrawer(DrawerLayout dl) {

        if (dl.isDrawerOpen(GravityCompat.START))
        {
            dl.closeDrawer(GravityCompat.START);
        }

    }
    public void Home(View v)
    {
        recreate();
    }
    public void AllTransactions(View v)
    {
        redirectActivity(this,AllTransactions.class);
    }

    public static void redirectActivity(Activity activity,Class aclass)
    {
        Intent i = new Intent(activity,aclass);

        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        activity.startActivity(i);

    }
    public void DayView(View v)
    {
        Toast.makeText(this, "Day View", Toast.LENGTH_SHORT).show();
    }
    public  void MonthView(View v)
    {
        Toast.makeText(this, "Month View", Toast.LENGTH_SHORT).show();
    }
    public void CustomView(View v)
    {
        Toast.makeText(this, "Custom View", Toast.LENGTH_SHORT).show();
    }
    public void Budget(View v)
    {
        Toast.makeText(this, "Budget", Toast.LENGTH_SHORT).show();
    }
    public void Category(View v)
    {
        Toast.makeText(this, "Category", Toast.LENGTH_SHORT).show();
    }
    public void Settings(View v)
    {
        Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
    }
    protected void onPause() {

        super.onPause();
        dl.closeDrawer(GravityCompat.START);
    }

}