package com.example.otavio.techwords.Controller.ControllerDesafios;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.otavio.techwords.BancoSQLite.BancoPalavras;
import com.example.otavio.techwords.R;

public class TelaDesafio3 extends AppCompatActivity {

    private BancoPalavras bancoPalavras = new BancoPalavras(this);

    private int i;
    private int word1 = i - 4;
    private int word2 = i - 3;
    private int word3 = i - 2;
    private int word4 = i - 1;
    private int word5 = i;

    private Button btnVerificar;
    private View.OnClickListener btnVerificarOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_desafio3);

        Intent intent = getIntent();
        this.i = intent.getIntExtra("id", 0);

        this.word1 = i - 4;
        this.word2 = i - 3;
        this.word3 = i - 2;
        this.word4 = i - 1;
        this.word5 = i;

        //this.inserirPalavras();
        //this.inserirDescricoes();

        btnVerificar = findViewById(R.id.btnChecar);
        btnVerificar.setOnClickListener(btnVerificarOnClick);

    }

    /*private void inserirPalavras() {
        btnPalavra1.setId(word1);
        String palavra1 = bancoPalavras.carregaDadosPorID(word1).get(0).getPalavra();
        btnPalavra1.setText(palavra1);

        btnPalavra2.setId(word2);
        String palavra2 = bancoPalavras.carregaDadosPorID(word2).get(0).getPalavra();
        btnPalavra2.setText(palavra2);

        btnPalavra3.setId(word3);
        String palavra3 = bancoPalavras.carregaDadosPorID(word3).get(0).getPalavra();
        btnPalavra3.setText(palavra3);

        btnPalavra4.setId(word4);
        String palavra4 = bancoPalavras.carregaDadosPorID(word4).get(0).getPalavra();
        btnPalavra4.setText(palavra4);

        btnPalavra5.setId(word5);
        String palavra5 = bancoPalavras.carregaDadosPorID(word5).get(0).getPalavra();
        btnPalavra5.setText(palavra5);
    }

    private void inserirDescricoes() {
        btnDescricao1.setId(word1);
        String descricao1 = bancoPalavras.carregaDadosPorID(word1).get(0).getDescricao();
        btnDescricao1.setText(descricao1);

        btnDescricao2.setId(word2);
        String descricao2 = bancoPalavras.carregaDadosPorID(word2).get(0).getDescricao();
        btnDescricao2.setText(descricao2);

        btnDescricao3.setId(word3);
        String descricao3 = bancoPalavras.carregaDadosPorID(word3).get(0).getDescricao();
        btnDescricao3.setText(descricao3);

        btnDescricao4.setId(word4);
        String descricao4 = bancoPalavras.carregaDadosPorID(word4).get(0).getDescricao();
        btnDescricao4.setText(descricao4);

        btnDescricao5.setId(word5);
        String descricao5 = bancoPalavras.carregaDadosPorID(word5).get(0).getDescricao();
        btnDescricao5.setText(descricao5);
    }*/

}
