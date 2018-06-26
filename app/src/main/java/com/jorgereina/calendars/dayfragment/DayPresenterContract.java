package com.jorgereina.calendars.dayfragment;

/**
 * Created by jorgereina on 6/26/18.
 */

public interface DayPresenterContract {

    interface View {

        void showProgress();
        void hideProgress();
        void loadEventsToRecyclerView();
    }

    interface Presenter {

        void onCreateEvent();
    }
}
