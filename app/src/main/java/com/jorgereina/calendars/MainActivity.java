package com.jorgereina.calendars;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.jorgereina.calendars.calendarfragment.CalendarFragment;
import com.jorgereina.calendars.model.Event;

import java.util.List;

import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState != null) {
            return;
        }
        if (findViewById(R.id.fragment_container) != null) {

            CalendarFragment earthquakeFragment = new CalendarFragment();
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .add(R.id.fragment_container, earthquakeFragment, "EarthquakeFragment")
                    .commit();

        }


    }
}
