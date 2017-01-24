package com.marrog.workout;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements WorkoutListFragment.WorkoutListListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WorkoutDetailFragment fragment = (WorkoutDetailFragment)getSupportFragmentManager().findFragmentById(R.id.detail_frag);
        fragment.setWorkout(1);

    }

    @Override
    public void onItemClick() {

    }
}
