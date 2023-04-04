package com.lyn13.buku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.lyn13.buku.adapter.PengarangAdapter;
import com.lyn13.buku.adapter.UserAdapter;
import com.lyn13.buku.model.Buku;
import com.lyn13.buku.model.Pengarang;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

public class CetakPengarangActivity extends AppCompatActivity {
    ArrayList<Pengarang> arrayofuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cetak_pengarang);
        refreshListView();
    }
    public void refreshListView(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Pengarang> users = realm.where(Pengarang.class).findAll();

        arrayofuser = new ArrayList<Pengarang>();
        arrayofuser.addAll(realm.copyFromRealm(users));
        realm.close();

        PengarangAdapter userAdapter = new PengarangAdapter(this, arrayofuser);
        userAdapter.setmActivity(this);
        ListView listView = (ListView) findViewById(R.id.listViewPengarang);
        listView.setAdapter(userAdapter);
    }
}