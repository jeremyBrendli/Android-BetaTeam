package com.example.workouttracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static java.util.Arrays.asList;

public class ExerciseExamples extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> workarray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_examples);


        final ListView listView = (ListView) findViewById(R.id.listview);
        final ArrayList<String> excersize = new ArrayList<>(asList(getResources().getStringArray(R.array.Exersize)));
        workarray = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, excersize);
        listView.setAdapter(workarray);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("id", view + " view " + parent + "parent");
                //String selectedFromList = (listView.getItemAtPosition(position));


                if (id == R.id.OneRep) {
                    Intent intent = new Intent(getApplicationContext(), OneRepMax.class);
                    startActivity(intent);
                }
                if (id == R.id.Exercises) {
                    Intent intent = new Intent(getApplicationContext(), ExerciseExamples.class);
                    startActivity(intent);
                }
                if (id == R.id.Journal) {
                    Intent intent = new Intent(getApplicationContext(), WorkoutJournal.class);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.search_menu, menu);
        MenuItem item = menu.findItem(R.id.search);

        SearchView searchView = (SearchView) item.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                workarray.getFilter().filter(newText);
                return false;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id==R.id.search){
            //do your functionality here
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

