package com.example.repaso;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class thirdlayout extends AppCompatActivity {

    public EditText nombreEditext;
    public String nombreString;
    public TextView nombreTextView;

    /*ActivityResultLauncher<Intent> activityResultLauncher =
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
                    });*/


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thirdlayout);

        nombreEditext = findViewById(R.id.editText_nombre3);

        nombreTextView = findViewById(R.id.textView_nombre4);
        Intent intent = getIntent();
        nombreString = intent.getStringExtra("nombrealTercera");
        nombreTextView.setText(nombreString);

    }
}