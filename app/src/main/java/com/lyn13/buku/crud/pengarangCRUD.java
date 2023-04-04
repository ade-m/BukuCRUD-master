package com.lyn13.buku.crud;

import android.util.Log;

import com.lyn13.buku.model.Buku;
import com.lyn13.buku.model.Pengarang;

import io.realm.Realm;
import io.realm.exceptions.RealmPrimaryKeyConstraintException;

public class pengarangCRUD {

    public void updateDataPengarang(Integer idpengarang, String namapemngarang, String alamat) {
        Realm realm = Realm.getDefaultInstance();
        //Update data

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try{
                    Pengarang pengarang1 = realm.where(Pengarang.class).equalTo("idpengarang", idpengarang).findFirst();
                    pengarang1.setNama(namapemngarang);
                    pengarang1.setAlamat(alamat);
                }catch(RealmPrimaryKeyConstraintException e) {
                    Log.d("TAG", "PrimaryKey Sudah Ada"+e.getMessage().toString());
                }
            }
        });
        realm.close();
    }
    public void deleteDataPengarang(String idpengarang) {
        Realm realm = Realm.getDefaultInstance();
        //Update data

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                try{
                    Pengarang pengarang1 = realm.where(Pengarang.class).equalTo("idPengarang", idpengarang).findFirst();
                    pengarang1.deleteFromRealm();
                }catch(RealmPrimaryKeyConstraintException e) {
                    Log.d("TAG", "PrimaryKey Sudah Ada"+e.getMessage().toString());
                }
            }
        });
        realm.close();
    }
}
