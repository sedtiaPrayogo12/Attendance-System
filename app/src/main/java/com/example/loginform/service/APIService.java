package com.example.loginform.service;

import com.example.loginform.model.ResponsModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface APIService {

    @FormUrlEncoded
    @POST("/index.php")
    Call<ResponsModel> sendAttendance(@Field("nama") String nama,
                                      @Field("usia") int usia,
                                      @Field("domisili") String domisili);
}
