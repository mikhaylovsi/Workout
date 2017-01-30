package com.marrog.workout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.View;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.WorkoutListListener {

    WorkoutDetailFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    public void onItemClick(int id) {


        View frame = findViewById(R.id.fragment_container);

        if(frame == null){

            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("workoutId", id);

            startActivity(intent);

        }
        else {
            WorkoutDetailFragment fragment = new WorkoutDetailFragment();
            fragment.setWorkout(id);
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragment_container, fragment);
            transaction.addToBackStack(null);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.commit();
        }
    }
}
