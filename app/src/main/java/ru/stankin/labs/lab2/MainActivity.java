package ru.stankin.labs.lab2;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MovieAdapter adapter;
    private List<Movie> movieList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        movieList = new ArrayList<>();
        populateMovieList();

        adapter = new MovieAdapter(movieList, movie -> {
            Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
            intent.putExtra("title", movie.getTitle());
            intent.putExtra("year", movie.getYear());
            intent.putExtra("genre", movie.getGenre());
            intent.putExtra("description", movie.getDescription());
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);
    }

    private void populateMovieList() {
        for (int i = 1; i <= 20; i++) {
            movieList.add(new Movie("Movie " + i, "202" + (i % 10), "Genre " + i, "Description for Movie " + i));
        }
    }
}