package com.jorgereina.calendars.calendarfragment;

import com.jorgereina.calendars.model.Event;

/**
 * Created by jorgereina on 6/25/18.
 */

public interface MonthFragmentPresenterContract {

    interface View {

        void loadEventData();
        void showProgress();
        void hideProgress();
        void showDayDetails();
        void fetchEventError(String message);
    }

    interface Presenter {

        void onDayButtonClicked(Event event);

        int getEventsCount();

        Event getEventData(int position);

        void onViewInitialized();
    }

}
