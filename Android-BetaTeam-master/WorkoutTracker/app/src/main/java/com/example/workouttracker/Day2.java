package com.example.workouttracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

public class Day2 extends AppCompatActivity {
    EditText name;
    EditText weight;
    EditText reps;
    String workoutname;
    String lbs;
    String numberofreps;
    Button addExercise;
    List<EditText> namelist = new ArrayList<EditText>();
    List<EditText> weightlist = new ArrayList<EditText>();
    List<EditText> repslsit = new ArrayList<EditText>();
    int newlinecount = 0;
    private LinearLayout parent;

    List<EditText> textList = new ArrayList<>();
    SharedPreferences workouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day2);
        name  = findViewById(R.id.exerciseName);;
        weight = findViewById(R.id.weightET);
        reps = findViewById(R.id.numberOfReps);

        addExercise = findViewById(R.id.addExercise);

        Intent intent = new Intent();
        workouts = this.getSharedPreferences("com.example.workouttracker", Context.MODE_PRIVATE);
        try {
            for (int i = 6; i < 12; i++) {

                workoutname = workouts.getString("Workouts" + i, "Exercise Name");
                lbs = workouts.getString("LBS" + i, "Weight");
                numberofreps = workouts.getString("Reps" + i, "# Of Sets & Reps ");
                String exerciseID = "exerciseName" + i;
                String weightID = "weight" + i;
                String numberOfRepsID = "numberOfReps" +i;
                int NameId = getResources().getIdentifier(exerciseID, "id", getPackageName());
                int weightId = getResources().getIdentifier(weightID, "id", getPackageName());
                int repsid = getResources().getIdentifier(numberOfRepsID, "id", getPackageName());
                name = findViewById(NameId);
                weight = findViewById(weightId);
                reps = findViewById(repsid);
               /* EditText nameET = namelist.get(i);
                EditText weightET = weightlist.get(i);
                EditText reptET = repslsit.get(i);
                */
                name.setText(workoutname);
                weight.setText(lbs);
                reps.setText(numberofreps);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

    /* public void newLine(View view) {
         newlinecount++;
         if (newlinecount < 9) {
             LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
             final View rowView = getLayoutInflater().inflate(R.layout.journal_rows, null);
             // Add the new row before the add field button.
             parent.addView(rowView, parent.getChildCount() - 2);
             int id = View.generateViewId();
             rowView.setId(id);

             EditText edittext = (EditText) rowView.findViewById(R.id.weight1);
             // store object in list
             textList.add(edittext);
         }

     }*/
    public void save(View view){
        workouts = this.getSharedPreferences("com.example.workouttracker", Context.MODE_PRIVATE);
        for(int i =6; i < 12;i++) {
            String exerciseID = "exerciseName" + i;
            String weightID = "weight" + i;
            String numberOfRepsID = "numberOfReps" +i;
            int NameId = getResources().getIdentifier(exerciseID, "id", getPackageName());
            int weightId = getResources().getIdentifier(weightID, "id", getPackageName());
            int repsid = getResources().getIdentifier(numberOfRepsID, "id", getPackageName());
            name = findViewById(NameId);
            weight = findViewById(weightId);
            reps = findViewById(repsid);
            /*weightlist.add(weight);
            namelist.add(name);
            repslsit.add(reps);
*/
            //EditText nameET = namelist.get(i);
            workoutname = name.getText().toString();

            //EditText weightET = weightlist.get(i);
            lbs = weight.getText().toString();

            //EditText reptET = repslsit.get(i);
            numberofreps = reps.getText().toString();

            workouts.edit().putString("Workouts"+i, workoutname).apply();
            workouts.edit().putString("LBS"+i, lbs).apply();
            workouts.edit().putString("Reps"+i, numberofreps).apply();

        }
        /*for(int i = 0;i<6;i++) {

            EditText nameET = namelist.get(i);
            workoutname = nameET.getText().toString();

            EditText weightET = weightlist.get(i);
            lbs =weightET.getText().toString();

            EditText reptET = repslsit.get(i);
            numberofreps = reptET.getText().toString();

            workouts.edit().putString("Workouts"+i, workoutname).apply();
            workouts.edit().putString("LBS"+i, lbs).apply();
            workouts.edit().putString("Reps"+i, numberofreps).apply();
        }
*/

    }
    public void moveScrenes(View view){
        if(view.getId() == R.id.OneRep){
            Intent intent = new Intent(getApplicationContext(),OneRepMax.class);
            startActivity(intent);

        }
        if(view.getId() == R.id.Exercises){

            Intent intent = new Intent(getApplicationContext(), ExampleExercises.class);
            startActivity(intent);

        }
        if(view.getId() == R.id.Journal){

            Intent intent = new Intent(getApplicationContext(),WorkoutJournalNavigator.class);
            startActivity(intent);

        }
    }

}
