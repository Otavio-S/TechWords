package com.example.otavio.techwords.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.otavio.techwords.BancoSQLite.BancoDisciplinas;
import com.example.otavio.techwords.Controller.ControllerDesafios.TelaPalavra;
import com.example.otavio.techwords.Model.Disciplina;
import com.example.otavio.techwords.R;

import java.util.List;

public class DisciplinasAdapter extends RecyclerView.Adapter<DisciplinasAdapter.MyViewHolder> {

    private Context context;
    private List<Disciplina> disciplinaList;
    private BancoDisciplinas bancoDisciplinas;
    private int id;

    public DisciplinasAdapter(Context context, List<Disciplina> disciplinaList) {
        this.context = context;
        this.disciplinaList = disciplinaList;
    }

    @NonNull
    @Override
    public DisciplinasAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(context).inflate(R.layout.activity_tela_disciplinas_adapter, parent, false);
        bancoDisciplinas = new BancoDisciplinas(context);

        return new DisciplinasAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull DisciplinasAdapter.MyViewHolder holder, final int position) {

        holder.btnDisciplina.setText(disciplinaList.get(position).getDisciplina());
        id = disciplinaList.get(position).getId();

        holder.btnDisciplina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TelaPalavra.class);
                intent.putExtra("item", position);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return disciplinaList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        Button btnDisciplina;

        public MyViewHolder(View itemView) {
            super(itemView);

            btnDisciplina = itemView.findViewById(R.id.btnDisciplina);

        }
    }
}

