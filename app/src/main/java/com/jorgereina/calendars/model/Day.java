package com.jorgereina.calendars.model;

import java.util.List;

/**
 * Created by jorgereina on 6/25/18.
 */

public class Day {

    List<Event> events;

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

}
