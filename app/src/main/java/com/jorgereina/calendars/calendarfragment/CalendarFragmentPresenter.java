package com.jorgereina.calendars.calendarfragment;

import android.util.Log;

import com.jorgereina.calendars.CalendarApi;
import com.jorgereina.calendars.MainActivity;
import com.jorgereina.calendars.model.Event;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jorgereina on 6/25/18.
 */

public class CalendarFragmentPresenter implements CalendarFragmentPresenterContract.Presenter {

    private static final String BASE_URL = "https://spotical.herokuapp.com";
    private static final String TAG = MainActivity.class.getSimpleName() + "lagarto";


    private void getEventsRequest() {

        Retrofit retrofit = new  Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CalendarApi service = retrofit.create(CalendarApi.class);

        Call<List<Event>> call = service.getEvents();

        call.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, retrofit2.Response<List<Event>> response) {
                Log.d(TAG, "onResponse: " + response.body().get(0).getTitle());
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());

            }
        });
    }
}
