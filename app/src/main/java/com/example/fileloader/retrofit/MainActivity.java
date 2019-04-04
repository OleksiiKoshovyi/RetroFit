package com.example.fileloader.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements Callback<DataModel> {

    RecyclerView rview;

    List<Result> results = new ArrayList<>();
    RecipeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rview = findViewById(R.id.rview);
        rview.setLayoutManager(new LinearLayoutManager(this));

        adapter = new RecipeAdapter(results, this);
        rview.setAdapter(adapter);

       getRecipe();
    }

    private void getRecipe(){
        Call<DataModel> call = Service.getApi().getRecipe();

        call.enqueue(new Callback<DataModel>() {
            @Override
            public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                //response.body().toString();
                results = response.body().getResults();
                adapter.setList(results);
            }

            @Override
            public void onFailure(Call<DataModel> call, Throwable t) {
                t.getMessage();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }


    @Override
    public void onResponse(Call<DataModel> call, Response<DataModel> response) {
        response.body();
    }

    @Override
    public void onFailure(Call<DataModel> call, Throwable t) {

    }
}
