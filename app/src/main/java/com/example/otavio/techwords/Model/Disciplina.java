package com.example.otavio.techwords.Model;

public class Disciplina {

    private int id;
    private String disciplina;
    private int disciplinasConcluidas;

    public Disciplina() {
    }

    public Disciplina(int id, String disciplina) {
        this.id = id;
        this.disciplina = disciplina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public int getDisciplinasConcluidas() {
        return disciplinasConcluidas;
    }

    public void setDisciplinasConcluidas(int disciplinasConcluidas) {
        this.disciplinasConcluidas = disciplinasConcluidas;
    }
}
