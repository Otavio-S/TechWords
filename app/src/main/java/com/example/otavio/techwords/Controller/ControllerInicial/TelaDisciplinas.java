package com.example.otavio.techwords.Controller.ControllerInicial;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.otavio.techwords.Adapter.DisciplinasAdapter;
import com.example.otavio.techwords.BancoSQLite.BancoDisciplinas;
import com.example.otavio.techwords.Model.Disciplina;
import com.example.otavio.techwords.R;

import java.util.ArrayList;
import java.util.List;

public class TelaDisciplinas extends Activity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_disciplinas);

        List<Disciplina> disciplinaList = new ArrayList<>();
        BancoDisciplinas disciplinas = new BancoDisciplinas(getApplicationContext());
        int i;
        int quant = disciplinas.carregaDados().size();

        for (i = 0; i < quant; i++) {
            disciplinaList.add(disciplinas.carregaDados().get(i));
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        DisciplinasAdapter viewAdapter = new DisciplinasAdapter(getApplicationContext(), disciplinaList);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(viewAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());

        recyclerView.addItemDecoration(dividerItemDecoration);

    }

}