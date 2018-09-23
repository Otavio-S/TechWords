package com.example.otavio.techwords.Controller.ControllerInicial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.otavio.techwords.R;
import com.example.otavio.techwords.TestCRUD;

public class TelaInicial extends AppCompatActivity {

    private View.OnClickListener btnPlayOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(TelaInicial.this, TelaDisciplinas.class);
            startActivity(intent);
        }
    };
    private View.OnClickListener btnInstructionsOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent2 = new Intent(TelaInicial.this, TelaInstrucoes.class);
            startActivity(intent2);
        }
    };
    private View.OnClickListener btnExitOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent3 = new Intent(TelaInicial.this, TestCRUD.class);
            startActivity(intent3);
            //finish();
            //System.exit(0);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        Button btnPlay = findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(btnPlayOnClickListener);

        Button btnInstructions = findViewById(R.id.btnInstructions);
        btnInstructions.setOnClickListener(btnInstructionsOnClickListener);

        Button btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(btnExitOnClickListener);

    }

}
