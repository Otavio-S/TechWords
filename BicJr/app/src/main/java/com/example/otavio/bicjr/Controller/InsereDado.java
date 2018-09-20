package com.example.otavio.bicjr.Controller;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.otavio.bicjr.Dao.BancoController;
import com.example.otavio.bicjr.Model.Palavra;
import com.example.otavio.bicjr.R;

public class InsereDado extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.testebanco);


        Button btnSalvar = (Button) findViewById(R.id.btnSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BancoController crud = new BancoController(getBaseContext());
                EditText edtID = (EditText) findViewById(R.id.edtID);
                EditText edtPalavra = (EditText) findViewById(R.id.edtPalavra);
                EditText edtDescricao = (EditText) findViewById(R.id.edtDescricao);

                Palavra palavra = new Palavra();
                palavra.setPalavra(edtPalavra.getText().toString());
                palavra.setDescricao(edtDescricao.getText().toString());

                String resultado;

                resultado = crud.insereDado(palavra);

                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
            }
        });

    }

}
