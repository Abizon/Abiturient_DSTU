package com.dstu.myapplication.dstu;

import com.dstu.myapplication.models.Specialty;
import com.dstu.myapplication.models.Facultie;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Path;

public interface Requests {
    @GET("/site/ci/api/training/getChildren") Call<Facultie.Answer> getFaculties();

    @GET("/site/ci/api/training/getSpecialties/{id}") Call<Specialty.Array> getSpecialties(@Path("id") int ID);
}
