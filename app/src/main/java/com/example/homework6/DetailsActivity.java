package com.example.homework6;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String flagUrl = getIntent().getStringExtra("flagUrl"); // Используем URL вместо ID

        ImageView flag = findViewById(R.id.imageView);
        Glide.with(this).load(flagUrl).into(flag);
        // Получение данных из Intent
        String countryName = getIntent().getStringExtra("countryName");
        String capitalName = getIntent().getStringExtra("capitalName");
        Integer square = getIntent().getIntExtra("square", 0);
//        Integer flagId = getIntent().getIntExtra("flagId", 0);

        // Отображение страны
        TextView countryText = findViewById(R.id.textCountry);
        countryText.setText(countryName);
//        flag.setImageResource(flagId);
        TextView capitalText = findViewById(R.id.textCapital);
        capitalText.setText("Столица: "+ capitalName);
        TextView squareText = findViewById(R.id.squareText);
        squareText.setText("Площадь: "+square.toString());
    }
}