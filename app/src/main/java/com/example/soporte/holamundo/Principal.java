package com.example.soporte.holamundo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    //Declaramos variables
    private EditText cajaNombre;
    private EditText cajaApellido;
    private Intent i;
    private Bundle b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        //Capturamos las cajas
        cajaNombre = (EditText)findViewById(R.id.txtNombre);
        cajaApellido = (EditText)findViewById(R.id.txtApellido);
        //Creamos el objeto intent que sirve para pasar de una actividad a otra
        i = new Intent(this,Saludo.class);
        //Creamos el objeto Bundle que sirve para encapsular datos
        b = new Bundle();

    }


    public void saludar(View v){
        String nomb, apell;
      if(validar()) {
            //Tomo el valor que la persona ingresó tanto en nombre como en apellido
            nomb = cajaNombre.getText().toString();
            apell = cajaApellido.getText().toString();
           //Encapsulo los valores previamente tomados
            b.putString("Nombre", nomb);
            b.putString("Apellido", apell);
            //Le paso al intent todos los datos en forma encapsulada con el bundle
            i.putExtras(b);
            //Arranco la actividad que le intent me diga
            startActivity(i);
        }
    }

    public boolean validar(){
        if(cajaNombre.getText().toString().isEmpty()){
           cajaNombre.setError(getResources().getString(R.string.error_1));
            // Toast.makeText(this,"Digite por favor el nombre",Toast.LENGTH_SHORT).show();
            return false;
        }
       if (cajaApellido.getText().toString().isEmpty()){
           cajaApellido.setError(getResources().getString(R.string.error_2));

           //Toast.makeText(this,"Digite por favor el Apellido",Toast.LENGTH_SHORT).show();
          return false;
        }
        return true;
    }
}















