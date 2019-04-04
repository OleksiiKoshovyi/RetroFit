package com.example.fileloader.retrofit;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static java.security.AccessController.getContext;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.ViewHolder> {
    TextView txtTitle,txtIngredients,txtUrl;
    ImageView img;
    Context context;
    private List<Result> results;

    public RecipeAdapter(List<Result> results, Context context) {
        this.results = results;
        this.context = context;
    }

    public void setList(List<Result> results)
    {
        this.results = results;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecipeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.container, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeAdapter.ViewHolder viewHolder, int i) {
        viewHolder.onBind(results.get(i));
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtIngredients = itemView.findViewById(R.id.txtIngredients);
            txtUrl = itemView.findViewById(R.id.txtUrl);
            img = itemView.findViewById(R.id.img);
        }

        public void onBind(Result result){
            txtTitle.setText(String.valueOf(result.getTitle()));
            txtIngredients.setText(String.valueOf(result.getIngredients()));
            txtUrl.setText(String.valueOf(result.getHref()));

            Picasso.with(context)
                    .load(result.getThumbnail())
                    .placeholder(R.drawable.ic_launcher_background)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(img);
        }
    }

}
