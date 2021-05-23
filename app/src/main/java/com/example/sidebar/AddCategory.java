package com.example.sidebar;

import androidx.appcompat.app.ActionBar;
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

public class AddCategory extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    FloatingActionButton fb1;
    EditText et1,et2;
    RadioButton rb;
    RadioGroup rg1;
    Spinner spn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_category);

        fb1 = findViewById(R.id.save);
        et1 = findViewById(R.id.edtcatname);
        et2 = findViewById(R.id.edtnote_ic);
        spn1 = findViewById(R.id.spinner_icon);

        ArrayList<AddCategoryicon> customList = new ArrayList<>();
        customList.add(new AddCategoryicon(R.drawable.fast_food));
        customList.add(new AddCategoryicon(R.drawable.public_transport));
        customList.add(new AddCategoryicon(R.drawable.budget));

        AddiconAdapter addiconAdapter = new AddiconAdapter(this,customList);
        if(spn1!=null)
        {
            spn1.setAdapter(addiconAdapter);
            spn1.setOnItemSelectedListener(this);
        }

        fb1.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        AddCategoryicon addCategoryicon = (AddCategoryicon) parent.getSelectedItem();
        Toast.makeText(this, addCategoryicon.getSpinner_icon(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) { }

    @Override
    public void onClick(View v) {
        String cat = et1.getText().toString();
        String not = et2.getText().toString();
        rg1 = findViewById(R.id.catgroup);
        int radioId = rg1.getCheckedRadioButtonId();
        rb = findViewById(radioId);
        dbHelper db = new dbHelper(this);
        String result = db.AddCategory(cat,rb.getText().toString(),not);

        Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
    }

}