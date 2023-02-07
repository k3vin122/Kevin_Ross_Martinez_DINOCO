package com.iacc.kevin_ross_martinez_dinoco.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbProductos extends DbHelper {

    Context context;

    public DbProductos(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    // metodo insertar registros a la tabla t_productos

    public long insertarProducto(String nombre, String planta, String cantidad, String fecha) {
        long id = 0;

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();

            values.put("nombre", nombre);
            values.put("planta", planta);
            values.put("cantidad", cantidad);
            values.put("fecha", fecha);
            db.insert(TABLE_PRODUCTOS, null, values);

        } catch (Exception ex) {
            ex.toString();
        }
        return id;
    }
}
