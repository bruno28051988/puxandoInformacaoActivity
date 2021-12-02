package com.example.curso01puxandoinfodeactibity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

     private Button mudarNOme;
     private TextView textoNome;
     private String nome = "usuário";
     Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textoNome = findViewById(R.id.textNome);
        mudarNOme = findViewById(R.id.btnMudarNome);


        textoNome.setText("Ola, "+ nome);


        mudarNOme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent i = new Intent(MainActivity.this, MainActivity2.class);
               i.putExtra("nome", nome);
               startActivityForResult(i,1 );
            }
        });



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == 2 && data != null){
            nome = data.getExtras().getString("nome");
            textoNome.setText("Ola, "+ nome);
        }else{
            Toast.makeText(this, "Resultado inválido", Toast.LENGTH_LONG).show();
        }
    }
}