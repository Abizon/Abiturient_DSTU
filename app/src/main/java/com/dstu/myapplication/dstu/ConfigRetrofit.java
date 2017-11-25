package com.dstu.myapplication.dstu;

import com.squareup.okhttp.OkHttpClient;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;

/**
 * Created by root on 25.11.2017.
 */

public class ConfigRetrofit {
    private static final String BASE_URL = "http://ec.donstu.ru/";
    private  static Retrofit retrofit;

    public static Retrofit getRetrofit(){
        if(retrofit==null)
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .client(new OkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

        return retrofit;
    }
}
