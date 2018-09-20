package com.example.otavio.bicjr.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Palavra {
    private int id;
    private String palavra;
    private String descricao;

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

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.palavra);
        dest.writeString(this.descricao);
    }

}
