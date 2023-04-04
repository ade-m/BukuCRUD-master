package com.lyn13.buku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.lyn13.buku.adapter.UserAdapter;
import com.lyn13.buku.model.Buku;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class CetakHapusActivity extends AppCompatActivity {
    ArrayList<Buku> arrayofuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cetak_hapus);
        refreshListview();

    }
    public void refreshListview(){

        Realm realm = Realm.getDefaultInstance();
        RealmResults<Buku> users = realm.where(Buku.class).findAll();

        arrayofuser = new ArrayList<Buku>();
        arrayofuser.addAll(realm.copyFromRealm(users));
        realm.close();

        UserAdapter userAdapter = new UserAdapter(this, arrayofuser);
        userAdapter.setmActivity(this);
        ListView listView = (ListView) findViewById(R.id.listViewBuku);
        listView.setAdapter(userAdapter);
    }
}