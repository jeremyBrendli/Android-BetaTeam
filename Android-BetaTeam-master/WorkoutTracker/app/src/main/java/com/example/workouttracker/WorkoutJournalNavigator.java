package com.example.workouttracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class WorkoutJournalNavigator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_journal_navigator);
    }
    public void moveScrenes(View view){
        if(view.getId() == R.id.OneRep){
            Intent intent = new Intent(getApplicationContext(),OneRepMax.class);
            startActivity(intent);

        }
        if(view.getId() == R.id.Exercises){

            Intent intent = new Intent(getApplicationContext(), Day1.class);
            startActivity(intent);

        }
        if(view.getId() == R.id.Journal){

            Intent intent = new Intent(getApplicationContext(),WorkoutJournal.class);
            startActivity(intent);

        }if(view.getId() == R.id.Day1){

            Intent intent = new Intent(getApplicationContext(),Day1.class);
            startActivity(intent);

        }if(view.getId() == R.id.Day2){

            Intent intent = new Intent(getApplicationContext(),Day2.class);
            startActivity(intent);

        }if(view.getId() == R.id.day3){

            Intent intent = new Intent(getApplicationContext(),DAy3.class);
            startActivity(intent);

        }if(view.getId() == R.id.day4){

            Intent intent = new Intent(getApplicationContext(),Day4.class);
            startActivity(intent);

        }if(view.getId() == R.id.day5){

            Intent intent = new Intent(getApplicationContext(),Day5.class);
            startActivity(intent);

        }if(view.getId() == R.id.day6){

            Intent intent = new Intent(getApplicationContext(),Day6.class);
            startActivity(intent);

        }if(view.getId() == R.id.day7){

            Intent intent = new Intent(getApplicationContext(),DAy7.class);
            startActivity(intent);

        }



    }
}
