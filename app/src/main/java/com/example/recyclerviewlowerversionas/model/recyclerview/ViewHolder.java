package com.example.recyclerviewlowerversionas.model.recyclerview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewlowerversionas.R;

public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView year;
    private ImageView bookCover;
    private ImageView deleteIcon;
    private ConstraintLayout containerBook;

    public ViewHolder(View view) {
        super(view);

        title = view.findViewById(R.id.title);
        year = view.findViewById(R.id.year);
        bookCover = view.findViewById(R.id.bookCover);
        deleteIcon = view.findViewById(R.id.deleteIcon);
        containerBook = view.findViewById(R.id.containerBook);
    }

    public TextView getTitle() {
        return title;
    }

    public void setTitle(TextView title) {
        this.title = title;
    }

    public ImageView getBookCover() {
        return bookCover;
    }

    public void setBookCover(ImageView bookCover) {
        this.bookCover = bookCover;
    }

    public ImageView getDeleteIcon() {
        return deleteIcon;
    }

    public void setDeleteIcon(ImageView deleteIcon) {
        this.deleteIcon = deleteIcon;
    }

    public ConstraintLayout getContainerBook() {
        return containerBook;
    }

    public void setContainerBook(ConstraintLayout containerBook) {
        this.containerBook = containerBook;
    }

    public TextView getYear() {
        return year;
    }

    public void setYear(TextView year) {
        this.year = year;
    }
}
