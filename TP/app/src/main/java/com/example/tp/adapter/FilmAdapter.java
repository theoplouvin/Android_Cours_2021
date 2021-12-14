package com.example.tp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.tp.R;
import com.example.tp.models.Film;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.ViewHolder> {

    private final List<Film> mFilm;

    public FilmAdapter(List<Film> film) {
        this.mFilm = film;
    }

    @NonNull
    @Override
    public FilmAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View filmView = inflater.inflate(R.layout.movie_element, parent, false);

        return new ViewHolder(filmView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TextView title = holder.title;
        ConstraintLayout layout = holder.layout;
        ImageView image = holder.image;

        title.setText(mFilm.get(position).getOriginal_title());

        Glide.with(holder.image).load("https://image.tmdb.org/t/p/original/" + mFilm.get(position).getBackdrop_path())
                .apply(new RequestOptions().override(200,600)).into(image);

       /* Film film = mFilm.get(position);

        ImageView image = holder.image;
        Glide.with(image).load("https://image.tmdb.org/t/p/original/" + film.getBackdrop_path()).into(image);

        TextView title = holder.title;
        title.setText(film.getOriginal_title());*/
    }

    @Override
    public int getItemCount() {
        return mFilm.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView image;
        public TextView title;
        public ConstraintLayout layout;

        public ViewHolder(View itemView){
            super(itemView);

            image = (ImageView) itemView.findViewById(R.id.imageView);
            title = (TextView) itemView.findViewById(R.id.movie_title);
            layout = (ConstraintLayout) itemView.findViewById(R.id.movieElementLayout);
        }
    }
}
