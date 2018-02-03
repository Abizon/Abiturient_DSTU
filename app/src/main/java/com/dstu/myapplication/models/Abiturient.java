package com.dstu.myapplication.models;

import com.google.gson.annotations.SerializedName;

public class Abiturient {
    @SerializedName("date") String date;
    @SerializedName("mail") String mail;
    @SerializedName("name") String name;
    @SerializedName("password") String password;
    @SerializedName("school") String school;
    @SerializedName("surname") String surname;
    @SerializedName("verificate_password") String verificate_password;
    @SerializedName("city") String city;
    @SerializedName("directions") String directions;



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
    public String getPassword() {
        return password;
    }
    public String getVerificate_password() {
        return verificate_password;
    }
    public String getCity() {
        return city;
    }
    public String getDirections() {
        return directions;
    }
}
