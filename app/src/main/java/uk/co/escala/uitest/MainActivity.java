package uk.co.escala.uitest;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void startChronometer(View view) {
        long startTime = SystemClock.elapsedRealtime();
        Chronometer chronometer = ((Chronometer) view);
        chronometer.setBase(startTime);
        chronometer.start();

        chronometer.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {

            @Override
            public void onChronometerTick(Chronometer chronometer) {
                // This is triggered each second
                int secondCount = (int) ((SystemClock.elapsedRealtime() - chronometer.getBase()) / 1000);
                int escapeCount = 600; // seconds
                if (secondCount >= escapeCount) {
                    chronometer.stop();
                } else {
                   if((secondCount % 60) == 0) System.err.println("***** MINUTE TICK *****");
                }
            }
        });
    }
}
