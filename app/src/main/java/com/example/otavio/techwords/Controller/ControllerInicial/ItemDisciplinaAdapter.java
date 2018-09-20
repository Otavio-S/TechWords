package com.example.otavio.techwords.Controller.ControllerInicial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.example.otavio.techwords.Model.Disciplina;
import com.example.otavio.techwords.R;

import java.util.ArrayList;

public class ItemDisciplinaAdapter extends ArrayAdapter<Disciplina> {

    public ItemDisciplinaAdapter(Context context, ArrayList<Disciplina> users) {
        super(context, 0, users);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Disciplina disciplina = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_tela_disciplinas_adapter, parent, false);
        }

        Button btnDisciplina = (Button) convertView.findViewById(R.id.btnDisciplina);
        btnDisciplina.setText(disciplina.getDisciplina());

        return convertView;
    }

}
