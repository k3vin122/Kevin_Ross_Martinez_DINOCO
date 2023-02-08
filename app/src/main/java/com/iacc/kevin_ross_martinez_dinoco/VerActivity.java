package com.iacc.kevin_ross_martinez_dinoco;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.iacc.kevin_ross_martinez_dinoco.db.DbProductos;
import com.iacc.kevin_ross_martinez_dinoco.entidades.Productos;

public class VerActivity extends AppCompatActivity {
    EditText txtNombre, txtPlanta, txtCantidad, txtFecha;
    Button btnGuarda;
    Productos producto;
    Button fabEditar, fabEliminar;

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
        btnGuarda.setVisibility(View.INVISIBLE);


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
        DbProductos dbProductos = new DbProductos(VerActivity.this);
        producto = dbProductos.verProducto(id);

        if (producto != null) {
            txtNombre.setText(producto.getNombre());
            txtPlanta.setText(producto.getPlanta());
            txtCantidad.setText(producto.getCantidad());
            txtFecha.setText(producto.getFecha());
            btnGuarda.setVisibility(View.INVISIBLE);

            //bloquear los imput para no se habra el teclado
            txtNombre.setInputType(InputType.TYPE_NULL);
            txtPlanta.setInputType(InputType.TYPE_NULL);
            txtCantidad.setInputType(InputType.TYPE_NULL);
            txtFecha.setInputType(InputType.TYPE_NULL);

        }
        fabEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VerActivity.this, EditarActivity.class);
                intent.putExtra("ID", id);
                startActivity(intent);
            }
        });

        fabEliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(VerActivity.this);
                builder.setMessage("¿Este Registro se eliminara?")
                    .setPositiveButton("SI", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //metodo eliminar  de DbProductos

                            if (dbProductos.eliminarContacto(id)) {
                                lista_redirec();
                            }
                        }
                    })
                    .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).show();


            }
        });
    }

    private void lista_redirec() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
