package com.example.recyclerviewlowerversionas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.recyclerviewlowerversionas.model.entities.Book;

public class AddBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_book);

        Button addButton = findViewById(R.id.add);
        TextView title = findViewById(R.id.title);
        TextView publisher = findViewById(R.id.publisher);
        TextView resume = findViewById(R.id.resume);
        TextView year = findViewById(R.id.year);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                if (!isAllDataInserted(title, publisher, resume, year)) {
                    System.out.println("Insira todos os dados para cadastrar um livro!");
                } else {
                    Book book = new Book(title.getText().toString(), resume.getText().toString(), publisher.getText().toString(), Integer.parseInt(year.getText().toString()), BookCoverSelectActivity.coverSelected);
                    intent.putExtra("BOOK", book);
                    setResult(78, intent);
                    finish();
                }
            }
        });
    }

    public void selectCoverBook(View view) {
        Intent intent = new Intent(this, BookCoverSelectActivity.class);
        startActivity(intent);
    }

    public boolean isAllDataInserted(TextView title, TextView publisher, TextView resume, TextView year) {
        if (title.length() == 0 || publisher.length() == 0 || resume.length() == 0 || year.length() == 0 || BookCoverSelectActivity.coverSelected == null) {
            return false;
        }
        return true;
    }
}
