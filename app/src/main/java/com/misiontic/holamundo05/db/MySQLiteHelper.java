package com.misiontic.holamundo05.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MySQLiteHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "app_05_db.sqlite";
    private static final int DB_VERSION = 1;

    private static final String PEOPLE_TABLE_CREATE = "CREATE TABLE personas(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                                        "nombres TEXT, apellidos TEXT, direccion TEXT, telefono TEXT, " +
                                                        "fecha_nacimiento DATE, foto TEXT)";


    public MySQLiteHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PEOPLE_TABLE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    public boolean insertData(String sentence) {
        boolean success = false;
        try {
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL(sentence);
            success = true;
        } catch (Exception e) {
            success = false;
        }
        return success;
    }

}
