package com.example.sidebar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class AllTransactions extends AppCompatActivity {
        DrawerLayout dl;
        RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_transactions);
        dl = findViewById(R.id.drawer_layout);
        recyclerView = findViewById(R.id.transaction);
        ArrayList<Transaction_Item> transaction_items = new ArrayList<Transaction_Item>();
        transaction_items.add(new Transaction_Item(R.drawable.debt,1000,"31/01/1997"));
        transaction_items.add(new Transaction_Item(R.drawable.food,5000,"11/11/2001"));
        transaction_items.add(new Transaction_Item(R.drawable.furniture,900,"01/09/2005"));
        transaction_items.add(new Transaction_Item(R.drawable.entertenment,1100,"10/07/1989"));
        transaction_items.add(new Transaction_Item(R.drawable.bills,11100,"06/05/2010"));
        MyTransactionItemAdapter myTransactionItemAdapter = new MyTransactionItemAdapter(transaction_items,AllTransactions.this);
        myTransactionItemAdapter.setTransactionItems(transaction_items);
        recyclerView.setAdapter(myTransactionItemAdapter);
    }
    public void ClickMenu(View v)
    {
        MainActivity.openDrawer(dl);
    }
    public void ClickLogo(View v)
    {
        MainActivity.closeDrawer(dl);
    }
    public void AllTransactions(View v)
    {
        recreate();
    }
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