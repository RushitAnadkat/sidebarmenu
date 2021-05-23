package com.example.sidebar;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

public class AddBudget extends AppCompatActivity  {

    FloatingActionButton fabutton;
    EditText et1,et2;
    DatePickerDialog.OnDateSetListener setListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_budget);
        fabutton = findViewById(R.id.save_budget);


        et1 = findViewById(R.id.bgtdate);
        et2 = findViewById(R.id.bgtamount);

        et1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                final int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dp1 = new DatePickerDialog(AddBudget.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month += 1;
                        String date = day + "/" + month + "/" + year;
                        et1.setText(date);
                    }
                },year,month,day);
                dp1.show();
            }
        });
        setListener =new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                month += 1;
                String date = day + "/" + month + "/" + year;
                et1.setText(date);
            }
        };

        fabutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = et1.getText().toString();
                int amount = Integer.parseInt(et2.getText().toString());
                dbHelper db = new dbHelper(AddBudget.this);
                String result = db.AddBudget(date,amount);
                Toast.makeText(AddBudget.this, result, Toast.LENGTH_SHORT).show();
            }
        });
    }
}