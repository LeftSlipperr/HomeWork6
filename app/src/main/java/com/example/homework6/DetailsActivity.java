package com.example.homework6;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.homework6.R;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        String flagUrl = getIntent().getStringExtra("flagUrl");
        String countryName = getIntent().getStringExtra("countryName");
        String capitalName = getIntent().getStringExtra("capitalName");
        int square = getIntent().getIntExtra("square", 0);

        TextView countryNameTextView = findViewById(R.id.textCountry);
        TextView capitalNameTextView = findViewById(R.id.textCapital);
        TextView squareTextView = findViewById(R.id.squareText);
        ImageView flagImageView = findViewById(R.id.flagDetails);

        countryNameTextView.setText(countryName);
        capitalNameTextView.setText(capitalName);
        squareTextView.setText("Square: " + square + " km2");

        Glide.with(this)
                .load(flagUrl)
                .into(flagImageView);
    }
}