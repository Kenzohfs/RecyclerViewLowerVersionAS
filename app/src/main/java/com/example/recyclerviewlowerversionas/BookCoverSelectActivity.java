package com.example.recyclerviewlowerversionas;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class BookCoverSelectActivity extends AppCompatActivity {

    int[] images = { R.drawable.nao_quero_ler, R.drawable.o_pequeno_principe, R.drawable.orgulho_e_preconceito, R.drawable.george_orwelljpg};
    public static Drawable coverSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_cover_select);

        ImageView imagem1 = findViewById(R.id.imageView2);
        ImageView imagem2 = findViewById(R.id.imageView3);
        ImageView imagem3 = findViewById(R.id.imageView4);
        ImageView imagem4 = findViewById(R.id.imageView5);

        imagem1.setImageResource(images[0]);
        imagem2.setImageResource(images[1]);
        imagem3.setImageResource(images[2]);
        imagem4.setImageResource(images[3]);
    }

    public void salvarImagem(View view) {
        coverSelected = ((ImageView) findViewById(R.id.selectedImage)).getDrawable();
        finish();
    }

    public void setImage1(View view) {
        ImageView imagemGrande = findViewById(R.id.selectedImage);
        imagemGrande.setImageResource(images[0]);
    }

    public void setImage2(View view) {
        ImageView imagemGrande = findViewById(R.id.selectedImage);
        imagemGrande.setImageResource(images[1]);
    }

    public void setImage3(View view) {
        ImageView imagemGrande = findViewById(R.id.selectedImage);
        imagemGrande.setImageResource(images[2]);
    }

    public void setImage4(View view) {
        ImageView imagemGrande = findViewById(R.id.selectedImage);
        imagemGrande.setImageResource(images[3]);
    }
}
