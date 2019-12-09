package com.example.workouttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PreacherCurl extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preacher_curl);

        Button onerep = (Button) findViewById(R.id.OneRep);
        Button Exercises = (Button)findViewById(R.id.Exercises);
        Button Journal = (Button) findViewById(R.id.Journal);

    }


    public void moveScrenes(View view){
        if(view.getId() == R.id.OneRep){
            Intent intent = new Intent(getApplicationContext(),OneRepMax.class);
            startActivity(intent);

        }
        if(view.getId() == R.id.Exercises){

            Intent intent = new Intent(getApplicationContext(),ExerciseExamples.class);
            startActivity(intent);

        }
        if(view.getId() == R.id.Journal){

            Intent intent = new Intent(getApplicationContext(),WorkoutJournal.class);
            startActivity(intent);

        }
    }

}
