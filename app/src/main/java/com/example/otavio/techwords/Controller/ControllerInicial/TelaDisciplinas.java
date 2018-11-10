package com.example.otavio.techwords.Controller.ControllerInicial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.otavio.techwords.BancoSQLite.BancoDisciplinas;
import com.example.otavio.techwords.Controller.ControllerDesafios.TelaPalavra;
import com.example.otavio.techwords.R;

public class TelaDisciplinas extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_disciplinas);

        ListView listview = findViewById(R.id.listVDisciplinas);

        BancoDisciplinas banco = new BancoDisciplinas(this);
        int x = banco.carregaDados().size();

        String[] dados = new String[x];

        for (int a = 0; a < x; a++) {
            dados[a] = banco.carregaDados().get(a).getDisciplina();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getBaseContext(), android.R.layout.simple_list_item_1, dados);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(TelaDisciplinas.this, TelaPalavra.class);
                intent.putExtra("item", position);
                startActivity(intent);
            }
        });

        banco.close();
    }

}