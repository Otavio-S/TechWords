package com.example.otavio.techwords.Controller.ControllerDesafios;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.otavio.techwords.BancoSQLite.BancoPalavras;
import com.example.otavio.techwords.BancoSQLite.BancoStatus;
import com.example.otavio.techwords.Model.Status;
import com.example.otavio.techwords.R;

import java.util.Locale;

public class TelaPalavra extends Activity {

    private String palavra;
    private String descricao;
    private String sinonimo;
    private TextToSpeech toSpeech;
    private ImageView imgView;
    private TextView txtPalavra;
    private TextView txtDescricao;
    private TextView txtSinonimo;
    private TextView txtTraducao;
    private BancoPalavras bancoPalavras;
    private BancoStatus bancoStatus;
    private int status;
    private int disciplina;
    private int count = 0;

    private View.OnClickListener btnVoltarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            finish();
        }
    };

    private View.OnClickListener btnTraduzirOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String traducao = bancoPalavras.carregaDadosPorID(status).get(0).getTraducao();
            txtTraducao.setVisibility(View.VISIBLE);
            txtTraducao.setText(traducao);
        }
    };

    private View.OnClickListener btnFalarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            toSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {
                    if (i == TextToSpeech.SUCCESS) {
                        toSpeech.setLanguage(Locale.US);
                        toSpeech.setPitch((float) 0.7);
                        toSpeech.speak(palavra, TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                }
            });
        }
    };

    private View.OnClickListener btnAnteriorOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            txtTraducao.setVisibility(View.INVISIBLE);

            //CARREGA PALAVRA ANTERIOR
            status = status - 1;
            if (count > 0) {
                count -= 1;
                palavra = bancoPalavras.carregaDadosPorID(status).get(0).getPalavra();
                descricao = bancoPalavras.carregaDadosPorID(status).get(0).getDescricao();
                sinonimo = bancoPalavras.carregaDadosPorID(status).get(0).getSinonimo();
                txtPalavra.setText(palavra);
                txtDescricao.setText(descricao);
                txtSinonimo.setText(sinonimo);

                try {
                    String imagem = "@drawable/i" + status;
                    int imageResource = getResources().getIdentifier(imagem, null, getPackageName());
                    Drawable res = ContextCompat.getDrawable(getApplicationContext(), imageResource);
                    imgView.setVisibility(View.VISIBLE);
                    imgView.setImageDrawable(res);
                } catch (Exception e) {
                    imgView.setVisibility(View.INVISIBLE);
                }

                //ATUALIZA O STATUS DA DISCIPLINA
                Status s = new Status();
                s.setStatus(status);
                s.setDisciplina(disciplina);
                bancoStatus.diminuiStatus(s);
            } else {
                finish();
            }
        }
    };

    private View.OnClickListener btnProximoOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            txtTraducao.setVisibility(View.INVISIBLE);

            //CARREGA PRÒXIMA PALAVRA
            if (count != 4) {
                count += 1;
                status = status + 1;
                palavra = bancoPalavras.carregaDadosPorID(status).get(0).getPalavra();
                descricao = bancoPalavras.carregaDadosPorID(status).get(0).getDescricao();
                sinonimo = bancoPalavras.carregaDadosPorID(status).get(0).getSinonimo();
                txtPalavra.setText(palavra);
                txtDescricao.setText(descricao);
                txtSinonimo.setText(sinonimo);

                try {
                    String imagem = "@drawable/i" + status;
                    int imageResource = getResources().getIdentifier(imagem, null, getPackageName());
                    Drawable res = ContextCompat.getDrawable(getApplicationContext(), imageResource);
                    imgView.setVisibility(View.VISIBLE);
                    imgView.setImageDrawable(res);
                } catch (Exception e) {
                    imgView.setVisibility(View.INVISIBLE);
                }

                //ATUALIZA O STATUS DA DISCIPLINA
                Status s = new Status();
                s.setStatus(status);
                s.setDisciplina(disciplina);
                bancoStatus.aumentaStatus(s);
            } else {
                //CHAMA A TELA DESAFIO
                Intent intent = new Intent(TelaPalavra.this, TelaDesafio2.class);
                intent.putExtra("id", status);
                startActivity(intent);
            }
        }
    };

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_palavra);

        bancoStatus = new BancoStatus(this);
        bancoPalavras = new BancoPalavras(this);
        Intent intent = getIntent();
        this.disciplina = intent.getIntExtra("item", 0);
        this.disciplina += 1;

        txtPalavra = findViewById(R.id.txtPalavra);
        txtDescricao = findViewById(R.id.txtDescricao);
        txtSinonimo = findViewById(R.id.txtSinonimo);
        txtTraducao = findViewById(R.id.txtTraducao);

        Status stats = bancoStatus.carregaStatus(String.valueOf(this.disciplina));
        this.status = stats.getStatus();

        palavra = bancoPalavras.carregaDadosPorID(status).get(0).getPalavra();
        descricao = bancoPalavras.carregaDadosPorID(status).get(0).getDescricao();
        sinonimo = bancoPalavras.carregaDadosPorID(status).get(0).getSinonimo();
        txtPalavra.setText(palavra);
        txtPalavra.setTextSize(50);
        txtDescricao.setText(descricao);
        txtSinonimo.setText(sinonimo);
        txtTraducao.setVisibility(View.INVISIBLE);

        ImageButton btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(btnVoltarOnClickListener);

        ImageButton btnTraduzir = findViewById(R.id.btnTraduzir);
        btnTraduzir.setOnClickListener(btnTraduzirOnClickListener);

        ImageButton btnFalar = findViewById(R.id.btnFalar);
        btnFalar.setOnClickListener(btnFalarOnClickListener);

        Button btnAnterior = findViewById(R.id.btnAnterior);
        btnAnterior.setOnClickListener(btnAnteriorOnClickListener);

        Button btnProximo = findViewById(R.id.btnProximo);
        btnProximo.setOnClickListener(btnProximoOnClickListener);

        imgView = findViewById(R.id.imageView);

        try {
            String imagem = "@drawable/i" + this.status;
            int imageResource = getResources().getIdentifier(imagem, null, getPackageName());
            Drawable res = ContextCompat.getDrawable(getApplicationContext(), imageResource);
            imgView.setVisibility(View.VISIBLE);
            imgView.setImageDrawable(res);
        } catch (Exception e) {
            imgView.setVisibility(View.INVISIBLE);
        }

    }

}