package com.jorgereina.calendars.dayfragment;

import com.jorgereina.calendars.CalendarApi;
import com.jorgereina.calendars.calendarfragment.RetrofitInstance;
import com.jorgereina.calendars.model.Event;

import java.util.ArrayList;
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
    public void onCreateEvent() {
        CalendarApi service = RetrofitInstance.getRetrofitInstance().create(CalendarApi.class);
        Call<List<Event>> call = service.postEvent("tonys bday", null,null, "4pm");
        call.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {

            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {

            }
        });

    }
}
