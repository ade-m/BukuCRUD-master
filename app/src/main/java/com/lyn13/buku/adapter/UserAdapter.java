package com.lyn13.buku.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.lyn13.buku.CetakHapusActivity;
import com.lyn13.buku.EditActivity;
import com.lyn13.buku.R;
import com.lyn13.buku.crud.userCRUD;
import com.lyn13.buku.model.Buku;

import java.util.ArrayList;
import java.util.List;

public class UserAdapter extends ArrayAdapter<Buku> {
    private Activity mActivity;
    public UserAdapter(Context context, List<Buku> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Buku user = getItem(position);
        if(convertView==null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.layout_listviewbuku, parent, false);
        }

        TextView txvIdBuku = (TextView) convertView.findViewById(R.id.txvIdBuku);
        TextView txvJudul= (TextView) convertView.findViewById(R.id.txvJudul);
        TextView txvPengarang= (TextView) convertView.findViewById(R.id.txvPengarang);
        TextView txvPenerbit = (TextView) convertView.findViewById(R.id.txvPenerbit);
        TextView txvTahunTerbit= (TextView) convertView.findViewById(R.id.txvTahunTerbit);

        txvIdBuku.setText(user.getidbuku().toString());
        txvJudul.setText(user.getJudul());
        txvPengarang.setText(user.getPengarang());
        txvPenerbit.setText(user.getPenerbit());
        txvTahunTerbit.setText(user.getTahunTerbit().toString());

        ImageButton imgBtnEdit= (ImageButton) convertView.findViewById(R.id.imgBtnEdit);
        imgBtnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(getContext(), EditActivity.class);
                intent.putExtra("idbuku", user.getidbuku().toString());
                intent.putExtra("judul", user.getJudul());
                intent.putExtra("pengarang", user.getPengarang());
                intent.putExtra("penerbit", user.getPenerbit());
                intent.putExtra("tahunTerbit", user.getTahunTerbit().toString());
                getContext().startActivity(intent);
            }
        });

        ImageButton imgBtnDelete= (ImageButton) convertView.findViewById(R.id.imgBtnDelete);
        imgBtnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userCRUD usercrud = new userCRUD();
                usercrud.deleteDataUser(user.getidbuku());
                ((CetakHapusActivity) getmActivity()).refreshListview();

                notifyDataSetChanged();
            }
        });

        return convertView;

    }

    public Activity getmActivity() {
        return mActivity;
    }

    public void setmActivity(Activity mActivity) {
        this.mActivity = mActivity;
    }
}
