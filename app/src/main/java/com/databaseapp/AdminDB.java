package com.databaseapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminDB extends SQLiteOpenHelper {
    public AdminDB(@Nullable Context context, @Nullable String nombre, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nombre, factory, version);
    }

    //construir la base de datos
    @Override
    public void onCreate(SQLiteDatabase baseDatos){
        baseDatos.execSQL("CREATE TABLE usuario(cedula int primary key, nombre text, telefono int)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int j){

    }
}
