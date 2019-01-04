package com.example.otavio.techwords.Controller.ControllerDesafios;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.example.otavio.techwords.BancoSQLite.BancoDisciplinas;
import com.example.otavio.techwords.Model.Disciplina;
import com.example.otavio.techwords.R;

public class TelaConclusao extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_conclusao);

        Handler handler = new Handler();

        handler.postDelayed(new Runnable() {
            public void run() {
                finish();
            }
        }, 5000);

        BancoDisciplinas bancoDisciplinas = new BancoDisciplinas(getApplicationContext());
        bancoDisciplinas.carregaDados();

        TextView txtDis = findViewById(R.id.txtDis);

        Intent intent = getIntent();
        int disciplina = intent.getIntExtra("disciplina", 0);

        String nome = "";
        int n = bancoDisciplinas.carregaDados().size();
        for (int i = 0; i < n; i++) {
            if (bancoDisciplinas.carregaDados().get(i).getId() == disciplina) {
                nome = bancoDisciplinas.carregaDados().get(i).getDisciplina();
                bancoDisciplinas.alteraRegistro(disciplina);
                break;
            }
        }

        String congrats = "Você concluiu a disciplina de " + nome + ". Parabéns!";

        txtDis.setText(congrats);


    }

}
