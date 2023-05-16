package com.example.listelistes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import database.ItemAdapter;
import database.ListeAdapter;
import models.Item;
import models.ListeItems;

public class EditionItemActivity extends AppCompatActivity {

    private Intent afficherListeIntent;
    private EditText txtNomNewItem;

    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edition_item);
        setWidgets();

        itemAdapter = new ItemAdapter(EditionItemActivity.this);
    }

    private void setWidgets() {
        txtNomNewItem = findViewById(R.id.txtNomNewItem);
    }


    public void onAjouterItem(View view) {

        String nomItem = txtNomNewItem.getText().toString();

        itemAdapter.insererItem(new Item(nomItem));

        afficherListeIntent = new Intent(EditionItemActivity.this, ListingItemActivity.class);
        startActivity(afficherListeIntent);
    }
}