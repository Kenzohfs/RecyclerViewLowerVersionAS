package com.example.recyclerviewlowerversionas;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.recyclerviewlowerversionas.model.entities.Book;

public class MoreDetailsActivity extends AppCompatActivity {
    public static Drawable image;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_details);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Book book = (Book) getIntent().getSerializableExtra("BOOK");
        System.out.println(book.toString());

        TextView title = findViewById(R.id.title);
        TextView resume = findViewById(R.id.resume);
        TextView publisher = findViewById(R.id.publisher);
        TextView year = findViewById(R.id.year);
        ImageView coverBook = findViewById(R.id.bookCover);

        title.setText(book.getTitle());
        resume.setText(book.getResume());
        publisher.setText(book.getPublisher());
        year.setText(String.valueOf(book.getYear()));
        coverBook.setImageDrawable(image);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                System.out.println("entrou aq");
                this.finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
