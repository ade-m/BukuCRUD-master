package com.lyn13.buku.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;
import io.realm.annotations.Required;

@RealmClass
public class Pengarang extends RealmObject {
    @PrimaryKey
    String idPengarang;

    @Required
    String nama;

    @Required
    String alamat;

    public Pengarang() {
    }

    public Pengarang(String idPengarang, String nama, String alamat) {
        this.idPengarang = idPengarang;
        this.nama = nama;
        this.alamat = alamat;
    }

    public String getIdPengarang() {
        return idPengarang;
    }

    public void setIdPengarang(String idPengarang) {
        this.idPengarang = idPengarang;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
