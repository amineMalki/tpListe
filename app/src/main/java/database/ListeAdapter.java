package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import models.ListeItems;

public class ListeAdapter {
    private final Context context;
    private SQLiteDatabase db;
    private ItemOpenHelper dbHelper;

    public ListeAdapter(Context context) {
        this.context = context;
        this.dbHelper = new ItemOpenHelper(context, ItemOpenHelper.DB_NAME, null, ItemOpenHelper.VERSION);
    }

    public void insererListe(ListeItems listeItems) {

        openBD();

        String nomListe = listeItems.getNom();
        ContentValues cv = new ContentValues();
        cv.put(ItemOpenHelper.COL_NOMLISTE, nomListe);
        db.insert(ItemOpenHelper.TABLE_LISTE, null,cv);
        Toast.makeText(context, "Ajout réussi", Toast.LENGTH_SHORT).show();

        fermerBD();
        
    }



    private void openBD() {
        db = dbHelper.getWritableDatabase();
    }

    private void fermerBD() {
        db.close();
    }
}
