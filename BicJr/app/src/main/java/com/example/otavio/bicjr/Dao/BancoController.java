package com.example.otavio.bicjr.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.content.SearchRecentSuggestionsProvider;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;

import com.example.otavio.bicjr.Model.Palavra;

public class BancoController extends CriaBanco {

    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context) {
        super(context);
    }

    public void create(Palavra palavra) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(super.getCOLUNA_PALAVRA(), palavra.getPalavra());
        values.put(super.getCOLUNA_DESCRICAO(), palavra.getDescricao());

        long newRowId;
        newRowId = db.insert(
                super.getTABELA(),
                null,
                values);
    }

    public String insereDado(Palavra palavra) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues valores = new ContentValues();
        long resultado;

        valores.put(super.getCOLUNA_PALAVRA(), palavra.getPalavra());
        valores.put(super.getCOLUNA_DESCRICAO(), palavra.getDescricao());

        resultado = db.insert(super.getTABELA(), null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }

    public Cursor carregaDados() {
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor;
        String[] campos = {
                String.valueOf(super.getCOLUNA_ID()),
                super.getCOLUNA_PALAVRA(),
                super.getCOLUNA_DESCRICAO()};

        String ordem = super.getCOLUNA_PALAVRA() + " ASC";

        cursor = db.query(super.getTABELA(), campos, null, null, null, null, ordem, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public Cursor carregaDadoById(int id) {
        Cursor cursor;
        String[] campos = {String.valueOf(super.getCOLUNA_ID()), super.getCOLUNA_PALAVRA(), super.getCOLUNA_DESCRICAO()};
        String where = super.getCOLUNA_ID() + "=" + id;
        db = banco.getReadableDatabase();
        cursor = db.query(super.getTABELA(), campos, where, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    public void alteraRegistro(Palavra palavra) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(super.getCOLUNA_PALAVRA(), palavra.getPalavra());
        valores.put(super.getCOLUNA_DESCRICAO(), palavra.getDescricao());

        String selecao = super.getCOLUNA_ID() + " LIKE ?";
        String[] selecaoArgs = {String.valueOf(super.getCOLUNA_ID())};

        int count = db.update(
                super.getTABELA(),
                valores,
                selecao,
                selecaoArgs);
    }

    public void deletaRegistro(int id) {
        SQLiteDatabase db = getReadableDatabase();

        String selecao = super.getCOLUNA_ID() + " LIKE ?";
        String[] selecaoArgs = { String.valueOf(id) };
        db.delete(super.getTABELA(), selecao, selecaoArgs);
    }

}
