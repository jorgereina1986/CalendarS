package com.jorgereina.calendars.model;

/**
 * Created by jorgereina on 6/25/18.
 */

public class Event {

    private String id;
    private String title;
    private String date;
    private String description;
    private String time;

    public Event(String title, String date, String description, String time) {
        this.title = title;
        this.date = date;
        this.description = description;
        this.time = time;
    }

    public Event(String id, String title, String date, String description, String time) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.description = description;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
