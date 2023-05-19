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

public class MainActivity extends AppCompatActivity {

    public EditText nombreEditd;
    private String nombreString;

    public TextView nombreTextView;
    public String valor;

    public EditText numeroEditext;
    public EditText numeroEditext2;

    public Number numero1;
    public Number numero2;

    //creo una lista de intent   //acceder a los resultados
    ActivityResultLauncher<Intent> activityResultLauncher =
            registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                    new ActivityResultCallback<ActivityResult>() {
        @Override                   //ActivityResult es el resultado de  una actividad
        public void onActivityResult(ActivityResult result) {
            //obtener el resultado cuando se cierra un layaout
            if (result.getResultCode() == Activity.RESULT_OK){
                //Intent intent = result.getData();
                //valor= intent.getStringExtra("nombre2");
            }
        }
    });


    //onCreate siempre se ejecuta primero
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findViewById realciona la varia edit para que se puede trabajar con ella
        //ya que no se puede trabajar con ella directamente
       nombreEditd = findViewById(R.id.editText_nombre);
                //getText tomo el texto de la variable

       nombreTextView = findViewById(R.id.textView_nombreFinal);

        //nombref.setText(valor);


        //////////el nombre del secondlayaut

        Intent intent = getIntent();
        nombreString = intent.getStringExtra("nombrefinal");
        nombreTextView.setText(nombreString);




    }


    //                  View es una clase, View es un requisito para que reconosca el onlclick
    public void aceptar(View view){
        //Intent en un hilo entre 2 pantallas
        nombreString = (nombreEditd.getText().toString());

        Intent intent = new Intent(MainActivity.this, secondlayout.class);
                        //name nombreRefencia referencio a la variable nombre
                        //envia clave y valor
        intent.putExtra("nombreReferencia", nombreString);

        startActivity(intent);


    }



}