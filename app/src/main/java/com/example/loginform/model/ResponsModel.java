package com.example.loginform.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponsModel {

    @SerializedName("kode")
    @Expose
    public int kode;
    @SerializedName("pesan")
    @Expose
    public String pesan;


    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public String getPesan() {
        return pesan;
    }

    public void setPesan(String pesan) {
        this.pesan = pesan;
    }
}
