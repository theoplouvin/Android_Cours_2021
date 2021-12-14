package com.example.tp1.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tp1.DetailMovie;
import com.example.tp1.R;
import com.example.tp1.models.Movie;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {
    private final List<Movie> mMovie;
    private ReclyclerViewClickListener listener;

    public MovieAdapter(List<Movie> film, ReclyclerViewClickListener listener) {
        this.mMovie = film;
        this.listener = listener;
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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView image;
        public TextView title;

        public ViewHolder(View itemView){
            super(itemView);

            image = itemView.findViewById(R.id.imageMovie);
            title = itemView.findViewById(R.id.nameMovie);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            listener.onClick(itemView, getAdapterPosition());
        }
    }

    public interface ReclyclerViewClickListener{
        void onClick(View v, int position);
    }

}
