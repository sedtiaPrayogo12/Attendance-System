package com.example.loginform.api;

import com.example.loginform.model.ResponsModel;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiRequestAttendance {

    @FormUrlEncoded
    @POST("insert.php")
    Call<ResponsModel> sendAttendance(@Field("nis") String nis,
                                      @Field("nama") String nama,
                                      @Field("kelas") String kelas,
                                      @Field("jurusan") String jurusan);
}
