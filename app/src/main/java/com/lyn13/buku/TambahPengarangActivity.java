package com.lyn13.buku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.lyn13.buku.model.Buku;
import com.lyn13.buku.model.Pengarang;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class TambahPengarangActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_pengarang);
        Realm realm = Realm.getDefaultInstance();
        //penyimpanan data

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try{
                    Pengarang pengarang1 = realm.createObject(Pengarang.class, "1234");
                    pengarang1.setNama("Budi Handoko");
                    pengarang1.setAlamat("Medan");
                    finish();
                }catch(RealmPrimaryKeyConstraintException e) {
                    Log.d("TAG", "PrimaryKey Sudah Ada"+e.getMessage().toString());
                }
            }
        });
        realm.close();
    }
}