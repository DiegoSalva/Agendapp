package com.srxlpx.agendapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ConfirmarDatos extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFechaNacimiento;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        botonEditarDatos(); //Llama al listener para el botón Editar Datos

        //Se obtienen los datos de la vista anterior
        Bundle datos = getIntent().getExtras();
        String nombre = datos.getString("nombre");
        String fechaNacimiento = datos.getString("fechaNacimiento");
        String telefono = datos.getString("telefono");
        String email = datos.getString("email");
        String descripcion = datos.getString("descripcion");

        //Se asignan los TextViews a las variables
        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvFechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion = (TextView) findViewById(R.id.tvDescripcion);

        //Se asigna el valor de las variables a los TextViews
        tvNombre.setText("Nombre: " + nombre);
        tvFechaNacimiento.setText(fechaNacimiento);
        tvTelefono.setText("Telefono: "+telefono);
        tvEmail.setText("Email: "+email);
        tvDescripcion.setText("Descripción: "+descripcion);
    }

    private void botonEditarDatos() {
        Button boton_EditarDatos = (Button) findViewById(R.id.btnEditar);
        assert boton_EditarDatos != null;
        boton_EditarDatos.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent actividadPrincipal = getIntent();
                actividadPrincipal.putExtra("nombre",tvNombre.getText().toString());
                actividadPrincipal.putExtra("fechaNacimiento",tvFechaNacimiento.getText().toString());
                actividadPrincipal.putExtra("telefono",tvTelefono.getText().toString());
                actividadPrincipal.putExtra("email",tvEmail.getText().toString());
                actividadPrincipal.putExtra("descripcion",tvDescripcion.getText().toString());
                setResult(RESULT_OK, actividadPrincipal);
                finish();
            }
        });
    }
}
