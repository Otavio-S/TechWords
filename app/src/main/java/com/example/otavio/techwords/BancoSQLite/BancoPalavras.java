package com.example.otavio.techwords.BancoSQLite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.otavio.techwords.Constant.CamposPalavra;
import com.example.otavio.techwords.Model.Palavra;

import java.util.ArrayList;
import java.util.List;

public class BancoPalavras extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "TechWordsPalavras.db";
    private static final int VERSAO_BANCO = 6;

    public BancoPalavras(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + CamposPalavra.NOME_TABELA + " (" +
                CamposPalavra.COLUNA_ID + " INTEGER," +
                CamposPalavra.COLUNA_PALAVRA + " TEXT," +
                CamposPalavra.COLUNA_TRADUCAO + " TEXT," +
                CamposPalavra.COLUNA_SINONIMO + " TEXT," +
                CamposPalavra.COLUNA_DESCRICAO + " TEXT," +
                CamposPalavra.COLUNA_DISCIPLINA + " TEXT" + " )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + CamposPalavra.NOME_TABELA);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public String insereDado(Palavra palavra) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues valores = new ContentValues();
        long resultado;

        int id = UltimoID();

        id = id + 1;

        valores.put(CamposPalavra.COLUNA_ID, id);

        valores.put(CamposPalavra.COLUNA_PALAVRA, palavra.getPalavra());
        valores.put(CamposPalavra.COLUNA_TRADUCAO, palavra.getTraducao());
        valores.put(CamposPalavra.COLUNA_SINONIMO, palavra.getSinonimo());
        valores.put(CamposPalavra.COLUNA_DESCRICAO, palavra.getDescricao());
        valores.put(CamposPalavra.COLUNA_DISCIPLINA, palavra.getDisciplina());

        resultado = db.insert(
                CamposPalavra.NOME_TABELA,
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
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT * FROM " + CamposPalavra.NOME_TABELA, null);

        if (cursor.moveToLast()) {
            Palavra palavra = new Palavra();
            palavra.setId(cursor.getInt(cursor.getColumnIndex(CamposPalavra.COLUNA_ID)));
            id = (palavra.getId());
        }

        return id;
    }

    public List<Palavra> carregaDados() {

        List<Palavra> palavras = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT * FROM " + CamposPalavra.NOME_TABELA, null);

        if (cursor.moveToFirst()) {
            do {
                Palavra palavra = new Palavra();
                palavra.setId(cursor.getInt(cursor.getColumnIndex(CamposPalavra.COLUNA_ID)));
                palavra.setPalavra(cursor.getString(cursor.getColumnIndex(CamposPalavra.COLUNA_PALAVRA)));
                palavra.setTraducao(cursor.getString(cursor.getColumnIndex(CamposPalavra.COLUNA_TRADUCAO)));
                palavra.setSinonimo(cursor.getString(cursor.getColumnIndex(CamposPalavra.COLUNA_SINONIMO)));
                palavra.setDescricao(cursor.getString(cursor.getColumnIndex(CamposPalavra.COLUNA_DESCRICAO)));
                palavra.setDisciplina(cursor.getString(cursor.getColumnIndex(CamposPalavra.COLUNA_DISCIPLINA)));
                palavras.add(palavra);
            } while (cursor.moveToNext());
        }

        return palavras;
    }

    public List<Palavra> carregaDadosPorID(int id) {

        List<Palavra> palavra = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT * FROM " + CamposPalavra.NOME_TABELA + " WHERE " + CamposPalavra.COLUNA_ID + " = " + String.valueOf(id), null);

        if (cursor.moveToFirst()) {
            Palavra word = new Palavra();
            word.setId(cursor.getInt(cursor.getColumnIndex(CamposPalavra.COLUNA_ID)));
            word.setPalavra(cursor.getString(cursor.getColumnIndex(CamposPalavra.COLUNA_PALAVRA)));
            word.setTraducao(cursor.getString(cursor.getColumnIndex(CamposPalavra.COLUNA_TRADUCAO)));
            word.setSinonimo(cursor.getString(cursor.getColumnIndex(CamposPalavra.COLUNA_SINONIMO)));
            word.setDescricao(cursor.getString(cursor.getColumnIndex(CamposPalavra.COLUNA_DESCRICAO)));
            word.setDisciplina(cursor.getString(cursor.getColumnIndex(CamposPalavra.COLUNA_DISCIPLINA)));
            palavra.add(word);

        }

        return palavra;
    }

    public List<Palavra> carregaDadosAleatorio(int id1, int id2) {

        List<Palavra> palavra = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + CamposPalavra.NOME_TABELA +
                " WHERE " + CamposPalavra.COLUNA_ID + " >= " + String.valueOf(id1) +
                " AND " + CamposPalavra.COLUNA_ID + " <= " + String.valueOf(id2) +
                " ORDER BY random()";

        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(query, null);


        if (cursor.moveToFirst()) {
            do {
                Palavra word = new Palavra();
                word.setId(cursor.getInt(cursor.getColumnIndex(CamposPalavra.COLUNA_ID)));
                word.setPalavra(cursor.getString(cursor.getColumnIndex(CamposPalavra.COLUNA_PALAVRA)));
                word.setTraducao(cursor.getString(cursor.getColumnIndex(CamposPalavra.COLUNA_TRADUCAO)));
                word.setSinonimo(cursor.getString(cursor.getColumnIndex(CamposPalavra.COLUNA_SINONIMO)));
                word.setDescricao(cursor.getString(cursor.getColumnIndex(CamposPalavra.COLUNA_DESCRICAO)));
                palavra.add(word);
            } while (cursor.moveToNext());
        }

        return palavra;
    }

    public int carregaIDPorPalavra(String palavra) {

        List<Palavra> id = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        String query = "SELECT * FROM " + CamposPalavra.NOME_TABELA + " WHERE " + CamposPalavra.COLUNA_PALAVRA + " LIKE '" + palavra + "'";

        @SuppressLint("Recycle") Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            Palavra word = new Palavra();
            word.setId(cursor.getInt(cursor.getColumnIndex(CamposPalavra.COLUNA_ID)));
            id.add(word);
        }

        return id.get(0).getId();
    }

    public int carregaIDPorSinonimo(String sinonimo) {

        List<Palavra> id = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT * FROM " + CamposPalavra.NOME_TABELA + " WHERE " + CamposPalavra.COLUNA_SINONIMO + " LIKE '" + sinonimo + "'", null);

        if (cursor.moveToFirst()) {
            Palavra word = new Palavra();
            word.setId(cursor.getInt(cursor.getColumnIndex(CamposPalavra.COLUNA_ID)));
            id.add(word);

        }

        return id.get(0).getId();
    }

    public int carregaIDPorTraducao(String traducao) {

        List<Palavra> id = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT * FROM " + CamposPalavra.NOME_TABELA + " WHERE " + CamposPalavra.COLUNA_TRADUCAO + " LIKE '" + traducao + "'", null);

        if (cursor.moveToFirst()) {
            Palavra word = new Palavra();
            word.setId(cursor.getInt(cursor.getColumnIndex(CamposPalavra.COLUNA_ID)));
            id.add(word);

        }

        return id.get(0).getId();
    }

    public String alteraRegistro(Palavra palavra) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(CamposPalavra.COLUNA_PALAVRA, palavra.getPalavra());
        valores.put(CamposPalavra.COLUNA_TRADUCAO, palavra.getTraducao());
        valores.put(CamposPalavra.COLUNA_SINONIMO, palavra.getSinonimo());
        valores.put(CamposPalavra.COLUNA_DESCRICAO, palavra.getDescricao());
        valores.put(CamposPalavra.COLUNA_DISCIPLINA, palavra.getDisciplina());

        String selecao = CamposPalavra.COLUNA_ID + " LIKE ?";
        String[] selecaoArgs = {String.valueOf(palavra.getId())};

        int count = db.update(
                CamposPalavra.NOME_TABELA,
                valores,
                selecao,
                selecaoArgs
        );

        if (count == -1)
            return "Erro ao atualizar registro";
        else {
            return "Registro atualizado com sucesso";
        }
    }

    public String deletaRegistro(int id) {
        SQLiteDatabase db = getReadableDatabase();

        String sql = CamposPalavra.COLUNA_ID + " LIKE ?";
        String[] selecaoArgs = {String.valueOf(id)};
        int count = db.delete(
                CamposPalavra.NOME_TABELA,
                sql,
                selecaoArgs);

        if (count == -1)
            return "Erro ao deletar registro";
        else {
            return "Registro deletado com sucesso";
        }

    }

}
