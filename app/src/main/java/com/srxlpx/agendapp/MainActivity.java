package com.srxlpx.agendapp;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    public final static int MI_CODIGO_REQUEST = 1;

    public static TextView tvfechaNacimiento;
    private TextInputEditText tiInputNombre;
    private TextInputEditText tiInputTelefono;
    private TextInputEditText tiInputEmail;
    private TextInputEditText tiDescripcion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvfechaNacimiento = (TextView) findViewById(R.id.tvFechaNacimiento);
        tiInputNombre = (TextInputEditText) findViewById(R.id.tiInputNombre);
        tiInputTelefono = (TextInputEditText) findViewById(R.id.tiInputTelefono);
        tiInputEmail = (TextInputEditText) findViewById(R.id.tiInputEmail);
        tiDescripcion = (TextInputEditText) findViewById(R.id.tiInputDescripcion);

        //Llama al Listener del botón Siguiente
        botonSiguiente();

    }


    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState){
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR); //Obtiene el año actual
            int month = c.get(Calendar.MONTH); //Obtiene el mes actual
            int day = c.get(Calendar.DAY_OF_MONTH); //Obtiene el día actual

            DatePickerDialog dialogDatePicker = new DatePickerDialog(getActivity(), this, year, month, day);
            dialogDatePicker.getDatePicker().setCalendarViewShown(false); //Presenta solo el Spinner, cancela el calendario
            return dialogDatePicker;
        }

        public void onDateSet (DatePicker v, int year, int month, int day){
            //Al presionale l boton de Listo, Regresa la cadena con la fecha de nacimiento
            tvfechaNacimiento.setText("Fecha de Nacimiento: "+(month+1)+"/"+day+"/"+year);
        }
    }

    public void muestraDatePickerDialog(View v) {
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "Fecha de Nacimiento");

    }

    public void botonSiguiente (){
        Button boton_Siguiente = (Button) findViewById(R.id.btnSiguiente);
        assert boton_Siguiente != null;
        boton_Siguiente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent detalleContacto = new Intent(getApplicationContext(), ConfirmarDatos.class);
                detalleContacto.putExtra("nombre",tiInputNombre.getText().toString());
                detalleContacto.putExtra("fechaNacimiento",tvfechaNacimiento.getText().toString());
                detalleContacto.putExtra("telefono",tiInputTelefono.getText().toString());
                detalleContacto.putExtra("email",tiInputEmail.getText().toString());
                detalleContacto.putExtra("descripcion",tiDescripcion.getText().toString());
                startActivityForResult(detalleContacto,MI_CODIGO_REQUEST);
                //finish();
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Bundle data){
        if(resultCode==RESULT_OK){
            Bundle datos = getIntent().getExtras();
            String nombre = datos.getString("nombre");
            String fechaNacimiento = datos.getString("fechaNacimiento");
            String telefono = datos.getString("telefono");
            String email = datos.getString("email");
            String descripcion = datos.getString("descripcion");

            //Se asigna el valor de las variables a los TextViews
            tiInputNombre.setText("Nombre: " + nombre);
            tvfechaNacimiento.setText(fechaNacimiento);
            tiInputTelefono.setText("Telefono: "+telefono);
            tiInputEmail.setText("Email: "+email);
            tiDescripcion.setText("Descripción: "+descripcion);
        }
    }
}