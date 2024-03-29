package com.example.workouttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class BenchPress extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bench_press);
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
