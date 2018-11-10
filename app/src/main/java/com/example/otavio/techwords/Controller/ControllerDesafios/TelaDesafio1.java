package com.example.otavio.techwords.Controller.ControllerDesafios;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.otavio.techwords.BancoSQLite.BancoPalavras;
import com.example.otavio.techwords.R;

public class TelaDesafio1 extends AppCompatActivity {

    private BancoPalavras bancoPalavras = new BancoPalavras(this);

    private int i;
    private int word1 = i - 4;
    private int word2 = i - 3;
    private int word3 = i - 2;
    private int word4 = i - 1;
    private int word5 = i;

    private Button btnPalavra1;
    private View.OnClickListener btnPalavra1OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    private Button btnPalavra2;
    private View.OnClickListener btnPalavra2OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    private Button btnPalavra3;
    private View.OnClickListener btnPalavra3OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    private Button btnPalavra4;
    private View.OnClickListener btnPalavra4OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    private Button btnPalavra5;
    private View.OnClickListener btnPalavra5OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    private Button btnDescricao1;
    private View.OnClickListener btnDescricao1OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    private Button btnDescricao2;
    private View.OnClickListener btnDescricao2OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    private Button btnDescricao3;
    private View.OnClickListener btnDescricao3OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    private Button btnDescricao4;
    private View.OnClickListener btnDescricao4OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    private Button btnDescricao5;
    private View.OnClickListener btnDescricao5OnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    private Button btnVerificar;
    private View.OnClickListener btnVerificarOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_desafio1);

        Intent intent = getIntent();
        this.i = intent.getIntExtra("id", 0);

        this.word1 = i - 4;
        this.word2 = i - 3;
        this.word3 = i - 2;
        this.word4 = i - 1;
        this.word5 = i;

        btnPalavra1 = findViewById(R.id.btnPalavra1);
        btnPalavra2 = findViewById(R.id.btnPalavra2);
        btnPalavra3 = findViewById(R.id.btnPalavra3);
        btnPalavra4 = findViewById(R.id.btnPalavra4);
        btnPalavra5 = findViewById(R.id.btnPalavra5);

        btnDescricao1 = findViewById(R.id.btnDescricao1);
        btnDescricao2 = findViewById(R.id.btnDescricao2);
        btnDescricao3 = findViewById(R.id.btnDescricao3);
        btnDescricao4 = findViewById(R.id.btnDescricao4);
        btnDescricao5 = findViewById(R.id.btnDescricao5);

        this.inserirPalavras();
        this.inserirDescricoes();

        btnVerificar = findViewById(R.id.btnChecar);
        btnVerificar.setOnClickListener(btnVerificarOnClick);



    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_desafio1);

        final Button btn1 = findViewById(R.id.button);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btn1.setPressed(TRUE);
                id1 = btn1.getId();
            }
        });
    }*/


    }

    private void inserirPalavras() {
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
    }

}
