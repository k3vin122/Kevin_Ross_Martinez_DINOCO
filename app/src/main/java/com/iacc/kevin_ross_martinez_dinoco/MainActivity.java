package com.iacc.kevin_ross_martinez_dinoco;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.iacc.kevin_ross_martinez_dinoco.adaptadores.ListaProductosAdapter;
import com.iacc.kevin_ross_martinez_dinoco.db.DbHelper;
import com.iacc.kevin_ross_martinez_dinoco.db.DbProductos;
import com.iacc.kevin_ross_martinez_dinoco.entidades.Productos;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView listaProductos;
    ArrayList<Productos> listarArrayProductos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaProductos = findViewById(R.id.listaProductos);

        listaProductos.setLayoutManager(new LinearLayoutManager(this));
        DbProductos dbProductos = new DbProductos(MainActivity.this);

        listarArrayProductos = new ArrayList<>();
        ListaProductosAdapter adapter = new ListaProductosAdapter(dbProductos.leerContactos());
        listaProductos.setAdapter(adapter);
    }



    // METODO MOSTRA MENU
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuNuevo:
                nuevoRegistro();
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }


    private void nuevoRegistro() {
        Intent intent = new Intent(this, CreateActivity.class);
        startActivity(intent);

    }
}
