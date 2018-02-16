package com.dstu.myapplication.dstu;


import org.joda.time.DateTime;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by root on 25.11.2017.
 */

public class ConfigRetrofit {
    private static final String BASE_URL = "http://ec.donstu.ru/";
    private  static Retrofit retrofit;
    private  static String  COOKIE=null;



    public static Retrofit getRetrofit(){
        if(retrofit==null) {
            OkHttpClient httpClient = new OkHttpClient.Builder()
                    .addInterceptor(
                            new Interceptor() {
                                @Override
                                public Response intercept(Interceptor.Chain chain) throws IOException {
                                    Request original = chain.request();

                                    // Request customization: add request headers
                                    Request.Builder requestBuilder = original.newBuilder()
                                            .header("Accept", "application/json")
                                            .header("Authorization", "auth-token")
                                            .header("Cookie", "PHPCOOKIE="+getCOOKIE())
                                            .method(original.method(), original.body());

                                    Request request = requestBuilder.build();
                                    return chain.proceed(request);
                                }
                            })
                    .build();

            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .client(httpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static String getCOOKIE() {
        if(COOKIE==null)
            COOKIE=md5(DateTime.now().toString());
        return COOKIE;
    }

    public static void setCOOKIE(String COOKIE) {
        ConfigRetrofit.COOKIE = COOKIE;
    }

    /**
     * Хэширование строки
     * @param s
     * @return
     */
    public static String md5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i=0; i<messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }
}
