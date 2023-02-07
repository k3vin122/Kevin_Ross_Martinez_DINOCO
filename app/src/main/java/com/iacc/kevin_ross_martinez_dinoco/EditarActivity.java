package com.iacc.kevin_ross_martinez_dinoco;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.iacc.kevin_ross_martinez_dinoco.db.DbProductos;
import com.iacc.kevin_ross_martinez_dinoco.entidades.Productos;

public class EditarActivity extends AppCompatActivity {
    EditText txtNombre, txtPlanta, txtCantidad, txtFecha;
    Button btnGuarda;
    Productos producto;
    Button fabEditar, fabEliminar;
    boolean x1 = false;

    int id = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver);

        txtNombre = findViewById(R.id.txtNombre);
        txtPlanta = findViewById(R.id.txtPlanta);
        txtCantidad = findViewById(R.id.txtCantidad);
        txtFecha = findViewById(R.id.txtFecha);

        fabEditar = findViewById(R.id.fabEditar);
        fabEliminar = findViewById(R.id.fabEliminar);
        btnGuarda = findViewById(R.id.btnGuarda);
        //btnGuarda.setVisibility(View.INVISIBLE);


        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                id = Integer.parseInt(null);
            } else {
                id = extras.getInt("ID");
            }
        } else {
            id = (int) savedInstanceState.getSerializable("ID");
        }
        DbProductos dbProductos = new DbProductos(EditarActivity.this);
        producto = dbProductos.verProducto(id);

        if (producto != null) {
            txtNombre.setText(producto.getNombre());
            txtPlanta.setText(producto.getPlanta());
            txtCantidad.setText(producto.getCantidad());
            txtFecha.setText(producto.getFecha());
        }

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!txtNombre.getText().toString().equals("") && !txtPlanta.getText().toString().equals("")) {
                    x1 = dbProductos.editarProducto(id, txtNombre.getText().toString(), txtPlanta.getText().toString(), txtCantidad.getText().toString(), txtFecha.getText().toString());

                    if (x1) {
                        Toast.makeText(EditarActivity.this, "REGISTRO MODIFICADO", Toast.LENGTH_LONG).show();
                        verRegistro();
                    } else {
                        Toast.makeText(EditarActivity.this, "ERROR AL MODIFICAR REGISTRO", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(EditarActivity.this, "DEBE LLENAR LOS CAMPOS OBLIGATORIOS", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void verRegistro() {
        Intent intent = new Intent(this, VerActivity.class);
        intent.putExtra("ID", id);
        startActivity(intent);
    }
}



