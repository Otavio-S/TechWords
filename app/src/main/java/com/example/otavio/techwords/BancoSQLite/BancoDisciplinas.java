package com.example.otavio.techwords.BancoSQLite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.otavio.techwords.Constant.CamposDisciplina;
import com.example.otavio.techwords.Model.Disciplina;

import java.util.ArrayList;
import java.util.List;

public class BancoDisciplinas extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "TechWordsDisciplinas.db";
    private static final int VERSAO_BANCO = 3;

    public BancoDisciplinas(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + CamposDisciplina.NOME_TABELA + " (" +
                CamposDisciplina.COLUNA_ID + " TEXT," +
                CamposDisciplina.COLUNA_DISCIPLINA + " TEXT," +
                CamposDisciplina.COLUNA_DISCIPLINAS_CONCLUIDAS + " TEXT" + " )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + CamposDisciplina.NOME_TABELA);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public String insereDado(Disciplina disciplina) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues valores = new ContentValues();
        long resultado;

        int id = UltimoID();

        id = id + 1;

        valores.put(CamposDisciplina.COLUNA_ID, id);
        valores.put(CamposDisciplina.COLUNA_DISCIPLINA, disciplina.getDisciplina());
        valores.put(CamposDisciplina.COLUNA_DISCIPLINAS_CONCLUIDAS, disciplina.getDisciplinasConcluidas());

        resultado = db.insert(
                CamposDisciplina.NOME_TABELA,
                null,
                valores);

        if (resultado == -1)
            return "Erro ao inserir registro";
        else {
            return "Registro Inserido com sucesso";
        }
    }

    private int UltimoID() {
        int id = 0;
        SQLiteDatabase db = getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT * FROM " + CamposDisciplina.NOME_TABELA, null);

        if (cursor.moveToLast()) {
            Disciplina disciplina = new Disciplina();
            disciplina.setId(cursor.getInt(cursor.getColumnIndex(CamposDisciplina.COLUNA_ID)));
            id = (disciplina.getId());
        }

        return id;
    }

    public List<Disciplina> carregaDados() {

        List<Disciplina> disciplinas = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT * FROM " + CamposDisciplina.NOME_TABELA, null);

        if (cursor.moveToFirst()) {
            do {
                Disciplina disciplina = new Disciplina();
                disciplina.setId(cursor.getInt(cursor.getColumnIndex(CamposDisciplina.COLUNA_ID)));
                disciplina.setDisciplina(cursor.getString(cursor.getColumnIndex(CamposDisciplina.COLUNA_DISCIPLINA)));
                disciplina.setDisciplinasConcluidas(cursor.getInt(cursor.getColumnIndex(CamposDisciplina.COLUNA_DISCIPLINAS_CONCLUIDAS)));
                disciplinas.add(disciplina);
            } while (cursor.moveToNext());
        }

        return disciplinas;
    }

    public void alteraRegistro(int id) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(CamposDisciplina.COLUNA_DISCIPLINAS_CONCLUIDAS, 1);

        String selecao = CamposDisciplina.COLUNA_ID + " LIKE ?";
        String[] selecaoArgs = {String.valueOf(id)};

        int count = db.update(
                CamposDisciplina.NOME_TABELA,
                valores,
                selecao,
                selecaoArgs
        );
    }

    public String deletaRegistro(int id) {
        SQLiteDatabase db = getReadableDatabase();

        String sql = CamposDisciplina.COLUNA_ID + " LIKE ?";
        String[] selecaoArgs = {String.valueOf(id)};
        int count = db.delete(
                CamposDisciplina.NOME_TABELA,
                sql,
                selecaoArgs);

        if (count == -1)
            return "Erro ao deletar registro";
        else {
            return "Registro deletado com sucesso";
        }

    }

}
