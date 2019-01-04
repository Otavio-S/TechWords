package com.example.otavio.techwords.Controller.ControllerDesafios;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.otavio.techwords.BancoSQLite.BancoPalavras;
import com.example.otavio.techwords.BancoSQLite.BancoStatus;
import com.example.otavio.techwords.Model.Palavra;
import com.example.otavio.techwords.Model.Status;
import com.example.otavio.techwords.R;

import java.util.List;
import java.util.Locale;

public class TelaDesafio1 extends AppCompatActivity {

    private TextToSpeech toSpeech;

    private String palavra1;
    private String palavra2;
    private String palavra3;
    private String palavra4;
    private String palavra5;

    private TextView txtPalavra1;
    private TextView txtPalavra2;
    private TextView txtPalavra3;
    private TextView txtPalavra4;
    private TextView txtPalavra5;

    private View.OnClickListener btnVerificarOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String word1 = String.valueOf(txtPalavra1.getText());
            String word2 = String.valueOf(txtPalavra2.getText());
            String word3 = String.valueOf(txtPalavra3.getText());
            String word4 = String.valueOf(txtPalavra4.getText());
            String word5 = String.valueOf(txtPalavra5.getText());

            int resultado = 0;

            if (word1.equalsIgnoreCase(palavra1)) {
                resultado += 1;
            }
            if (word2.equalsIgnoreCase(palavra2)) {
                resultado += 1;
            }
            if (word3.equalsIgnoreCase(palavra3)) {
                resultado += 1;
            }
            if (word4.equalsIgnoreCase(palavra4)) {
                resultado += 1;
            }
            if (word5.equalsIgnoreCase(palavra5)) {
                resultado += 1;
            }

            if (resultado >= 3) {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Você acertou: " + resultado + " palavras.",
                        Toast.LENGTH_LONG);
                toast.show();

                Intent intent = getIntent();
                int disciplina = intent.getIntExtra("disciplina", 0);
                int i = intent.getIntExtra("id", 0);
                i = i + 1;

                BancoStatus bancoStatus = new BancoStatus(getApplicationContext());

                Status s = new Status();
                s.setStatus(i);
                s.setDisciplina(disciplina);

                bancoStatus.aumentaStatus(s);

                finish();
            } else {
                Toast toast = Toast.makeText(getApplicationContext(),
                        "Você acertou: " + resultado + " palavras. \n Tente novamente!",
                        Toast.LENGTH_LONG);
                toast.show();

                Intent intent = getIntent();
                int disciplina = intent.getIntExtra("disciplina", 0);
                int i = intent.getIntExtra("id", 0);
                i = i - 4;

                BancoStatus bancoStatus = new BancoStatus(getApplicationContext());

                Status s = new Status();
                s.setStatus(i);
                s.setDisciplina(disciplina);

                bancoStatus.aumentaStatus(s);

                finish();
            }
        }
    };

    private View.OnClickListener audio1OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            toSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {
                    if (i == TextToSpeech.SUCCESS) {
                        toSpeech.setLanguage(Locale.US);
                        toSpeech.setPitch((float) 0.7);
                        toSpeech.speak(palavra1, TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                }
            });
        }
    };

    private View.OnClickListener audio2OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            toSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {
                    if (i == TextToSpeech.SUCCESS) {
                        toSpeech.setLanguage(Locale.US);
                        toSpeech.setPitch((float) 0.7);
                        toSpeech.speak(palavra2, TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                }
            });
        }
    };

    private View.OnClickListener audio3OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            toSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {
                    if (i == TextToSpeech.SUCCESS) {
                        toSpeech.setLanguage(Locale.US);
                        toSpeech.setPitch((float) 0.7);
                        toSpeech.speak(palavra3, TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                }
            });
        }
    };

    private View.OnClickListener audio4OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            toSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {
                    if (i == TextToSpeech.SUCCESS) {
                        toSpeech.setLanguage(Locale.US);
                        toSpeech.setPitch((float) 0.7);
                        toSpeech.speak(palavra4, TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                }
            });
        }
    };

    private View.OnClickListener audio5OnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            toSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
                @Override
                public void onInit(int i) {
                    if (i == TextToSpeech.SUCCESS) {
                        toSpeech.setLanguage(Locale.US);
                        toSpeech.setPitch((float) 0.7);
                        toSpeech.speak(palavra5, TextToSpeech.QUEUE_FLUSH, null, null);
                    }
                }
            });
        }
    };

    @Override
    public void onBackPressed() {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Termine o teste primeiro.",
                Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_desafio1);

        Intent intent = getIntent();
        int i = intent.getIntExtra("id", 0);

        int word1 = i - 4;
        int word5 = i;

        BancoPalavras bancoPalavras = new BancoPalavras(getApplicationContext());

        List<Palavra> palavras = bancoPalavras.carregaDadosAleatorio(word1, word5);

        int a;
        System.out.printf("Percorrendo o ArrayList (usando o índice)\n");
        int x = palavras.size();
        for (a = 0; a < x; a++) {
            System.out.printf("PALAVRA %d - %s\n", a, palavras.get(a).getPalavra());
        }

        palavra1 = palavras.get(0).getPalavra();
        palavra2 = palavras.get(1).getPalavra();
        palavra3 = palavras.get(2).getPalavra();
        palavra4 = palavras.get(3).getPalavra();
        palavra5 = palavras.get(4).getPalavra();

        bancoPalavras.close();

        ImageView audio1 = findViewById(R.id.audio1);
        audio1.setOnClickListener(audio1OnClickListener);

        ImageView audio2 = findViewById(R.id.audio2);
        audio2.setOnClickListener(audio2OnClickListener);

        ImageView audio3 = findViewById(R.id.audio3);
        audio3.setOnClickListener(audio3OnClickListener);

        ImageView audio4 = findViewById(R.id.audio4);
        audio4.setOnClickListener(audio4OnClickListener);

        ImageView audio5 = findViewById(R.id.audio5);
        audio5.setOnClickListener(audio5OnClickListener);

        txtPalavra1 = findViewById(R.id.txtPalavra1);
        txtPalavra2 = findViewById(R.id.txtPalavra2);
        txtPalavra3 = findViewById(R.id.txtPalavra3);
        txtPalavra4 = findViewById(R.id.txtPalavra4);
        txtPalavra5 = findViewById(R.id.txtPalavra5);

        Button btnVerificar = findViewById(R.id.btnChecar4);
        btnVerificar.setOnClickListener(btnVerificarOnClickListener);
    }

}
