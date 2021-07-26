package com.example.tokengenerator;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.tokengenerator.utilities.Utilities;

public class DataBase extends SQLiteOpenHelper {


    public DataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Utilities.USER_TOKEN_NAME);
        db.execSQL(Utilities.USER_TOKEN_CODE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + Utilities.TOKEN_NAME_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Utilities.TOKEN_CODE_TABLE);
        onCreate(db);
    }
}
