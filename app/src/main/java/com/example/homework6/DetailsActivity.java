package com.example.homework6;

import android.content.Intent;
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
    private TextView tvName;
    private TextView tvCapital;
    private TextView tvSquare;
    private ImageView ivFlag;

    private TextView tvPopulation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Получаем данные о стране из Intent
        Intent intent = getIntent();
        Country country = (Country) intent.getSerializableExtra("country");

        // Находим все TextView и ImageView в макете
        tvName = findViewById(R.id.countryName);
        tvCapital = findViewById(R.id.capitalText);
        tvSquare = findViewById(R.id.squareText);
        ivFlag = findViewById(R.id.flagImageView);
        tvPopulation = findViewById(R.id.populationText);

        // Устанавливаем текст для TextView
        tvName.setText("Название: " + country.getName());
        tvCapital.setText("Столица: " + country.getCapital());
        tvSquare.setText("Площадь: " + country.getArea() + " М2");
        tvPopulation.setText("Население: " + country.getPopulation() + " человек");

        // Загружаем изображение флага с помощью Glide
        Glide.with(this)
                .load(country.getFlags().png)
                .into(ivFlag);
    }
}

