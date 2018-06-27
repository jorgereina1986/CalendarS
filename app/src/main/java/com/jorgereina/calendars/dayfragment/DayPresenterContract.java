package com.jorgereina.calendars.dayfragment;

/**
 * Created by jorgereina on 6/26/18.
 */

public interface DayPresenterContract {

    interface View {

        void showProgress();

        void hideProgress();

        void loadEventsToRecyclerView();

        void eventCreatedSuccess();

        void eventFailedToCreate();
    }

    interface Presenter {

        void onCreateEventSelected(String title, String date, String description, String time);
    }
}
