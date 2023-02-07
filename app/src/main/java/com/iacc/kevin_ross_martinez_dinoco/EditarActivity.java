package com.iacc.kevin_ross_martinez_dinoco;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.iacc.kevin_ross_martinez_dinoco.db.DbProductos;
import com.iacc.kevin_ross_martinez_dinoco.entidades.Productos;

public class EditarActivity extends AppCompatActivity {
    EditText txtNombre, txtPlanta, txtCantidad, txtFecha;
    Button btnGuarda;
    Productos producto;
    FloatingActionButton fabEditar, fabEliminar;

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
            public void onClick(View v) {

            }

        });
    }
}
//https://www.youtube.com/watch?v=JLvRRJkEmE8&ab_channel=C%C3%B3digosdeProgramaci%C3%B3n-MR

//https://github.com/CodigosdeProgramacion/Agenda/blob/main/app/src/main/java/com/cdp/agenda/EditarActivity.java