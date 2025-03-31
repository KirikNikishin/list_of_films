package ru.stankin.labs.lab2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<Movie> movieList;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Movie movie);
    }

    public MovieAdapter(List<Movie> movieList, OnItemClickListener listener) {
        this.movieList = movieList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.bind(movieList.get(position));
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        private TextView titleTextView;
        private TextView yearTextView;

        public MovieViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            yearTextView = itemView.findViewById(R.id.yearTextView);
        }

        public void bind(final Movie movie) {
            titleTextView.setText(movie.getTitle());
            yearTextView.setText(movie.getYear());
            itemView.setOnClickListener(v -> listener.onItemClick(movie));
        }
    }
}