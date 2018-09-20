package com.example.otavio.bicjr.Controller;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ListView;

import com.example.otavio.bicjr.Dao.BancoController;
import com.example.otavio.bicjr.R;

public class Consulta extends Activity {

    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testebanco);

        BancoController crud = new BancoController(getBaseContext());
        Cursor cursor = crud.carregaDados();

        String[] nomeCampos = new String[]{};
        int[] idViews = new int[] {R.id.edtPalavra, R.id.edtDescricao};

    }
}
