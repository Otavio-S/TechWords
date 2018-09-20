package com.example.otavio.bicjr.Dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CriaBanco extends SQLiteOpenHelper {
    private static String NOME_BANCO = "TechWords.db";
    private static final int VERSAO_BANCO = 1;

    private final String TABELA = "palavras";

    private int COLUNA_ID;
    private String COLUNA_PALAVRA = "palavra";
    private String COLUNA_DESCRICAO = "descricao";



    public String getCOLUNA_PALAVRA() {
        return COLUNA_PALAVRA;
    }

    public String getCOLUNA_DESCRICAO() {
        return COLUNA_DESCRICAO;
    }

    public int getCOLUNA_ID() {
        return COLUNA_ID;
    }

    public String getTABELA() {
        return TABELA;
    }

    public void setCOLUNA_PALAVRA(String PALAVRA) {
        this.COLUNA_PALAVRA = PALAVRA;
    }

    public void setCOLUNA_DESCRICAO(String DESCRICAO) {
        this.COLUNA_DESCRICAO = DESCRICAO;
    }

    public CriaBanco(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + TABELA + " (" +
                COLUNA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUNA_PALAVRA + " CHAR(35)," +
                COLUNA_DESCRICAO + " CHAR(250)" + " )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        onCreate(db);
    }

}