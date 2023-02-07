package com.iacc.kevin_ross_martinez_dinoco;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.iacc.kevin_ross_martinez_dinoco.db.DbHelper;

public class MainActivity extends AppCompatActivity {
    Button btnCrear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCrear = findViewById(R.id.btnCrear);
        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper dbHelper = new DbHelper(MainActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if (db != null) {

                    Toast.makeText(MainActivity.this, "Base de datos creada con exito", Toast.LENGTH_LONG).show();
                } else {

                    Toast.makeText(MainActivity.this, "Ups! Algo salio mal", Toast.LENGTH_LONG).show();
                }
            }
        });
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
