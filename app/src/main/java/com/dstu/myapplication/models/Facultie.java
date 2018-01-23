package com.dstu.myapplication.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;


public class Facultie {
    @SerializedName("id") int id;
    @SerializedName("name") String name;
    @SerializedName("parent_code") int parent_code;
    @SerializedName("children") ArrayList<Facultie> children;


    public class Answer {
        @SerializedName("array") List<Facultie> answer;

        public List<Facultie> getAnswer() {
            return answer;
        }

        public void setAnswer(List<Facultie> answer) {
            this.answer = answer;
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

    public int getParent_code() {
        return parent_code;
    }

    public void setParent_code(int parent_code) {
        this.parent_code = parent_code;
    }

    public ArrayList<Facultie> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Facultie> children) {
        this.children = children;
    }


}
