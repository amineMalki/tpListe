package com.example.listelistes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import database.ItemAdapter;
import database.ListeAdapter;
import models.ListeItems;

public class EditionListingActivity extends AppCompatActivity {

    private Intent afficherListeIntent;
    private EditText txtNomListe;

    private ListeAdapter listeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edition_listing);
        setWidgets();

        listeAdapter = new ListeAdapter(EditionListingActivity.this);
    }

    private void setWidgets() {
        txtNomListe = findViewById(R.id.txtNomListe);
    }

    public void onCreerListe(View view) {

        String nomListe = txtNomListe.getText().toString();

        listeAdapter.insererListe(new ListeItems(nomListe));

        afficherListeIntent = new Intent(EditionListingActivity.this, ListingItemActivity.class);
        startActivity(afficherListeIntent);
    }
}