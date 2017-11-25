package com.dstu.myapplication.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by root on 25.11.2017.
 */

public class Specialty {

    @SerializedName("id") int id;
    @SerializedName("qualification_diplom") String qualification_diplom;
    @SerializedName("department_id") int department_id;
    @SerializedName("duration_diplom") String duration_diplom;//null
    @SerializedName("specilaty_id") int specilaty_id; // ID специальности (пока не нужен)
    @SerializedName("specilaty_title") String specilaty_title;
    @SerializedName("specilaty_code") String specilaty_code; //Код Специальности (к примеру 09.03.02)
    @SerializedName("training_from_title") String training_from_title; //Форма обучения (Очная, Заочная)
    @SerializedName("children") ArrayList<Specialty> children;

    public class Array{
        @SerializedName("array") ArrayList<Specialty> array;

        public ArrayList<Specialty> getArray() {
            return array;
        }

        public void setArray(ArrayList<Specialty> array) {
            this.array = array;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getQualification_diplom() {
        return qualification_diplom;
    }

    public void setQualification_diplom(String qualification_diplom) {
        this.qualification_diplom = qualification_diplom;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDuration_diplom() {
        return duration_diplom;
    }

    public void setDuration_diplom(String duration_diplom) {
        this.duration_diplom = duration_diplom;
    }

    public int getSpecilaty_id() {
        return specilaty_id;
    }

    public void setSpecilaty_id(int specilaty_id) {
        this.specilaty_id = specilaty_id;
    }

    public String getSpecilaty_title() {
        return specilaty_title;
    }

    public void setSpecilaty_title(String specilaty_title) {
        this.specilaty_title = specilaty_title;
    }

    public String getSpecilaty_code() {
        return specilaty_code;
    }

    public void setSpecilaty_code(String specilaty_code) {
        this.specilaty_code = specilaty_code;
    }

    public String getTraining_from_title() {
        return training_from_title;
    }

    public void setTraining_from_title(String training_from_title) {
        this.training_from_title = training_from_title;
    }

    public ArrayList<Specialty> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Specialty> children) {
        this.children = children;
    }
}
