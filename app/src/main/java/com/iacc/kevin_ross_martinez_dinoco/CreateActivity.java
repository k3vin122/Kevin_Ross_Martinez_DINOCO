package com.iacc.kevin_ross_martinez_dinoco;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.iacc.kevin_ross_martinez_dinoco.db.DbProductos;

public class CreateActivity extends AppCompatActivity {

    EditText txt_nombre, txt_planta, txt_cantidad, txt_fecha;
    Button btnGuardar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        txt_nombre = findViewById(R.id.txt_nombre);
        txt_planta = findViewById(R.id.txt_planta);
        txt_cantidad = findViewById(R.id.txt_cantidad);
        txt_fecha = findViewById(R.id.txt_fecha);

        btnGuardar = findViewById(R.id.btnGuardar);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbProductos dbContactos = new DbProductos(CreateActivity.this);
                long id = dbContactos.insertarProducto(txt_nombre.getText().toString(), txt_planta.getText().toString(), txt_cantidad.getText().toString(), txt_fecha.getText().toString());

                if (id > 0) {

                    Toast.makeText(CreateActivity.this, "DATOS INGRESADOS CORRECTAMENTE", Toast.LENGTH_LONG).show();
                    limpiar();
                } else {

                    Toast.makeText(CreateActivity.this, "ERROR AL GUARDAR!", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
    // METODO LIMPIAR LOS CAMPOS AL GUARADAR

    private void limpiar() {
        txt_nombre.setText("");
        txt_planta.setText("");
        txt_cantidad.setText("");
        txt_fecha.setText("");
    }
}
