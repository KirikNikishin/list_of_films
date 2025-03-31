package ru.stankin.labs.lab2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Получаем переданные данные
        String title = getIntent().getStringExtra("title");
        String year = getIntent().getStringExtra("year");
        String genre = getIntent().getStringExtra("genre");
        String description = getIntent().getStringExtra("description");

        // Найдем TextView и установим данные
        TextView titleTextView = findViewById(R.id.titleTextView);
        TextView yearTextView = findViewById(R.id.yearTextView);
        TextView genreTextView = findViewById(R.id.genreTextView);
        TextView descriptionTextView = findViewById(R.id.descriptionTextView);
        Button webButton = findViewById(R.id.webButton);

        titleTextView.setText("Title: " + title);
        yearTextView.setText("Year: " + year);
        genreTextView.setText("Genre: " + genre);
        descriptionTextView.setText("Description: " + description);

        // Неявный Intent (например, открыть страницу в браузере)
        webButton.setOnClickListener(v -> {
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + title));
            startActivity(webIntent);
        });
    }
}
