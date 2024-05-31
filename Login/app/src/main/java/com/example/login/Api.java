package com.example.login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface Api {


    @POST("ConMysql")
    Call<Void> insertUser(@Body loginUser myData);

}
