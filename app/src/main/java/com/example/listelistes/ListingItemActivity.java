package com.example.listelistes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import java.util.ArrayList;

import database.ItemAdapter;
import models.Item;

public class ListingItemActivity extends AppCompatActivity {

    private ListView listing;
    private ItemAdapter itemAdapter;
    private ArrayAdapter<Item> listAdapter;
    private SimpleCursorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listing_item);
        listing = findViewById(R.id.listingItem);
        itemAdapter = new ItemAdapter(ListingItemActivity.this);

        afficherData();
    }

    private void afficherData() {

        // ArrayList<Employe> listo = empAdapter.selectionnerEmployes();
        Cursor curseur = itemAdapter.selectionnerItems();
//        listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,
//                android.R.id.text1, listo);
        String[] from ={"nom", "etat"};
        int[] to = {R.id.txtNomItem, R.id.txtEtatItem};
//        listAdapter = new ArrayAdapter<>(ListingActivity.this, listo, R.layout.itemo);
        adapter = new SimpleCursorAdapter(this,  R.layout.item, curseur,from, to,1);
        listing.setAdapter(adapter);
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edition_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int option = item.getItemId();
        switch (option) {

            case R.id.idAjouter:
                Intent intent = new Intent(this, EditionItemActivity.class);
                startActivity(intent);
                break;

            case R.id.idQuitter:
                Intent intent2 = new Intent(this, MainActivity.class);
                startActivity(intent2);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
    }
