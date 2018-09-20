package com.example.otavio.techwords.Controller.ControllerInicial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.otavio.techwords.BancoSQLite.BancoDisciplinas;
import com.example.otavio.techwords.Controller.ControllerDesafios.TelaPalavra;
import com.example.otavio.techwords.R;

public class TelaDisciplinas extends Activity {

    private ListView listview;
    private BancoDisciplinas banco;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_disciplinas);

        listview = findViewById(R.id.listVDisciplinas);

        banco = new BancoDisciplinas(this);
        int x = banco.carregaDados().size();

        String[] dados = new String[x];

        for (int a = 0; a < x; a++) {
            dados[a] = banco.carregaDados().get(a).getDisciplina();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getBaseContext(), android.R.layout.simple_list_item_1, dados);

        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) listview.getItemAtPosition(position);

                //Abrir tela com palavra
                Intent intent = new Intent(TelaDisciplinas.this, TelaPalavra.class);
                intent.putExtra("item",itemPosition);
                startActivity(intent);

                // Show Alert
                Toast.makeText(getApplicationContext(),
                        "Position :" + itemPosition + "  ListItem : " + itemValue, Toast.LENGTH_LONG)
                        .show();

            }
        });
    }

}