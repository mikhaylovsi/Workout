package com.marrog.workout;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {

    int workoutId;

    public WorkoutDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(savedInstanceState != null){
            workoutId = savedInstanceState.getInt("workoutID");
        }

        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();

        TextView textDescription = (TextView)view.findViewById(R.id.textDescription);
        TextView textTitle = (TextView)view.findViewById(R.id.textTitle);

        textTitle.setText(Workout.workouts[workoutId].getName());
        textDescription.setText(Workout.workouts[workoutId].getDescription());

    }

    public void setWorkout(int id){
        this.workoutId = id;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putInt("workoutID", workoutId);
    }
}
