package com.iacc.kevin_ross_martinez_dinoco.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.iacc.kevin_ross_martinez_dinoco.entidades.Productos;

import java.lang.reflect.Array;
import java.util.ArrayList;

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
            id = db.insert(TABLE_PRODUCTOS, null, values);

        } catch (Exception ex) {
            ex.toString();
        }
        return id;
    }

    // METODO MOSTRA DATOS.


    public ArrayList<Productos> leerContactos() {

        DbHelper dbHelper = new DbHelper(context);
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ArrayList<Productos> listarProductos = new ArrayList<>();
        // Varibale
        Productos productos = null;
        // crear cursor
        Cursor cursorProductos = null;

        // se genera consulta a la base de datos devolviendo una respuesta de tipo cursor
        cursorProductos = db.rawQuery(" SELECT * FROM " + TABLE_PRODUCTOS, null);
        // validacion
        if (cursorProductos.moveToFirst()) {
            do {
                productos = new Productos();
                productos.setId(cursorProductos.getInt(0));
                productos.setNombre(cursorProductos.getString(1));
                productos.setPlanta(cursorProductos.getString(2));
                productos.setCantidad(cursorProductos.getString(3));
                productos.setFecha(cursorProductos.getString(4));
                listarProductos.add(productos);
            }
            while (cursorProductos.moveToNext());
        }
        cursorProductos.close();
        return listarProductos;
    }


}
