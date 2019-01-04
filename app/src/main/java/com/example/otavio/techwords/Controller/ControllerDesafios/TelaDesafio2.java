package com.example.otavio.techwords.Controller.ControllerDesafios;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.otavio.techwords.BancoSQLite.BancoPalavras;
import com.example.otavio.techwords.BancoSQLite.BancoStatus;
import com.example.otavio.techwords.Model.Palavra;
import com.example.otavio.techwords.Model.Status;
import com.example.otavio.techwords.R;

import java.util.List;

public class TelaDesafio2 extends AppCompatActivity {

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
        setContentView(R.layout.activity_tela_desafio2);

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
            System.out.printf("DESCRICAO %d - %s\n", a, palavras.get(a).getDescricao());
        }

        String descricao1 = palavras.get(0).getDescricao();
        palavra1 = palavras.get(0).getPalavra();
        String descricao2 = palavras.get(1).getDescricao();
        palavra2 = palavras.get(1).getPalavra();
        String descricao3 = palavras.get(2).getDescricao();
        palavra3 = palavras.get(2).getPalavra();
        String descricao4 = palavras.get(3).getDescricao();
        palavra4 = palavras.get(3).getPalavra();
        String descricao5 = palavras.get(4).getDescricao();
        palavra5 = palavras.get(4).getPalavra();

        bancoPalavras.close();

        TextView txtDescricao1 = findViewById(R.id.txtDescricao1);
        txtDescricao1.setText(descricao1);

        TextView txtDescricao2 = findViewById(R.id.txtDescricao2);
        txtDescricao2.setText(descricao2);

        TextView txtDescricao3 = findViewById(R.id.txtDescricao3);
        txtDescricao3.setText(descricao3);

        TextView txtDescricao4 = findViewById(R.id.txtDescricao4);
        txtDescricao4.setText(descricao4);

        TextView txtDescricao5 = findViewById(R.id.txtDescricao5);
        txtDescricao5.setText(descricao5);

        txtPalavra1 = findViewById(R.id.txtPalavra1);
        txtPalavra2 = findViewById(R.id.txtPalavra2);
        txtPalavra3 = findViewById(R.id.txtPalavra3);
        txtPalavra4 = findViewById(R.id.txtPalavra4);
        txtPalavra5 = findViewById(R.id.txtPalavra5);

        Button btnVerificar = findViewById(R.id.btnVerificar);
        btnVerificar.setOnClickListener(btnVerificarOnClickListener);
    }

}