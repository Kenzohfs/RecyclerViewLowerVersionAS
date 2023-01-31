package com.example.recyclerviewlowerversionas.model.interfaces;


import com.example.recyclerviewlowerversionas.model.entities.Book;

public interface OnItemClicked {
    public void onContainerClick(Book book);
    public void onDeleteClick(Book book);
}
