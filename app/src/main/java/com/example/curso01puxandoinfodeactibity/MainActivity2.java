package com.example.curso01puxandoinfodeactibity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {

    private EditText campoNome;
    private Button enviar;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        campoNome = findViewById(R.id.editNovoNome);
        enviar = findViewById(R.id.btnOk);

        i = getIntent();
        campoNome.setText(i.getExtras().getString("nome"));

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                i.putExtra("nome", campoNome.getText().toString());
                setResult(2, i); // pode ser o mesmo valor da MainActivity
                finish();


            }
        });
    }
}