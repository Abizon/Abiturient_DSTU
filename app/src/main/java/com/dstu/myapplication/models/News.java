package com.dstu.myapplication.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by root on 25.11.2017.
 */

public class News {
    @SerializedName("id") int id;
    @SerializedName("name") String title;
    @SerializedName("description") String description;
    @SerializedName("time_last_modify") String time_last_modify;
    @SerializedName("time_create") String time_create;
    @SerializedName("surname") String surname;
    @SerializedName("firstname") String firstname;
    @SerializedName("patronymic") String patronymic;

    public class Array{
        @SerializedName("array") ArrayList<News> array;

        public ArrayList<News> getArray() {
            return array;
        }

        public void setArray(ArrayList<News> array) {
            this.array = array;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTime_last_modify() {
        return time_last_modify;
    }

    public void setTime_last_modify(String time_last_modify) {
        this.time_last_modify = time_last_modify;
    }

    public String getTime_create() {
        return time_create;
    }

    public void setTime_create(String time_create) {
        this.time_create = time_create;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
}
