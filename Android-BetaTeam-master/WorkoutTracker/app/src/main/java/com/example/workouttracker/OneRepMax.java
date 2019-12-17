package com.example.workouttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class OneRepMax extends AppCompatActivity{

    TextView OneRep;
    EditText Weight;
    int spiinnernum = 0;
    Button Upperbody;
    private LinearLayout parentlinear;
    int i = 0;
    int newlinecount =0;
    List<EditText> editTextList = new ArrayList<EditText>();
    List<TextView> TextViewList = new ArrayList<TextView>();
    SharedPreferences day1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_rep_max);
        parentlinear = findViewById(R.id.LiinearParent);
        Upperbody = findViewById(R.id.UpperBody);
        Intent intent = getIntent();
        //searches to see if a text box was edited

        }
    public void calculateUpper(View view){
        spiinnernum = 1;
        try {
        EditText FirstWeight = findViewById(R.id.weightET);
        TextView FirstOneRep = findViewById(R.id.OneRep);
        calculateOneRep(FirstWeight, FirstOneRep);



            for (int i = 0; i < parentlinear.getChildCount() - 2; i++) {
                final EditText weight = editTextList.get(i);
                final TextView MAX = TextViewList.get(i);
                calculateOneRep(weight, MAX);
                //everything under this is the shared preferences
               /* try{
                    if (i == 0) {
                       Log.i("IDINTLWO", weight.toString());
                        day1.edit().putString("Weight", weight.toString()).apply();
                    }
                    /*else if (i == 1){
                        String dummy = ObjectSerializer.serialize(new ArrayList<>());
                        String serOneRep = day2.getString("One Rep Max", dummy);
                        editTextList = (ArrayList<EditText>) ObjectSerializer.deserialize(serOneRep);
                    }
                    else if (i == 2){
                        String dummy = ObjectSerializer.serialize(new ArrayList<>());
                        String serOneRep = day3.getString("One Rep Max", dummy);
                        editTextList = (ArrayList<EditText>) ObjectSerializer.deserialize(serOneRep);
                    }
                    else if (i == 3){
                        String dummy = ObjectSerializer.serialize(new ArrayList<>());
                        String serOneRep = day4.getString("One Rep Max", dummy);
                        editTextList = (ArrayList<EditText>) ObjectSerializer.deserialize(serOneRep);
                    }
                    else if (i == 4){
                        String dummy = ObjectSerializer.serialize(new ArrayList<>());
                        String serOneRep = day5.getString("One Rep Max", dummy);
                        editTextList = (ArrayList<EditText>) ObjectSerializer.deserialize(serOneRep);
                    }
                    else if (i == 5){
                        String dummy = ObjectSerializer.serialize(new ArrayList<>());
                        String serOneRep = day6.getString("One Rep Max", dummy);
                        editTextList = (ArrayList<EditText>) ObjectSerializer.deserialize(serOneRep);
                    }
                    else if (i == 6){
                        String dummy = ObjectSerializer.serialize(new ArrayList<>());
                        String serOneRep = day7.getString("One Rep Max", dummy);
                        editTextList = (ArrayList<EditText>) ObjectSerializer.deserialize(serOneRep);
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }*/
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }



    }
    public void calculateLower(View view){
        spiinnernum = 2;
        try {
            EditText FirstWeight = findViewById(R.id.weightET);
            TextView FirstOneRep = findViewById(R.id.OneRep);
            calculateOneRep(FirstWeight, FirstOneRep);

            for (int i = 0; i < parentlinear.getChildCount() - 2; i++) {
                final EditText weight = editTextList.get(i);
                final TextView MAX = TextViewList.get(i);
                calculateOneRep(weight, MAX);

            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }


    public void newLine(View view){
        newlinecount++;
        if(newlinecount <9) {
            LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final View rowView = getLayoutInflater().inflate(R.layout.newrows, null);
            // Add the new row before the add field button.
            parentlinear.addView(rowView, parentlinear.getChildCount() - 2);
            int id = View.generateViewId();
            rowView.setId(id);

            EditText edittext = (EditText) rowView.findViewById(R.id.weight1);
            // store object in list
            editTextList.add(edittext);
            TextView textView = (TextView) rowView.findViewById((R.id.OneRep));
            TextViewList.add(textView);

        }

    }
    public void calculateOneRep(EditText WeightET,TextView OneRep){
    double max;
    double weight;
        //OneRep = findViewById(R.id.OneRep);
        Log.i("I almost made it" , "www");
        try {
            Log.i("I made it" , "ww");
            weight = Double.parseDouble(WeightET.getText().toString());
           // BodyLocation.setOnItemSelectedListener(this);
            //upper body
            if(weight == 0){
                OneRep.setText("0Lbs");
                return;
            }
            if(spiinnernum == 1) {
                max = (weight * 1.1307) + 0.6998;
                OneRep.setText(String.format("%.2f", max)+ " Lbs");
            }
            //lowerbody
            else if(spiinnernum == 2){
                max = (weight* 1.09703) + 14.2546;
                OneRep.setText(String.format("%.2f",max)+ " Lbs");
            }
            else{
                Toast.makeText(this,"Please Select Upper Or Lower Body",Toast.LENGTH_LONG).show();
            }

        }
        catch(Exception e){
            Toast.makeText(this,"You need to add weight",Toast.LENGTH_SHORT).show();
        }
    }
    public void moveScrenes(View view) {
        if (view.getId() == R.id.OneRep) {
            Intent intent = new Intent(getApplicationContext(), OneRepMax.class);
            startActivity(intent);

        }
        if (view.getId() == R.id.Exercises) {

            Intent intent = new Intent(getApplicationContext(), Day1.class);
            startActivity(intent);

        }
        if (view.getId() == R.id.Journal) {

            Intent intent = new Intent(getApplicationContext(), WorkoutJournal.class);
            startActivity(intent);

        }
    }


}

