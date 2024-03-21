package com.databaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText nombre, cedula, telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre = findViewById(R.id.nombre);
        cedula = findViewById(R.id.cedula);
        telefono = findViewById(R.id.telefono);
    }

    public void registrar(View vista){
        AdminDB admin = new AdminDB(this, "estudiantes", null, 1);
        SQLiteDatabase baseDatos = admin.getWritableDatabase();
        String documento = cedula.getText().toString();
        String name = nombre.getText().toString();
        String phone = telefono.getText().toString();
        if(!documento.isEmpty()){
            Cursor fila = baseDatos.rawQuery("SELECT cedula FROM usuario WHERE cedula =" + documento, null);
            if (fila.moveToFirst()){
                String idPersona = fila.getString(0);
                if (!idPersona.isEmpty()){
                    Toast.makeText(this, "Usuario ya existe", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (!documento.isEmpty() && !name.isEmpty() && !phone.isEmpty()){
                        ContentValues registro = new ContentValues();
                        registro.put("cedula", documento);
                        registro.put("nombre", name);
                        registro.put("telefono", phone);
                        baseDatos.insert("usuario", null, registro);
                        baseDatos.close();
                        Toast.makeText(this, "Usuario a sido creado", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        }
    }
}