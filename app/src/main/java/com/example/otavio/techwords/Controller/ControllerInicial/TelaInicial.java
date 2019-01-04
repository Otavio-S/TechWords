package com.example.otavio.techwords.Controller.ControllerInicial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.otavio.techwords.BancoSQLite.BancoPalavras;
import com.example.otavio.techwords.BancoSQLite.DadosIniciais;
import com.example.otavio.techwords.Model.Palavra;
import com.example.otavio.techwords.R;

import java.util.List;

public class TelaInicial extends Activity {

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
            System.exit(0);
            finish();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        BancoPalavras bancoPalavras = new BancoPalavras(getApplicationContext());
        List<Palavra> palavraList = bancoPalavras.carregaDados();

        if (palavraList.isEmpty()) {
            DadosIniciais dadosIniciais = new DadosIniciais();
            dadosIniciais.insereDados(getApplicationContext());
        }

        bancoPalavras.close();

        Button btnPlay = findViewById(R.id.btnPlay);
        btnPlay.setOnClickListener(btnPlayOnClickListener);

        Button btnInstructions = findViewById(R.id.btnInstructions);
        btnInstructions.setOnClickListener(btnInstructionsOnClickListener);

        Button btnExit = findViewById(R.id.btnExit);
        btnExit.setOnClickListener(btnExitOnClickListener);

    }

}
