package com.example.fileloader.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<DataModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private void getRecipe(){
        Call<DataModel> call = Service.getApi().getRecipe();
        call.enqueue(this);
    }


    @Override
    public void onResponse(Call<DataModel> call, Response<DataModel> response) {
        response.body();
    }

    @Override
    public void onFailure(Call<DataModel> call, Throwable t) {

    }
}
