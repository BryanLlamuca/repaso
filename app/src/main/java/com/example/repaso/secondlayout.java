package com.example.repaso;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class secondlayout extends AppCompatActivity {

    public TextView nomView;
    public String nombreokString;

    public EditText nombre2EditText;
    public String valor;


    ActivityResultLauncher<Intent> activityResultLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
                        @Override                   //ActivityResult es el resultado de  una actividad
                        public void onActivityResult(ActivityResult result) {
                            //obtener el resultado cuando se cierra un layaout
                            if (result.getResultCode() == Activity.RESULT_OK){
                                //Intent intent = result.getData();
                               // valor= intent.getStringExtra("nombre2");
                            }
                        }
                    });

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondlayout);

        nombre2EditText = findViewById(R.id.editText_nombre21);




        nomView = findViewById(R.id.textView_nombreTraido);
                        //obteniendo la referencia anterior
        Intent intent = getIntent();
        //nombreok le estamos cargardo la variable que tenemos con la clave y la referencia
        nombreokString = intent.getStringExtra("nombreReferencia");
        //asigno el contenido de nombreok al textview para qe se muestre
        nomView.setText(nombreokString);

    }



    public void enviarNombre2(View view){
    nombreokString = nombre2EditText.getText().toString();
        Intent intent = new Intent(secondlayout.this, MainActivity.class);

        intent.putExtra("nombrefinal", nombreokString);

        startActivity(intent);
    }


    public void enviarNombreSiguiente(View view){
        nombreokString = nombre2EditText.getText().toString();
        Intent intent = new Intent(secondlayout.this, thirdlayout.class);

        intent.putExtra("nombrealTercera", nombreokString);

        startActivity(intent);
    }
                    //para activar con el botton
   /* public void Enviar(View view){
        Intent intent = new Intent();
        intent.putExtra("nombre2", nombreok);
        setResult(Activity.RESULT_OK,intent);
        super.onBackPressed();

    }*/


    /*public void Enviar(View view){
        nombreok = (nombre2.getText().toString());

       Intent intent = new Intent(secondlayout.this, MainActivity.class);

        intent.putExtra("nombrefinal", nombreok);

        startActivity(intent);
    }*/




}