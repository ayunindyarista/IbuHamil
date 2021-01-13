package com.example.ibuhamil;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageView;

public class DashboardRelawan extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard_relawan);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());

        ImageView buttonEvaluasi = (ImageView) findViewById(R.id.evaluasi);
        ImageView buttonPemeriksaan = (ImageView) findViewById(R.id.pemeriksaan);
        ImageView buttonPasien = (ImageView) findViewById(R.id.pasien);
        ImageView buttonNewPasien = (ImageView) findViewById(R.id.newPasien);
        ImageView buttonNewPemeriksaan = (ImageView) findViewById(R.id.newPemeriksaan);
        ImageView buttonNotification = (ImageView) findViewById(R.id.notification);
        buttonEvaluasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardRelawan.this, evaluasi.class);
                startActivity(intent);
            }
        });
        buttonPemeriksaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardRelawan.this, pemeriksaan.class);
                startActivity(intent);
            }
        });
        buttonPasien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardRelawan.this, pasien.class);
                startActivity(intent);
            }
        });
        buttonNewPasien.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardRelawan.this, insert_pasien.class);
                startActivity(intent);
            }
        });
        buttonNewPemeriksaan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardRelawan.this, insert_pemeriksaan.class);
                startActivity(intent);
            }
        });
        buttonNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DashboardRelawan.this, notification.class);
                startActivity(intent);
            }
        });


    }
}