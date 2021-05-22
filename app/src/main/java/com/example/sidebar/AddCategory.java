package com.example.sidebar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class AddCategory extends AppCompatActivity implements AdapterView.OnItemSelectedListener, View.OnClickListener {
    EditText et1,et2;
    Spinner sp1;
    RadioGroup rg1;
    RadioButton rb;
    FloatingActionButton fb1;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);
        et1 = findViewById(R.id.edtcategoryname);
        et2 = findViewById(R.id.edtnote_ic);
        sp1 = findViewById(R.id.spinner_icon);
        fb1 = findViewById(R.id.save);
        rg1 = findViewById(R.id.rgroup);
        int radioId = rg1.getCheckedRadioButtonId();
        rb = findViewById(radioId);

        ArrayList<AddCategoryicon> customList = new ArrayList<>();
        customList.add(new AddCategoryicon(R.drawable.investment));
        customList.add(new AddCategoryicon(R.drawable.entertainment));
        customList.add(new AddCategoryicon(R.drawable.gift));
        customList.add(new AddCategoryicon(R.drawable.food));
        customList.add(new AddCategoryicon(R.drawable.mortgage));

        AddiconAdapter addiconAdapter = new AddiconAdapter(this,customList);
        if (sp1 != null) {
            sp1.setAdapter(addiconAdapter);
            sp1.setOnItemSelectedListener(this);
        }

        fb1.setOnClickListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        AddCategoryicon item = (AddCategoryicon) parent.getSelectedItem();
//        Toast.makeText(this, item.getSpinner_icon(), Toast.LENGTH_SHORT).show();
//        name = item.getSpinner_icon();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        Toast.makeText(AddCategory.this,"Demo", Toast.LENGTH_SHORT).show();
    }
}