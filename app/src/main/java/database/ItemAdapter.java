package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import java.util.ArrayList;

import models.Item;

public class ItemAdapter {

    private final Context context;
    private SQLiteDatabase db;
    private ItemOpenHelper dbHelper;

    public ItemAdapter(Context context) {
        this.context = context;
        this.dbHelper = new ItemOpenHelper(context, ItemOpenHelper.DB_NAME, null, ItemOpenHelper.VERSION);
    }
    public Cursor selectionnerItems() {

        //ouvrir BD
        openBD();

        //recuperer data
        //indiquer les col du select
        String[] cols ={ItemOpenHelper.COL_ID, ItemOpenHelper.COL_NOM, ItemOpenHelper.COL_ETAT};
        return db.query(ItemOpenHelper.TABLE_ITEM, cols,null,null,
                null, null,null, null);


    }

    private void openBD() {
        db = dbHelper.getWritableDatabase();
    }

    private void fermerBD() {
        db.close();
    }

    public void insererItem(Item item) {
        openBD();

        String nomItem = item.getNom();
        ContentValues cv = new ContentValues();
        cv.put(ItemOpenHelper.COL_NOM, nomItem);
        db.insert(ItemOpenHelper.TABLE_ITEM, null,cv);
        Toast.makeText(context, "Ajout réussi", Toast.LENGTH_SHORT).show();

        fermerBD();
    }
}
