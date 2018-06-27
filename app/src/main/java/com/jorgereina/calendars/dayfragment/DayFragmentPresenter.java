package com.jorgereina.calendars.dayfragment;

import android.util.Log;

import com.jorgereina.calendars.CalendarApi;
import com.jorgereina.calendars.calendarfragment.RetrofitInstance;
import com.jorgereina.calendars.model.Event;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by jorgereina on 6/26/18.
 */

public class DayFragmentPresenter implements DayPresenterContract.Presenter {

    private DayPresenterContract.View view;

    public DayFragmentPresenter(DayPresenterContract.View view) {
        this.view = view;
    }

    @Override
    public void onCreateEventSelected(String title, String date, String description, String time) {

        CalendarApi service = RetrofitInstance.getRetrofitInstance().create(CalendarApi.class);
        Call<Event> call = service.postEvent(title, date, description, time);
        call.enqueue(new Callback<Event>() {
            @Override
            public void onResponse(Call<Event> call, Response<Event> response) {
                view.eventCreatedSuccess();
                Log.d("lagarto", "onResponse: " + "event created");
            }

            @Override
            public void onFailure(Call<Event> call, Throwable t) {
                view.eventFailedToCreate();
                Log.d("lagarto", "onResponse: " + t.getMessage());
            }
        });

    }
}
