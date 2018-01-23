package com.dstu.myapplication.models;

import com.google.gson.annotations.SerializedName;

public class Abiturient {
    @SerializedName("name") String name;
    @SerializedName("date") String date;
    @SerializedName("surname") String surname;
    @SerializedName("school") String school;
    @SerializedName("mail") String mail;

    public String getDate() {
        return date;
    }
    public String getMail() {
        return mail;
    }
    public String getName() {
        return name;
    }
    public String getSchool() {
        return school;
    }
    public String getSurname() {
        return surname;
    }
}
