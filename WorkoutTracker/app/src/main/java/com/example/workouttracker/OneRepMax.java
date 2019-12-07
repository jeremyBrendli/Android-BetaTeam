package com.example.workouttracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.generateViewId;

public class OneRepMax extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    TextView OneRep;
    EditText Weight;
    Spinner BodyLocation;
    int spiinnernum = 0;
    private LinearLayout parentlinear;
    int i = 0;
    List<EditText> editTextList = new ArrayList<EditText>();
    List<TextView> TextViewList = new ArrayList<TextView>();
    List<Spinner> Spinnerlist = new ArrayList<Spinner>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_rep_max);
        parentlinear = findViewById(R.id.LiinearParent);

        BodyLocation = findViewById(R.id.location);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.upperlower, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        BodyLocation.setAdapter(adapter);
        BodyLocation.setOnItemSelectedListener(this);

        Intent intent = getIntent();
        //searches to see if a text box was edited

    }
    public void calculate(View view){
        Log.i("This is the child count", parentlinear.getChildCount()+"");
        try {
        EditText FirstWeight = findViewById(R.id.weight);
        TextView FirstOneRep = findViewById(R.id.OneRep);
        calculateOneRep(FirstWeight, FirstOneRep);

            for (int i = 0; i < parentlinear.getChildCount() - 3; i++) {
                EditText weight = editTextList.get(i);
                TextView MAX = TextViewList.get(i);
                calculateOneRep(weight, MAX);

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    public void newLine(View view){

        LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        final View rowView = getLayoutInflater().inflate(R.layout.newrows, null);
        // Add the new row before the add field button.
        parentlinear.addView(rowView, parentlinear.getChildCount() - 1);
        int id = View.generateViewId();
        rowView.setId(id);

        EditText edittext = (EditText) rowView.findViewById(R.id.weight1);
        // store object in list
        editTextList.add(edittext);
        TextView textView = (TextView) rowView.findViewById((R.id.OneRep));
        TextViewList.add(textView);
        Spinner UpperLower = (Spinner) rowView.findViewById(R.id.location);
        Spinnerlist.add(UpperLower);


    }
    public void calculateOneRep(EditText WeightET,TextView OneRep){
    double max;
    double weight;
        //OneRep = findViewById(R.id.OneRep);
        Log.i("I almost made it" , "www");
        try {
            Log.i("I made it" , "ww");
            weight = Double.parseDouble(WeightET.getText().toString());
            BodyLocation.setOnItemSelectedListener(this);
            if(spiinnernum == 1) {
                max = (weight * 1.1307) + 0.6998;
                OneRep.setText(String.format("%.2f", max));
            }
            else if(spiinnernum == 2){
                max = (weight* 1.09703) + 14.2546;
                OneRep.setText(String.format("%.2f",max));
            }
            else{
                Toast.makeText(this,"Please Select Upper Or Lower Body",Toast.LENGTH_LONG).show();
            }

        }
        catch(Exception e){
            Toast.makeText(this,"You need to add weight",Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(position == 0){
            spiinnernum = 1;
            try {
                for (int i = 0; i < parentlinear.getChildCount() - 3; i++) {
                    final EditText weight = editTextList.get(i);
                    TextView MAX = TextViewList.get(i);
                    calculateOneRep(weight,MAX);
                }
            }catch(Exception e) {
                e.printStackTrace();
            }

            //calculateOneRep();
        }
        else if(position == 1){
            spiinnernum = 2;

            try {
                for (int i = 0; i < parentlinear.getChildCount() - 3; i++) {
                    final EditText weight = editTextList.get(i);
                    TextView MAX = TextViewList.get(i);
                    calculateOneRep(weight,MAX);
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
            //needs to call something else
            //calculateOneRep();
        }
    }

@Override
public void onNothingSelected(AdapterView<?> parent) {

   }




}
