package com.example.otavio.techwords;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.otavio.techwords.BancoSQLite.BancoDisciplinas;
import com.example.otavio.techwords.BancoSQLite.BancoPalavras;
import com.example.otavio.techwords.BancoSQLite.BancoStatus;
import com.example.otavio.techwords.Controller.ControllerInicial.TelaInstrucoes;
import com.example.otavio.techwords.Model.Disciplina;
import com.example.otavio.techwords.Model.Palavra;
import com.example.otavio.techwords.Model.Status;

public class TestCRUD extends AppCompatActivity {

    private BancoPalavras crud;
    private BancoDisciplinas banco;
    private BancoStatus bancoStatus;

    public static void start(Context context) {
        Intent intent = new Intent(context, TelaInstrucoes.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_instrucoes);

        crud = new BancoPalavras(this);
        banco = new BancoDisciplinas(this);
        bancoStatus = new BancoStatus(this);

        System.out.println("INSERINDO DISCIPLINAS");

        Disciplina disciplina = new Disciplina(1, "Informática Básica");

        System.out.println(banco.insereDado(disciplina));

        Disciplina disciplina2 = new Disciplina(2, "Web");

        System.out.println(banco.insereDado(disciplina2));

        Disciplina disciplina3 = new Disciplina(3, "Redes de Computadores");

        System.out.println(banco.insereDado(disciplina3));

        int a;
        System.out.printf("Percorrendo o ArrayList (usando o índice)\n");
        int x = crud.carregaDados().size();
        for (a = 0; a < x; a++) {
            System.out.printf("ID %d - %s\n", a, banco.carregaDados().get(a).getId());
            System.out.printf("Disciplina %d - %s\n", a, banco.carregaDados().get(a).getDisciplina());

        }

        Status status1 = new Status(1, 13, 1);
        Status status2 = new Status(2, 1, 2);
        Status status3 = new Status(3, 8, 3);

        System.out.println("INSERINDO STATUS");
        System.out.println(bancoStatus.insereDado(status1) + " 1");
        System.out.println(bancoStatus.insereDado(status2) + " 2");
        System.out.println(bancoStatus.insereDado(status3) + " 3");

        System.out.printf("Percorrendo o ArrayList (usando o índice)\n");
        int n2 = bancoStatus.carregaDados().size();
        for (int i2 = 0; i2 < n2; i2++) {
            System.out.printf("Posição %d - %s\n", i2, bancoStatus.carregaDados().get(i2).getId());
            System.out.printf("Status %d - %s\n", i2, bancoStatus.carregaDados().get(i2).getStatus());
            System.out.printf("Disciplina %d - %s\n", i2, bancoStatus.carregaDados().get(i2).getDisciplina());
        }

        Palavra palavra = new Palavra(1, "Word", "Word é uma", "sinonimo", "APalavra em ingles", "2");

        System.out.println(crud.insereDado(palavra));

        Palavra novaPalavra = new Palavra(2, "Test", "Teste", "sinonimo", "BFazer um teste", "2");

        System.out.println(crud.insereDado(novaPalavra));

        Palavra palavra3 = new Palavra(3, "Palavra3", "Word é uma", "sinonimo", "CPalavra em ingles", "2");

        System.out.println(crud.insereDado(palavra3));

        Palavra palavra4 = new Palavra(4, "Palavra4", "Word é uma", "sinonimo", "DPalavra em ingles", "2");

        System.out.println(crud.insereDado(palavra4));

        Palavra palavra5 = new Palavra(5, "Palavra5", "Word é uma", "sinonimo", "EPalavra em ingles", "2");

        System.out.println(crud.insereDado(palavra5));

        Palavra palavra6 = new Palavra(6, "Word6", "Word é uma", "sinonimo", "FPalavra em ingles", "2");

        System.out.println(crud.insereDado(palavra6));

        int i;
        System.out.printf("Percorrendo o ArrayList (usando o índice)\n");
        int n = crud.carregaDados().size();
        for (i = 0; i < n; i++) {
            System.out.printf("Posição %d - %s\n", i, crud.carregaDados().get(i).getId());
            System.out.printf("Palavra %d - %s\n", i, crud.carregaDados().get(i).getPalavra());
            System.out.printf("Tradução %d - %s\n", i, crud.carregaDados().get(i).getTraducao());
            System.out.printf("Sinônimo %d - %s\n", i, crud.carregaDados().get(i).getSinonimo());
            System.out.printf("Descrição %d - %s\n", i, crud.carregaDados().get(i).getDescricao());
            System.out.printf("Disciplina %d - %s\n", i, crud.carregaDados().get(i).getDisciplina());
        }

    }

}
