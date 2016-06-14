package com.example.miguelvzz.datospersonales;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleContacto extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacto_detalle);

        MainActivity ma = new MainActivity();
        Bundle parametros = getIntent().getExtras();

        ((TextView) findViewById(R.id.tv_nombre)).setText(parametros.getString(getResources().getString(R.string.et_nombre)));
        ((TextView) findViewById(R.id.tv_fec_nac)).setText(parametros.getString(getResources().getString(R.string.et_fec_naci)));
        ((TextView) findViewById(R.id.tv_telefono)).setText(parametros.getString(getResources().getString(R.string.et_telefono)));
        ((TextView) findViewById(R.id.tv_email)).setText(parametros.getString(getResources().getString(R.string.et_email)));
        ((TextView) findViewById(R.id.tv_desc)).setText(parametros.getString(getResources().getString(R.string.et_descrip)));

        //Toast.makeText(this, getResources().getString(R.string.et_fec_naci), Toast.LENGTH_LONG).show();

        Button btn_editar = (Button) findViewById(R.id.btn_editar);
        btn_editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalleContacto.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.et_nombre), ((TextView) findViewById((R.id.tv_nombre))).getText().toString());
                intent.putExtra(getResources().getString(R.string.et_fec_naci), ((TextView) findViewById((R.id.tv_fec_nac))).getText().toString());
                intent.putExtra(getResources().getString(R.string.et_telefono), ((TextView) findViewById((R.id.tv_telefono))).getText().toString());
                intent.putExtra(getResources().getString(R.string.et_email), ((TextView) findViewById((R.id.tv_email))).getText().toString());
                intent.putExtra(getResources().getString(R.string.et_descrip), ((TextView) findViewById((R.id.tv_desc))).getText().toString());
                startActivity(intent);
                finish();
            }
        });

    }
}
