package com.example.fileloader.retrofit;

import retrofit2.Retrofit;

public class Service {

    public static API getApi(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.recipepuppy.com/api/")
//                .addConverterFactory(GsonConverterFactory.create())
                .build();
        API api = retrofit.create(API.class);
        return  api;
    }
}
