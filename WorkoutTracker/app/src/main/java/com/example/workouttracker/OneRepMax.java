package com.example.workouttracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class OneRepMax extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView OneRep;
    EditText Weight;
    Spinner BodyLocation;
    int spiinnernum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_rep_max);
        BodyLocation  = findViewById(R.id.location);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.upperlower,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        BodyLocation.setAdapter(adapter);
        BodyLocation.setOnItemSelectedListener(this);

        Intent intent = getIntent();


    }
    public void OnClick(View view){


    double max;
    double weight;
    OneRep = findViewById(R.id.OneRep);
    Weight = findViewById(R.id.weight);
    weight = Double.parseDouble(Weight.getText().toString());


    BodyLocation.setOnItemSelectedListener(this);

    if(spiinnernum == 1) {
        max = (weight * 1.1307) + 0.6998;
        OneRep.setText(max + "");
    }
    else if(spiinnernum == 2){
        max = (weight* 1.09703) + 14.2546;
        OneRep.setText(max+"");
    }
    else{
        Toast.makeText(this,"Please Select Upper Or Lower Body",Toast.LENGTH_LONG).show();
    }


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position == 0){
            spiinnernum =1;
        }
        else if(position == 1){
            spiinnernum = 2;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void addlines(View view){

    }
}
