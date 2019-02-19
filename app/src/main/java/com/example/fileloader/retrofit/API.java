package com.example.fileloader.retrofit;


import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("?i=onions")
    public Call<DataModel> getRecipe();
}
