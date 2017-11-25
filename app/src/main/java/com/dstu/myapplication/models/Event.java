package com.dstu.myapplication.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Event {
    @SerializedName("id") int id;
    @SerializedName("name") String name;
    @SerializedName("description") String description;
    @SerializedName("date_start_event") String date_start_event;
    @SerializedName("date_end_event") String date_end_event; //Нужна проверка на Null (почти всегда отсутствует

    public class Array{
        @SerializedName("array") ArrayList<Event> events;

        public ArrayList<Event> getEvents() {
            return events;
        }

        public void setEvents(ArrayList<Event> events) {
            this.events = events;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate_start_event() {
        return date_start_event;
    }

    public void setDate_start_event(String date_start_event) {
        this.date_start_event = date_start_event;
    }

    public String getDate_end_event() {
        return date_end_event;
    }

    public void setDate_end_event(String date_end_event) {
        this.date_end_event = date_end_event;
    }
}
