package com.example.fileloader.retrofit;


import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    @GET("?i=onions")
    public Call<DataModel> getRecipe();
}
