package com.example.workouttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class WorkoutJournal extends AppCompatActivity {

    EditText name;
    EditText weight;
    EditText reps;
    Button addExercise;
    int newlinecount = 0;
    private LinearLayout parent;

    List<EditText> textList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_journal);

        addExercise = findViewById(R.id.addExercise);
        Intent intent = new Intent();

    }

    public void newLine(View view) {
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
    }
}
