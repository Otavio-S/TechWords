package com.example.otavio.bicjr.Controller;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.otavio.bicjr.R;

public class TelaInstrucoes extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testebanco);

        Button btnTeste = (Button) findViewById(R.id.btnSalvar);

        btnTeste.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context contexto = getApplicationContext();
                String texto = "exemplo toast";
                int duracao = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(contexto, texto, duracao);
                toast.show();
            }
        });
    }
}
