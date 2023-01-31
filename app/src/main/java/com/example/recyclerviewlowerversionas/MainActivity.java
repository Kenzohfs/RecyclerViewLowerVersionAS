package com.example.recyclerviewlowerversionas;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.recyclerviewlowerversionas.model.entities.Book;
import com.example.recyclerviewlowerversionas.model.interfaces.OnItemClicked;
import com.example.recyclerviewlowerversionas.model.recyclerview.CustomAdapter;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnItemClicked {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private CustomAdapter customAdapter;
    private ArrayList<Book> books = new ArrayList<>();

    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == 78) {
                        Intent intent = result.getData();

                        if (intent != null) {
                            Book book = (Book) intent.getSerializableExtra("BOOK");
                            book.setImage(BookCoverSelectActivity.coverSelected);
                            BookCoverSelectActivity.coverSelected = null;
                            books.add(book);
                            customAdapter.notifyItemInserted(books.size() - 1);
                        }
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        books.add(new Book("Livro 1", "Resume", "Publisher", 2020, getDrawable(R.drawable.nao_quero_ler)));
        books.add(new Book("Livro 2", "Resume", "Publisher", 2021, getDrawable(R.drawable.o_pequeno_principe)));
        books.add(new Book("Livro 3", "Resume", "Publisher", 2022, getDrawable(R.drawable.orgulho_e_preconceito)));

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRecyclerView();
    }

    public void setRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this);
        customAdapter = new CustomAdapter(books, this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(customAdapter);
    }

    @Override
    public void onContainerClick(Book book) {
        System.out.println(book.toString());
        Intent intent = new Intent(this, MoreDetailsActivity.class);
        MoreDetailsActivity.image = book.getImage();
        intent.putExtra("BOOK", book);
        startActivity(intent);
    }

    @Override
    public void onDeleteClick(Book book) {
        customAdapter.notifyItemRemoved(books.indexOf(book));
        books.remove(book);
    }

    public void onClickAddBtn(View view) {
        System.out.println("livro adicionado");
        Intent intent = new Intent(this, AddBookActivity.class);
        activityResultLauncher.launch(intent);
    }
}