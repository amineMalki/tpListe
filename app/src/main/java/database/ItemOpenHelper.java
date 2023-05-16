package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ItemOpenHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "bdListe";
    public static final int VERSION = 1;
    public  static final String TABLE_ITEM = "ITEM";
    public static final String COL_ID = "_id";
    public  static final String COL_NOM = "nom";
    public  static final String COL_ETAT = "etat";
    private static final String DDL_ITEM = "create table " + TABLE_ITEM + " (" + COL_ID +
            " integer primary key autoincrement," + COL_NOM + " TEXT, " + COL_ETAT +
            " TEXT)";


    public static final String TABLE_LISTE = "liste";

    public static final String COL_NOMLISTE = "nomListe";

    private static final String DDL_LISTE = "create table " + TABLE_LISTE + " (" + COL_ID +
            " integer primary key autoincrement," + COL_NOMLISTE + " TEXT)";

    public ItemOpenHelper(@Nullable Context context,
                          @Nullable String name,
                          @Nullable SQLiteDatabase.CursorFactory factory,
                          int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(DDL_ITEM);
        sqLiteDatabase.execSQL(DDL_LISTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
