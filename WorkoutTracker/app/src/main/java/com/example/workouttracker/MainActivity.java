package com.example.workouttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button onerep = (Button) findViewById(R.id.OneRep);
        Button Exercises = (Button)findViewById(R.id.Exercises);
        Button Journal = (Button) findViewById(R.id.Journal);


    }
    public void moveScrenes(View view){
        if(view.getId() == R.id.OneRep){
            Intent intent = new Intent(getApplicationContext(),OneRepMax.class);
            startActivity(intent);
            Toast.makeText(this,"YAYAA",Toast.LENGTH_LONG).show();
        }
        if(view.getId() == R.id.Exercises){

            Intent intent = new Intent(getApplicationContext(),ExerciseExamples.class);
            startActivity(intent);
            Toast.makeText(this,"workout",Toast.LENGTH_LONG).show();
        }
        if(view.getId() == R.id.Journal){

            Intent intent = new Intent(getApplicationContext(),WorkoutJournal.class);
            startActivity(intent);
            Toast.makeText(this,"YAYAA",Toast.LENGTH_LONG).show();
        }
    }
}
