package com.example.sidebar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    DrawerLayout dl;
    ImageView iv;
    FloatingActionButton fap1,fap2,fap3;
    Animation fapopen,fapclose,fapclockwise,fapanticlockwise;

    Boolean isOpen=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dl = findViewById(R.id.drawer_layout);
        iv = findViewById(R.id.menu1);
        fap1=findViewById(R.id.fltincome);
        fap2=findViewById(R.id.fltexpense);
        fap3=findViewById(R.id.fltmenu);
        fapopen= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_open_anim);
        fapclose= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_close_anim);
        fapclockwise=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.from_bottom_anim);
        fapanticlockwise=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.to_bottom_anim);
        fap3.setOnClickListener(this);
        fap1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.setClass(MainActivity.this,addexpense.class);
                startActivity(i);
            }
        });
        fap2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();
                i.setClass(MainActivity.this,addincome.class);
                startActivity(i);
            }
        });
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

    @Override
    public void onClick(View v) {
        if(isOpen) {
            fap2.startAnimation(fapclose);
            fap3.startAnimation(fapclose);
            fap1.startAnimation(fapclockwise);
            fap2.setClickable(false);
            fap3.setClickable(false);
            isOpen=false;
        }
        else{
            fap2.startAnimation(fapopen);
            fap3.startAnimation(fapopen);
            fap1.startAnimation(fapanticlockwise);
            fap2.setClickable(true);
            fap3.setClickable(true);
            isOpen=true;
        }

    }

}