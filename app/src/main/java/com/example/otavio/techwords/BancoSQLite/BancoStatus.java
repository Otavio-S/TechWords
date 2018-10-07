package com.example.otavio.techwords.BancoSQLite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.otavio.techwords.Constant.CamposStatus;
import com.example.otavio.techwords.Model.Status;

import java.util.ArrayList;
import java.util.List;

public class BancoStatus extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "TechWordsStatus.db";
    private static final int VERSAO_BANCO = 1;

    public BancoStatus(Context context) {
        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE " + CamposStatus.NOME_TABELA + " (" +
                CamposStatus.COLUNA_ID + " TEXT," +
                CamposStatus.COLUNA_STATUS + " TEXT," +
                CamposStatus.COLUNA_DISCIPLINA + " TEXT" + " )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + CamposStatus.NOME_TABELA);
        onCreate(db);
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public String insereDado(Status status) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues valores = new ContentValues();
        long resultado;

        valores.put(CamposStatus.COLUNA_ID, status.getId());
        valores.put(CamposStatus.COLUNA_STATUS, status.getStatus());
        valores.put(CamposStatus.COLUNA_DISCIPLINA, status.getDisciplina());

        resultado = db.insert(
                CamposStatus.NOME_TABELA,
                null,
                valores);

        if (resultado == -1)
            return "Erro ao inserir registro";
        else {
            return "Registro Inserido com sucesso";
        }
    }

    public List<Status> carregaDados() {

        List<Status> statuses = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        @SuppressLint("Recycle") Cursor cursor = db.rawQuery("SELECT * FROM " + CamposStatus.NOME_TABELA, null);

        if (cursor.moveToFirst()) {
            do {
                Status status = new Status();
                status.setId(cursor.getInt(cursor.getColumnIndex(CamposStatus.COLUNA_ID)));
                status.setStatus(cursor.getInt(cursor.getColumnIndex(CamposStatus.COLUNA_STATUS)));
                status.setDisciplina(cursor.getColumnIndex(CamposStatus.COLUNA_DISCIPLINA));
                statuses.add(status);
            } while (cursor.moveToNext());
        }

        return statuses;
    }

    public Status carregaStatus(String dis) {

        Status status = new Status();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + CamposStatus.NOME_TABELA + " WHERE " + CamposStatus.COLUNA_DISCIPLINA + " = " + dis, null);

        if (cursor.moveToFirst()) {
            Status stat = new Status();
            stat.setId(cursor.getInt(cursor.getColumnIndex(CamposStatus.COLUNA_ID)));
            stat.setStatus(cursor.getInt(cursor.getColumnIndex(CamposStatus.COLUNA_STATUS)));
            stat.setDisciplina(cursor.getInt(cursor.getColumnIndex(CamposStatus.COLUNA_DISCIPLINA)));
            status = stat;
        }

        cursor.close();

        return status;
    }

    public String alteraRegistro(Status status) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(CamposStatus.COLUNA_STATUS, status.getStatus());

        String selecao = CamposStatus.COLUNA_ID + " LIKE ?";
        String[] selecaoArgs = {String.valueOf(status.getDisciplina())};

        int count = db.update(
                CamposStatus.NOME_TABELA,
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

    public String aumentaStatus(Status status) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(CamposStatus.COLUNA_STATUS, status.getStatus());

        String selecao = CamposStatus.COLUNA_DISCIPLINA + " = ?";
        String[] selecaoArgs = {String.valueOf(status.getDisciplina())};

        int count = db.update(
                CamposStatus.NOME_TABELA,
                valores,
                selecao,
                selecaoArgs
        );

        if (count == -1)
            return "Erro ao aumentado registro";
        else {
            return "Registro aumentado com sucesso";
        }
    }

    public String diminuiStatus(Status status) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(CamposStatus.COLUNA_STATUS, status.getStatus());

        String selecao = CamposStatus.COLUNA_DISCIPLINA + " = ?";
        String[] selecaoArgs = {String.valueOf(status.getDisciplina())};

        int count = db.update(
                CamposStatus.NOME_TABELA,
                valores,
                selecao,
                selecaoArgs
        );

        if (count == -1)
            return "Erro ao diminuir registro";
        else {
            return "Registro diminuido com sucesso";
        }
    }

    public String deletaRegistro(int id) {
        SQLiteDatabase db = getReadableDatabase();

        String sql = CamposStatus.COLUNA_ID + " LIKE ?";
        String[] selecaoArgs = {String.valueOf(id)};
        int count = db.delete(
                CamposStatus.NOME_TABELA,
                sql,
                selecaoArgs);

        if (count == -1)
            return "Erro ao deletar registro";
        else {
            return "Registro deletado com sucesso";
        }

    }

}