package com.example.recyclerviewlowerversionas.model.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewlowerversionas.R;
import com.example.recyclerviewlowerversionas.model.entities.Book;
import com.example.recyclerviewlowerversionas.model.interfaces.OnItemClicked;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {

    private ArrayList<Book> books;
    private OnItemClicked listener;

    public CustomAdapter(ArrayList<Book> books, OnItemClicked listener) {
        this.books = books;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recyclerview, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Book book = books.get(position);
        holder.getTitle().setText(book.getTitle());
        holder.getBookCover().setImageDrawable(book.getImage());
        holder.getYear().setText(String.valueOf(book.getYear()));
        holder.getDeleteIcon().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onDeleteClick(book);
            }
        });
        holder.getContainerBook().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onContainerClick(book);
            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }
}
