package com.example.otavio.techwords.Model;

public class Status {

    private int id;
    private int status;
    private int disciplina;

    public Status() {
    }

    public Status(int id, int status, int idDisciplina) {
        this.id = id;
        this.status = status;
        this.disciplina = idDisciplina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Integer disciplina) {
        this.disciplina = disciplina;
    }
}
