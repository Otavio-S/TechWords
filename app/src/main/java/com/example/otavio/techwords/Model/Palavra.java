package com.example.otavio.techwords.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Palavra implements Parcelable {
    private int id;
    private String palavra;
    private String traducao;
    private String sinonimo;
    private String descricao;
    private String disciplina;

    public Palavra(int id, String palavra, String traducao, String sinonimo, String descricao, String disciplina) {
        this.id = id;
        this.palavra = palavra;
        this.traducao = traducao;
        this.sinonimo = sinonimo;
        this.descricao = descricao;
        this.disciplina = disciplina;
    }

    public Palavra() {
    }

    protected Palavra(Parcel in) {
        this.id = in.readInt();
        this.palavra = in.readString();
        this.descricao = in.readString();
    }

    public static final Parcelable.Creator<Palavra> CREATOR = new Parcelable.Creator<Palavra>() {
        @Override
        public Palavra createFromParcel(Parcel source) {
            return new Palavra(source);
        }

        @Override
        public Palavra[] newArray(int size) {
            return new Palavra[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTraducao() { return traducao; }

    public void setTraducao(String traducao) { this.traducao = traducao; }

    public String getSinonimo() { return sinonimo; }

    public void setSinonimo(String sinonimo) { this.sinonimo = sinonimo; }

    public String getDisciplina() { return disciplina; }

    public void setDisciplina(String disciplina) { this.disciplina = disciplina; }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.id);
        parcel.writeString(this.palavra);
        parcel.writeString(this.sinonimo);
        parcel.writeString(this.traducao);
        parcel.writeString(this.descricao);
        parcel.writeString(this.disciplina);
    }
}
