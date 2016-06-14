package com.example.miguelvzz.datospersonales;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    final Calendar fecha_actual = Calendar.getInstance();
    int anio;
    int mes;
    int dia;
    static final int DIALOG_ID = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_siguiente = (Button) findViewById(R.id.btn_siguiente);
        btn_siguiente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent  intent = new Intent(MainActivity.this, DetalleContacto.class);
                //intent.putExtra("Nombre", et_nombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.et_nombre), ((EditText) findViewById(R.id.et_nombre)).getText().toString());
                intent.putExtra(getResources().getString(R.string.et_fec_naci),((EditText) findViewById(R.id.et_fec_nacimiento)).getText().toString());
                intent.putExtra(getResources().getString(R.string.et_telefono), ((EditText) findViewById(R.id.et_telefono)).getText().toString());
                intent.putExtra(getResources().getString(R.string.et_email), ((EditText) findViewById(R.id.et_email)).getText().toString());
                intent.putExtra(getResources().getString(R.string.et_descrip), ((EditText) findViewById(R.id.et_desc)).getText().toString());

                startActivity(intent);
                finish();
            }
        });

        Bundle parametros = getIntent().getExtras();

        if(parametros != null) {


            ((TextView) findViewById(R.id.et_nombre)).setText(parametros.getString(getResources().getString(R.string.et_nombre)));
            ((TextView) findViewById(R.id.et_fec_nacimiento)).setText(parametros.getString(getResources().getString(R.string.et_fec_naci)));
            ((TextView) findViewById(R.id.et_telefono)).setText(parametros.getString(getResources().getString(R.string.et_telefono)));
            ((TextView) findViewById(R.id.et_email)).setText(parametros.getString(getResources().getString(R.string.et_email)));
            ((TextView) findViewById(R.id.et_desc)).setText(parametros.getString(getResources().getString(R.string.et_descrip)));

        }

        anio = fecha_actual.get(Calendar.YEAR);
        mes = fecha_actual.get(Calendar.MONTH) + 1;
        dia = fecha_actual.get(Calendar.DAY_OF_MONTH);
        final String fecha = dia + "/" + mes + "/" + anio;

        ((EditText) findViewById(R.id.et_fec_nacimiento)).setText(fecha);

        mostrarDatePicker();

    }

    public void mostrarDatePicker(){

        Button b_sfecha = (Button) findViewById(R.id.btn_fecha);

        b_sfecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog(DIALOG_ID);
            }
        });

    }

    @Override
    protected Dialog onCreateDialog(int id) {

        if(id == DIALOG_ID){

            return new DatePickerDialog(this,R.style.Picker_fecha,datepickerListener, anio,mes,dia);
        }

        return null;
    }

    private DatePickerDialog.OnDateSetListener datepickerListener = new DatePickerDialog.OnDateSetListener(){
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth){

            anio = year;
            mes = monthOfYear + 1;
            dia = dayOfMonth;

            String fecha1 = dia + "/" + mes + "/" + anio;

            ((EditText) findViewById(R.id.et_fec_nacimiento)).setText(fecha1);

        }
    };

}
