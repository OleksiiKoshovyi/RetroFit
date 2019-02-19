package com.example.fileloader.retrofit;


import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("/")
    public Call<DataModel> getRecipe();
}
