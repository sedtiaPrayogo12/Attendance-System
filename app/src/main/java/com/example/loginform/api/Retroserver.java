package com.example.loginform.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Retroserver {
    private static final String base_url = "http://10.212.0.1/andro-api/attendance/insert.php";

    private static Retrofit retrofit;


    public static Retrofit getClient()
    {
        if(retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(base_url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return  retrofit;
    }
}
