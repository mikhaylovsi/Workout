package com.marrog.workout;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static com.marrog.workout.R.id.timer;


/**
 * A simple {@link Fragment} subclass.
 */
public class StopwatchFragment extends Fragment implements View.OnClickListener {

    private int time = 0;
    private boolean running = false;
    private boolean wasRunning = false;

    public StopwatchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(savedInstanceState != null){
            time = savedInstanceState.getInt("time");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");

        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View layout = inflater.inflate(R.layout.fragment_stopwatch, container, false);

        runTimer(layout);

        // Inflate the layout for this fragment
        return layout;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Button btnStart = (Button)getView().findViewById(R.id.start_button);
        btnStart.setOnClickListener(this);

        Button btnStop = (Button)getView().findViewById(R.id.stop_button);
        btnStop.setOnClickListener(this);

        Button btnReset = (Button)getView().findViewById(R.id.reset_button);
        btnReset.setOnClickListener(this);

    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (wasRunning){
            running = true;
        }
    }

    @Override
    public void onPause() {

        super.onPause();
        wasRunning = running;
        running = false;
    }

    private void runTimer(View layout) {
//    private void runTimer() {

       final TextView timer = (TextView)layout.findViewById(R.id.timer);

        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                int seconds = time % 60;
                int minutes = time % 3600 / 60;
                int hours = time / 3600;

                String currentTime = String.format("%d:%02d:%02d", hours, minutes, seconds);

              //  TextView timer = (TextView)getView().findViewById(R.id.timer);

                timer.setText(currentTime);

                if(running){
                    time++;
                }

               handler.postDelayed(this, 1000);

            }
        });

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        outState.putInt("time", time);
        outState.putBoolean("running", running);
        outState.putBoolean("wasRunning", wasRunning);

    }

    @Override
    public void onClick(View view) {


        switch (view.getId()) {
            case R.id.start_button:
                running = true;
                break;
            case R.id.stop_button:
                running = false;
                break;
            case R.id.reset_button:
                running = false;
                time = 0;
                break;
        }

    }
}
