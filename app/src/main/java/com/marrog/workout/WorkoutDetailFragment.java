package com.marrog.workout;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {

    int workoutId;
    private FragmentActivity mContext;

    public WorkoutDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = (FragmentActivity)context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(savedInstanceState != null){
            workoutId = savedInstanceState.getInt("workoutID");
        }
        else {

            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();

            StopwatchFragment fragment = new StopwatchFragment();
            transaction.replace(R.id.stopwatch_container, fragment);
            transaction.addToBackStack(null);
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            transaction.commit();

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
