package com.example.tp1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tp1.R;
import com.example.tp1.models.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private final List<Movie> mMovie;

    public MovieAdapter(List<Movie> film) {
        this.mMovie = film;
    }

    @NonNull
    @Override
    public MovieAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View MovieView = inflater.inflate(R.layout.popular_activity_item, parent, false);

        return new ViewHolder(MovieView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TextView title = holder.title;
        ImageView image = holder.image;

        title.setText(mMovie.get(position).getOriginal_title());

        Glide.with(holder.image).load("https://image.tmdb.org/t/p/w500/" + mMovie.get(position).getPoster_path())
                .apply(new RequestOptions().override(200,600)).into(image);

    }

    @Override
    public int getItemCount() {
        return mMovie.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView image;
        public TextView title;

        public ViewHolder(View itemView){
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.imageMovie);
            title = (TextView) itemView.findViewById(R.id.nameMovie);
        }
    }

}
